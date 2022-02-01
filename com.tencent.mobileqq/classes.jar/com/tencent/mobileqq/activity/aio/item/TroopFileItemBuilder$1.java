package com.tencent.mobileqq.activity.aio.item;

import ahkv;
import android.app.Activity;
import anrb;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    ahkv.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bfjs, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (ahkv.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)ahkv.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      anrb localanrb = (anrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localanrb));
      ahkv.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */