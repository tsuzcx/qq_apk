package com.tencent.mobileqq.app;

import android.view.View.OnSystemUiVisibilityChangeListener;
import com.tencent.qphone.base.util.QLog;

class QBaseActivity$5
  implements View.OnSystemUiVisibilityChangeListener
{
  QBaseActivity$5(QBaseActivity paramQBaseActivity) {}
  
  public void onSystemUiVisibilityChange(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = false;; bool = true)
    {
      QBaseActivity.mIsInMultiScreen = bool;
      this.a.onMultiWindowModeChanged(QBaseActivity.mIsInMultiScreen);
      if (QLog.isDevelopLevel()) {
        QLog.d("qqBaseActivity", 4, "onSystemUiVisibilityChange:" + paramInt + ",Activity name:" + getClass().getName());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QBaseActivity.5
 * JD-Core Version:    0.7.0.1
 */