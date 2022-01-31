package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReportPlugin
  extends WebViewPlugin
{
  public static final String a = ReportPlugin.class.getSimpleName();
  private static final String b = ReportPlugin.class.getName();
  
  public ReportPlugin()
  {
    this.mPluginNameSpace = a;
  }
  
  protected static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    JSONObject localJSONObject;
    try
    {
      paramQQAppInterface = paramQQAppInterface.a().a(paramString, 0, 10);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
      {
        paramString = new JSONArray();
        localJSONObject = new JSONObject();
        i = 0;
        if ((i < paramQQAppInterface.size()) && (i < 10))
        {
          localObject = new JSONObject();
          MessageRecord localMessageRecord = (MessageRecord)paramQQAppInterface.get(i);
          if ((localMessageRecord instanceof MessageForPic))
          {
            MessageForPic localMessageForPic = (MessageForPic)localMessageRecord;
            localMessageForPic.parse();
            ((JSONObject)localObject).put("content", localMessageForPic.msg.replace("&", URLEncoder.encode("&", "UTF-8")) + ",uuid:" + localMessageForPic.uuid);
          }
          for (;;)
          {
            ((JSONObject)localObject).put("contentType", "" + localMessageRecord.msgtype);
            ((JSONObject)localObject).put("time", "" + localMessageRecord.time);
            paramString.put(i, localObject);
            i += 1;
            break;
            if ((localMessageRecord instanceof MessageForText)) {
              ((JSONObject)localObject).put("content", localMessageRecord.msg.replace("&", URLEncoder.encode("&", "UTF-8")));
            }
          }
        }
      }
      else
      {
        return "0";
      }
    }
    catch (Exception paramQQAppInterface) {}
    Object localObject = new StringBuilder().append("");
    if (paramQQAppInterface.size() <= 10) {}
    for (int i = paramQQAppInterface.size();; i = 10)
    {
      localJSONObject.put("msgnum", i);
      localJSONObject.put("contentlist", paramString);
      paramQQAppInterface = localJSONObject.toString();
      return paramQQAppInterface;
    }
  }
  
  public static String a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    for (;;)
    {
      try
      {
        Object localObject;
        if ((paramMessageRecord instanceof MessageForPtt))
        {
          localObject = (MessageForPtt)paramMessageRecord;
          ((MessageForPtt)localObject).parse();
          localJSONObject2.put("content", paramMessageRecord.msg + ",urlAtServer:" + ((MessageForPtt)localObject).urlAtServer);
          localJSONObject2.put("contentType", "" + paramMessageRecord.msgtype);
          localJSONObject2.put("time", "" + paramMessageRecord.time);
          localJSONArray.put(0, localJSONObject2);
          localJSONObject1.put("msgnum", "1");
          localJSONObject1.put("contentlist", localJSONArray);
          return localJSONObject1.toString();
        }
        if ((paramMessageRecord instanceof MessageForPic))
        {
          localObject = (MessageForPic)paramMessageRecord;
          ((MessageForPic)localObject).parse();
          localJSONObject2.put("content", ((MessageForPic)localObject).msg + ",uuid:" + ((MessageForPic)localObject).uuid);
        }
        else
        {
          localJSONObject2.put("content", paramMessageRecord.msg);
        }
      }
      catch (Exception paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.i(b, 2, "getReportMessage:" + paramMessageRecord.getMessage());
        }
        return "0";
      }
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if ((paramContext == null) || (paramQQAppInterface == null) || (TextUtils.isEmpty(paramString3)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(b, 2, "safetyReport param null");
      }
      label31:
      return;
    }
    String str3 = "impeachuin=" + paramString3;
    if ((paramInt != 403) && (paramInt != 405) && (paramInt != 406) && (!TextUtils.isEmpty(paramString1))) {}
    for (String str2 = "groupuin=" + paramString1;; str2 = "groupuin=0")
    {
      paramString3 = (FriendsManager)paramQQAppInterface.getManager(50);
      if (paramString3 == null) {}
      label169:
      Object localObject;
      for (boolean bool = false;; bool = paramString3.b(paramString2)) {
        switch (paramInt)
        {
        default: 
          str1 = "subapp=BusinessCard";
          if (!bool) {
            break label844;
          }
          paramString3 = "uin_source=friend";
          localObject = "msglist=" + a(paramQQAppInterface, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label851;
          }
          if (!QLog.isColorLevel()) {
            break label31;
          }
          QLog.d(b, 2, "eviluinparm param null");
          return;
        }
      }
      String str1 = "subapp=BusinessCard";
      if (bool) {}
      for (paramString3 = "uin_source=friend";; paramString3 = "uin_source=unfriend")
      {
        localObject = "msglist=" + a(paramQQAppInterface, paramString2);
        if (!TextUtils.isEmpty(paramString2)) {
          break label301;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(b, 2, "eviluinparm param null");
        return;
      }
      label301:
      paramQQAppInterface = "eviluin=" + paramString2;
      paramString2 = (String)localObject;
      for (;;)
      {
        localObject = new StringBuffer();
        ((StringBuffer)localObject).append("appname=KQQ&jubaotype=uin&system=android");
        ((StringBuffer)localObject).append("&" + str1);
        ((StringBuffer)localObject).append("&SourceID=").append(paramInt);
        ((StringBuffer)localObject).append("&" + str2 + "&" + paramQQAppInterface + "&" + str3);
        if (!TextUtils.isEmpty(paramString3)) {
          ((StringBuffer)localObject).append("&" + paramString3);
        }
        ((StringBuffer)localObject).append("&" + paramString2);
        if ((paramInt == 403) || (paramInt == 402) || (paramInt == 406) || (paramInt == 405))
        {
          ((StringBuffer)localObject).append("&tinnyid=").append(paramString4);
          if ((paramInt == 403) || (paramInt == 406) || (paramInt == 405))
          {
            ((StringBuffer)localObject).append("&lid=").append(paramString1);
            if ((paramInt == 405) || ((paramInt == 406) && (!TextUtils.isEmpty(paramString5)))) {
              ((StringBuffer)localObject).append("&commentid=").append(paramString5);
            }
          }
        }
        try
        {
          paramQQAppInterface = new Intent(paramContext, QQBrowserActivity.class);
          paramQQAppInterface.putExtra("BSafeReportPost", true);
          paramQQAppInterface.putExtra("SafeReportData", ((StringBuffer)localObject).toString().getBytes("utf-8"));
          paramQQAppInterface.putExtra("hide_more_button", true);
          paramQQAppInterface.putExtra("ishiderefresh", true);
          paramQQAppInterface.putExtra("ishidebackforward", true);
          if (!(paramContext instanceof Activity)) {
            paramQQAppInterface.addFlags(268435456);
          }
          paramContext.startActivity(paramQQAppInterface.putExtra("url", "http://jubao.qq.com/cn/jubao"));
          return;
        }
        catch (Exception paramContext) {}
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(b, 2, "safetyReport exception" + paramContext.getMessage());
        return;
        str1 = "subapp=BusinessCard";
        if (bool) {}
        for (paramString3 = "uin_source=hot_group_friend";; paramString3 = "uin_source=hot_group_unfriend")
        {
          localObject = "msglist=" + a(paramQQAppInterface, paramString2);
          if (!TextUtils.isEmpty(paramString2)) {
            break label795;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d(b, 2, "eviluinparm param null");
          return;
        }
        label795:
        paramQQAppInterface = "eviluin=" + paramString2;
        paramString2 = (String)localObject;
        continue;
        str1 = "subapp=group";
        paramString3 = "";
        paramString2 = "msglist=0";
        paramQQAppInterface = "eviluin=0";
        continue;
        label844:
        paramString3 = "uin_source=unfriend";
        break label169;
        label851:
        paramQQAppInterface = "eviluin=" + paramString2;
        paramString2 = (String)localObject;
      }
    }
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a(paramBaseActivity, paramInt, paramString1, paramString2, paramString3, "0", "");
  }
  
  public static void a(BaseActivity paramBaseActivity, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    a(paramBaseActivity, paramBaseActivity.app, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  private boolean a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getIntent() == null)) {
      return false;
    }
    return this.mRuntime.a().getIntent().getBooleanExtra("BSafeReportPost", false);
  }
  
  private byte[] a()
  {
    if ((this.mRuntime == null) || (this.mRuntime.a() == null) || (this.mRuntime.a().getIntent() == null)) {
      return null;
    }
    return this.mRuntime.a().getIntent().getByteArrayExtra("SafeReportData");
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
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    if ((paramLong == 32L) && (a()))
    {
      a(paramString, a());
      paramString = this.mRuntime.a(this.mRuntime.a());
      if ((paramString != null) && ((paramString instanceof WebUiUtils.WebUiMethodInterface))) {
        ((WebUiUtils.WebUiMethodInterface)paramString).a();
      }
      return true;
    }
    return false;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ReportPlugin
 * JD-Core Version:    0.7.0.1
 */