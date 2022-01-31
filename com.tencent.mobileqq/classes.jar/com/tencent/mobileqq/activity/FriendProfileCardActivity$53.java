package com.tencent.mobileqq.activity;

import ajxl;
import aukp;
import aukq;
import auvf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;

class FriendProfileCardActivity$53
  implements Runnable
{
  FriendProfileCardActivity$53(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = ((ajxl)this.this$0.app.getManager(51)).b(this.this$0.app.getCurrentAccountUin());
    if (localObject == null) {
      this.this$0.i = "-1";
    }
    for (;;)
    {
      this.this$0.i = "-1";
      return;
      if (((Card)localObject).lCurrentStyleId == auvf.a)
      {
        localObject = (QZoneCover)this.this$0.app.getEntityManagerFactory().createEntityManager().a(QZoneCover.class, this.this$0.app.getCurrentAccountUin());
        if (localObject != null) {
          this.this$0.i = ((QZoneCover)localObject).type;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.53
 * JD-Core Version:    0.7.0.1
 */