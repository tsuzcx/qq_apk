package com.tencent.mobileqq.activity.aio.item;

import ageh;
import aloz;
import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    ageh.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Bbtn, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (ageh.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)ageh.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      aloz localaloz = (aloz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localaloz));
      ageh.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */