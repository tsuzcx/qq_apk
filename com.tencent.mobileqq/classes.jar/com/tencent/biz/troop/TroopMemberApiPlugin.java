package com.tencent.biz.troop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"InlinedApi"})
public class TroopMemberApiPlugin
  extends WebViewPlugin
  implements ITroopMemberApiClientApi.Callback
{
  AtomicBoolean a = new AtomicBoolean(false);
  TroopMemberApiClient b = null;
  VideoCombineHelper c = null;
  protected String d;
  
  public TroopMemberApiPlugin()
  {
    this.mPluginNameSpace = "TroopMemberApiPlugin";
  }
  
  private void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("gcode");
      localObject = ((JSONObject)localObject).optString("id");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        this.b.b(paramString, (String)localObject);
      }
      return;
    }
    catch (JSONException paramString)
    {
      Object localObject;
      paramString.printStackTrace();
      if (QLog.isColorLevel())
      {
        localObject = this.mTAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("anonymousReport exception");
        localStringBuilder.append(paramString.getMessage());
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
    }
  }
  
  void a()
  {
    if (this.a.compareAndSet(false, true))
    {
      this.b = TroopMemberApiClient.a();
      this.b.e();
    }
  }
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    if ("changeAnonymousNick".equals(paramBundle.getString("method")))
    {
      boolean bool = paramBundle.getBoolean("result");
      paramBundle = this.d;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{result : ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append("}");
      callJs(paramBundle, new String[] { ((StringBuilder)localObject).toString() });
      return;
    }
    Object localObject = paramBundle.getString("callback");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      callJs((String)localObject, new String[] { paramBundle.getString("data") });
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool = "anonymousReport".equals(paramString3);
    int i = 0;
    if (bool)
    {
      a(paramVarArgs[0]);
      return true;
    }
    int j;
    Object localObject1;
    Object localObject2;
    if ("anonymousNickChanged".equals(paramString3))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        paramString1 = paramJsBridgeListener.optString("troopUin");
        long l = paramJsBridgeListener.optLong("bubbleId");
        i = paramJsBridgeListener.optInt("headId");
        paramString2 = paramJsBridgeListener.optString("nickName");
        j = paramJsBridgeListener.optInt("expireTime");
        paramString3 = paramJsBridgeListener.optString("rankColor");
        this.d = paramJsBridgeListener.optString("callback");
        if (QLog.isColorLevel())
        {
          paramVarArgs = this.mTAG;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("TroopMemberApiPlugin, anonymousNickChanged, json : ");
          ((StringBuilder)localObject1).append(paramJsBridgeListener);
          QLog.d(paramVarArgs, 2, ((StringBuilder)localObject1).toString());
        }
        this.b.a(paramString1, l, i, paramString2, j, paramString3, this);
        return true;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label1237;
        }
      }
      paramString1 = this.mTAG;
      paramString2 = new StringBuilder();
      paramString2.append("TroopMemberApiPlugin, anonymousNickChanged, JSONException :");
      paramString2.append(paramJsBridgeListener);
      QLog.d(paramString1, 2, paramString2.toString());
      return false;
    }
    else
    {
      if ("getUploadInfo".equals(paramString3)) {
        try
        {
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { "{stateus:0}" });
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      if ("cleanDynamicRedPoint".equals(paramString3)) {
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
          this.b.c(paramJsBridgeListener, this);
          return true;
        }
        catch (JSONException paramJsBridgeListener)
        {
          paramJsBridgeListener.printStackTrace();
          return true;
        }
      }
      bool = "selectedTribe".endsWith(paramString3);
      paramJsBridgeListener = "";
      if ((bool) && (paramVarArgs.length == 1))
      {
        try
        {
          paramString1 = new JSONObject(paramVarArgs[0]);
          localObject1 = this.mRuntime.d();
          paramVarArgs = paramString1.optString("name");
          paramString2 = paramString1.optString("bid");
          localObject2 = paramString1.optJSONObject("condition");
          paramString3 = paramString1.optString("tribeList");
          Intent localIntent = new Intent();
          paramString1 = paramVarArgs;
          if (TextUtils.isEmpty(paramVarArgs)) {
            paramString1 = "";
          }
          localIntent.putExtra("tribeName", paramString1);
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = "";
          }
          localIntent.putExtra("bid", paramString1);
          if (!TextUtils.isEmpty(paramString3)) {
            break label1691;
          }
          localIntent.putExtra("tribeList", paramJsBridgeListener);
          i = ((JSONObject)localObject2).optInt("optionType", -1);
          if (i != -1) {
            localIntent.putExtra("optionType", i);
          }
          ((Activity)localObject1).setResult(-1, localIntent);
          ((Activity)localObject1).finish();
          return false;
        }
        catch (JSONException paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label1237;
          }
        }
        paramString1 = this.mTAG;
        paramString2 = new StringBuilder();
        paramString2.append("JSONException:");
        paramString2.append(paramJsBridgeListener.toString());
        QLog.e(paramString1, 2, paramString2.toString());
        return false;
      }
      else
      {
        if ("getTroopBarPublishInfo".equals(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            if (this.b == null)
            {
              this.b = TroopMemberApiClient.a();
              this.b.e();
            }
            this.b.a(new TroopMemberApiPlugin.1(this, paramJsBridgeListener));
            return false;
          }
          catch (JSONException paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return false;
          }
        }
        if (("createVideoAndSend".equals(paramString3)) || ("prepareVideoResources".equals(paramString3))) {
          break label1239;
        }
        if ("checkVideoLib".equals(paramString3)) {
          try
          {
            paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
            paramString1 = new JSONObject();
            if (VideoEnvironment.checkAndLoadAVCodec())
            {
              paramString1.put("retCode", 0);
              callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
              return false;
            }
            paramString1.put("retCode", -1);
            callJs(paramJsBridgeListener, new String[] { paramString1.toString() });
            if (this.b == null)
            {
              this.b = TroopMemberApiClient.a();
              this.b.e();
            }
            this.b.h();
            return false;
          }
          catch (Exception paramJsBridgeListener)
          {
            paramJsBridgeListener.printStackTrace();
            return false;
          }
        }
        if ((!"setTribePublishTopic".equals(paramString3)) || (paramVarArgs.length != 1)) {}
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramString2 = paramString1.optString("callback");
        paramString3 = new JSONObject();
        paramVarArgs = this.mRuntime.d();
        i = paramString1.optInt("theme_id", -1);
        paramString1 = paramString1.optString("theme_name");
        localObject1 = new Intent();
        if ((i != -1) && (paramString1 == null))
        {
          paramVarArgs.setResult(0, (Intent)localObject1);
          paramString3.put("retCode", -1);
        }
        else
        {
          ((Intent)localObject1).putExtra("theme_id", i);
          if (!TextUtils.isEmpty(paramString1)) {
            break label1697;
          }
          ((Intent)localObject1).putExtra("theme_name", paramJsBridgeListener);
          paramVarArgs.setResult(-1, (Intent)localObject1);
          paramString3.put("retCode", 0);
        }
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = this.mTAG;
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("setTribePublishTopic JSAPI mThemeID = ");
          paramVarArgs.append(i);
          paramVarArgs.append(" mThemeName = ");
          paramVarArgs.append(paramString1);
          QLog.d(paramJsBridgeListener, 2, paramVarArgs.toString());
        }
        callJs(paramString2, new String[] { paramString3.toString() });
        return false;
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label1237;
        }
      }
      paramString1 = this.mTAG;
      paramString2 = new StringBuilder();
      paramString2.append("selectedTheme JSONException:");
      paramString2.append(paramJsBridgeListener.toString());
      QLog.e(paramString1, 2, paramString2.toString());
      return false;
      if (("enableShortVideoPublish".equals(paramString3)) && (paramVarArgs.length == 1)) {
        try
        {
          paramJsBridgeListener = new JSONObject();
          paramJsBridgeListener.put("enableShortVideoPublish", ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).supportCapture());
          if (QLog.isColorLevel())
          {
            paramString1 = this.mTAG;
            paramString2 = new StringBuilder();
            paramString2.append("retJson=");
            paramString2.append(paramJsBridgeListener);
            QLog.d(paramString1, 2, paramString2.toString());
          }
          callJs(new JSONObject(paramVarArgs[0]).optString("callback"), new String[] { paramJsBridgeListener.toString() });
          return false;
        }
        catch (Exception paramJsBridgeListener)
        {
          if (QLog.isColorLevel())
          {
            paramString1 = this.mTAG;
            paramString2 = new StringBuilder();
            paramString2.append("enableShortVideoPublish exp:");
            paramString2.append(paramJsBridgeListener.toString());
            QLog.e(paramString1, 2, paramString2.toString());
          }
        }
      }
      label1237:
      return false;
      try
      {
        label1239:
        if (QLog.isColorLevel())
        {
          paramJsBridgeListener = this.mTAG;
          paramString1 = new StringBuilder();
          paramString1.append(paramString3);
          paramString1.append("json:");
          paramString1.append(paramVarArgs[0]);
          QLog.i(paramJsBridgeListener, 2, paramString1.toString());
        }
        paramVarArgs = new JSONObject(paramVarArgs[0]);
        paramString1 = paramVarArgs.optString("troopUin");
        paramString2 = paramVarArgs.optString("wording");
        localObject1 = paramVarArgs.optString("bgMusic");
        j = paramVarArgs.optInt("tailType");
        paramJsBridgeListener = paramVarArgs.optString("callback");
        paramVarArgs = paramVarArgs.optJSONArray("videos");
        if (((!"createVideoAndSend".equals(paramString3)) || (!TextUtils.isEmpty(paramString1))) && (!TextUtils.isEmpty(paramString2)) && (paramVarArgs != null) && (paramVarArgs.length() != 0))
        {
          if (this.c == null) {
            this.c = new VideoCombineHelper((QBaseActivity)this.mRuntime.d());
          }
          localObject2 = this.c;
          localObject2.getClass();
          localObject2 = new VideoCombineHelper.CombineParams((VideoCombineHelper)localObject2);
          ((VideoCombineHelper.CombineParams)localObject2).c = paramString1;
          ((VideoCombineHelper.CombineParams)localObject2).e = ((String)localObject1);
          ((VideoCombineHelper.CombineParams)localObject2).f = paramString2;
          ((VideoCombineHelper.CombineParams)localObject2).g = j;
          while (i < paramVarArgs.length())
          {
            paramString1 = paramVarArgs.getString(i);
            ((VideoCombineHelper.CombineParams)localObject2).d.add(paramString1);
            i += 1;
          }
          if ("createVideoAndSend".equals(paramString3))
          {
            this.c.a((VideoCombineHelper.CombineParams)localObject2, new TroopMemberApiPlugin.2(this, paramJsBridgeListener));
            return true;
          }
          this.c.b((VideoCombineHelper.CombineParams)localObject2, new TroopMemberApiPlugin.3(this, paramJsBridgeListener));
          return true;
        }
        paramString3 = new JSONObject();
        paramString3.put("retCode", 1);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("params error: troopUin = ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" wroding = ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(" array = ");
        ((StringBuilder)localObject1).append(paramVarArgs);
        paramString3.put("errorMsg", ((StringBuilder)localObject1).toString());
        callJs(paramJsBridgeListener, new String[] { paramString3.toString() });
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        QLog.e(this.mTAG, 1, "invoke createVideoAndSend failed", paramJsBridgeListener);
        return true;
      }
      label1691:
      paramJsBridgeListener = paramString3;
      break;
      label1697:
      paramJsBridgeListener = paramString1;
    }
  }
  
  protected void onCreate()
  {
    AppInterface localAppInterface = this.mRuntime.b();
    Activity localActivity = this.mRuntime.d();
    if (localAppInterface != null)
    {
      if (localActivity == null) {
        return;
      }
      a();
    }
  }
  
  protected void onDestroy()
  {
    if (this.a.get()) {
      this.b.f();
    }
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiPlugin
 * JD-Core Version:    0.7.0.1
 */