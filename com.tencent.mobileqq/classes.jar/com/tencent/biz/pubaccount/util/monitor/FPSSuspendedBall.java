package com.tencent.biz.pubaccount.util.monitor;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import uiy;

public class FPSSuspendedBall
  extends TextView
{
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FPSSuspendedBall(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setId(2131371323);
    setBackgroundColor(paramContext.getResources().getColor(2131165364));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new uiy(this, null));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 53;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 250;
    float f = getTextSize();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)(5.0F * f));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)(f * 1.5D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall
 * JD-Core Version:    0.7.0.1
 */