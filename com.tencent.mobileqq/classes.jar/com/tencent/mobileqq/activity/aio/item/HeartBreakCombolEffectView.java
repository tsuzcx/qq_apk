package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.utils.ImageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class HeartBreakCombolEffectView
  extends View
  implements Runnable
{
  static boolean h = false;
  Handler a;
  Handler b;
  HeartBreakCombolEffectView.DecodeRunnable c;
  Bitmap d;
  Paint e = new Paint(6);
  int f = 0;
  int g = 0;
  ArrayList<HeartBreakCombolEffectView.OneFrame> i = new ArrayList();
  public ArrayList<Bitmap> j = new ArrayList();
  private Vector<Bitmap> k = new Vector();
  
  public HeartBreakCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HeartBreakCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d();
  }
  
  private void d()
  {
    setOnTouchListener(new HeartBreakCombolEffectView.1(this));
    this.a = new Handler(Looper.getMainLooper());
    e();
    HandlerThread localHandlerThread = new HandlerThread("decode");
    localHandlerThread.start();
    this.b = new Handler(localHandlerThread.getLooper());
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PokeBigResHandler.b);
    ((StringBuilder)localObject).append("/xinsui_caidan/xinsui_caidan_");
    localObject = ((StringBuilder)localObject).toString();
    int m = 0;
    while (m < 55)
    {
      m += 1;
      StringBuilder localStringBuilder;
      if (m < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localStringBuilder.append(m);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(m);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
    }
  }
  
  public void a()
  {
    if (h == true) {
      return;
    }
    setVisibility(0);
    this.a.removeCallbacks(this);
    this.a.post(this);
    this.d = ImageUtil.a(((HeartBreakCombolEffectView.OneFrame)this.i.get(this.f)).a, null);
    h = true;
  }
  
  public void a(String paramString, int paramInt)
  {
    HeartBreakCombolEffectView.OneFrame localOneFrame = new HeartBreakCombolEffectView.OneFrame(this);
    localOneFrame.a = paramString;
    localOneFrame.b = paramInt;
    this.i.add(localOneFrame);
  }
  
  public void b()
  {
    this.f = 0;
    this.g = 0;
    h = false;
    this.a.removeCallbacks(this);
    this.b.post(this.c);
    this.c = null;
    setVisibility(8);
  }
  
  public void c()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.j.size() > 0)
    {
      localObject = this.j.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.j.clear();
    }
    if (this.k.size() > 0)
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.k.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Object localObject = this.d;
    if (localObject != null)
    {
      int m = ((Bitmap)localObject).getWidth();
      int n = this.d.getHeight();
      int i1 = getWidth();
      int i2 = getHeight();
      float f2 = i1 * 1.0F / m;
      float f1 = i2 / 2;
      f2 = n * f2;
      paramCanvas.translate(0.0F, (int)(f1 - f2 / 2.0F) + 50);
      localObject = new Rect(0, 0, m, n);
      Rect localRect = new Rect(0, 0, i1, (int)f2);
      paramCanvas.drawBitmap(this.d, (Rect)localObject, localRect, this.e);
    }
  }
  
  public Bitmap getCacheBitmap()
  {
    ArrayList localArrayList = this.j;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0) {
        localObject1 = (Bitmap)this.j.remove(0);
      }
    }
    return localObject1;
  }
  
  public void run()
  {
    int m = this.f + 1;
    if (m < 55)
    {
      if (this.c == null) {
        this.c = new HeartBreakCombolEffectView.DecodeRunnable(this, this.j);
      }
      HeartBreakCombolEffectView.OneFrame localOneFrame = (HeartBreakCombolEffectView.OneFrame)this.i.get(m);
      this.b.removeCallbacks(this.c);
      this.b.post(this.c);
      this.f += 1;
      Bitmap localBitmap = this.d;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        localBitmap = this.d;
        if (this.k.size() <= 2) {
          this.k.add(localBitmap);
        } else {
          localBitmap.recycle();
        }
      }
      this.d = getCacheBitmap();
      invalidate();
      this.a.postDelayed(this, localOneFrame.b);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartBreakCombolEffectView
 * JD-Core Version:    0.7.0.1
 */