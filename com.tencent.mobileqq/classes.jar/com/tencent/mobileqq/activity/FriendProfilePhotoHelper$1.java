package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

class FriendProfilePhotoHelper$1
  implements Runnable
{
  FriendProfilePhotoHelper$1(FriendProfilePhotoHelper paramFriendProfilePhotoHelper) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = (FriendsManager)this.this$0.b.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Object localObject2 = ((FriendsManager)localObject1).f(this.this$0.b.getCurrentAccountUin());
      if (localObject2 == null) {
        return;
      }
      if (((Card)localObject2).checkCoverUrl(this.this$0.j)) {
        ((Card)localObject2).updateCoverData(this.this$0.j);
      }
      ((FriendsManager)localObject1).a((Card)localObject2);
      localObject1 = ((Card)localObject2).getCoverData(this.this$0.l);
      localObject2 = (String)localObject1[0];
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals(this.this$0.k)))
      {
        this.this$0.k = ((String)localObject2);
        this.this$0.l = ((Integer)localObject1[1]).intValue();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePhotoHelper.1
 * JD-Core Version:    0.7.0.1
 */