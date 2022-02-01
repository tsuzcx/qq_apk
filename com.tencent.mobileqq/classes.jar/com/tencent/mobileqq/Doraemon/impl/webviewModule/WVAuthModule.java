package com.tencent.mobileqq.Doraemon.impl.webviewModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.APIParam;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import org.json.JSONObject;

public class WVAuthModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    if (paramInt != 3) {
      return false;
    }
    DoraemonUtil.a(paramAPICallback, APIParam.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.webviewModule.WVAuthModule
 * JD-Core Version:    0.7.0.1
 */