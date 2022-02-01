import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class aoqc
{
  private long jdField_a_of_type_Long;
  private anyw jdField_a_of_type_Anyw;
  aoqd jdField_a_of_type_Aoqd;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<Friends> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  Friends[] jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends;
  ArrayList<Friends> b;
  
  public aoqc(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean, aoqd paramaoqd)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends = paramArrayOfFriends;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_Aoqd = paramaoqd;
    this.jdField_a_of_type_Anyw = ((anyw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ExtensionInfoBatchUpdater", 2, "saveInBatch friendList size=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends.length);
    }
    anws localanws = (anws)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    Iterator localIterator;
    Friends localFriends;
    String str;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        localFriends = (Friends)localIterator.next();
        str = localFriends.name;
        aofp.a(Long.parseLong(localFriends.uin), str, localanws);
      }
    }
    if (this.b.size() > 0)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localFriends = (Friends)localIterator.next();
        str = localFriends.remark;
        aofp.b(Long.parseLong(localFriends.uin), str, localanws);
      }
    }
    this.jdField_a_of_type_Aoqd.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    int j = 0;
    paramFriends.uin = String.valueOf(paramFriendInfo.friendUin);
    paramFriends.name = paramFriendInfo.nick;
    paramFriends.remark = paramFriendInfo.remark;
    paramFriends.groupid = paramFriendInfo.groupId;
    paramFriends.cSpecialFlag = paramFriendInfo.cSpecialFlag;
    paramFriends.detalStatusFlag = paramFriendInfo.detalStatusFlag;
    paramFriends.datetime = this.jdField_a_of_type_Long;
    paramFriends.alias = paramFriendInfo.sShowName;
    paramFriends.abilityBits = paramFriendInfo.uAbiFlag;
    paramFriends.eNetwork = paramFriendInfo.eNetworkType;
    paramFriends.netTypeIconId = paramFriendInfo.eIconType;
    paramFriends.strTermDesc = paramFriendInfo.strTermDesc;
    paramFriends.setShieldFlag(false);
    paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
    paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
    paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
    boolean bool;
    label289:
    Friends localFriends;
    int i;
    if (paramFriendInfo.cKingOfGloryFlag == 1)
    {
      bool = true;
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      paramFriends.strMasterUin = paramFriendInfo.strMasterUin;
      paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
      paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
      azlk.a(paramFriends, paramFriendInfo.vecMusicInfo, "GetFriendList");
      if ((!TextUtils.isEmpty(paramFriends.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.c().equals(paramFriends.uin))) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.c(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (paramFriendInfo.cOlympicTorch != 1) {
        break label929;
      }
      bool = true;
      paramFriends.setOlympicTorchFlag(bool);
      localFriends = this.jdField_a_of_type_Anyw.e(paramFriends.uin);
      paramFriends.iTermType = paramFriendInfo.iTermType;
      Object localObject = paramFriendInfo.oVipInfo;
      int k = EVIPSPEC.E_SP_QQVIP.value();
      if (localFriends == null) {
        break label935;
      }
      i = localFriends.qqVipInfo;
      label341:
      paramFriends.qqVipInfo = aopy.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends == null) {
        break label940;
      }
      i = localFriends.superQqInfo;
      label378:
      paramFriends.superQqInfo = aopy.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends == null) {
        break label945;
      }
      i = localFriends.superVipInfo;
      label415:
      paramFriends.superVipInfo = aopy.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_BIGCLUB.value();
      i = j;
      if (localFriends != null) {
        i = localFriends.bigClubInfo;
      }
      paramFriends.bigClubInfo = aopy.a((VipBaseInfo)localObject, k, i);
      paramFriends.cNewLoverDiamondFlag = paramFriendInfo.cNewLoverDiamondFlag;
      if ((paramFriendInfo.oVipInfo != null) && (paramFriendInfo.oVipInfo.mOpenInfo != null))
      {
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject != null) {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localObject != null) {
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        paramFriends.nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
        paramFriends.grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
      }
      if (localFriends != null)
      {
        paramFriends.showLoginClient = localFriends.showLoginClient;
        paramFriends.lastLoginType = localFriends.lastLoginType;
      }
      azin.a(paramFriends, paramFriendInfo.vecExtOnlineBusinessInfo, "GetFriendList", localFriends);
      if ((localFriends != null) && (aofp.a(paramFriends.name, localFriends.name)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(paramFriends);
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(paramFriendInfo.nick)) && (!paramFriendInfo.nick.equals(paramFriendInfo.remark)) && (aofp.b(paramFriends.remark, localFriends.remark)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.b.add(paramFriends);
      }
      if (localFriends != null)
      {
        if (localFriends.gathtertype != 1) {
          break label950;
        }
        paramFriends.gathtertype = 1;
      }
    }
    for (;;)
    {
      paramFriends.age = localFriends.age;
      paramFriends.smartRemark = localFriends.smartRemark;
      paramFriends.gender = localFriends.gender;
      paramFriends.recommReason = localFriends.recommReason;
      return;
      bool = false;
      break;
      label929:
      bool = false;
      break label289;
      label935:
      i = 0;
      break label341;
      label940:
      i = 0;
      break label378;
      label945:
      i = 0;
      break label415;
      label950:
      if (localFriends.gathtertype == 2) {
        paramFriends.gathtertype = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqc
 * JD-Core Version:    0.7.0.1
 */