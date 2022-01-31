import AccostSvc.RespClientMsg;
import AccostSvc.RespDeleteBlackList;
import AccostSvc.RespGetBlackList;
import AccostSvc.RespHeader;
import AccostSvc.RespInsertBlackList;
import AccostSvc.SvrMsg;
import MessageSvcPack.RequestPushStatus;
import MessageSvcPack.SvcResponseDelMsgV2;
import MessageSvcPack.SvcResponseDelRoamMsg;
import MessageSvcPack.SvcResponseGetMsgV2;
import MessageSvcPack.SvcResponsePullGroupMsgSeq;
import MessageSvcPack.SvcResponseSetRoamMsg;
import OnlinePushPack.SvcReqPushMsg;
import PushAdMsg.AdMsgInfo;
import PushNotifyPack.RequestPushNotify;
import PushNotifyPack.SvcRequestPushReadedNotify;
import QQService.RespGetSign;
import QQService.RespOffFilePack;
import QQService.RespTmpChatPicDownload;
import QQService.SCPushStreamMsg;
import QQService.SCRespUploadStreamMsg;
import QQService.StreamData;
import QQService.StreamInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.qq.jce.wup.UniPacket;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.IBaseActionListener;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ayvl
{
  private String a = MessageHandler.class.getSimpleName();
  
  private <T> T a(byte[] paramArrayOfByte, String paramString, T paramT)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    UniPacket localUniPacket = new UniPacket(true);
    try
    {
      localUniPacket.setEncodeName("utf-8");
      localUniPacket.decode(paramArrayOfByte);
      return localUniPacket.getByClass(paramString, paramT);
    }
    catch (Exception paramArrayOfByte)
    {
      return null;
    }
    catch (RuntimeException paramArrayOfByte) {}
    return null;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt, String paramString, long paramLong)
  {
    FromServiceMsg localFromServiceMsg = new FromServiceMsg(paramToServiceMsg.getUin(), paramToServiceMsg.getServiceCmd());
    localFromServiceMsg.extraData.putLong("ServerReplyCode", paramLong);
    localFromServiceMsg.setBusinessFail(paramInt, paramInt, paramString);
    try
    {
      if (paramToServiceMsg.actionListener != null) {
        paramToServiceMsg.actionListener.onActionResult(localFromServiceMsg);
      }
      return;
    }
    catch (RemoteException paramToServiceMsg) {}
  }
  
  private void a(ToServiceMsg paramToServiceMsg, long paramLong)
  {
    a(paramToServiceMsg, 1001, "", paramLong);
  }
  
  private Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("push", 2, "decodeVideoChatStatus");
    }
    return null;
  }
  
  private Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespGetSign localRespGetSign = (RespGetSign)a(paramFromServiceMsg.getWupBuffer(), "RespGetSign", new RespGetSign());
    if ((localRespGetSign == null) || (localRespGetSign.iReplyCode != 0))
    {
      if (localRespGetSign == null) {}
      for (long l = 2139062143L;; l = localRespGetSign.iReplyCode)
      {
        a(paramToServiceMsg, l);
        paramFromServiceMsg.extraData.putLong("ServerReplyCode", l);
        return null;
      }
    }
    return new ayvn(this, localRespGetSign.vKey, localRespGetSign.vSign);
  }
  
  private Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCRespUploadStreamMsg)a(paramFromServiceMsg.getWupBuffer(), "SCRespUploadStreamMsg", new SCRespUploadStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    paramFromServiceMsg = paramToServiceMsg.stStreamInfo;
    return new ayvo(azqa.a(paramFromServiceMsg.iMsgId, 0), paramToServiceMsg.shResetSeq, paramFromServiceMsg.shFlowLayer, paramFromServiceMsg, paramToServiceMsg.result);
  }
  
  private Object e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SCPushStreamMsg)a(paramFromServiceMsg.getWupBuffer(), "SCPushStreamMsg", new SCPushStreamMsg());
    if (paramToServiceMsg == null) {
      return null;
    }
    paramFromServiceMsg = paramToServiceMsg.stStreamInfo;
    StreamData localStreamData = paramToServiceMsg.stStreamData;
    long l = paramToServiceMsg.lKey;
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Long.valueOf(l);
    arrayOfObject[1] = paramFromServiceMsg;
    arrayOfObject[2] = localStreamData;
    arrayOfObject[3] = Long.valueOf(paramToServiceMsg.bubbleID);
    arrayOfObject[4] = Long.valueOf(paramToServiceMsg.subBubbleId);
    arrayOfObject[5] = Long.valueOf(paramToServiceMsg.diyAddonId);
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "decodeServerPushStream: iSeq:" + paramToServiceMsg.iSeq + ", lKey: " + l + ", vipBubbleID:" + arrayOfObject[3] + ", subBubbleId:" + arrayOfObject[4] + ", diyAddonId:" + arrayOfObject[5]);
    }
    return arrayOfObject;
  }
  
  private Object f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = paramFromServiceMsg.getWupBuffer();
    paramFromServiceMsg = new byte[paramToServiceMsg.length - 4];
    System.arraycopy(paramToServiceMsg, 4, paramFromServiceMsg, 0, paramToServiceMsg.length - 4);
    return (RequestPushNotify)a(paramFromServiceMsg, "req_PushNotify", new RequestPushNotify());
  }
  
  private Object g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvrMsg)a(paramFromServiceMsg.getWupBuffer(), "SvrMsg", new SvrMsg());
  }
  
  private Object h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespGetBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespGetBlackList", new RespGetBlackList());
  }
  
  private Object i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespInsertBlackList localRespInsertBlackList = (RespInsertBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespInsertBlackList", new RespInsertBlackList());
    paramFromServiceMsg.extraData.putString("insertUin", paramToServiceMsg.extraData.getString("insertUin"));
    paramToServiceMsg = localRespInsertBlackList;
    if (localRespInsertBlackList.stHeader.eReplyCode != 0) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespDeleteBlackList localRespDeleteBlackList = (RespDeleteBlackList)a(paramFromServiceMsg.getWupBuffer(), "RespDeleteBlackList", new RespDeleteBlackList());
    paramFromServiceMsg.extraData.putString("deleteUin", paramToServiceMsg.extraData.getString("deleteUin"));
    paramToServiceMsg = localRespDeleteBlackList;
    if (localRespDeleteBlackList.stHeader.eReplyCode != 0) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RespClientMsg)a(paramFromServiceMsg.getWupBuffer(), "RespClientMsg", new RespClientMsg());
  }
  
  private Object l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcReqPushMsg)a(paramFromServiceMsg.getWupBuffer(), "req", new SvcReqPushMsg());
  }
  
  private Object m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcRequestPushReadedNotify)a(paramFromServiceMsg.getWupBuffer(), "req", new SvcRequestPushReadedNotify());
  }
  
  private Object n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = (RespTmpChatPicDownload)a(paramFromServiceMsg.getWupBuffer(), "RespTmpChatPicDownload", new RespTmpChatPicDownload());
    paramToServiceMsg = paramFromServiceMsg;
    if (paramFromServiceMsg == null) {
      paramToServiceMsg = null;
    }
    return paramToServiceMsg;
  }
  
  private Object o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseGetMsgV2)a(paramFromServiceMsg.getWupBuffer(), "resp_GetMsgV2", new SvcResponseGetMsgV2());
    if (paramToServiceMsg != null)
    {
      atqu.a("Video", "Receive message packet: seq = " + paramFromServiceMsg.getRequestSsoSeq() + " size = " + paramToServiceMsg.vMsgInfos.size());
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponseDelMsgV2)a(paramFromServiceMsg.getWupBuffer(), "resp_DelMsgV2", new SvcResponseDelMsgV2());
    if (paramToServiceMsg != null) {
      return paramToServiceMsg;
    }
    return null;
  }
  
  private Object q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    RespOffFilePack localRespOffFilePack = (RespOffFilePack)a(paramFromServiceMsg.getWupBuffer(), "RespOffFilePack", new RespOffFilePack());
    paramToServiceMsg.extraData.getLong("msgTime");
    byte b1 = paramToServiceMsg.extraData.getByte("type");
    paramToServiceMsg.extraData.getString("friendUin");
    if ((localRespOffFilePack == null) || (localRespOffFilePack.iReplyCode != 0))
    {
      paramToServiceMsg = paramFromServiceMsg.extraData;
      if (localRespOffFilePack == null) {}
      for (l1 = 2139062143L;; l1 = localRespOffFilePack.iReplyCode)
      {
        paramToServiceMsg.putLong("ServerReplyCode", l1);
        return null;
      }
    }
    byte b2 = localRespOffFilePack.vBody[0];
    long l1 = bdlr.a(localRespOffFilePack.vBody, 1);
    int i = bdlr.a(localRespOffFilePack.vBody, 5);
    paramFromServiceMsg = new byte[i];
    bdlr.a(paramFromServiceMsg, 0, localRespOffFilePack.vBody, 7, i);
    paramFromServiceMsg = bdlr.a(paramFromServiceMsg, 0, i);
    i += 7;
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "<<<<decodeGetOffLineFileResp cSubCmd:" + b2);
    }
    long l2;
    long l3;
    long l4;
    long l5;
    byte[] arrayOfByte;
    switch (b2)
    {
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
      l2 = bdlr.b(localRespOffFilePack.vBody, i);
      i += 8;
      l3 = bdlr.b(localRespOffFilePack.vBody, i);
      i += 8;
      l4 = bdlr.a(localRespOffFilePack.vBody, i);
      i += 4;
      l5 = bdlr.a(localRespOffFilePack.vBody, i);
      i += 4;
      short s = bdlr.a(localRespOffFilePack.vBody, i);
      j = i + 2;
      i = bdlr.a(localRespOffFilePack.vBody, j);
      j += 2;
      paramToServiceMsg = new byte[i];
      bdlr.a(paramToServiceMsg, 0, localRespOffFilePack.vBody, j, paramToServiceMsg.length);
      j += paramToServiceMsg.length;
      i = bdlr.a(localRespOffFilePack.vBody, j);
      j += 2;
      arrayOfByte = new byte[i];
      bdlr.a(arrayOfByte, 0, localRespOffFilePack.vBody, j, arrayOfByte.length);
      i = j + arrayOfByte.length;
      byte b3 = localRespOffFilePack.vBody[i];
      i += 1;
      long l6 = bdlr.a(localRespOffFilePack.vBody, i);
      if (QLog.isColorLevel()) {
        QLog.d("wk", 2, "" + l1 + "|" + l5 + "|" + s + "|" + paramToServiceMsg + "|" + arrayOfByte + "|" + b3);
      }
      return new ayvm(this, l1, paramFromServiceMsg, b2, b1, l2, l3, l4, l5, s, paramToServiceMsg, arrayOfByte, b3, l6);
    case 2: 
      return new ayvm(this, l1, paramFromServiceMsg, b2, b1);
    case 3: 
      j = localRespOffFilePack.vBody[i];
      i += 1;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 2;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 2;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 2;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 2;
      j = localRespOffFilePack.vBody[i];
      i += 1;
      l2 = bdlr.a(localRespOffFilePack.vBody, i);
      j = i + 4;
      i = bdlr.a(localRespOffFilePack.vBody, j);
      j += 2;
      bdlr.a(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = bdlr.a(localRespOffFilePack.vBody, j);
      j += 2;
      arrayOfByte = new byte[i];
      bdlr.a(arrayOfByte, 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = localRespOffFilePack.vBody[j];
      j += 1;
      bdlr.a(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = localRespOffFilePack.vBody[j];
      j += 1;
      bdlr.a(new byte[i], 0, localRespOffFilePack.vBody, j, i);
      j += i;
      i = bdlr.a(localRespOffFilePack.vBody, j);
      j += 2;
      Object localObject = new byte[i];
      bdlr.a((byte[])localObject, 0, localRespOffFilePack.vBody, j, i);
      localObject = bdlr.a((byte[])localObject, 0, i);
      i = j + i;
      j = localRespOffFilePack.vBody[i];
      i += 1;
      l3 = bdlr.a(localRespOffFilePack.vBody, i);
      i += 4;
      l4 = bdlr.a(localRespOffFilePack.vBody, i);
      i += 4;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 2;
      bdlr.a(localRespOffFilePack.vBody, i);
      i += 4;
      l5 = bdlr.a(localRespOffFilePack.vBody, i);
      if (QLog.isColorLevel()) {
        QLog.i(this.a, 2, "<<<<decodeGetOffLineFileResp dwUploadTime = " + l5);
      }
      return new ayvm(this, l1, paramFromServiceMsg, b2, b1, l2, HexUtil.bytes2HexStr(arrayOfByte), l4, paramToServiceMsg.extraData.getLong("msgTime"), paramToServiceMsg.extraData.getShort("msgSeq"), l3, (String)localObject, paramToServiceMsg.extraData.getLong("delUin"));
    }
    int j = bdlr.a(localRespOffFilePack.vBody, i);
    paramToServiceMsg = new byte[j];
    bdlr.a(paramToServiceMsg, 0, localRespOffFilePack.vBody, i + 2, j);
    return new ayvm(this, l1, paramFromServiceMsg, b2, b1, paramToServiceMsg);
  }
  
  private Object r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseSetRoamMsg)a(paramFromServiceMsg.getWupBuffer(), "resp_SetRoamMsg", new SvcResponseSetRoamMsg());
  }
  
  private Object s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (SvcResponseDelRoamMsg)a(paramFromServiceMsg.getWupBuffer(), "resp_DelRoamMsg", new SvcResponseDelRoamMsg());
  }
  
  private Object t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (AdMsgInfo)a(paramFromServiceMsg.getWupBuffer(), "PushADMsg", new AdMsgInfo());
  }
  
  private Object u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = (SvcResponsePullGroupMsgSeq)a(paramFromServiceMsg.getWupBuffer(), "resp_PullGroupMsgSeq", new SvcResponsePullGroupMsgSeq());
    if (QLog.isColorLevel()) {
      QLog.d("MessageService", 2, "decodePullGroupMsgNumResp res" + paramToServiceMsg);
    }
    return paramToServiceMsg;
  }
  
  private Object v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return (RequestPushStatus)a(paramFromServiceMsg.getWupBuffer(), "req_PushStatus", new RequestPushStatus());
  }
  
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d(this.a, 2, "decodeRespMsg cmd: " + str);
    }
    if ("MessageSvc.PushNotify".equalsIgnoreCase(str)) {
      return f(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.GetMsgV4".equalsIgnoreCase(str)) {
      return o(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelMsgV2".equalsIgnoreCase(str)) {
      return p(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqOffFilePack".equalsIgnoreCase(str)) {
      return q(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqTmpChatPicDownload".equalsIgnoreCase(str)) {
      return n(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SetRoamMsgAllUser".equalsIgnoreCase(str)) {
      return r(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.DelRoamMsg".equalsIgnoreCase(str)) {
      return s(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("ADMsgSvc.PushMsg".equalsIgnoreCase(str)) {
      return t(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("OnlinePush.ReqPush".equalsIgnoreCase(str)) {
      return l(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PushReaded".equalsIgnoreCase(str)) {
      return m(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("TransService.ReqGetSign".equalsIgnoreCase(str)) {
      return c(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.RespUploadStreamMsg".equalsIgnoreCase(str)) {
      return d(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.SendVideoMsg".equalsIgnoreCase(str)) {
      return b(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("StreamSvr.PushStreamMsg".equalsIgnoreCase(str)) {
      return e(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ClientMsg".equals(str)) {
      return k(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqInsertBlackList".equals(str)) {
      return i(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqDeleteBlackList".equals(str)) {
      return j(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.ReqGetBlackList".equals(str)) {
      return h(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("AccostSvc.SvrMsg".equals(str)) {
      return g(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.PullGroupMsgSeq".equalsIgnoreCase(str)) {
      return u(paramToServiceMsg, paramFromServiceMsg);
    }
    if ("MessageSvc.RequestPushStatus".equalsIgnoreCase(str)) {
      return v(paramToServiceMsg, paramFromServiceMsg);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvl
 * JD-Core Version:    0.7.0.1
 */