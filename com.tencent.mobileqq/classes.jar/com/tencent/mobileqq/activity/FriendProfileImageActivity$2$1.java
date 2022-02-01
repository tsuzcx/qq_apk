package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class FriendProfileImageActivity$2$1
  implements Runnable
{
  FriendProfileImageActivity$2$1(FriendProfileImageActivity.2 param2, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    this.b.this$0.r.setVisibility(0);
    ((AvatarPendantManager)this.b.this$0.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.b.this$0.s).a(this.b.this$0.r, 1, PendantInfo.e, this.a.uin, this.a.pendantDiyId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2.1
 * JD-Core Version:    0.7.0.1
 */