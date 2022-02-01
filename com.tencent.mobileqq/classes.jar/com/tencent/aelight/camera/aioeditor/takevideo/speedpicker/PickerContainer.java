package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PickerContainer
  extends RelativeLayout
  implements PickerBarLayout.PickerBarLayoutListener
{
  public static final String a;
  public float a;
  private int jdField_a_of_type_Int = 58;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  Property<PickerContainer, Float> jdField_a_of_type_AndroidUtilProperty = new PickerContainer.1(this, Float.class, "containerAlpha");
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ContainerDrawable jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable;
  private HintDrawable jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable;
  private PickerBarLayout jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout;
  private Float jdField_a_of_type_JavaLangFloat = Float.valueOf(1.0F);
  private WeakReference<PickerContainer.PickerContainerListener> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean = false;
  public float b;
  private boolean b;
  private float c = 200.0F;
  private float d = 497.0F;
  
  static
  {
    jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131708155);
  }
  
  public PickerContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PickerContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Float = 333.60001F;
    this.jdField_b_of_type_Float = 333.60001F;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private static float a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return paramFloat * paramResources.getDisplayMetrics().density;
  }
  
  public static float a(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      return paramFloat;
    }
    return a(paramFloat / 2.0F, paramContext.getResources());
  }
  
  private Float a()
  {
    return this.jdField_a_of_type_JavaLangFloat;
  }
  
  private void a(Context paramContext)
  {
    this.c = a(paramContext, this.c);
    this.jdField_a_of_type_Float = a(paramContext, this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Float = a(paramContext, this.jdField_b_of_type_Float);
    this.d = a(paramContext, this.d);
    this.jdField_a_of_type_Int = AIOUtils.b(this.jdField_a_of_type_Int, paramContext.getResources());
  }
  
  private void a(Float paramFloat)
  {
    this.jdField_a_of_type_JavaLangFloat = paramFloat;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(boolean paramBoolean, long paramLong)
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    float f = 1.0F;
    if (!paramBoolean) {
      f = 0.0F;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(this.jdField_a_of_type_AndroidUtilProperty, new float[] { this.jdField_a_of_type_JavaLangFloat.floatValue(), f }) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(paramLong);
    localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.setRepeatMode(1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(0);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setStartDelay(0L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new PickerContainer.2(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new PickerContainer.3(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable;
    if (localObject != null)
    {
      ((HintDrawable)localObject).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable;
    if (localObject != null)
    {
      ((ContainerDrawable)localObject).a();
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout;
    if (localObject != null) {
      ((PickerBarLayout)localObject).a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllUpdateListeners();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    this.jdField_a_of_type_AndroidUtilProperty = null;
  }
  
  public void a(int paramInt)
  {
    ContainerDrawable localContainerDrawable;
    if (paramInt == 1)
    {
      localContainerDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable;
      if (localContainerDrawable != null)
      {
        localContainerDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.a(false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.a(1);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.start();
      }
    }
    else
    {
      if (paramInt == 4) {
        return;
      }
      localContainerDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable;
      if (localContainerDrawable != null)
      {
        localContainerDrawable.stop();
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.a(false);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.a(2);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.start();
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelected: index:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" text:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" bstart:");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(" bend:");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("PickerContainer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (PickerContainer.PickerContainerListener)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject != null) {
      if (paramBoolean1)
      {
        this.jdField_b_of_type_Boolean = true;
        ((PickerContainer.PickerContainerListener)localObject).a(paramInt, paramString);
      }
      else if (paramBoolean2)
      {
        this.jdField_b_of_type_Boolean = false;
        ((PickerContainer.PickerContainerListener)localObject).c(paramInt, paramString);
      }
      else
      {
        ((PickerContainer.PickerContainerListener)localObject).b(paramInt, paramString);
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new PickerContainer.4(this, paramString), 300L);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PickerBarLayout localPickerBarLayout = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout;
    if (localPickerBarLayout != null) {
      localPickerBarLayout.a(paramInt, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
    if (paramLong > 0L)
    {
      setVisibility(0);
      b(paramBoolean, paramLong);
      return;
    }
    setAlpha(1.0F);
    if (paramBoolean)
    {
      setVisibility(0);
      return;
    }
    setVisibility(8);
  }
  
  public boolean a(EditVideoParams paramEditVideoParams, PickerContainer.PickerContainerListener paramPickerContainerListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramPickerContainerListener);
    a(getContext());
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    paramPickerContainerListener = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable = new ContainerDrawable();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable.a(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackground(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerContainerDrawable);
    addView(this.jdField_a_of_type_AndroidViewView, paramPickerContainerListener);
    paramPickerContainerListener = new RelativeLayout(getContext());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.bottomMargin = this.jdField_a_of_type_Int;
    addView(paramPickerContainerListener, localLayoutParams);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout = new PickerBarLayout(getContext());
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout.a(paramEditVideoParams, getContext(), this);
    this.d = (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout.a() * 60 + 80 + this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout.a() * 5 + 22 + 70);
    this.d = a(getContext(), this.d);
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.c, (int)this.d);
    paramEditVideoParams.addRule(11);
    paramEditVideoParams.addRule(15);
    paramPickerContainerListener.addView(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerPickerBarLayout, paramEditVideoParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    paramEditVideoParams = new RelativeLayout.LayoutParams((int)this.jdField_a_of_type_Float, (int)this.jdField_b_of_type_Float);
    paramEditVideoParams.addRule(13);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable = new HintDrawable();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable.a(getContext(), this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, 1.2F);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackground(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable);
    paramPickerContainerListener.addView(this.jdField_a_of_type_AndroidWidgetImageView, paramEditVideoParams);
    return true;
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if (paramInt == 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      HintDrawable localHintDrawable = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable;
      if (localHintDrawable != null)
      {
        localHintDrawable.stop();
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable.a() == 1) || (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable.a() == 3))
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable.a(2);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoSpeedpickerHintDrawable.start();
        }
      }
    }
  }
  
  public void d(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer
 * JD-Core Version:    0.7.0.1
 */