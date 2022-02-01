package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import bioy;
import org.json.JSONException;
import uav;

class ReadInjoyWebShareHelper$3$1
  implements Runnable
{
  ReadInjoyWebShareHelper$3$1(ReadInjoyWebShareHelper.3 param3, String paramString1, String paramString2) {}
  
  public void run()
  {
    Activity localActivity = uav.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.this$0).a();
    if ((localActivity == null) || (localActivity.isFinishing())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.this$0.a(this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.a, this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.c, this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.d, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_ComTencentBizPubaccountUtilReadInjoyWebShareHelper$3.e, 13);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3.1
 * JD-Core Version:    0.7.0.1
 */