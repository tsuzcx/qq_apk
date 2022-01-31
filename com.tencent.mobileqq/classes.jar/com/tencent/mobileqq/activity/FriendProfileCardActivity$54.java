package com.tencent.mobileqq.activity;

import alto;
import awgf;
import awgg;
import awra;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QZoneCover;

class FriendProfileCardActivity$54
  implements Runnable
{
  FriendProfileCardActivity$54(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    Object localObject = ((alto)this.this$0.app.getManager(51)).b(this.this$0.app.getCurrentAccountUin());
    if (localObject == null) {
      this.this$0.i = "-1";
    }
    for (;;)
    {
      this.this$0.i = "-1";
      return;
      if (((Card)localObject).lCurrentStyleId == awra.a)
      {
        localObject = (QZoneCover)this.this$0.app.getEntityManagerFactory().createEntityManager().a(QZoneCover.class, this.this$0.app.getCurrentAccountUin());
        if (localObject != null) {
          this.this$0.i = ((QZoneCover)localObject).type;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.54
 * JD-Core Version:    0.7.0.1
 */