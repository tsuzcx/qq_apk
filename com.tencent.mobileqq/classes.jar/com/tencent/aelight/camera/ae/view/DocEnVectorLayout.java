package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DocEnVectorLayout
  extends LinearLayout
{
  private View a;
  private View b;
  
  public DocEnVectorLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public DocEnVectorLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DocEnVectorLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    View localView = this.a;
    if ((localView != null) && (localView.animate() != null)) {
      this.a.animate().cancel();
    }
    localView = this.b;
    if ((localView != null) && (localView.animate() != null)) {
      this.b.animate().cancel();
    }
  }
  
  @RequiresApi(api=21)
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
    {
      paramView = getBackground();
      if ((paramView instanceof AnimatedVectorDrawable))
      {
        ((AnimatedVectorDrawable)paramView).start();
        this.a = findViewById(2064122306);
        this.b = findViewById(2064122758);
        paramView = this.a;
        if ((paramView != null) && (this.b != null))
        {
          paramView.setAlpha(0.0F);
          this.b.setAlpha(0.0F);
          this.a.animate().alpha(1.0F).setDuration(200L).setStartDelay(360L).start();
          this.b.animate().alpha(1.0F).setDuration(160L).setStartDelay(400L).start();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.DocEnVectorLayout
 * JD-Core Version:    0.7.0.1
 */