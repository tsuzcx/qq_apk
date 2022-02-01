package com.tencent.mobileqq.app.qqdaily;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;

class QQDailyMsgContainer$1
  implements ArkViewImplement.LoadCallback
{
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ark load failed. i: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", i1: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", s: ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", b: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQDailyMsgContainer", 2, localStringBuilder.toString());
    }
  }
  
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ark load state: ");
      localStringBuilder.append(paramInt);
      QLog.d("QQDailyMsgContainer", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyMsgContainer.1
 * JD-Core Version:    0.7.0.1
 */