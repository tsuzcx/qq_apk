import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;
import java.util.ArrayList;

public class aoly
{
  FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  SpecialCareInfo jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo;
  
  public aoly(QQAppInterface paramQQAppInterface, FriendListHandler paramFriendListHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = paramFriendListHandler;
  }
  
  private void a(Friends paramFriends, FriendInfo paramFriendInfo, GetFriendListResp paramGetFriendListResp, anvk paramanvk)
  {
    axmv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriends, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo, paramFriendInfo.vecIntimateInfo);
    int k = paramGetFriendListResp.wGetExtSnsRspCode;
    int j;
    int i;
    if (paramGetFriendListResp.stSubSrvRspCode != null)
    {
      j = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
      i = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend.ExtensionInfoSingleUpdater", 2, new Object[] { "handleGetFriendDetailInfo uin=", paramFriends.uin, ", cSpecialFlag=", Byte.valueOf(paramFriends.cSpecialFlag), " wGetExtSnsRspCode:", Integer.valueOf(k), " wGetMutualMarkRspCode:", Integer.valueOf(j), " wGetIntimateInfoRspCode:", Integer.valueOf(i), " extOnline:", Long.valueOf(paramFriendInfo.uExtOnlineStatus), " battery:", Integer.valueOf(paramFriendInfo.iBatteryStatus) });
      }
      if (k == 0) {
        afse.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramanvk, paramFriends, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo, paramFriends.uin, paramFriendInfo.vecExtSnsFrdData);
      }
      if (j == 0) {
        axlt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramanvk, paramFriends, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo, paramFriends.uin, paramFriendInfo.vecMutualMarkData);
      }
      return;
      i = 0;
      j = 0;
    }
  }
  
  public void a()
  {
    Object localObject = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    VasFaceManager localVasFaceManager = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getVaseFaceManager();
    ((anvk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    ((anvk)localObject).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
    localVasFaceManager.a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
    localObject = new ArrayList();
    ((ArrayList)localObject).add(this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.notifyUI(99, true, new Object[] { Boolean.valueOf(true), localObject });
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo, GetFriendListResp paramGetFriendListResp)
  {
    anvk localanvk = (anvk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = localanvk.a(paramFriends.uin);
    if (this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = new ExtensionInfo();
      this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uin = paramFriends.uin;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId = paramFriendInfo.ulFaceAddonId;
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont = gb.a(paramFriendInfo.uFounderFont);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType = gb.b(paramFriendInfo.uFounderFont);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.colorRingId = paramFriendInfo.uColorRing;
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.magicFont = (paramFriendInfo.cSpecialFlag >> 3 & 0x1);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.faceId = ((int)paramFriendInfo.uFaceStoreId);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.timestamp = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.latestPLUpdateTimestamp = paramFriendInfo.uTagUpdateTime;
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.fontEffect = ((int)paramFriendInfo.uFontEffect);
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
    this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo = new SpecialCareInfo();
    aolc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriendInfo.vecRing, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo, paramFriends, this.jdField_a_of_type_ComTencentMobileqqDataSpecialCareInfo, 0L);
    a(paramFriends, paramFriendInfo, paramGetFriendListResp, localanvk);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend.ExtensionInfoSingleUpdater", 2, "handleGetFriendDetailInfo, Get ExtensionInfo, uin=" + paramFriends.uin + ", id=" + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId + ",font=" + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uVipFont + ", fontType = " + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.vipFontType + ", magicfont = " + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.magicFont + ",latestplNewsTs=" + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.latestPLUpdateTimestamp + ",fontEffect=" + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.fontEffect + ",fontEffectLastUpdateTime=" + this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.fontEffectLastUpdateTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoly
 * JD-Core Version:    0.7.0.1
 */