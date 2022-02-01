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
    String str = (String)paramMap.get("url");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("openWebUrl openWebUrl openWebUrl url = ");
    ((StringBuilder)localObject).append(str);
    logI("UIJavascriptInterface", ((StringBuilder)localObject).toString());
    Uri.parse(str);
    localObject = (String)paramMap.get("target");
    paramMap = (String)paramMap.get("no_history");
    try
    {
      i = Integer.valueOf((String)localObject).intValue();
    }
    catch (Exception localException)
    {
      int i;
      label89:
      break label89;
    }
    Log.e("UIJavascriptInterface", "illegal target");
    i = 1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if (!TextUtils.isEmpty(str))
      {
        if (str.contains("quan.qq.com"))
        {
          startWebActivity(str);
          return;
        }
        if ((!str.startsWith("http://")) && (!str.startsWith("https://")) && (!str.startsWith("file://")))
        {
          startOuterActivity(str);
          return;
        }
        if (SPUtil.get(this.mContext, "nowlive_config").getString("status", "1").equals("1"))
        {
          ((FloatWindowConfigServiceInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowConfigServiceInterface.class)).setFloatWindowEnabledOnce(true);
          ((FloatWindowPermissionInterface)BizEngineMgr.getInstance().getLiveEngine().getService(FloatWindowPermissionInterface.class)).requestPermissionAndDoJump((Activity)this.mContext, new UIJavascriptInterface.2(this, paramMap, str));
          return;
        }
        startWebActivity(paramMap, str);
      }
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start activity error, e =");
      localStringBuilder.append(paramString.toString());
      logE("UIJavascriptInterface", localStringBuilder.toString());
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
    }
    catch (Exception paramMap)
    {
      int i;
      label35:
      break label35;
    }
    Log.e("UIJavascriptInterface", "illegal target");
    i = 1;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((!TextUtils.isEmpty(str)) && ((str.startsWith("http://")) || (str.startsWith("https://")) || (str.startsWith("file://")))) {
        startWebActivity(str);
      }
    }
  }
  
  @NewJavascriptInterface
  public void openUrlInWx(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openUrlInWx:");
    localStringBuilder.append(paramMap);
    Log.i("UIJavascriptInterface", localStringBuilder.toString());
  }
  
  @NewJavascriptInterface
  public void savePic(Map<String, String> paramMap)
  {
    paramMap = (String)paramMap.get("url");
    Object localObject1 = this.mContext.getCacheDir().getAbsolutePath();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject2).append(".jpg");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new File((String)localObject1, (String)localObject2);
    if ((getJsBizAdapter() != null) && (getJsBizAdapter().getHttp() != null)) {
      getJsBizAdapter().getHttp().download(paramMap, null, ((File)localObject1).getAbsolutePath(), new UIJavascriptInterface.1(this, (File)localObject1, (String)localObject2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.UIJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */