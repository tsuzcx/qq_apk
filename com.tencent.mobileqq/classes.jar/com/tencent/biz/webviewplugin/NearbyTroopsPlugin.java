package com.tencent.biz.webviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NearbyTroopsPlugin
  extends WebViewPlugin
{
  AIOAnimationControlManager a = null;
  
  public NearbyTroopsPlugin()
  {
    this.mPluginNameSpace = "NearbyTroopsPlugin";
  }
  
  protected void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelectTypeResult:");
        localStringBuilder.append(paramString);
        QLog.d("NearbyTroopsPlugin", 2, localStringBuilder.toString());
      }
      Activity localActivity = this.mRuntime.d();
      Intent localIntent = new Intent();
      localStringBuilder = null;
      try
      {
        paramString = new JSONObject(paramString).getJSONObject("data");
      }
      catch (Exception localException)
      {
        paramString = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("setSelectTypeResult:");
          paramString.append(localException.toString());
          QLog.d("NearbyTroopsPlugin", 2, paramString.toString());
          paramString = localStringBuilder;
        }
      }
      if (paramString != null)
      {
        localIntent.putExtra("data", paramString.toString());
        localActivity.setResult(-1, localIntent);
      }
      else
      {
        localActivity.setResult(0, localIntent);
      }
      localActivity.finish();
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSelectTypeResult:");
        localStringBuilder.append(paramString.toString());
        QLog.d("NearbyTroopsPlugin", 2, localStringBuilder.toString());
      }
    }
  }
  
  protected void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("giftAnimation:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("NearbyTroopsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = this.mRuntime.d();
      if (localObject1 != null)
      {
        if (((Activity)localObject1).isFinishing()) {
          return;
        }
        Object localObject2 = new JSONObject(paramString);
        int i = ((JSONObject)localObject2).optInt("id");
        long l1 = ((JSONObject)localObject2).optLong("senderUin", 0L);
        long l2 = ((JSONObject)localObject2).optLong("receiveUin", 0L);
        paramString = ((JSONObject)localObject2).optString("brief");
        boolean bool = ((JSONObject)localObject2).optBoolean("showClose", false);
        String str1 = ((JSONObject)localObject2).optString("senderAvatarURL");
        String str2 = ((JSONObject)localObject2).optString("receiverAvatarURL");
        localObject2 = ((JSONObject)localObject2).optString("callback");
        MessageForDeliverGiftTips localMessageForDeliverGiftTips = new MessageForDeliverGiftTips();
        localMessageForDeliverGiftTips.animationPackageId = i;
        localMessageForDeliverGiftTips.senderUin = l1;
        localMessageForDeliverGiftTips.receiverUin = l2;
        localMessageForDeliverGiftTips.showCloseBtn = bool;
        localMessageForDeliverGiftTips.animationBrief = paramString;
        localMessageForDeliverGiftTips.senderAvatarUrl = str1;
        localMessageForDeliverGiftTips.receiveAvatarUrl = str2;
        localMessageForDeliverGiftTips.frienduin = String.valueOf(10000L);
        if (this.a == null)
        {
          callJs((String)localObject2, new String[] { "{\"result\":10,\"message\":\"troopGiftManager is null\"}" });
          return;
        }
        this.a.a((Activity)localObject1);
        if (this.a.a(localMessageForDeliverGiftTips))
        {
          this.a.k = new NearbyTroopsPlugin.1(this, (String)localObject2);
          paramString = new StringBuilder();
          paramString.append("{\"result\":0,\"id\":");
          paramString.append(i);
          paramString.append("}");
          callJs((String)localObject2, new String[] { paramString.toString() });
          return;
        }
        callJs((String)localObject2, new String[] { "{\"result\":2}" });
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      Object localObject1;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setSelectTypeResult:");
        ((StringBuilder)localObject1).append(paramString.toString());
        QLog.d("NearbyTroopsPlugin", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ("NearbyTroopsPlugin".equals(paramString2))
    {
      if (("setSelectTypeResult".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        a(paramVarArgs[0]);
        return true;
      }
      if (("giftAnimation".equals(paramString3)) && (paramVarArgs.length > 0))
      {
        b(paramVarArgs[0]);
        return true;
      }
    }
    return false;
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
      this.a = ((AIOAnimationControlManager)localAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER));
    }
  }
  
  protected void onDestroy()
  {
    AIOAnimationControlManager localAIOAnimationControlManager = this.a;
    if (localAIOAnimationControlManager != null) {
      localAIOAnimationControlManager.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NearbyTroopsPlugin
 * JD-Core Version:    0.7.0.1
 */