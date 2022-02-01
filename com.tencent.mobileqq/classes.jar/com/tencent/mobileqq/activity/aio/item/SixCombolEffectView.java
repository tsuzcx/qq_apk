package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class SixCombolEffectView
  extends View
  implements Handler.Callback
{
  public static boolean i = false;
  public static int j;
  private int A = 0;
  private int B = 0;
  private long C = 0L;
  private boolean D = false;
  private String E = "chat_item_for_qq666";
  private int F;
  private int G;
  private int H = ScreenUtil.dip2px(60.0F);
  private MessageForPoke I;
  private Context J;
  private ChatXListView K;
  private ChatAdapter1 L;
  Bitmap a;
  Bitmap b;
  Bitmap c;
  BitmapFactory.Options d = new BitmapFactory.Options();
  float e;
  float f;
  float g = ScreenUtil.dip2px(120.0F);
  float h = ScreenUtil.dip2px(120.0F);
  float k;
  float l = ScreenUtil.dip2px(100.0F);
  int m = ScreenUtil.dip2px(30.0F);
  int n = ScreenUtil.dip2px(30.0F);
  int o = ScreenUtil.dip2px(13.0F);
  int p = ScreenUtil.dip2px(50.0F);
  private SixCombolEffectView.ISixAnimationListener q;
  private ValueAnimator r;
  private ValueAnimator s;
  private ValueAnimator t;
  private boolean u;
  private boolean v = false;
  private Handler w;
  private Matrix x = null;
  private ArrayList<SixCombolEffectView.OneHeartTracker> y;
  private SixCombolEffectView.OneHeartTracker z;
  
  public SixCombolEffectView(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public SixCombolEffectView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  @TargetApi(11)
  private SixCombolEffectView.OneHeartTracker a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    SixCombolEffectView.OneHeartTracker localOneHeartTracker = new SixCombolEffectView.OneHeartTracker(this);
    localOneHeartTracker.a = paramInt1;
    localOneHeartTracker.b = false;
    localOneHeartTracker.c = paramInt2;
    localOneHeartTracker.e = paramInt3;
    localOneHeartTracker.g = paramInt4;
    localOneHeartTracker.j = paramInt5;
    localOneHeartTracker.o = false;
    localOneHeartTracker.p = new SixCombolEffectView.BezierEvaluator(this);
    localOneHeartTracker.k = ValueAnimator.ofFloat(new float[] { 0.2F, this.k - 0.15F });
    ValueAnimator localValueAnimator = localOneHeartTracker.k;
    double d1 = paramInt5;
    Double.isNaN(d1);
    localValueAnimator.setDuration((int)(d1 * 1.2D));
    localOneHeartTracker.k.addListener(new SixCombolEffectView.9(this, localOneHeartTracker));
    localOneHeartTracker.k.addUpdateListener(new SixCombolEffectView.10(this, localOneHeartTracker));
    float f1 = this.k;
    localOneHeartTracker.l = ValueAnimator.ofFloat(new float[] { f1 - 0.15F, f1 });
    localOneHeartTracker.l.setDuration(paramInt6);
    localOneHeartTracker.l.addUpdateListener(new SixCombolEffectView.11(this, localOneHeartTracker));
    localOneHeartTracker.m = ValueAnimator.ofFloat(new float[] { 0.0F, 2.5F });
    localValueAnimator = localOneHeartTracker.m;
    paramInt1 = paramInt6 - paramInt5;
    d1 = paramInt1;
    Double.isNaN(d1);
    localValueAnimator.setDuration((d1 * 2.1D));
    localOneHeartTracker.m.setInterpolator(new DecelerateInterpolator());
    localOneHeartTracker.m.addListener(new SixCombolEffectView.12(this));
    localOneHeartTracker.m.addUpdateListener(new SixCombolEffectView.13(this, localOneHeartTracker));
    localOneHeartTracker.n = ValueAnimator.ofFloat(new float[] { 1.0F, 2.2F });
    localOneHeartTracker.n.setDuration(paramInt1);
    localOneHeartTracker.n.setInterpolator(new LinearInterpolator());
    localOneHeartTracker.n.addUpdateListener(new SixCombolEffectView.14(this, localOneHeartTracker));
    return localOneHeartTracker;
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f1 = this.h / paramBitmap.getHeight();
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate(paramFloat1, paramFloat2);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramCanvas.save();
    Matrix localMatrix = new Matrix();
    float f1 = this.h / paramBitmap.getHeight();
    localMatrix.postScale(f1, f1);
    localMatrix.postTranslate(-this.g / 2.0F, -this.h / 2.0F);
    localMatrix.postRotate(paramFloat1);
    localMatrix.postTranslate(paramFloat2, paramFloat3);
    paramCanvas.drawBitmap(paramBitmap, localMatrix, paramPaint);
    paramCanvas.restore();
  }
  
  private void a(SixCombolEffectView.OneHeartTracker paramOneHeartTracker, int paramInt1, int paramInt2, int paramInt3)
  {
    paramOneHeartTracker.d = paramInt1;
    paramOneHeartTracker.f = paramInt2;
    paramOneHeartTracker.o = false;
    SixCombolEffectView.BezierEvaluator localBezierEvaluator = paramOneHeartTracker.p;
    PointF localPointF = new PointF(paramInt1, paramOneHeartTracker.e);
    float f1 = paramInt2;
    localBezierEvaluator.a(new PointF[] { localPointF, new PointF(f1, paramOneHeartTracker.e - paramInt3), new PointF(f1, paramOneHeartTracker.g) });
  }
  
  private void b(Context paramContext)
  {
    this.J = paramContext;
    paramContext = this.J;
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = ((BaseActivity)paramContext).getChatFragment().k();
      this.K = paramContext.U;
      this.L = paramContext.V;
    }
    setOnTouchListener(new SixCombolEffectView.1(this));
    paramContext = this.d;
    paramContext.inSampleSize = 1;
    paramContext.inMutable = true;
    if (PokeBigResHandler.e)
    {
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(PokeBigResHandler.b);
        paramContext.append("/666_caidan/666send_caidan_hand.png");
        this.a = ImageUtil.a(paramContext.toString(), this.d);
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Six Hand", 2, paramContext.toString());
        }
        this.a = null;
      }
      try
      {
        paramContext = new StringBuilder();
        paramContext.append(PokeBigResHandler.b);
        paramContext.append("/666_caidan/666send_caidan_hand6.png");
        this.c = ImageUtil.a(paramContext.toString(), this.d);
      }
      catch (OutOfMemoryError paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Six Six", 2, paramContext.toString());
        }
        this.c = null;
      }
      this.b = a(this.a);
    }
    this.r = ValueAnimator.ofFloat(new float[] { -0.2F, 1.0F });
    this.r.setDuration(300L);
    this.r.addUpdateListener(new SixCombolEffectView.2(this));
    this.r.addListener(new SixCombolEffectView.3(this));
    this.t = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 0.0F }).setDuration(300L);
    this.t.setInterpolator(new DecelerateInterpolator());
    this.t.setRepeatCount(7);
    this.t.addUpdateListener(new SixCombolEffectView.4(this));
    this.t.addListener(new SixCombolEffectView.5(this));
    this.s = ValueAnimator.ofFloat(new float[] { 1.0F, -0.2F });
    this.s.setDuration(300L);
    this.s.addUpdateListener(new SixCombolEffectView.6(this));
    this.s.addListener(new SixCombolEffectView.7(this));
    a(getContext());
  }
  
  private void d()
  {
    this.v = true;
    this.w.removeMessages(2);
    this.t.end();
    this.r.end();
    this.s.end();
    this.v = false;
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      SixCombolEffectView.OneHeartTracker localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
      localOneHeartTracker.n.end();
      localOneHeartTracker.k.end();
      localOneHeartTracker.m.end();
      localOneHeartTracker.l.end();
      localOneHeartTracker.h = 0.0F;
      localOneHeartTracker.i = 0.0F;
      localOneHeartTracker.b = false;
    }
    if (this.D) {
      HapticManager.b().d(this.F);
    }
    this.F = 0;
  }
  
  private GivingHeartItemBuilder.Holder getCurrent()
  {
    ChatXListView localChatXListView = this.K;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localChatXListView != null)
    {
      localObject1 = localObject2;
      if (this.L != null)
      {
        int i1 = AIOUtils.a(this.I.uniseq, this.L);
        localObject1 = AIOUtils.a(this.K, i1 + 1);
        if (localObject1 == null) {
          return null;
        }
        localObject1 = (GivingHeartItemBuilder.Holder)AIOUtils.b((View)localObject1);
      }
    }
    return localObject1;
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
  
  public void a()
  {
    int i1;
    SixCombolEffectView.OneHeartTracker localOneHeartTracker;
    if (this.u)
    {
      i1 = (int)(this.A - ScreenUtil.dip2px(50.0F) - this.g / 2.0F);
      localIterator = this.y.iterator();
      while (localIterator.hasNext())
      {
        localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
        if (localOneHeartTracker.a == 0) {
          a(localOneHeartTracker, i1, i1 / 3 * 2, 0);
        } else if (localOneHeartTracker.a == 1) {
          a(localOneHeartTracker, i1, i1 / 3, 0);
        } else {
          a(localOneHeartTracker, i1, ScreenUtil.dip2px(10.0F), 50);
        }
      }
    }
    Iterator localIterator = this.y.iterator();
    while (localIterator.hasNext())
    {
      localOneHeartTracker = (SixCombolEffectView.OneHeartTracker)localIterator.next();
      i1 = (int)(ScreenUtil.dip2px(50.0F) + this.g / 2.0F);
      int i2 = (int)(this.A - ScreenUtil.dip2px(50.0F) - this.g / 2.0F);
      if (localOneHeartTracker.a == 0) {
        a(localOneHeartTracker, i1, i1, 0);
      } else if (localOneHeartTracker.a == 1) {
        a(localOneHeartTracker, i1, i2 / 3 + i1, 0);
      } else {
        a(localOneHeartTracker, i1, (int)(this.A - this.l - ScreenUtil.dip2px(10.0F)), 50);
      }
    }
    this.w.sendEmptyMessage(1);
  }
  
  void a(Context paramContext)
  {
    this.w = new Handler(Looper.getMainLooper(), this);
    this.x = new Matrix();
    int i2 = UIUtils.b(paramContext);
    int i1 = getResources().getDisplayMetrics().heightPixels;
    this.A = i2;
    this.B = i1;
    this.k = (this.l / this.c.getWidth());
    this.y = new ArrayList();
    paramContext = this.y;
    i2 = ScreenUtil.dip2px(70.0F);
    int i3 = (int)(i1 * 0.6F);
    paramContext.add(a(0, 800, i1 - i2, i3, 700, 2000));
    this.y.add(a(0, 1600, i1 - ScreenUtil.dip2px(70.0F), i3, 600, 1400));
    this.y.add(a(0, 1800, i1 - ScreenUtil.dip2px(70.0F), i3, 600, 1800));
    this.y.add(a(1, 0, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1500));
    this.y.add(a(1, 600, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1400));
    this.y.add(a(1, 1200, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1500));
    this.y.add(a(1, 2000, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1800));
    this.y.add(a(2, 300, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1500));
    this.y.add(a(2, 1000, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1500));
    this.y.add(a(2, 1400, i1 - ScreenUtil.dip2px(70.0F), i3, 500, 1900));
    this.z = ((SixCombolEffectView.OneHeartTracker)this.y.get(6));
    this.z.m.addListener(new SixCombolEffectView.8(this));
  }
  
  public void a(GivingHeartItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    if (i) {
      return;
    }
    this.D = paramBoolean;
    d();
    this.I = ((MessageForPoke)paramHolder.q);
    this.I.mFrameState.d = true;
    this.u = this.I.isSend();
    i = true;
    this.w.sendEmptyMessage(3);
    if (this.D) {
      this.F = HapticManager.b().a(this.E, 2);
    }
  }
  
  public void b()
  {
    setVisibility(8);
    Object localObject = getCurrent();
    SixCombolEffectView.ISixAnimationListener localISixAnimationListener = this.q;
    if ((localISixAnimationListener != null) && (localObject != null))
    {
      localISixAnimationListener.a((GivingHeartItemBuilder.Holder)localObject);
      this.q = null;
    }
    localObject = this.I;
    if (localObject != null) {
      ((MessageForPoke)localObject).mFrameState.d = false;
    }
    i = false;
    j = 0;
    d();
  }
  
  public void c()
  {
    this.J = null;
    this.K = null;
    this.L = null;
    b();
  }
  
  public MessageForPoke getMessage()
  {
    return this.I;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return false;
        }
        setVisibility(0);
        requestLayout();
        j = 0;
        this.r.start();
        return false;
      }
      this.w.removeMessages(2);
      long l1 = AnimationUtils.currentAnimationTimeMillis();
      long l2 = this.C;
      i1 = 0;
      while (i1 < this.y.size())
      {
        paramMessage = (SixCombolEffectView.OneHeartTracker)this.y.get(i1);
        if ((l1 - l2 >= paramMessage.c) && (!paramMessage.b))
        {
          paramMessage.b = true;
          paramMessage.k.start();
          paramMessage.m.start();
        }
        i1 += 1;
      }
      if (!this.z.b)
      {
        paramMessage = this.w.obtainMessage();
        paramMessage.what = 2;
        this.w.sendMessageDelayed(paramMessage, 25L);
        return false;
      }
    }
    else
    {
      this.C = AnimationUtils.currentAnimationTimeMillis();
      paramMessage = this.y.iterator();
      while (paramMessage.hasNext()) {
        ((SixCombolEffectView.OneHeartTracker)paramMessage.next()).b = false;
      }
      this.w.sendEmptyMessage(2);
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.I == null) {
      return;
    }
    Object localObject1 = getCurrent();
    if (localObject1 == null)
    {
      b();
      return;
    }
    Object localObject2 = new int[2];
    ((GivingHeartItemBuilder.Holder)localObject1).s.getLocationOnScreen((int[])localObject2);
    int i1 = localObject2[0];
    this.G = ((int)(localObject2[1] + this.h - this.p));
    if (this.c != null)
    {
      if (this.a == null) {
        return;
      }
      localObject1 = this.y.iterator();
      float f1;
      double d1;
      double d2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SixCombolEffectView.OneHeartTracker)((Iterator)localObject1).next();
        if (((SixCombolEffectView.OneHeartTracker)localObject2).b)
        {
          this.x.reset();
          PointF localPointF;
          if (((SixCombolEffectView.OneHeartTracker)localObject2).i <= 1.0F)
          {
            localPointF = ((SixCombolEffectView.OneHeartTracker)localObject2).p.a(((SixCombolEffectView.OneHeartTracker)localObject2).i, null, null);
            this.x.postTranslate(localPointF.x, localPointF.y - (this.B - this.G) + this.o);
          }
          else
          {
            f1 = ((SixCombolEffectView.OneHeartTracker)localObject2).i;
            d1 = this.B;
            Double.isNaN(d1);
            d2 = 1.0F - (f1 - 1.0F);
            Double.isNaN(d2);
            i1 = (int)(d1 * 0.6D * d2);
            localPointF = ((SixCombolEffectView.OneHeartTracker)localObject2).p.a(((SixCombolEffectView.OneHeartTracker)localObject2).i, null, null);
            this.x.postTranslate(localPointF.x, i1 - (this.B - this.G) + this.o);
          }
          this.x.preScale(((SixCombolEffectView.OneHeartTracker)localObject2).h, ((SixCombolEffectView.OneHeartTracker)localObject2).h);
          paramCanvas.drawBitmap(this.c, this.x, null);
        }
      }
      if (this.z.b)
      {
        if (this.z.i <= 1.0F)
        {
          i1 = (int)(this.z.p.a(this.z.i, null, null).y - (this.B - this.G) + this.o);
        }
        else
        {
          f1 = this.z.i;
          i1 = this.B;
          d1 = i1;
          Double.isNaN(d1);
          d2 = 1.0F - (f1 - 1.0F);
          Double.isNaN(d2);
          i1 = (int)(d1 * 0.6D * d2) - (i1 - this.G) + this.o;
        }
        if (i1 + this.c.getHeight() * this.z.h < 0.0F) {
          b();
        }
      }
      i1 = j;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return;
          }
          if (this.u)
          {
            localObject1 = this.a;
            f1 = this.e;
            f2 = getWidth();
            f3 = this.g / 2.0F;
            float f4 = this.H;
            i1 = this.o;
            a(paramCanvas, null, (Bitmap)localObject1, 90.0F - f1 * 90.0F, f2 - f3 - f4 - i1, this.G - this.h / 2.0F + i1);
            return;
          }
          localObject1 = this.b;
          f1 = this.e;
          float f2 = this.g / 2.0F;
          float f3 = this.H;
          i1 = this.o;
          a(paramCanvas, null, (Bitmap)localObject1, f1 * 90.0F - 90.0F, f2 + f3 + i1, this.G - this.h / 2.0F + i1);
          return;
        }
        if (this.u)
        {
          a(paramCanvas, null, this.a, getWidth() - this.g + (this.f - 0.5F) * 100.0F - this.H, this.G - this.h);
          return;
        }
        a(paramCanvas, null, this.b, -(this.f - 0.5F) * 100.0F + this.H, this.G - this.h);
        return;
      }
      if (this.u)
      {
        a(paramCanvas, null, this.a, 90.0F - this.e * 90.0F, getWidth() - this.g / 2.0F - this.H, this.G - this.h / 2.0F);
        return;
      }
      a(paramCanvas, null, this.b, this.e * 90.0F - 90.0F, this.g / 2.0F + this.H, this.G - this.h / 2.0F);
    }
  }
  
  public void setListener(SixCombolEffectView.ISixAnimationListener paramISixAnimationListener)
  {
    this.q = paramISixAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.SixCombolEffectView
 * JD-Core Version:    0.7.0.1
 */