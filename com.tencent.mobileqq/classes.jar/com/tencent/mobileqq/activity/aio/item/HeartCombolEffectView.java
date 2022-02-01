package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class HeartCombolEffectView
  extends View
  implements Handler.Callback
{
  private Handler a;
  private ArrayList<HeartCombolEffectView.OneHeartTracker> b;
  private HeartCombolEffectView.OneHeartTracker c;
  private Bitmap d;
  private Bitmap e;
  private Matrix f = null;
  private long g = 0L;
  private int h = 0;
  private int i = 0;
  private String j = "chat_item_for_qqbixin_strong";
  private int k;
  private boolean l = false;
  private int m = 0;
  private int n = 0;
  private boolean o = true;
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public HeartCombolEffectView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.l = paramBoolean;
    a(paramContext);
  }
  
  @TargetApi(11)
  private HeartCombolEffectView.OneHeartTracker a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat, int paramInt6)
  {
    HeartCombolEffectView.OneHeartTracker localOneHeartTracker = new HeartCombolEffectView.OneHeartTracker(this);
    localOneHeartTracker.a = false;
    localOneHeartTracker.b = paramInt1;
    localOneHeartTracker.c = paramInt2;
    localOneHeartTracker.d = paramInt3;
    localOneHeartTracker.e = paramInt4;
    localOneHeartTracker.f = paramInt5;
    localOneHeartTracker.i = paramFloat;
    localOneHeartTracker.k = paramInt6;
    localOneHeartTracker.o = false;
    localOneHeartTracker.l = new Scroller(getContext(), new DecelerateInterpolator());
    localOneHeartTracker.l = new Scroller(getContext(), new DecelerateInterpolator());
    localOneHeartTracker.m = new Scroller(getContext(), new AccelerateInterpolator());
    localOneHeartTracker.n = ValueAnimator.ofFloat(new float[] { localOneHeartTracker.i, 0.0F });
    localOneHeartTracker.n.setDuration(1100 - localOneHeartTracker.k);
    localOneHeartTracker.n.addUpdateListener(new HeartCombolEffectView.3(this, localOneHeartTracker));
    return localOneHeartTracker;
  }
  
  public Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i1 = paramBitmap.getWidth();
      int i2 = paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(-1.0F, 1.0F);
      try
      {
        paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, i1, i2, localMatrix, true);
        return paramBitmap;
      }
      catch (OutOfMemoryError paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return null;
  }
  
  void a(Context paramContext)
  {
    setOnTouchListener(new HeartCombolEffectView.1(this));
    this.a = new Handler(Looper.getMainLooper(), this);
    this.d = ImageUtil.a(getResources(), 2130839248);
    paramContext = this.d;
    if (paramContext != null) {
      this.e = a(paramContext);
    }
    if (this.e == null) {
      this.e = this.d;
    }
    this.f = new Matrix();
    int i1 = getResources().getDisplayMetrics().widthPixels;
    int i2 = getResources().getDisplayMetrics().heightPixels - ImmersiveUtils.getStatusBarHeight(getContext()) * 2;
    this.b = new ArrayList();
    paramContext = this.b;
    int i3 = (int)(i1 * 1.2F);
    float f1 = i2;
    paramContext.add(a(300, i3, (int)(0.37F * f1), 0, (int)(0.15F * f1), 1.0F, 500));
    this.b.add(a(780, i3, (int)(0.42F * f1), 0, (int)(0.25F * f1), 0.95F, 500));
    paramContext = this.b;
    int i5 = (int)(0.46F * f1);
    double d1 = -i1;
    Double.isNaN(d1);
    int i4 = (int)(0.06D * d1);
    paramContext.add(a(180, i3, i5, i4, (int)(0.27F * f1), 1.42F, 500));
    this.b.add(a(450, i3, (int)(0.51F * f1), 0, (int)(0.45F * f1), 0.92F, 500));
    paramContext = this.b;
    i5 = (int)(0.56F * f1);
    Double.isNaN(d1);
    paramContext.add(a(0, i3, i5, (int)(0.1D * d1), (int)(0.6F * f1), 0.55F, 500));
    paramContext = this.b;
    i5 = (int)(0.63F * f1);
    Double.isNaN(d1);
    paramContext.add(a(620, i3, i5, (int)(d1 * 0.04D), (int)(0.75F * f1), 1.3F, 500));
    this.b.add(a(410, i3, (int)(0.71F * f1), i4, (int)(f1 * 0.89F), 0.88F, 500));
    this.c = ((HeartCombolEffectView.OneHeartTracker)this.b.get(1));
    this.c.n.addListener(new HeartCombolEffectView.2(this));
    this.h = i1;
    this.i = i2;
  }
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
    setVisibility(0);
    this.a.sendEmptyMessage(1);
    if (this.l) {
      ThreadManager.postImmediately(new HeartCombolEffectView.4(this), null, true);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      this.a.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.g;
      i1 = 0;
      while (i1 < this.b.size())
      {
        paramMessage = (HeartCombolEffectView.OneHeartTracker)this.b.get(i1);
        if (l1 - l2 >= paramMessage.b)
        {
          if (!paramMessage.a)
          {
            int i3;
            if (this.o)
            {
              i2 = paramMessage.c;
              i3 = paramMessage.e;
            }
            else
            {
              i2 = this.h - paramMessage.c;
              i3 = this.h - paramMessage.e;
            }
            paramMessage.l.startScroll(i2, 0, i3 - i2, 0, 1100);
            paramMessage.m.startScroll(0, paramMessage.d, 0, paramMessage.f - paramMessage.d, 1100);
            paramMessage.a = true;
          }
          if (paramMessage.l.computeScrollOffset())
          {
            paramMessage.m.computeScrollOffset();
            if ((paramMessage.l.timePassed() > paramMessage.k) && (paramMessage.j == paramMessage.i)) {
              paramMessage.n.start();
            }
            paramMessage.g = paramMessage.l.getCurrX();
            paramMessage.h = paramMessage.m.getCurrY();
          }
        }
        i1 += 1;
      }
      i1 = this.h;
      int i2 = this.c.e;
      float f1 = ((Float)this.c.n.getAnimatedValue()).floatValue();
      if ((this.c.a) && ((!this.o) || (this.c.g <= this.c.e)) && ((this.o) || (this.c.g >= i1 - i2)) && ((!this.c.o) || (f1 <= 0.001D)))
      {
        if (this.l) {
          HapticManager.b().d(this.k);
        }
        this.k = 0;
        return false;
      }
      postInvalidate();
      paramMessage = this.a.obtainMessage();
      paramMessage.what = 2;
      this.a.sendMessageDelayed(paramMessage, 25L);
      return false;
    }
    this.g = AnimationUtils.currentAnimationTimeMillis();
    paramMessage = this.b.iterator();
    while (paramMessage.hasNext())
    {
      HeartCombolEffectView.OneHeartTracker localOneHeartTracker = (HeartCombolEffectView.OneHeartTracker)paramMessage.next();
      localOneHeartTracker.a = false;
      localOneHeartTracker.l.abortAnimation();
      localOneHeartTracker.m.abortAnimation();
      localOneHeartTracker.g = localOneHeartTracker.c;
      localOneHeartTracker.h = localOneHeartTracker.d;
      localOneHeartTracker.j = localOneHeartTracker.i;
    }
    if (this.l) {
      this.k = HapticManager.b().a(this.j, 2);
    }
    this.a.sendEmptyMessage(2);
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.o) && (this.d == null)) {
      return;
    }
    if ((!this.o) && (this.e == null)) {
      return;
    }
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      HeartCombolEffectView.OneHeartTracker localOneHeartTracker = (HeartCombolEffectView.OneHeartTracker)localIterator.next();
      if (localOneHeartTracker.a)
      {
        this.f.reset();
        this.m = ((int)(this.d.getWidth() * localOneHeartTracker.j / 2.0F));
        this.n = ((int)(this.d.getHeight() * localOneHeartTracker.j / 2.0F));
        this.f.postTranslate(localOneHeartTracker.g, localOneHeartTracker.h);
        this.f.preScale(localOneHeartTracker.j, localOneHeartTracker.j);
        if (this.o) {
          paramCanvas.drawBitmap(this.d, this.f, null);
        } else {
          paramCanvas.drawBitmap(this.e, this.f, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.HeartCombolEffectView
 * JD-Core Version:    0.7.0.1
 */