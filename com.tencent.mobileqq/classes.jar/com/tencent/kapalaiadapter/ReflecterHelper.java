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
    if (paramContext == null) {}
    label184:
    for (;;)
    {
      return;
      InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
      if (localInputMethodManager != null)
      {
        String[] arrayOfString = new String[3];
        arrayOfString[0] = "mCurRootView";
        arrayOfString[1] = "mServedView";
        arrayOfString[2] = "mNextServedView";
        int i = 0;
        for (;;)
        {
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label184;
            }
            Object localObject1 = arrayOfString[i];
            try
            {
              localObject1 = localInputMethodManager.getClass().getDeclaredField((String)localObject1);
              if (!((Field)localObject1).isAccessible()) {
                ((Field)localObject1).setAccessible(true);
              }
              Object localObject2 = ((Field)localObject1).get(localInputMethodManager);
              if ((localObject2 != null) && ((localObject2 instanceof View)))
              {
                localObject2 = (View)localObject2;
                if (((View)localObject2).getContext() == paramContext)
                {
                  ((Field)localObject1).set(localInputMethodManager, null);
                }
                else
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d(ReflecterHelper.class.getSimpleName(), 0, "fixInputMethodManagerLeak break, context is not suitable, get_context=" + ((View)localObject2).getContext() + " dest_context=" + paramContext);
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
      }
    }
  }
  
  public static void fixMesssageLeak(Dialog paramDialog)
  {
    if (paramDialog == null) {}
    for (;;)
    {
      return;
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
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localNoSuchFieldException.printStackTrace();
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localIllegalArgumentException.printStackTrace();
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localIllegalAccessException.printStackTrace();
        }
        i += 1;
      }
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
      localObject = arrayOfClass;
      if (i < j)
      {
        if (paramArrayOfObject[i] != null)
        {
          arrayOfClass[i] = paramArrayOfObject[i].getClass();
          label45:
          if (arrayOfClass[i] != Integer.class) {
            break label77;
          }
          arrayOfClass[i] = Integer.TYPE;
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfClass[i] = String.class;
          break label45;
          label77:
          if (arrayOfClass[i] == Boolean.class) {
            arrayOfClass[i] = Boolean.TYPE;
          }
        }
      }
    }
    return localObject;
  }
  
  /* Error */
  private static final Field getField(String paramString)
  {
    // Byte code:
    //   0: getstatic 149	com/tencent/kapalaiadapter/ReflecterHelper:mCurrentClass	Ljava/lang/Class;
    //   3: aload_0
    //   4: invokevirtual 44	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   7: astore_0
    //   8: aload_0
    //   9: iconst_1
    //   10: invokevirtual 54	java/lang/reflect/Field:setAccessible	(Z)V
    //   13: aload_0
    //   14: areturn
    //   15: astore_1
    //   16: aconst_null
    //   17: astore_0
    //   18: aload_1
    //   19: invokevirtual 150	java/lang/SecurityException:printStackTrace	()V
    //   22: aload_0
    //   23: areturn
    //   24: astore_1
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_1
    //   28: invokevirtual 128	java/lang/NoSuchFieldException:printStackTrace	()V
    //   31: aload_0
    //   32: areturn
    //   33: astore_1
    //   34: goto -7 -> 27
    //   37: astore_1
    //   38: goto -20 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	paramString	String
    //   15	4	1	localSecurityException1	java.lang.SecurityException
    //   24	4	1	localNoSuchFieldException1	NoSuchFieldException
    //   33	1	1	localNoSuchFieldException2	NoSuchFieldException
    //   37	1	1	localSecurityException2	java.lang.SecurityException
    // Exception table:
    //   from	to	target	type
    //   0	8	15	java/lang/SecurityException
    //   0	8	24	java/lang/NoSuchFieldException
    //   8	13	33	java/lang/NoSuchFieldException
    //   8	13	37	java/lang/SecurityException
  }
  
  public static final int getIntValue(Object paramObject, String paramString, int paramInt)
  {
    setClass(paramObject.getClass().getName());
    paramString = getField(paramString);
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      i = paramString.getInt(paramObject);
      return i;
    }
    catch (IllegalArgumentException paramObject)
    {
      paramObject.printStackTrace();
      return paramInt;
    }
    catch (IllegalAccessException paramObject)
    {
      paramObject.printStackTrace();
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
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      i = paramString.getInt(null);
      return i;
    }
    catch (IllegalArgumentException paramString)
    {
      paramString.printStackTrace();
      return paramInt;
    }
    catch (IllegalAccessException paramString)
    {
      paramString.printStackTrace();
    }
    return paramInt;
  }
  
  public static Object getStaticProperty(String paramString1, String paramString2)
  {
    Object localObject = null;
    setClass(paramString1);
    paramString2 = getField(paramString2);
    paramString1 = localObject;
    if (paramString2 != null) {}
    try
    {
      paramString1 = paramString2.get(null);
      return paramString1;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
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
    Object localObject = null;
    try
    {
      paramString = Class.forName(paramString);
      mCurrentClass = paramString;
      if (mCurrentClass != null) {
        return true;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = localObject;
      }
    }
    return false;
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
    if (paramString1 != null) {}
    try
    {
      paramString1.setAccessible(true);
      paramString1.set(null, paramObject);
      return;
    }
    catch (IllegalArgumentException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.kapalaiadapter.ReflecterHelper
 * JD-Core Version:    0.7.0.1
 */