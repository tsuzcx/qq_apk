package com.tencent.mobileqq.activity;

import android.os.Message;
import aybz;
import com.tencent.mobileqq.data.MessageRecord;
import mqq.os.MqqHandler;

class ChatHistory$8
  implements Runnable
{
  ChatHistory$8(ChatHistory paramChatHistory, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = null;
    if (this.jdField_a_of_type_Boolean) {
      localStringBuilder = new StringBuilder();
    }
    int i = 0;
    if (this.this$0.jdField_a_of_type_Aybz != null) {
      i = this.this$0.jdField_a_of_type_Aybz.a(MessageRecord.getTableName(this.this$0.b, this.this$0.jdField_a_of_type_Int));
    }
    int j = ChatHistory.a(this.this$0.app, this.this$0.b, this.this$0.jdField_a_of_type_Int, localStringBuilder);
    Message localMessage = this.this$0.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(this.jdField_a_of_type_Int);
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      localMessage.obj = localStringBuilder.toString();
    }
    localMessage.arg1 = j;
    localMessage.arg2 = i;
    this.this$0.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.8
 * JD-Core Version:    0.7.0.1
 */