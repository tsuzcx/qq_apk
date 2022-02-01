package com.tencent.av.ui;

import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ConferenceFlyTicketActivity$OnReportHrSelfNickNameTask
  extends BaseDownloadAsyncTask
{
  public ConferenceFlyTicketActivity$OnReportHrSelfNickNameTask(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    AudioHelper.b("上传SelfNickName_rsp");
    boolean bool = paramDownloadParams.f.f;
    String str = "";
    Object localObject;
    StringBuilder localStringBuilder;
    if (bool)
    {
      try
      {
        paramDownloadParams = new String(paramDownloadParams.f.a, "UTF-8");
      }
      catch (Exception paramDownloadParams)
      {
        if (QLog.isColorLevel())
        {
          localObject = this.a.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPostDownloadComplete :");
          localStringBuilder.append(paramDownloadParams.toString());
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        paramDownloadParams = null;
      }
      if (paramDownloadParams == null) {}
    }
    try
    {
      localObject = new JSONObject(paramDownloadParams);
      i = ((JSONObject)localObject).getInt("retcode");
      if (QLog.isColorLevel())
      {
        paramDownloadParams = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnReportHrSelfNickNameTask.onPostDownloadComplete : retcode = ");
        localStringBuilder.append(i);
        QLog.d(paramDownloadParams, 2, localStringBuilder.toString());
      }
      paramDownloadParams = str;
      if (((JSONObject)localObject).has("result"))
      {
        localObject = ((JSONObject)localObject).getJSONObject("result");
        paramDownloadParams = str;
        if (((JSONObject)localObject).has("result_code")) {
          paramDownloadParams = ((JSONObject)localObject).getString("result_code");
        }
      }
    }
    catch (JSONException paramDownloadParams)
    {
      int i;
      label215:
      int j;
      break label215;
    }
    j = -2;
    paramDownloadParams = str;
    i = j;
    if (QLog.isColorLevel())
    {
      paramDownloadParams = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostDownloadComplete : result_code = ");
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(",retcode = ");
      ((StringBuilder)localObject).append(-2);
      QLog.i(paramDownloadParams, 2, ((StringBuilder)localObject).toString());
      paramDownloadParams = str;
      i = j;
      break label301;
      i = 1;
      paramDownloadParams = str;
    }
    label301:
    if ((i == 0) && (paramDownloadParams.equals("0")))
    {
      this.a.b();
      return;
    }
    this.a.a(1, 0);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.OnReportHrSelfNickNameTask
 * JD-Core Version:    0.7.0.1
 */