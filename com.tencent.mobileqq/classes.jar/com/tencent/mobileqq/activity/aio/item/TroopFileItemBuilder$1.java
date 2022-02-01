package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import java.util.HashMap;

final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    TroopFileItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1;
    if (TroopFileItemBuilder.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)TroopFileItemBuilder.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    } else {
      l1 = 0L;
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      TroopFileHandler localTroopFileHandler = (TroopFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localTroopFileHandler));
      TroopFileItemBuilder.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */