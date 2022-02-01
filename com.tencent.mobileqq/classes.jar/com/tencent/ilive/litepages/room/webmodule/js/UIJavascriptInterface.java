package com.tencent.ilive.litepages.room.webmodule.js;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowPermissionInterface;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.utils.SPUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteUIJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import com.tencent.ilivesdk.webcomponent.StartWebViewHelper;
import com.tencent.ilivesdk.webcomponent.activity.WebActivity;
import com.tencent.livesdk.liveengine.LiveEngine;
import java.io.File;
import java.util.Map;

public class UIJavascriptInterface
  extends BaseLiteUIJavascriptInterface
{
  private static final String LITTLE_WINDOW_OPEN = "1";
  private static final String TAG = "UIJavascriptInterface";
  
  public UIJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  private File mkPicDirInDCIM()
  {
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  private void openWebUrl(Map<String, String> paramMap)
  {
    String str1 = (String)paramMap.get("url");
    logI("UIJavascriptInterface", "openWebUrl openWebUrl openWebUrl url = " + str1);
    Uri.parse(str1);
    String str2 = (String)paramMap.get("target");
    paramMap = (String)paramMap.get("no_history");
    try
    {
      i = Integer.valueOf(str2).intValue();
      switch (i)
      {
      }
    }
    catch (Exception localException)
    {
      do
      {
        for (;;)
        {
          Log.e("UIJavascriptInterface", "illegal target");
          int i = 1;
        }
      } while (TextUtils.isEmpty(str1));
      if (str1.contains("quan.qq.com"))
      {
        startWebActivity(str1);
        return;
      }
      if ((str1.startsWith("http://")) || (str1.startsWith("https://")) || (str1.startsWith("file://")))
      {
        if (SPUtil.get(this.mContext, "nowlive_config").getString("status", "1").equals("1"))
        {
          ((FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class)).setFloatWindowEnabledOnce(true);
          ((FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class)).requestPermissionAndDoJump((Activity)this.mContext, new UIJavascriptInterface.2(this, paramMap, str1));
          return;
        }
        startWebActivity(paramMap, str1);
        return;
      }
      startOuterActivity(str1);
    }
  }
  
  private void startOuterActivity(String paramString)
  {
    try
    {
      paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
      paramString.setFlags(268435456);
      this.mContext.startActivity(paramString);
      return;
    }
    catch (Exception paramString)
    {
      logE("UIJavascriptInterface", "start activity error, e =" + paramString.toString());
    }
  }
  
  private void startWebActivity(String paramString)
  {
    startWebActivity("0", paramString);
  }
  
  private void startWebActivity(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(this.mContext, WebActivity.class);
    localIntent.putExtra("needskey", true);
    if ("1".equals(paramString1)) {
      localIntent.putExtra("leftClickClose", true);
    }
    localIntent.putExtra("url", paramString2);
    StartWebViewHelper.startInnerWebView(this.mContext, localIntent);
    SPUtil.get(this.mContext, "nowlive_config").putString("pageType", "activity");
  }
  
  @NewJavascriptInterface
  public void closeCurrentWebView(Map<String, String> paramMap)
  {
    Log.d("UIJavascriptInterface", "closeCurrentWebView");
    ((Activity)this.mContext).finish();
  }
  
  @NewJavascriptInterface
  public void openUrl(Map<String, String> paramMap)
  {
    openWebUrl(paramMap);
  }
  
  @NewJavascriptInterface
  public void openUrlInHost(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("url");
    paramMap = (String)paramMap.get("target");
    try
    {
      i = Integer.valueOf(paramMap).intValue();
      switch (i)
      {
      }
    }
    catch (Exception paramMap)
    {
      do
      {
        for (;;)
        {
          Log.e("UIJavascriptInterface", "illegal target");
          int i = 1;
        }
      } while ((TextUtils.isEmpty(str)) || ((!str.startsWith("http://")) && (!str.startsWith("https://")) && (!str.startsWith("file://"))));
      startWebActivity(str);
    }
  }
  
  @NewJavascriptInterface
  public void openUrlInWx(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    Log.i("UIJavascriptInterface", "openUrlInWx:" + paramMap);
  }
  
  @NewJavascriptInterface
  public void savePic(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    Object localObject = this.mContext.getCacheDir().getAbsolutePath();
    String str = System.currentTimeMillis() + ".jpg";
    localObject = new File((String)localObject, str);
    if ((getJsBizAdapter() != null) && (getJsBizAdapter().getHttp() != null)) {
      getJsBizAdapter().getHttp().download(paramMap, null, ((File)localObject).getAbsolutePath(), new UIJavascriptInterface.1(this, (File)localObject, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */