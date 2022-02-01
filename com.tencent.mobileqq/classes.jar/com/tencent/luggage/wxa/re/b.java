package com.tencent.luggage.wxa.re;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/sdk/vendor/HuaweiKt;", "", "()V", "TAG", "", "hasHuaweiMagicWindowFeature", "", "Ljava/lang/Boolean;", "isHWTablet", "wechat-commons-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
{
  public static final b a = new b();
  private static Boolean b;
  
  @JvmStatic
  public static final boolean a()
  {
    Object localObject = b;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((Boolean)localObject).booleanValue();
    }
    boolean bool1 = false;
    try
    {
      localObject = Class.forName("com.huawei.android.os.SystemPropertiesEx");
      localObject = ((Class)localObject).getMethod("getBoolean", new Class[] { String.class, Boolean.TYPE }).invoke(((Class)localObject).newInstance(), new Object[] { "ro.config.hw_magic_window_enable", Boolean.valueOf(false) });
      if (localObject != null)
      {
        boolean bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hasHuaweiMagicWindowFeature: ");
      localStringBuilder.append(localThrowable.getMessage());
      o.c("MicroMsg.HuaweiKt", localStringBuilder.toString());
      b = Boolean.valueOf(bool1);
      Boolean localBoolean = b;
      if (localBoolean == null) {
        Intrinsics.throwNpe();
      }
      return localBoolean.booleanValue();
    }
  }
  
  @JvmStatic
  public static final boolean b()
  {
    boolean bool1 = false;
    try
    {
      Object localObject = Class.forName("com.huawei.android.os.SystemPropertiesEx");
      if (!Intrinsics.areEqual("tablet", ((Class)localObject).getMethod("get", new Class[] { String.class, String.class }).invoke(((Class)localObject).newInstance(), new Object[] { "ro.build.characteristics", "" })))
      {
        localObject = r.a();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getContext()");
        boolean bool2 = ((Context)localObject).getPackageManager().hasSystemFeature("com.huawei.software.features.pad");
        if (!bool2) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.b
 * JD-Core Version:    0.7.0.1
 */