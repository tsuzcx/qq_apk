package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

public class QWalletSetting
{
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    int i = paramInt;
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt(paramString2 + paramString1, paramInt);
    }
    return i;
  }
  
  public static long a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    long l = paramLong;
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong(paramString2 + paramString1, paramLong);
    }
    return l;
  }
  
  private static SharedPreferences a(String paramString)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences(paramString, 4);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    String str = null;
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString("goldmsg_seed_user_url" + paramString, null);
    }
    return str;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    String str = paramString3;
    if (localSharedPreferences != null) {
      str = localSharedPreferences.getString(paramString2 + paramString1, paramString3);
    }
    return str;
  }
  
  public static ArrayList a(Context paramContext, String paramString1, String paramString2, Class paramClass)
  {
    Object localObject2 = null;
    localObject1 = null;
    int i = 0;
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    paramContext = localObject2;
    if (localSharedPreferences != null)
    {
      paramString1 = localSharedPreferences.getString(paramString2 + paramString1, null);
      paramContext = localObject2;
      if (TextUtils.isEmpty(paramString1)) {}
    }
    try
    {
      paramString2 = new JSONArray(paramString1);
      if (paramString2 == null) {
        break label173;
      }
      int j = paramString2.length();
      if (j <= 0) {
        break label173;
      }
      paramContext = new ArrayList();
      for (;;)
      {
        paramString1 = paramContext;
        if (i >= j) {
          break label175;
        }
        try
        {
          paramString1 = paramString2.getString(i);
          boolean bool = TextUtils.isEmpty(paramString1);
          if (!bool) {}
          try
          {
            paramContext.add(paramClass.getConstructor(new Class[] { String.class }).newInstance(new Object[] { paramString1 }));
            i += 1;
          }
          catch (Exception paramString1)
          {
            for (;;)
            {
              paramString1.printStackTrace();
            }
          }
          paramString1.printStackTrace();
        }
        catch (JSONException paramString1) {}
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        paramContext = localObject1;
      }
    }
    return paramContext;
    label173:
    paramString1 = null;
    label175:
    return paramString1;
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletSetting", 2, "isShow" + paramInt);
      }
      localSharedPreferences.edit().putInt("GoldMsgEntry" + paramString, paramInt).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString("goldmsg_seed_user_url" + paramString1, paramString2).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putInt(paramString2 + paramString1, paramInt).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(paramString2 + paramString1, paramLong).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putString(paramString2 + paramString1, paramString3).commit();
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean(paramString2 + paramString1, paramBoolean).commit();
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("goldmsg_seed_url_need_show" + paramString, paramBoolean).commit();
    }
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    int i;
    if (localSharedPreferences != null)
    {
      i = localSharedPreferences.getInt("GoldMsgEntry" + paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("QWalletSetting", 2, "get isShow" + i);
      }
    }
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
        } while ((i & 0x1) != 0);
        return false;
      } while ((i & 0x2) != 0);
      return false;
    } while ((i & 0x4) != 0);
    return false;
  }
  
  public static boolean a(String paramString)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null)
    {
      long l1 = localSharedPreferences.getLong("F2FRedpack_EntryColorBeginTime" + paramString, 0L);
      long l2 = localSharedPreferences.getLong("F2FRedpack_EntryColorEndTime" + paramString, 0L);
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      if ((l3 > l1) && (l3 < l2)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    boolean bool = paramBoolean;
    if (localSharedPreferences != null) {
      bool = localSharedPreferences.getBoolean(paramString2 + paramString1, paramBoolean);
    }
    return bool;
  }
  
  public static boolean b(String paramString)
  {
    SharedPreferences localSharedPreferences = a("qwallet_setting");
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("goldmsg_seed_url_need_show" + paramString, false);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.QWalletSetting
 * JD-Core Version:    0.7.0.1
 */