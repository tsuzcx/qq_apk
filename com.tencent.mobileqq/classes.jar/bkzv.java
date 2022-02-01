import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bkzv
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bkzr parambkzr)
  {
    a(parambkzr, 0L);
  }
  
  public static void a(bkzr parambkzr, long paramLong)
  {
    if ((parambkzr == null) || (parambkzr.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambkzr), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bkzr parambkzr, int paramInt, bkzx parambkzx)
  {
    parambkzr.a(parambkzx);
    if (parambkzr.jdField_b_of_type_JavaLangString != null)
    {
      blfh localblfh = (blfh)paramAppRuntime.getManager(27);
      if (localblfh == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambkzr.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bkzp.a(paramAppRuntime, 1, parambkzr.jdField_b_of_type_Int, parambkzr.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambkzr.d) });
        return;
      }
      PluginInfo localPluginInfo = localblfh.a(parambkzr.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambkzr.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bkzp.a(paramAppRuntime, 1, parambkzr.jdField_b_of_type_Int, parambkzr.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambkzr.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bkzp.a(paramAppRuntime, 0, parambkzr.jdField_b_of_type_Int, parambkzr.c, parambkzx.jdField_a_of_type_Int, parambkzx.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambkzr.d) });
        parambkzr.a();
        return;
      }
      if ((parambkzr.jdField_a_of_type_Boolean) && (bgnt.h(BaseApplicationImpl.getContext())))
      {
        localblfh.installPlugin(parambkzr.jdField_b_of_type_JavaLangString, new bkzw(paramAppRuntime, parambkzr, parambkzx, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambkzr.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bkzp.a(paramAppRuntime, 1, parambkzr.jdField_b_of_type_Int, parambkzr.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambkzr.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bkzp.a(paramAppRuntime, 0, parambkzr.jdField_b_of_type_Int, parambkzr.c, parambkzx.jdField_a_of_type_Int, parambkzx.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambkzr.d) });
    parambkzr.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzv
 * JD-Core Version:    0.7.0.1
 */