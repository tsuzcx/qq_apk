import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;

public class bhcy
{
  public static EIPCResult a(QIPCModule paramQIPCModule, String paramString, Bundle paramBundle, int paramInt)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("RemoteProxy", 2, "action:" + paramString + "  callbackId:" + paramInt);
    }
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split("\\$");
    Object localObject = paramString[0];
    paramString = paramString[1];
    for (;;)
    {
      int j;
      try
      {
        Class localClass = Class.forName((String)localObject);
        localObject = localClass.newInstance();
        ArrayList localArrayList = paramBundle.getStringArrayList("__parameterTypes__");
        j = localArrayList.size();
        Class[] arrayOfClass = new Class[j];
        Object[] arrayOfObject = new Object[j];
        if (i < localArrayList.size())
        {
          String str1 = "__arg+" + i + "__";
          String str2 = (String)localArrayList.get(i);
          arrayOfClass[i] = a(str2);
          arrayOfObject[i] = b(paramBundle, str2, str1);
          j = i;
          if (str2.equals(EIPCModule.class.getName()))
          {
            arrayOfObject[i] = paramQIPCModule;
            j = i + 1;
            arrayOfObject[j] = Integer.valueOf(paramInt);
            arrayOfClass[j] = a((String)localArrayList.get(j));
          }
        }
        else
        {
          paramQIPCModule = localClass.getMethod(paramString, arrayOfClass);
          paramString = paramQIPCModule.invoke(localObject, arrayOfObject);
          localObject = new EIPCResult();
          ((EIPCResult)localObject).data = paramBundle;
          b(paramBundle, paramQIPCModule.getReturnType().getName(), "result", paramString);
          b(paramBundle, String.class.getName(), "resultType", paramQIPCModule.getReturnType().getName());
          paramBundle.putString("resultType", paramQIPCModule.getReturnType().getName());
          return localObject;
        }
      }
      catch (Exception paramQIPCModule)
      {
        paramQIPCModule.printStackTrace();
        QLog.d("RemoteProxy", 1, "onCall exception", paramQIPCModule);
        return null;
      }
      i = j + 1;
    }
  }
  
  private static Class a(String paramString)
  {
    if ("int".equals(paramString)) {
      return Integer.TYPE;
    }
    if ("java.lang.String".equals(paramString)) {
      return String.class;
    }
    if ("java.lang.Boolean".equals(paramString)) {
      return Boolean.class;
    }
    if ("long".equals(paramString)) {
      return Long.TYPE;
    }
    if ("short".equals(paramString)) {
      return Short.TYPE;
    }
    if ("java.util.ArrayList".equals(paramString)) {
      return ArrayList.class;
    }
    return Class.forName(paramString);
  }
  
  public static Object a(Class paramClass)
  {
    return Proxy.newProxyInstance(paramClass.getClassLoader(), paramClass.getInterfaces(), new bhcz(paramClass));
  }
  
  private static EIPCResult b(String paramString, Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().callServer("ThemeIPCModule", paramString, paramBundle);
  }
  
  private static Object b(Bundle paramBundle, String paramString1, String paramString2)
  {
    if ("int".equals(paramString1)) {
      return Integer.valueOf(paramBundle.getInt(paramString2));
    }
    if ("java.lang.String".equals(paramString1)) {
      return paramBundle.getString(paramString2);
    }
    if ("java.lang.Boolean".equals(paramString1)) {
      return Boolean.valueOf(paramBundle.getBoolean(paramString2));
    }
    if ("long".equals(paramString1)) {
      return Long.valueOf(paramBundle.getLong(paramString2));
    }
    if ("short".equals(paramString1)) {
      return Short.valueOf(paramBundle.getShort(paramString2));
    }
    if ("java.util.ArrayList".equals(paramString1)) {
      return paramBundle.getStringArrayList(paramString2);
    }
    return null;
  }
  
  private static void b(Bundle paramBundle, String paramString1, String paramString2, Object paramObject)
  {
    if ("int".equals(paramString1)) {
      paramBundle.putInt(paramString2, ((Integer)paramObject).intValue());
    }
    do
    {
      return;
      if ("java.lang.String".equals(paramString1))
      {
        paramBundle.putString(paramString2, (String)paramObject);
        return;
      }
      if ("java.lang.Boolean".equals(paramString1))
      {
        paramBundle.putBoolean(paramString2, ((Boolean)paramObject).booleanValue());
        return;
      }
      if ("long".equals(paramString1))
      {
        paramBundle.putLong(paramString2, ((Long)paramObject).longValue());
        return;
      }
      if ("short".equals(paramString1))
      {
        paramBundle.putShort(paramString2, ((Short)paramObject).shortValue());
        return;
      }
    } while (!"java.util.ArrayList".equals(paramString1));
    paramBundle.putStringArrayList(paramString2, (ArrayList)paramObject);
  }
  
  private static void b(String paramString, Bundle paramBundle, EIPCResultCallback paramEIPCResultCallback)
  {
    QIPCClientHelper.getInstance().callServer("ThemeIPCModule", paramString, paramBundle, paramEIPCResultCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcy
 * JD-Core Version:    0.7.0.1
 */