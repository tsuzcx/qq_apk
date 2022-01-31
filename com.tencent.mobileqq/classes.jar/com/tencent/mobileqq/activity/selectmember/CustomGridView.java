package com.tencent.mobileqq.activity.selectmember;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

public class CustomGridView
  extends GridView
{
  public CustomGridView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CustomGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CustomGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      super.setOverScrollMode(2);
      if (QLog.isColorLevel()) {
        QLog.d("CustomGridView", 2, "setOverScrollMode  OVER_SCROLL_NEVER");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CustomGridView
 * JD-Core Version:    0.7.0.1
 */