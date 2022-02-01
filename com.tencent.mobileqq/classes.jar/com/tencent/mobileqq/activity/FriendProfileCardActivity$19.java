package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class FriendProfileCardActivity$19
  implements Runnable
{
  FriendProfileCardActivity$19(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = (LocalRedTouchManager)this.this$0.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    RedTouchItem localRedTouchItem = ((LocalRedTouchManager)localObject).a(100601);
    if ((((LocalRedTouchManager)localObject).a(localRedTouchItem, false)) && (localRedTouchItem.passThroughLevel > 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.19
 * JD-Core Version:    0.7.0.1
 */