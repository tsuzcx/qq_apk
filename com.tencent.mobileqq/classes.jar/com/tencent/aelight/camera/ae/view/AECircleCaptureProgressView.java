package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class AECircleCaptureProgressView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = AIOUtils.b(98.0F, getResources());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AnimationQIMCircleProgress jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
  @NonNull
  private final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  private int jdField_b_of_type_Int = AIOUtils.b(98.0F, getResources());
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  @NonNull
  private float[] jdField_b_of_type_ArrayOfFloat = { 0.0F, 1.0F };
  
  public AECircleCaptureProgressView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AECircleCaptureProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private float a(float paramFloat, @NonNull float[] paramArrayOfFloat)
  {
    return paramArrayOfFloat[0] + paramFloat * (paramArrayOfFloat[1] - paramArrayOfFloat[0]);
  }
  
  private void a(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    LayoutInflater.from(paramContext).inflate(2064318472, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2064122309));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2064122315));
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress = ((AnimationQIMCircleProgress)findViewById(2064121958));
  }
  
  public int a()
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      return localAnimationQIMCircleProgress.getMode();
    }
    return 0;
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localObject == null) {
      return;
    }
    localObject = ((AnimationQIMCircleProgress)localObject).getLayoutParams();
    int i = this.jdField_b_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).width = ((int)(i * paramFloat));
    ((ViewGroup.LayoutParams)localObject).height = ((int)(i * paramFloat));
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setAlpha(a(AECircleCaptureStyle.a(paramFloat), this.jdField_b_of_type_ArrayOfFloat));
  }
  
  public void a(int paramInt)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.changeMode(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(paramAECircleCaptureStyle.jdField_a_of_type_Int);
    }
    localObject = this.jdField_b_of_type_AndroidWidgetImageView;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(paramAECircleCaptureStyle.d);
    }
    this.jdField_b_of_type_ArrayOfFloat = paramAECircleCaptureStyle.jdField_a_of_type_ArrayOfFloat;
    localObject = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localObject != null)
    {
      ((AnimationQIMCircleProgress)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setAlpha(this.jdField_b_of_type_ArrayOfFloat[0]);
    }
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).getLayoutParams();
    localObject = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
    int i = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject).width = ((int)(i * paramFloat));
    ((ViewGroup.LayoutParams)localObject).height = ((int)(i * paramFloat));
    this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramFloat = a(AECircleCaptureStyle.b(paramFloat), this.jdField_a_of_type_ArrayOfFloat);
    this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(paramFloat);
    this.jdField_b_of_type_AndroidWidgetImageView.setAlpha(1.0F - paramFloat);
  }
  
  public void setCenterView()
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setCenterView();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setProgress(paramFloat);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECircleCaptureProgressView
 * JD-Core Version:    0.7.0.1
 */