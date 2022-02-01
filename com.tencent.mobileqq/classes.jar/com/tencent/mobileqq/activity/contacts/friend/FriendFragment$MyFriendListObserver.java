package com.tencent.mobileqq.activity.contacts.friend;

import android.os.Bundle;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment.RefreshDataListener;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FriendFragment$MyFriendListObserver
  extends FriendListObserver
{
  private FriendFragment$MyFriendListObserver(FriendFragment paramFriendFragment) {}
  
  public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onGroupDataInited()
  {
    FriendFragment.a(this.a, 1400L, true);
  }
  
  public void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global isSuccess: " + paramBoolean);
    }
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      try
      {
        String[] arrayOfString = (String[])paramArrayOfObject[1];
        paramArrayOfObject = (boolean[])paramArrayOfObject[2];
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.FriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString(arrayOfString), Arrays.toString(paramArrayOfObject) });
        }
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
        {
          if (paramArrayOfObject[0] != 0)
          {
            QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131704891), 0).a();
            return;
          }
          QQToast.a(this.a.getActivity(), 2, HardCodeUtil.a(2131704892), 0).a();
          return;
        }
      }
      catch (Exception paramArrayOfObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("contacts.fragment.FriendFragment", 2, "onSetSpecialCareSwitch_global fail!", paramArrayOfObject);
        }
      }
    }
  }
  
  public void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateAddFriend isSucess= " + paramBoolean1 + ",addSuccess=" + paramBoolean2 + " addDirect=" + paramBoolean3);
    }
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateDelFriend isSucess= " + paramBoolean);
    }
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    FriendFragment localFriendFragment = this.a;
    boolean bool;
    if ((paramBoolean2) || (!paramBoolean1))
    {
      bool = true;
      FriendFragment.a(localFriendFragment, bool);
      if (QLog.isColorLevel()) {
        QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateFriendList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
      }
      paramBoolean2 = FriendFragment.a(this.a);
      if (FriendFragment.a(this.a))
      {
        if (FriendFragment.b(this.a))
        {
          FriendFragment.b(this.a, false);
          if (FriendFragment.a(this.a) != null) {
            FriendFragment.b(this.a).a(this.a.b(), paramBoolean1, null);
          }
        }
        localFriendFragment = this.a;
        if (!FriendFragment.b(this.a)) {
          break label189;
        }
      }
    }
    label189:
    for (long l = 0L;; l = 1400L)
    {
      FriendFragment.a(localFriendFragment, l, true);
      if ((!paramBoolean2) && (FriendFragment.b(this.a))) {
        FriendFragment.a(this.a, 1400L, true);
      }
      return;
      bool = false;
      break;
    }
  }
  
  public void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 0L, true);
    }
  }
  
  public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    FriendFragment.a(this.a, 1400L, false);
  }
  
  public void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  public void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateOlympicTorchList(boolean paramBoolean)
  {
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  public void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  public void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("contacts.fragment.FriendFragment", 2, "onUpdateSpecialCareList isSucess= " + paramBoolean1 + ",isComplete=" + paramBoolean2);
    }
    if ((paramBoolean1) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */