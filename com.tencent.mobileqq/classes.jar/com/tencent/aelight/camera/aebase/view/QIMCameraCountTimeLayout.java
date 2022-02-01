package com.tencent.aelight.camera.aebase.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;

public class QIMCameraCountTimeLayout
  extends LinearLayout
{
  private View a;
  private TextView b;
  private boolean c;
  
  public QIMCameraCountTimeLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QIMCameraCountTimeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    this.a = new View(getContext());
    this.a.setBackgroundResource(2130845876);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(6.0F), ViewUtils.dip2px(6.0F));
    localLayoutParams.gravity = 16;
    this.b = new TextView(getContext());
    if (this.c)
    {
      addView(this.a, localLayoutParams);
      this.b.setText("0秒");
      this.b.setTextSize(14.0F);
      this.b.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165580);
      this.b.setTextColor(getResources().getColor(2131168464));
    }
    else
    {
      this.b.setText("00:00");
      this.b.setTextSize(18.0F);
      this.b.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165580);
      this.b.setTextColor(getResources().getColor(2131168464));
    }
    localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = ViewUtils.dip2px(4.0F);
    addView(this.b, localLayoutParams);
  }
  
  public void setDotView(int paramInt)
  {
    this.a.setBackgroundResource(paramInt);
  }
  
  public void setIsCircleStyle(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void setText(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setTextColor(int paramInt)
  {
    this.b.setTextColor(paramInt);
  }
  
  public void setTextShadow(boolean paramBoolean)
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localTextView.setShadowLayer(2.0F, 0.0F, 0.0F, 2131165580);
      return;
    }
    localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if ((paramInt == 0) && (this.c))
    {
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2063663104);
      this.a.startAnimation(localAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCountTimeLayout
 * JD-Core Version:    0.7.0.1
 */