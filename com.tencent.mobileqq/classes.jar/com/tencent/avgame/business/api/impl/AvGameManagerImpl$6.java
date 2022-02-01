package com.tencent.avgame.business.api.impl;

import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;
import com.tencent.qphone.base.util.QLog;

class AvGameManagerImpl$6
  implements Runnable
{
  AvGameManagerImpl$6(AvGameManagerImpl paramAvGameManagerImpl, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      String str = AvGameManagerImpl.access$200(this.this$0).getCurrentNickname();
      AVGameShareUtil.a().a(AvGameManagerImpl.access$200(this.this$0), 0, this.a, AvGameEntranceUtil.a(this.b), AvGameManagerImpl.access$200(this.this$0).getLongAccountUin(), str, 1, "", 1);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifySendMsg error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("AvGameManager", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.api.impl.AvGameManagerImpl.6
 * JD-Core Version:    0.7.0.1
 */