package com.tencent.mobileqq.app;

import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.qphone.base.util.QLog;

class QBaseActivity$5
  implements View.OnSystemUiVisibilityChangeListener
{
  QBaseActivity$5(QBaseActivity paramQBaseActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = false;
    } else {
      bool = true;
    }
    QBaseActivity.mIsInMultiScreen = bool;
    this.this$0.onMultiWindowModeChanged(QBaseActivity.mIsInMultiScreen);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSystemUiVisibilityChange:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",Activity name:");
      localStringBuilder.append(getClass().getName());
      QLog.d("qqBaseActivity", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.5
 * JD-Core Version:    0.7.0.1
 */