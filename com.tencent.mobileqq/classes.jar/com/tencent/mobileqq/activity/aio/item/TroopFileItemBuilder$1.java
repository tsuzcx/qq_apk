package com.tencent.mobileqq.activity.aio.item;

import aede;
import ajsx;
import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    aede.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Azqv, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (aede.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)aede.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      ajsx localajsx = (ajsx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localajsx));
      aede.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */