package com.tencent.biz.pubaccount.util.monitor;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;

class FPSSuspendedBall
  extends TextView
{
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private boolean jdField_a_of_type_Boolean;
  
  public FPSSuspendedBall(Context paramContext)
  {
    this(paramContext, null);
  }
  
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
    setId(2131371821);
    setBackgroundColor(paramContext.getResources().getColor(2131165370));
    setText("60.00");
    setTextColor(-16711936);
    setGravity(17);
    setOnTouchListener(new FPSSuspendedBall.SuspendedBallTouchListener(this, null));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams(-2, -2, 1000, 8, -3);
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 53;
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = 250;
    float f = getTextSize();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = ((int)(5.0F * f));
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = ((int)(f * 1.5D));
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, long paramLong1, long paramLong2)
  {
    float f = getTextSize();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFloat1);
    if ((paramFloat2 > 0.0F) && (paramFloat3 > 0.0F)) {
      localStringBuilder.append("\n").append(paramFloat2).append("%").append("\n").append(paramFloat3).append("%");
    }
    for (int i = 0 + (int)(4.0F * f);; i = 0 + (int)(f * 1.5D))
    {
      int j = i;
      if (this.jdField_a_of_type_Boolean)
      {
        localStringBuilder.append("\n").append(paramLong1).append("kb/s").append("\n").append(paramLong2).append("kb/s");
        double d = i;
        j = (int)(f * 2.5D + d);
      }
      if (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height != j)
      {
        this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = j;
        if (getParent() != null) {
          this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
        }
      }
      setText(localStringBuilder.toString());
      return;
    }
  }
  
  public void a(Activity paramActivity, WindowManager paramWindowManager)
  {
    this.jdField_a_of_type_AndroidViewWindowManager = paramWindowManager;
    paramActivity.getWindow().getDecorView().post(new FPSSuspendedBall.1(this, paramWindowManager));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.FPSSuspendedBall
 * JD-Core Version:    0.7.0.1
 */