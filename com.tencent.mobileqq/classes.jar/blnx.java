import android.text.TextUtils;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QReaderHelper.1;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class blnx
{
  public static int a = 0;
  public static boolean a;
  
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      paramString = Class.forName("com.qqreader.ReaderRuntime");
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QReaderHelper", 2, "createReaderRuntime: load class failed");
        }
        return null;
      }
    }
    catch (ClassNotFoundException paramString)
    {
      try
      {
        ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qqreaderplugin.apk");
        paramString = localClassLoader.loadClass("com.qqreader.ReaderRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (Exception paramBaseApplicationImpl)
      {
        return null;
      }
      paramBaseApplicationImpl = paramString.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, "Reader" });
      if ((paramBaseApplicationImpl != null) && ((paramBaseApplicationImpl instanceof AppRuntime)))
      {
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      paramBaseApplicationImpl.printStackTrace();
      return null;
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
  
  public static void a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    if (!bgnt.g(paramQQAppInterface.getApplication())) {
      if (QLog.isColorLevel()) {
        QLog.d("QReaderHelper", 2, "no network. skip update offline pkg.");
      }
    }
    do
    {
      return;
      if (a(paramInt))
      {
        if (QLog.isColorLevel()) {
          QLog.e("QReaderHelper", 1, "entry " + paramInt + " offline preload enabled,update offline package now!");
        }
        nko.a();
        ThreadManager.post(new QReaderHelper.1(paramQQAppInterface), 5, null, true);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QReaderHelper", 2, "entry " + paramInt + " offline preload is disabled.");
  }
  
  private static boolean a(int paramInt)
  {
    boolean bool = true;
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.qr_process_config.name());
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (QLog.isColorLevel())) {
      QLog.e("QReaderHelper", 1, "reader dpc is null.");
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("QReaderHelper", 2, "enableOfflinePreload,dpc=" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length >= 7) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("QReaderHelper", 2, "offline preload switch not fount.");
    return false;
    if ((Integer.parseInt(localObject[6]) & paramInt) != 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blnx
 * JD-Core Version:    0.7.0.1
 */