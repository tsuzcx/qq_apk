package com.dartnative.dart_native;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CallbackInvocationHandler
  implements InvocationHandler
{
  private static final String TAG = "CallbackHandler";
  private static HashMap<Class<?>, String> sTypeConvert = new CallbackInvocationHandler.1();
  
  static native Object hookCallback(long paramLong, String paramString1, int paramInt, String[] paramArrayOfString, Object[] paramArrayOfObject, String paramString2);
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invoke method: ");
    ((StringBuilder)localObject).append(paramMethod.getName());
    Log.d("CallbackHandler", ((StringBuilder)localObject).toString());
    localObject = paramMethod.getParameterTypes();
    String[] arrayOfString = new String[localObject.length];
    int i = 0;
    while (i < localObject.length)
    {
      arrayOfString[i] = ((String)sTypeConvert.get(localObject[i]));
      i += 1;
    }
    String str = paramMethod.getName();
    paramMethod = (String)sTypeConvert.get(paramMethod.getReturnType());
    return hookCallback(CallbackManager.getInstance().getRegisterDartAddr(paramObject), str, localObject.length, arrayOfString, paramArrayOfObject, paramMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dartnative.dart_native.CallbackInvocationHandler
 * JD-Core Version:    0.7.0.1
 */