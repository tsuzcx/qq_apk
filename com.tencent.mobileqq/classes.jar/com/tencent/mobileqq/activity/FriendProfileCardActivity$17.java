package com.tencent.mobileqq.activity;

import android.os.Message;
import aymd;
import bkys;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$17
  implements Runnable
{
  FriendProfileCardActivity$17(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = (aymd)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((aymd)localObject).a(100601);
    if ((((aymd)localObject).a(localRedTouchItem, false)) && (localRedTouchItem.passThroughLevel > 0))
    {
      localObject = this.this$0.b.obtainMessage();
      ((Message)localObject).what = 14;
      ((Message)localObject).arg1 = 2;
      this.this$0.b.sendMessageDelayed((Message)localObject, 300L);
      if (QLog.isColorLevel()) {
        QLog.d("FriendProfileCardActivity", 2, "update red touch of like ranking list");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.17
 * JD-Core Version:    0.7.0.1
 */