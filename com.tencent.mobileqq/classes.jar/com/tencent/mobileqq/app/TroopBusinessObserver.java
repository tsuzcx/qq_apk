package com.tencent.mobileqq.app;

import KQQ.RespBatchProcess;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.AddContactFindTroopClassifyInfo;
import com.tencent.mobileqq.activity.contact.recommendtroop.RecommendMember;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopGameInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.profile.ProfileGameInfo;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.troop.api.ITroopObserver;
import com.tencent.mobileqq.troop.associations.AllianceItem;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.data.ShowExternalTroop;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.utils.TroopRobotData;
import com.tencent.mobileqq.troop.utils.TroopRobotInfo;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.hw.group_mgr.CardInfo;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMember;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import tencent.im.oidb.cmd0xe83.oidb_0xe83.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.Result;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class TroopBusinessObserver
  implements ITroopObserver, BusinessObserver
{
  private void onNotify_JoinTroopSecurityTips(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bZ) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    onJoinTroopSecurityTips(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue());
  }
  
  private void onUpdate_batchAddFriendSecurityCheck(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ba) {
      return;
    }
    paramObject = (Object[])paramObject;
    onBAFSecurityCheckResult(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue());
  }
  
  private void onUpdate_batchGetTroopCardDeafultNick(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ag) {
      return;
    }
    onBatchTroopCardDefaultNick(paramBoolean, paramObject);
  }
  
  private void onUpdate_batchGetTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.H) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
    } while (!(paramObject instanceof Object[]));
    paramObject = (Object[])paramObject;
    onBatchGetTroopInfoResp(paramBoolean, ((Long)paramObject[0]).longValue(), (RespBatchProcess)paramObject[1], (Bundle)paramObject[2]);
    return;
    onBatchGetTroopInfoResp(paramBoolean, -1L, null, null);
  }
  
  private void onUpdate_batchGetTroopNick(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.h) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramBoolean)
    {
      onGetTroopNickNameFinish(true, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], (String[])paramObject[3]);
      return;
    }
    onGetTroopNickNameFinish(false, ((Long)paramObject[0]).longValue(), (long[])paramObject[1], null);
  }
  
  private void onUpdate_beKickOutTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.al) {}
    while ((paramObject == null) || (!(paramObject instanceof String))) {
      return;
    }
    onBeKickOutTroop((String)paramObject);
  }
  
  private void onUpdate_changeGroupClassExt(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bh) {
      return;
    }
    paramObject = (Object[])paramObject;
    onChangeGroupClassExt(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
  
  private void onUpdate_changeTroopAioRedPoint(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aj) {
      return;
    }
    paramObject = (Object[])paramObject;
    onChangeTroopAIORedPoint(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void onUpdate_checkPrivilege(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ah) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    boolean bool1 = ((Boolean)paramObject[0]).booleanValue();
    boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
    boolean bool3 = ((Boolean)paramObject[2]).booleanValue();
    onTroopPrivilege((String)paramObject[3], paramBoolean, bool1, bool2, bool3);
  }
  
  private void onUpdate_cleanTroopDetailOnlineMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aV) {
      return;
    }
    paramObject = (Object[])paramObject;
    onCleanOnlineMemberList(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void onUpdate_cmdTroopAvatar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    Object localObject2 = null;
    if (paramInt != TroopNotificationConstants.V) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object localObject3 = (Object[])paramObject;
    label76:
    Object localObject1;
    label95:
    int j;
    if (localObject3.length <= 5) {
      if ((localObject3[4] instanceof List))
      {
        paramObject = (List)localObject3[4];
        if ((localObject3[3] instanceof Integer))
        {
          paramInt = ((Integer)localObject3[3]).intValue();
          if ((localObject3[2] instanceof String))
          {
            localObject1 = (String)localObject3[2];
            if ((localObject3[1] instanceof Integer)) {
              i = ((Integer)localObject3[1]).intValue();
            }
            if ((localObject3[0] instanceof String))
            {
              localObject3 = (String)localObject3[0];
              j = i;
              localObject2 = localObject1;
              localObject1 = paramObject;
              i = paramInt;
              paramObject = localObject2;
              paramInt = j;
              localObject2 = localObject3;
            }
          }
        }
      }
    }
    for (;;)
    {
      onCmdTroopAvatar(paramBoolean, localObject2, paramInt, paramObject, i, (List)localObject1);
      return;
      localObject3 = paramObject;
      paramObject = localObject1;
      j = paramInt;
      paramInt = i;
      i = j;
      localObject1 = localObject3;
      continue;
      localObject1 = null;
      break label95;
      paramInt = -1;
      break label76;
      paramObject = null;
      break;
      localObject1 = null;
      i = -1;
      paramInt = -1;
      paramObject = null;
    }
  }
  
  private void onUpdate_delTroopMember(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.S) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[1];
    onDeleteTroopMember(paramBoolean, paramInt, localArrayList);
    if (paramObject.length > 2)
    {
      onDeleteTroopMember(paramBoolean, paramInt, localArrayList, (String)paramObject[2]);
      return;
    }
    onDeleteTroopMember(paramBoolean, paramInt, localArrayList, null);
  }
  
  private void onUpdate_editTroopLocation(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.p) {
      return;
    }
    paramObject = (TroopBusinessObserver.EditTroopLocationRet)paramObject;
    onEditTroopLocationRet(paramObject.jdField_a_of_type_Long, paramObject.jdField_a_of_type_Int, paramObject.jdField_a_of_type_Boolean, paramObject.jdField_a_of_type_JavaLangString, paramObject.b, paramObject.c);
  }
  
  private void onUpdate_genNewTroopName(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bm) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGenNewTroopName((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_getAddTroopWebInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.an) {
      return;
    }
    if ((paramObject instanceof String))
    {
      onGetAddTroopWebInfo((String)paramObject);
      return;
    }
    onGetAddTroopWebInfo(null);
  }
  
  private void onUpdate_getAllTroopOnlineMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aX) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetAllOnlineMemberList(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_getAnonyChatNick(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.W) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetAnonyChatNick(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (String)paramObject[6], (String)paramObject[7]);
      return;
    }
    onGetAnonyChatNick(paramBoolean, null, null, 0, 0, 0, 0, null, null);
  }
  
  private void onUpdate_getAtAllCountInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = false;
    if (paramInt != TroopNotificationConstants.af) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    String str1 = (String)paramObject[0];
    boolean bool2 = ((Boolean)paramObject[1]).booleanValue();
    String str2 = (String)paramObject[2];
    String str3 = (String)paramObject[3];
    if (paramObject.length >= 5) {
      bool1 = ((Boolean)paramObject[4]).booleanValue();
    }
    onGetAtAllRemianCountInfo(paramBoolean, str1, bool2, str2, str3, bool1);
  }
  
  private void onUpdate_getEssenceSwitchForShowInTroopCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cq) {}
    Object localObject;
    do
    {
      return;
      if (paramObject == null) {
        break;
      }
      localObject = (Object[])paramObject;
    } while (localObject.length != 2);
    if ((localObject[0] instanceof String)) {}
    for (paramObject = (String)localObject[0];; paramObject = null)
    {
      if ((localObject[1] instanceof TroopInfo)) {}
      for (localObject = (TroopInfo)localObject[1];; localObject = null)
      {
        onGetEssenceSwitchForShowInTroopCard(paramBoolean, paramObject, (TroopInfo)localObject);
        return;
        onGetEssenceSwitchForShowInTroopCard(paramBoolean, null, null);
        return;
      }
    }
  }
  
  private void onUpdate_getFollowStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aI) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetFollowStatus(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void onUpdate_getGlobalTroopLevel(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aJ) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetGolbalTroopLevel(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_getHomeworkTroopIdentity(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bg) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetHomeworkTroopIdentity(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), (String)paramObject[3], (String)paramObject[4]);
  }
  
  private void onUpdate_getHwTroopMemberCardInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ar) {
      return;
    }
    if (paramBoolean)
    {
      onGetHwTroopMemberCardInfo(0, "", (group_mgr.CardInfo)paramObject);
      return;
    }
    paramObject = (Object[])paramObject;
    onGetHwTroopMemberCardInfo(((Integer)paramObject[0]).intValue(), (String)paramObject[1], null);
  }
  
  private void onUpdate_getInvite2GroupAutoAgree(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aL) {
      return;
    }
    onGetAutoAgreeInvite2GroupIn50Flag(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void onUpdate_getInviteNoAuthLimitNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aH) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetInviteNoAuthLimitNum(paramBoolean, ((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void onUpdate_getMaxTroopAdminNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.B) {
      return;
    }
    if (paramBoolean)
    {
      paramObject = (Object[])paramObject;
      onGetMaxTroopAdminNum(true, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
      return;
    }
    onGetMaxTroopAdminNum(false, null, -1);
  }
  
  private void onUpdate_getNewTroopAppList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bf) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetNewTroopAppList((oidb_0xe83.RspBody)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_getPayToJoinTroopStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ai) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetPayToJoinTroopStatus(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_getRecommendTroopNew(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.D) {
      return;
    }
    onRecommendTroopBack(paramBoolean, (ArrayList)paramObject);
  }
  
  private void onUpdate_getShowExternalTroopList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ae) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    List localList = (List)paramObject[1];
    if (paramObject.length >= 3)
    {
      onGetExtShowTroopList(paramBoolean, paramInt, localList, (List)paramObject[2]);
      return;
    }
    onGetExtShowTroopList(paramBoolean, paramInt, localList, null);
  }
  
  private void onUpdate_getTroopAllGameOnlineMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aY) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetAllGameOnlineMemberList(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_getTroopAvatar(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = -1;
    String str = null;
    if (paramInt != TroopNotificationConstants.U) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    List localList;
    label77:
    label95:
    int j;
    if (arrayOfObject.length <= 5) {
      if ((arrayOfObject[4] instanceof List))
      {
        localList = (List)arrayOfObject[4];
        if ((arrayOfObject[3] instanceof Integer))
        {
          paramInt = ((Integer)arrayOfObject[3]).intValue();
          if ((arrayOfObject[2] instanceof String))
          {
            paramObject = (String)arrayOfObject[2];
            if ((arrayOfObject[1] instanceof Integer)) {
              i = ((Integer)arrayOfObject[1]).intValue();
            }
            if ((arrayOfObject[0] instanceof String))
            {
              str = (String)arrayOfObject[0];
              j = i;
              i = paramInt;
              paramInt = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      onGetTroopAvatar(paramBoolean, str, paramInt, paramObject, i, localList);
      return;
      j = paramInt;
      paramInt = i;
      i = j;
      continue;
      paramObject = null;
      break label95;
      paramInt = -1;
      break label77;
      localList = null;
      break;
      localList = null;
      i = -1;
      paramInt = -1;
      paramObject = null;
    }
  }
  
  private void onUpdate_getTroopCreditInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ao) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      onGetTroopCreditLevelInfo(paramBoolean, ((Long)paramObject).longValue());
      return;
    }
    onGetTroopCreditLevelInfo(paramBoolean, 0L);
  }
  
  private void onUpdate_getTroopDetailOnlineMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aU) {
      return;
    }
    paramObject = (Object[])paramObject;
    onUpdateOnlineMemberList(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_getTroopExternalStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ad) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetExtShowTroopStatus(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void onUpdate_getTroopGetGrayWebConfig(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aS) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopHideWebConfig(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5], (String)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue(), ((Long)paramObject[9]).longValue());
  }
  
  private void onUpdate_getTroopHomeworkTab(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aq) {
      return;
    }
    onGetHomeworkTab((String)paramObject);
  }
  
  private void onUpdate_getTroopMemberAutoRemark(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bk) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopMemberAutoRemark(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_getTroopMemberListCount(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.P) {
      return;
    }
    onUpdateTroopGetMemberListProgress(paramBoolean, ((Integer)paramObject).intValue());
  }
  
  private void onUpdate_getTroopMemberMaxNum(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ab) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    String str = (String)paramObject[0];
    ((Integer)paramObject[1]).intValue();
    paramInt = -1;
    if (paramBoolean) {
      paramInt = ((Integer)paramObject[2]).intValue();
    }
    onGetTroopMemberMaxNum(paramBoolean, str, paramInt);
  }
  
  private void onUpdate_getTroopNotifyFeeds(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aR) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopAioNotifyFeeds(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_getTroopOnlineMemberEntranceTips(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aZ) {
      return;
    }
    paramObject = (Object[])paramObject;
    onUpdateOnlineMemberTips(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_getTroopTag(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.G) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    Object localObject = (Object[])paramObject;
    if (localObject.length >= 3) {
      if ((localObject[2] instanceof String))
      {
        paramObject = (String)localObject[2];
        if ((localObject[0] instanceof Long)) {
          localObject = String.valueOf((Long)localObject[0]);
        }
      }
    }
    for (;;)
    {
      onGetTroopTagResult(paramBoolean, (String)localObject, paramObject);
      return;
      localObject = "";
      continue;
      paramObject = null;
      break;
      paramObject = null;
      localObject = "";
    }
  }
  
  private void onUpdate_getUinByOpenId(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aG) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetUinByOpenId(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ProfileActivity.AllInOne)paramObject[6]);
  }
  
  private void onUpdate_gvideoGetOnlineLevel(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ax) {
      return;
    }
    paramObject = (Object[])paramObject;
    RecvGVideoLevelInfo[] arrayOfRecvGVideoLevelInfo = new RecvGVideoLevelInfo[paramObject.length];
    paramInt = 0;
    while (paramInt < arrayOfRecvGVideoLevelInfo.length)
    {
      arrayOfRecvGVideoLevelInfo[paramInt] = ((RecvGVideoLevelInfo)paramObject[paramInt]);
      paramInt += 1;
    }
    onReceiveGVideoLevelInfo(arrayOfRecvGVideoLevelInfo);
  }
  
  private void onUpdate_hotChatAioPostTabRedPointComing(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aM) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    onBuluoHotChatRedPointComing(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_joinOrExitOpenTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aF) {
      return;
    }
    paramObject = (Object[])paramObject;
    if (paramObject.length > 3)
    {
      onJoinOrExitOpenTroop(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), ((Boolean)paramObject[3]).booleanValue(), ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue());
      return;
    }
    onJoinOrExitOpenTroop(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), false, 0, 0);
  }
  
  private void onUpdate_modifyHwTroopMemberCardInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.as) {
      return;
    }
    paramObject = (Object[])paramObject;
    onModifyHwTroopMemberCardInfo(((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
  }
  
  private void onUpdate_modifyTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.l) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        onModifyTroopInfo(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2]);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.troopinfo", 2, paramObject.toString());
  }
  
  private void onUpdate_modifyTroopMemberCardPush(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.q) {
      return;
    }
    onModifyTroopInfoPushResult(paramBoolean, (ArrayList)paramObject);
  }
  
  private void onUpdate_notifyActiveExtTroopSuccess(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.by) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    onActiveExtTroop(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_notifyAddContactFindTroopClassify(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bP) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    onGetAddContactFindTroopClassify(paramBoolean, (ArrayList)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_notifyAddContactFindTroopGetNearbyDatas(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if (paramInt != TroopNotificationConstants.bR) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    int i = ((Integer)paramObject[1]).intValue();
    int j = ((Integer)paramObject[2]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[3];
    boolean bool2 = ((Boolean)paramObject[4]).booleanValue();
    if (j == 1) {}
    for (;;)
    {
      onGetAddContactFindTroopNearbyTroop(paramBoolean, paramInt, i, bool1, localArrayList, bool2);
      return;
      bool1 = false;
    }
  }
  
  private void onUpdate_notifyAddContactFindTroopGetRecommendDatas(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool1 = true;
    if (paramInt != TroopNotificationConstants.bQ) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    paramInt = ((Integer)paramObject[0]).intValue();
    String str = (String)paramObject[1];
    int i = ((Integer)paramObject[2]).intValue();
    int j = ((Integer)paramObject[3]).intValue();
    ArrayList localArrayList = (ArrayList)paramObject[4];
    boolean bool2 = ((Boolean)paramObject[5]).booleanValue();
    if (j == 1) {}
    for (;;)
    {
      onGetAddContactFindTroopRecommendTroop(paramBoolean, paramInt, str, i, bool1, localArrayList, bool2);
      return;
      bool1 = false;
    }
  }
  
  private void onUpdate_notifyAddTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bx) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    onAddTroopSuccess((String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_notifyAssignHomework(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bo) {
      return;
    }
    long l;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        l = ((Long)paramObject[0]).longValue();
        if (paramObject.length > 1) {
          paramInt = ((Integer)paramObject[1]).intValue();
        }
      }
    }
    for (;;)
    {
      onAssignHomework(paramBoolean, l, paramInt);
      return;
      paramInt = 0;
      continue;
      l = -1L;
      break;
      l = -1L;
      paramInt = 0;
    }
  }
  
  private void onUpdate_notifyBatchAddfrdsDataPrepareErr(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bj) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchAddFrdsDataPrepareErr(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue());
  }
  
  private void onUpdate_notifyBatchGetTroopProfile(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bK) {
      return;
    }
    boolean bool = true;
    if ((paramObject instanceof Object[])) {
      bool = ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue();
    }
    onGetOnePageTroopInfo(paramBoolean, bool);
  }
  
  private void onUpdate_notifyBatchReqCommfrds(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bb) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchReqMemberCmnFrds(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Long)paramObject[2]).longValue(), ((Integer)paramObject[3]).intValue(), ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), (HashMap)paramObject[6], (List)paramObject[7]);
  }
  
  private void onUpdate_notifyBatchReqRemark(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bi) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopBatchGetMemberRemark(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue(), ((Integer)paramObject[2]).intValue(), ((Boolean)paramObject[3]).booleanValue());
  }
  
  private void onUpdate_notifyBulkSendMessageResult(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.br) {
      return;
    }
    paramObject = (Object[])paramObject;
    onBulkSendMessage(paramBoolean, (homework.RspSend1V1Msg)paramObject[0], (homework.ReqSend1V1Msg)paramObject[1]);
  }
  
  private void onUpdate_notifyEssenceMsgListChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cd) {}
    while (!(paramObject instanceof Long)) {
      return;
    }
    onEssenceMsgListChange(((Long)paramObject).longValue());
  }
  
  private void onUpdate_notifyExitTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bw) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onPassiveExit((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_notifyGetAddRobot(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bB) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    onGetAddedRobots(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (ArrayList)paramObject[2]);
  }
  
  private void onUpdate_notifyGetAddTroopAppRemindInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ce) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        onGetAddTroopAppRemindInfo(paramBoolean, ((Long)paramObject[0]).longValue(), paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      onGetAddTroopAppRemindInfo(false, 0L, null, -1);
      return;
    }
    onGetAddTroopAppRemindInfo(false, 0L, null, -1);
  }
  
  private void onUpdate_notifyGetAllRobot(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bC) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    onGetAllRobots(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), (TroopRobotData)paramObject[2]);
  }
  
  private void onUpdate_notifyGetAllStarLeagueTroopMembers(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bs) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetAllStarLeagueMembers(paramBoolean, (String)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_notifyGetGroupInviteStauts(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bA) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      onGetGroupInviteStatus(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), (ArrayList)paramObject[3], ((Integer)paramObject[4]).intValue());
      return;
    }
    onGetGroupInviteStatus(false, -1, 0, 0, null, 0);
  }
  
  private void onUpdate_notifyGetHomeworkInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bp) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      localObject1 = localObject2;
      if (paramObject.length > 0) {
        localObject1 = (HomeworkInfo)paramObject[0];
      }
    }
    onGetHomeworkInfo(paramBoolean, (HomeworkInfo)localObject1);
  }
  
  private void onUpdate_notifyGetLatestMemo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bz) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onGetTroopLatestMemo(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_notifyGetMemberGameCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.co) {
      return;
    }
    Object localObject;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      localObject = (Object[])paramObject;
      if (localObject.length == 3) {
        if (!(localObject[0] instanceof String)) {
          break label132;
        }
      }
    }
    label132:
    for (paramObject = (String)localObject[0];; paramObject = null)
    {
      if ((localObject[1] instanceof String)) {}
      for (String str = (String)localObject[1];; str = null)
      {
        if ((localObject[2] instanceof ProfileGameInfo)) {}
        for (localObject = (ProfileGameInfo)localObject[2];; localObject = null)
        {
          onGetTroopMemberGameCard(paramBoolean, paramObject, str, (ProfileGameInfo)localObject);
          return;
          onGetTroopMemberGameCard(paramBoolean, null, null, null);
          return;
          onGetTroopMemberGameCard(paramBoolean, null, null, null);
          return;
        }
      }
    }
  }
  
  private void onUpdate_notifyGetMemberGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cm) {
      return;
    }
    Object[] arrayOfObject;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3) {
        if (!(arrayOfObject[0] instanceof Long)) {
          break label144;
        }
      }
    }
    label144:
    for (paramObject = (Long)arrayOfObject[0];; paramObject = Long.valueOf(0L))
    {
      if ((arrayOfObject[1] instanceof Long)) {}
      for (Long localLong1 = (Long)arrayOfObject[1];; localLong1 = Long.valueOf(0L))
      {
        Long localLong2 = Long.valueOf(0L);
        if ((arrayOfObject[2] instanceof Long)) {
          localLong2 = (Long)arrayOfObject[2];
        }
        onGetMemberGameCardSwitch(paramBoolean, paramObject.longValue(), localLong1.longValue(), localLong2.longValue());
        return;
        onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
        return;
        onGetMemberGameCardSwitch(false, 0L, 0L, 0L);
        return;
      }
    }
  }
  
  private void onUpdate_notifyGetNewTroopHead(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bc) {
      return;
    }
    paramObject = (Pair)paramObject;
    onUpdateNewTroopFaceIcon(paramBoolean, ((Boolean)paramObject.first).booleanValue(), (String)paramObject.second);
  }
  
  private void onUpdate_notifyGetRelationTroopList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ci) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof Integer)) && ((paramObject[2] instanceof Long)) && ((paramObject[3] instanceof AllianceItem)))
      {
        onGetRelatedTroopList(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Long)paramObject[2]).longValue(), (AllianceItem)paramObject[3]);
        return;
      }
      onGetRelatedTroopList(false, "", -1, -1L, null);
      return;
    }
    onGetRelatedTroopList(false, "", -1, -1L, null);
  }
  
  private void onUpdate_notifyGetSignInStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cg) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 4) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)) && ((paramObject[3] instanceof Integer)))
      {
        onGetSignInStatus(paramBoolean, (String)paramObject[0], (String)paramObject[1], paramObject[2], ((Integer)paramObject[3]).intValue());
        return;
      }
      onGetSignInStatus(false, "", "", null, -1);
      return;
    }
    onGetSignInStatus(false, "", "", null, -1);
  }
  
  private void onUpdate_notifyGetTroopAppShortcut(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bT) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        onGetShortcutTroopApps(paramBoolean, paramObject[0], paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      onGetShortcutTroopApps(false, null, null, -1);
      return;
    }
    onGetShortcutTroopApps(false, null, null, -1);
  }
  
  private void onUpdate_notifyGetTroopGameCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cn) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 2) && ((paramObject[0] instanceof String)))
      {
        if ((paramObject[1] instanceof TroopGameInfo))
        {
          onGetTroopGameGameCard(paramBoolean, (String)paramObject[0], (TroopGameInfo)paramObject[1]);
          return;
        }
        onGetTroopGameGameCard(paramBoolean, (String)paramObject[0], null);
        return;
      }
      onGetTroopGameGameCard(paramBoolean, null, null);
      return;
    }
    onGetTroopGameGameCard(paramBoolean, null, null);
  }
  
  private void onUpdate_notifyGetTroopLuckyCharacterStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cp) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length != 2) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof String)));
    onGetToopLuckyCharacterStatus(paramBoolean, (String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_notifyGetTroopRobotPrivilege(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bE) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    onGetTroopRobotPrivilege(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void onUpdate_notifyModifyMemberGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cl) {
      return;
    }
    Object[] arrayOfObject;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3) {
        if (!(arrayOfObject[0] instanceof Long)) {
          break label144;
        }
      }
    }
    label144:
    for (paramObject = (Long)arrayOfObject[0];; paramObject = Long.valueOf(0L))
    {
      if ((arrayOfObject[1] instanceof Long)) {}
      for (Long localLong = (Long)arrayOfObject[1];; localLong = Long.valueOf(0L))
      {
        String str = "";
        if ((arrayOfObject[2] instanceof String)) {
          str = (String)arrayOfObject[2];
        }
        onModifyMemberGameCardSwitch(paramBoolean, paramObject.longValue(), localLong.longValue(), str);
        return;
        onModifyMemberGameCardSwitch(false, 0L, 0L, "");
        return;
        onModifyMemberGameCardSwitch(false, 0L, 0L, "");
        return;
      }
    }
  }
  
  private void onUpdate_notifyModifyTroopGameCardSwitch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ck) {
      return;
    }
    Object[] arrayOfObject;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3) {
        if (!(arrayOfObject[0] instanceof Long)) {
          break label144;
        }
      }
    }
    label144:
    for (paramObject = (Long)arrayOfObject[0];; paramObject = Long.valueOf(0L))
    {
      if ((arrayOfObject[1] instanceof Long)) {}
      for (Long localLong = (Long)arrayOfObject[1];; localLong = Long.valueOf(0L))
      {
        String str = "";
        if ((arrayOfObject[2] instanceof String)) {
          str = (String)arrayOfObject[2];
        }
        onModifyTroopGameCardSwitch(paramBoolean, paramObject.longValue(), localLong.longValue(), str);
        return;
        onModifyTroopGameCardSwitch(false, 0L, 0L, "");
        return;
        onModifyTroopGameCardSwitch(false, 0L, 0L, "");
        return;
      }
    }
  }
  
  private void onUpdate_notifyModifyTroopNickRule(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cf) {
      return;
    }
    Object[] arrayOfObject;
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length == 3) {
        if (!(arrayOfObject[0] instanceof Long)) {
          break label144;
        }
      }
    }
    label144:
    for (paramObject = (Long)arrayOfObject[0];; paramObject = Long.valueOf(0L))
    {
      if ((arrayOfObject[1] instanceof Long)) {}
      for (Long localLong = (Long)arrayOfObject[1];; localLong = Long.valueOf(0L))
      {
        String str = "";
        if ((arrayOfObject[2] instanceof String)) {
          str = (String)arrayOfObject[2];
        }
        onModifyTroopNickRule(paramBoolean, paramObject.longValue(), localLong.longValue(), str);
        return;
        onModifyTroopNickRule(false, 0L, 0L, "");
        return;
        onModifyTroopNickRule(false, 0L, 0L, "");
        return;
      }
    }
  }
  
  private void onUpdate_notifyOidb_0xD22_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bH) {
      return;
    }
    String str = "";
    if ((paramObject instanceof Object[])) {
      str = (String)((Object[])(Object[])paramObject)[0];
    }
    onGetCreateTroopTokenForThirdApp(paramBoolean, str);
  }
  
  private void onUpdate_notifyOidb_0xD22_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bI) {
      return;
    }
    String str1 = "";
    String str2 = "";
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      str1 = (String)paramObject[0];
      str2 = (String)paramObject[1];
    }
    onGetJoinTroopTokenForThirdApp(paramBoolean, str1, str2);
  }
  
  private void onUpdate_notifyOidb_0xD23_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bJ) {
      return;
    }
    paramInt = -1;
    long l = 0L;
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      paramInt = ((Integer)paramObject[0]).intValue();
      l = ((Long)paramObject[1]).longValue();
    }
    onBindTroopForThirdApp(paramBoolean, paramInt, l);
  }
  
  private void onUpdate_notifyReadyForTroopBatchAddTip(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bl) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    if (arrayOfObject[2] != null) {}
    for (paramObject = (List)arrayOfObject[2];; paramObject = null)
    {
      onTroopBatchAddFrdsReadyForTip(paramBoolean, (String)arrayOfObject[0], ((Integer)arrayOfObject[1]).intValue(), paramObject);
      return;
    }
  }
  
  private void onUpdate_notifySetRobot(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bD) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramObject instanceof Object[]));
        paramObject = (Object[])paramObject;
      } while (paramObject.length < 4);
      paramInt = ((Integer)paramObject[3]).intValue();
      if (paramInt == 0)
      {
        onDeleteRobot(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
        return;
      }
    } while (paramInt != 1);
    onAddRobot(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Long)paramObject[1]).longValue(), ((Long)paramObject[2]).longValue());
  }
  
  private void onUpdate_notifySetSignInStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ch) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if ((paramObject.length == 3) && ((paramObject[0] instanceof String)) && ((paramObject[1] instanceof String)))
      {
        onSetSignInStatus(paramBoolean, (String)paramObject[0], (String)paramObject[1], paramObject[2]);
        return;
      }
      onSetSignInStatus(false, "", "", null);
      return;
    }
    onSetSignInStatus(false, "", "", null);
  }
  
  private void onUpdate_notifySubmitHomework(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bq) {
      return;
    }
    int i = 0;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Integer)) {
        paramInt = ((Integer)paramObject).intValue();
      }
    }
    onSubmitHomework(paramBoolean, paramInt);
  }
  
  private void onUpdate_notifyTroopClassChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ca) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length != 2) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof Long)));
    onTroopClassExtChanged(paramBoolean, (String)paramObject[0], ((Long)paramObject[1]).longValue());
  }
  
  private void onUpdate_notifyTroopClearAppRedPoint(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aw) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onClearTroopAppRedPoint(Boolean.valueOf(paramBoolean), (ArrayList)paramObject[0], (List)paramObject[1]);
  }
  
  private void onUpdate_notifyTroopDataCardGetRecommendTroop(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    if (paramInt != TroopNotificationConstants.bL) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    long l = ((Long)paramObject[0]).longValue();
    paramInt = ((Integer)paramObject[1]).intValue();
    int i = ((Integer)paramObject[2]).intValue();
    paramObject = (ArrayList)paramObject[3];
    if (i == 1) {}
    for (;;)
    {
      onGetTroopDataCardRecommendTroop(paramBoolean, l, paramInt, bool, paramObject);
      return;
      bool = false;
    }
  }
  
  private void onUpdate_notifyTroopEnterEffectPush(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aT) {
      return;
    }
    onPushTroopEnterEffect((TroopEnterEffectController.TroopEnterEffectData)paramObject);
  }
  
  private void onUpdate_notifyTroopFileRedDotTim(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bv) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    onTroopFileRedDotForTimShow(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_notifyTroopFlagExt3Update(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt != TroopNotificationConstants.cb) || (!paramBoolean)) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    onTroopFlagExt3Update((String)paramObject[0], ((Long)paramObject[1]).longValue());
  }
  
  private void onUpdate_notifyTroopFlagExt4Change(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bY) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length != 2) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof Integer)));
    onTroopFlagExt4Changed(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_notifyTroopGetAppList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.au) {
      return;
    }
    onGetTroopAppList(Boolean.valueOf(paramBoolean));
  }
  
  private void onUpdate_notifyTroopHonorUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bM) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    onTroopHonorUpdate((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_notifyTroopMemberChanged(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bd) {
      return;
    }
    onTroopMemberUpdate();
  }
  
  private void onUpdate_notifyTroopMiniAppEntranceRedPoint(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bG) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 2);
    onUpdateTroopMiniAppEntranceRedPoint((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void onUpdate_notifyTroopOpenApiTokenVerify(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.at) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopOpenApiVerifyed(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue(), ((Integer)paramObject[5]).intValue(), (ArrayList)paramObject[6], ((Integer)paramObject[7]).intValue(), ((Integer)paramObject[8]).intValue());
  }
  
  private void onUpdate_notifyTroopRankSwitchUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bW) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 2);
    onTroopRankSwitchUpdate((String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void onUpdate_notifyTroopRankTitleUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bO) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 3);
    onTroopRankTitleUpdate((String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  private void onUpdate_notifyTroopRecommendGrayTipGetPersonList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bS) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length < 5);
    onGetTroopRecommendGrayTipsPerson(paramBoolean, (String)paramObject[0], (ArrayList)paramObject[1], (byte[])paramObject[2], ((Boolean)paramObject[3]).booleanValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_notifyTroopRemarkChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cr) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length < 2) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof Integer)));
    onModifyTroopRemarkResult(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
    onUpdateTroopRemark((String)paramObject[0]);
  }
  
  private void onUpdate_notifyTroopRewardChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aE) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopRewardChangeNotify((String)paramObject[0], (String)paramObject[1]);
  }
  
  private void onUpdate_notifyTroopRobotChangeByWeb(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bF) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      localObject = (Object[])paramObject;
    } while (localObject.length < 4);
    paramObject = (Boolean)localObject[0];
    String str1 = (String)localObject[1];
    String str2 = (String)localObject[2];
    Object localObject = (String)localObject[3];
    if (paramObject.booleanValue())
    {
      onAddRobotByWeb(str1, str2, (String)localObject);
      return;
    }
    onDelRobotByWeb(str1, str2, (String)localObject);
  }
  
  private void onUpdate_notifyTroopRobotRed(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bN) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2)
      {
        onGetRobotsRedList(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
        return;
      }
      onGetRobotsRedList(false, 0L, null);
      return;
    }
    onGetRobotsRedList(false, 0L, null);
  }
  
  private void onUpdate_notifyTroopSortAppList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.av) {
      return;
    }
    onSortedTroopAppList(Boolean.valueOf(paramBoolean));
  }
  
  private void onUpdate_notifyTroopUpgradeSuccess(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aa) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onNotifyTroopUpgradeSuccess((String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_notifyUpdateTitleBtnCall(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aB) {
      return;
    }
    onNotifyUpdateTitleBtnCall(paramBoolean, paramObject);
  }
  
  private void onUpdate_notifyUpdateTroopInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.be) {
      return;
    }
    onTroopInfoUpdate((String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_notify_HasNewApp(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bV) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    onTroopAppHasNew(paramBoolean, (String)paramObject[0]);
  }
  
  private void onUpdate_notify_QueryJoinTroopCanNoVerify(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.bU) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
      if (paramObject.length == 5)
      {
        onQueryJoinTroopCanNoVerify(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1], (String)paramObject[2], (String)paramObject[3], ((Integer)paramObject[4]).intValue());
        return;
      }
    } while (paramObject.length != 2);
    onQueryJoinTroopWhetherHighRisk(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
  }
  
  private void onUpdate_notify_TroopBlocked(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.cc) {}
    do
    {
      do
      {
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    onTroopBlockStatusChanged((String)paramObject[0]);
  }
  
  private void onUpdate_oidb_0x88D_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.s) {
      return;
    }
    paramObject = (Object[])paramObject;
    Object[] arrayOfObject = new Object[2];
    if (paramObject.length == 7)
    {
      arrayOfObject[0] = paramObject[5];
      arrayOfObject[1] = paramObject[6];
    }
    onOIDB0X88D_0_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4], arrayOfObject);
  }
  
  private void onUpdate_oidb_0x88D_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.A) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X88D_1_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (TroopInfo)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_oidb_0x899_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.t) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X899_0_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void onUpdate_oidb_0x899_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.u) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X899_1_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), ((Integer)paramObject[1]).intValue(), (List)paramObject[2], ((Long)paramObject[3]).longValue(), ((Integer)paramObject[4]).intValue(), (String)paramObject[5]);
  }
  
  private void onUpdate_oidb_0x89E_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.v) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0X89E_0_Ret(paramBoolean, ((Long)paramObject[0]).longValue(), (String)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), (String)paramObject[4]);
  }
  
  private void onUpdate_oidb_0x903_2(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aN) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        onGetInvitedUinList(paramBoolean, (Long)paramObject[0], (List)paramObject[1]);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("onGetInvitedUinList", 2, paramObject.toString());
  }
  
  private void onUpdate_oidb_0x91A_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aO) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        onGetTroopAuditTimes(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (oidb_0x88d.GroupInfo)paramObject[4]);
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("oidb_0x91a_1", 2, paramObject.toString());
  }
  
  private void onUpdate_oidb_0x91B_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aP) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject != null) && (paramObject.length > 1))
    {
      onSetTroopAuditTimes(paramBoolean, ((Integer)paramObject[0]).intValue(), (String)paramObject[1]);
      return;
    }
    onSetTroopAuditTimes(paramBoolean, -1, "");
  }
  
  private void onUpdate_oidb_0x91C_1(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aQ) {}
    do
    {
      return;
      try
      {
        paramObject = (Object[])paramObject;
        onGetTroopAuthSubmitTime(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.d("oidb_0x91a_1", 2, paramObject.toString());
  }
  
  private void onUpdate_oidb_0xA80_0(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.az) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOIDB0XA80_0_Ret(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void onUpdate_operateSpecialFocus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.T) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onOperateSpecialFocus(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), (long[])paramObject[2]);
  }
  
  private void onUpdate_queryTroopFeeMemberList(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ay) {
      return;
    }
    onGetTroopFeeMemberList(paramBoolean, (List)paramObject);
  }
  
  private void onUpdate_setInvite2GroupAutoAgree(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aK) {
      return;
    }
    onSend0x4ff_86Rsp(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
  }
  
  private void onUpdate_setTroopExternalStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ac) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onSetTroopShowExternalStatus(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue());
  }
  
  private void onUpdate_troopLink(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.n) {
      return;
    }
    onTroopShareLink(paramBoolean, (TroopShareResp)paramObject);
  }
  
  private void onUpdate_troopManager(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.f) {
      return;
    }
    paramObject = (Object[])paramObject;
    if ((paramObject[1] instanceof Integer)) {}
    for (paramInt = ((Integer)paramObject[1]).intValue(); paramBoolean; paramInt = ((Byte)paramObject[1]).byteValue())
    {
      onTroopManagerSuccess(((Integer)paramObject[0]).intValue(), paramInt, (String)paramObject[2]);
      return;
    }
    onTroopManagerFailed(((Integer)paramObject[0]).intValue(), paramInt);
  }
  
  private void onUpdate_troopNewFeedComing(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ak) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onTroopNewFeedsComing(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Boolean)paramObject[2]).booleanValue());
  }
  
  private void onUpdate_troopNewFeedNeedAutoPullDown(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.ap) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 3);
    onTroopNewFeedsAutoPullDown(paramBoolean, (String)paramObject[0], (String)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  private void onUpdate_troopSearch(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.g) {
      return;
    }
    Object[] arrayOfObject = (Object[])paramObject;
    byte b = ((Byte)arrayOfObject[0]).byteValue();
    if (arrayOfObject[1] != null) {}
    for (paramObject = (TroopInfo)arrayOfObject[1];; paramObject = null)
    {
      onTroopSearch(true, b, paramObject, ((Boolean)arrayOfObject[2]).booleanValue());
      return;
    }
  }
  
  private void onUpdate_troopSurveyListUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.jdField_a_of_type_Int) {
      return;
    }
    onGetHomeworkSurvey(paramBoolean, (String)((Object[])(Object[])paramObject)[0]);
  }
  
  private void onUpdate_uniqueTitleChanged(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.am) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onUniqueTitleChanged((String)paramObject[0], (String)paramObject[1], (String)paramObject[2]);
  }
  
  private void onUpdate_updateGameOnlineSwitchStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.aW) {
      return;
    }
    paramObject = (Object[])paramObject;
    onUpdateGameOnlineSwitchStatus(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
  }
  
  private void onUpdate_updateTroopUnreadMsg(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != TroopNotificationConstants.E) {}
    while (!(paramObject instanceof Object[])) {
      return;
    }
    paramObject = (Object[])paramObject;
    onUpdateTroopUnreadMsg(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), (List)paramObject[1], ((Integer)paramObject[2]).intValue());
  }
  
  protected void onActiveExtTroop(boolean paramBoolean, String paramString) {}
  
  protected void onAddRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void onAddRobotByWeb(String paramString1, String paramString2, String paramString3) {}
  
  protected void onAddTroopSuccess(String paramString) {}
  
  public void onAssignHomework(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void onBAFSecurityCheckResult(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2) {}
  
  protected void onBatchGetTroopInfoResp(boolean paramBoolean, long paramLong, RespBatchProcess paramRespBatchProcess, Bundle paramBundle) {}
  
  protected void onBatchTroopCardDefaultNick(boolean paramBoolean, Object paramObject) {}
  
  protected void onBeKickOutTroop(String paramString) {}
  
  protected void onBindTroopForThirdApp(boolean paramBoolean, int paramInt, long paramLong) {}
  
  protected void onBulkSendMessage(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg) {}
  
  protected void onBuluoHotChatRedPointComing(boolean paramBoolean, String paramString) {}
  
  protected void onChangeGroupClassExt(boolean paramBoolean, String paramString, long paramLong1, long paramLong2) {}
  
  protected void onChangeTroopAIORedPoint(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2) {}
  
  protected void onCleanOnlineMemberList(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void onClearTroopAppRedPoint(Boolean paramBoolean, ArrayList<Integer> paramArrayList, List<cmd0xca05.Result> paramList) {}
  
  protected void onCmdTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void onDelRobotByWeb(String paramString1, String paramString2, String paramString3) {}
  
  protected void onDeleteRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList) {}
  
  protected void onDeleteTroopMember(boolean paramBoolean, int paramInt, ArrayList<String> paramArrayList, String paramString) {}
  
  protected void onEditTroopLocationRet(long paramLong, int paramInt1, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {}
  
  protected void onEssenceMsgListChange(long paramLong) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2) {}
  
  protected void onGetAddContactFindTroopClassify(boolean paramBoolean, ArrayList<AddContactFindTroopClassifyInfo> paramArrayList) {}
  
  protected void onGetAddContactFindTroopNearbyTroop(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void onGetAddContactFindTroopRecommendTroop(boolean paramBoolean1, int paramInt1, String paramString, int paramInt2, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList, boolean paramBoolean3) {}
  
  protected void onGetAddTroopAppRemindInfo(boolean paramBoolean, long paramLong, Object paramObject, int paramInt) {}
  
  protected void onGetAddTroopWebInfo(String paramString) {}
  
  protected void onGetAddedRobots(boolean paramBoolean, int paramInt, long paramLong, ArrayList<TroopRobotInfo> paramArrayList) {}
  
  protected void onGetAllGameOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void onGetAllOnlineMemberList(boolean paramBoolean, String paramString, List<String> paramList) {}
  
  protected void onGetAllRobots(boolean paramBoolean, int paramInt, long paramLong, TroopRobotData paramTroopRobotData) {}
  
  protected void onGetAllStarLeagueMembers(boolean paramBoolean, String paramString, List<oidb_0xa2a.UserInfo> paramList) {}
  
  protected void onGetAnonyChatNick(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, String paramString4) {}
  
  protected void onGetAtAllRemianCountInfo(boolean paramBoolean1, String paramString1, boolean paramBoolean2, String paramString2, String paramString3, boolean paramBoolean3) {}
  
  protected void onGetAutoAgreeInvite2GroupIn50Flag(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetBatchCmnFrdsCnt(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, long paramLong, int paramInt, boolean paramBoolean3, HashMap<String, Integer> paramHashMap) {}
  
  protected void onGetCreateTroopTokenForThirdApp(boolean paramBoolean, String paramString) {}
  
  protected void onGetEssenceSwitchForShowInTroopCard(boolean paramBoolean, String paramString, TroopInfo paramTroopInfo) {}
  
  protected void onGetExtShowTroopList(boolean paramBoolean, int paramInt, List<ShowExternalTroop> paramList, List<String> paramList1) {}
  
  protected void onGetExtShowTroopStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  protected void onGetFollowStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void onGetGolbalTroopLevel(boolean paramBoolean, long paramLong, int paramInt) {}
  
  protected void onGetGroupInviteStatus(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4) {}
  
  public void onGetHomeworkInfo(boolean paramBoolean, HomeworkInfo paramHomeworkInfo) {}
  
  protected void onGetHomeworkSurvey(boolean paramBoolean, String paramString) {}
  
  protected void onGetHomeworkTab(String paramString) {}
  
  protected void onGetHomeworkTroopIdentity(boolean paramBoolean, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {}
  
  protected void onGetHwTroopMemberCardInfo(int paramInt, String paramString, group_mgr.CardInfo paramCardInfo) {}
  
  protected void onGetInviteNoAuthLimitNum(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void onGetInvitedUinList(boolean paramBoolean, Long paramLong, List<Long> paramList) {}
  
  protected void onGetJoinTroopTokenForThirdApp(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetMaxTroopAdminNum(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onGetMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, long paramLong3) {}
  
  protected void onGetNewTroopAppList(oidb_0xe83.RspBody paramRspBody, int paramInt) {}
  
  protected void onGetOnePageTroopInfo(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetPayToJoinTroopStatus(boolean paramBoolean1, String paramString1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString2) {}
  
  protected void onGetRelatedTroopList(boolean paramBoolean, String paramString, int paramInt, long paramLong, AllianceItem paramAllianceItem) {}
  
  protected void onGetRobotsRedList(boolean paramBoolean, long paramLong, ArrayList<String> paramArrayList) {}
  
  public void onGetShortcutTroopApps(boolean paramBoolean, Object paramObject1, Object paramObject2, int paramInt) {}
  
  protected void onGetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject, int paramInt) {}
  
  protected void onGetToopLuckyCharacterStatus(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetTroopAioNotifyFeeds(boolean paramBoolean, String paramString, List<TroopAIONotifyItem> paramList) {}
  
  protected void onGetTroopAppList(Boolean paramBoolean) {}
  
  protected void onGetTroopAuditTimes(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo) {}
  
  protected void onGetTroopAuthSubmitTime(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onGetTroopAvatar(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, List<TroopClipPic> paramList) {}
  
  protected void onGetTroopCreditLevelInfo(boolean paramBoolean, long paramLong) {}
  
  protected void onGetTroopDataCardRecommendTroop(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2, ArrayList<RecommendTroopItem> paramArrayList) {}
  
  protected void onGetTroopFeeMemberList(boolean paramBoolean, List<cmd0x406.GroupFeeMember> paramList) {}
  
  protected void onGetTroopGameGameCard(boolean paramBoolean, String paramString, TroopGameInfo paramTroopGameInfo) {}
  
  protected void onGetTroopHideWebConfig(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong) {}
  
  protected void onGetTroopLatestMemo(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetTroopMemberAutoRemark(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onGetTroopMemberGameCard(boolean paramBoolean, String paramString1, String paramString2, ProfileGameInfo paramProfileGameInfo) {}
  
  protected void onGetTroopMemberMaxNum(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onGetTroopNickNameFinish(boolean paramBoolean, long paramLong, long[] paramArrayOfLong, String[] paramArrayOfString) {}
  
  protected void onGetTroopRecommendGrayTipsPerson(boolean paramBoolean1, String paramString1, ArrayList<RecommendMember> paramArrayList, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString2) {}
  
  protected void onGetTroopRobotPrivilege(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2) {}
  
  protected void onGetTroopTagResult(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onGetUinByOpenId(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ProfileActivity.AllInOne paramAllInOne) {}
  
  protected void onJoinOrExitOpenTroop(boolean paramBoolean1, String paramString, int paramInt1, boolean paramBoolean2, boolean paramBoolean3, int paramInt2, int paramInt3) {}
  
  protected void onJoinTroopSecurityTips(boolean paramBoolean, String paramString, int paramInt, long paramLong) {}
  
  protected void onModifyHwTroopMemberCardInfo(int paramInt, String paramString) {}
  
  protected void onModifyMemberGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  protected void onModifyTroopGameCardSwitch(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  protected void onModifyTroopInfo(boolean paramBoolean, long paramLong, int paramInt, TroopInfo paramTroopInfo) {}
  
  protected void onModifyTroopInfoPushResult(boolean paramBoolean, ArrayList<TroopMemberCardInfo> paramArrayList) {}
  
  protected void onModifyTroopNickRule(boolean paramBoolean, long paramLong1, long paramLong2, String paramString) {}
  
  protected void onModifyTroopRemarkResult(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onNotifyTroopUpgradeSuccess(String paramString, int paramInt) {}
  
  protected void onNotifyUpdateTitleBtnCall(boolean paramBoolean, Object paramObject) {}
  
  protected void onOIDB0X88D_0_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString, Object[] paramArrayOfObject) {}
  
  protected void onOIDB0X88D_1_Ret(boolean paramBoolean, long paramLong, int paramInt1, TroopInfo paramTroopInfo, int paramInt2, String paramString) {}
  
  protected void onOIDB0X899_0_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void onOIDB0X899_1_Ret(boolean paramBoolean, long paramLong1, int paramInt1, List<oidb_0x899.memberlist> paramList, long paramLong2, int paramInt2, String paramString) {}
  
  protected void onOIDB0X89E_0_Ret(boolean paramBoolean, long paramLong, String paramString1, String paramString2, int paramInt, String paramString3) {}
  
  protected void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2) {}
  
  protected void onOperateSpecialFocus(boolean paramBoolean, String paramString, int paramInt, long[] paramArrayOfLong) {}
  
  protected void onPassiveExit(String paramString, int paramInt) {}
  
  protected void onPushTroopEnterEffect(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData) {}
  
  public void onQueryJoinTroopCanNoVerify(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2) {}
  
  public void onQueryJoinTroopWhetherHighRisk(boolean paramBoolean, String paramString, int paramInt) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      onSetTroopAdminSuccess(paramBundle.getString("troop_code"), paramBundle.getString("troop_member_uin"), paramBundle.getByte("operation"));
      return;
    }
    paramInt = 0;
    if (paramBundle != null) {
      paramInt = paramBundle.getInt("error_code");
    }
    onSetTroopAdminFail(paramInt);
  }
  
  protected void onReceiveGVideoLevelInfo(RecvGVideoLevelInfo[] paramArrayOfRecvGVideoLevelInfo) {}
  
  protected void onRecommendTroopBack(boolean paramBoolean, List<RecommendTroopItem> paramList) {}
  
  protected void onSend0x4ff_86Rsp(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetSignInStatus(boolean paramBoolean, String paramString1, String paramString2, Object paramObject) {}
  
  protected void onSetTroopAdminFail(int paramInt) {}
  
  protected void onSetTroopAdminSuccess(String paramString1, String paramString2, byte paramByte) {}
  
  protected void onSetTroopAuditTimes(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void onSetTroopShowExternalStatus(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onSortedTroopAppList(Boolean paramBoolean) {}
  
  public void onSubmitHomework(boolean paramBoolean, int paramInt) {}
  
  protected void onTroopAppHasNew(boolean paramBoolean, String paramString) {}
  
  protected void onTroopBatchAddFrdsDataPrepareErr(boolean paramBoolean, String paramString, long paramLong, int paramInt) {}
  
  protected void onTroopBatchAddFrdsReadyForTip(boolean paramBoolean, String paramString, int paramInt, List<String> paramList) {}
  
  protected void onTroopBatchGetMemberRemark(boolean paramBoolean1, String paramString, long paramLong, int paramInt, boolean paramBoolean2) {}
  
  protected void onTroopBatchReqMemberCmnFrds(boolean paramBoolean1, String paramString1, String paramString2, long paramLong, int paramInt, boolean paramBoolean2, boolean paramBoolean3, HashMap<String, Integer> paramHashMap, List<String> paramList) {}
  
  protected void onTroopBlockStatusChanged(String paramString) {}
  
  protected void onTroopClassExtChanged(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void onTroopFileRedDotForTimShow(boolean paramBoolean, String paramString) {}
  
  protected void onTroopFlagExt3Update(String paramString, long paramLong) {}
  
  protected void onTroopFlagExt4Changed(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onTroopHonorUpdate(String paramString1, String paramString2) {}
  
  protected void onTroopInfoUpdate(String paramString) {}
  
  protected void onTroopManagerFailed(int paramInt1, int paramInt2) {}
  
  protected void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString) {}
  
  protected void onTroopMemberUpdate() {}
  
  protected void onTroopNewFeedsAutoPullDown(boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  protected void onTroopNewFeedsComing(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void onTroopOpenApiVerifyed(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, ArrayList<String> paramArrayList, int paramInt4, int paramInt5) {}
  
  protected void onTroopPrivilege(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4) {}
  
  protected void onTroopRankSwitchUpdate(String paramString, boolean paramBoolean) {}
  
  protected void onTroopRankTitleUpdate(String paramString1, String paramString2, int paramInt) {}
  
  protected void onTroopRewardChangeNotify(String paramString1, String paramString2) {}
  
  protected void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2) {}
  
  public void onTroopShareLink(boolean paramBoolean, TroopShareResp paramTroopShareResp) {}
  
  protected void onUniqueTitleChanged(String paramString1, String paramString2, String paramString3) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    onUpdate_queryTroopFeeMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberListCount(paramInt, paramBoolean, paramObject);
    onUpdate_troopSearch(paramInt, paramBoolean, paramObject);
    onUpdate_troopManager(paramInt, paramBoolean, paramObject);
    onUpdate_batchGetTroopNick(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x903_2(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateTitleBtnCall(paramInt, paramBoolean, paramObject);
    onUpdate_modifyTroopMemberCardPush(paramInt, paramBoolean, paramObject);
    onUpdate_modifyTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x91A_1(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x91B_1(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x91C_1(paramInt, paramBoolean, paramObject);
    onUpdate_getRecommendTroopNew(paramInt, paramBoolean, paramObject);
    onUpdate_editTroopLocation(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x88D_0(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x88D_1(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x899_0(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x899_1(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0x89E_0(paramInt, paramBoolean, paramObject);
    onUpdate_getMaxTroopAdminNum(paramInt, paramBoolean, paramObject);
    onUpdate_updateTroopUnreadMsg(paramInt, paramBoolean, paramObject);
    onUpdate_troopNewFeedComing(paramInt, paramBoolean, paramObject);
    onUpdate_hotChatAioPostTabRedPointComing(paramInt, paramBoolean, paramObject);
    onUpdate_troopNewFeedNeedAutoPullDown(paramInt, paramBoolean, paramObject);
    onUpdate_batchGetTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_delTroopMember(paramInt, paramBoolean, paramObject);
    onUpdate_operateSpecialFocus(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopTag(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopAvatar(paramInt, paramBoolean, paramObject);
    onUpdate_cmdTroopAvatar(paramInt, paramBoolean, paramObject);
    onUpdate_troopLink(paramInt, paramBoolean, paramObject);
    onUpdate_notifyAssignHomework(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetHomeworkInfo(paramInt, paramBoolean, paramObject);
    onUpdate_notifySubmitHomework(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopOpenApiTokenVerify(paramInt, paramBoolean, paramObject);
    onUpdate_getUinByOpenId(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopGetAppList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopSortAppList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopClearAppRedPoint(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopUpgradeSuccess(paramInt, paramBoolean, paramObject);
    onUpdate_getAnonyChatNick(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberMaxNum(paramInt, paramBoolean, paramObject);
    onUpdate_setTroopExternalStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopExternalStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getShowExternalTroopList(paramInt, paramBoolean, paramObject);
    onUpdate_getAtAllCountInfo(paramInt, paramBoolean, paramObject);
    onUpdate_batchGetTroopCardDeafultNick(paramInt, paramBoolean, paramObject);
    onUpdate_getPayToJoinTroopStatus(paramInt, paramBoolean, paramObject);
    onUpdate_checkPrivilege(paramInt, paramBoolean, paramObject);
    onUpdate_beKickOutTroop(paramInt, paramBoolean, paramObject);
    onUpdate_uniqueTitleChanged(paramInt, paramBoolean, paramObject);
    onUpdate_getAddTroopWebInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopCreditInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopHomeworkTab(paramInt, paramBoolean, paramObject);
    onUpdate_getHwTroopMemberCardInfo(paramInt, paramBoolean, paramObject);
    onUpdate_modifyHwTroopMemberCardInfo(paramInt, paramBoolean, paramObject);
    onUpdate_gvideoGetOnlineLevel(paramInt, paramBoolean, paramObject);
    onUpdate_oidb_0xA80_0(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRewardChange(paramInt, paramBoolean, paramObject);
    onUpdate_joinOrExitOpenTroop(paramInt, paramBoolean, paramObject);
    onUpdate_getInviteNoAuthLimitNum(paramInt, paramBoolean, paramObject);
    onUpdate_getFollowStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getGlobalTroopLevel(paramInt, paramBoolean, paramObject);
    onUpdate_setInvite2GroupAutoAgree(paramInt, paramBoolean, paramObject);
    onUpdate_getInvite2GroupAutoAgree(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopNotifyFeeds(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopGetGrayWebConfig(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopEnterEffectPush(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopDetailOnlineMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_cleanTroopDetailOnlineMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_updateGameOnlineSwitchStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getAllTroopOnlineMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopAllGameOnlineMemberList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetAllStarLeagueTroopMembers(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopOnlineMemberEntranceTips(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchReqCommfrds(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchAddfrdsDataPrepareErr(paramInt, paramBoolean, paramObject);
    onUpdate_notifyReadyForTroopBatchAddTip(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchReqRemark(paramInt, paramBoolean, paramObject);
    onUpdate_batchAddFriendSecurityCheck(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetNewTroopHead(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopMemberChanged(paramInt, paramBoolean, paramObject);
    onUpdate_notifyUpdateTroopInfo(paramInt, paramBoolean, paramObject);
    onUpdate_getNewTroopAppList(paramInt, paramBoolean, paramObject);
    onUpdate_getHomeworkTroopIdentity(paramInt, paramBoolean, paramObject);
    onUpdate_changeGroupClassExt(paramInt, paramBoolean, paramObject);
    onUpdate_changeTroopAioRedPoint(paramInt, paramBoolean, paramObject);
    onUpdate_troopSurveyListUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopMemberAutoRemark(paramInt, paramBoolean, paramObject);
    onUpdate_genNewTroopName(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBulkSendMessageResult(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopFileRedDotTim(paramInt, paramBoolean, paramObject);
    onUpdate_notifyExitTroop(paramInt, paramBoolean, paramObject);
    onUpdate_notifyAddTroop(paramInt, paramBoolean, paramObject);
    onUpdate_notifyActiveExtTroopSuccess(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetLatestMemo(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetGroupInviteStauts(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRobotRed(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetAddRobot(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetAllRobot(paramInt, paramBoolean, paramObject);
    onUpdate_notifySetRobot(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopRobotPrivilege(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRobotChangeByWeb(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopMiniAppEntranceRedPoint(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD22_1(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD22_2(paramInt, paramBoolean, paramObject);
    onUpdate_notifyOidb_0xD23_2(paramInt, paramBoolean, paramObject);
    onUpdate_notifyBatchGetTroopProfile(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopDataCardGetRecommendTroop(paramInt, paramBoolean, paramObject);
    onUpdate_notifyAddContactFindTroopGetRecommendDatas(paramInt, paramBoolean, paramObject);
    onUpdate_notifyAddContactFindTroopGetNearbyDatas(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopHonorUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRankTitleUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_notifyAddContactFindTroopClassify(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRecommendGrayTipGetPersonList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopAppShortcut(paramInt, paramBoolean, paramObject);
    onUpdate_notify_QueryJoinTroopCanNoVerify(paramInt, paramBoolean, paramObject);
    onUpdate_notify_HasNewApp(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRankSwitchUpdate(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopFlagExt4Change(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopLuckyCharacterStatus(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopClassChange(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopRemarkChange(paramInt, paramBoolean, paramObject);
    onNotify_JoinTroopSecurityTips(paramInt, paramBoolean, paramObject);
    onUpdate_notifyTroopFlagExt3Update(paramInt, paramBoolean, paramObject);
    onUpdate_notify_TroopBlocked(paramInt, paramBoolean, paramObject);
    onUpdate_notifyEssenceMsgListChange(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetAddTroopAppRemindInfo(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyTroopNickRule(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetSignInStatus(paramInt, paramBoolean, paramObject);
    onUpdate_notifySetSignInStatus(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetRelationTroopList(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyTroopGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyModifyMemberGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetMemberGameCardSwitch(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetTroopGameCard(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetMemberGameCard(paramInt, paramBoolean, paramObject);
    onUpdate_getEssenceSwitchForShowInTroopCard(paramInt, paramBoolean, paramObject);
  }
  
  protected void onUpdateGameOnlineSwitchStatus(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  protected void onUpdateNewTroopFaceIcon(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  protected void onUpdateOnlineMemberList(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onUpdateOnlineMemberTips(boolean paramBoolean, String paramString1, String paramString2) {}
  
  protected void onUpdateTroopGetMemberListProgress(boolean paramBoolean, int paramInt) {}
  
  protected void onUpdateTroopMiniAppEntranceRedPoint(String paramString, boolean paramBoolean) {}
  
  protected void onUpdateTroopRemark(String paramString) {}
  
  protected void onUpdateTroopUnreadMsg(boolean paramBoolean1, boolean paramBoolean2, List<TroopUnreadMsgInfo> paramList, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopBusinessObserver
 * JD-Core Version:    0.7.0.1
 */