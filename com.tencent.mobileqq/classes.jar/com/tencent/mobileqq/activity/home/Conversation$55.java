package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class Conversation$55
  extends HotChatObserver
{
  Conversation$55(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetUserCreateHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", troopOwner=" + paramLong);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetHotChatAnnounce  isSuccess= " + paramBoolean + ", result=" + paramInt + ", memo=" + paramString2 + ", jumpurl=" + paramString3);
    }
    if ((paramBoolean) && (paramInt == 0)) {
      this.a.a(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.55
 * JD-Core Version:    0.7.0.1
 */