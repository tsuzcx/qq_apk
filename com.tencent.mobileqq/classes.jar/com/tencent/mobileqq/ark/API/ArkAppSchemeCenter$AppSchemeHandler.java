package com.tencent.mobileqq.ark.API;

import aajp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.service.gamecenter.AppLaucherHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppSchemeCenter$AppSchemeHandler
  implements ArkAppSchemeCenter.IRegScheme
{
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppLaucherHelper localAppLaucherHelper = new AppLaucherHelper();
    j = 268435456;
    try
    {
      k = Integer.parseInt(paramString4);
      if ((k & 0x4000000) != 67108864) {
        break label99;
      }
      j = 335544320;
    }
    catch (Exception paramString4)
    {
      for (;;)
      {
        int k;
        int i;
        continue;
        j = 268435456;
      }
    }
    i = j;
    if ((k & 0x20000000) == 536870912) {
      i = j | 0x20000000;
    }
    j = i;
    if ((k & 0x400000) == 4194304) {
      j = i | 0x400000;
    }
    localAppLaucherHelper.a(a(), paramContext, paramString1, paramString2, paramString3, j);
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getPackageInfo(paramString.trim(), 0);
      if (paramContext != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean a(String paramString1, String paramString2, String paramString3)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity == null) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      Object localObject2 = ArkAppSchemeCenter.a(new JSONObject(paramString2));
      Object localObject3 = ((Map)localObject2).get("url");
      paramString2 = (String)localObject1;
      if (localObject3 != null)
      {
        paramString2 = (String)localObject1;
        if ((localObject3 instanceof String)) {
          paramString2 = (String)localObject3;
        }
      }
      try
      {
        localObject1 = ((Map)localObject2).get("data");
        if ((localObject1 == null) || (!(localObject1 instanceof Map))) {
          break label350;
        }
        localObject2 = (Map)localObject1;
        localObject1 = new StringBuilder();
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
          localObject3 = ((Map.Entry)localObject4).getKey();
          localObject4 = ((Map.Entry)localObject4).getValue();
          if ((localObject3 != null) && ((localObject3 instanceof String)) && (localObject4 != null))
          {
            ((StringBuilder)localObject1).append("&");
            ((StringBuilder)localObject1).append(localObject3);
            ((StringBuilder)localObject1).append("=");
            ((StringBuilder)localObject1).append(localObject4.toString());
          }
        }
        if (!QLog.isColorLevel()) {
          break label230;
        }
      }
      catch (JSONException localJSONException) {}
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        label230:
        paramString2 = null;
        continue;
        String str = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$";
      }
    }
    QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler.jsonParseError");
    str = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$";
    if (!a(localBaseActivity, paramString3)) {
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new Intent(localBaseActivity, QQBrowserActivity.class);
        paramString1.putExtra("url", paramString2);
        paramString1.putExtra("fromArkAppDownload", true);
        localBaseActivity.startActivity(paramString1);
      }
    }
    for (;;)
    {
      return true;
      str = "platform=qq_m&current_uin=$OPID$&launchfrom=Ark&openid=$OPID$&atoken=$AT$&ptoken=$PT$" + str;
      break;
      if (QLog.isColorLevel())
      {
        QLog.i("ArkApp", 1, "ArkAppSchemeCenter.AppSchemeHandler, download url is empty");
        continue;
        a(localBaseActivity, paramString1, str, paramString3, "0");
      }
    }
  }
  
  protected QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {}
    do
    {
      return false;
      paramString3 = BaseActivity.sTopActivity;
    } while ((paramString3 == null) || (TextUtils.isEmpty(paramString1)));
    String str = BaseApplication.getContext().getSharedPreferences("arkappid2pkname_entry", 4).getString(paramString1, null);
    if ((str != null) && (str.length() > 0) && (a(paramString3, str)))
    {
      a(paramString1, paramString2, str);
      return true;
    }
    ((ArkAppCenter)a().getManager(120)).a(paramString1, this, new aajp(this, paramString2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppSchemeCenter.AppSchemeHandler
 * JD-Core Version:    0.7.0.1
 */