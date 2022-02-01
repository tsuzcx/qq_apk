package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.troop.api.essence.data.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.qphone.base.util.QLog;

public class WriteTogetherEssenceMsgHelper
  implements ILifeCycleHelper, OnActivityResultCallback
{
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  public WriteTogetherEssenceMsgHelper(HelperProvider paramHelperProvider, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.a();
    paramHelperProvider.a(this);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    long l1 = 0L;
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L) || (paramInt == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("WriteTogetherEssenceMsgHelper", 1, "setEssenceMsgIfNeed: return");
      }
      return;
    }
    try
    {
      long l2 = Long.valueOf(paramString).longValue();
      l1 = l2;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    paramString = new TroopEssenceMsgItem();
    paramString.troopUin = l1;
    paramString.msgSeq = paramLong;
    paramString.msgRandom = paramInt;
    paramString.opUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramString.msgSenderUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    paramString.opType = 1;
    if (QLog.isColorLevel()) {
      QLog.i("WriteTogetherEssenceMsgHelper", 1, "setEssenceMsgIfNeed: msgItem = " + paramString.toString());
    }
    ((TroopEssenceMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(paramString, 2);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 18005) {}
    for (;;)
    {
      return;
      if ((paramInt2 & 0x4) != 0) {
        ((FullScreenInputHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(24)).b(false);
      }
      if ((paramIntent != null) && (paramIntent.getExtras() != null)) {
        try
        {
          paramIntent = paramIntent.getExtras();
          String str = paramIntent.getString("KEY_WRITE_TOGETHER_GROUPUIN", null);
          long l = paramIntent.getLong("KEY_WRITE_TOGETHER_MSG_SEQ", 0L);
          paramInt1 = paramIntent.getInt("KEY_WRITE_TOGETHER_MSG_RANDOM", 0);
          if (this.jdField_a_of_type_Boolean)
          {
            a(str, l, paramInt1);
            return;
          }
        }
        catch (Exception paramIntent)
        {
          if (QLog.isColorLevel()) {
            QLog.i("WriteTogetherEssenceMsgHelper", 1, "onActivityResult: e = " + paramIntent);
          }
          paramIntent.printStackTrace();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String getTag()
  {
    return "WriteTogetherEssenceMsgHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[0];
  }
  
  public void onMoveToState(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.WriteTogetherEssenceMsgHelper
 * JD-Core Version:    0.7.0.1
 */