package com.tencent.biz.subscribe.utils;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

final class EvilReportUtil$1
  implements Callback
{
  EvilReportUtil$1(Context paramContext, EvilReportUtil.EvilReportParams paramEvilReportParams) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.d("QCircleEvilReport", 1, "repose is failed jump to h5");
    EvilReportUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizSubscribeUtilsEvilReportUtil$EvilReportParams, "Jbq0Dm55FudiaTa26UjP071XduhCyIKRYaK6MCcYzZA");
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    try
    {
      paramCall = new JSONObject(paramResponse.body().string()).optString("key");
      QLog.d("QCircleEvilReport", 1, "response is success jump to h5");
      EvilReportUtil.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizSubscribeUtilsEvilReportUtil$EvilReportParams, paramCall);
      return;
    }
    catch (Throwable paramCall)
    {
      paramResponse = new StringBuilder();
      paramResponse.append("response is failed");
      paramResponse.append(paramCall);
      QLog.d("QCircleEvilReport", 1, paramResponse.toString());
      paramCall.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.EvilReportUtil.1
 * JD-Core Version:    0.7.0.1
 */