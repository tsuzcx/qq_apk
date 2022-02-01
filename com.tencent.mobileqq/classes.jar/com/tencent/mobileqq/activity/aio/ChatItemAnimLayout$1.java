package com.tencent.mobileqq.activity.aio;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

class ChatItemAnimLayout$1
  extends Handler
{
  ChatItemAnimLayout$1(ChatItemAnimLayout paramChatItemAnimLayout) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemAnimLayout", 2, "ANIMATION_END");
        }
        paramMessage = this.a;
        paramMessage.e = 1.0F;
        paramMessage.invalidate();
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemAnimLayout$OnItemAnimEndListener != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityAioChatItemAnimLayout$OnItemAnimEndListener.a(this.a.b);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatItemAnimLayout", 2, "ANIMATION_UPDADE");
        }
        this.a.b.mMsgAnimTime = System.currentTimeMillis();
        float f2 = (float)(this.a.b.mMsgAnimTime - this.a.jdField_a_of_type_Long) / 300.0F;
        float f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramMessage = this.a;
        f2 = 1.0F - f1;
        paramMessage.e = (1.0F - f2 * f2 * f2);
        paramMessage.f = f1;
        if (paramMessage.e < 1.0F)
        {
          sendMessageDelayed(ChatItemAnimLayout.a(this.a).obtainMessage(1), 10L);
        }
        else
        {
          paramMessage = this.a;
          paramMessage.e = 1.0F;
          sendMessageDelayed(ChatItemAnimLayout.a(paramMessage).obtainMessage(2), 0L);
        }
        this.a.invalidate();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemAnimLayout", 2, "ANIMATION_START");
      }
      this.a.b.mMsgAnimTime = System.currentTimeMillis();
      paramMessage = this.a;
      paramMessage.e = 0.0F;
      paramMessage.f = 0.0F;
      sendMessageDelayed(ChatItemAnimLayout.a(paramMessage).obtainMessage(1), 10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatItemAnimLayout.1
 * JD-Core Version:    0.7.0.1
 */