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
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class GreatMoveCombolEffectView
  extends View
  implements Runnable
{
  public static boolean h = false;
  Handler a;
  Handler b;
  GreatMoveCombolEffectView.DecodeRunnable c;
  Bitmap d;
  Paint e = new Paint(6);
  int f = 0;
  int g = 0;
  boolean i = false;
  GreatMoveCombolEffectView.GreateMoveListener j;
  ArrayList<GreatMoveCombolEffectView.OneFrame> k = new ArrayList();
  public ArrayList<Bitmap> l = new ArrayList();
  private Context m;
  private ChatXListView n;
  private ChatAdapter1 o;
  private Vector<Bitmap> p = new Vector();
  private MessageForPoke q;
  
  public GreatMoveCombolEffectView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GreatMoveCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.m = paramContext;
    paramContext = this.m;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment().k();
      this.n = paramContext.U;
      this.o = paramContext.V;
    }
    setOnTouchListener(new GreatMoveCombolEffectView.1(this));
    this.a = new Handler(Looper.getMainLooper());
    d();
    paramContext = new HandlerThread("decode");
    paramContext.start();
    this.b = new Handler(paramContext.getLooper());
  }
  
  private void d()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(PokeBigResHandler.b);
    ((StringBuilder)localObject).append("/dazhao_caidan/dazhao_caidan_");
    localObject = ((StringBuilder)localObject).toString();
    int i1 = 0;
    while (i1 < 37)
    {
      i1 += 1;
      StringBuilder localStringBuilder;
      if (i1 < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("0");
        localStringBuilder.append(i1);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(i1);
        localStringBuilder.append(".png");
        a(localStringBuilder.toString(), 30);
      }
    }
  }
  
  private GivingHeartItemBuilder.Holder getCurrent()
  {
    ChatXListView localChatXListView = this.n;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localChatXListView != null)
    {
      localObject1 = localObject2;
      if (this.o != null)
      {
        int i1 = AIOUtils.a(this.q.uniseq, this.o);
        localObject1 = AIOUtils.a(this.n, i1 + 1);
        if (localObject1 == null) {
          return null;
        }
        localObject1 = (GivingHeartItemBuilder.Holder)AIOUtils.b((View)localObject1);
      }
    }
    return localObject1;
  }
  
  private void setGreateMoveListener(GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    this.j = paramGreateMoveListener;
  }
  
  public void a()
  {
    this.f = 0;
    this.g = 0;
    h = false;
    this.a.removeCallbacks(this);
    this.b.post(this.c);
    this.c = null;
    setVisibility(8);
    GreatMoveCombolEffectView.GreateMoveListener localGreateMoveListener = this.j;
    if (localGreateMoveListener != null)
    {
      localGreateMoveListener.a();
      this.j = null;
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    if ((h) && (paramMessageForPoke != this.q)) {
      return;
    }
    this.f = 0;
    this.a.removeCallbacks(this);
    this.a.post(this);
    paramMessageForPoke = (GreatMoveCombolEffectView.OneFrame)this.k.get(this.f);
    try
    {
      this.d = ImageUtil.a(paramMessageForPoke.a, null);
      return;
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
      }
      this.d = null;
    }
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, GreatMoveCombolEffectView.GreateMoveListener paramGreateMoveListener)
  {
    if (h)
    {
      paramGreateMoveListener.a();
      return;
    }
    setGreateMoveListener(paramGreateMoveListener);
    setVisibility(0);
    this.q = paramMessageForPoke;
    this.i = paramBoolean;
    this.a.removeCallbacks(this);
    this.a.post(this);
    paramMessageForPoke = (GreatMoveCombolEffectView.OneFrame)this.k.get(this.f);
    try
    {
      this.d = ImageUtil.a(paramMessageForPoke.a, null);
    }
    catch (OutOfMemoryError paramMessageForPoke)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GreatMoveCombolEffectView", 2, paramMessageForPoke.toString());
      }
      this.d = null;
    }
    h = true;
  }
  
  public void a(String paramString, int paramInt)
  {
    GreatMoveCombolEffectView.OneFrame localOneFrame = new GreatMoveCombolEffectView.OneFrame(this);
    localOneFrame.a = paramString;
    localOneFrame.b = paramInt;
    this.k.add(localOneFrame);
  }
  
  public void b()
  {
    this.m = null;
    this.n = null;
    this.o = null;
    a();
  }
  
  public void c()
  {
    Object localObject = this.d;
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.d.recycle();
      this.d = null;
    }
    if (this.l.size() > 0)
    {
      localObject = this.l.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.l.clear();
    }
    if (this.p.size() > 0)
    {
      localObject = this.p.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Bitmap)((Iterator)localObject).next()).recycle();
      }
      this.p.clear();
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.q == null) {
      return;
    }
    Object localObject1 = getCurrent();
    if (localObject1 == null)
    {
      a();
      return;
    }
    Object localObject2 = new int[2];
    ((GivingHeartItemBuilder.Holder)localObject1).s.getLocationOnScreen((int[])localObject2);
    int i1 = localObject2[1];
    int i2 = ((GivingHeartItemBuilder.Holder)localObject1).s.getLayoutParams().height / 2;
    super.draw(paramCanvas);
    localObject1 = this.d;
    if ((localObject1 != null) && (!((Bitmap)localObject1).isRecycled()))
    {
      int i3 = this.d.getWidth();
      int i4 = this.d.getHeight();
      int i5 = getWidth();
      int i6 = getHeight();
      if (this.i)
      {
        paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, i5 / 2, i6 / 2);
      }
      float f1 = i5 * 1.0F / i3;
      f1 = i4 * f1;
      paramCanvas.translate(0.0F, -((int)(f1 / 2.0F - (i1 + i2)) + 50));
      localObject1 = new Rect(0, 0, i3, i4);
      localObject2 = new Rect(0, 0, i5, (int)f1);
      paramCanvas.drawBitmap(this.d, (Rect)localObject1, (Rect)localObject2, this.e);
      if (this.i) {
        paramCanvas.restore();
      }
    }
  }
  
  public Bitmap getCacheBitmap()
  {
    ArrayList localArrayList = this.l;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localArrayList != null)
    {
      localObject1 = localObject2;
      if (localArrayList.size() > 0) {
        localObject1 = (Bitmap)this.l.remove(0);
      }
    }
    return localObject1;
  }
  
  public void run()
  {
    int i1 = this.f + 1;
    if ((i1 < 37) && (h))
    {
      if (this.c == null) {
        this.c = new GreatMoveCombolEffectView.DecodeRunnable(this, this.l);
      }
      GreatMoveCombolEffectView.OneFrame localOneFrame = (GreatMoveCombolEffectView.OneFrame)this.k.get(i1);
      this.b.removeCallbacks(this.c);
      this.b.post(this.c);
      this.f += 1;
      Bitmap localBitmap = this.d;
      if ((localBitmap != null) && (!localBitmap.isRecycled()))
      {
        localBitmap = this.d;
        if (this.p.size() <= 2) {
          this.p.add(localBitmap);
        } else {
          localBitmap.recycle();
        }
      }
      this.d = getCacheBitmap();
      invalidate();
      this.a.postDelayed(this, localOneFrame.b);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GreatMoveCombolEffectView
 * JD-Core Version:    0.7.0.1
 */