package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class PublicAccountUtilImpl$19$1
  implements HttpWebCgiAsyncTask.Callback
{
  PublicAccountUtilImpl$19$1(PublicAccountUtilImpl.19 param19) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    if (paramJSONObject != null) {
      if (QLog.isColorLevel()) {
        QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result :" + paramJSONObject);
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("PublicAccountUtil", 2, "videoPlayRealtimeReport:return result null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.19.1
 * JD-Core Version:    0.7.0.1
 */