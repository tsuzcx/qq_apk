package com.dartnative.dart_native;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

public class CallbackInvocationHandler
  implements InvocationHandler
{
  private static final String TAG = "CallbackHandler";
  private static final HashMap<String, String> sBasicTypeConvert = new CallbackInvocationHandler.1();
  
  static native Object hookCallback(long paramLong, String paramString1, int paramInt, String[] paramArrayOfString, Object[] paramArrayOfObject, String paramString2);
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invoke method: ");
    ((StringBuilder)localObject).append(paramMethod.getName());
    Log.d("CallbackHandler", ((StringBuilder)localObject).toString());
    int j = 0;
    int i;
    if (paramArrayOfObject == null) {
      i = 0;
    } else {
      i = paramArrayOfObject.length;
    }
    String[] arrayOfString = new String[i];
    while (j < i)
    {
      if (paramArrayOfObject[j] != null) {
        localObject = paramArrayOfObject[j].getClass().getName();
      } else {
        localObject = null;
      }
      arrayOfString[j] = localObject;
      j += 1;
    }
    localObject = paramMethod.getName();
    paramMethod = paramMethod.getReturnType().getName();
    if (sBasicTypeConvert.get(paramMethod) != null) {
      for (;;)
      {
        paramMethod = (String)sBasicTypeConvert.get(paramMethod);
      }
    }
    return hookCallback(CallbackManager.getInstance().getRegisterDartAddr(paramObject), (String)localObject, i, arrayOfString, paramArrayOfObject, paramMethod);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dartnative.dart_native.CallbackInvocationHandler
 * JD-Core Version:    0.7.0.1
 */