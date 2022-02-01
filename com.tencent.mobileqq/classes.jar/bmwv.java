import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class bmwv
{
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 8);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    localObject2 = null;
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramString2 = "";
      return paramString2;
    }
    for (;;)
    {
      try
      {
        byte[] arrayOfByte = paramString1.getBytes();
        localObject1 = localObject2;
        if (arrayOfByte != null)
        {
          localObject1 = localObject2;
          if (arrayOfByte.length > 0)
          {
            paramString2 = new bmwu().b(arrayOfByte, paramString2.getBytes());
            localObject1 = localObject2;
            if (paramString2 != null)
            {
              paramString2 = Base64.encode(paramString2, paramInt);
              if (paramString2 == null) {
                continue;
              }
              paramString2 = new String(paramString2);
              localObject1 = paramString2;
            }
          }
        }
      }
      catch (Exception paramString2)
      {
        Object localObject1 = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("WadlProviderUtil", 4, "encodeStr exception:", paramString2);
        localObject1 = localObject2;
        continue;
      }
      paramString2 = (String)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("WadlProviderUtil", 4, "encodeStr signStr=" + paramString1 + ",encodeStr=" + (String)localObject1);
      return localObject1;
      paramString2 = null;
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = false;
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getApplication().getSystemService("activity")).getRunningAppProcesses().iterator();
    if (localIterator.hasNext())
    {
      if (!((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals(paramString)) {
        break label57;
      }
      bool = true;
    }
    label57:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return b(paramString1, paramString2, 8);
  }
  
  public static String b(String paramString1, String paramString2, int paramInt)
  {
    localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label28;
      }
      localObject1 = localObject3;
    }
    label28:
    do
    {
      return localObject1;
      try
      {
        paramString1 = Base64.decode(paramString1, paramInt);
        if ((paramString1 == null) || (paramString1.length <= 0)) {
          break;
        }
        paramString1 = new bmwu().a(paramString1, paramString2.getBytes());
        if (paramString1 == null) {
          break;
        }
        paramString1 = new String(paramString1);
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.e("WadlProviderUtil", 4, "decodeStr exception:", paramString2);
            paramString1 = localObject2;
            continue;
            paramString1 = null;
          }
        }
      }
      localObject1 = paramString1;
    } while (!QLog.isColorLevel());
    QLog.d("WadlProviderUtil", 4, "decodeStr decodeStr=" + paramString1);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bmwv
 * JD-Core Version:    0.7.0.1
 */