package com.tencent.aelight.camera.aeeditor.module.aifilter;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.log.AEQLog;

public class AEEditorApplyAllLoadingView
  extends FrameLayout
{
  private TextView a;
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEEditorApplyAllLoadingView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private float a(float paramFloat)
  {
    paramFloat = paramFloat * 1000.0F / 1000.0F - 1.0F;
    return (paramFloat * paramFloat * paramFloat * paramFloat * paramFloat + 1.0F) * 1.0F + 0.0F;
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2064318548, this);
    this.a = ((TextView)findViewById(2064122684));
    b();
  }
  
  private void b()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ValueAnimator localValueAnimator1 = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator1.setDuration(1000L);
    localValueAnimator1.addUpdateListener(new AEEditorApplyAllLoadingView.1(this));
    ValueAnimator localValueAnimator2 = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
    localValueAnimator2.setDuration(1000L);
    localValueAnimator2.addUpdateListener(new AEEditorApplyAllLoadingView.2(this));
    localAnimatorSet.play(localValueAnimator1).before(localValueAnimator2);
    localAnimatorSet.addListener(new AEEditorApplyAllLoadingView.3(this));
    localAnimatorSet.start();
  }
  
  public void a()
  {
    if (getParent() == null)
    {
      AEQLog.a("AEEditorApplyAllLoadingView", "cancelLoading parent is null.");
      return;
    }
    ((ViewGroup)getParent()).removeAllViews();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AEEditorApplyAllLoadingView
 * JD-Core Version:    0.7.0.1
 */