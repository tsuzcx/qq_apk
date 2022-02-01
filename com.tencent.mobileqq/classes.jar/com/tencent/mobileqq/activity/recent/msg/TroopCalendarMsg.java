package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.StructMsgFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class TroopCalendarMsg
  extends TroopAtMsg
{
  public TroopCalendarMsg(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append("[");
    paramContext.append(HardCodeUtil.a(2131895053));
    paramContext.append("]");
    this.c = paramContext.toString();
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)StructMsgFactory.a(paramMessageRecord.msgData) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      }
      paramMessageRecord = "";
    }
    else
    {
      paramMessageRecord = StructMsgForGeneralShare.remindBrief;
    }
    if ((paramObject instanceof TroopCalendarMsg))
    {
      paramObject = (TroopCalendarMsg)paramObject;
      paramObject.h.b(paramMessageInfo.c);
      paramMessageInfo = paramObject;
    }
    else
    {
      paramObject = new TroopCalendarMsg(BaseApplication.getContext());
      paramObject.h = new MessageNavInfo(paramMessageInfo.c);
      paramMessageInfo = paramObject;
    }
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      paramObject = new StringBuilder();
      paramObject.append("[");
      paramObject.append(paramMessageRecord);
      paramObject.append("]");
      paramMessageInfo.c = paramObject.toString();
    }
    return paramMessageInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg
 * JD-Core Version:    0.7.0.1
 */