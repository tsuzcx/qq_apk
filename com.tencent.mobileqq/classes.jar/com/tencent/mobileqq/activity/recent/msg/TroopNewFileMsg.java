package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class TroopNewFileMsg
  extends TroopAtMsg
{
  public int c;
  
  public TroopNewFileMsg(Context paramContext, int paramInt)
  {
    this.c = paramInt;
    if (paramInt == 0) {
      this.jdField_a_of_type_JavaLangString = "";
    }
    while (paramInt != 1) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = HardCodeUtil.a(2131715540);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    if (((paramObject instanceof TroopNewFileMsg)) && (((TroopNewFileMsg)paramObject).c == 0))
    {
      paramObject = (TroopNewFileMsg)paramObject;
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
    }
    paramObject = new TroopNewFileMsg(BaseApplication.getContext(), 0);
    paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopNewFileMsg
 * JD-Core Version:    0.7.0.1
 */