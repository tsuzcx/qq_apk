package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportPlugin
  extends WebViewPlugin
{
  public static final String a = "ReportPlugin";
  private static final String b = "com.tencent.biz.webviewplugin.ReportPlugin";
  
  public ReportPlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    Object localObject1 = new JSONArray();
    Object localObject2 = new JSONObject();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      boolean bool = paramMessageRecord instanceof MessageForPtt;
      StringBuilder localStringBuilder;
      if (bool)
      {
        localObject3 = (MessageForPtt)paramMessageRecord;
        ((MessageForPtt)localObject3).parse();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramMessageRecord.msg);
        localStringBuilder.append(",urlAtServer:");
        localStringBuilder.append(((MessageForPtt)localObject3).urlAtServer);
        localJSONObject.put("content", localStringBuilder.toString());
      }
      else if ((paramMessageRecord instanceof MessageForPic))
      {
        localObject3 = (MessageForPic)paramMessageRecord;
        ((MessageForPic)localObject3).parse();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((MessageForPic)localObject3).msg);
        localStringBuilder.append(",uuid:");
        localStringBuilder.append(((MessageForPic)localObject3).uuid);
        localJSONObject.put("content", localStringBuilder.toString());
      }
      else
      {
        localJSONObject.put("content", paramMessageRecord.msg);
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramMessageRecord.msgtype);
      localJSONObject.put("contentType", ((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramMessageRecord.time);
      localJSONObject.put("time", ((StringBuilder)localObject3).toString());
      ((JSONArray)localObject1).put(0, localJSONObject);
      ((JSONObject)localObject2).put("msgnum", "1");
      ((JSONObject)localObject2).put("contentlist", localObject1);
      paramMessageRecord = ((JSONObject)localObject2).toString();
      return paramMessageRecord;
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject1 = b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getReportMessage:");
        ((StringBuilder)localObject2).append(paramMessageRecord.getMessage());
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
    }
    return "0";
  }
  
  private boolean a()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null))
    {
      if (this.mRuntime.a().getIntent() == null) {
        return false;
      }
      return this.mRuntime.a().getIntent().getBooleanExtra("BSafeReportPost", false);
    }
    return false;
  }
  
  private byte[] a()
  {
    if ((this.mRuntime != null) && (this.mRuntime.a() != null) && (this.mRuntime.a().getIntent() != null)) {
      return this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData");
    }
    return null;
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    CustomWebView localCustomWebView = this.mRuntime.a();
    if (localCustomWebView == null) {
      return;
    }
    try
    {
      localCustomWebView.postUrl(paramString, paramArrayOfByte);
      localCustomWebView.requestFocus();
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 32L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if ((paramLong == 32L) && (a()))
    {
      a(paramString, a());
      this.mRuntime.a().readyForLoadJs();
      return true;
    }
    return false;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */