package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.immersion.stickersampleapp.HapticManager;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PokeBigResHandler;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FitSystemWindowsRelativeLayout;
import mqq.util.WeakReference;

public class UnlimitedBladeWorks
  extends RelativeLayout
  implements GreatMoveCombolEffectView.GreateMoveListener
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private CustomFrameAnimationDrawable d;
  private CustomFrameAnimationDrawable e;
  private ValueAnimator f;
  private boolean g = false;
  private Bitmap h = null;
  private Drawable i = null;
  private UnlimitedBladeWorks.UnlimitedState j;
  private boolean k = false;
  private float l;
  private WeakReference<Context> m;
  private UnlimitedBladeWorks.BallAnimationListener n;
  private String o = "chat_item_for_qqultnew";
  private int p;
  private MessageForPoke q;
  private boolean r = false;
  private UnlimitedBladeWorks.UnlimitedEndListener s = null;
  
  public UnlimitedBladeWorks(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public UnlimitedBladeWorks(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131629618, this, true);
  }
  
  @TargetApi(17)
  private void a(int paramInt)
  {
    Object localObject = this.m;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (Activity)this.m.get();
      ((Activity)localObject).runOnUiThread(new UnlimitedBladeWorks.6(this, (Activity)localObject, paramInt));
    }
  }
  
  private AnimationSet b(int paramInt)
  {
    int i1 = 0;
    AnimationSet localAnimationSet = new AnimationSet(false);
    int[] arrayOfInt = new int[8];
    int[] tmp20_18 = arrayOfInt;
    tmp20_18[0] = 80;
    int[] tmp25_20 = tmp20_18;
    tmp25_20[1] = 120;
    int[] tmp30_25 = tmp25_20;
    tmp30_25[2] = 120;
    int[] tmp35_30 = tmp30_25;
    tmp35_30[3] = 120;
    int[] tmp40_35 = tmp35_30;
    tmp40_35[4] = 120;
    int[] tmp45_40 = tmp40_35;
    tmp45_40[5] = 80;
    int[] tmp50_45 = tmp45_40;
    tmp50_45[6] = 80;
    int[] tmp56_50 = tmp50_45;
    tmp56_50[7] = 80;
    tmp56_50;
    int i2 = paramInt * 0;
    int i3 = paramInt * 1;
    int i4 = arrayOfInt.length;
    long l1 = 0L;
    while (i1 < i4)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, AIOUtils.b(new int[] { paramInt * 5, paramInt * -12, paramInt * 15, paramInt * -15, paramInt * 12, paramInt * -8, paramInt * 6, i2 }[i1], getResources()), 0.0F, AIOUtils.b(new int[] { i3, paramInt * -3, paramInt * 2, paramInt * -2, i3, paramInt * -1, i3, i2 }[i1], getResources()));
      localTranslateAnimation.setDuration(arrayOfInt[i1]);
      localTranslateAnimation.setStartOffset(l1);
      localAnimationSet.addAnimation(localTranslateAnimation);
      l1 += arrayOfInt[i1];
      i1 += 1;
    }
    return localAnimationSet;
  }
  
  @TargetApi(17)
  private void f()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (Activity)this.m.get();
      ((Activity)localObject).runOnUiThread(new UnlimitedBladeWorks.7(this, (Activity)localObject));
    }
  }
  
  private void g()
  {
    Object localObject = new int[2];
    this.b.getLocationOnScreen((int[])localObject);
    int i1 = localObject[0];
    int i2 = localObject[1];
    PokeItemAnimationManager.c().a(10);
    localObject = this.m;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.m.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887)).getGreatMoveCombolEffectView().a(this.q, this.g, this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[x :");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append(", y : ");
        ((StringBuilder)localObject).append(i2);
        ((StringBuilder)localObject).append("]");
        QLog.d("fangdazhao", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.j;
    ((UnlimitedBladeWorks.UnlimitedState)localObject).e = true;
    ((UnlimitedBladeWorks.UnlimitedState)localObject).d = false;
    f();
    localObject = this.s;
    if (localObject != null) {
      ((UnlimitedBladeWorks.UnlimitedEndListener)localObject).a();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    this.r = paramBoolean2;
    this.a = ((ImageView)findViewById(2131435896));
    this.b = ((ImageView)findViewById(2131429259));
    this.c = ((ImageView)findViewById(2131429600));
    this.d = getHandDrawable();
    this.e = getBlusterDrawable();
    this.a.setImageDrawable(this.d);
    this.g = paramBoolean1;
    this.d.a(paramBoolean1);
    this.b.clearAnimation();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    try
    {
      this.h = ImageUtil.a(PokeBigResHandler.d, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
      }
      this.h = null;
    }
    Bitmap localBitmap = this.h;
    if (localBitmap != null) {
      this.i = PokeItemHelper.a(localBitmap);
    }
    this.m = new WeakReference(paramContext);
    setParams(this.g);
    if (paramBoolean2) {
      ThreadManager.postImmediately(new UnlimitedBladeWorks.1(this), null, true);
    }
    this.n = new UnlimitedBladeWorks.BallAnimationListener(this, null);
    this.d.a(new UnlimitedBladeWorks.2(this));
    this.k = true;
  }
  
  public void a(MessageForPoke paramMessageForPoke, float paramFloat)
  {
    this.q = paramMessageForPoke;
    this.j = this.q.mUnlimitedState;
    this.l = paramFloat;
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, float paramFloat)
  {
    if ((paramFloat == 2.0F) && (GreatMoveCombolEffectView.h == true))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.m.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887)).getGreatMoveCombolEffectView().a(paramMessageForPoke, this);
      return;
    }
    this.j = paramMessageForPoke.mUnlimitedState;
    paramMessageForPoke = this.j;
    paramMessageForPoke.d = true;
    paramMessageForPoke.e = false;
    if (QLog.isColorLevel())
    {
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append("[");
      paramMessageForPoke.append(this.j.a);
      paramMessageForPoke.append(",");
      paramMessageForPoke.append(this.j.c);
      paramMessageForPoke.append(",");
      paramMessageForPoke.append(this.j.b);
      paramMessageForPoke.append("]");
      QLog.d("fangdazhao", 2, paramMessageForPoke.toString());
    }
    if (this.j.a < 23)
    {
      this.b.setImageResource(0);
      this.c.setImageDrawable(null);
      this.d.b(this.j.a);
      this.f.cancel();
      this.b.setImageDrawable(null);
      this.d.a(new UnlimitedBladeWorks.4(this));
      this.d.d();
      return;
    }
    if ((this.j.a >= 23) && (this.j.a < 29))
    {
      this.c.setImageDrawable(null);
      if (this.g) {
        this.b.setImageDrawable(this.i);
      } else {
        this.b.setImageBitmap(this.h);
      }
      this.d.b(this.j.a);
      if (this.j.c == -1L)
      {
        this.f.start();
      }
      else
      {
        this.f.start();
        this.f.setCurrentPlayTime(this.j.c);
      }
      this.d.a(null);
      this.d.d();
      return;
    }
    int i1 = ((Integer)this.f.getAnimatedValue()).intValue();
    if (i1 > 0)
    {
      if (this.g) {
        this.b.setImageDrawable(this.i);
      } else {
        this.b.setImageBitmap(this.h);
      }
      this.f.start();
      this.f.setCurrentPlayTime(this.j.c);
      return;
    }
    if ((i1 <= 0) && (this.j.b >= 0) && (this.j.b < 9))
    {
      this.b.setImageResource(0);
      this.c.setImageDrawable(this.e);
      this.e.a(new UnlimitedBladeWorks.5(this));
      this.e.a(paramBoolean);
      this.e.b(this.j.b);
      this.e.d();
      return;
    }
    this.a.setImageDrawable(null);
    this.b.setImageResource(0);
    this.c.setImageDrawable(this.e);
    paramMessageForPoke = this.s;
    if (paramMessageForPoke != null)
    {
      paramMessageForPoke.a();
      if (this.r) {
        HapticManager.b().d(this.p);
      }
      this.p = 0;
    }
    paramMessageForPoke = this.j;
    paramMessageForPoke.d = false;
    paramMessageForPoke.e = true;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public void c()
  {
    int i1 = ScreenUtil.SCREEN_WIDTH;
    int i2 = ScreenUtil.dip2px(142.0F);
    int i3 = (int)(ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(142.0F) * this.l);
    float f1 = i3 * 1.0F / (i1 - i2);
    ValueAnimator localValueAnimator = this.f;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.f.removeAllListeners();
    }
    this.f = ValueAnimator.ofInt(new int[] { i3, -ScreenUtil.dip2px(80.0F) });
    this.f.addUpdateListener(new UnlimitedBladeWorks.3(this));
    if (this.n == null) {
      this.n = new UnlimitedBladeWorks.BallAnimationListener(this, null);
    }
    this.f.addListener(this.n);
    this.f.setDuration((f1 * 600.0F));
    this.f.setTarget(this.b);
    this.f.setInterpolator(new LinearInterpolator());
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "SHOW_PLACEHOLDER Unlimited");
    }
    UnlimitedBladeWorks.UnlimitedState localUnlimitedState = this.j;
    localUnlimitedState.a = 0;
    localUnlimitedState.b = 0;
    localUnlimitedState.c = 0L;
    localUnlimitedState.d = true;
    localUnlimitedState.e = false;
    this.a.setImageDrawable(this.d);
    this.b.setImageDrawable(null);
    this.c.setImageDrawable(null);
    this.d.c();
    if (this.r) {
      this.p = HapticManager.b().a(this.o, 2);
    }
  }
  
  public UnlimitedBladeWorks.UnlimitedState e()
  {
    UnlimitedBladeWorks.UnlimitedState localUnlimitedState = this.j;
    this.d.f();
    localUnlimitedState.a = this.d.j();
    if (this.f.isRunning())
    {
      localUnlimitedState.c = this.f.getCurrentPlayTime();
      this.f.cancel();
      this.b.setImageDrawable(null);
    }
    else
    {
      localUnlimitedState.c = -1L;
    }
    this.e.f();
    localUnlimitedState.b = this.e.j();
    return localUnlimitedState;
  }
  
  public CustomFrameAnimationDrawable getBlusterDrawable()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PokeBigResHandler.c);
    ((StringBuilder)localObject1).append("/dazhao/dazhao2_motion/dazhao2_motion_");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inSampleSize = 1;
    ((BitmapFactory.Options)localObject1).inMutable = true;
    StringBuilder localStringBuilder;
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("01.png");
      localObject1 = ImageUtil.a(localStringBuilder.toString(), (BitmapFactory.Options)localObject1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
      }
      localObject2 = null;
    }
    Object localObject2 = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject2, PokeItemAnimationManager.c().b());
    ((CustomFrameAnimationDrawable)localObject2).l();
    int i2;
    for (int i1 = 0; i1 < 23; i1 = i2)
    {
      i2 = i1 + 1;
      if (i2 < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("0");
        localStringBuilder.append(i2);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i1, 40, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(i2);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i1, 40, localStringBuilder.toString());
      }
    }
    ((CustomFrameAnimationDrawable)localObject2).a();
    ((CustomFrameAnimationDrawable)localObject2).i();
    return localObject2;
  }
  
  public CustomFrameAnimationDrawable getHandDrawable()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(PokeBigResHandler.c);
    ((StringBuilder)localObject1).append("/dazhao/daozhao_motion/dazhao_motion_");
    String str = ((StringBuilder)localObject1).toString();
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inSampleSize = 1;
    ((BitmapFactory.Options)localObject1).inMutable = true;
    StringBuilder localStringBuilder;
    try
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("01.png");
      localObject1 = ImageUtil.a(localStringBuilder.toString(), (BitmapFactory.Options)localObject1);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
      }
      localObject2 = null;
    }
    Object localObject2 = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject2, PokeItemAnimationManager.c().b());
    ((CustomFrameAnimationDrawable)localObject2).l();
    int i2;
    for (int i1 = 0; i1 < 29; i1 = i2)
    {
      i2 = i1 + 1;
      if (i2 < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("0");
        localStringBuilder.append(i2);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i1, 40, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(i2);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i1, 40, localStringBuilder.toString());
      }
    }
    ((CustomFrameAnimationDrawable)localObject2).a();
    ((CustomFrameAnimationDrawable)localObject2).i();
    return localObject2;
  }
  
  public void setEndListener(UnlimitedBladeWorks.UnlimitedEndListener paramUnlimitedEndListener)
  {
    this.s = paramUnlimitedEndListener;
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (this.g == paramBoolean) {
      return;
    }
    this.g = paramBoolean;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.a.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.b(100.0F, getResources());
      this.b.setLayoutParams(localLayoutParams);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.a.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.b(100.0F, getResources());
      this.b.setLayoutParams(localLayoutParams);
    }
    this.d.a(paramBoolean);
    this.e.a(paramBoolean);
  }
  
  public void setParams(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean == true)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      this.a.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(34.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(48.0F) * this.l));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.b(100.0F, getResources());
      this.b.setLayoutParams(localLayoutParams);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      this.a.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.l));
      this.c.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(34.0F) * this.l));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(48.0F) * this.l));
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.b(100.0F, getResources());
      this.b.setLayoutParams(localLayoutParams);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks
 * JD-Core Version:    0.7.0.1
 */