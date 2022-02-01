import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class anil
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  amsw jdField_a_of_type_Amsw;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ArrayList<ExtensionInfo> jdField_a_of_type_JavaUtilArrayList;
  List<String> jdField_a_of_type_JavaUtilList;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap;
  Set<String> jdField_a_of_type_JavaUtilSet;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  List<String> jdField_b_of_type_JavaUtilList;
  Map<String, Boolean> jdField_b_of_type_JavaUtilMap;
  int jdField_c_of_type_Int;
  List<String> jdField_c_of_type_JavaUtilList;
  List<SpecialCareInfo> d;
  
  public anil(QQAppInterface paramQQAppInterface, int paramInt1, long paramLong, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_Amsw = ((amsw)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt1);
    this.jdField_a_of_type_JavaUtilSet = alem.a(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.d = new ArrayList();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.contacttab.friend.ExtensionInfoBatchUpdater", 2, "saveInBatch uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + " | size:" + this.jdField_a_of_type_Int + " | extensionInfoList.size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    this.jdField_a_of_type_Amsw.b(this.jdField_a_of_type_JavaUtilArrayList);
    ((bgga)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a.a(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Amsw.a(this.d, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_JavaUtilMap.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "friendlist size", Integer.valueOf(this.jdField_b_of_type_JavaUtilMap.size()) });
      }
      FriendsStatusUtil.a(this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    for (;;)
    {
      alem.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      alem.b(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      alem.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      alem.c(this.jdField_c_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "friendlist size 0");
      }
    }
  }
  
  public void a(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    Object localObject2 = this.jdField_a_of_type_Amsw.a(String.valueOf(paramFriends.uin));
    int i = paramFriendInfo.cSpecialFlag >> 3 & 0x1;
    boolean bool1 = false;
    Object localObject1;
    if (localObject2 == null)
    {
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = String.valueOf(paramFriends.uin);
      ((ExtensionInfo)localObject1).pendantId = paramFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject1).uVipFont = gb.a(paramFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject1).vipFontType = gb.b(paramFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject1).magicFont = i;
      ((ExtensionInfo)localObject1).colorRingId = paramFriendInfo.uColorRing;
      ((ExtensionInfo)localObject1).timestamp = this.jdField_a_of_type_Long;
      ((ExtensionInfo)localObject1).fontEffect = ((int)paramFriendInfo.uFontEffect);
      ((ExtensionInfo)localObject1).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      bool1 = true;
    }
    for (;;)
    {
      boolean bool2 = bool1;
      if (((ExtensionInfo)localObject1).faceId != paramFriendInfo.uFaceStoreId)
      {
        ((ExtensionInfo)localObject1).faceId = ((int)paramFriendInfo.uFaceStoreId);
        ((ExtensionInfo)localObject1).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
        bool2 = bool1 | true;
      }
      localObject2 = new SpecialCareInfo();
      boolean bool3 = anij.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriendInfo.vecRing, (ExtensionInfo)localObject1, paramFriends, this.jdField_a_of_type_JavaUtilSet, this.jdField_a_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilMap, this.jdField_c_of_type_JavaUtilList, this.jdField_b_of_type_JavaUtilMap, (SpecialCareInfo)localObject2, this.jdField_a_of_type_Long);
      if (((SpecialCareInfo)localObject2).globalSwitch != 0) {
        this.d.add(localObject2);
      }
      boolean bool4 = bool2 | bool3 | awgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFriends, (ExtensionInfo)localObject1, paramFriendInfo.vecIntimateInfo);
      bool3 = bool4;
      if (this.jdField_b_of_type_Int == 0) {
        bool3 = afas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amsw, paramFriends, (ExtensionInfo)localObject1, paramFriends.uin, paramFriendInfo.vecExtSnsFrdData) | bool4;
      }
      bool4 = bool3;
      if (this.jdField_c_of_type_Int == 0) {
        bool4 = bool3 | awfr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Amsw, paramFriends, (ExtensionInfo)localObject1, paramFriends.uin, paramFriendInfo.vecMutualMarkData);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleGetFriendList, update(), Get Extension").append(", uin=").append(((ExtensionInfo)localObject1).uin).append(", id=").append(((ExtensionInfo)localObject1).pendantId).append(", font=").append(((ExtensionInfo)localObject1).uVipFont).append(", fontType=").append(((ExtensionInfo)localObject1).vipFontType).append(", magicfont=").append(i).append(", latestplNewsTs=").append(((ExtensionInfo)localObject1).latestPLUpdateTimestamp).append(", fontEffect=").append(((ExtensionInfo)localObject1).fontEffect).append(", fontEffectLastUpdateTime=").append(((ExtensionInfo)localObject1).fontEffectLastUpdateTime).append(", extensionChanged=").append(bool4).append(", cSpecialFlag=").append(paramFriends.cSpecialFlag).append(", battery=").append(paramFriendInfo.iBatteryStatus).append(", extOnline=").append(paramFriendInfo.uExtOnlineStatus).append(", cmshow3dFlag=").append(paramFriendInfo.cCentiShow3DFlag).append(", apolloServerTS=").append(paramFriendInfo.uApolloTimestamp).append(", apolloStatus=").append(paramFriendInfo.cApolloFlag);
        QLog.d("Q.contacttab.friend.ExtensionInfoBatchUpdater", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool4) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
      return;
      if ((((ExtensionInfo)localObject2).pendantId == paramFriendInfo.ulFaceAddonId) && (((ExtensionInfo)localObject2).uVipFont == gb.a(paramFriendInfo.uFounderFont)) && (((ExtensionInfo)localObject2).vipFontType == gb.b(paramFriendInfo.uFounderFont)) && (((ExtensionInfo)localObject2).colorRingId == paramFriendInfo.uColorRing) && (((ExtensionInfo)localObject2).magicFont == i) && (((ExtensionInfo)localObject2).latestPLUpdateTimestamp == paramFriendInfo.uTagUpdateTime))
      {
        localObject1 = localObject2;
        if (((ExtensionInfo)localObject2).fontEffect == (int)paramFriendInfo.uFontEffect) {}
      }
      else
      {
        ((ExtensionInfo)localObject2).pendantId = paramFriendInfo.ulFaceAddonId;
        ((ExtensionInfo)localObject2).uVipFont = gb.a(paramFriendInfo.uFounderFont);
        ((ExtensionInfo)localObject2).vipFontType = gb.b(paramFriendInfo.uFounderFont);
        ((ExtensionInfo)localObject2).magicFont = i;
        ((ExtensionInfo)localObject2).colorRingId = paramFriendInfo.uColorRing;
        ((ExtensionInfo)localObject2).timestamp = this.jdField_a_of_type_Long;
        ((ExtensionInfo)localObject2).latestPLUpdateTimestamp = paramFriendInfo.uTagUpdateTime;
        ((ExtensionInfo)localObject2).fontEffect = ((int)paramFriendInfo.uFontEffect);
        ((ExtensionInfo)localObject2).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
        bool1 = true;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anil
 * JD-Core Version:    0.7.0.1
 */