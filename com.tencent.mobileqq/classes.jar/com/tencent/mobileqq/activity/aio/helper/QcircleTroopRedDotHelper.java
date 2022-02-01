package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.AIOTroopQcircleRedDotManager;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import java.util.List;
import mqq.os.MqqHandler;

public class QcircleTroopRedDotHelper
  implements ILifeCycleHelper, OnTroopChatMsgChangedCallback
{
  public static String a;
  TroopChatPie a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "QcircleTroopRedDotHelper";
  }
  
  public QcircleTroopRedDotHelper(HelperProvider paramHelperProvider, TroopChatPie paramTroopChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = paramTroopChatPie;
    paramHelperProvider.a(this);
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    if (paramInt == 1)
    {
      AIOTroopQcircleRedDotManager.b();
      if (AIOTroopQcircleRedDotManager.a() == AIOTroopQcircleRedDotManager.c) {
        ThreadManager.excute(new QcircleTroopRedDotHelper.3(this, paramTroopChatPie, paramList), 160, null, true);
      }
    }
  }
  
  public String getTag()
  {
    return jdField_a_of_type_JavaLangString;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    }
    do
    {
      return;
      AIOTroopQcircleRedDotManager.a();
      ThreadManagerV2.excute(new QcircleTroopRedDotHelper.1(this), 160, null, true);
      return;
      AIOTroopQcircleRedDotManager.a();
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.a() == null) || ((!AIOTroopQcircleRedDotManager.a()) && (!AIOTroopQcircleRedDotManager.b())));
    List localList = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.a();
    ThreadManager.getUIHandler().post(new QcircleTroopRedDotHelper.2(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper
 * JD-Core Version:    0.7.0.1
 */