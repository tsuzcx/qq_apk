package com.huawei.hms.android;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HwBuildEx
{
  public static int getSystemPropertiesInt(String paramString, int paramInt)
  {
    try
    {
      Class localClass = Class.forName("android.os.SystemProperties");
      int i = ((Integer)localClass.getDeclaredMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { paramString, Integer.valueOf(paramInt) })).intValue();
      return i;
    }
    catch (ClassNotFoundException paramString)
    {
      Log.e("HwBuildEx", "An exception occurred while reading: EMUI_SDK_INT");
      return paramInt;
    }
    catch (ClassCastException paramString)
    {
      break label56;
    }
    catch (IllegalAccessException paramString)
    {
      break label56;
    }
    catch (IllegalArgumentException paramString)
    {
      break label56;
    }
    catch (NoSuchMethodException paramString)
    {
      break label56;
    }
    catch (InvocationTargetException paramString)
    {
      label56:
      break label56;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.android.HwBuildEx
 * JD-Core Version:    0.7.0.1
 */