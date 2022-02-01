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
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131697229);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopAtAllMsg))
    {
      paramObject = (TroopAtAllMsg)paramObject;
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    }
    for (paramMessageInfo = paramObject;; paramMessageInfo = paramObject)
    {
      if (QLog.isColorLevel()) {
        QLog.d(MessageInfo.class.getSimpleName() + ".troop.special_msg.at_all_msg", 2, "updateMsgInfo");
      }
      return paramMessageInfo;
      paramObject = new TroopAtAllMsg(BaseApplication.getContext());
      paramObject.a(paramMessageRecord.senderuin);
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopAtAllMsg
 * JD-Core Version:    0.7.0.1
 */