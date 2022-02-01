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

public class aodp
{
  private long jdField_a_of_type_Long;
  private anmw jdField_a_of_type_Anmw;
  aodq jdField_a_of_type_Aodq;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<Friends> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  Friends[] jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends;
  ArrayList<Friends> b;
  
  public aodp(QQAppInterface paramQQAppInterface, Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean, aodq paramaodq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends = paramArrayOfFriends;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.b = new ArrayList();
    this.jdField_a_of_type_Aodq = paramaodq;
    this.jdField_a_of_type_Anmw = ((anmw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ExtensionInfoBatchUpdater", 2, "saveInBatch friendList size=" + this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends.length);
    }
    ankw localankw = (ankw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
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
        antf.a(Long.parseLong(localFriends.uin), str, localankw);
      }
    }
    if (this.b.size() > 0)
    {
      localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        localFriends = (Friends)localIterator.next();
        str = localFriends.remark;
        antf.b(Long.parseLong(localFriends.uin), str, localankw);
      }
    }
    this.jdField_a_of_type_Aodq.a(this.jdField_a_of_type_ArrayOfComTencentMobileqqDataFriends, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    int j = 0;
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
    label278:
    Friends localFriends;
    int i;
    if (paramFriendInfo.cKingOfGloryFlag == 1)
    {
      bool = true;
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      paramFriends.strMasterUin = paramFriendInfo.strMasterUin;
      paramFriends.uExtOnlineStatus = paramFriendInfo.uExtOnlineStatus;
      paramFriends.iBatteryStatus = paramFriendInfo.iBatteryStatus;
      aysz.a(paramFriends, paramFriendInfo.vecMusicInfo, "GetFriendList");
      if ((!TextUtils.isEmpty(paramFriends.uin)) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.c().equals(paramFriends.uin))) {
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.app.c(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (paramFriendInfo.cOlympicTorch != 1) {
        break label918;
      }
      bool = true;
      paramFriends.setOlympicTorchFlag(bool);
      localFriends = this.jdField_a_of_type_Anmw.e(paramFriends.uin);
      paramFriends.iTermType = paramFriendInfo.iTermType;
      Object localObject = paramFriendInfo.oVipInfo;
      int k = EVIPSPEC.E_SP_QQVIP.value();
      if (localFriends == null) {
        break label924;
      }
      i = localFriends.qqVipInfo;
      label330:
      paramFriends.qqVipInfo = FriendListHandler.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends == null) {
        break label929;
      }
      i = localFriends.superQqInfo;
      label367:
      paramFriends.superQqInfo = FriendListHandler.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends == null) {
        break label934;
      }
      i = localFriends.superVipInfo;
      label404:
      paramFriends.superVipInfo = FriendListHandler.a((VipBaseInfo)localObject, k, i);
      localObject = paramFriendInfo.oVipInfo;
      k = EVIPSPEC.E_SP_BIGCLUB.value();
      i = j;
      if (localFriends != null) {
        i = localFriends.bigClubInfo;
      }
      paramFriends.bigClubInfo = FriendListHandler.a((VipBaseInfo)localObject, k, i);
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
      aypu.a(paramFriends, paramFriendInfo.vecExtOnlineBusinessInfo, "GetFriendList", localFriends);
      if ((localFriends != null) && (antf.a(paramFriends.name, localFriends.name)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(paramFriends);
      }
      if ((localFriends != null) && (!TextUtils.isEmpty(paramFriendInfo.nick)) && (!paramFriendInfo.nick.equals(paramFriendInfo.remark)) && (antf.b(paramFriends.remark, localFriends.remark)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + localFriends.name + ",newName " + paramFriends.name + ",oldRemark " + localFriends.remark + ",newRemark =" + paramFriends.remark);
        }
        this.b.add(paramFriends);
      }
      if (localFriends != null)
      {
        if (localFriends.gathtertype != 1) {
          break label939;
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
      label918:
      bool = false;
      break label278;
      label924:
      i = 0;
      break label330;
      label929:
      i = 0;
      break label367;
      label934:
      i = 0;
      break label404;
      label939:
      if (localFriends.gathtertype == 2) {
        paramFriends.gathtertype = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodp
 * JD-Core Version:    0.7.0.1
 */