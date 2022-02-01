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
  private ImageView a;
  private ImageView b;
  private AnimationQIMCircleProgress c;
  @NonNull
  private final float[] d = { 0.0F, 1.0F };
  @NonNull
  private float[] e = { 0.0F, 1.0F };
  private int f = AIOUtils.b(98.0F, getResources());
  private int g = AIOUtils.b(98.0F, getResources());
  
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
    LayoutInflater.from(paramContext).inflate(2064056332, this, true);
    this.a = ((ImageView)findViewById(2063991189));
    this.b = ((ImageView)findViewById(2063991196));
    this.c = ((AnimationQIMCircleProgress)findViewById(2063990889));
  }
  
  public void a(float paramFloat)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return;
    }
    localObject = ((AnimationQIMCircleProgress)localObject).getLayoutParams();
    int i = this.g;
    ((ViewGroup.LayoutParams)localObject).width = ((int)(i * paramFloat));
    ((ViewGroup.LayoutParams)localObject).height = ((int)(i * paramFloat));
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setAlpha(a(AECircleCaptureStyle.a(paramFloat), this.e));
  }
  
  public void a(int paramInt)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.changeMode(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, @NonNull AECircleCaptureStyle paramAECircleCaptureStyle)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(paramAECircleCaptureStyle.i);
    }
    localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setImageResource(paramAECircleCaptureStyle.l);
    }
    this.e = paramAECircleCaptureStyle.o;
    localObject = this.c;
    if (localObject != null)
    {
      ((AnimationQIMCircleProgress)localObject).a(paramBoolean, paramAECircleCaptureStyle);
      this.c.setAlpha(this.e[0]);
    }
  }
  
  public int getMode()
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      return localAnimationQIMCircleProgress.getMode();
    }
    return 0;
  }
  
  public void setCenterScaleValue(float paramFloat)
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    ((ImageView)localObject).getLayoutParams();
    localObject = this.b.getLayoutParams();
    int i = this.f;
    ((ViewGroup.LayoutParams)localObject).width = ((int)(i * paramFloat));
    ((ViewGroup.LayoutParams)localObject).height = ((int)(i * paramFloat));
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramFloat = a(AECircleCaptureStyle.b(paramFloat), this.d);
    this.a.setAlpha(paramFloat);
    this.b.setAlpha(1.0F - paramFloat);
  }
  
  public void setCenterView()
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setCenterView();
    }
  }
  
  public void setProgress(float paramFloat)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setProgress(paramFloat);
    }
  }
  
  public void setStrokeWidth(float paramFloat)
  {
    AnimationQIMCircleProgress localAnimationQIMCircleProgress = this.c;
    if (localAnimationQIMCircleProgress != null) {
      localAnimationQIMCircleProgress.setStrokeWidth(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECircleCaptureProgressView
 * JD-Core Version:    0.7.0.1
 */