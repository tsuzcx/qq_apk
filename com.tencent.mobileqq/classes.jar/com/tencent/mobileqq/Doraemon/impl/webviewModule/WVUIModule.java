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
    Object localObject = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a() instanceof WebUiUtils.WebShareInterface)) {
      localObject = (WebUiUtils.WebShareInterface)this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    }
    if (localObject == null) {
      return false;
    }
    localObject = (Share)((WebUiUtils.WebShareInterface)localObject).getShare();
    if (localObject == null) {
      return false;
    }
    ((Share)localObject).a(paramAPICallback);
    return true;
  }
  
  private boolean a(JSONObject paramJSONObject)
  {
    WebUiUtils.WebShareInterface localWebShareInterface = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a() instanceof WebUiUtils.WebShareInterface)) {
      localWebShareInterface = (WebUiUtils.WebShareInterface)this.jdField_a_of_type_ComTencentMobileqqDoraemonImplWebviewModuleAbsWVModule$WebViewRuntimeCompat.a();
    }
    if (localWebShareInterface == null) {
      return false;
    }
    Bundle localBundle = new Bundle();
    String str1 = paramJSONObject.optString("title");
    String str2 = paramJSONObject.optString("desc");
    String str3 = paramJSONObject.optString("shareUrl");
    paramJSONObject = paramJSONObject.optString("imageUrl");
    String str4 = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a().b;
    if (!TextUtils.isEmpty(str4))
    {
      localBundle.putString("source_name", str4);
      localBundle.putString("source_icon", this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a().e);
    }
    localBundle.putInt("extra_url_info_from", 1);
    return localWebShareInterface.setSummary(str1, str2, str3, paramJSONObject, localBundle);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 25: 
      if (a(paramJSONObject)) {
        DoraemonUtil.a(paramAPICallback, APIParam.a);
      }
      break;
    }
    for (;;)
    {
      return true;
      DoraemonUtil.a(paramAPICallback, -1, "");
      continue;
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      paramString = this.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager.a();
      if ((paramString == null) || (paramString.isFinishing()))
      {
        QLog.e("WVUIModule", 1, "execute activity is null or finish");
        return false;
      }
      paramString.finish();
      continue;
      DoraemonUtil.a(paramAPICallback, APIParam.a);
      continue;
      if (a(paramAPICallback)) {
        DoraemonUtil.a(paramAPICallback, APIParam.a);
      } else {
        DoraemonUtil.a(paramAPICallback, -1, "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webviewModule.WVUIModule
 * JD-Core Version:    0.7.0.1
 */