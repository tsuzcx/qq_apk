package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.HummerParser.ChatFileInfo;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.qun.group_activity.group_activity.GroupAct;

public class BizTroopObserver
  implements BusinessObserver
{
  private static final String TAG = "BizTroopObserver";
  
  private void onUpdate_confessTalkSwitchChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 44) {
      return;
    }
    onConfessTalkSwitchChange(paramBoolean, paramObject);
  }
  
  private void onUpdate_fetchPreviewInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 20) {
      return;
    }
    onFetchPreviewInfo(paramObject);
  }
  
  private void onUpdate_getIdolInfoOfCard(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 46) {
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Object[])))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length == 3)
      {
        onGetIdolInfoOfCard(paramBoolean, ((Long)paramObject[0]).longValue(), paramObject[1], ((Integer)paramObject[2]).intValue());
        return;
      }
      onGetIdolInfoOfCard(false, 0L, null, -1);
      return;
    }
    onGetIdolInfoOfCard(false, 0L, null, -1);
  }
  
  private void onUpdate_getRecTroopBusinessMsg(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 11) {
      return;
    }
    onGetRecTroopBusinessMsg(paramBoolean, (List)paramObject);
  }
  
  private void onUpdate_getTroopActivityInfo(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 6) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramBoolean)
    {
      onGetTroopActivityInfo(paramBoolean, (String)paramArrayOfObject[0], ((Boolean)paramArrayOfObject[1]).booleanValue(), (List)paramArrayOfObject[2]);
      return;
    }
    onGetTroopActivityInfo(paramBoolean, (String)paramArrayOfObject[0], ((Boolean)paramArrayOfObject[1]).booleanValue(), null);
  }
  
  private void onUpdate_getTroopCreate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 28) {
      return;
    }
    onGetTroopCreate(paramBoolean, paramObject);
  }
  
  private void onUpdate_getTroopCreateAdvance(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 27) {
      return;
    }
    onGetTroopCreateAdvance(paramBoolean, paramObject);
  }
  
  private void onUpdate_getTroopCreatePermission(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 19) {}
  }
  
  private void onUpdate_getTroopNewGuide(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 24) {
      return;
    }
    onGetTroopNewGuide(paramBoolean, paramObject);
  }
  
  private void onUpdate_handleShareLbsBeforeJoinTroop(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 33) {}
    while (paramArrayOfObject == null) {
      return;
    }
    onHandleShareLbsBeforeJoinTroop(paramBoolean, ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue());
  }
  
  private void onUpdate_mMApkFileSafeCheckResult(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 48) {}
    while (paramArrayOfObject == null) {
      return;
    }
    onMMApkFileSafeCheckResult((TroopFileStatusInfo)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)paramArrayOfObject[4], (Bundle)paramArrayOfObject[5]);
  }
  
  private void onUpdate_modifyTroopName(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 43) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramArrayOfObject.length >= 4) {}
    for (paramInt = ((Integer)paramArrayOfObject[3]).intValue();; paramInt = 0)
    {
      onModifyTroopName(paramBoolean, (String)paramArrayOfObject[0], (String)paramArrayOfObject[1], (String)paramArrayOfObject[2], paramInt);
      return;
    }
  }
  
  private void onUpdate_notifyGetFansTroopIdolInfo(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 47) {}
    do
    {
      do
      {
        return;
      } while (!(paramObject instanceof Object[]));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length != 3) || (!(paramObject[0] instanceof String)) || (!(paramObject[1] instanceof String)) || (!(paramObject[2] instanceof Long)));
    onGetFansTroopIdolInfo(paramBoolean, (String)paramObject[0], (String)paramObject[1], (Long)paramObject[2]);
  }
  
  private void onUpdate_reportSelfLbsInfo(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 32) {}
    while (paramArrayOfObject == null) {
      return;
    }
    onReportSelfLbsInfo(paramBoolean, ((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
  }
  
  private void onUpdate_setAnonymousChatResult(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 30) {
      return;
    }
    onSetAnonymousChatResult(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void onUpdate_setCommonUsedTroop(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 18) {}
    while (paramArrayOfObject == null) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfObject.length == 5)
    {
      localObject1 = localObject2;
      if (paramArrayOfObject[4] != null) {
        localObject1 = (String)paramArrayOfObject[4];
      }
    }
    onSetCommonUsedTroop((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)localObject1);
  }
  
  private void onUpdate_setCommonUsedTroopList(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramInt != 42) {}
    do
    {
      return;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BizTroopObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
    return;
    Map localMap;
    if ((paramArrayOfObject[0] instanceof Integer))
    {
      paramInt = ((Integer)paramArrayOfObject[0]).intValue();
      if ((paramArrayOfObject[1] instanceof Integer)) {
        i = ((Integer)paramArrayOfObject[1]).intValue();
      }
      if (!(paramArrayOfObject[2] instanceof Map)) {
        break label122;
      }
      localMap = (Map)paramArrayOfObject[2];
      label90:
      if (!(paramArrayOfObject[3] instanceof String)) {
        break label128;
      }
    }
    label128:
    for (paramArrayOfObject = (String)paramArrayOfObject[3];; paramArrayOfObject = null)
    {
      onSetCommonUsedTroopList(paramInt, i, localMap, paramArrayOfObject);
      return;
      paramInt = -1;
      break;
      label122:
      localMap = null;
      break label90;
    }
  }
  
  private void onUpdate_setPrivilege(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 36) {
      return;
    }
    onSetPrivilege(paramBoolean, paramObject);
  }
  
  private void onUpdate_shareLbsInTroop(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 31) {}
    while (paramArrayOfObject == null) {
      return;
    }
    onShareLbsInTroop(paramBoolean, ((Boolean)paramArrayOfObject[1]).booleanValue());
  }
  
  private void onUpdate_transferDiscussionToGroup(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 41) {
      return;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {}
    for (paramInt = ((Integer)paramArrayOfObject[0]).intValue(); (paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4); paramInt = 2131696116)
    {
      onTransferDiscussionToGroup(paramBoolean, paramInt, (String)paramArrayOfObject[1], (String)paramArrayOfObject[2], (Boolean)paramArrayOfObject[3]);
      return;
    }
    onTransferDiscussionToGroup(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
  }
  
  private void onUpdate_troopFile(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    onTroopFileUpdate(paramBoolean, paramObject);
  }
  
  private void onUpdate_troopFileDel(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    onTroopFileDel(paramBoolean, paramObject);
  }
  
  private void onUpdate_troopFileInfoGetBy0x383(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 39) {
      return;
    }
    onTroopFileInfoGetBy0x383(paramBoolean, paramObject);
  }
  
  private void onUpdate_troopFileReportSimpleError(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 13) {
      return;
    }
    onTroopFileReportSimpleError(paramObject);
  }
  
  private void onUpdate_troopFileSearchBy0x383(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 40) {
      return;
    }
    onTroopFileSearchBy0x383(paramBoolean, paramObject);
  }
  
  private void onUpdate_troopFileStatus(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 9) {
      return;
    }
    onTroopFileStatusUpdate(paramObject);
  }
  
  private void onUpdate_troopFileTrans2Permanent(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 8) {
      return;
    }
    onTroopFileTrans2Permanent(paramBoolean, paramObject);
  }
  
  private void onUpdate_troopGagStatusChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 22) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
    }
    onTroopGagStatusChange((TroopGagMgr.GagStatus)paramObject);
  }
  
  private void onUpdate_troopImage(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 12) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramBoolean)
    {
      onUpdateTroopImage(true, ((Integer)paramArrayOfObject[0]).intValue(), ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (ArrayList)paramArrayOfObject[3], 0);
      return;
    }
    onUpdateTroopImage(false, ((Integer)paramArrayOfObject[2]).intValue(), 0, 0, null, ((Integer)paramArrayOfObject[4]).intValue());
  }
  
  private void onUpdate_troopInfoModifyBy0X89A(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 29) {
      return;
    }
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      onTroopInfoModifyBy0X89A(false, -1L, "");
      return;
    }
    onTroopInfoModifyBy0X89A(paramBoolean, ((Long)paramArrayOfObject[0]).longValue(), (String)paramArrayOfObject[1]);
  }
  
  private void onUpdate_troopInfoModifyExamine(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 38) {
      return;
    }
    if ((paramBoolean) && (paramArrayOfObject != null))
    {
      onTroopInfoModifyExamine(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue(), ((Long)paramArrayOfObject[2]).longValue(), (String)paramArrayOfObject[3]);
      return;
    }
    onTroopInfoModifyExamine(-1L, -1L, -1L, "");
  }
  
  private void onUpdate_troopNotices(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 21) {
      return;
    }
    onUpdateTroopNotices(paramBoolean, paramObject);
  }
  
  private void onUpdate_updateTroopSearchApproachPageTroopInfoUpdated(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 49) {}
    while (!(paramObject instanceof String)) {
      return;
    }
    onUpdateTroopSearchApproachPageTroopInfoUpdated(paramBoolean, (String)paramObject);
  }
  
  private void onUpdate_writeTogetherSwitchChange(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 45) {
      return;
    }
    onWriteTogetherSwitchChange(paramBoolean, paramObject);
  }
  
  protected void onConfessTalkSwitchChange(boolean paramBoolean, Object paramObject) {}
  
  protected void onFetchPreviewInfo(Object paramObject) {}
  
  protected void onGetFansTroopIdolInfo(boolean paramBoolean, String paramString1, String paramString2, Long paramLong) {}
  
  protected void onGetIdolInfoOfCard(boolean paramBoolean, long paramLong, Object paramObject, int paramInt) {}
  
  protected void onGetRecTroopBusinessMsg(boolean paramBoolean, List<group_activity.GroupAct> paramList) {}
  
  public void onGetTroopActivityInfo(boolean paramBoolean1, String paramString, boolean paramBoolean2, List<group_activity_info.GroupActInfo> paramList) {}
  
  protected void onGetTroopCreate(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetTroopCreateAdvance(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetTroopNewGuide(boolean paramBoolean, Object paramObject) {}
  
  protected void onHandleShareLbsBeforeJoinTroop(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  protected void onMMApkFileSafeCheckResult(TroopFileStatusInfo paramTroopFileStatusInfo, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle) {}
  
  public void onModifyTroopName(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  protected void onReportSelfLbsInfo(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void onSetAnonymousChatResult(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onSetCommonUsedTroop(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {}
  
  public void onSetCommonUsedTroopList(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString) {}
  
  protected void onSetPrivilege(boolean paramBoolean, Object paramObject) {}
  
  protected void onShareLbsInTroop(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onTransferDiscussionToGroup(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  protected void onTroopFileDel(boolean paramBoolean, Object paramObject) {}
  
  protected void onTroopFileInfoGetBy0x383(boolean paramBoolean, Object paramObject) {}
  
  protected void onTroopFileReportSimpleError(Object paramObject) {}
  
  protected void onTroopFileSearchBy0x383(boolean paramBoolean, Object paramObject) {}
  
  protected void onTroopFileStatusUpdate(Object paramObject) {}
  
  protected void onTroopFileTrans2Permanent(boolean paramBoolean, Object paramObject) {}
  
  protected void onTroopFileUpdate(boolean paramBoolean, Object paramObject) {}
  
  protected void onTroopGagStatusChange(TroopGagMgr.GagStatus paramGagStatus) {}
  
  protected void onTroopInfoModifyBy0X89A(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void onTroopInfoModifyExamine(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject = null;
    if ((paramObject instanceof Object[])) {
      arrayOfObject = (Object[])paramObject;
    }
    onUpdate_troopFile(paramInt, paramBoolean, paramObject);
    onUpdate_troopFileStatus(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopActivityInfo(paramInt, paramBoolean, arrayOfObject);
    onUpdate_troopFileTrans2Permanent(paramInt, paramBoolean, paramObject);
    onUpdate_troopFileDel(paramInt, paramBoolean, paramObject);
    onUpdate_getRecTroopBusinessMsg(paramInt, paramBoolean, paramObject);
    onUpdate_troopImage(paramInt, paramBoolean, arrayOfObject);
    onUpdate_troopFileReportSimpleError(paramInt, paramBoolean, paramObject);
    onUpdate_fetchPreviewInfo(paramInt, paramBoolean, paramObject);
    onUpdate_setCommonUsedTroop(paramInt, paramBoolean, arrayOfObject);
    onUpdate_setCommonUsedTroopList(paramInt, paramBoolean, arrayOfObject);
    onUpdate_getTroopCreatePermission(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopCreateAdvance(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopCreate(paramInt, paramBoolean, paramObject);
    onUpdate_troopInfoModifyBy0X89A(paramInt, paramBoolean, arrayOfObject);
    onUpdate_troopNotices(paramInt, paramBoolean, paramObject);
    onUpdate_troopGagStatusChange(paramInt, paramBoolean, paramObject);
    onUpdate_setAnonymousChatResult(paramInt, paramBoolean, paramObject);
    onUpdate_getTroopNewGuide(paramInt, paramBoolean, paramObject);
    onUpdate_reportSelfLbsInfo(paramInt, paramBoolean, arrayOfObject);
    onUpdate_handleShareLbsBeforeJoinTroop(paramInt, paramBoolean, arrayOfObject);
    onUpdate_shareLbsInTroop(paramInt, paramBoolean, arrayOfObject);
    onUpdate_setPrivilege(paramInt, paramBoolean, paramObject);
    onUpdate_confessTalkSwitchChange(paramInt, paramBoolean, paramObject);
    onUpdate_troopInfoModifyExamine(paramInt, paramBoolean, arrayOfObject);
    onUpdate_troopFileInfoGetBy0x383(paramInt, paramBoolean, paramObject);
    onUpdate_troopFileSearchBy0x383(paramInt, paramBoolean, paramObject);
    onUpdate_transferDiscussionToGroup(paramInt, paramBoolean, arrayOfObject);
    onUpdate_modifyTroopName(paramInt, paramBoolean, arrayOfObject);
    onUpdate_mMApkFileSafeCheckResult(paramInt, paramBoolean, arrayOfObject);
    onUpdate_writeTogetherSwitchChange(paramInt, paramBoolean, paramObject);
    onUpdate_getIdolInfoOfCard(paramInt, paramBoolean, paramObject);
    onUpdate_notifyGetFansTroopIdolInfo(paramInt, paramBoolean, paramObject);
    onUpdate_updateTroopSearchApproachPageTroopInfoUpdated(paramInt, paramBoolean, paramObject);
  }
  
  public void onUpdateTroopImage(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<HummerParser.ChatFileInfo> paramArrayList, int paramInt4) {}
  
  protected void onUpdateTroopNotices(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateTroopSearchApproachPageTroopInfoUpdated(boolean paramBoolean, String paramString) {}
  
  protected void onWriteTogetherSwitchChange(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BizTroopObserver
 * JD-Core Version:    0.7.0.1
 */