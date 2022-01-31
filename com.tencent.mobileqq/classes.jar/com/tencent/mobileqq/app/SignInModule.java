package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInModule
  extends QIPCModule
{
  private static SignInModule a;
  
  private SignInModule()
  {
    super("SignInModule");
  }
  
  public static SignInModule a()
  {
    if (a == null) {
      a = new SignInModule();
    }
    return a;
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle.getInt("type", 1);
    int i = paramBundle.getInt("result", 2);
    paramInt = paramBundle.getInt("day", 1);
    SharedPreferences localSharedPreferences;
    Object localObject;
    if (i == 0)
    {
      paramBundle = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (paramBundle != null)
      {
        localSharedPreferences = paramBundle.getPreferences();
        localObject = localSharedPreferences.getString(paramBundle.c() + "sign_in_info", null);
        paramString = (CardHandler)paramBundle.a(2);
      }
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      i = ((JSONObject)localObject).optInt("type");
      ((JSONObject)localObject).put("type", 4);
      ((JSONObject)localObject).put("day", paramInt);
      ((JSONObject)localObject).put("redpoint", 0);
      ((JSONObject)localObject).put("iconUrl", null);
      localSharedPreferences.edit().putString(paramBundle.c() + "sign_in_info", ((JSONObject)localObject).toString()).commit();
      if (i != 4)
      {
        if (QLog.isColorLevel()) {
          QLog.i("DailySignIn", 2, "get oidb0x922 by web");
        }
        paramString.c(0);
      }
    }
    catch (JSONException paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
      }
    }
    paramString.a(84, true, null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignInModule
 * JD-Core Version:    0.7.0.1
 */