package com.tencent.mobileqq.activity.aio.item;

import agrx;
import amoo;
import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public final class TroopFileItemBuilder$1
  implements Runnable
{
  public void run()
  {
    agrx.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Becp, this.jdField_a_of_type_ComTencentMobileqqDataMessageForTroopFile);
    long l1 = 0L;
    if (agrx.a.containsKey(this.jdField_a_of_type_JavaLangString)) {
      l1 = ((Long)agrx.a.get(this.jdField_a_of_type_JavaLangString)).longValue();
    }
    long l2 = System.currentTimeMillis();
    if (l2 - l1 > 10000L)
    {
      amoo localamoo = (amoo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(22);
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new TroopFileItemBuilder.1.1(this, localamoo));
      agrx.a.put(this.jdField_a_of_type_JavaLangString, Long.valueOf(l2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopFileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */