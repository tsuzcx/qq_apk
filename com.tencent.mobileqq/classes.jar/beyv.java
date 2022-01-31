import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class beyv
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(beyr parambeyr)
  {
    a(parambeyr, 0L);
  }
  
  public static void a(beyr parambeyr, long paramLong)
  {
    if ((parambeyr == null) || (parambeyr.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambeyr), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, beyr parambeyr, int paramInt, beyx parambeyx)
  {
    parambeyr.a(parambeyx);
    if (parambeyr.jdField_b_of_type_JavaLangString != null)
    {
      bfcz localbfcz = (bfcz)paramAppRuntime.getManager(27);
      if (localbfcz == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambeyr.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        beyp.a(paramAppRuntime, 1, parambeyr.jdField_b_of_type_Int, parambeyr.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambeyr.d) });
        return;
      }
      PluginInfo localPluginInfo = localbfcz.a(parambeyr.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambeyr.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        beyp.a(paramAppRuntime, 1, parambeyr.jdField_b_of_type_Int, parambeyr.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambeyr.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        beyp.a(paramAppRuntime, 0, parambeyr.jdField_b_of_type_Int, parambeyr.c, parambeyx.jdField_a_of_type_Int, parambeyx.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambeyr.d) });
        parambeyr.a();
        return;
      }
      if ((parambeyr.jdField_a_of_type_Boolean) && (badq.h(BaseApplicationImpl.getContext())))
      {
        localbfcz.installPlugin(parambeyr.jdField_b_of_type_JavaLangString, new beyw(paramAppRuntime, parambeyr, parambeyx, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambeyr.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      beyp.a(paramAppRuntime, 1, parambeyr.jdField_b_of_type_Int, parambeyr.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambeyr.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    beyp.a(paramAppRuntime, 0, parambeyr.jdField_b_of_type_Int, parambeyr.c, parambeyx.jdField_a_of_type_Int, parambeyx.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambeyr.d) });
    parambeyr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyv
 * JD-Core Version:    0.7.0.1
 */