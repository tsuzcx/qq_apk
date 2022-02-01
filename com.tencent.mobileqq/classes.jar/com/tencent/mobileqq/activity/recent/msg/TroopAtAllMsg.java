package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TroopAtAllMsg
  extends TroopAtMsg
{
  public TroopAtAllMsg(Context paramContext)
  {
    this.c = HardCodeUtil.a(2131895021);
    this.d = this.c;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopAtAllMsg))
    {
      paramObject = (TroopAtAllMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      paramMessageInfo = paramObject;
    }
    else
    {
      paramObject = new TroopAtAllMsg(BaseApplication.getContext());
      paramObject.b(paramMessageRecord.senderuin);
      paramObject.h = new MessageNavInfo(paramMessageInfo.c);
      paramMessageInfo = paramObject;
    }
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append(MessageInfo.class.getSimpleName());
      paramObject.append(".troop.special_msg.at_all_msg");
      QLog.d(paramObject.toString(), 2, "updateMsgInfo");
    }
    return paramMessageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg
 * JD-Core Version:    0.7.0.1
 */