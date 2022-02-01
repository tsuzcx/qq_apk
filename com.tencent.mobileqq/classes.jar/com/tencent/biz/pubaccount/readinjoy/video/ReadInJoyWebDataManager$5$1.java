package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebDataManager$5$1
  implements HttpWebCgiAsyncTask.Callback
{
  ReadInJoyWebDataManager$5$1(ReadInJoyWebDataManager.5 param5) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null)
    {
      this.a.this$0.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.b));
      try
      {
        if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager$HttpFetchBizCallback != null) && ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager$HttpFetchBizCallback instanceof ReadInJoyWebDataManager.HttpFetchBizCallback))) {
          this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoReadInJoyWebDataManager$HttpFetchBizCallback.a(paramJSONObject);
        }
        paramBundle = paramJSONObject.toString();
        ReadInJoyWebDataManager.a(this.a.this$0, this.a.b, paramBundle);
        if (this.a.jdField_a_of_type_OrgJsonJSONObject != null)
        {
          this.a.jdField_a_of_type_OrgJsonJSONObject.put("data", paramBundle);
          this.a.this$0.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_OrgJsonJSONObject.toString(), "", this.a.jdField_a_of_type_OrgJsonJSONObject);
        }
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:storeParams putData JSONException :" + paramBundle);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result :" + paramJSONObject);
      }
    }
    do
    {
      return;
      this.a.this$0.a(this.a.b, Integer.toString(ReadInJoyWebDataManager.a));
    } while (!QLog.isColorLevel());
    QLog.w("ReadInJoyWebDataManager", 2, "doSendRequestWithExtraHeader:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager.5.1
 * JD-Core Version:    0.7.0.1
 */