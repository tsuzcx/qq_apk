package com.tencent.assistant.qa.hook;

import com.taobao.android.dexposed.DexposedBridge;

public final class GalileoHookUtil
{
  public static void replaceMethod(Class<?> paramClass, String paramString, Object[] paramArrayOfObject, Object paramObject)
  {
    paramObject = new GalileoHookUtil.1(paramObject);
    Object[] arrayOfObject = new Object[paramArrayOfObject.length + 1];
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject, 0, paramArrayOfObject.length);
    arrayOfObject[paramArrayOfObject.length] = paramObject;
    DexposedBridge.findAndHookMethod(paramClass, paramString, arrayOfObject);
  }
  
  public static void replaceMethodParams(Class<?> paramClass, String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2)
  {
    paramArrayOfObject2 = new GalileoHookUtil.2(paramString, paramArrayOfObject2);
    Object[] arrayOfObject = new Object[paramArrayOfObject1.length + 1];
    System.arraycopy(paramArrayOfObject1, 0, arrayOfObject, 0, paramArrayOfObject1.length);
    arrayOfObject[paramArrayOfObject1.length] = paramArrayOfObject2;
    DexposedBridge.findAndHookMethod(paramClass, paramString, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.assistant.qa.hook.GalileoHookUtil
 * JD-Core Version:    0.7.0.1
 */