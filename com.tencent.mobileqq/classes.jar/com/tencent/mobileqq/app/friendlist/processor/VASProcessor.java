package com.tencent.mobileqq.app.friendlist.processor;

import QQService.EVIPSPEC;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.etrump.mixlayout.FontManager;
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
      paramExtRspData.uVipFont = FontManager.a(((FriendInfo)localObject).uFounderFont);
      paramExtRspData.vipFontType = FontManager.b(((FriendInfo)localObject).uFounderFont);
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
    label51:
    Object localObject2;
    Friends localFriends1;
    label134:
    Friends localFriends2;
    Object localObject3;
    int j;
    if (paramList.hasNext())
    {
      localObject2 = (Pair)paramList.next();
      localFriends1 = (Friends)((Pair)localObject2).first;
      localObject2 = (FriendInfo)((Pair)localObject2).second;
      localFriends1.namePlateOfKingGameId = ((FriendInfo)localObject2).uGameAppid;
      localFriends1.namePlateOfKingLoginTime = ((FriendInfo)localObject2).uGameLastLoginTime;
      localFriends1.namePlateOfKingDan = ((int)((FriendInfo)localObject2).ulKingOfGloryRank);
      if (((FriendInfo)localObject2).cKingOfGloryFlag != 1) {
        break label593;
      }
      paramBoolean = true;
      localFriends1.namePlateOfKingDanDisplatSwitch = paramBoolean;
      if ((!TextUtils.isEmpty(localFriends1.uin)) && (this.mApp.getCurrentUin().equals(localFriends1.uin))) {
        this.mApp.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.mApp.getCurrentUin(), localFriends1.namePlateOfKingDanDisplatSwitch).apply();
      }
      localFriends2 = ((IFriendDataService)localObject1).getFriend(localFriends1.uin, true, true);
      localObject3 = ((FriendInfo)localObject2).oVipInfo;
      j = EVIPSPEC.E_SP_QQVIP.value();
      if (localFriends2 == null) {
        break label599;
      }
      i = localFriends2.qqVipInfo;
      label271:
      localFriends1.qqVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject3, j, i);
      localObject3 = ((FriendInfo)localObject2).oVipInfo;
      j = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends2 == null) {
        break label605;
      }
      i = localFriends2.superQqInfo;
      label312:
      localFriends1.superQqInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject3, j, i);
      localObject3 = ((FriendInfo)localObject2).oVipInfo;
      j = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label611;
      }
      i = localFriends2.superVipInfo;
      label353:
      localFriends1.superVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject3, j, i);
      localObject3 = ((FriendInfo)localObject2).oVipInfo;
      j = EVIPSPEC.E_SP_BIGCLUB.value();
      if (localFriends2 == null) {
        break label617;
      }
    }
    label593:
    label599:
    label605:
    label611:
    label617:
    for (int i = localFriends2.bigClubInfo;; i = 0)
    {
      localFriends1.bigClubInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject3, j, i);
      localFriends1.cNewLoverDiamondFlag = ((FriendInfo)localObject2).cNewLoverDiamondFlag;
      if ((((FriendInfo)localObject2).oVipInfo != null) && (((FriendInfo)localObject2).oVipInfo.mOpenInfo != null))
      {
        localObject3 = (VipOpenInfo)((FriendInfo)localObject2).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject3 != null) {
          localFriends1.superVipTemplateId = ((int)((VipOpenInfo)localObject3).lNameplateId);
        }
        localObject3 = (VipOpenInfo)((FriendInfo)localObject2).oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (localObject3 != null) {
          localFriends1.bigClubTemplateId = ((int)((VipOpenInfo)localObject3).lNameplateId);
        }
        localFriends1.nameplateVipType = ((FriendInfo)localObject2).oVipInfo.iNameplateVipType;
        localFriends1.grayNameplateFlag = ((FriendInfo)localObject2).oVipInfo.iGrayNameplateFlag;
        localFriends1.bigClubExtTemplateId = QidCardManager.a(((FriendInfo)localObject2).oVipInfo.strExtendNameplateId);
      }
      if (localFriends2 == null) {
        break label51;
      }
      localFriends1.showLoginClient = localFriends2.showLoginClient;
      localFriends1.lastLoginType = localFriends2.lastLoginType;
      break label51;
      break;
      paramBoolean = false;
      break label134;
      i = 0;
      break label271;
      i = 0;
      break label312;
      i = 0;
      break label353;
    }
  }
  
  public void onUpdateExtensionInfo(ExtensionInfo paramExtensionInfo, FriendInfo paramFriendInfo, ExtRspData paramExtRspData)
  {
    paramExtensionInfo.pendantId = paramFriendInfo.ulFaceAddonId;
    paramExtensionInfo.uVipFont = FontManager.a(paramFriendInfo.uFounderFont);
    paramExtensionInfo.vipFontType = FontManager.b(paramFriendInfo.uFounderFont);
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
    if (!(this.mApp instanceof QQAppInterface))
    {
      QLog.e("IMCore.friend.VASFriendProcessor", 1, "onUpdateFriendInfo| app is not QQAppInterface");
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.mApp;
    Friends localFriends = ((IFriendDataService)this.mApp.getRuntimeService(IFriendDataService.class, "all")).getFriend(paramFriends.uin);
    Object localObject = paramFriendInfo.oVipInfo;
    int j = EVIPSPEC.E_SP_QQVIP.value();
    int i;
    if (localFriends != null)
    {
      i = localFriends.qqVipInfo;
      label79:
      paramFriends.qqVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject, j, i);
      localObject = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends == null) {
        break label486;
      }
      i = localFriends.superQqInfo;
      label116:
      paramFriends.superQqInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject, j, i);
      localObject = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends == null) {
        break label491;
      }
      i = localFriends.superVipInfo;
      label153:
      paramFriends.superVipInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject, j, i);
      localObject = paramFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_BIGCLUB.value();
      if (localFriends == null) {
        break label496;
      }
      i = localFriends.bigClubInfo;
      label190:
      paramFriends.bigClubInfo = FriendListHandlerUtil.a((VipBaseInfo)localObject, j, i);
      paramFriends.cNewLoverDiamondFlag = paramFriendInfo.cNewLoverDiamondFlag;
      if ((paramFriendInfo.oVipInfo != null) && (paramFriendInfo.oVipInfo.mOpenInfo != null))
      {
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject != null) {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        localObject = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        i = QidCardManager.a(paramFriendInfo.oVipInfo.strExtendNameplateId);
        if (localObject != null)
        {
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
          paramFriends.bigClubExtTemplateId = i;
        }
        if (localFriends != null)
        {
          localFriends.nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
          localFriends.grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
          localFriends.bigClubExtTemplateId = i;
        }
      }
      paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
      paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
      paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
      if (paramFriendInfo.cKingOfGloryFlag != 1) {
        break label501;
      }
    }
    label486:
    label491:
    label496:
    label501:
    for (boolean bool = true;; bool = false)
    {
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      if ((TextUtils.isEmpty(paramFriends.uin)) || (!localQQAppInterface.getCurrentUin().equals(paramFriends.uin))) {
        break;
      }
      localQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + localQQAppInterface.getCurrentUin(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      return;
      i = 0;
      break label79;
      i = 0;
      break label116;
      i = 0;
      break label153;
      i = 0;
      break label190;
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
      VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
      if (localVipOpenInfo != null) {
        paramFriends.superVipTemplateId = ((int)localVipOpenInfo.lNameplateId);
      }
      localVipOpenInfo = (VipOpenInfo)paramFriendInfo.oVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
      if (localVipOpenInfo != null) {
        paramFriends.bigClubTemplateId = ((int)localVipOpenInfo.lNameplateId);
      }
      paramFriends.nameplateVipType = paramFriendInfo.oVipInfo.iNameplateVipType;
      paramFriends.grayNameplateFlag = paramFriendInfo.oVipInfo.iGrayNameplateFlag;
      paramFriends.bigClubExtTemplateId = QidCardManager.a(paramFriendInfo.oVipInfo.strExtendNameplateId);
    }
    paramFriends.namePlateOfKingGameId = paramFriendInfo.uGameAppid;
    paramFriends.namePlateOfKingLoginTime = paramFriendInfo.uGameLastLoginTime;
    paramFriends.namePlateOfKingDan = ((int)paramFriendInfo.ulKingOfGloryRank);
    if (paramFriendInfo.cKingOfGloryFlag == 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramFriends.namePlateOfKingDanDisplatSwitch = bool;
      ((VasExtensionManager)this.mApp.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(paramFriends.uin, (int)paramFriendInfo.uFaceStoreId);
      ((FontManager)this.mApp.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(paramFriends.uin, (int)paramFriendInfo.uFontEffect);
      this.mApp.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.mApp.getCurrentUin(), paramFriends.namePlateOfKingDanDisplatSwitch).apply();
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.friend.VASFriendProcessor.selfFontEffect", 2, "self fontEffect: " + (int)paramFriendInfo.uFontEffect);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.VASProcessor
 * JD-Core Version:    0.7.0.1
 */