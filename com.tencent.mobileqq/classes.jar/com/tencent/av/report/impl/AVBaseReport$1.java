package com.tencent.av.report.impl;

import com.tencent.av.report.AVReportLog;
import com.tencent.ilive.opensdk.reporterinterface.SimpleCoreHttpResponse;
import org.json.JSONObject;

class AVBaseReport$1
  extends SimpleCoreHttpResponse
{
  AVBaseReport$1(AVBaseReport paramAVBaseReport) {}
  
  public void onResponse(int paramInt, JSONObject paramJSONObject)
  {
    paramJSONObject = new StringBuilder();
    paramJSONObject.append("report result code=");
    paramJSONObject.append(paramInt);
    AVReportLog.i("AVBaseReport", paramJSONObject.toString(), new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.report.impl.AVBaseReport.1
 * JD-Core Version:    0.7.0.1
 */