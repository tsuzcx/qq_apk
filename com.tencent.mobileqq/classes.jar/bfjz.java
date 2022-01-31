import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import mqq.app.AppRuntime;

public class bfjz
{
  public static AppRuntime a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() application == null || processName == null");
      }
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.qqindividuality.application.QQIndividualityRuntime");
      if (localClass1 != null) {}
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;)
      {
        try
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() cls == null");
        }
        catch (ClassNotFoundException paramBaseApplicationImpl)
        {
          ClassLoader localClassLoader;
          paramBaseApplicationImpl.printStackTrace();
        }
        localClassNotFoundException = localClassNotFoundException;
        localClassLoader = PluginStatic.getOrCreateClassLoader(paramBaseApplicationImpl, "qqindividuality_plugin.apk");
        Class localClass2 = localClassLoader.loadClass("com.qqindividuality.application.QQIndividualityRuntime");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
        continue;
        do
        {
          return null;
          if (QLog.isColorLevel()) {
            QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() 1 ");
          }
          paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { BaseApplicationImpl.class, String.class }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
        } while (!(paramBaseApplicationImpl instanceof AppRuntime));
        if (QLog.isColorLevel()) {
          QLog.d("QQIndividuality", 2, "QQIndividualityRuntime() succ");
        }
        paramBaseApplicationImpl = (AppRuntime)paramBaseApplicationImpl;
        return paramBaseApplicationImpl;
      }
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
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfjz
 * JD-Core Version:    0.7.0.1
 */