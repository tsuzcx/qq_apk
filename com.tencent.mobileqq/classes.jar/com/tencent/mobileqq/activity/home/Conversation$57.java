package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class Conversation$57
  extends HotChatObserver
{
  Conversation$57(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetUserCreateHotChatAnnounce  isSuccess= ");
      paramString1.append(paramBoolean);
      paramString1.append(", result=");
      paramString1.append(paramInt);
      paramString1.append(", memo=");
      paramString1.append(paramString2);
      paramString1.append(", troopOwner=");
      paramString1.append(paramLong);
      QLog.d("Q.recent", 2, paramString1.toString());
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("onGetHotChatAnnounce  isSuccess= ");
      paramString1.append(paramBoolean);
      paramString1.append(", result=");
      paramString1.append(paramInt);
      paramString1.append(", memo=");
      paramString1.append(paramString2);
      paramString1.append(", jumpurl=");
      paramString1.append(paramString3);
      QLog.d("Q.recent", 2, paramString1.toString());
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.57
 * JD-Core Version:    0.7.0.1
 */