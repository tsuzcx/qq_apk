package com.tencent.mfsdk.reporter;

import android.os.Build;
import android.os.HandlerThread;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class QCloudReporter
  implements IReporter
{
  private static final String jdField_a_of_type_JavaLangString = String.format(Locale.US, "http://sngapm.qq.com/entrance/%d/uploadFile/", new Object[] { Integer.valueOf(MagnifierSDK.jdField_a_of_type_Int) });
  private static final String b = String.format(Locale.US, "http://sngapm.qq.com/entrance/%d/uploadJson/", new Object[] { Integer.valueOf(MagnifierSDK.jdField_a_of_type_Int) });
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public QCloudReporter(HandlerThread paramHandlerThread)
  {
    if (paramHandlerThread != null) {
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(paramHandlerThread.getLooper());
    }
  }
  
  public boolean a(ResultObject paramResultObject, IReporter.ReportResultCallback paramReportResultCallback)
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler == null) {
      return false;
    }
    JSONObject localJSONObject = paramResultObject.params;
    Object localObject2 = localJSONObject.optJSONObject("fileObj");
    Object localObject1 = localJSONObject.optJSONObject("clientinfo");
    int i;
    Iterator localIterator;
    String str1;
    for (;;)
    {
      try
      {
        if (localJSONObject.has("newplugin"))
        {
          i = localJSONObject.getInt("newplugin");
          localIterator = ((JSONObject)localObject1).keys();
          if (!localIterator.hasNext()) {
            break;
          }
          str1 = (String)localIterator.next();
          localJSONObject.put(str1, ((JSONObject)localObject1).getString(str1));
          continue;
        }
        i = ((JSONObject)localObject1).getInt("plugin");
      }
      catch (Exception paramResultObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Magnifier_QCloudReporter", 2, "[qcloud_report] exception: ", paramResultObject);
        }
        return false;
      }
    }
    localJSONObject.put("version", MagnifierSDK.jdField_a_of_type_JavaLangString);
    localJSONObject.put("manu", Build.BRAND);
    localJSONObject.put("device", Build.MODEL);
    localJSONObject.put("rdmuuid", ((JSONObject)localObject1).getString("rdmuuid"));
    localJSONObject.put("api_ver", 1);
    localJSONObject.put("plugin_ver", 1);
    localJSONObject.put("client_identify", UUID.randomUUID());
    localJSONObject.put("platform", "android");
    localJSONObject.put("plugin", i);
    localJSONObject.remove("clientinfo");
    localObject1 = new StringBuffer(1024);
    if ((localObject2 != null) && (i != 102))
    {
      localObject2 = ((JSONObject)localObject2).getString("fileObj1");
      localJSONObject.put("fileObj", localObject2);
      localIterator = localJSONObject.keys();
      str1 = (String)localIterator.next();
      String str2 = localJSONObject.getString(str1);
      ((StringBuffer)localObject1).append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      while (localIterator.hasNext())
      {
        str1 = (String)localIterator.next();
        str2 = localJSONObject.getString(str1);
        ((StringBuffer)localObject1).append("&").append(str1).append("=").append(URLEncoder.encode(str2, "UTF-8"));
      }
      ((StringBuffer)localObject1).append("&a=1");
      localObject1 = jdField_a_of_type_JavaLangString + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] file url: " + (String)localObject1);
      }
      paramResultObject = new QCloudFileUploadRunnable(new URL((String)localObject1), (String)localObject2, localJSONObject, paramReportResultCallback, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
    }
    else
    {
      ((StringBuffer)localObject1).append("p_id=").append(localJSONObject.getString("p_id")).append("&plugin=").append(i);
      ((StringBuffer)localObject1).append("&version=").append(URLEncoder.encode(MagnifierSDK.jdField_a_of_type_JavaLangString, "UTF-8")).append("&a=1");
      localObject1 = b + "?" + ((StringBuffer)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.i("Magnifier_QCloudReporter", 2, "[qcloud_report] json url: " + (String)localObject1 + " jsonObj: " + localJSONObject.toString());
      }
      paramResultObject = new JsonUploadRunnable(new URL((String)localObject1), localJSONObject, paramReportResultCallback, paramResultObject.dbId, this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_a_of_type_MqqOsMqqHandler.post(paramResultObject);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.QCloudReporter
 * JD-Core Version:    0.7.0.1
 */