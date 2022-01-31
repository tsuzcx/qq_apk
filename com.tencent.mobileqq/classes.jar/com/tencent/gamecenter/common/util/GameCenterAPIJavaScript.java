package com.tencent.gamecenter.common.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class GameCenterAPIJavaScript
  extends WebViewPlugin
{
  public static final String TAG = "GCApi";
  private DisplayMetrics dm;
  private Context mContext;
  private String uin = "";
  
  public GameCenterAPIJavaScript()
  {
    this.mPluginNameSpace = "GCApi";
  }
  
  public String getOpenidBatch(String paramString)
  {
    String str = "";
    if ((this.mContext instanceof GameCenterActivity)) {
      str = GameCenterActivity.a(this.mContext, "http://cgi.connect.qq.com/api/get_openids_by_appids", paramString, this.uin);
    }
    return str;
  }
  
  public String getReportPublicData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + MobileInfoUtil.c());
      localStringBuilder.append("|");
      localStringBuilder.append("" + MobileInfoUtil.a());
      localStringBuilder.append("|");
      localStringBuilder.append("" + GCCommon.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.MODEL);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getReportPublicHighData()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      localStringBuilder.append("" + GCCommon.b());
      localStringBuilder.append("|");
      localStringBuilder.append("" + APNUtil.a(this.mContext.getApplicationContext()));
      localStringBuilder.append("|");
      localStringBuilder.append("" + Build.VERSION.RELEASE);
      localStringBuilder.append("|");
      localStringBuilder.append("" + CommonDataAdapter.a().d());
      localStringBuilder.append("|");
      localStringBuilder.append(AppSetting.a);
      localStringBuilder.append("|");
      localStringBuilder.append(this.dm.widthPixels + " * " + this.dm.heightPixels);
      return localStringBuilder.toString();
    }
    catch (Exception localException) {}
    return "";
  }
  
  public String getVersionName()
  {
    try
    {
      String str = CommonDataAdapter.a().d();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "4.3.0";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("GCApi".equals(paramString2))
    {
      if (("getOpenidBatch".equals(paramString3)) && (paramVarArgs.length == 1)) {
        paramString1 = getOpenidBatch(paramVarArgs[0]);
      }
      for (;;)
      {
        if ((paramJsBridgeListener != null) && (paramString1 != null)) {
          paramJsBridgeListener.a(paramString1);
        }
        return true;
        if (("showWarningToast".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          showWarningToast(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getUin".equals(paramString3))
        {
          paramString1 = this.uin;
        }
        else if (("setTitleLoading".equals(paramString3)) && (paramVarArgs.length == 1))
        {
          setTitleLoading(paramVarArgs[0]);
          paramString1 = null;
        }
        else if ("getReportPublicData".equals(paramString3))
        {
          paramString1 = getReportPublicData();
        }
        else if ("getReportPublicHighData".equals(paramString3))
        {
          paramString1 = getReportPublicHighData();
        }
        else if (("reportAction".equals(paramString3)) && (paramVarArgs.length == 3))
        {
          reportAction(paramVarArgs[0], paramVarArgs[1], paramVarArgs[2]);
          paramString1 = null;
        }
        else if ("getVersionName".equals(paramString3))
        {
          paramString1 = getVersionName();
        }
        else
        {
          if (("startToAuthorized".equals(paramString3)) && (paramVarArgs.length == 1)) {
            startToAuthorized(paramVarArgs[0]);
          }
          paramString1 = null;
        }
      }
    }
    return false;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.dm = new DisplayMetrics();
    this.mContext = this.mRuntime.a();
    if (this.mContext != null) {
      ((Activity)this.mContext).getWindowManager().getDefaultDisplay().getMetrics(this.dm);
    }
    if (this.mRuntime.a() != null) {
      this.uin = this.mRuntime.a().getCurrentAccountUin();
    }
  }
  
  public void reportAction(String paramString1, String paramString2, String paramString3)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(this.mRuntime.a(), this.uin, paramString1, paramString2, 0, 1, paramString3, null, null, null, null);
  }
  
  public void setTitleLoading(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {
      try
      {
        if ("true".equals(paramString)) {}
        for (int i = 1; i != 0; i = 0)
        {
          ((GameCenterActivity)this.mContext).a.sendEmptyMessage(2003);
          return;
          if (!"false".equals(paramString)) {
            return;
          }
        }
        ((GameCenterActivity)this.mContext).a.sendEmptyMessage(2004);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void showWarningToast(String paramString)
  {
    if ((this.mContext instanceof GameCenterActivity)) {}
    try
    {
      Message localMessage = Message.obtain(((GameCenterActivity)this.mContext).a);
      localMessage.what = 2006;
      localMessage.obj = paramString;
      ((GameCenterActivity)this.mContext).a.sendMessage(localMessage);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void startToAuthorized(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      ((JSONObject)localObject).put("uin", this.uin);
      localObject = ((JSONObject)localObject).toString();
      paramString = (String)localObject;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    MyAppApi.a().a(paramString, null, (Activity)this.mContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GameCenterAPIJavaScript
 * JD-Core Version:    0.7.0.1
 */