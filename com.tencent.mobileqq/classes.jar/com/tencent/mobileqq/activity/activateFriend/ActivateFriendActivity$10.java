package com.tencent.mobileqq.activity.activateFriend;

import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ActivateFriendActivity$10
  implements Runnable
{
  ActivateFriendActivity$10(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void run()
  {
    int i = this.this$0.app.getMessageFacade().w();
    String str = this.this$0.app.getApp().getString(2131917002);
    Object localObject = str;
    if (i > 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("(");
      if (i > 99) {
        localObject = "99+";
      } else {
        localObject = Integer.valueOf(i);
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(")");
      localObject = localStringBuilder.toString();
    }
    ActivateFriendActivity.g(this.this$0).setText((CharSequence)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.10
 * JD-Core Version:    0.7.0.1
 */