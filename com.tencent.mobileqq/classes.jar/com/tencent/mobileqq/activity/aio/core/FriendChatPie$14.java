package com.tencent.mobileqq.activity.aio.core;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.mutualmark.oldlogic.ReCheckInHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class FriendChatPie$14
  extends FriendListObserver
{
  FriendChatPie$14(FriendChatPie paramFriendChatPie) {}
  
  public void onAddFriend(String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.b, 2, "onAddFriend");
    }
    FriendChatPie.a(this.a, false);
  }
  
  public void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqMutualmarkOldlogicReCheckInHelper.a(paramBoolean, paramString1, paramString2, paramInt);
  }
  
  public void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if (!paramBoolean) {
      QQToast.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getResources().getString(2131719077), 0).b(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getTitleBarHeight());
    }
  }
  
  public void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    super.onUpdateFriendInfo(paramString, paramBoolean);
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (paramString.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onUpdateHotFriendLevel");
      }
      this.a.E();
    }
  }
  
  public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.b, 2, "onUpdateHotFriendLevel");
      }
      this.a.E();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.14
 * JD-Core Version:    0.7.0.1
 */