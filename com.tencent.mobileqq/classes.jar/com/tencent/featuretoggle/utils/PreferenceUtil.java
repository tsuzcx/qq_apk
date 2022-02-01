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
  private static volatile PreferenceUtil a;
  private MMKVPersitence b = null;
  private MMKVPersitence c = null;
  
  public PreferenceUtil()
  {
    a(ToggleSetting.j());
    if (this.b == null)
    {
      this.b = new MMKVPersitence();
      this.b.a(ToggleSetting.j(), SpManager.a);
    }
    if (this.c == null)
    {
      this.c = new MMKVPersitence();
      this.c.a(ToggleSetting.j(), SpManager.b);
    }
  }
  
  public static PreferenceUtil a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PreferenceUtil();
        }
      }
      finally {}
    }
    return a;
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
  
  private boolean b(String paramString, Context paramContext)
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
      if (b(paramString1, paramContext)) {
        return paramLong;
      }
      try
      {
        long l = a(paramString1, paramContext).b(paramString2, paramLong);
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
        return this.b;
      }
      return this.c;
    }
    return null;
  }
  
  public String a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)))
    {
      if (b(paramString1, paramContext)) {
        return paramString3;
      }
      try
      {
        paramContext = a(paramString1, paramContext).b(paramString2, paramString3);
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
      if (b(paramString1, paramContext)) {
        return false;
      }
      try
      {
        boolean bool = a(paramString1, paramContext).b(paramString2);
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
  
  public String[] a(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (b(paramString, paramContext)) {
        return null;
      }
      try
      {
        paramContext = a(paramString, paramContext).c();
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
  
  public boolean b(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)) && (!b(paramString1, paramContext)))
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
  
  public boolean b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((paramContext != null) && (!Utils.a(paramString2)) && (!b(paramString1, paramContext)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.PreferenceUtil
 * JD-Core Version:    0.7.0.1
 */