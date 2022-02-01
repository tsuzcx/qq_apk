package com.tencent.component.network.downloader.handler;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.module.report.ExtendData;
import com.tencent.component.network.module.report.ReportObj;
import org.json.JSONObject;

public class ReportHandler$DownloadReportObject
  extends ReportObj
{
  private static final String QQ_QUN_FLAG = "store.qq.com/qun/";
  public int appIdType = 0;
  public String clientip;
  public int concurrent;
  public String content_type;
  public String dnsIp;
  public String logInfo;
  public int realFilesize = 0;
  public String refer;
  public int retry;
  public int sample = 100;
  public String strategyInfo;
  public Throwable t;
  public long t_conn;
  public long t_prepare;
  public long t_process;
  public long t_recvdata;
  public long t_recvrsp;
  public long t_wait;
  public long totaltime;
  public int type = 1;
  public String url;
  
  public ReportHandler$DownloadReportObject() {}
  
  public ReportHandler$DownloadReportObject(String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, long paramLong1, long paramLong2, long paramLong3, int paramInt3, String paramString4, ExtendData paramExtendData)
  {
    super(paramInt1, paramInt2, paramString3, paramLong1, paramLong2, paramLong3, paramInt3, paramString4, paramExtendData);
    this.url = paramString1;
    this.dnsIp = paramString2;
  }
  
  private void calculateAppIdType()
  {
    if ((!TextUtils.isEmpty(this.url)) && (this.url.indexOf("store.qq.com/qun/") >= 0)) {
      this.appIdType = 10;
    }
  }
  
  public String getRefer()
  {
    if (this.appIdType == 10) {
      return "mqun";
    }
    return super.getRefer();
  }
  
  public boolean needForceReport()
  {
    return this.retry > 0;
  }
  
  public void setUrl(String paramString)
  {
    this.url = paramString;
    calculateAppIdType();
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject = super.toJSON();
    localJSONObject.put("url", this.url);
    localJSONObject.put("dnsip", this.dnsIp);
    localJSONObject.put("retry", this.retry);
    localJSONObject.put("clientip", this.clientip);
    localJSONObject.put("t_wait", this.t_wait);
    localJSONObject.put("t_prepare", this.t_prepare);
    localJSONObject.put("t_conn", this.t_conn);
    localJSONObject.put("t_recvrsp", this.t_recvrsp);
    localJSONObject.put("t_recvdata", this.t_recvdata);
    localJSONObject.put("t_process", this.t_process);
    localJSONObject.put("content_type", this.content_type);
    localJSONObject.put("concurrent", this.concurrent);
    if (this.refer != null) {
      localJSONObject.put("refer", this.refer);
    }
    if (!TextUtils.isEmpty(this.strategyInfo))
    {
      if (this.extend == null) {
        this.extend = new ExtendData();
      }
      this.extend.put(10, this.strategyInfo);
      localJSONObject.put("extend", this.extend.getExtendString());
    }
    if (this.t != null)
    {
      if (this.extend == null) {
        this.extend = new ExtendData();
      }
      String str2 = Log.getStackTraceString(this.t);
      String str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.replaceAll("\n\t", "--");
      }
      this.extend.put(11, str1);
      str2 = this.extend.getExtendString();
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        str1 = str2.replaceAll(",", ";");
      }
      localJSONObject.put("extend", str1);
    }
    if (this.type == 2)
    {
      localJSONObject.put("orgurl", this.url);
      localJSONObject.put("directip", this.serverIp);
      localJSONObject.put("contentlen", this.fileSize);
      localJSONObject.put("size", this.realFilesize);
      localJSONObject.put("sample", this.sample);
      if ((this.errMsg != null) && (this.errMsg.length() > 0))
      {
        if (localJSONObject.has("msg")) {
          localJSONObject.remove("msg");
        }
        localJSONObject.put("errdetail", this.errMsg.toString());
      }
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.downloader.handler.ReportHandler.DownloadReportObject
 * JD-Core Version:    0.7.0.1
 */