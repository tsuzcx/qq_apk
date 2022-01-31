package com.tencent.mobileqq.activity.aio;

import azmz;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AIOOpenWebMonitor$1
  implements Runnable
{
  public AIOOpenWebMonitor$1(QQAppInterface paramQQAppInterface, int paramInt, String paramString, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int != 1) {
          break;
        }
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(this.jdField_a_of_type_JavaLangString);
      } while (localObject == null);
      HashMap localHashMap = new HashMap(3);
      localHashMap.put("m_num", ((TroopInfo)localObject).wMemberNum + "");
      azmz.a(BaseApplication.getContext()).a(null, "AIOWebTC", false, 0L, 0L, localHashMap, "", false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    } while (localObject == null);
    Object localObject = ((List)localObject).iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while (((ChatMessage)((Iterator)localObject).next()).msgUid != this.jdField_a_of_type_Long);
    for (int i = 1;; i = 2)
    {
      localObject = new HashMap(3);
      ((HashMap)localObject).put("m_i", i + "");
      azmz.a(BaseApplication.getContext()).a(null, "AIOWebmsgposition", false, 0L, 0L, (HashMap)localObject, "", false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1
 * JD-Core Version:    0.7.0.1
 */