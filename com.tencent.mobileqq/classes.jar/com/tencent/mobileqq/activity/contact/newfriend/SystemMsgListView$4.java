package com.tencent.mobileqq.activity.contact.newfriend;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.qphone.base.util.QLog;
import friendlist.EAddFriendSourceID;
import java.util.ArrayList;

class SystemMsgListView$4
  extends FriendListObserver
{
  SystemMsgListView$4(SystemMsgListView paramSystemMsgListView) {}
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetConnectionsPerson " + paramBoolean + " " + paramInt1 + " " + paramInt2);
    }
    if (paramBoolean)
    {
      localTabLayoutStatus = SystemMsgListView.a(this.a).a();
      if ((localTabLayoutStatus != null) && (localTabLayoutStatus.a()) && (localTabLayoutStatus.a == paramInt2) && (!SystemMsgListView.a(this.a, paramInt2, paramInt3))) {
        SystemMsgListView.a(this.a).a(0L);
      }
    }
    while (paramInt1 != 1205)
    {
      TabLayoutStatus localTabLayoutStatus;
      return;
    }
    SystemMsgListView.a(this.a).a(0L);
  }
  
  public void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.newfriendSystemMsgListView", 2, "onGetMayKnowRecommend " + paramBoolean);
    }
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).c();
    }
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (paramBoolean1)
    {
      paramString = paramBundle.getString("uin");
      int i = paramBundle.getInt("source_id");
      paramBundle = paramBundle.getString("extra");
      if (((i == 3006) || (i == 3075)) && ("ContactMatchBuilder".equals(paramBundle))) {
        this.a.a(paramString);
      }
      if (EAddFriendSourceID.a(i)) {
        SystemMsgListView.a(this.a).c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.4
 * JD-Core Version:    0.7.0.1
 */