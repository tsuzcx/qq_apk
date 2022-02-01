package com.tencent.mobileqq.activity.home;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Conversation$19
  implements Runnable
{
  Conversation$19(Conversation paramConversation, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a.equals(Conversation.a(this.this$0).getText())) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][mainTab] updateNickName() ignore from: " + this.b + " nickName: " + this.a);
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "[status][mainTab] updateNickName() from: " + this.b + " nickName: " + this.a);
      }
      Conversation.a(this.this$0).setText(this.a);
      Object localObject = Conversation.a(this.this$0).getTag(2131366402);
      if (((localObject instanceof WeakReference)) && ((((WeakReference)localObject).get() instanceof TextView))) {}
      for (localObject = (TextView)((WeakReference)localObject).get(); localObject != null; localObject = null)
      {
        ((TextView)localObject).setText(this.a);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.19
 * JD-Core Version:    0.7.0.1
 */