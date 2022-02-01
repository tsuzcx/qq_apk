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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap = null;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private CustomFrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private UnlimitedBladeWorks.BallAnimationListener jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$BallAnimationListener;
  private UnlimitedBladeWorks.UnlimitedEndListener jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedEndListener = null;
  private UnlimitedBladeWorks.UnlimitedState jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
  private MessageForPoke jdField_a_of_type_ComTencentMobileqqDataMessageForPoke;
  private String jdField_a_of_type_JavaLangString = "chat_item_for_qqultnew";
  private WeakReference<Context> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private CustomFrameAnimationDrawable jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable;
  private boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean = false;
  
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
    LayoutInflater.from(paramContext).inflate(2131563010, this, true);
  }
  
  private AnimationSet a(int paramInt)
  {
    int i = 0;
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
    int j = paramInt * 0;
    int k = paramInt * 1;
    int m = arrayOfInt.length;
    long l = 0L;
    while (i < m)
    {
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, AIOUtils.b(new int[] { paramInt * 5, paramInt * -12, paramInt * 15, paramInt * -15, paramInt * 12, paramInt * -8, paramInt * 6, j }[i], getResources()), 0.0F, AIOUtils.b(new int[] { k, paramInt * -3, paramInt * 2, paramInt * -2, k, paramInt * -1, k, j }[i], getResources()));
      localTranslateAnimation.setDuration(arrayOfInt[i]);
      localTranslateAnimation.setStartOffset(l);
      localAnimationSet.addAnimation(localTranslateAnimation);
      l += arrayOfInt[i];
      i += 1;
    }
    return localAnimationSet;
  }
  
  @TargetApi(17)
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      ((Activity)localObject).runOnUiThread(new UnlimitedBladeWorks.6(this, (Activity)localObject, paramInt));
    }
  }
  
  @TargetApi(17)
  private void d()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
      ((Activity)localObject).runOnUiThread(new UnlimitedBladeWorks.7(this, (Activity)localObject));
    }
  }
  
  private void e()
  {
    Object localObject = new int[2];
    this.jdField_b_of_type_AndroidWidgetImageView.getLocationOnScreen((int[])localObject);
    int i = localObject[0];
    int j = localObject[1];
    PokeItemAnimationManager.a().a(10);
    localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288)).a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke, this.jdField_a_of_type_Boolean, this);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[x :");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", y : ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append("]");
        QLog.d("fangdazhao", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public CustomFrameAnimationDrawable a()
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
    Object localObject2 = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject2, PokeItemAnimationManager.a().a());
    ((CustomFrameAnimationDrawable)localObject2).i();
    int j;
    for (int i = 0; i < 23; i = j)
    {
      j = i + 1;
      if (j < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("0");
        localStringBuilder.append(j);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i, 40, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(j);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i, 40, localStringBuilder.toString());
      }
    }
    ((CustomFrameAnimationDrawable)localObject2).a();
    ((CustomFrameAnimationDrawable)localObject2).h();
    return localObject2;
  }
  
  public UnlimitedBladeWorks.UnlimitedState a()
  {
    UnlimitedBladeWorks.UnlimitedState localUnlimitedState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.f();
    localUnlimitedState.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())
    {
      localUnlimitedState.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidAnimationValueAnimator.getCurrentPlayTime();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    else
    {
      localUnlimitedState.jdField_a_of_type_Long = -1L;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.f();
    localUnlimitedState.jdField_b_of_type_Int = this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a();
    return localUnlimitedState;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_b_of_type_Boolean = true;
    ((UnlimitedBladeWorks.UnlimitedState)localObject).jdField_a_of_type_Boolean = false;
    d();
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedEndListener;
    if (localObject != null) {
      ((UnlimitedBladeWorks.UnlimitedEndListener)localObject).a();
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, float paramFloat)
  {
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131368945));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363369));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363685));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = b();
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable = a();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean1);
    this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = 1;
    localOptions.inMutable = true;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a(PokeBigResHandler.d, localOptions);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UnlimitedBladeWorks", 2, localOutOfMemoryError.toString());
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = PokeItemHelper.a(localBitmap);
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramContext);
    setParams(this.jdField_a_of_type_Boolean);
    if (paramBoolean2) {
      ThreadManager.postImmediately(new UnlimitedBladeWorks.1(this), null, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$BallAnimationListener = new UnlimitedBladeWorks.BallAnimationListener(this, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new UnlimitedBladeWorks.2(this));
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(MessageForPoke paramMessageForPoke, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke = paramMessageForPoke;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState = this.jdField_a_of_type_ComTencentMobileqqDataMessageForPoke.mUnlimitedState;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(MessageForPoke paramMessageForPoke, boolean paramBoolean, float paramFloat)
  {
    if ((paramFloat == 2.0F) && (GreatMoveCombolEffectView.jdField_a_of_type_Boolean == true))
    {
      ((FitSystemWindowsRelativeLayout)((ViewGroup)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getWindow().getDecorView()).getChildAt(0).findViewById(2131362288)).a().a(paramMessageForPoke, this);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState = paramMessageForPoke.mUnlimitedState;
    paramMessageForPoke = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    paramMessageForPoke.jdField_a_of_type_Boolean = true;
    paramMessageForPoke.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      paramMessageForPoke = new StringBuilder();
      paramMessageForPoke.append("[");
      paramMessageForPoke.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int);
      paramMessageForPoke.append(",");
      paramMessageForPoke.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long);
      paramMessageForPoke.append(",");
      paramMessageForPoke.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int);
      paramMessageForPoke.append("]");
      QLog.d("fangdazhao", 2, paramMessageForPoke.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int < 23)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new UnlimitedBladeWorks.4(this));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int >= 23) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int < 29))
    {
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Int);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long == -1L)
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      }
      else
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
      return;
    }
    int i = ((Integer)this.jdField_a_of_type_AndroidAnimationValueAnimator.getAnimatedValue()).intValue();
    if (i > 0)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      } else {
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setCurrentPlayTime(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_a_of_type_Long);
      return;
    }
    if ((i <= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int < 9))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(new UnlimitedBladeWorks.5(this));
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState.jdField_b_of_type_Int);
      this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.d();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    paramMessageForPoke = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedEndListener;
    if (paramMessageForPoke != null)
    {
      paramMessageForPoke.a();
      if (this.jdField_c_of_type_Boolean) {
        HapticManager.a().c(this.jdField_a_of_type_Int);
      }
      this.jdField_a_of_type_Int = 0;
    }
    paramMessageForPoke = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    paramMessageForPoke.jdField_a_of_type_Boolean = false;
    paramMessageForPoke.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public CustomFrameAnimationDrawable b()
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
    Object localObject2 = new CustomFrameAnimationDrawable(getResources(), (Bitmap)localObject2, PokeItemAnimationManager.a().a());
    ((CustomFrameAnimationDrawable)localObject2).i();
    int j;
    for (int i = 0; i < 29; i = j)
    {
      j = i + 1;
      if (j < 10)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("0");
        localStringBuilder.append(j);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i, 40, localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(j);
        localStringBuilder.append(".png");
        ((CustomFrameAnimationDrawable)localObject2).a(i, 40, localStringBuilder.toString());
      }
    }
    ((CustomFrameAnimationDrawable)localObject2).a();
    ((CustomFrameAnimationDrawable)localObject2).h();
    return localObject2;
  }
  
  public void b()
  {
    int i = ScreenUtil.SCREEN_WIDTH;
    int j = ScreenUtil.dip2px(142.0F);
    int k = (int)(ScreenUtil.SCREEN_WIDTH - ScreenUtil.dip2px(142.0F) * this.jdField_a_of_type_Float);
    float f = k * 1.0F / (i - j);
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { k, -ScreenUtil.dip2px(80.0F) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new UnlimitedBladeWorks.3(this));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$BallAnimationListener == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$BallAnimationListener = new UnlimitedBladeWorks.BallAnimationListener(this, null);
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$BallAnimationListener);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration((f * 600.0F));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setTarget(this.jdField_b_of_type_AndroidWidgetImageView);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("placeholder", 2, "SHOW_PLACEHOLDER Unlimited");
    }
    UnlimitedBladeWorks.UnlimitedState localUnlimitedState = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedState;
    localUnlimitedState.jdField_a_of_type_Int = 0;
    localUnlimitedState.jdField_b_of_type_Int = 0;
    localUnlimitedState.jdField_a_of_type_Long = 0L;
    localUnlimitedState.jdField_a_of_type_Boolean = true;
    localUnlimitedState.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(null);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.c();
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_Int = HapticManager.a().a(this.jdField_a_of_type_JavaLangString, 2);
    }
  }
  
  public void setEndListener(UnlimitedBladeWorks.UnlimitedEndListener paramUnlimitedEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemUnlimitedBladeWorks$UnlimitedEndListener = paramUnlimitedEndListener;
  }
  
  public void setMirror(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.b(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.b(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioItemCustomFrameAnimationDrawable.a(paramBoolean);
  }
  
  public void setParams(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean == true)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(34.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(48.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.leftMargin = 0;
      localLayoutParams.rightMargin = AIOUtils.b(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    else
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, 0);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(90.0F) * this.jdField_a_of_type_Float));
      this.jdField_c_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams.addRule(9, -1);
      localLayoutParams.addRule(11, 0);
      localLayoutParams.height = ((int)(ScreenUtil.dip2px(34.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.width = ((int)(ScreenUtil.dip2px(48.0F) * this.jdField_a_of_type_Float));
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = AIOUtils.b(100.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks
 * JD-Core Version:    0.7.0.1
 */