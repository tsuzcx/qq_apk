package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.app.message.OnLinePushMsgTypeProcessorDispatcher;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class OnLinePushMessageProcessor$ProcessOneMsg
{
  private long jdField_a_of_type_Long;
  private MsgInfo jdField_a_of_type_OnlinePushPackMsgInfo;
  private SvcReqPushMsg jdField_a_of_type_OnlinePushPackSvcReqPushMsg;
  private FromServiceMsg jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<MsgInfo> jdField_b_of_type_JavaUtilArrayList;
  private boolean jdField_b_of_type_Boolean;
  private ArrayList<DelMsgInfo> c;
  private ArrayList<String> d;
  
  public OnLinePushMessageProcessor$ProcessOneMsg(FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg, String paramString, ArrayList<MessageRecord> paramArrayList, ArrayList<MsgInfo> paramArrayList1, ArrayList<DelMsgInfo> paramArrayList2, long paramLong, ArrayList<String> paramArrayList3, MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramSvcReqPushMsg;
    this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg = paramString;
    this.jdField_a_of_type_JavaLangString = paramArrayList;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList1;
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList2;
    this.c = paramLong;
    this.jdField_a_of_type_Long = ???;
    this.d = paramMsgInfo;
    this.jdField_a_of_type_OnlinePushPackMsgInfo = paramBoolean;
    boolean bool1;
    this.jdField_b_of_type_Boolean = bool1;
  }
  
  private void a()
  {
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID > 0L)) {
      this.d.add(AppShareIDUtil.a(this.jdField_a_of_type_OnlinePushPackMsgInfo.uAppShareID));
    }
  }
  
  private void a(int paramInt)
  {
    if ((42 != paramInt) && (83 != paramInt) && (127 != paramInt) && (QLog.isColorLevel())) {
      MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq, String.valueOf(this.jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin));
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin + " msgInfo.shMsgType: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + this.jdField_a_of_type_OnlinePushPackMsgInfo.lMsgUid);
    }
  }
  
  private void a(Exception paramException)
  {
    paramException.printStackTrace();
    if ((this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg != null) && (QLog.isColorLevel())) {
      QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.bytes2HexStr(this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsg));
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, long paramLong1, MsgInfo paramMsgInfo, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte, int paramInt3, long paramLong2, long paramLong3, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) || (paramString == null)) {
      return;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(paramInt2);
    if (paramInt1 == 1006)
    {
      String str = ContactUtils.f(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, String.valueOf(paramLong2));
      localMessageRecord.init(String.valueOf(paramLong1), ContactUtils.f(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, String.valueOf(paramLong3)), str, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
    }
    for (;;)
    {
      localMessageRecord.shmsgseq = paramMsgInfo.shMsgSeq;
      localMessageRecord.isread = paramBoolean1;
      localMessageRecord.msgUid = paramMsgInfo.lMsgUid;
      localMessageRecord.msgData = paramArrayOfByte;
      if (paramInt3 > 0) {
        localMessageRecord.setExtraFlag(paramInt3);
      }
      if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, localMessageRecord, true)) {
        paramArrayList.add(localMessageRecord);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + paramLong3 + " msgType: " + paramInt2 + " friendType: " + paramInt1 + " shMsgSeq: " + paramMsgInfo.shMsgSeq + " msgContent: " + MessageRecordUtil.a(paramString));
      return;
      localMessageRecord.init(paramLong1, paramLong3, paramLong2, paramString, paramMsgInfo.uRealMsgTime, paramInt2, paramInt1, paramMsgInfo.uMsgTime);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, paramMsgInfo, paramLong);
    if ((paramMsgInfo != null) && (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, paramMsgInfo, true))) {
      paramArrayList.add(paramMsgInfo);
    }
  }
  
  private void a(ArrayList<MsgInfo> paramArrayList, ArrayList<DelMsgInfo> paramArrayList1, long paramLong1, MsgInfo paramMsgInfo, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean, DelMsgInfo paramDelMsgInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + paramArrayList.size());
    }
    if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, paramInt, String.valueOf(paramLong3), String.valueOf(paramLong2), paramMsgInfo.uMsgTime, paramMsgInfo.shMsgSeq)) {}
    do
    {
      return;
      paramArrayList1.remove(paramDelMsgInfo);
      paramArrayList = new String(paramMsgInfo.vMsg) + paramMsgInfo.uMsgTime;
      if (!this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getMsgHandler().a().a(paramArrayList))
      {
        paramArrayList = new long[1];
        paramArrayList[0] = paramMsgInfo.lFromUin;
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
        }
        OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, String.valueOf(paramLong3), paramLong1, paramArrayList, paramMsgInfo.vMsg, paramMsgInfo.uMsgTime, paramMsgInfo.shMsgSeq, paramBoolean);
        paramMsgInfo.lFromUin = paramArrayList[0];
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
  }
  
  private boolean a(SvcReqPushMsg paramSvcReqPushMsg, ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, int paramInt)
  {
    paramSvcReqPushMsg = OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, paramInt, paramMsgInfo, paramSvcReqPushMsg);
    if (paramSvcReqPushMsg != null)
    {
      if (paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        paramArrayList.add(paramSvcReqPushMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
      if (paramSvcReqPushMsg.jdField_a_of_type_Boolean) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramMsgInfo.vMsg == null) {
      bool1 = true;
    }
    int i;
    do
    {
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool1;
            localObject = new byte[paramMsgInfo.vMsg.length];
            PkgTools.copyData((byte[])localObject, 0, paramMsgInfo.vMsg, 0, localObject.length);
            i = localObject[4];
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.getLongData(paramMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + paramMsgInfo.shMsgSeq);
            }
            if ((i != 16) && (i != 17) && (i != 20) && (i != 21)) {
              break;
            }
            bool1 = bool2;
          } while (paramMsgInfo.vMsg.length <= 7);
          localObject = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
          byte[] arrayOfByte = new byte[paramMsgInfo.vMsg.length - 7];
          PkgTools.copyData(arrayOfByte, 0, paramMsgInfo.vMsg, 7, arrayOfByte.length);
          paramMsgInfo = ((TroopTipsMsgMgr)localObject).a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, arrayOfByte, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, false, false, null);
          bool1 = bool2;
        } while (paramMsgInfo == null);
        paramArrayList.add(paramMsgInfo);
        return false;
        if ((i == 12) || (i == 14))
        {
          ((TroopGagMgr)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((byte[])localObject, paramMsgInfo.shMsgSeq);
          return false;
        }
        if (i == 15)
        {
          OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, (byte[])localObject, paramMsgInfo.shMsgSeq);
          return true;
        }
        if (i == 6)
        {
          OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, (byte[])localObject);
          return false;
        }
        if (i == 11) {
          break;
        }
        bool1 = bool2;
      } while (i != 13);
      bool1 = bool2;
    } while (paramMsgInfo.vMsg.length <= 7);
    paramArrayList = new byte[paramMsgInfo.vMsg.length - 7];
    PkgTools.copyData(paramArrayList, 0, paramMsgInfo.vMsg, 7, paramArrayList.length);
    OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, paramArrayList, i);
    return false;
  }
  
  public ProcessOneMsg a()
  {
    int i;
    long l1;
    long l2;
    long l3;
    try
    {
      new ArrayList();
      i = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType;
      l1 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      l2 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
      if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin() == null) {}
      for (Object localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getAccount());; localObject1 = Long.valueOf(this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin()))
      {
        l3 = ((Long)localObject1).longValue();
        localObject1 = new DelMsgInfo();
        ((FriendsManager)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin);
        ((DelMsgInfo)localObject1).lFromUin = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
        ((DelMsgInfo)localObject1).shMsgSeq = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgSeq;
        ((DelMsgInfo)localObject1).uMsgTime = this.jdField_a_of_type_OnlinePushPackMsgInfo.uMsgTime;
        ((DelMsgInfo)localObject1).vMsgCookies = this.jdField_a_of_type_OnlinePushPackMsgInfo.vMsgCookies;
        this.c.add(localObject1);
        a(i);
        if (!OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(i))) {
          break;
        }
        if (!a(this.jdField_a_of_type_OnlinePushPackSvcReqPushMsg, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, i)) {
          break label749;
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
      }
      if (169 != i) {
        break label282;
      }
      a(this.jdField_b_of_type_JavaUtilArrayList, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, 0, l1, l2, false, (DelMsgInfo)localObject1);
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    catch (Exception localException)
    {
      a(localException);
    }
    a();
    this.jdField_a_of_type_Boolean = false;
    return this;
    label282:
    Object localObject3;
    int j;
    Object localObject2;
    boolean bool;
    int k;
    if (8 == i)
    {
      localObject3 = new OnLinePushMessageProcessor.HandleShMsgType0x08(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
      i = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject3).a();
      j = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject3).b();
      localObject2 = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject3).a();
      l1 = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject3).a();
      bool = false;
      k = -1;
      localObject3 = null;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, j, (String)localObject2, (byte[])localObject3, k, l1, l2, bool, this.jdField_b_of_type_Boolean);
      break;
      if (132 == i)
      {
        localObject3 = new OnLinePushMessageProcessor.HandleShMsgType0x84(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
        i = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject3).a();
        j = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject3).b();
        localObject2 = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject3).a();
        l1 = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject3).a();
        bool = false;
        k = -1;
        localObject3 = null;
      }
      else if (732 == i)
      {
        this.jdField_b_of_type_Boolean = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo);
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
      else if (230 == i)
      {
        OnLinePushMessageProcessor.HandleShMsgType0xe6 localHandleShMsgType0xe6 = new OnLinePushMessageProcessor.HandleShMsgType0xe6(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, l1, l2).a();
        i = localHandleShMsgType0xe6.a();
        j = localHandleShMsgType0xe6.b();
        localObject2 = localHandleShMsgType0xe6.a();
        localObject3 = localHandleShMsgType0xe6.a();
        bool = localHandleShMsgType0xe6.a();
        k = -1;
      }
      else if (SystemMsg.isSystemMessage(i))
      {
        localObject2 = new OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i).a();
        j = ((OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage)localObject2).a();
        l2 = ((OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage)localObject2).a();
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
      }
      else if (SystemMsg.isTroopSystemMessage(i))
      {
        localObject2 = new OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, -1000, -1, l1, l2).a();
        j = ((OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage)localObject2).a();
        k = ((OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage)localObject2).b();
        l2 = ((OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage)localObject2).a();
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
      }
      else if (528 == i)
      {
        a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, l3);
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        }
        this.jdField_a_of_type_Boolean = true;
        return this;
        label749:
        bool = false;
        i = 0;
        localObject2 = null;
        localObject3 = null;
        k = -1;
        j = -1000;
      }
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.ProcessOneMsg
 * JD-Core Version:    0.7.0.1
 */