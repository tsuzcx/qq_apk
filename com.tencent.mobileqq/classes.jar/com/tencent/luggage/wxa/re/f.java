package com.tencent.luggage.wxa.re;

import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class f
{
  public static boolean a(Context paramContext)
  {
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramContext == null) {
      return false;
    }
    try
    {
      paramContext = paramContext.getClassLoader().loadClass("android.util.FtFeature");
      boolean bool = ((Boolean)paramContext.getMethod("isFeatureSupport", new Class[] { Integer.TYPE }).invoke(paramContext, new Object[] { Integer.valueOf(32) })).booleanValue();
      o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    catch (ClassNotFoundException paramContext) {}catch (NoSuchMethodException paramContext) {}catch (IllegalAccessException paramContext) {}catch (InvocationTargetException paramContext) {}finally
    {
      break label176;
    }
    o.b("MicroMsg.Vendor.Vivo", "hasCutOut, InvocationTargetException!!");
    o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Vivo", "hasCutOut, IllegalAccessException!!");
    o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Vivo", "hasCutOut, NoSuchMethodException!!");
    o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { localBoolean });
    return false;
    o.b("MicroMsg.Vendor.Vivo", "hasCutOut, ClassNotFoundException!!");
    o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { localBoolean });
    return false;
    label176:
    o.e("MicroMsg.Vendor.Vivo", "vivo hasCutOut: %s", new Object[] { localBoolean });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.re.f
 * JD-Core Version:    0.7.0.1
 */