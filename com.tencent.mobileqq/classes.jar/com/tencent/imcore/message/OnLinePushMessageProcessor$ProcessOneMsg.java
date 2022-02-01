package com.tencent.imcore.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.OfflineFileMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnLinePushMessageProcessor$ProcessOneMsg
  extends BaseOnLinePushMessageProcessor.ProcessOneMsg
{
  public OnLinePushMessageProcessor$ProcessOneMsg(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams paramProcessOneMsgBuildParams)
  {
    super(paramOnLinePushMessageProcessor, paramProcessOneMsgBuildParams);
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a(paramMsgInfo, paramLong);
    if ((paramMsgInfo != null) && (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, paramMsgInfo, true))) {
      paramArrayList.add(paramMsgInfo);
    }
  }
  
  private void a(ArrayList<MsgInfo> paramArrayList, ArrayList<DelMsgInfo> paramArrayList1, long paramLong1, MsgInfo paramMsgInfo, int paramInt, long paramLong2, long paramLong3, boolean paramBoolean, DelMsgInfo paramDelMsgInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("------->msgFilter-handleC2COnlinePushMsgResp receive msg size:");
      localStringBuilder.append(paramArrayList.size());
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, paramInt, String.valueOf(paramLong3), String.valueOf(paramLong2), paramMsgInfo.uMsgTime, paramMsgInfo.shMsgSeq)) {
      return;
    }
    paramArrayList1.remove(paramDelMsgInfo);
    paramArrayList = new StringBuilder();
    paramArrayList.append(new String(paramMsgInfo.vMsg));
    paramArrayList.append(paramMsgInfo.uMsgTime);
    paramArrayList = paramArrayList.toString();
    if (!((QQAppInterface)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a).getMsgHandler().a().a(paramArrayList))
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
    }
  }
  
  private boolean a(ArrayList<MessageRecord> paramArrayList, MsgInfo paramMsgInfo)
  {
    if (paramMsgInfo.vMsg == null) {
      return true;
    }
    Object localObject1 = new byte[paramMsgInfo.vMsg.length];
    PkgTools.copyData((byte[])localObject1, 0, paramMsgInfo.vMsg, 0, localObject1.length);
    int i = localObject1[4];
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<---0x2dc push  groupCode:");
      ((StringBuilder)localObject2).append(PkgTools.getLongData(paramMsgInfo.vMsg, 0));
      ((StringBuilder)localObject2).append(" subType:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("msgSeq:");
      ((StringBuilder)localObject2).append(paramMsgInfo.shMsgSeq);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    if ((i != 16) && (i != 17) && (i != 20) && (i != 21))
    {
      if ((i != 12) && (i != 14))
      {
        if (i == 15)
        {
          OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, (byte[])localObject1, paramMsgInfo.shMsgSeq);
          return true;
        }
        if (i == 6)
        {
          OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, (byte[])localObject1);
          return false;
        }
        if (((i == 11) || (i == 13)) && (paramMsgInfo.vMsg.length > 7))
        {
          paramArrayList = new byte[paramMsgInfo.vMsg.length - 7];
          PkgTools.copyData(paramArrayList, 0, paramMsgInfo.vMsg, 7, paramArrayList.length);
          OnLinePushMessageProcessor.a(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, paramArrayList, i);
          return false;
        }
      }
      else
      {
        ((TroopGagMgr)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER)).a((byte[])localObject1, paramMsgInfo.shMsgSeq);
        return false;
      }
    }
    else if (paramMsgInfo.vMsg.length > 7)
    {
      localObject1 = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
      localObject2 = new byte[paramMsgInfo.vMsg.length - 7];
      PkgTools.copyData((byte[])localObject2, 0, paramMsgInfo.vMsg, 7, localObject2.length);
      paramMsgInfo = ((TroopTipsMsgMgr)localObject1).a((QQAppInterface)this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a, (byte[])localObject2, paramMsgInfo.shMsgSeq, paramMsgInfo.uRealMsgTime, paramMsgInfo.lMsgUid, paramMsgInfo.shMsgType, false, false, null, true);
      if (paramMsgInfo != null) {
        paramArrayList.add(paramMsgInfo);
      }
    }
    return false;
  }
  
  protected boolean a(DelMsgInfo paramDelMsgInfo)
  {
    int i = this.jdField_a_of_type_OnlinePushPackMsgInfo.shMsgType;
    long l1 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
    long l2 = this.jdField_a_of_type_OnlinePushPackMsgInfo.lFromUin;
    if (this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin() == null) {
      localObject = this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor.a.getAccount();
    } else {
      localObject = this.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getUin();
    }
    long l3 = Long.valueOf((String)localObject).longValue();
    if (169 == i)
    {
      a(this.jdField_b_of_type_JavaUtilArrayList, this.c, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, 0, l1, l2, false, paramDelMsgInfo);
      this.jdField_a_of_type_Boolean = true;
      return true;
    }
    paramDelMsgInfo = null;
    if (8 == i)
    {
      localObject = new OnLinePushMessageProcessor.HandleShMsgType0x08(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
      i = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject).a();
      j = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject).b();
      paramDelMsgInfo = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject).a();
    }
    for (l1 = ((OnLinePushMessageProcessor.HandleShMsgType0x08)localObject).a();; l1 = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject).a())
    {
      localObject = null;
      k = -1;
      bool = false;
      break label487;
      if (132 != i) {
        break;
      }
      localObject = new OnLinePushMessageProcessor.HandleShMsgType0x84(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, null).a();
      i = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject).a();
      j = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject).b();
      paramDelMsgInfo = ((OnLinePushMessageProcessor.HandleShMsgType0x84)localObject).a();
    }
    if (732 == i)
    {
      this.jdField_b_of_type_Boolean = a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo);
    }
    else
    {
      if (230 == i)
      {
        OnLinePushMessageProcessor.HandleShMsgType0xe6 localHandleShMsgType0xe6 = new OnLinePushMessageProcessor.HandleShMsgType0xe6(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, l1, l2).a();
        i = localHandleShMsgType0xe6.a();
        j = localHandleShMsgType0xe6.b();
        paramDelMsgInfo = localHandleShMsgType0xe6.a();
        localObject = localHandleShMsgType0xe6.a();
        bool = localHandleShMsgType0xe6.a();
        break label484;
      }
      if (SystemMsg.isSystemMessage(i))
      {
        localObject = new OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i).a();
        j = ((OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage)localObject).a();
        l2 = ((OnLinePushMessageProcessor.HandleShMsgTypeSystemMessage)localObject).a();
        localObject = null;
        i = 0;
        k = -1;
        bool = false;
        break label487;
      }
      if (SystemMsg.isTroopSystemMessage(i))
      {
        paramDelMsgInfo = new OnLinePushMessageProcessor.HandleShMsgTypeTroopSytemMessage(this.jdField_a_of_type_ComTencentImcoreMessageOnLinePushMessageProcessor, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, -1000, -1, l1, l2).a();
        j = paramDelMsgInfo.a();
        k = paramDelMsgInfo.b();
        l2 = paramDelMsgInfo.a();
        paramDelMsgInfo = null;
        localObject = paramDelMsgInfo;
        i = 0;
        bool = false;
        break label487;
      }
      if (528 != i) {
        break label522;
      }
      a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_OnlinePushPackMsgInfo, l3);
    }
    paramDelMsgInfo = null;
    Object localObject = paramDelMsgInfo;
    i = 0;
    int j = -1000;
    boolean bool = false;
    label484:
    int k = -1;
    label487:
    a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Long, this.jdField_a_of_type_OnlinePushPackMsgInfo, i, j, paramDelMsgInfo, (byte[])localObject, k, l1, l2, bool, this.jdField_b_of_type_Boolean);
    return false;
    label522:
    if (QLog.isColorLevel()) {
      QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor.ProcessOneMsg
 * JD-Core Version:    0.7.0.1
 */