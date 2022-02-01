package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIManager;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class NavigateModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    paramString = this.a.a();
    if ((paramString != null) && (!paramString.isFinishing()))
    {
      Intent localIntent;
      switch (paramInt)
      {
      default: 
        return false;
      case 21: 
        paramJSONObject = paramJSONObject.optString("url", "");
        localIntent = new Intent();
        localIntent.putExtra("url", paramJSONObject);
        RouteUtils.a(paramString, localIntent, "/base/browser");
        DoraemonUtil.a(paramAPICallback, APIParam.a);
        return true;
      case 19: 
        paramJSONObject = paramJSONObject.optString("action", "");
        if ((paramJSONObject != null) && (paramJSONObject.startsWith("mqqapi:")))
        {
          localIntent = new Intent();
          localIntent.setData(Uri.parse(paramJSONObject));
          RouteUtils.a(paramString, localIntent, "/base/jump");
          DoraemonUtil.a(paramAPICallback, APIParam.a);
          return true;
        }
        DoraemonUtil.a(paramAPICallback, -1, "scheme not support");
      }
      return true;
    }
    QLog.e("NavigateModule", 1, "execute activity is null or finish");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.NavigateModule
 * JD-Core Version:    0.7.0.1
 */