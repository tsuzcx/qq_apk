package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopAtMeMsg
  extends TroopAtMsg
{
  public TroopAtMeMsg(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131697231);
    this.b = this.jdField_a_of_type_JavaLangString;
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if ((paramObject instanceof TroopAtMeMsg))
    {
      paramObject = (TroopAtMeMsg)paramObject;
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
    }
    paramObject = new TroopAtMeMsg(BaseApplication.getContext());
    paramObject.a(paramMessageRecord.senderuin);
    paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopAtMeMsg
 * JD-Core Version:    0.7.0.1
 */