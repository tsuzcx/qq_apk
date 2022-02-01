import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import friendlist.GetFriendListResp;
import friendlist.GroupInfo;
import java.util.ArrayList;
import java.util.Map;

public class aoqe
{
  public static void a(QQAppInterface paramQQAppInterface, GetFriendListResp paramGetFriendListResp)
  {
    boolean bool2 = true;
    int i = paramGetFriendListResp.startIndex;
    anyw localanyw = (anyw)paramQQAppInterface.getManager(51);
    VasFaceManager localVasFaceManager = ((bhzq)paramQQAppInterface.getManager(235)).a;
    gc localgc = (gc)paramQQAppInterface.getManager(42);
    boolean bool1;
    FriendInfo localFriendInfo;
    if ((paramGetFriendListResp.stSelfInfo != null) && (i == 0))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("Q.contacttab.friend.FriendListUpdateUtil", 2, "updateSelfOnRsp needUpdateSelf=" + bool1);
      }
      if (bool1)
      {
        localFriendInfo = paramGetFriendListResp.stSelfInfo;
        paramGetFriendListResp = localanyw.e(paramQQAppInterface.getCurrentAccountUin());
        if (paramGetFriendListResp != null) {
          break label733;
        }
        paramGetFriendListResp = new Friends();
        paramGetFriendListResp.name = localFriendInfo.nick;
        paramGetFriendListResp.remark = localFriendInfo.remark;
        paramGetFriendListResp.uin = String.valueOf(localFriendInfo.friendUin);
        paramGetFriendListResp.cSpecialFlag = localFriendInfo.cSpecialFlag;
        paramGetFriendListResp.detalStatusFlag = localFriendInfo.detalStatusFlag;
        paramGetFriendListResp.alias = localFriendInfo.sShowName;
        paramGetFriendListResp.iBatteryStatus = localFriendInfo.iBatteryStatus;
        paramGetFriendListResp.uExtOnlineStatus = localFriendInfo.uExtOnlineStatus;
        azlk.a(paramGetFriendListResp, localFriendInfo.vecMusicInfo, "GetFriendList(self)");
        azin.a(paramGetFriendListResp, localFriendInfo.vecExtOnlineBusinessInfo, "GetFriendList(self)");
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, new Object[] { "handleGetFriendList selfUin=" + paramGetFriendListResp.uin + ", cSpecialFlag=" + paramGetFriendListResp.cSpecialFlag, " battery:", Integer.valueOf(localFriendInfo.iBatteryStatus), " extOnline:", Long.valueOf(localFriendInfo.uExtOnlineStatus) });
        }
      }
    }
    label733:
    for (;;)
    {
      paramGetFriendListResp.abilityBits = localFriendInfo.uAbiFlag;
      paramGetFriendListResp.eNetwork = localFriendInfo.eNetworkType;
      paramGetFriendListResp.groupid = -1;
      paramGetFriendListResp.qqVipInfo = aopy.a(localFriendInfo.oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), paramGetFriendListResp.qqVipInfo);
      paramGetFriendListResp.superQqInfo = aopy.a(localFriendInfo.oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), paramGetFriendListResp.superQqInfo);
      paramGetFriendListResp.superVipInfo = aopy.a(localFriendInfo.oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), paramGetFriendListResp.superVipInfo);
      paramGetFriendListResp.bigClubInfo = aopy.a(localFriendInfo.oVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), paramGetFriendListResp.bigClubInfo);
      paramGetFriendListResp.cNewLoverDiamondFlag = localFriendInfo.cNewLoverDiamondFlag;
      if ((localFriendInfo.oVipInfo != null) && (localFriendInfo.oVipInfo.mOpenInfo != null))
      {
        VipOpenInfo localVipOpenInfo = (VipOpenInfo)localFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localVipOpenInfo != null) {
          paramGetFriendListResp.superVipTemplateId = ((int)localVipOpenInfo.lNameplateId);
        }
        localVipOpenInfo = (VipOpenInfo)localFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localVipOpenInfo != null) {
          paramGetFriendListResp.bigClubTemplateId = ((int)localVipOpenInfo.lNameplateId);
        }
        paramGetFriendListResp.nameplateVipType = localFriendInfo.oVipInfo.iNameplateVipType;
        paramGetFriendListResp.grayNameplateFlag = localFriendInfo.oVipInfo.iGrayNameplateFlag;
      }
      paramGetFriendListResp.namePlateOfKingGameId = localFriendInfo.uGameAppid;
      paramGetFriendListResp.namePlateOfKingLoginTime = localFriendInfo.uGameLastLoginTime;
      paramGetFriendListResp.namePlateOfKingDan = ((int)localFriendInfo.ulKingOfGloryRank);
      if (localFriendInfo.cKingOfGloryFlag == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramGetFriendListResp.namePlateOfKingDanDisplatSwitch = bool1;
        localanyw.a(paramGetFriendListResp);
        localVasFaceManager.b(paramGetFriendListResp.uin, (int)localFriendInfo.uFaceStoreId);
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler.selfFontEffect", 2, "self fontEffect: " + (int)localFriendInfo.uFontEffect);
        }
        localgc.a(paramGetFriendListResp.uin, (int)localFriendInfo.uFontEffect);
        paramQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + paramQQAppInterface.c(), paramGetFriendListResp.namePlateOfKingDanDisplatSwitch).apply();
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, GetFriendListResp paramGetFriendListResp, long paramLong)
  {
    paramQQAppInterface = (anyw)paramQQAppInterface.getManager(51);
    if (paramGetFriendListResp.vecGroupInfo != null)
    {
      int j = paramGetFriendListResp.vecGroupInfo.size();
      Groups[] arrayOfGroups = new Groups[j];
      int i = 0;
      while (i < j)
      {
        GroupInfo localGroupInfo = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i);
        Groups localGroups = new Groups();
        localGroups.group_id = localGroupInfo.groupId;
        localGroups.group_name = localGroupInfo.groupname;
        localGroups.group_friend_count = localGroupInfo.friend_count;
        localGroups.seqid = localGroupInfo.seqid;
        localGroups.datetime = paramLong;
        arrayOfGroups[i] = localGroups;
        i += 1;
      }
      if ((j > 0) && (QLog.isColorLevel()))
      {
        paramGetFriendListResp = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
        QLog.d("Q.contacttab.friend.FriendListUpdateUtil", 2, "handleGetFriendList " + bhjx.a(paramGetFriendListResp.groupname) + ", " + paramGetFriendListResp.friend_count + ", " + paramGetFriendListResp.sqqOnLine_count + ", " + paramGetFriendListResp.seqid);
      }
      paramQQAppInterface.a(arrayOfGroups);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i = 1;
    if (i < 19)
    {
      if ((!paramBoolean2) && (i == 16)) {}
      for (;;)
      {
        i += 1;
        break;
        if (((paramBoolean1) || (i != 18)) && (i != 13)) {
          paramQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i, paramLong).commit();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqe
 * JD-Core Version:    0.7.0.1
 */