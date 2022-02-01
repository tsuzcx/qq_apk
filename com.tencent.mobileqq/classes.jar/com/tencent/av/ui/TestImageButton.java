package com.tencent.av.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.qphone.base.util.QLog;

public class TestImageButton
  extends ImageButton
{
  public TestImageButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TestImageButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TestImageButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WL_DEBUG setVisibility visibility = ");
      localStringBuilder.append(paramInt);
      QLog.d("TestImageButton", 4, localStringBuilder.toString());
    }
    SmallScreenUtils.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.TestImageButton
 * JD-Core Version:    0.7.0.1
 */