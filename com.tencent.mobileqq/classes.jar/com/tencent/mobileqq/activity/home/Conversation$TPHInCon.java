package com.tencent.mobileqq.activity.home;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Conversation$TPHInCon
  extends TransProcessorHandler
{
  final WeakReference<Conversation> a;
  
  public Conversation$TPHInCon(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void handleMessage(Message paramMessage)
  {
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation == null) {
      return;
    }
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if ((Conversation.a(localConversation) != null) && (localFileMsg != null))
    {
      if (TextUtils.isEmpty(localFileMsg.mUin)) {
        return;
      }
      int k = paramMessage.what;
      int i = localFileMsg.fileType;
      int j = 0;
      if (i != 1)
      {
        i = j;
        if (localFileMsg.fileType != 2) {}
      }
      else if ((k != 1001) && (k != 1002) && (k != 1000) && (k != 1005))
      {
        i = j;
        if (k != 1003) {}
      }
      else
      {
        i = 1;
      }
      if ((i != 0) || (((k == 1003) || (k == 2003)) && ((localFileMsg.fileType == 2) || (localConversation.e))))
      {
        localConversation.a(8, localFileMsg.mUin, -2147483648);
        if (QLog.isColorLevel()) {
          QLog.i("Q.recent", 2, "refresh recent, from_transferListener2");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.TPHInCon
 * JD-Core Version:    0.7.0.1
 */