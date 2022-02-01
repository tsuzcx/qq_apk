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
    this.jdField_a_of_type_JavaLangString = ("[" + HardCodeUtil.a(2131697261) + "]");
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((StructMsgForGeneralShare)StructMsgFactory.a(paramMessageRecord.msgData) == null)
    {
      if (!QLog.isColorLevel()) {
        break label136;
      }
      QLog.d("Navigate.UpdateMsgInfoUtil", 2, "updateMsgInfo():calendarMsg getStructMsg is null");
      paramMessageRecord = "";
    }
    for (;;)
    {
      if ((paramObject instanceof TroopCalendarMsg))
      {
        paramObject = (TroopCalendarMsg)paramObject;
        paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      }
      for (paramMessageInfo = paramObject;; paramMessageInfo = paramObject)
      {
        if (!TextUtils.isEmpty(paramMessageRecord)) {
          paramMessageInfo.jdField_a_of_type_JavaLangString = ("[" + paramMessageRecord + "]");
        }
        return paramMessageInfo;
        paramMessageRecord = StructMsgForGeneralShare.remindBrief;
        break;
        paramObject = new TroopCalendarMsg(BaseApplication.getContext());
        paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      }
      label136:
      paramMessageRecord = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopCalendarMsg
 * JD-Core Version:    0.7.0.1
 */