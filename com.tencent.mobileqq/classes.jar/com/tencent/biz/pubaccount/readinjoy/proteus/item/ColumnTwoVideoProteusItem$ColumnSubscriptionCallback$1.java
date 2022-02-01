package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.os.Bundle;
import pvs;
import qig;
import qih;

public class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1
  implements Runnable
{
  public ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$1(pvs parampvs, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("subscribeAction", 0);
    if ((i == 1) && (this.jdField_a_of_type_Int != 0))
    {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("columnId", 0);
      str = this.jdField_a_of_type_AndroidOsBundle.getString("columnIconUrl", "");
      qig.a.a().a(this.jdField_a_of_type_Int, str, String.valueOf(i), 1);
    }
    while (i != 2)
    {
      String str;
      return;
    }
    qig.a.a().a(true, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.1
 * JD-Core Version:    0.7.0.1
 */