package com.tencent.mobileqq.activity.aio.item;

import afzs;
import alkk;
import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    afzs.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbpe, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (afzs.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)afzs.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      alkk localalkk = (alkk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localalkk));
      afzs.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */