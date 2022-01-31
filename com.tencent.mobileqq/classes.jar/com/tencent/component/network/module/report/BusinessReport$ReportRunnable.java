package com.tencent.component.network.module.report;

import android.text.TextUtils;
import com.tencent.component.network.Global;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.http.HttpUtil;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessReport$ReportRunnable
  implements Runnable
{
  private static final int MAX_TRY_COUNT = 0;
  int appid;
  String body;
  boolean inited = false;
  ArrayList<ReportObj> listToSend;
  int op;
  boolean successed = false;
  int tryCount = 0;
  String url;
  
  public BusinessReport$ReportRunnable(ArrayList<ReportObj> paramArrayList, int paramInt1, int paramInt2)
  {
    this.listToSend = paramArrayList;
    this.appid = paramInt1;
    this.op = paramInt2;
  }
  
  private void init()
  {
    if (this.inited) {
      return;
    }
    if (this.listToSend.isEmpty())
    {
      QDLog.e("BusinessReport", "listToSend is empty.");
      return;
    }
    Object localObject = this.listToSend;
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("count", ((ArrayList)localObject).size());
      JSONArray localJSONArray = new JSONArray();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localJSONArray.put(((ReportObj)((Iterator)localObject).next()).toJSON());
        continue;
        this.url = ReportObj.getReportUrl(this.appid, this.op);
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONObject = null;
      QDLog.e("BusinessReport", "JSONException when uploadReport.", localJSONException);
    }
    for (;;)
    {
      if (QDLog.isInfoEnable()) {
        QDLog.i("BusinessReport", "url : " + this.url);
      }
      if (localJSONObject != null) {
        this.body = localJSONObject.toString();
      }
      if (QDLog.isInfoEnable()) {
        QDLog.i("BusinessReport", "json : " + this.body);
      }
      this.inited = true;
      return;
      localJSONObject.put("data", localJSONException);
    }
  }
  
  public void run()
  {
    init();
    if ((TextUtils.isEmpty(this.url)) || (TextUtils.isEmpty(this.body))) {}
    for (;;)
    {
      return;
      if (QDLog.isInfoEnable()) {
        QDLog.i("BusinessReport", "start report thread.");
      }
      try
      {
        HttpResponse localHttpResponse = HttpUtil.executeHttpPost(Global.getContext(), this.url, new StringEntity(this.body));
        if (localHttpResponse.getStatusLine() != null)
        {
          if (localHttpResponse.getStatusLine().getStatusCode() != 200) {
            break label136;
          }
          this.listToSend.clear();
          this.successed = true;
          if (QDLog.isInfoEnable()) {
            QDLog.i("BusinessReport", "report success.");
          }
        }
        while ((!this.successed) && (this.tryCount <= 0))
        {
          BusinessReport.access$200().postDelay(this, 60000L);
          return;
          label136:
          this.tryCount += 1;
          QDLog.e("BusinessReport", "HttpStatus error when report : " + localHttpResponse.getStatusLine().getStatusCode());
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "exception when report", localUnsupportedEncodingException);
        }
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "exception when report", localClientProtocolException);
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "exception when report", localIOException);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "exception when report", localIllegalArgumentException);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "exception when report", localException);
        }
      }
      catch (Error localError)
      {
        for (;;)
        {
          this.tryCount += 1;
          QDLog.w("BusinessReport", "error when report", localError);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */