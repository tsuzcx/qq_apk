package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.reminder.OnGetReminderFromDBFinishListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ActivateFriendActivity$3
  implements OnGetReminderFromDBFinishListener
{
  ActivateFriendActivity$3(ActivateFriendActivity paramActivateFriendActivity, ArrayList paramArrayList, int paramInt) {}
  
  public void a(List<AcsMsg> paramList)
  {
    Object localObject = new CopyOnWriteArrayList(paramList);
    paramList = new Bundle();
    paramList.putSerializable("list", (Serializable)localObject);
    paramList.putSerializable("models", this.a);
    paramList.putInt("count", this.b);
    localObject = this.c.a.obtainMessage();
    ((Message)localObject).obj = paramList;
    ((Message)localObject).what = 2;
    this.c.a.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity.3
 * JD-Core Version:    0.7.0.1
 */