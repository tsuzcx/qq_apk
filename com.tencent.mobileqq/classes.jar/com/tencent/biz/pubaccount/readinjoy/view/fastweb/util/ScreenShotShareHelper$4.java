package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;
import com.tencent.qphone.base.util.QLog;

class ScreenShotShareHelper$4
  implements TroopMemberApiClient.Callback
{
  ScreenShotShareHelper$4(ScreenShotShareHelper paramScreenShotShareHelper, boolean paramBoolean) {}
  
  public void callback(Bundle paramBundle)
  {
    int j = paramBundle.getInt("readinjoy_to_wx_config");
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "config = " + j + ", scene" + i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilScreenShotShareHelper.a(j, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ScreenShotShareHelper.4
 * JD-Core Version:    0.7.0.1
 */