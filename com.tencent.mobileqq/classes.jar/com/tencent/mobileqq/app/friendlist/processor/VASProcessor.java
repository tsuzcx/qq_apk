package com.tencent.mobileqq.app.friendlist.processor;

import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.data.ExtRspData;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.qid.QidCardManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class VASProcessor
  extends BaseFriendProcessor
{
  public VASProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateExtensionInfo(List<Pair<ExtensionInfo, FriendInfo>> paramList, ExtRspData paramExtRspData, long paramLong, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Pair)paramList.next();
      paramExtRspData = (ExtensionInfo)((Pair)localObject).first;
      localObject = (FriendInfo)((Pair)localObject).second;
      paramExtRspData.pendantId = ((FriendInfo)localObject).ulFaceAddonId;
      paramExtRspData.uVipFont = FontManagerConstants.parseFontId(((FriendInfo)localObject).uFounderFont);
      paramExtRspData.vipFontType = FontManagerConstants.parseFontType(((FriendInfo)localObject).uFounderFont);
      paramExtRspData.magicFont = (((FriendInfo)localObject).cSpecialFlag >> 3 & 0x1);
      paramExtRspData.colorRingId = ((FriendInfo)localObject).uColorRing;
      paramExtRspData.timestamp = paramLong;
      paramExtRspData.fontEffect = ((int)((FriendInfo)localObject).uFontEffect);
      paramExtRspData.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      paramExtRspData.latestPLUpdateTimestamp = ((FriendInfo)localObject).uTagUpdateTime;
      if (paramExtRspData.faceId != ((FriendInfo)localObject).uFaceStoreId)
      {
        paramExtRspData.faceId = ((int)((FriendInfo)localObject).uFaceStoreId);
        paramExtRspData.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      }
    }
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.VASFriendProcessor", 1, "onGetExtensionInfoResp| app is not QQAppInterface");
      return;
    }
    Object localObject1 = (QQAppInterface)this.mApp;
    localObject1 = (IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject2 = (Pair)paramList.next();
      Friends localFriends = (Friends)((Pair)localObject2).first;
      localObject2 = (FriendInfo)((Pair)localObject2).second;
      localFriends.namePlateOfKingGameId = ((FriendInfo)localObject2).uGameAppid;
      localFriends.namePlateOfKingLoginTime = ((FriendInfo)localObject2).uGameLastLoginTime;
      localFriends.namePlateOfKingDan = ((int)((FriendInfo)localObject2).ulKingOfGloryRank);
      int i = ((FriendInfo)localObject2).cKingOfGloryFlag;
      int j = 0;
      if (i == 1) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      localFriends.namePlateOfKingDanDisplatSwitch = paramBoolean;
      if ((!TextUtils.isEmpty(localFriends.uin)) && (this.mApp.getCurrentUin().equals(localFriends.uin)))
      {
        localObject3 = this.mApp.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("plate_of_king_display_switch_");
        ((StringBuilder)localObject4).append(this.mApp.getCurrentUin());
        ((SharedPreferences.Editor)localObject3).putBoolean(((StringBuilder)localObject4).toString(), localFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      Object localObject3 = ((IFriendDataService)localObject1).getFriend(localFriends.uin, true, true);
      Object localObject4 = ((FriendInfo)localObject2).oVipInfo;
      int k = EVIPSPEC.E_SP_QQVIP.value();
      if (localObject3 != null) {
        i = ((Friends)localObject3).qqVipInfo;
      } else {
        i = 0;
      }
      localFriends.qqVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject4, k, i);
      localObject4 = ((FriendInfo)localObject2).oVipInfo;
      k = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localObject3 != null) {
        i = ((Friends)localObject3).superQqInfo;
      } else {
        i = 0;
      }
      localFriends.superQqInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject4, k, i);
      localObject4 = ((FriendInfo)localObject2).oVipInfo;
      k = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject3 != null) {
        i = ((Friends)localObject3).superVipInfo;
      } else {
        i = 0;
      }
      localFriends.superVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject4, k, i);
      localObject4 = ((FriendInfo)localObject2).oVipInfo;
      k = EVIPSPEC.E_SP_BIGCLUB.value();
      i = j;
      if (localObject3 != null) {
        i = ((Friends)localObject3).bigClubInfo;
      }
      localFriends.bigClubInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject4, k, i);
      localFriends.cNewLoverDiamondFlag = ((FriendInfo)localObject2).cNewLoverDiamondFlag;
      if ((((FriendInfo)localObject2).oVipInfo != null) && (((FriendInfo)localObject2).oVipInfo.mOpenInfo != null))
      {
        localObject4 = (VipOpenInfo)((FriendInfo)localObject2).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject4 != null) {
          localFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject4).lNameplateId);
        }
        localObject4 = (VipOpenInfo)((FriendInfo)localObject2).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localObject4 != null) {
          localFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject4).lNameplateId);
        }
        localFriends.nameplateVipType = ((FriendInfo)localObject2).oVipInfo.iNameplateVipType;
        localFriends.grayNameplateFlag = ((FriendInfo)localObject2).oVipInfo.iGrayNameplateFlag;
        localFriends.bigClubExtTemplateId = QidCardManager.a(((FriendInfo)localObject2).oVipInfo.strExtendNameplateId);
      }
      if (localObject3 != null)
      {
        localFriends.showLoginClient = ((Friends)localObject3).showLoginClient;
        localFriends.lastLoginType = ((Friends)localObject3).lastLoginType;
      }
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    paramExtensionInfo.pendantId = paramFriendInfo.ulFaceAddonId;
    paramExtensionInfo.uVipFont = FontManagerConstants.parseFontId(paramFriendInfo.uFounderFont);
    paramExtensionInfo.vipFontType = FontManagerConstants.parseFontType(paramFriendInfo.uFounderFont);
    paramExtensionInfo.colorRingId = paramFriendInfo.uColorRing;
    paramExtensionInfo.magicFont = (paramFriendInfo.cSpecialFlag >> 3 & 0x1);
    paramExtensionInfo.faceId = ((int)paramFriendInfo.uFaceStoreId);
    paramExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
    paramExtensionInfo.timestamp = System.currentTimeMillis();
    paramExtensionInfo.latestPLUpdateTimestamp = paramFriendInfo.uTagUpdateTime;
    paramExtensionInfo.fontEffect = ((int)paramFriendInfo.uFontEffect);
    paramExtensionInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
  }
  
  public void onUpdateFriendInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    boolean bool2 = this.mApp instanceof QQAppInterface;
    boolean bool1 = true;
    if (!bool2)
    {
      QLog.e("IMCore.friend.VASFriendProcessor", 1, "onUpdateFriendInfo| app is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
    Object localObject1 = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).getFriend(paramFriends.uin);
    Object localObject2 = paramFriendInfo.oVipInfo;
    int j = EVIPSPEC.E_SP_QQVIP.value();
    int i;
    if (localObject1 != null) {
      i = ((Friends)localObject1).qqVipInfo;
    } else {
      i = 0;
    }
    paramFriends.qqVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject2, j, i);
    localObject2 = paramFriendInfo.oVipInfo;
    j = EVIPSPEC.E_SP_SUPERQQ.value();
    if (localObject1 != null) {
      i = ((Friends)localObject1).superQqInfo;
    } else {
      i = 0;
    }
    paramFriends.superQqInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject2, j, i);
    localObject2 = paramFriendInfo.oVipInfo;
    j = EVIPSPEC.E_SP_SUPERVIP.value();
    if (localObject1 != null) {
      i = ((Friends)localObject1).superVipInfo;
    } else {
      i = 0;
    }
    paramFriends.superVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject2, j, i);
    localObject2 = paramFriendInfo.oVipInfo;
    j = EVIPSPEC.E_SP_BIGCLUB.value();
    if (localObject1 != null) {
      i = ((Friends)localObject1).bigClubInfo;
    } else {
      i = 0;
    }
    paramFriends.bigClubInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject2, j, i);
    paramFriends.cNewLoverDiamondFlag = paramFriendInfo.cNewLoverDiamondFlag;
    if ((paramFriendInfo.oVipInfo != null) && (paramFriendInfo.oVipInfo.mOpenInfo != null))
    {
      localObject2 = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
      if (localObject2 != null) {
        paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject2).lNameplateId);
      }
      localObject2 = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
      i = QidCardManager.a(paramFriendInfo.oVipInfo.strExtendNameplateId);
      if (localObject2 != null)
      {
        paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject2).lNameplateId);
        paramFriends.bigClubExtTemplateId = i;
      }
      if (localObject1 != null)
      {
        ((Friends)localObject1).nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
        ((Friends)localObject1).grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
        ((Friends)localObject1).bigClubExtTemplateId = i;
      }
    }
    paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
    paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
    paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
    if (paramFriendInfo.cKingOfGloryFlag != 1) {
      bool1 = false;
    }
    paramFriends.namePlateOfKingDanDisplatSwitch = bool1;
    if ((!TextUtils.isEmpty(paramFriends.uin)) && (localQQAppInterface.getCurrentUin().equals(paramFriends.uin)))
    {
      paramFriendInfo = localQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("plate_of_king_display_switch_");
      ((StringBuilder)localObject1).append(localQQAppInterface.getCurrentUin());
      paramFriendInfo.putBoolean(((StringBuilder)localObject1).toString(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
    }
  }
  
  public void onUpdateSelfInfo(Friends paramFriends, FriendInfo paramFriendInfo)
  {
    paramFriends.qqVipInfo = FriendListHandlerUtil.a(paramFriendInfo.oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), paramFriends.qqVipInfo);
    paramFriends.superQqInfo = FriendListHandlerUtil.a(paramFriendInfo.oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), paramFriends.superQqInfo);
    paramFriends.superVipInfo = FriendListHandlerUtil.a(paramFriendInfo.oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), paramFriends.superVipInfo);
    paramFriends.bigClubInfo = FriendListHandlerUtil.a(paramFriendInfo.oVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), paramFriends.bigClubInfo);
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
      paramFriends.bigClubExtTemplateId = QidCardManager.a(paramFriendInfo.oVipInfo.strExtendNameplateId);
    }
    paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
    paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
    paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
    int i = paramFriendInfo.cKingOfGloryFlag;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    paramFriends.namePlateOfKingDanDisplatSwitch = bool;
    ((VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(paramFriends.uin, (int)paramFriendInfo.uFaceStoreId);
    ((IFontManagerService)this.mApp.getRuntimeService(IFontManagerService.class, "")).updateSelfFontEffectId(paramFriends.uin, (int)paramFriendInfo.uFontEffect);
    Object localObject = this.mApp.getApp().getSharedPreferences("sp_plate_of_king", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("plate_of_king_display_switch_");
    localStringBuilder.append(this.mApp.getCurrentUin());
    ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
    if (QLog.isColorLevel())
    {
      paramFriends = new StringBuilder();
      paramFriends.append("self fontEffect: ");
      paramFriends.append((int)paramFriendInfo.uFontEffect);
      QLog.i("IMCore.friend.VASFriendProcessor.selfFontEffect", 2, paramFriends.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.VASProcessor
 * JD-Core Version:    0.7.0.1
 */