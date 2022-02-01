package com.tencent.mobileqq.ark.module;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;

public class ArkModuleAPIAuthority
{
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ark_authority_info_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  static SharedPreferences a()
  {
    return BaseApplication.getContext().getSharedPreferences("sp_ark_authority", 0);
  }
  
  static String a(String paramString, ArrayList<String> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    int j = 0;
    int k = 0;
    int i;
    for (int m = 0; j < paramArrayList.size(); m = i)
    {
      String str = (String)paramArrayList.get(j);
      int n = k;
      i = m;
      if (!TextUtils.isEmpty(str))
      {
        if (m > 0) {
          localStringBuilder.append(";");
        }
        localStringBuilder.append(str);
        m += 1;
        n = k;
        i = m;
        if (str.equals(paramString))
        {
          n = 1;
          i = m;
        }
      }
      j += 1;
      k = n;
    }
    if (k == 0)
    {
      if (m > 0) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }
  
  public static ArrayList<String> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    SharedPreferences localSharedPreferences = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ark_authority_app_list_");
    localStringBuilder.append(paramString);
    paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(";");
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localSharedPreferences = paramString[i];
          if (!TextUtils.isEmpty(localSharedPreferences)) {
            localArrayList.add(localSharedPreferences);
          }
          i += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramString1 = a(paramString1, a(paramString2));
    SharedPreferences.Editor localEditor = a().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ark_authority_app_list_");
    localStringBuilder.append(paramString2);
    localEditor.putString(localStringBuilder.toString(), paramString1).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    SharedPreferences localSharedPreferences = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_ark_authority_info_");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    localSharedPreferences.edit().putInt(paramString1, paramInt).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, AuthDialogEventHandler paramAuthDialogEventHandler)
  {
    String str = ArkAppCacheMgr.getApplicationDesc(paramString2);
    if (TextUtils.isEmpty(str)) {
      str = paramString2;
    }
    SharedPreferences localSharedPreferences = a();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("key_ark_authority_show_dialog_");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(paramString1);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = localSharedPreferences.getBoolean((String)localObject, false);
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramAuthDialogEventHandler != null) {
        paramAuthDialogEventHandler.a();
      }
    }
    else
    {
      if ((!bool) && (ArkAppModuleBase.a))
      {
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkModuleAPIAuthority.1(str, paramString4, paramString2, paramAuthDialogEventHandler, paramString3, paramString1));
        localSharedPreferences.edit().putBoolean((String)localObject, true).apply();
        a(str, paramString1);
        return;
      }
      if (1 == a(str, paramString3, paramString1))
      {
        if (paramAuthDialogEventHandler != null) {
          paramAuthDialogEventHandler.a();
        }
      }
      else if (paramAuthDialogEventHandler != null) {
        paramAuthDialogEventHandler.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkModuleAPIAuthority
 * JD-Core Version:    0.7.0.1
 */