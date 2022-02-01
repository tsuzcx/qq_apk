package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class ActivateFriendActivity$5
  implements Handler.Callback
{
  ActivateFriendActivity$5(ActivateFriendActivity paramActivateFriendActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (ActivateFriendActivity.a(this.a) != null)
      {
        ActivateFriendActivity.a(this.a).e();
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        ActivateFriendActivity.a(this.a, (ArrayList)paramMessage.getSerializable("models"), (List)paramMessage.getSerializable("list"), paramMessage.getInt("count"));
        continue;
        paramMessage = (Bundle)paramMessage.obj;
        this.a.a((AcsMsg)paramMessage.getSerializable("acsMsg"));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.5
 * JD-Core Version:    0.7.0.1
 */