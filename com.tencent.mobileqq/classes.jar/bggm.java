import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bggm
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bggi parambggi)
  {
    a(parambggi, 0L);
  }
  
  public static void a(bggi parambggi, long paramLong)
  {
    if ((parambggi == null) || (parambggi.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambggi), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bggi parambggi, int paramInt, bggo parambggo)
  {
    parambggi.a(parambggo);
    if (parambggi.jdField_b_of_type_JavaLangString != null)
    {
      bgkq localbgkq = (bgkq)paramAppRuntime.getManager(27);
      if (localbgkq == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambggi.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bggg.a(paramAppRuntime, 1, parambggi.jdField_b_of_type_Int, parambggi.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambggi.d) });
        return;
      }
      PluginInfo localPluginInfo = localbgkq.a(parambggi.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambggi.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bggg.a(paramAppRuntime, 1, parambggi.jdField_b_of_type_Int, parambggi.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambggi.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bggg.a(paramAppRuntime, 0, parambggi.jdField_b_of_type_Int, parambggi.c, parambggo.jdField_a_of_type_Int, parambggo.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambggi.d) });
        parambggi.a();
        return;
      }
      if ((parambggi.jdField_a_of_type_Boolean) && (bbev.h(BaseApplicationImpl.getContext())))
      {
        localbgkq.installPlugin(parambggi.jdField_b_of_type_JavaLangString, new bggn(paramAppRuntime, parambggi, parambggo, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambggi.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bggg.a(paramAppRuntime, 1, parambggi.jdField_b_of_type_Int, parambggi.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambggi.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bggg.a(paramAppRuntime, 0, parambggi.jdField_b_of_type_Int, parambggi.c, parambggo.jdField_a_of_type_Int, parambggo.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambggi.d) });
    parambggi.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggm
 * JD-Core Version:    0.7.0.1
 */