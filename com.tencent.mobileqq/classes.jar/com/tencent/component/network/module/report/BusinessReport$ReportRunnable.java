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
    Object localObject2 = this.listToSend;
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("count", ((ArrayList)localObject2).size());
      JSONArray localJSONArray = new JSONArray();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        localJSONArray.put(((ReportObj)((Iterator)localObject2).next()).toJSON());
      }
      ((JSONObject)localObject1).put("data", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      localObject1 = null;
      QDLog.e("BusinessReport", "JSONException when uploadReport.", localJSONException);
    }
    this.url = ReportObj.getReportUrl(this.appid, this.op);
    if (QDLog.isInfoEnable())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("url : ");
      localStringBuilder.append(this.url);
      QDLog.i("BusinessReport", localStringBuilder.toString());
    }
    if (localObject1 != null) {
      this.body = ((JSONObject)localObject1).toString();
    }
    if (QDLog.isInfoEnable())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("json : ");
      ((StringBuilder)localObject1).append(this.body);
      QDLog.i("BusinessReport", ((StringBuilder)localObject1).toString());
    }
    this.inited = true;
  }
  
  public void run()
  {
    init();
    if (!TextUtils.isEmpty(this.url))
    {
      if (TextUtils.isEmpty(this.body)) {
        return;
      }
      if (QDLog.isInfoEnable()) {
        QDLog.i("BusinessReport", "start report thread.");
      }
      try
      {
        HttpResponse localHttpResponse = HttpUtil.executeHttpPost(Global.getContext(), this.url, new StringEntity(this.body));
        if (localHttpResponse.getStatusLine() != null) {
          if (localHttpResponse.getStatusLine().getStatusCode() == 200)
          {
            this.listToSend.clear();
            this.successed = true;
            if (QDLog.isInfoEnable()) {
              QDLog.i("BusinessReport", "report success.");
            }
          }
          else
          {
            this.tryCount += 1;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("HttpStatus error when report : ");
            localStringBuilder.append(localHttpResponse.getStatusLine().getStatusCode());
            QDLog.e("BusinessReport", localStringBuilder.toString());
          }
        }
      }
      catch (Error localError)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "error when report", localError);
      }
      catch (Exception localException)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "exception when report", localException);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "exception when report", localIllegalArgumentException);
      }
      catch (IOException localIOException)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "exception when report", localIOException);
      }
      catch (ClientProtocolException localClientProtocolException)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "exception when report", localClientProtocolException);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        this.tryCount += 1;
        QDLog.w("BusinessReport", "exception when report", localUnsupportedEncodingException);
      }
      if ((!this.successed) && (this.tryCount <= 0)) {
        BusinessReport.access$200().postDelay(this, 60000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.report.BusinessReport.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */