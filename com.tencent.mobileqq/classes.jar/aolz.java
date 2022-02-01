import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Map;

public class aolz
{
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public aolz(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
  }
  
  public void a(Friends paramFriends)
  {
    ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramFriends);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends.name = paramFriendInfo.nick;
    paramFriends.remark = paramFriendInfo.remark;
    paramFriends.uin = String.valueOf(paramFriendInfo.friendUin);
    paramFriends.groupid = paramFriendInfo.groupId;
    paramFriends.cSpecialFlag = paramFriendInfo.cSpecialFlag;
    if (paramFriendInfo.cSpecialFlag < 0)
    {
      QLog.i("Q.contacttab.friend.FriendInfoSingleUpdater", 1, "infoResp.cSpecialFlag is 0xFF");
      paramFriends.cSpecialFlag = 0;
    }
    paramFriends.detalStatusFlag = paramFriendInfo.detalStatusFlag;
    paramFriends.alias = paramFriendInfo.sShowName;
    paramFriends.iTermType = paramFriendInfo.iTermType;
    paramFriends.abilityBits = paramFriendInfo.uAbiFlag;
    paramFriends.netTypeIconId = paramFriendInfo.eIconType;
    paramFriends.strTermDesc = paramFriendInfo.strTermDesc;
    paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
    paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
    if (paramFriends.eNetwork != paramFriendInfo.eNetworkType)
    {
      paramFriends.eNetwork = paramFriendInfo.eNetworkType;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(13, true, null);
    }
    paramFriends.setShieldFlag(false);
    Object localObject1 = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject2 = ((anvk)localObject1).e(paramFriends.uin);
    if (localObject2 != null)
    {
      if (((Friends)localObject2).gathtertype != 1) {
        break label819;
      }
      paramFriends.gathtertype = 1;
      paramFriends.age = ((Friends)localObject2).age;
      paramFriends.smartRemark = ((Friends)localObject2).smartRemark;
      paramFriends.gender = ((Friends)localObject2).gender;
      paramFriends.recommReason = ((Friends)localObject2).recommReason;
      if (((((Friends)localObject2).gathtertype == 1) || (((Friends)localObject2).gathtertype == 2)) && (QLog.isColorLevel())) {
        QLog.i("Q.contacttab.friend.FriendInfoSingleUpdater", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + paramFriends.gathtertype + " | friend.age = " + paramFriends.age + " | friend.recommReason = " + paramFriends.recommReason);
      }
    }
    localObject1 = ((anvk)localObject1).e(paramFriends.uin);
    localObject2 = paramFriendInfo.oVipInfo;
    int j = EVIPSPEC.E_SP_QQVIP.value();
    int i;
    if (localObject1 != null)
    {
      i = ((Friends)localObject1).qqVipInfo;
      label355:
      paramFriends.qqVipInfo = aolb.a((VipBaseInfo)localObject2, j, i);
      localObject2 = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localObject1 == null) {
        break label841;
      }
      i = ((Friends)localObject1).superQqInfo;
      label392:
      paramFriends.superQqInfo = aolb.a((VipBaseInfo)localObject2, j, i);
      localObject2 = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject1 == null) {
        break label846;
      }
      i = ((Friends)localObject1).superVipInfo;
      label429:
      paramFriends.superVipInfo = aolb.a((VipBaseInfo)localObject2, j, i);
      localObject2 = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_BIGCLUB.value();
      if (localObject1 == null) {
        break label851;
      }
      i = ((Friends)localObject1).bigClubInfo;
      label466:
      paramFriends.bigClubInfo = aolb.a((VipBaseInfo)localObject2, j, i);
      paramFriends.cNewLoverDiamondFlag = paramFriendInfo.cNewLoverDiamondFlag;
      if ((paramFriendInfo.oVipInfo != null) && (paramFriendInfo.oVipInfo.mOpenInfo != null))
      {
        localObject2 = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject2 != null) {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject2).lNameplateId);
        }
        localObject2 = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localObject2 != null) {
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject2).lNameplateId);
        }
        if (localObject1 != null)
        {
          ((Friends)localObject1).nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
          ((Friends)localObject1).grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
        }
      }
      paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
      paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
      paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
      if (paramFriendInfo.cKingOfGloryFlag != 1) {
        break label856;
      }
    }
    label819:
    label841:
    label846:
    label851:
    label856:
    for (boolean bool = true;; bool = false)
    {
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      if ((!TextUtils.isEmpty(paramFriends.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramFriends.uin))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (localObject1 != null)
      {
        paramFriends.datetime = ((Friends)localObject1).datetime;
        paramFriends.lastLoginType = ((Friends)localObject1).lastLoginType;
        if (((Friends)localObject1).gathtertype == 1)
        {
          paramFriends.gender = ((Friends)localObject1).gender;
          paramFriends.age = ((Friends)localObject1).age;
          paramFriends.smartRemark = ((Friends)localObject1).smartRemark;
          paramFriends.recommReason = ((Friends)localObject1).recommReason;
        }
      }
      bjxa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriends);
      return;
      if (((Friends)localObject2).gathtertype != 2) {
        break;
      }
      paramFriends.gathtertype = 2;
      break;
      i = 0;
      break label355;
      i = 0;
      break label392;
      i = 0;
      break label429;
      i = 0;
      break label466;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolz
 * JD-Core Version:    0.7.0.1
 */