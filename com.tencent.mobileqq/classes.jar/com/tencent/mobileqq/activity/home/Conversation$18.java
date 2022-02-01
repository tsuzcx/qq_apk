package com.tencent.mobileqq.activity.home;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Conversation$18
  implements Runnable
{
  Conversation$18(Conversation paramConversation, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.a.equals(Conversation.a(this.this$0).getText()))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[status][mainTab] updateNickName() ignore from: ");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(" nickName: ");
        ((StringBuilder)localObject1).append(this.a);
        QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[status][mainTab] updateNickName() from: ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" nickName: ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject1).toString());
    }
    Conversation.a(this.this$0).setText(this.a);
    Object localObject2 = null;
    Object localObject3 = Conversation.a(this.this$0).getTag(2131366283);
    Object localObject1 = localObject2;
    if ((localObject3 instanceof WeakReference))
    {
      localObject3 = (WeakReference)localObject3;
      localObject1 = localObject2;
      if ((((WeakReference)localObject3).get() instanceof TextView)) {
        localObject1 = (TextView)((WeakReference)localObject3).get();
      }
    }
    if (localObject1 != null) {
      ((TextView)localObject1).setText(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.18
 * JD-Core Version:    0.7.0.1
 */