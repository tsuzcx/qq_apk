package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager;
import com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager.Companion;

class ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$2
  implements Runnable
{
  ColumnTwoVideoProteusItem$ColumnSubscriptionCallback$2(ColumnTwoVideoProteusItem.ColumnSubscriptionCallback paramColumnSubscriptionCallback, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_AndroidOsBundle.getInt("subscribeAction");
    if ((i == 1) && (this.jdField_a_of_type_Int != 0))
    {
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("columnId");
      str = this.jdField_a_of_type_AndroidOsBundle.getString("columnIconUrl", "");
      RIJPushNotifyManager.a.a().a(this.jdField_a_of_type_Int, str, String.valueOf(i), 1);
    }
    while (i != 2)
    {
      String str;
      return;
    }
    RIJPushNotifyManager.a.a().a(true, "MATCH_ALL_UIN");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.ColumnTwoVideoProteusItem.ColumnSubscriptionCallback.2
 * JD-Core Version:    0.7.0.1
 */