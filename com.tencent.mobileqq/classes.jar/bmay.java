import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bmay
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bmau parambmau)
  {
    a(parambmau, 0L);
  }
  
  public static void a(bmau parambmau, long paramLong)
  {
    if ((parambmau == null) || (parambmau.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambmau), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bmau parambmau, int paramInt, bmba parambmba)
  {
    parambmau.a(parambmba);
    if (parambmau.jdField_b_of_type_JavaLangString != null)
    {
      bmgk localbmgk = (bmgk)paramAppRuntime.getManager(27);
      if (localbmgk == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambmau.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bmas.a(paramAppRuntime, 1, parambmau.jdField_b_of_type_Int, parambmau.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambmau.d) });
        return;
      }
      PluginInfo localPluginInfo = localbmgk.a(parambmau.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambmau.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bmas.a(paramAppRuntime, 1, parambmau.jdField_b_of_type_Int, parambmau.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambmau.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bmas.a(paramAppRuntime, 0, parambmau.jdField_b_of_type_Int, parambmau.c, parambmba.jdField_a_of_type_Int, parambmba.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambmau.d) });
        parambmau.a();
        return;
      }
      if ((parambmau.jdField_a_of_type_Boolean) && (bhnv.h(BaseApplicationImpl.getContext())))
      {
        localbmgk.installPlugin(parambmau.jdField_b_of_type_JavaLangString, new bmaz(paramAppRuntime, parambmau, parambmba, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambmau.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bmas.a(paramAppRuntime, 1, parambmau.jdField_b_of_type_Int, parambmau.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambmau.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bmas.a(paramAppRuntime, 0, parambmau.jdField_b_of_type_Int, parambmau.c, parambmba.jdField_a_of_type_Int, parambmba.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambmau.d) });
    parambmau.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmay
 * JD-Core Version:    0.7.0.1
 */