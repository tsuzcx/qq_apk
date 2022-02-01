package com.tencent.featuretoggle.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleSetting;
import com.tencent.featuretoggle.mmkv.MMKVPersitence;
import com.tencent.mmkv.MMKV;
import java.io.File;

public class PreferenceUtil
{
  private static volatile PreferenceUtil jdField_a_of_type_ComTencentFeaturetoggleUtilsPreferenceUtil;
  private MMKVPersitence jdField_a_of_type_ComTencentFeaturetoggleMmkvMMKVPersitence = null;
  private MMKVPersitence b = null;
  
  public PreferenceUtil()
  {
    a(ToggleSetting.a());
    if (this.jdField_a_of_type_ComTencentFeaturetoggleMmkvMMKVPersitence == null)
    {
      this.jdField_a_of_type_ComTencentFeaturetoggleMmkvMMKVPersitence = new MMKVPersitence();
      this.jdField_a_of_type_ComTencentFeaturetoggleMmkvMMKVPersitence.a(ToggleSetting.a(), SpManager.a);
    }
    if (this.b == null)
    {
      this.b = new MMKVPersitence();
      this.b.a(ToggleSetting.a(), SpManager.b);
    }
  }
  
  public static PreferenceUtil a()
  {
    if (jdField_a_of_type_ComTencentFeaturetoggleUtilsPreferenceUtil == null) {
      try
      {
        if (jdField_a_of_type_ComTencentFeaturetoggleUtilsPreferenceUtil == null) {
          jdField_a_of_type_ComTencentFeaturetoggleUtilsPreferenceUtil = new PreferenceUtil();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentFeaturetoggleUtilsPreferenceUtil;
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject).append("/mmkv");
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      MMKV.a((String)localObject, new PreferenceUtil.1(this, paramContext));
      return;
    }
    catch (Throwable paramContext)
    {
      if (!LogUtils.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
  }
  
  private boolean a(String paramString, Context paramContext)
  {
    paramString = a(paramString, paramContext);
    if (paramString == null) {
      return true;
    }
    return paramString.a() == null;
  }
  
  public long a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)))
    {
      if (a(paramString1, paramContext)) {
        return paramLong;
      }
      try
      {
        long l = a(paramString1, paramContext).a(paramString2, paramLong);
        return l;
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    return paramLong;
  }
  
  public MMKVPersitence a(String paramString, Context paramContext)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramContext != null))
    {
      if (SpManager.a.equals(paramString)) {
        return this.jdField_a_of_type_ComTencentFeaturetoggleMmkvMMKVPersitence;
      }
      return this.b;
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)))
    {
      if (a(paramString1, paramContext)) {
        return paramString3;
      }
      try
      {
        paramContext = a(paramString1, paramContext).a(paramString2, paramString3);
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    return paramString3;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)))
    {
      if (a(paramString1, paramContext)) {
        return false;
      }
      try
      {
        boolean bool = a(paramString1, paramContext).a(paramString2);
        return bool;
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)) && (!a(paramString1, paramContext)))
    {
      try
      {
        a(paramString1, paramContext).a(paramString2, paramLong);
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
      return true;
    }
    return false;
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)) && (!a(paramString1, paramContext)))
    {
      try
      {
        a(paramString1, paramContext).a(paramString2, paramString3);
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
      return true;
    }
    return false;
  }
  
  public String[] a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (a(paramString, paramContext)) {
        return null;
      }
      try
      {
        paramContext = a(paramString, paramContext).a();
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        if (!LogUtils.a(paramContext)) {
          paramContext.printStackTrace();
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.PreferenceUtil
 * JD-Core Version:    0.7.0.1
 */