package com.tencent.mobileqq.Doraemon.impl.internalModule;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.DoraemonAPIModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;
import org.json.JSONObject;

public class SdkApiModule
  extends DoraemonAPIModule
{
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull APICallback paramAPICallback)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 33: 
      DoraemonUtil.a(paramAPICallback, null);
      break;
    case 32: 
      DoraemonUtil.a(paramAPICallback, null);
      break;
    case 31: 
      DoraemonUtil.a(paramAPICallback, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.internalModule.SdkApiModule
 * JD-Core Version:    0.7.0.1
 */