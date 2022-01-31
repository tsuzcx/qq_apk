package com.tencent.mobileqq.activity;

import ajxn;
import android.os.Message;
import auuw;
import bfnk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class FriendProfileCardActivity$41
  implements Runnable
{
  FriendProfileCardActivity$41(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    int j = 0;
    Object localObject = (ajxn)this.this$0.app.getManager(51);
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label164;
      }
      localObject = new Card();
    }
    label164:
    for (int i = 1;; i = 0)
    {
      ((Card)localObject).feedPreviewTime = System.currentTimeMillis();
      ((Card)localObject).strQzoneFeedsDesc = "";
      Message localMessage = Message.obtain();
      localMessage.obj = localObject;
      if (i != 0) {}
      for (localMessage.what = 6;; localMessage.what = 5)
      {
        if (this.this$0.jdField_a_of_type_Bfnk != null) {
          this.this$0.jdField_a_of_type_Bfnk.sendMessage(localMessage);
        }
        i = j;
        if (this.this$0.jdField_a_of_type_Auuw.a != null) {
          i = this.this$0.jdField_a_of_type_Auuw.a.h;
        }
        this.this$0.h(i);
        return;
        localObject = ((ajxn)localObject).b(this.this$0.jdField_a_of_type_Auuw.a.a);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.41
 * JD-Core Version:    0.7.0.1
 */