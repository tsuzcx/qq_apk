package com.tencent.mobileqq.activity.aio.core;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.mutualmark.oldlogic.ReCheckInHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FriendChatPie$12
  extends FriendListObserver
{
  FriendChatPie$12(FriendChatPie paramFriendChatPie) {}
  
  protected void onAddFriend(String paramString)
  {
    if (!this.a.ah.b.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.c, 2, "onAddFriend");
    }
    FriendChatPie.a(this.a, false);
  }
  
  protected void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.a.bk.a(paramBoolean, paramString1, paramString2, paramInt);
  }
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean) {
      QQToast.makeText(this.a.f, this.a.f.getResources().getString(2131916300), 0).show(this.a.f.getTitleBarHeight());
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    super.onUpdateFriendInfo(paramString, paramBoolean);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.contains(this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onUpdateHotFriendLevel");
      }
      this.a.bz();
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onUpdateHotFriendLevel");
      }
      this.a.bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.12
 * JD-Core Version:    0.7.0.1
 */