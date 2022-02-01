package com.tencent.biz.pubaccount.readinjoy.common;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import pgb;

public class ReadInJoyCardViewCostBall
  extends TextView
{
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  
  public ReadInJoyCardViewCostBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyCardViewCostBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131371248);
    setBackgroundColor(paramContext.getResources().getColor(2131165356));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new pgb(this, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyCardViewCostBall
 * JD-Core Version:    0.7.0.1
 */