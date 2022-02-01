package com.dartnative.dart_native;

import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class CallbackManager
{
  private static final String TAG = "CallbackManager";
  private static CallbackManager sCallbackManager;
  private CallbackInvocationHandler mCallbackHandler = new CallbackInvocationHandler();
  private HashMap<Integer, Long> mObjectMap = new HashMap();
  
  static CallbackManager getInstance()
  {
    if (sCallbackManager == null) {
      try
      {
        if (sCallbackManager == null) {
          sCallbackManager = new CallbackManager();
        }
      }
      finally {}
    }
    return sCallbackManager;
  }
  
  @Nullable
  public static Object registerCallback(long paramLong, String paramString)
  {
    try
    {
      paramString = Class.forName(paramString.replace("/", "."));
      ClassLoader localClassLoader = paramString.getClassLoader();
      CallbackInvocationHandler localCallbackInvocationHandler = getInstance().mCallbackHandler;
      paramString = Proxy.newProxyInstance(localClassLoader, new Class[] { paramString }, localCallbackInvocationHandler);
      getInstance().mObjectMap.put(Integer.valueOf(System.identityHashCode(paramString)), Long.valueOf(paramLong));
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("CallbackManager", paramString.getMessage());
    }
    return null;
  }
  
  long getRegisterDartAddr(Object paramObject)
  {
    if (paramObject == null) {
      return 0L;
    }
    paramObject = (Long)getInstance().mObjectMap.get(Integer.valueOf(System.identityHashCode(paramObject)));
    if (paramObject == null) {
      return 0L;
    }
    return paramObject.longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dartnative.dart_native.CallbackManager
 * JD-Core Version:    0.7.0.1
 */