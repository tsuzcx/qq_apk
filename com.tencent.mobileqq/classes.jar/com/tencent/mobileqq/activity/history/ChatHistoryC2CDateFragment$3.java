package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.MessageRoamManager.MessageRoamListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

class ChatHistoryC2CDateFragment$3
  implements MessageRoamManager.MessageRoamListener
{
  ChatHistoryC2CDateFragment$3(ChatHistoryC2CDateFragment paramChatHistoryC2CDateFragment) {}
  
  public void a(MessageRoamManager.MessageRoamListener paramMessageRoamListener) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = ChatHistoryC2CDateFragment.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRoamMsgForDate ");
      localStringBuilder.append(paramBoolean);
      QLog.d(paramObject, 2, localStringBuilder.toString());
    }
    this.a.u();
    if (paramBoolean)
    {
      ThreadManagerV2.executeOnSubThread(new ChatHistoryC2CDateFragment.3.1(this));
      return;
    }
    paramObject = this.a;
    paramObject.b(paramObject.getString(2131887730));
  }
  
  public void b(int paramInt1, int paramInt2, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CDateFragment.3
 * JD-Core Version:    0.7.0.1
 */