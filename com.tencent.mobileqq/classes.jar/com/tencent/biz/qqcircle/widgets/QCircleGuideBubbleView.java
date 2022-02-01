package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import waq;
import war;

public class QCircleGuideBubbleView
  extends QCircleBaseWidgetView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 3500;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private waq jdField_a_of_type_Waq;
  private war jdField_a_of_type_War;
  private boolean jdField_a_of_type_Boolean;
  
  public QCircleGuideBubbleView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QCircleGuideBubbleView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public QCircleGuideBubbleView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Waq.removeMessages(1);
    this.jdField_a_of_type_Waq.removeMessages(2);
  }
  
  public int a()
  {
    return 2131560738;
  }
  
  protected String a()
  {
    return "QCircleGuideBubbleView";
  }
  
  public void a()
  {
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      localObject = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject).setDuration(300L);
      startAnimation((Animation)localObject);
    }
    setVisibility(0);
    if (this.jdField_a_of_type_Int > 0) {
      this.jdField_a_of_type_Waq.sendEmptyMessageDelayed(2, this.jdField_a_of_type_Int);
    }
    Object localObject = this.jdField_a_of_type_War;
    if (localObject != null) {
      ((war)localObject).a();
    }
  }
  
  public void a(int paramInt)
  {
    d();
    this.jdField_a_of_type_Waq.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131365077));
    this.jdField_a_of_type_Waq = new waq(this, null);
  }
  
  public void a(Object paramObject) {}
  
  public void c()
  {
    d();
    if (this.jdField_a_of_type_Boolean)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
      localAlphaAnimation.setDuration(200L);
      startAnimation(localAlphaAnimation);
    }
    setVisibility(8);
  }
  
  public void onClick(View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
    this.jdField_a_of_type_War = null;
  }
  
  public void setNeedFadeAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setOnShowListener(war paramwar)
  {
    this.jdField_a_of_type_War = paramwar;
  }
  
  public void setReportBean(Object paramObject) {}
  
  public void setShowDuration(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setText(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleGuideBubbleView
 * JD-Core Version:    0.7.0.1
 */