package com.tencent.kapalaiadapter;

import android.app.Dialog;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.TMG.utils.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class ReflecterHelper
{
  public static Class<?> mCurrentClass;
  
  public static void fixInputMethodManagerLeak(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mCurRootView";
    arrayOfString[1] = "mServedView";
    arrayOfString[2] = "mNextServedView";
    int i = 0;
    while (i < arrayOfString.length)
    {
      Object localObject1 = arrayOfString[i];
      try
      {
        Object localObject2 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
        if (!((Field)localObject2).isAccessible()) {
          ((Field)localObject2).setAccessible(true);
        }
        localObject1 = ((Field)localObject2).get(localInputMethodManager);
        if ((localObject1 != null) && ((localObject1 instanceof View)))
        {
          localObject1 = (View)localObject1;
          if (((View)localObject1).getContext() == paramContext)
          {
            ((Field)localObject2).set(localInputMethodManager, null);
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            localObject2 = ReflecterHelper.class.getSimpleName();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("fixInputMethodManagerLeak break, context is not suitable, get_context=");
            localStringBuilder.append(((View)localObject1).getContext());
            localStringBuilder.append(" dest_context=");
            localStringBuilder.append(paramContext);
            QLog.d((String)localObject2, 0, localStringBuilder.toString());
            return;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i += 1;
      }
    }
  }
  
  public static void fixMesssageLeak(Dialog paramDialog)
  {
    if (paramDialog == null) {
      return;
    }
    String[] arrayOfString = new String[3];
    arrayOfString[0] = "mDismissMessage";
    arrayOfString[1] = "mCancelMessage";
    arrayOfString[2] = "mShowMessage";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfString[i];
      try
      {
        localObject = Dialog.class.getDeclaredField((String)localObject);
        if (localObject != null)
        {
          if (!((Field)localObject).isAccessible()) {
            ((Field)localObject).setAccessible(true);
          }
          localObject = ((Field)localObject).get(paramDialog);
          if ((localObject instanceof Message))
          {
            localObject = (Message)localObject;
            if (((Message)localObject).obj != null)
            {
              ((Message)localObject).obj = null;
              ((Message)localObject).what = 0;
            }
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localNoSuchFieldException.printStackTrace();
      }
      i += 1;
    }
  }
  
  private static Class<?>[] getArgsClasses(Object[] paramArrayOfObject)
  {
    Object localObject = (Class[])null;
    if (paramArrayOfObject != null)
    {
      Class[] arrayOfClass = new Class[paramArrayOfObject.length];
      int i = 0;
      int j = paramArrayOfObject.length;
      for (;;)
      {
        localObject = arrayOfClass;
        if (i >= j) {
          break;
        }
        if (paramArrayOfObject[i] != null) {
          arrayOfClass[i] = paramArrayOfObject[i].getClass();
        } else {
          arrayOfClass[i] = String.class;
        }
        if (arrayOfClass[i] == Integer.class) {
          arrayOfClass[i] = Integer.TYPE;
        } else if (arrayOfClass[i] == Boolean.class) {
          arrayOfClass[i] = Boolean.TYPE;
        }
        i += 1;
      }
    }
    return localObject;
  }
  
  private static final Field getField(String paramString)
  {
    String str2 = null;
    String str1 = null;
    try
    {
      paramString = mCurrentClass.getDeclaredField(paramString);
      str1 = paramString;
      str2 = paramString;
      paramString.setAccessible(true);
      return paramString;
    }
    catch (NoSuchFieldException paramString)
    {
      paramString.printStackTrace();
      return str1;
    }
    catch (SecurityException paramString)
    {
      paramString.printStackTrace();
    }
    return str2;
  }
  
  public static final int getIntValue(Object paramObject, String paramString, int paramInt)
  {
    setClass(paramObject.getClass().getName());
    paramString = getField(paramString);
    if (paramString != null) {
      try
      {
        int i = paramString.getInt(paramObject);
        return i;
      }
      catch (IllegalAccessException paramObject)
      {
        paramObject.printStackTrace();
        return paramInt;
      }
      catch (IllegalArgumentException paramObject)
      {
        paramObject.printStackTrace();
      }
    }
    return paramInt;
  }
  
  public static Object getProperty(Object paramObject, String paramString)
  {
    return paramObject.getClass().getField(paramString).get(paramObject);
  }
  
  public static final int getStaticIntValue(String paramString, int paramInt)
  {
    paramString = getField(paramString);
    if (paramString != null) {
      try
      {
        int i = paramString.getInt(null);
        return i;
      }
      catch (IllegalAccessException paramString)
      {
        paramString.printStackTrace();
        return paramInt;
      }
      catch (IllegalArgumentException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return paramInt;
  }
  
  public static Object getStaticProperty(String paramString1, String paramString2)
  {
    setClass(paramString1);
    paramString1 = getField(paramString2);
    if (paramString1 != null) {
      try
      {
        paramString1 = paramString1.get(null);
        return paramString1;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        return null;
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString)
  {
    return invokeMethod(paramObject, paramString, null);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    paramString = paramObject.getClass().getMethod(paramString, paramArrayOfClass);
    paramString.setAccessible(true);
    return paramString.invoke(paramObject, paramArrayOfObject);
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject)
  {
    return invokeMethod(paramObject, paramString, getArgsClasses(paramArrayOfObject), paramArrayOfObject);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2)
  {
    return invokeStaticMethod(paramString1, paramString2, (Object[])null);
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject)
  {
    return invokeStaticMethod(paramString1, paramString2, paramArrayOfObject, getArgsClasses(paramArrayOfObject));
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    paramString1 = Class.forName(paramString1);
    return paramString1.getDeclaredMethod(paramString2, paramArrayOfClass).invoke(paramString1, paramArrayOfObject);
  }
  
  public static Object newInstance(String paramString)
  {
    return newInstance(paramString, (Object[])null);
  }
  
  public static Object newInstance(String paramString, Object[] paramArrayOfObject)
  {
    return Class.forName(paramString).getConstructor(getArgsClasses(paramArrayOfObject)).newInstance(paramArrayOfObject);
  }
  
  public static Object newInstance(String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    return Class.forName(paramString).getConstructor(paramArrayOfClass).newInstance(paramArrayOfObject);
  }
  
  public static final boolean setClass(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
    }
    catch (ClassNotFoundException paramString)
    {
      paramString.printStackTrace();
      paramString = null;
    }
    mCurrentClass = paramString;
    return mCurrentClass != null;
  }
  
  public static void setProperty(Object paramObject1, String paramString, Object paramObject2)
  {
    paramString = paramObject1.getClass().getField(paramString);
    paramString.setAccessible(true);
    paramString.set(paramObject1, paramObject2);
  }
  
  public static void setStaticProperty(String paramString1, String paramString2, Object paramObject)
  {
    setClass(paramString1);
    paramString1 = getField(paramString2);
    if (paramString1 != null) {
      try
      {
        paramString1.setAccessible(true);
        paramString1.set(null, paramObject);
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IllegalArgumentException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kapalaiadapter.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */