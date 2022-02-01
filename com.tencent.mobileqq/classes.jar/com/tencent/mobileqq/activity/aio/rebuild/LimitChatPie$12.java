package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$12
  implements ArkViewImplement.LoadCallback
{
  LimitChatPie$12(LimitChatPie paramLimitChatPie) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    QLog.w("LimitChatPie", 1, "arkView onLoadFailed");
  }
  
  public void onLoadState(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("arkView onLoadState success : ");
    boolean bool;
    if (paramInt == 1) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.i("LimitChatPie", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.12
 * JD-Core Version:    0.7.0.1
 */