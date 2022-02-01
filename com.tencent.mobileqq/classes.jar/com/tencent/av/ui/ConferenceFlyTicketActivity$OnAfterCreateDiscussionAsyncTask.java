package com.tencent.av.ui;

import com.tencent.av.utils.download.BaseDownloadAsyncTask;
import com.tencent.av.utils.download.DownloadParams;
import com.tencent.av.utils.download.DownloadResult;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.qphone.base.util.QLog;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.json.JSONException;
import org.json.JSONObject;

class ConferenceFlyTicketActivity$OnAfterCreateDiscussionAsyncTask
  extends BaseDownloadAsyncTask
{
  public ConferenceFlyTicketActivity$OnAfterCreateDiscussionAsyncTask(ConferenceFlyTicketActivity paramConferenceFlyTicketActivity)
  {
    SSLSocketFactory.getSocketFactory().setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
  }
  
  public void a(DownloadParams paramDownloadParams)
  {
    boolean bool = paramDownloadParams.f.f;
    String str3 = "";
    StringBuilder localStringBuilder;
    if (bool)
    {
      try
      {
        String str1 = new String(paramDownloadParams.f.a, "UTF-8");
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = this.a.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onPostDownloadComplete :");
          localStringBuilder.append(localException.toString());
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        str2 = null;
      }
      if (str2 == null) {}
    }
    try
    {
      localObject = new JSONObject(str2);
      i = ((JSONObject)localObject).getInt("retcode");
      if (QLog.isColorLevel())
      {
        str2 = this.a.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnAfterCreateDiscussionAsyncTask.onPostDownloadComplete : retcode = ");
        localStringBuilder.append(i);
        QLog.d(str2, 2, localStringBuilder.toString());
      }
      str2 = str3;
      if (((JSONObject)localObject).has("result"))
      {
        localObject = ((JSONObject)localObject).getJSONObject("result");
        str2 = str3;
        if (((JSONObject)localObject).has("result_code")) {
          str2 = ((JSONObject)localObject).getString("result_code");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      label221:
      int j;
      break label221;
    }
    j = -2;
    i = j;
    String str2 = str3;
    if (QLog.isColorLevel())
    {
      str2 = this.a.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPostDownloadComplete : result_code = ");
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(",retcode = ");
      ((StringBuilder)localObject).append(-2);
      QLog.i(str2, 2, ((StringBuilder)localObject).toString());
      i = j;
      str2 = str3;
      break label312;
      i = 1;
      str2 = str3;
    }
    label312:
    str3 = this.a.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnAfterCreateDiscussionAsyncTask, IsSucc[");
    ((StringBuilder)localObject).append(paramDownloadParams.f.f);
    ((StringBuilder)localObject).append("], retcode[");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("], result_code[");
    ((StringBuilder)localObject).append(str2);
    ((StringBuilder)localObject).append("], mDiscID[");
    ((StringBuilder)localObject).append(this.a.h);
    ((StringBuilder)localObject).append("]");
    QLog.w(str3, 1, ((StringBuilder)localObject).toString());
    if ((i == 0) && (str2.equals("0")))
    {
      this.a.n.a(Long.parseLong(this.a.h), this.a.c);
      paramDownloadParams = this.a;
      paramDownloadParams.a(paramDownloadParams.h, this.a.c);
      this.a.finish();
      return;
    }
    this.a.n.c(Long.parseLong(this.a.h));
    this.a.a(1, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConferenceFlyTicketActivity.OnAfterCreateDiscussionAsyncTask
 * JD-Core Version:    0.7.0.1
 */