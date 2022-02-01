package com.tencent.aelight.camera.ae.gif.giftext.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GifAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static Set<SoftReference<Bitmap>> q = Collections.synchronizedSet(new HashSet());
  protected Context a;
  protected volatile boolean b;
  protected boolean c;
  protected boolean d;
  protected boolean e;
  private final String f;
  private int g;
  private GifAnimationDrawable.Frame h;
  private ArrayList<String> i;
  private boolean j;
  private long k;
  private GifAnimationDrawable.InvalidationHandler l;
  private ArrayList<GifAnimationDrawable.AnimationCallback> m;
  private Set<SoftReference<Bitmap>> n;
  private long o;
  private Paint p;
  
  public GifAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FastAnimationDrawable@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    this.f = localStringBuilder.toString();
    this.g = -1;
    this.d = false;
    this.j = false;
    this.k = 34L;
    this.m = new ArrayList();
    this.p = new Paint(1);
    this.a = paramContext;
    this.b = false;
    this.l = new GifAnimationDrawable.InvalidationHandler(this);
    this.k = paramLong;
    this.n = q;
    this.i = paramArrayList;
  }
  
  private void a(GifAnimationDrawable.Frame paramFrame)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("frameReady() called next=");
      localStringBuilder.append(paramFrame);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.e = false;
    if (this.h != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("android.resource://main_tab_animation_");
      ((StringBuilder)localObject).append((String)this.i.get(this.h.a));
      if (CommonImageCacheHelper.a(((StringBuilder)localObject).toString()) == null) {
        this.n.add(new SoftReference(this.h.c.getBitmap()));
      }
    }
    this.h = paramFrame;
    if (!isRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.f, 2, "frameReady() isRunning = false");
      }
      return;
    }
    invalidateSelf();
    b(paramFrame);
    if ((this.g == this.i.size() - 1) && (this.d))
    {
      this.l.postDelayed(new GifAnimationDrawable.1(this), this.k);
      return;
    }
    a();
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.f, 2, "reset");
    }
    this.b = true;
  }
  
  private void b(GifAnimationDrawable.Frame paramFrame)
  {
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).a(paramFrame.a);
    }
  }
  
  private void c()
  {
    Log.i(this.f, "dispatchAnimationStart: ");
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).a(this);
    }
  }
  
  private void d()
  {
    Log.i(this.f, "dispatchAnimationEnd: ");
    Iterator localIterator = this.m.iterator();
    while (localIterator.hasNext()) {
      ((GifAnimationDrawable.AnimationCallback)localIterator.next()).b(this);
    }
  }
  
  protected void a()
  {
    if (isRunning())
    {
      if (this.e) {
        return;
      }
      this.e = true;
      this.g += 1;
      this.g %= this.i.size();
      long l2 = SystemClock.uptimeMillis();
      long l1 = l2;
      if (!this.c) {
        l1 = l2 + this.k;
      }
      ThreadManagerV2.postImmediately(new GifAnimationDrawable.Decoder(this, new GifAnimationDrawable.Frame(this.g, l1, null)), null, false);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = this.o;
    l1 -= l2;
    if (l2 == 0L) {
      l1 = 0L;
    }
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = this.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("draw() called diff=[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("]");
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if (this.h != null)
    {
      if (this.c)
      {
        this.c = false;
        c();
      }
      this.h.c.setBounds(getBounds());
      if (QLog.isColorLevel())
      {
        localObject1 = this.h.c.getBitmap();
        if (localObject1 != null)
        {
          localObject2 = this.f;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("draw() called with: w=");
          localStringBuilder.append(((Bitmap)localObject1).getWidth());
          localStringBuilder.append(", h=");
          localStringBuilder.append(((Bitmap)localObject1).getHeight());
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        else
        {
          QLog.e(this.f, 2, "draw() called with: null bitmap");
        }
      }
      this.h.c.setFilterBitmap(true);
      this.h.c.draw(paramCanvas);
      this.p.setColor(-16711936);
      this.p.setStyle(Paint.Style.STROKE);
      this.p.setStrokeWidth(1.0F);
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.f, 2, "draw() called null bitmap");
    }
    this.o = SystemClock.uptimeMillis();
  }
  
  public int getIntrinsicHeight()
  {
    return getBounds().height();
  }
  
  public int getIntrinsicWidth()
  {
    return getBounds().width();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.b;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      String str = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setVisible changed:");
      localStringBuilder.append(bool);
      localStringBuilder.append(" visible:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" restart:");
      localStringBuilder.append(paramBoolean2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean1)
    {
      if (bool)
      {
        start();
        if (paramBoolean2)
        {
          b();
          return bool;
        }
        start();
        return bool;
      }
    }
    else if (bool) {
      stop();
    }
    return bool;
  }
  
  public void start()
  {
    if (!this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.f, 2, "start");
      }
      this.b = true;
      this.c = true;
      a();
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.f, 2, "stop() called");
    }
    if (isRunning()) {
      this.b = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.view.GifAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */