package com.tencent.mobileqq.app;

import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.search.model.ISearchResultGroupModel;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;

public class FriendListObserver
  implements IFriendObserver
{
  public static final int ERROR_INVITE_BAD_USERS = 9;
  public static final int ERROR_INVITE_FRIENDS_FORBIDDEN = 7;
  public static final int ERROR_INVITE_FRIENDS_FREQUENT = 1;
  static int[] NOTIFY_TYPES_1 = { 118, 120, 121, 122, 123, 124, 125, 126, 129, 130 };
  static int[] NOTIFY_TYPES_2 = { 109, 119, 67, 114, 55, 94, 95, 96, 127, 128, 98 };
  static int[] NOTIFY_TYPES_3 = { 50, 60, 61, 51, 48, 72, 27, 64, 63 };
  static int[] NOTIFY_TYPES_4 = { 101, 111, 103, 104, 108, 112, 110 };
  static int[] NOTIFY_TYPES_5 = { 84, 90, 106, 105, 91, 93, 113, 115, 92, 99, 97 };
  static int[] NOTIFY_TYPES_6 = { 47, 75, 76, 83, 74, 87, 77, 79, 80, 81, 82, 78, 88, 89 };
  static int[] NOTIFY_TYPES_7 = { 49, 57, 58, 59, 68, 69, 62, 65, 18, 19, 21, 22, 70 };
  static int[] NOTIFY_TYPES_8 = { 13, 14, 15, 28, 100, 13, 28 };
  static int[] NOTIFY_TYPES_9 = { 1, 2, 46, 52, 3, 66, 7, 8, 9, 10, 11 };
  
  private static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void onUpdateBatch1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_1, paramInt)) {
      return;
    }
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    switch (paramInt)
    {
    case 119: 
    case 127: 
    case 128: 
    default: 
    case 130: 
      addFriendByContact(paramBoolean, paramObject);
      return;
    case 129: 
      if (paramObject.length > 2)
      {
        onGetConnectionsPerson(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
        return;
      }
      break;
    case 126: 
      if (paramObject.length > 1)
      {
        onAgreeSuspiciousMsg(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
        return;
      }
      break;
    case 125: 
      if (paramObject.length > 0)
      {
        onSuspiciousSendReadReport(paramBoolean, ((Integer)paramObject[0]).intValue());
        return;
      }
      break;
    case 124: 
      if (paramObject.length > 0)
      {
        onSuspiciousClear(paramBoolean, ((Integer)paramObject[0]).intValue());
        return;
      }
      break;
    case 123: 
      if (paramObject.length > 1)
      {
        onSuspiciousDel(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
        return;
      }
      break;
    case 122: 
      if (paramObject.length > 3)
      {
        onSuspiciousGetList(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (byte[])paramObject[2], paramObject[3]);
        return;
      }
      break;
    case 121: 
      if (paramObject.length > 1)
      {
        onSuspiciousGetUnreadNum(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
        return;
      }
      break;
    case 120: 
      onConversationRecommendTypeChange(((Integer)paramObject[0]).intValue());
      return;
    case 118: 
      onGetFriendsHasBindPhone(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
    }
  }
  
  private void onUpdateBatch2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_2, paramInt)) {
      return;
    }
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramInt != 55)
    {
      if (paramInt != 67)
      {
        if (paramInt != 98)
        {
          if (paramInt != 109)
          {
            if (paramInt != 114)
            {
              if (paramInt != 119)
              {
                if (paramInt != 127)
                {
                  if (paramInt != 128)
                  {
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 96: 
                      onSetSpecialCareSwitch_qzone(paramBoolean, paramObject);
                      return;
                    case 95: 
                      onSetSpecialCareSwitch_specialRing(paramBoolean, paramObject);
                      return;
                    }
                    onSetSpecialCareSwitch_global(paramBoolean, paramObject);
                    return;
                  }
                  onSetMessageNotification(paramBoolean, paramObject);
                  return;
                }
                onSetHiddenChatSwitch(paramBoolean, paramObject);
                return;
              }
              if ((paramObject != null) && (paramObject.length == 1)) {
                onRecommendTroopJoinedOrDeleted((String)paramObject[0]);
              }
            }
            else
            {
              if ((paramObject != null) && (paramObject.length == 3))
              {
                onReqRecheckInHotReactive(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
                return;
              }
              onReqRecheckInHotReactive(false, "", "", 0);
            }
          }
          else {
            onAddBatchTroopFrd(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1]);
          }
        }
        else {
          onSetSpecialCareSwitchesOfAPerson(paramBoolean, paramObject);
        }
      }
      else
      {
        paramInt = paramObject.length;
        if (paramInt == 2)
        {
          onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], null);
          return;
        }
        if (paramInt == 3) {
          onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (GetOnlineInfoResp)paramObject[2]);
        }
      }
    }
    else {
      onUpdateFriendShieldFlag(((Long)paramObject[0]).longValue(), ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
    }
  }
  
  private void onUpdateBatch3(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_3, paramInt)) {
      return;
    }
    if (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramInt != 27)
    {
      if (paramInt != 48)
      {
        if (paramInt != 72)
        {
          if (paramInt != 50)
          {
            if (paramInt != 51)
            {
              if (paramInt != 60)
              {
                if (paramInt != 61)
                {
                  if (paramInt != 63)
                  {
                    if (paramInt != 64) {
                      return;
                    }
                    onUpdateStrangerRichStatus(paramBoolean, (String[])paramObject[0], (Map)paramObject[1]);
                    return;
                  }
                  onUpdateCircleRichStatus(paramBoolean, (String[])paramObject[0], (Bundle)paramObject[1]);
                  return;
                }
                onDelHistoryDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                return;
              }
              onDelAuthDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
              return;
            }
            onKickOutDevFResult(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
            return;
          }
          onDelMultiDeResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
          return;
        }
        onCondSearchFriendResult(((Long)paramObject[0]).longValue(), paramBoolean, paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
        return;
      }
      onSearchFriendResult(paramBoolean, ((Integer)paramObject[0]).intValue(), paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Long)paramObject[5]).longValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7]);
      return;
    }
    onSetComment(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
  }
  
  private void onUpdateBatch4(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_4, paramInt)) {
      return;
    }
    if (paramInt != 101) {
      if (paramInt != 108) {
        if (paramInt != 103) {
          if (paramInt != 104) {
            switch (paramInt)
            {
            default: 
              return;
            case 112: 
              if (!(paramObject instanceof List)) {
                break;
              }
            }
          }
        }
      }
    }
    try
    {
      onMayKnowListPushDel(paramBoolean, (List)paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      label82:
      break label82;
    }
    onMayKnowListPushDel(paramBoolean, null);
    return;
    onMayKnowListPushDel(paramBoolean, null);
    return;
    if ((paramObject instanceof List)) {}
    try
    {
      onMayKnowListPushAdd(paramBoolean, (List)paramObject);
      return;
    }
    catch (Throwable paramObject)
    {
      label113:
      break label113;
    }
    onMayKnowListPushAdd(paramBoolean, null);
    return;
    onMayKnowListPushAdd(paramBoolean, null);
    return;
    if ((paramObject instanceof Bundle))
    {
      onMayKnowEntryStateChanged(paramBoolean, (Bundle)paramObject);
      return;
    }
    onMayKnowEntryStateChanged(paramBoolean, null);
    return;
    if ((paramObject != null) && ((paramObject instanceof ArrayList)))
    {
      onUpdateHotFriendLevel(paramBoolean, (ArrayList)paramObject);
      return;
      if ((paramObject != null) && ((paramObject instanceof Boolean)))
      {
        onUpdateOlympicTorchList(((Boolean)paramObject).booleanValue());
        return;
        onAddBatchQIMFriend(paramBoolean, (List)paramObject);
        return;
        onGroupDataInited();
      }
    }
  }
  
  private void onUpdateBatch5(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_5, paramInt)) {
      return;
    }
    if (paramInt != 84)
    {
      if (paramInt != 97)
      {
        if (paramInt != 99)
        {
          if (paramInt != 113)
          {
            if (paramInt != 115)
            {
              if (paramInt != 105)
              {
                if (paramInt != 106)
                {
                  switch (paramInt)
                  {
                  default: 
                    return;
                  case 93: 
                    if (paramBoolean)
                    {
                      onGetSpecialCareRecommend(true, paramObject);
                      return;
                    }
                    onGetSpecialCareRecommend(false, null);
                    return;
                  case 92: 
                    onGetSigZanInfo(paramBoolean, paramObject);
                    return;
                  case 91: 
                    onCancelMayKnowRecommend(paramBoolean, (String)paramObject);
                    return;
                  }
                  if ((paramObject instanceof Bundle))
                  {
                    onGetMayKnowRecommend(paramBoolean, (Bundle)paramObject);
                    return;
                  }
                  onGetMayKnowRecommend(paramBoolean, null);
                  return;
                }
                onGetPushRecommend(paramBoolean);
                return;
              }
              onMayknowStateChanged(paramBoolean);
              return;
            }
            paramObject = (Object[])paramObject;
            if ((paramObject != null) && (paramObject.length == 3))
            {
              onReqLastChatTime(paramBoolean, (String)paramObject[0], (String)paramObject[1], Long.valueOf(((Long)paramObject[2]).longValue()));
              return;
            }
            onReqLastChatTime(false, "", "", Long.valueOf(0L));
            return;
          }
          onHideConversationMayKnowRecommend(paramBoolean, paramObject);
          return;
        }
        onSetMessageRaoam(paramBoolean);
        return;
      }
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        onUpdateSpecialCareList(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1]);
        return;
      }
      onUpdateSpecialCareList(false, false, null);
      return;
    }
    paramObject = (List)paramObject;
    if ((paramObject != null) && (paramObject.size() == 2))
    {
      onGetBothDongtaiPermissions(paramBoolean, ((Boolean)paramObject.get(0)).booleanValue(), ((Boolean)paramObject.get(1)).booleanValue());
      return;
    }
    onGetBothDongtaiPermissions(false, false, false);
  }
  
  private void onUpdateBatch6(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_6, paramInt)) {
      return;
    }
    boolean bool = true;
    if (paramInt != 47)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        case 89: 
          onSetAsNormalContacts(paramBoolean, (List)paramObject);
          return;
        case 88: 
          onSetAsUncommonlyUsedContacts(paramBoolean, (List)paramObject);
          return;
        }
        paramObject = (Object[])paramObject;
        onGetFriendDateNick(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
        return;
      case 83: 
        onSetBothDongtaiPermissions(paramBoolean);
        return;
      case 82: 
        onGetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 81: 
        onSetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 80: 
        onGetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 79: 
        onSetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 78: 
        onUpdateRecommGatherFriendList(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 77: 
        paramObject = (Object[])paramObject;
        onUpdateGatherFriendList(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
        return;
      case 76: 
        onGetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      case 75: 
        onSetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
        return;
      }
      onGetFriendNickBatch(paramBoolean, paramObject);
      return;
    }
    if (paramBoolean) {
      bool = ((Boolean)paramObject).booleanValue();
    }
    onUpdateLastLoginInfo(paramBoolean, bool);
  }
  
  private void onUpdateBatch7(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_7, paramInt)) {
      return;
    }
    if (paramInt != 18)
    {
      if (paramInt != 19)
      {
        if (paramInt != 21)
        {
          if (paramInt != 22)
          {
            if (paramInt != 49)
            {
              if (paramInt != 62)
              {
                if (paramInt != 65)
                {
                  switch (paramInt)
                  {
                  default: 
                    switch (paramInt)
                    {
                    default: 
                      return;
                    case 70: 
                      paramObject = (Bundle)paramObject;
                      onQueryUinSafetyFlag(paramBoolean, paramObject.getLong("uin"), 146, paramObject.getInt("safety_flag"));
                      return;
                    case 69: 
                      onUpdateServerAuthDeviceList(paramBoolean);
                      return;
                    }
                    if (paramBoolean)
                    {
                      onGetRecommendDeviceList(paramBoolean, (ArrayList)paramObject);
                      return;
                    }
                    onGetRecommendDeviceList(paramBoolean, null);
                    return;
                  case 59: 
                    onGetAuthDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                  case 58: 
                    onGetHistoryDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                    return;
                  }
                  onGetLoginDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
                  return;
                }
                onGetStrangerInfo(paramBoolean, paramObject);
                return;
              }
              if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof String))) {
                onAddFriend((String)paramObject);
              }
            }
            else
            {
              if (paramObject == null)
              {
                onGetMultiDevResult(false, null, null);
                return;
              }
              paramObject = (Object[])paramObject;
              onGetMultiDevResult(paramBoolean, (List)paramObject[0], (List)paramObject[1]);
            }
          }
          else {
            onResortGroupResp(paramBoolean, (GroupActionResp)paramObject);
          }
        }
        else {
          onDeleteGroupResp(paramBoolean, (GroupActionResp)paramObject);
        }
      }
      else {
        onRenameGroupResp(paramBoolean, (GroupActionResp)paramObject);
      }
    }
    else {
      onAddGroupResp(paramBoolean, (GroupActionResp)paramObject);
    }
  }
  
  private void onUpdateBatch8(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_8, paramInt)) {
      return;
    }
    if (paramInt != 28)
    {
      if (paramInt != 100)
      {
        switch (paramInt)
        {
        default: 
          return;
        case 15: 
          onUpdateDelFriend(paramBoolean, paramObject);
          return;
        case 14: 
          onUpdateGetVideoAbility(paramBoolean);
          return;
        }
        onUpdateOnlineFriend(paramBoolean, (String[])paramObject);
        return;
      }
      onPullIpad();
      return;
    }
    onSetSelfSignatureResult(paramBoolean);
  }
  
  private void onUpdateBatch9(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_9, paramInt)) {
      return;
    }
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 46)
          {
            if (paramInt != 52)
            {
              if (paramInt != 66)
              {
                switch (paramInt)
                {
                default: 
                  return;
                case 10: 
                  if (paramBoolean)
                  {
                    paramObject = (Object[])paramObject;
                    onUpdateAnswerAddedFriend(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
                    return;
                  }
                  onUpdateAnswerAddedFriend(paramBoolean, "", 0);
                  return;
                case 9: 
                  paramObject = (Object[])paramObject;
                  if (paramBoolean)
                  {
                    onUpdateMoveGroup((String)paramObject[0], ((Byte)paramObject[1]).byteValue(), ((Byte)paramObject[2]).byteValue());
                    return;
                  }
                  onUpdateMoveGroup(null, (byte)0, (byte)0);
                  return;
                case 8: 
                  onUpdateC2ChatStatus(paramBoolean, (HashMap)paramObject);
                  return;
                }
                onUpdateRecentList();
                return;
              }
              onUpdateFriendInfoFinished((ArrayList)paramObject, paramBoolean);
              return;
            }
            paramObject = (Bundle)paramObject;
            onUpdateTroopHeadDownloadUrl(paramBoolean, paramObject.getString("troopUin"), paramObject.getString("url"));
            return;
          }
          onGetStoreFace(paramBoolean, (HashSet)paramObject);
          return;
        }
        onUpdateFriendInfo((String)paramObject, paramBoolean);
        return;
      }
      onUpdateSignature(paramBoolean, (String[])paramObject);
      return;
    }
    if ((!paramBoolean) || (!((Boolean)paramObject).booleanValue())) {
      bool = false;
    }
    onUpdateFriendList(paramBoolean, bool);
  }
  
  public void addFriendByContact(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
      onAddFriendByContact((String)paramArrayOfObject[0]);
    }
  }
  
  public void onAddBatchQIMFriend(boolean paramBoolean, List<Long> paramList) {}
  
  public void onAddBatchTroopFrd(boolean paramBoolean, String paramString, ArrayList<cmd0x777.AddFrdInfo> paramArrayList) {}
  
  protected void onAddFriend(String paramString) {}
  
  public void onAddFriendByContact(String paramString) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {}
  
  public void onConversationRecommendTypeChange(int paramInt) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelMultiDeResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetMultiDevResult(boolean paramBoolean, List<SvcDevLoginInfo> paramList1, List<SvcDevLoginInfo> paramList2) {}
  
  protected void onGetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  protected void onGetPushRecommend(boolean paramBoolean) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<DeviceLockItemInfo> paramArrayList) {}
  
  protected void onGetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetSpecialCareRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet) {}
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGroupDataInited() {}
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onKickOutDevFResult(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  protected void onMayKnowEntryStateChanged(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onMayKnowListPushAdd(boolean paramBoolean, List<MayKnowRecommend> paramList) {}
  
  protected void onMayKnowListPushDel(boolean paramBoolean, List<String> paramList) {}
  
  protected void onMayknowStateChanged(boolean paramBoolean) {}
  
  protected void onPullIpad() {}
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onRecommendTroopJoinedOrDeleted(String paramString) {}
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onReqLastChatTime(boolean paramBoolean, String paramString1, String paramString2, Long paramLong) {}
  
  protected void onReqRecheckInHotReactive(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<ISearchResultGroupModel> paramList) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetBothDongtaiPermissions(boolean paramBoolean) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageNotification(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageRaoam(boolean paramBoolean) {}
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean) {}
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onSuspiciousClear(boolean paramBoolean, int paramInt) {}
  
  public void onSuspiciousDel(boolean paramBoolean, int paramInt, long paramLong) {}
  
  public void onSuspiciousGetList(boolean paramBoolean, int paramInt, ArrayList<SysSuspiciousMsg> paramArrayList, byte[] paramArrayOfByte, Object paramObject) {}
  
  public void onSuspiciousGetUnreadNum(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void onSuspiciousSendReadReport(boolean paramBoolean, int paramInt) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdateBatch1(paramInt, paramBoolean, paramObject);
    onUpdateBatch2(paramInt, paramBoolean, paramObject);
    onUpdateBatch3(paramInt, paramBoolean, paramObject);
    onUpdateBatch4(paramInt, paramBoolean, paramObject);
    onUpdateBatch5(paramInt, paramBoolean, paramObject);
    onUpdateBatch6(paramInt, paramBoolean, paramObject);
    onUpdateBatch7(paramInt, paramBoolean, paramObject);
    onUpdateBatch8(paramInt, paramBoolean, paramObject);
    onUpdateBatch9(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap) {}
  
  protected void onUpdateCircleRichStatus(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("FriendShield : send_oidb_0x5d1_0 : uin : ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" isSetOrClear:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" isSuc:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(" isPush:");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(" errMsg:");
      localStringBuilder.append(paramString);
      QLog.d("Shield", 2, localStringBuilder.toString());
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onUpdateGetVideoAbility(boolean paramBoolean) {}
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2) {}
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean) {}
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateRecommGatherFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateServerAuthDeviceList(boolean paramBoolean) {}
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList) {}
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap) {}
  
  protected void onUpdateTroopHeadDownloadUrl(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListObserver
 * JD-Core Version:    0.7.0.1
 */