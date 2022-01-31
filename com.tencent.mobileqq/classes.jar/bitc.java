import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qlink.QlinkPluginProxyActivity;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;

public class bitc
{
  public static Intent a()
  {
    Intent localIntent = new Intent();
    QlinkPluginProxyActivity.a(localIntent, "com.tencent.qlink.activity.QlinkProxyActivity");
    return localIntent;
  }
  
  public static bitd a(String paramString)
  {
    int i = 0;
    if (paramString == null) {}
    bitd localbitd;
    Object localObject;
    int j;
    String str2;
    for (;;)
    {
      return null;
      localbitd = new bitd();
      try
      {
        if (paramString.startsWith("qqf2f://qf/?"))
        {
          localObject = paramString.substring("qqf2f://qf/?".length(), paramString.length()).split("&");
          paramString = new Bundle();
          j = localObject.length;
        }
      }
      catch (Exception paramString)
      {
        int k;
        String str1;
        paramString.printStackTrace();
        return null;
      }
    }
    k = str2.indexOf("=");
    if (-1 != k)
    {
      str1 = str2.substring(0, k + 1);
      str2 = str2.substring(k + 1, str2.length());
      if ((str1 != null) && (str2 != null)) {
        paramString.putString(str1, str2);
      }
    }
    label293:
    for (;;)
    {
      localbitd.a = paramString.getString("k=");
      localbitd.b = d(paramString.getString("u="));
      localObject = b(paramString.getString("n="));
      if (localObject != null)
      {
        localbitd.c = URLDecoder.decode((String)localObject, "UTF-8");
        if (localbitd.c != null) {}
      }
      for (localbitd.c = localbitd.b;; localbitd.c = localbitd.b)
      {
        localbitd.d = paramString.getString("o=");
        localbitd.e = paramString.getString("p=");
        localbitd.f = paramString.getString("d=");
        if ((localbitd.a == null) || (localbitd.b == null) || (localbitd.d == null)) {
          break;
        }
        return localbitd;
      }
      for (;;)
      {
        if (i >= j) {
          break label293;
        }
        str2 = localObject[i];
        if (str2 != null) {
          break;
        }
        i += 1;
      }
    }
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.tencent.qlink.app.QlinkAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = QlinkPluginProxyActivity.a(paramBaseApplicationImpl);
        localClass2 = localClassLoader.loadClass("com.tencent.qlink.app.QlinkAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  public static String a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    Object localObject = paramString.getBytes();
    paramString = new byte[localObject.length];
    int i = 0;
    while (i < localObject.length)
    {
      paramString[i] = ((byte)((byte)((byte)(localObject[i] ^ 0xFFFFFFA2) ^ 0x68) ^ 0x1B));
      i += 1;
    }
    localObject = new StringBuilder(paramString.length * 2);
    i = j;
    while (i < paramString.length)
    {
      ((StringBuilder)localObject).append(Integer.toHexString((paramString[i] & 0xF0) >> 4));
      ((StringBuilder)localObject).append(Integer.toHexString(paramString[i] & 0xF));
      i += 1;
    }
    return ((StringBuilder)localObject).toString();
  }
  
  public static boolean a()
  {
    try
    {
      WifiManager localWifiManager = (WifiManager)BaseApplicationImpl.getContext().getSystemService("wifi");
      Method localMethod = localWifiManager.getClass().getMethod("isWifiApEnabled", new Class[0]);
      localMethod.setAccessible(true);
      boolean bool = ((Boolean)localMethod.invoke(localWifiManager, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return false;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static String b(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return null;
    }
    int k = paramString.length() / 2;
    byte[] arrayOfByte = new byte[k];
    int i = 0;
    while (i < k) {
      try
      {
        arrayOfByte[i] = Integer.valueOf(paramString.substring(i * 2, i * 2 + 2), 16).byteValue();
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    paramString = new byte[k];
    i = j;
    while (i < arrayOfByte.length)
    {
      paramString[i] = ((byte)((byte)((byte)(arrayOfByte[i] ^ 0x1B) ^ 0x68) ^ 0xFFFFFFA2));
      i += 1;
    }
    try
    {
      paramString = new String(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String c(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0x3702D1C2 ^ 0x5891625D ^ 0xCF267E29);
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public static String d(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return String.valueOf(l ^ 0xCF267E29 ^ 0x5891625D ^ 0x3702D1C2);
    }
    catch (Exception paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bitc
 * JD-Core Version:    0.7.0.1
 */