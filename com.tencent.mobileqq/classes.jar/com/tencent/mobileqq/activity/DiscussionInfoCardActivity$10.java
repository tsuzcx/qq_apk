package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class DiscussionInfoCardActivity$10
  extends FriendListObserver
{
  DiscussionInfoCardActivity$10(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean)
    {
      this.a.a();
      paramString1 = this.a;
      DiscussionInfoCardActivity.a(paramString1, DiscussionInfoCardActivity.k(paramString1));
      DiscussionInfoCardActivity.r(this.a).notifyDataSetChanged();
      return;
    }
    if ((this.a.i != null) && (this.a.i.isShowing()) && (!this.a.isFinishing())) {
      this.a.i.dismiss();
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.a.h != null) && (this.a.h.ownerUin != null))
      {
        paramString = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a.h.ownerUin);
        localStringBuilder.append("");
        paramString = paramString.m(localStringBuilder.toString());
        if (paramString != null) {
          this.a.s = paramString.name;
        }
      }
    }
    else if (QLog.isColorLevel()) {
      QLog.d("DiscussionInfoCardActivity", 2, "onUpdateFriendInfo get owner name failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.10
 * JD-Core Version:    0.7.0.1
 */