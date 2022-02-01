import QQService.RespTmpChatPicDownload;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import msf.msgsvc.msg_svc.TransSvrInfo;

public class amwl
  implements BusinessObserver
{
  private HashMap<Integer, anny> mMap = new HashMap();
  
  public amwl()
  {
    registerMsgType();
  }
  
  private void registerMsgType()
  {
    this.mMap.put(Integer.valueOf(999), new anod());
    this.mMap.put(Integer.valueOf(1000), new anod());
    this.mMap.put(Integer.valueOf(1003), new anod());
    this.mMap.put(Integer.valueOf(1004), new anod());
    this.mMap.put(Integer.valueOf(1005), new anod());
    this.mMap.put(Integer.valueOf(2000), new anod());
    this.mMap.put(Integer.valueOf(1002), new anod());
    this.mMap.put(Integer.valueOf(2001), new anod());
    this.mMap.put(Integer.valueOf(2002), new anod());
    this.mMap.put(Integer.valueOf(3012), new anod());
    this.mMap.put(Integer.valueOf(3011), new anod());
    this.mMap.put(Integer.valueOf(4003), new annw());
    this.mMap.put(Integer.valueOf(4005), new annw());
    this.mMap.put(Integer.valueOf(4006), new annw());
    this.mMap.put(Integer.valueOf(4011), new annw());
    this.mMap.put(Integer.valueOf(4012), new annw());
    this.mMap.put(Integer.valueOf(4001), new annw());
    this.mMap.put(Integer.valueOf(4004), new annw());
    this.mMap.put(Integer.valueOf(4002), new annw());
    this.mMap.put(Integer.valueOf(4013), new annw());
    this.mMap.put(Integer.valueOf(3021), new annw());
    this.mMap.put(Integer.valueOf(3001), new anoa());
    this.mMap.put(Integer.valueOf(3002), new anoa());
    this.mMap.put(Integer.valueOf(3013), new anoa());
    this.mMap.put(Integer.valueOf(3008), new anoa());
    this.mMap.put(Integer.valueOf(6000), new anoa());
    this.mMap.put(Integer.valueOf(6009), new anoa());
    this.mMap.put(Integer.valueOf(8002), new anoa());
    this.mMap.put(Integer.valueOf(7000), new anoa());
    this.mMap.put(Integer.valueOf(8006), new anoa());
    this.mMap.put(Integer.valueOf(8005), new anoa());
    this.mMap.put(Integer.valueOf(6010), new anoa());
    this.mMap.put(Integer.valueOf(6012), new anoa());
    this.mMap.put(Integer.valueOf(6013), new anoa());
    this.mMap.put(Integer.valueOf(8010), new anoa());
    this.mMap.put(Integer.valueOf(8012), new anoa());
    this.mMap.put(Integer.valueOf(8014), new anoa());
    this.mMap.put(Integer.valueOf(8028), new anoa());
    this.mMap.put(Integer.valueOf(8032), new anoa());
    this.mMap.put(Integer.valueOf(8042), new anoa());
    this.mMap.put(Integer.valueOf(8043), new anoa());
    this.mMap.put(Integer.valueOf(8044), new anoa());
    this.mMap.put(Integer.valueOf(8045), new anoa());
    this.mMap.put(Integer.valueOf(8037), new anoa());
    this.mMap.put(Integer.valueOf(8040), new anoa());
    this.mMap.put(Integer.valueOf(8041), new anoa());
    this.mMap.put(Integer.valueOf(4019), new annx());
    this.mMap.put(Integer.valueOf(4016), new annx());
    this.mMap.put(Integer.valueOf(4017), new annx());
    this.mMap.put(Integer.valueOf(4018), new annx());
    this.mMap.put(Integer.valueOf(5002), new annx());
    this.mMap.put(Integer.valueOf(5003), new annx());
    this.mMap.put(Integer.valueOf(5004), new annx());
    this.mMap.put(Integer.valueOf(5005), new annx());
    this.mMap.put(Integer.valueOf(4014), new annx());
    this.mMap.put(Integer.valueOf(4015), new annx());
    this.mMap.put(Integer.valueOf(6005), new annv());
    this.mMap.put(Integer.valueOf(6004), new annv());
    this.mMap.put(Integer.valueOf(6006), new annv());
    this.mMap.put(Integer.valueOf(6003), new annv());
    this.mMap.put(Integer.valueOf(6001), new annv());
    this.mMap.put(Integer.valueOf(6002), new annv());
    this.mMap.put(Integer.valueOf(6007), new annv());
    this.mMap.put(Integer.valueOf(5006), new annv());
    this.mMap.put(Integer.valueOf(5012), new annv());
    this.mMap.put(Integer.valueOf(5010), new annv());
    this.mMap.put(Integer.valueOf(6008), new anoc());
    this.mMap.put(Integer.valueOf(8015), new anoc());
    this.mMap.put(Integer.valueOf(6014), new anoc());
    this.mMap.put(Integer.valueOf(6016), new anoc());
    this.mMap.put(Integer.valueOf(8003), new anoc());
    this.mMap.put(Integer.valueOf(8011), new anoc());
    this.mMap.put(Integer.valueOf(8004), new anoc());
    this.mMap.put(Integer.valueOf(8007), new anoc());
    this.mMap.put(Integer.valueOf(8013), new anoc());
    this.mMap.put(Integer.valueOf(6015), new anoc());
    this.mMap.put(Integer.valueOf(8017), new annz());
    this.mMap.put(Integer.valueOf(8024), new annz());
    this.mMap.put(Integer.valueOf(8016), new annz());
    this.mMap.put(Integer.valueOf(8018), new annz());
    this.mMap.put(Integer.valueOf(8019), new annz());
    this.mMap.put(Integer.valueOf(8020), new annz());
    this.mMap.put(Integer.valueOf(8022), new annz());
    this.mMap.put(Integer.valueOf(8023), new annz());
    this.mMap.put(Integer.valueOf(8030), new annz());
    this.mMap.put(Integer.valueOf(8031), new annz());
    this.mMap.put(Integer.valueOf(8033), new anob());
    this.mMap.put(Integer.valueOf(8038), new anob());
    this.mMap.put(Integer.valueOf(8034), new anob());
    this.mMap.put(Integer.valueOf(8035), new anob());
    this.mMap.put(Integer.valueOf(8036), new anob());
    this.mMap.put(Integer.valueOf(8039), new anob());
    this.mMap.put(Integer.valueOf(8046), new anob());
  }
  
  public void addFriendByContact(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
      onAddFriendByContact((String)paramArrayOfObject[0]);
    }
  }
  
  public void c2cOnlineFile(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      Integer localInteger = (Integer)paramArrayOfObject[0];
      String str = (String)paramArrayOfObject[1];
      paramArrayOfObject = (String)paramArrayOfObject[2];
      onOnlineFileSessionNotify(paramBoolean, str, localInteger.intValue(), paramArrayOfObject);
    }
  }
  
  public void comenMsgReceived()
  {
    onUpdateReceivedMsg();
  }
  
  public void commenMsgContentChanged(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      onUpdateMsgContent(paramBoolean, (String)paramObject);
      return;
    }
    onUpdateMsgContent(paramBoolean, "");
  }
  
  public void danceMachine(Object paramObject)
  {
    if ((paramObject instanceof MessageForDanceMachine)) {
      onDanceMachineUploaded((MessageForDanceMachine)paramObject);
    }
  }
  
  public void delRoamChatFriend(boolean paramBoolean)
  {
    onUpdateDelRoamChat(paramBoolean);
  }
  
  public void deleteAllSystemMsg(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {
      onDeleteAllSysMsg(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue());
    }
  }
  
  public void friendsListRefresh()
  {
    onUpdateFriendsList();
  }
  
  public void getAllProxyTroopMsg(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      onGetAllProxyTroopMsgFin(paramBoolean, ((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
      return;
    }
    onGetAllProxyTroopMsgFin(paramBoolean, 0L, 0L);
  }
  
  public void getDelSystemMsgError()
  {
    onGetDelSystemMsgError();
  }
  
  public void getDelSystemMsgFin(boolean paramBoolean)
  {
    onGetDelSystemMsgFin(paramBoolean, false);
  }
  
  public void getDiscussionMsgFin(boolean paramBoolean)
  {
    onGetDiscussionMsgFin(paramBoolean);
  }
  
  public void getGroupFirstMsgFin(boolean paramBoolean)
  {
    onGetGroupFirstMsgFin(paramBoolean);
  }
  
  public void getMsgFin(boolean paramBoolean)
  {
    onGetMsgFin(paramBoolean);
  }
  
  public void getOfflineFinish(boolean paramBoolean)
  {
    onGetOfflineMsgFinished(paramBoolean);
  }
  
  public void getOfflineStart(boolean paramBoolean)
  {
    onGretOfflineMsgStart(paramBoolean);
  }
  
  public void getPAFin(boolean paramBoolean)
  {
    onGetPAMsgFin(paramBoolean);
  }
  
  public void getRoamChat(boolean paramBoolean, Object paramObject)
  {
    onUpdateGetRoamChat(paramBoolean, paramObject);
  }
  
  public void getSuspiciousSystemMsgFin(boolean paramBoolean, Object paramObject)
  {
    onGetSuspiciousSystemMsgFin(paramBoolean, false, (List)paramObject);
  }
  
  public void getSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    onGetSystemMsgFin(paramBoolean1, paramBoolean2, paramList);
  }
  
  public void getTroopMsgFin(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0))
    {
      String[] arrayOfString = new String[paramArrayOfObject.length];
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayOfObject[i]);
        i += 1;
      }
      onGetTroopMsgFin(paramBoolean, arrayOfString);
      return;
    }
    onGetTroopMsgFin(paramBoolean, null);
  }
  
  public void handle_NOTIFY_TYPE_CONFESS_TMP(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramBoolean) {
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 8)) {
        onUpdateSendMsgError_confess((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (SendMessageHandler)paramArrayOfObject[3], ((Long)paramArrayOfObject[4]).longValue(), ((Long)paramArrayOfObject[5]).longValue(), (String)paramArrayOfObject[6], ((Integer)paramArrayOfObject[7]).intValue());
      }
    }
    while ((paramArrayOfObject == null) || (paramArrayOfObject.length < 8))
    {
      do
      {
        return;
      } while ((paramArrayOfObject == null) || (paramArrayOfObject.length < 4));
      onSendResult_confess(true, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Long)paramArrayOfObject[2]).longValue(), ((Integer)paramArrayOfObject[3]).intValue());
      return;
    }
    onUpdateSendMsgError_confess((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (SendMessageHandler)paramArrayOfObject[3], ((Long)paramArrayOfObject[4]).longValue(), ((Long)paramArrayOfObject[5]).longValue(), (String)paramArrayOfObject[6], ((Integer)paramArrayOfObject[7]).intValue());
  }
  
  public void hiboomAuth(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2) && ((paramArrayOfObject[0] instanceof Integer)) && ((paramArrayOfObject[1] instanceof byte[]))) {
      onHiBoomAuthResult(((Integer)paramArrayOfObject[0]).intValue(), (byte[])paramArrayOfObject[1]);
    }
  }
  
  public void iPadOnlinesStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 1)) {
      onSelfIpadOnlineStatusUpdateNotify(((Byte)paramArrayOfObject[0]).byteValue(), ((Byte)paramArrayOfObject[1]).byteValue());
    }
  }
  
  public void macOnlinesStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 1)) {
      onSelfMacOnlineStatusUpdateNotify(((Byte)paramArrayOfObject[0]).byteValue(), ((Byte)paramArrayOfObject[1]).byteValue());
    }
  }
  
  public void msgDelFriend(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 2)) {
      onUpdateMsgDelFriend((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue());
    }
  }
  
  public void msgRevokeRsp(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    boolean bool;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
    {
      List localList = (List)paramArrayOfObject[0];
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      paramArrayOfObject = localList;
    }
    for (;;)
    {
      onMsgRevokeNotice(paramBoolean, paramArrayOfObject, bool);
      return;
      paramArrayOfObject = null;
      bool = true;
    }
  }
  
  public void msgStartSendingUI(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 1)) {
      onMsgStartSendingUI((String)paramArrayOfObject[0]);
    }
  }
  
  public void newMessageAdded(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof List))) {
      onMessageRecordAdded((List)paramObject);
    }
  }
  
  public void newRegisterProxyFin(boolean paramBoolean)
  {
    onNewRegisterProxyFin(paramBoolean);
  }
  
  public void onAddFriendByContact(String paramString) {}
  
  public void onBlessDirtyTextCheck(boolean paramBoolean, int paramInt) {}
  
  public void onBoxMsgUnreadNumRefresh() {}
  
  public void onDanceMachineUploaded(MessageForDanceMachine paramMessageForDanceMachine) {}
  
  protected void onDeleteAllSysMsg(boolean paramBoolean, int paramInt) {}
  
  protected void onGetAllProxyTroopMsgFin(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void onGetDelSystemMsgError() {}
  
  protected void onGetDelSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void onGetDiscussionMsgFin(boolean paramBoolean) {}
  
  protected void onGetGroupFirstMsgFin(boolean paramBoolean) {}
  
  protected void onGetMsgFin(boolean paramBoolean) {}
  
  protected void onGetOfflineMsgFinished(boolean paramBoolean) {}
  
  protected void onGetPAMsgFin(boolean paramBoolean) {}
  
  public void onGetSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu) {}
  
  protected void onGetSuspiciousSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList) {}
  
  protected void onGetSystemMsgFin(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList) {}
  
  protected void onGetTempChatPic(boolean paramBoolean, RespTmpChatPicDownload paramRespTmpChatPicDownload) {}
  
  protected void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString) {}
  
  protected void onGretOfflineMsgStart(boolean paramBoolean) {}
  
  protected void onHiBoomAuthResult(int paramInt, byte[] paramArrayOfByte) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onInsertIntoBlackList(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  public void onMessageRecordAdded(List<MessageRecord> paramList) {}
  
  public void onMsgForwardWXResult(int paramInt) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2) {}
  
  public void onMsgStartSendingUI(String paramString) {}
  
  protected void onNewRegisterProxyFin(boolean paramBoolean) {}
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm) {}
  
  protected void onOnlineFileSessionNotify(boolean paramBoolean, String paramString1, int paramInt, String paramString2) {}
  
  public void onPushPCActiveNotice(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  protected void onPushReadedNotify(boolean paramBoolean, Object paramObject) {}
  
  public void onPushRecommandDevLock(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, ArrayList<String> paramArrayList) {}
  
  public void onPushSubAccountMsg(boolean paramBoolean, String paramString, bcqu parambcqu) {}
  
  protected void onPushUpdateLoginDevStatusNotify(int paramInt) {}
  
  public void onReceiptMessageFetchReadStatusResult(long paramLong1, int paramInt, long paramLong2) {}
  
  public void onReceiptMessageReadReportResult(long paramLong, int paramInt) {}
  
  protected void onRefleshRecentListFinished(boolean paramBoolean) {}
  
  protected void onRegisterProxyFin(boolean paramBoolean, Object paramObject) {}
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString) {}
  
  protected void onRemoveFromBlackList(boolean paramBoolean, String paramString, int paramInt) {}
  
  protected void onSelfIpadOnlineStatusUpdateNotify(int paramInt1, int paramInt2) {}
  
  protected void onSelfMacOnlineStatusUpdateNotify(int paramInt1, int paramInt2) {}
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2) {}
  
  protected void onSelfWatchOnlineStatusUpdateNotify(int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onSendBlessMsgResp(boolean paramBoolean1, int paramInt, long paramLong, boolean paramBoolean2) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong, amwf paramamwf) {}
  
  protected void onSendResultWithTransInfo(boolean paramBoolean, msg_svc.TransSvrInfo paramTransSvrInfo) {}
  
  protected void onSendResult_confess(boolean paramBoolean, String paramString, int paramInt1, long paramLong, int paramInt2) {}
  
  protected void onSendSystemMsgActionError(String paramString) {}
  
  protected void onSendSystemMsgActionFin(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4) {}
  
  public void onSubAccountMsgNumConfirm(boolean paramBoolean, String paramString1, String paramString2) {}
  
  public void onSubAccountThirdQQUnreadMsgNum(boolean paramBoolean, String paramString, bcqv parambcqv) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {}
    for (Object[] arrayOfObject = (Object[])paramObject;; arrayOfObject = null)
    {
      anny localanny = (anny)this.mMap.get(Integer.valueOf(paramInt));
      if (localanny != null) {
        localanny.a(this, paramInt, paramBoolean, paramObject, arrayOfObject, null);
      }
      return;
    }
  }
  
  protected void onUpdateDelRoamChat(boolean paramBoolean) {}
  
  protected void onUpdateFriendsList() {}
  
  protected void onUpdateGetRoamChat(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateMsgContent(boolean paramBoolean, String paramString) {}
  
  protected void onUpdateMsgDelFriend(String paramString, int paramInt1, int paramInt2) {}
  
  protected void onUpdateReceivedMsg() {}
  
  protected void onUpdateRecentList() {}
  
  protected void onUpdateRoamMsgSearchResult(boolean paramBoolean, Object paramObject) {}
  
  protected void onUpdateSecretfileStatus() {}
  
  protected void onUpdateSendGetFriendSig(boolean paramBoolean, byte[] paramArrayOfByte, amwm paramamwm) {}
  
  protected void onUpdateSendGetSig(boolean paramBoolean) {}
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2) {}
  
  protected void onUpdateSendMsgError_confess(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2, int paramInt3) {}
  
  protected void onUpdateSendOfflineFile(boolean paramBoolean, bbkx parambbkx, amwm paramamwm) {}
  
  protected void onUpdateSetOfflineFileState(boolean paramBoolean, bbkx parambbkx) {}
  
  protected void onUpdateSetRoamChat(boolean paramBoolean) {}
  
  protected void onUpdateTroopList() {}
  
  protected void onUpdateUploadStreamFinished(boolean paramBoolean, bbkz parambbkz) {}
  
  public void pcActiveNotify(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 4)) {
      onPushPCActiveNotice(paramBoolean, (String)paramArrayOfObject[0], (String)paramArrayOfObject[1], (String)paramArrayOfObject[2], (String)paramArrayOfObject[3]);
    }
  }
  
  public void pcOnlinesStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 1)) {
      onSelfPcOnlineStatusUpdateNotify(((Byte)paramArrayOfObject[0]).byteValue(), ((Byte)paramArrayOfObject[1]).byteValue());
    }
  }
  
  public void pushReadedNotify(boolean paramBoolean, Object paramObject)
  {
    onPushReadedNotify(paramBoolean, paramObject);
  }
  
  public void pushUpdateLoginDevStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {
      onPushUpdateLoginDevStatusNotify(((Byte)paramArrayOfObject[0]).byteValue());
    }
  }
  
  public void receiptErrorRsp(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0].longValue() == 1L)
    {
      onReceiptMessageReadReportResult(paramArrayOfLong[1].longValue(), paramArrayOfLong[2].intValue());
      return;
    }
    onReceiptMessageFetchReadStatusResult(paramArrayOfLong[1].longValue(), paramArrayOfLong[2].intValue(), 0L);
  }
  
  public void receiptRead(Long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0].longValue() == 1L)
    {
      onReceiptMessageReadReportResult(paramArrayOfLong[1].longValue(), 0);
      return;
    }
    onReceiptMessageFetchReadStatusResult(paramArrayOfLong[1].longValue(), 0, paramArrayOfLong[2].longValue());
  }
  
  public void recentListRefresh()
  {
    onUpdateRecentList();
  }
  
  public void recommandDevLock(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 6))
    {
      Boolean localBoolean = (Boolean)paramArrayOfObject[0];
      String str1 = (String)paramArrayOfObject[1];
      String str2 = (String)paramArrayOfObject[2];
      String str3 = (String)paramArrayOfObject[3];
      String str4 = (String)paramArrayOfObject[4];
      paramArrayOfObject = (ArrayList)paramArrayOfObject[5];
      onPushRecommandDevLock(paramBoolean, localBoolean.booleanValue(), str1, str2, str3, str4, paramArrayOfObject);
    }
  }
  
  public void refreshRecentListFinish(boolean paramBoolean)
  {
    onRefleshRecentListFinished(paramBoolean);
  }
  
  public void registerProxyFin(boolean paramBoolean, Object paramObject)
  {
    onRegisterProxyFin(paramBoolean, paramObject);
  }
  
  public void reqBlessDirtyTextCheck(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int j = 0;
    int i = j;
    if (paramArrayOfObject != null)
    {
      i = j;
      if (paramArrayOfObject.length == 1) {
        i = ((Integer)paramArrayOfObject[0]).intValue();
      }
    }
    onBlessDirtyTextCheck(paramBoolean, i);
  }
  
  public void reqBlessMsg(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 3)) {
      onSendBlessMsgResp(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue(), ((Long)paramArrayOfObject[1]).longValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
    }
  }
  
  public void reqDeleteBlacklist(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length == 2))
    {
      onRemoveFromBlackList(paramBoolean, (String)paramArrayOfObject[0]);
      onRemoveFromBlackList(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue());
    }
  }
  
  public void reqInsertBlacklist(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof String)) {
      onInsertIntoBlackList(paramBoolean, (String)paramObject);
    }
  }
  
  public void reqInsertBlacklistPB(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      onInsertIntoBlackList(paramBoolean, (Object[])paramObject);
    }
  }
  
  public void richSendNotifyMsg(boolean paramBoolean, Object[] paramArrayOfObject, amwm paramamwm)
  {
    long l;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      l = ((Long)paramArrayOfObject[0]).longValue();
      paramamwm = (amwm)paramArrayOfObject[1];
    }
    for (;;)
    {
      onNotifyResultAfterSendRich(paramBoolean, l, paramamwm);
      return;
      l = 0L;
    }
  }
  
  public void roamMessageSearchInCloud(boolean paramBoolean, Object paramObject)
  {
    onUpdateRoamMsgSearchResult(paramBoolean, paramObject);
  }
  
  public void sendGetC2CSig(boolean paramBoolean, Object[] paramArrayOfObject, amwm paramamwm)
  {
    amwm localamwm = null;
    if (paramBoolean)
    {
      localObject = localamwm;
      if (paramArrayOfObject != null)
      {
        localObject = localamwm;
        if (paramArrayOfObject.length >= 1) {
          localObject = (byte[])paramArrayOfObject[0];
        }
      }
      localamwm = paramamwm;
      if (paramArrayOfObject != null)
      {
        localamwm = paramamwm;
        if (paramArrayOfObject.length >= 2) {
          localamwm = (amwm)paramArrayOfObject[1];
        }
      }
      onUpdateSendGetFriendSig(paramBoolean, (byte[])localObject, localamwm);
      return;
    }
    Object localObject = paramamwm;
    if (paramArrayOfObject != null)
    {
      localObject = paramamwm;
      if (paramArrayOfObject.length >= 2) {
        localObject = (amwm)paramArrayOfObject[1];
      }
    }
    onUpdateSendGetFriendSig(paramBoolean, null, (amwm)localObject);
  }
  
  public void sendGetSig(boolean paramBoolean)
  {
    onUpdateSendGetSig(paramBoolean);
  }
  
  public void sendMsgError(Object[] paramArrayOfObject)
  {
    String str2;
    int i;
    int j;
    SendMessageHandler localSendMessageHandler;
    long l1;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 2))
    {
      str2 = (String)paramArrayOfObject[0];
      i = ((Integer)paramArrayOfObject[1]).intValue();
      j = ((Integer)paramArrayOfObject[2]).intValue();
      if (paramArrayOfObject.length < 6) {
        break label112;
      }
      localSendMessageHandler = (SendMessageHandler)paramArrayOfObject[3];
      l1 = ((Long)paramArrayOfObject[4]).longValue();
    }
    for (long l2 = ((Long)paramArrayOfObject[5]).longValue();; l2 = 0L)
    {
      String str1 = "";
      if (paramArrayOfObject.length >= 7) {
        str1 = (String)paramArrayOfObject[6];
      }
      onUpdateSendMsgError(str2, i, j, localSendMessageHandler, l1, l2, str1);
      return;
      label112:
      localSendMessageHandler = null;
      l1 = 96000L;
    }
  }
  
  public void sendOfflineFile(boolean paramBoolean, Object[] paramArrayOfObject, amwm paramamwm)
  {
    amwm localamwm = null;
    if (paramBoolean)
    {
      localObject = localamwm;
      if (paramArrayOfObject != null)
      {
        localObject = localamwm;
        if (paramArrayOfObject.length >= 1) {
          localObject = (bbkx)paramArrayOfObject[0];
        }
      }
      localamwm = paramamwm;
      if (paramArrayOfObject != null)
      {
        localamwm = paramamwm;
        if (paramArrayOfObject.length >= 2) {
          localamwm = (amwm)paramArrayOfObject[1];
        }
      }
      onUpdateSendOfflineFile(paramBoolean, (bbkx)localObject, localamwm);
      return;
    }
    Object localObject = paramamwm;
    if (paramArrayOfObject != null)
    {
      localObject = paramamwm;
      if (paramArrayOfObject.length >= 2) {
        localObject = (amwm)paramArrayOfObject[1];
      }
    }
    onUpdateSendOfflineFile(paramBoolean, null, (amwm)localObject);
  }
  
  public void sendResult(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length >= 3) {
        onSendResult(paramBoolean, (String)paramArrayOfObject[0], Long.parseLong((String)paramArrayOfObject[1]), (amwf)paramArrayOfObject[2]);
      }
      onSendResult(paramBoolean, (String)paramArrayOfObject[0], Long.parseLong((String)paramArrayOfObject[1]));
    }
  }
  
  public void sendResultWithTransinfo(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof msg_svc.TransSvrInfo)) {
      onSendResultWithTransInfo(paramBoolean, (msg_svc.TransSvrInfo)paramObject);
    }
  }
  
  public void sendSystemMsgActionError(ToServiceMsg paramToServiceMsg)
  {
    onSendSystemMsgActionError((String)paramToServiceMsg.getAttribute("_tag_LOGSTR"));
  }
  
  public void sendSystemMsgActionFin(boolean paramBoolean, ToServiceMsg paramToServiceMsg)
  {
    String str2 = (String)paramToServiceMsg.getAttribute("_tag_LOGSTR");
    int i = paramToServiceMsg.extraData.getInt("system_msg_action_type");
    Object localObject1 = paramToServiceMsg.extraData.getString("system_msg_action_resp_key");
    Object localObject2 = paramToServiceMsg.extraData.getString("system_msg_action_resp_error_key");
    int j = paramToServiceMsg.extraData.getInt("system_msg_action_resp_result_code_key");
    int k = paramToServiceMsg.extraData.getInt("system_msg_action_resp_type_key");
    String str1 = paramToServiceMsg.extraData.getString("system_msg_action_resp_invalid_decided_key");
    int m = paramToServiceMsg.extraData.getInt("system_msg_action_resp_remark_result_key");
    paramToServiceMsg = (ToServiceMsg)localObject1;
    if (localObject1 == null) {
      paramToServiceMsg = "";
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = str1;
    if (str1 == null) {
      localObject2 = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageObserver", 2, "sendSystemMsgActionResult logStr=" + str2 + ";actionType=" + i + ";msgDetail=" + paramToServiceMsg + ";resultCode=" + j + ";respType=" + k + ";msgFail=" + (String)localObject1 + ";msgInvalidDecided=" + (String)localObject2 + ";remarkRet=" + m);
    }
    onSendSystemMsgActionFin(paramBoolean, str2, i, paramToServiceMsg, j, k, (String)localObject1, (String)localObject2, m);
  }
  
  public void setOfflineFileState(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject2 = null;
    if (paramBoolean)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfObject != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfObject.length >= 1) {
          localObject1 = (bbkx)paramArrayOfObject[0];
        }
      }
      onUpdateSetOfflineFileState(paramBoolean, (bbkx)localObject1);
      return;
    }
    onUpdateSetOfflineFileState(paramBoolean, null);
  }
  
  public void setRoamChat(boolean paramBoolean)
  {
    onUpdateSetRoamChat(paramBoolean);
  }
  
  public void subaccountGetMsg(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_GET_MSG");
    }
    String str = null;
    if (paramObject != null) {
      str = ((bcqu)paramObject).c;
    }
    onGetSubAccountMsg(paramBoolean, str, (bcqu)paramObject);
  }
  
  public void subaccountMsgNumReadedConfirm(boolean paramBoolean, Object paramObject)
  {
    Object localObject1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("MessageObserver", 2, "onUpdate NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM isSucc=" + paramBoolean + " data=" + String.valueOf(paramObject));
    }
    if ((paramObject instanceof String[]))
    {
      paramObject = (String[])paramObject;
      if (paramObject.length == 2)
      {
        localObject1 = paramObject[0];
        paramObject = paramObject[1];
      }
    }
    for (;;)
    {
      onSubAccountMsgNumConfirm(paramBoolean, (String)localObject1, paramObject);
      return;
      Object localObject2 = null;
      paramObject = localObject1;
      localObject1 = localObject2;
    }
  }
  
  public void subaccountPushMsg(boolean paramBoolean, Object paramObject)
  {
    String str = null;
    if (paramObject != null) {
      str = ((bcqu)paramObject).c;
    }
    onPushSubAccountMsg(paramBoolean, str, (bcqu)paramObject);
  }
  
  public void transserviceC2CUploadStreamPtt(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {
      onUpdateUploadStreamFinished(paramBoolean, (bbkz)paramArrayOfObject[0]);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    if ("Stream ptt:UploadStreamStruct : arrayLength:" + paramArrayOfObject == null) {}
    for (paramArrayOfObject = "null";; paramArrayOfObject = paramArrayOfObject.length + "")
    {
      QLog.d("streamptt.send", 2, paramArrayOfObject);
      return;
    }
  }
  
  public void transserviceTempChatDownloadPic(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    Object localObject2 = null;
    if (paramBoolean)
    {
      Object localObject1 = localObject2;
      if (paramArrayOfObject != null)
      {
        localObject1 = localObject2;
        if (paramArrayOfObject.length > 0) {
          localObject1 = (RespTmpChatPicDownload)paramArrayOfObject[0];
        }
      }
      onGetTempChatPic(paramBoolean, (RespTmpChatPicDownload)localObject1);
      return;
    }
    onGetTempChatPic(paramBoolean, null);
  }
  
  public void troopListRefresh()
  {
    onUpdateTroopList();
    onUpdateRecentList();
  }
  
  public void updateSecretfileStatus()
  {
    onUpdateSecretfileStatus();
  }
  
  public void watchOnlineStatus(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 2)) {
      onSelfWatchOnlineStatusUpdateNotify(((Byte)paramArrayOfObject[0]).byteValue(), ((Byte)paramArrayOfObject[1]).byteValue(), ((Integer)paramArrayOfObject[2]).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amwl
 * JD-Core Version:    0.7.0.1
 */