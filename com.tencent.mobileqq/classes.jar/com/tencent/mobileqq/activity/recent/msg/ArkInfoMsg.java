package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.qphone.base.util.BaseApplication;

public class ArkInfoMsg
  extends TroopAtMsg
{
  public ArkInfoMsg(Context paramContext, String paramString)
  {
    a(paramString);
  }
  
  public Object a(int paramInt, MessageInfo paramMessageInfo, Object paramObject, MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = null;
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      paramQQAppInterface = ArkTipsManager.a((MessageForArkApp)paramMessageRecord);
    }
    if ((paramObject instanceof ArkInfoMsg))
    {
      paramObject = (ArkInfoMsg)paramObject;
      if (paramQQAppInterface != null) {
        paramObject.a(paramQQAppInterface);
      }
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo.a(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
    }
    paramObject = BaseApplication.getContext();
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      paramObject = new ArkInfoMsg(paramObject, paramQQAppInterface);
      paramObject.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo = new MessageNavInfo(paramMessageInfo.jdField_a_of_type_ComTencentMobileqqTroopDataMessageNavInfo);
      return paramObject;
      paramQQAppInterface = "";
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "";; paramString = '[' + paramString + ']')
    {
      this.jdField_a_of_type_JavaLangString = paramString;
      this.b = this.jdField_a_of_type_JavaLangString;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.ArkInfoMsg
 * JD-Core Version:    0.7.0.1
 */