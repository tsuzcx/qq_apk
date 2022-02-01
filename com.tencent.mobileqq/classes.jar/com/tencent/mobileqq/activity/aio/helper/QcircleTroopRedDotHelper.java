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
  public static String a = "QcircleTroopRedDotHelper";
  TroopChatPie a;
  
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
    return new int[] { 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      AIOTroopQcircleRedDotManager.a();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((localObject != null) && (((TroopChatPie)localObject).a != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.a() == null) {
          return;
        }
        if ((!AIOTroopQcircleRedDotManager.a()) && (!AIOTroopQcircleRedDotManager.b())) {
          return;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a.a();
        ThreadManager.getUIHandler().post(new QcircleTroopRedDotHelper.2(this, (List)localObject));
      }
    }
    else
    {
      AIOTroopQcircleRedDotManager.a();
      ThreadManagerV2.excute(new QcircleTroopRedDotHelper.1(this), 160, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.QcircleTroopRedDotHelper
 * JD-Core Version:    0.7.0.1
 */