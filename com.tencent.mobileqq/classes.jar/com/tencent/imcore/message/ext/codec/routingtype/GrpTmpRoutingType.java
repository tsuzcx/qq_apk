package com.tencent.imcore.message.ext.codec.routingtype;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.core.codec.RoutingType;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.GrpTmp;
import msf.msgsvc.msg_svc.RoutingHead;

public class GrpTmpRoutingType
  implements RoutingType<AppInterface>
{
  public int a()
  {
    return 1000;
  }
  
  public boolean a(msg_svc.RoutingHead paramRoutingHead, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    if ((!TextUtils.isEmpty(paramMessageRecord.senderuin)) && (Long.valueOf(paramMessageRecord.senderuin).longValue() != 0L) && (!TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.selfuin))) {
      TextUtils.equals(paramMessageRecord.senderuin, paramMessageRecord.frienduin);
    }
    paramAppInterface = new msg_svc.GrpTmp();
    if (TextUtils.isEmpty(paramMessageRecord.senderuin))
    {
      paramAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.selfuin).longValue());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("createSendRichTextMsgReq, senderuin error, senderuin: ");
        localStringBuilder.append(paramMessageRecord.senderuin);
        localStringBuilder.append(" frienduin: ");
        localStringBuilder.append(paramMessageRecord.frienduin);
        localStringBuilder.append(" msgtype: ");
        localStringBuilder.append(paramMessageRecord.msgtype);
        QLog.d("GrpTmpRoutingType", 2, localStringBuilder.toString());
      }
    }
    else
    {
      paramAppInterface.group_uin.set(Long.valueOf(paramMessageRecord.senderuin).longValue());
    }
    paramAppInterface.to_uin.set(Long.valueOf(paramMessageRecord.frienduin).longValue());
    paramRoutingHead.grp_tmp.set(paramAppInterface);
    return true;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 6000;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.routingtype.GrpTmpRoutingType
 * JD-Core Version:    0.7.0.1
 */