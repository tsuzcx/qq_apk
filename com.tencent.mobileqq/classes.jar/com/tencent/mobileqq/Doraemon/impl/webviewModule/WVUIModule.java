package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class WVUIModule
  extends AbsWVModule
{
  private boolean a(APICallback paramAPICallback)
  {
    if ((this.b.d() instanceof WebUiUtils.WebShareInterface)) {
      localObject = (WebUiUtils.WebShareInterface)this.b.d();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return false;
    }
    Object localObject = (Share)((WebUiUtils.WebShareInterface)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((Share)localObject).a(paramAPICallback);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    WebUiUtils.WebShareInterface localWebShareInterface;
    if ((this.b.d() instanceof WebUiUtils.WebShareInterface)) {
      localWebShareInterface = (WebUiUtils.WebShareInterface)this.b.d();
    } else {
      localWebShareInterface = null;
    }
    if (localWebShareInterface == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.a.f().d;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.a.f().g);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localWebShareInterface.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (paramInt != 2)
    {
      if (paramInt != 22)
      {
        if (paramInt != 25)
        {
          if (paramInt != 26) {
            return false;
          }
          if (a(paramAPICallback))
          {
            DoraemonUtil.a(paramAPICallback, APIParam.a);
            return true;
          }
          DoraemonUtil.a(paramAPICallback, -1, "");
          return true;
        }
        if (a(paramJSONObject))
        {
          DoraemonUtil.a(paramAPICallback, APIParam.a);
          return true;
        }
        DoraemonUtil.a(paramAPICallback, -1, "");
        return true;
      }
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      return true;
    }
    DoraemonUtil.a(paramAPICallback, APIParam.a);
    paramString = this.a.h();
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      paramString.finish();
      return true;
    }
    QLog.e("WVUIModule", 1, "execute activity is null or finish");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webviewModule.WVUIModule
 * JD-Core Version:    0.7.0.1
 */