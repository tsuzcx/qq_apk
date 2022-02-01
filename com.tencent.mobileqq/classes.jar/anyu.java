import QQService.SvcDevLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;
import com.tencent.mobileqq.app.FriendListHandler.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SysSuspiciousMsg;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import tencent.im.oidb.cmd0x777.cmd0x777.AddFrdInfo;

public class anyu
  implements anui
{
  public static final String ADD_DIRECT = "addDirect";
  public static final int ERROR_INVITE_BAD_USERS = 9;
  public static final int ERROR_INVITE_FRIENDS_FORBIDDEN = 7;
  public static final int ERROR_INVITE_FRIENDS_FREQUENT = 1;
  static int[] NOTIFY_TYPES_1 = { 121, 123, 124, 125, 126, 127, 128, 129, 132, 133 };
  static int[] NOTIFY_TYPES_2 = { 112, 122, 68, 117, 56, 96, 97, 98, 130, 131, 100 };
  static int[] NOTIFY_TYPES_3 = { 51, 61, 62, 52, 49, 73, 27, 104, 65, 64 };
  static int[] NOTIFY_TYPES_4 = { 103, 105, 106, 107, 110, 111, 113, 114, 115 };
  static int[] NOTIFY_TYPES_5 = { 86, 92, 109, 108, 93, 95, 116, 118, 94, 101, 99 };
  static int[] NOTIFY_TYPES_6 = { 48, 76, 77, 74, 75, 78, 89, 79, 81, 82, 83, 84, 80, 90, 91, 85, 120 };
  static int[] NOTIFY_TYPES_7 = { 39, 50, 58, 59, 60, 69, 70, 63, 66, 18, 19, 21, 22, 71, 72 };
  static int[] NOTIFY_TYPES_8 = { 12, 13, 14, 15, 28, 33, 35, 37, 102, 38, 41, 42, 43, 44, 47 };
  static int[] NOTIFY_TYPES_9 = { 1, 2, 45, 4, 46, 5, 6, 30, 53, 3, 67, 7, 8, 9, 10, 11 };
  
  private static boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void onUpdateBatch1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_1, paramInt)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                    } while (!(paramObject instanceof Object[]));
                    paramObject = (Object[])paramObject;
                    switch (paramInt)
                    {
                    case 122: 
                    case 130: 
                    case 131: 
                    default: 
                      return;
                    case 121: 
                      onGetFriendsHasBindPhone(paramBoolean, ((Integer)paramObject[0]).intValue(), (List)paramObject[1]);
                      return;
                    case 123: 
                      onConversationRecommendTypeChange(((Integer)paramObject[0]).intValue());
                      return;
                    }
                  } while (paramObject.length <= 1);
                  onSuspiciousGetUnreadNum(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
                  return;
                } while (paramObject.length <= 3);
                onSuspiciousGetList(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1], (byte[])paramObject[2], paramObject[3]);
                return;
              } while (paramObject.length <= 1);
              onSuspiciousDel(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
              return;
            } while (paramObject.length <= 0);
            onSuspiciousClear(paramBoolean, ((Integer)paramObject[0]).intValue());
            return;
          } while (paramObject.length <= 0);
          onSuspiciousSendReadReport(paramBoolean, ((Integer)paramObject[0]).intValue());
          return;
        } while (paramObject.length <= 1);
        onAgreeSuspiciousMsg(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue());
        return;
      } while (paramObject.length <= 2);
      onGetConnectionsPerson(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
    } while (paramObject.length <= 1);
    onGetHeadInfoEmpty(paramBoolean, ((Integer)paramObject[0]).intValue(), (ArrayList)paramObject[1]);
  }
  
  private void onUpdateBatch2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_2, paramInt)) {}
    Object[] arrayOfObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof Object[]));
        arrayOfObject = (Object[])paramObject;
        switch (paramInt)
        {
        default: 
          return;
        case 56: 
          onUpdateFriendShieldFlag(((Long)arrayOfObject[0]).longValue(), ((Boolean)arrayOfObject[1]).booleanValue(), ((Boolean)arrayOfObject[2]).booleanValue(), ((Boolean)arrayOfObject[3]).booleanValue(), (String)arrayOfObject[4]);
          return;
        case 112: 
          paramObject = (Object[])paramObject;
          onAddBatchTroopFrd(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1]);
          return;
        }
      } while ((arrayOfObject == null) || (arrayOfObject.length != 1));
      onRecommendTroopJoinedOrDeleted((String)arrayOfObject[0]);
      return;
      paramInt = arrayOfObject.length;
      if (paramInt == 2)
      {
        onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)arrayOfObject[0]).longValue(), (String)arrayOfObject[1], null);
        return;
      }
    } while (paramInt != 3);
    onGetOnlineInfoByUinOrMobile(paramBoolean, ((Long)arrayOfObject[0]).longValue(), (String)arrayOfObject[1], (GetOnlineInfoResp)arrayOfObject[2]);
    return;
    if ((arrayOfObject != null) && (arrayOfObject.length == 3))
    {
      onReqRecheckInHotReactive(paramBoolean, (String)arrayOfObject[0], (String)arrayOfObject[1], ((Integer)arrayOfObject[2]).intValue());
      return;
    }
    onReqRecheckInHotReactive(false, "", "", 0);
    return;
    onSetSpecialCareSwitch_global(paramBoolean, arrayOfObject);
    return;
    onSetSpecialCareSwitch_specialRing(paramBoolean, arrayOfObject);
    return;
    onSetSpecialCareSwitch_qzone(paramBoolean, arrayOfObject);
    return;
    onSetHiddenChatSwitch(paramBoolean, arrayOfObject);
    return;
    onSetMessageNotification(paramBoolean, arrayOfObject);
    return;
    onSetSpecialCareSwitchesOfAPerson(paramBoolean, arrayOfObject);
  }
  
  private void onUpdateBatch3(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_3, paramInt)) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    switch (paramInt)
    {
    default: 
      return;
    case 27: 
      onSetComment(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Byte)paramObject[2]).byteValue());
      return;
    case 51: 
      onDelMultiDeResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 61: 
      onDelAuthDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 62: 
      onDelHistoryDevResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    case 52: 
      onKickOutDevFResult(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
      return;
    case 49: 
      onSearchFriendResult(paramBoolean, ((Integer)paramObject[0]).intValue(), paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Long)paramObject[5]).longValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7]);
      return;
    case 73: 
      onCondSearchFriendResult(((Long)paramObject[0]).longValue(), paramBoolean, paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
      return;
    case 104: 
      onStrangerHeadReady(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
      return;
    case 65: 
      onUpdateStrangerRichStatus(paramBoolean, (String[])paramObject[0], (Map)paramObject[1]);
      return;
    }
    onUpdateCircleRichStatus(paramBoolean, (String[])paramObject[0], (Bundle)paramObject[1]);
  }
  
  private void onUpdateBatch4(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_4, paramInt)) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          case 104: 
          case 108: 
          case 109: 
          case 112: 
          default: 
            return;
          case 103: 
            onGroupDataInited();
            return;
          }
        } while ((paramObject == null) || (!(paramObject instanceof String)));
        onAddReqStatesChanged(paramBoolean, (String)paramObject);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Boolean)));
      onUpdateOlympicTorchList(((Boolean)paramObject).booleanValue());
      return;
    } while ((paramObject == null) || (!(paramObject instanceof ArrayList)));
    onUpdateHotFriendLevel(paramBoolean, (ArrayList)paramObject);
    return;
    onAddBatchPhoneFriend(paramBoolean, (ArrayList)paramObject);
    return;
    onAddBatchQIMFriend(paramBoolean, (List)paramObject);
    return;
    if ((paramObject instanceof Bundle))
    {
      onMayKnowEntryStateChanged(paramBoolean, (Bundle)paramObject);
      return;
    }
    onMayKnowEntryStateChanged(paramBoolean, null);
    return;
    if ((paramObject instanceof List)) {
      try
      {
        onMayKnowListPushAdd(paramBoolean, (List)paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        onMayKnowListPushAdd(paramBoolean, null);
        return;
      }
    }
    onMayKnowListPushAdd(paramBoolean, null);
    return;
    if ((paramObject instanceof List)) {
      try
      {
        onMayKnowListPushDel(paramBoolean, (List)paramObject);
        return;
      }
      catch (Throwable paramObject)
      {
        onMayKnowListPushDel(paramBoolean, null);
        return;
      }
    }
    onMayKnowListPushDel(paramBoolean, null);
  }
  
  private void onUpdateBatch5(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_5, paramInt)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 86: 
      paramObject = (List)paramObject;
      if ((paramObject != null) && (paramObject.size() == 2))
      {
        onGetBothDongtaiPermissions(paramBoolean, ((Boolean)paramObject.get(0)).booleanValue(), ((Boolean)paramObject.get(1)).booleanValue());
        return;
      }
      onGetBothDongtaiPermissions(false, false, false);
      return;
    case 92: 
      if ((paramObject instanceof Bundle))
      {
        onGetMayKnowRecommend(paramBoolean, (Bundle)paramObject);
        return;
      }
      onGetMayKnowRecommend(paramBoolean, null);
      return;
    case 109: 
      onGetPushRecommend(paramBoolean);
      return;
    case 108: 
      onMayknowStateChanged(paramBoolean);
      return;
    case 93: 
      onCancelMayKnowRecommend(paramBoolean, (String)paramObject);
      return;
    case 95: 
      if (paramBoolean)
      {
        onGetSpecialCareRecommend(true, paramObject);
        return;
      }
      onGetSpecialCareRecommend(false, null);
      return;
    case 116: 
      onHideConversationMayKnowRecommend(paramBoolean, paramObject);
      return;
    case 118: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 3))
      {
        onReqLastChatTime(paramBoolean, (String)paramObject[0], (String)paramObject[1], Long.valueOf(((Long)paramObject[2]).longValue()));
        return;
      }
      onReqLastChatTime(false, "", "", Long.valueOf(0L));
      return;
    case 94: 
      onGetSigZanInfo(paramBoolean, paramObject);
      return;
    case 101: 
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
  }
  
  private void onUpdateBatch6(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_6, paramInt)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 48: 
      if (paramBoolean) {}
      for (boolean bool = ((Boolean)paramObject).booleanValue();; bool = true)
      {
        onUpdateLastLoginInfo(paramBoolean, bool);
        return;
      }
    case 76: 
      onSetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 77: 
      onGetVisibilityForNetWorkStatus(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 74: 
      paramObject = (Bundle)paramObject;
      onInfoOpenId(paramBoolean, paramObject.getString("uin"), paramObject.getString("nick_name"));
      return;
    case 75: 
      onGetFriendNickBatch(paramBoolean, paramObject);
      return;
    case 78: 
      onSetSpecialCareRing(paramBoolean, (Map)paramObject);
      return;
    case 89: 
      paramObject = (Object[])paramObject;
      onGetFriendDateNick(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
      return;
    case 79: 
      paramObject = (Object[])paramObject;
      onUpdateGatherFriendList(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue());
      return;
    case 81: 
      onSetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 82: 
      onGetNotAllowedSeeMyDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 83: 
      onSetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 84: 
      onGetShieldHisDongtai(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 80: 
      onUpdateRecommGatherFriendList(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    case 90: 
      onSetAsUncommonlyUsedContacts(paramBoolean, (List)paramObject);
      return;
    case 91: 
      onSetAsNormalContacts(paramBoolean, (List)paramObject);
      return;
    case 85: 
      onSetBothDongtaiPermissions(paramBoolean);
      return;
    }
    onAddFriendSecCheck(paramBoolean, (Bundle)paramObject);
  }
  
  private void onUpdateBatch7(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (!contains(NOTIFY_TYPES_7, paramInt)) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 18: 
        onAddGroupResp(paramBoolean, (GroupActionResp)paramObject);
        return;
      case 39: 
        onUpdateMobileQQHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
        return;
      case 50: 
        if (paramObject == null)
        {
          onGetMultiDevResult(false, null, null);
          return;
        }
        paramObject = (Object[])paramObject;
        onGetMultiDevResult(paramBoolean, (List)paramObject[0], (List)paramObject[1]);
        return;
      case 58: 
        onGetLoginDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
        return;
      case 59: 
        onGetHistoryDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
        return;
      case 60: 
        onGetAuthDevResult(paramBoolean, (SvcRspGetDevLoginInfo)paramObject);
        return;
      case 69: 
        if (paramBoolean)
        {
          onGetRecommendDeviceList(paramBoolean, (ArrayList)paramObject);
          return;
        }
        onGetRecommendDeviceList(paramBoolean, null);
        return;
      case 70: 
        onUpdateServerAuthDeviceList(paramBoolean);
        return;
      }
    } while ((!paramBoolean) || (paramObject == null) || (!(paramObject instanceof String)));
    onAddFriend((String)paramObject);
    return;
    onGetStrangerInfo(paramBoolean, paramObject);
    return;
    onRenameGroupResp(paramBoolean, (GroupActionResp)paramObject);
    return;
    onDeleteGroupResp(paramBoolean, (GroupActionResp)paramObject);
    return;
    onResortGroupResp(paramBoolean, (GroupActionResp)paramObject);
    return;
    paramObject = (Bundle)paramObject;
    long l = paramObject.getLong("uin");
    int j = paramObject.getInt("safety_flag");
    int i = 146;
    if (paramInt == 72) {
      i = 147;
    }
    onQueryUinSafetyFlag(paramBoolean, l, i, j);
  }
  
  private void onUpdateBatch8(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    if (!contains(NOTIFY_TYPES_8, paramInt)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 12: 
      onUpdateAddFriendSetting(paramBoolean, (Bundle)paramObject);
      return;
    case 13: 
      onUpdateOnlineFriend(paramBoolean, (String[])paramObject);
      return;
    case 14: 
      onUpdateGetVideoAbility(paramBoolean);
      return;
    case 15: 
      onUpdateDelFriend(paramBoolean, paramObject);
      return;
    case 28: 
      onSetSelfSignatureResult(paramBoolean);
      return;
    case 33: 
      paramObject = (Bundle)paramObject;
      String str = paramObject.getString("uin");
      if (paramBoolean)
      {
        onGetAutoInfo(true, str, paramObject.getString("nick_name"), paramObject.getInt("group_id", 0));
        return;
      }
      onGetAutoInfo(false, str, "", 0);
      return;
    case 35: 
      boolean bool1 = bool2;
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        bool1 = bool2;
        if (paramObject.length == 1)
        {
          bool1 = bool2;
          if ((paramObject[0] instanceof Boolean)) {
            bool1 = ((Boolean)paramObject[0]).booleanValue();
          }
        }
      }
      onGetGenralSettings(paramBoolean, bool1);
      return;
    case 37: 
      onSetGenralSettings(paramBoolean, (ArrayList)paramObject);
      return;
    case 102: 
      onPullIpad();
      return;
    case 38: 
      onSetGenralSettingsTroopFilter(paramBoolean, (Map)paramObject);
      return;
    case 41: 
      onSetGenralSettingsTroopRing(paramBoolean, (Map)paramObject);
      return;
    case 42: 
      onSetGenralSettingsTroopVibrate(paramBoolean, (Map)paramObject);
      return;
    case 43: 
      onSetGenralSettingsALLRing(paramBoolean, (Map)paramObject);
      return;
    case 44: 
      onSetGenralSettingsALLVibrate(paramBoolean, (Map)paramObject);
      return;
    }
    onSetGeneralSettingsC2CRoaming(paramBoolean, (Map)paramObject);
  }
  
  private void onUpdateBatch9(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    if (!contains(NOTIFY_TYPES_9, paramInt)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      bool1 = bool2;
      if (paramBoolean)
      {
        bool1 = bool2;
        if (((Boolean)paramObject).booleanValue()) {
          bool1 = true;
        }
      }
      onUpdateFriendList(paramBoolean, bool1);
      return;
    case 2: 
      onUpdateSignature(paramBoolean, (String[])paramObject);
      return;
    case 45: 
      onGetHeadInfo(paramBoolean, (Setting)paramObject);
      return;
    case 4: 
      onUpdateCustomHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
      return;
    case 46: 
      onGetStoreFace(paramBoolean, (HashSet)paramObject);
      return;
    case 5: 
      paramObject = (Object[])paramObject;
      onUpdateStrangerHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 6: 
      paramObject = (Object[])paramObject;
      onUpdateQCallHead(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue());
      return;
    case 30: 
      onUpdateTroopHead(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
      return;
    case 53: 
      paramObject = (Bundle)paramObject;
      onUpdateTroopHeadDownloadUrl(paramBoolean, paramObject.getString("troopUin"), paramObject.getString("url"));
      return;
    case 3: 
      onUpdateFriendInfo((String)paramObject, paramBoolean);
      return;
    case 67: 
      onUpdateFriendInfoFinished((ArrayList)paramObject, paramBoolean);
      return;
    case 7: 
      onUpdateRecentList();
      return;
    case 8: 
      onUpdateC2ChatStatus(paramBoolean, (HashMap)paramObject);
      return;
    case 9: 
      if (paramBoolean)
      {
        paramObject = (Object[])paramObject;
        onUpdateMoveGroup((String)paramObject[0], ((Byte)paramObject[1]).byteValue(), ((Byte)paramObject[2]).byteValue());
        return;
      }
      onUpdateMoveGroup(null, (byte)0, (byte)0);
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
    }
    paramObject = (Bundle)paramObject;
    String str = paramObject.getString("uin");
    paramInt = paramObject.getInt("resultCode", 1);
    bool2 = paramObject.getBoolean("addDirect", false);
    if (paramInt == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      onUpdateAddFriend(paramBoolean, bool1, bool2, str, paramObject);
      return;
    }
  }
  
  public void onAddBatchPhoneFriend(boolean paramBoolean, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList) {}
  
  public void onAddBatchQIMFriend(boolean paramBoolean, List<Long> paramList) {}
  
  public void onAddBatchTroopFrd(boolean paramBoolean, String paramString, ArrayList<cmd0x777.AddFrdInfo> paramArrayList) {}
  
  protected void onAddFriend(String paramString) {}
  
  protected void onAddFriendSecCheck(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onAddReqStatesChanged(boolean paramBoolean, String paramString) {}
  
  public void onAgreeSuspiciousMsg(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void onCancelMayKnowRecommend(boolean paramBoolean, String paramString) {}
  
  protected void onCondSearchFriendResult(long paramLong, boolean paramBoolean, Object paramObject, int paramInt1, int paramInt2) {}
  
  public void onConversationRecommendTypeChange(int paramInt) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDelMultiDeResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp) {}
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onGetBothDongtaiPermissions(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onGetConnectionsPerson(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onGetFriendDateNick(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetFriendNickBatch(boolean paramBoolean, Object paramObject) {}
  
  public void onGetFriendsHasBindPhone(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onGetGenralSettings(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetHeadInfo(boolean paramBoolean, Setting paramSetting) {}
  
  public void onGetHeadInfoEmpty(boolean paramBoolean, int paramInt, List<String> paramList) {}
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo) {}
  
  protected void onGetMayKnowRecommend(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onGetMultiDevResult(boolean paramBoolean, List<SvcDevLoginInfo> paramList1, List<SvcDevLoginInfo> paramList2) {}
  
  protected void onGetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetOnlineInfoByUinOrMobile(boolean paramBoolean, long paramLong, String paramString, GetOnlineInfoResp paramGetOnlineInfoResp) {}
  
  protected void onGetPushRecommend(boolean paramBoolean) {}
  
  protected void onGetRecommendDeviceList(boolean paramBoolean, ArrayList<amsh> paramArrayList) {}
  
  protected void onGetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetSigZanInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetSpecialCareRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetStoreFace(boolean paramBoolean, HashSet<String> paramHashSet) {}
  
  protected void onGetStrangerInfo(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGroupDataInited() {}
  
  protected void onHideConversationMayKnowRecommend(boolean paramBoolean, Object paramObject) {}
  
  protected void onInfoOpenId(boolean paramBoolean, String paramString1, String paramString2) {}
  
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
  
  protected void onSearchFriendResult(boolean paramBoolean1, int paramInt1, Object paramObject, int paramInt2, String paramString, boolean paramBoolean2, long paramLong, int paramInt3, List<bcfq> paramList) {}
  
  protected void onSetAsNormalContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetAsUncommonlyUsedContacts(boolean paramBoolean, List<String> paramList) {}
  
  protected void onSetBothDongtaiPermissions(boolean paramBoolean) {}
  
  protected void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte) {}
  
  protected void onSetGeneralSettingsC2CRoaming(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettings(boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  protected void onSetGenralSettingsALLRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsALLVibrate(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetGenralSettingsTroopVibrate(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageNotification(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetMessageRaoam(boolean paramBoolean) {}
  
  protected void onSetNotAllowedSeeMyDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean) {}
  
  protected void onSetShieldHisDongtai(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSpecialCareRing(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  protected void onSetSpecialCareSwitch_global(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_qzone(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitch_specialRing(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetSpecialCareSwitchesOfAPerson(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void onSetVisibilityForNetWorkStatus(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onStrangerHeadReady(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
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
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle) {}
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle) {}
  
  protected void onUpdateAnswerAddedFriend(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onUpdateC2ChatStatus(boolean paramBoolean, HashMap<String, String> paramHashMap) {}
  
  protected void onUpdateCircleRichStatus(boolean paramBoolean, String[] paramArrayOfString, Bundle paramBundle) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateDelFriend(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateFriendInfoFinished(ArrayList paramArrayList, boolean paramBoolean) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Shield", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " isSetOrClear:" + paramBoolean1 + " isSuc:" + paramBoolean2 + " isPush:" + paramBoolean3 + " errMsg:" + paramString);
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  protected void onUpdateGetVideoAbility(boolean paramBoolean) {}
  
  protected void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList) {}
  
  protected void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateMobileQQHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateMoveGroup(String paramString, byte paramByte1, byte paramByte2) {}
  
  protected void onUpdateOlympicTorchList(boolean paramBoolean) {}
  
  protected void onUpdateOnlineFriend(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateRecommGatherFriendList(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onUpdateServerAuthDeviceList(boolean paramBoolean) {}
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onUpdateSpecialCareList(boolean paramBoolean1, boolean paramBoolean2, List<SpecialCareInfo> paramList) {}
  
  protected void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2) {}
  
  protected void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap) {}
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateTroopHeadDownloadUrl(boolean paramBoolean, String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     anyu
 * JD-Core Version:    0.7.0.1
 */