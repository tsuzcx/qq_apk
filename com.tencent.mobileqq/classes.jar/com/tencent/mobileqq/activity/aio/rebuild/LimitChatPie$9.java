package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$9
  implements ArkViewImplement.LoadCallback
{
  LimitChatPie$9(LimitChatPie paramLimitChatPie) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    QLog.w("LimitChatPie", 1, "arkView onLoadFailed");
  }
  
  public void onLoadState(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("arkView onLoadState success : ");
    if (paramInt == 1) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.i("LimitChatPie", 1, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9
 * JD-Core Version:    0.7.0.1
 */