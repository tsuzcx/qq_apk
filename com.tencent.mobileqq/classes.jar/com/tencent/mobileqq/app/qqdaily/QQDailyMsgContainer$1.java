package com.tencent.mobileqq.app.qqdaily;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;

class QQDailyMsgContainer$1
  implements ArkViewImplement.LoadCallback
{
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyMsgContainer", 2, "ark load failed. i: " + paramInt1 + ", i1: " + paramInt2 + ", s: " + paramString + ", b: " + paramBoolean);
    }
  }
  
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQDailyMsgContainer", 2, "ark load state: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyMsgContainer.1
 * JD-Core Version:    0.7.0.1
 */