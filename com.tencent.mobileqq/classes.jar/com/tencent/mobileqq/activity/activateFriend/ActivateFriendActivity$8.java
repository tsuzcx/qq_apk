package com.tencent.mobileqq.activity.activateFriend;

import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.BaseApplication;

class ActivateFriendActivity$8
  implements Runnable
{
  ActivateFriendActivity$8(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public void run()
  {
    int i = this.this$0.app.a().b();
    Object localObject2 = this.this$0.app.getApp().getString(2131654133);
    Object localObject1 = localObject2;
    if (i > 0)
    {
      localObject2 = new StringBuilder().append((String)localObject2).append("(");
      if (i <= 99) {
        break label88;
      }
    }
    label88:
    for (localObject1 = "99+";; localObject1 = Integer.valueOf(i))
    {
      localObject1 = localObject1 + ")";
      ActivateFriendActivity.a(this.this$0).setText((CharSequence)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.8
 * JD-Core Version:    0.7.0.1
 */