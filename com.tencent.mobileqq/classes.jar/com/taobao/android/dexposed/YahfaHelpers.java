package com.taobao.android.dexposed;

import com.tencent.qa.apphook.GalileoHookNative;
import com.tencent.qa.apphook.util.BasicType;
import com.tencent.yahfa.apphook.YahfaLog;
import de.robv.android.xposed.XC_MethodHook.MethodHookParam;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class YahfaHelpers
{
  public static void ensureResolved(Member paramMember)
  {
    if (!Modifier.isStatic(paramMember.getModifiers())) {
      YahfaLog.d("not static, ignore.");
    }
    do
    {
      return;
      YahfaLog.d(paramMember.getName() + " is static");
    } while (!(paramMember instanceof Method));
    try
    {
      ((Method)paramMember).invoke(null, new Object[0]);
      YahfaLog.d("ensure resolved");
      return;
    }
    catch (Exception paramMember) {}
  }
  
  public static BasicType getBasicTypeIfIs(Class<?> paramClass)
  {
    if (paramClass.equals(Boolean.TYPE)) {
      return BasicType.BOOLEAN;
    }
    if (paramClass.equals(Byte.TYPE)) {
      return BasicType.BYTE;
    }
    if (paramClass.equals(Character.TYPE)) {
      return BasicType.CHAR;
    }
    if (paramClass.equals(Short.TYPE)) {
      return BasicType.SHORT;
    }
    if (paramClass.equals(Integer.TYPE)) {
      return BasicType.INT;
    }
    if (paramClass.equals(Long.TYPE)) {
      return BasicType.LONG;
    }
    if (paramClass.equals(Float.TYPE)) {
      return BasicType.FLOAT;
    }
    if (paramClass.equals(Double.TYPE)) {
      return BasicType.DOUBLE;
    }
    return null;
  }
  
  public static Object invoke(Member paramMember, XC_MethodHook paramXC_MethodHook, Object paramObject, Object[] paramArrayOfObject)
  {
    XC_MethodHook.MethodHookParam localMethodHookParam;
    if ((paramMember instanceof Method))
    {
      ((Method)paramMember).setAccessible(true);
      localMethodHookParam = new XC_MethodHook.MethodHookParam();
      localMethodHookParam.method = paramMember;
      localMethodHookParam.thisObject = paramObject;
      localMethodHookParam.args = paramArrayOfObject;
      if (paramXC_MethodHook == null) {
        break label71;
      }
    }
    for (;;)
    {
      if (localMethodHookParam.getThrowable() == null) {
        break label80;
      }
      throw localMethodHookParam.getThrowable();
      ((Constructor)paramMember).setAccessible(true);
      break;
      label71:
      localMethodHookParam.setResult(null);
    }
    label80:
    localMethodHookParam.setResult(((Method)paramMember).invoke(paramObject, paramArrayOfObject));
    if ((paramXC_MethodHook == null) || (localMethodHookParam.getThrowable() != null)) {
      throw localMethodHookParam.getThrowable();
    }
    return localMethodHookParam.getResult();
  }
  
  public static void makePrivate(Member paramMember)
  {
    boolean bool = Modifier.isPublic(paramMember.getModifiers());
    YahfaLog.d("Method " + paramMember.getName() + " isPublicMethod is " + bool);
    if ((bool) && ((paramMember instanceof Method))) {
      GalileoHookNative.makePrivate((Method)paramMember);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.taobao.android.dexposed.YahfaHelpers
 * JD-Core Version:    0.7.0.1
 */