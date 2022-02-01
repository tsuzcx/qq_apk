package com.tencent.mobileqq.activity.contacts.friend;

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
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onGroupDataInited()
  {
    FriendFragment.a(this.a, 1400L, true);
  }
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetSpecialCareSwitch_global isSuccess: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.a != null) {
      this.a.a.notifyDataSetChanged();
    }
    if ((paramBoolean) && (this.a.isResumed())) {
      try
      {
        localObject = (String[])paramArrayOfObject[1];
        paramArrayOfObject = (boolean[])paramArrayOfObject[2];
        if (QLog.isColorLevel()) {
          QLog.d("contacts.fragment.FriendFragment", 2, new Object[] { "onSetSpecialCareSwitch_global uinArray=%s stateArray=%s", Arrays.toString((Object[])localObject), Arrays.toString(paramArrayOfObject) });
        }
        if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
        {
          if (paramArrayOfObject[0] != 0)
          {
            QQToast.a(this.a.getBaseActivity(), 2, HardCodeUtil.a(2131704967), 0).a();
            return;
          }
          QQToast.a(this.a.getBaseActivity(), 2, HardCodeUtil.a(2131704968), 0).a();
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
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("onUpdateDelFriend isSucess= ");
      paramObject.append(paramBoolean);
      QLog.d("contacts.fragment.FriendFragment", 2, paramObject.toString());
    }
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.a;
    boolean bool;
    if ((!paramBoolean2) && (paramBoolean1)) {
      bool = false;
    } else {
      bool = true;
    }
    FriendFragment.a((FriendFragment)localObject, bool);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateFriendList isSucess= ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(",isComplete=");
      ((StringBuilder)localObject).append(paramBoolean2);
      QLog.d("contacts.fragment.FriendFragment", 2, ((StringBuilder)localObject).toString());
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
      localObject = this.a;
      long l;
      if (FriendFragment.b((FriendFragment)localObject)) {
        l = 0L;
      } else {
        l = 1400L;
      }
      FriendFragment.a((FriendFragment)localObject, l, true);
    }
    if ((!paramBoolean2) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramBoolean3)) {
      FriendFragment.a(this.a, 0L, true);
    }
  }
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    FriendFragment.a(this.a, 1400L, false);
  }
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    if ((paramString != null) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean)
  {
    if (paramBoolean) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, true);
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    if ((paramBoolean) && (FriendFragment.b(this.a))) {
      FriendFragment.a(this.a, 1400L, false);
    }
  }
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onUpdateSpecialCareList isSucess= ");
      paramList.append(paramBoolean1);
      paramList.append(",isComplete=");
      paramList.append(paramBoolean2);
      QLog.d("contacts.fragment.FriendFragment", 2, paramList.toString());
    }
    if ((paramBoolean1) && (this.a.a != null)) {
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.FriendFragment.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */