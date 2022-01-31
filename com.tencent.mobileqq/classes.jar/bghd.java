import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bghd
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bggz parambggz)
  {
    a(parambggz, 0L);
  }
  
  public static void a(bggz parambggz, long paramLong)
  {
    if ((parambggz == null) || (parambggz.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambggz), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bggz parambggz, int paramInt, bghf parambghf)
  {
    parambggz.a(parambghf);
    if (parambggz.jdField_b_of_type_JavaLangString != null)
    {
      bglh localbglh = (bglh)paramAppRuntime.getManager(27);
      if (localbglh == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambggz.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bggx.a(paramAppRuntime, 1, parambggz.jdField_b_of_type_Int, parambggz.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambggz.d) });
        return;
      }
      PluginInfo localPluginInfo = localbglh.a(parambggz.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambggz.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bggx.a(paramAppRuntime, 1, parambggz.jdField_b_of_type_Int, parambggz.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambggz.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bggx.a(paramAppRuntime, 0, parambggz.jdField_b_of_type_Int, parambggz.c, parambghf.jdField_a_of_type_Int, parambghf.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambggz.d) });
        parambggz.a();
        return;
      }
      if ((parambggz.jdField_a_of_type_Boolean) && (bbfj.h(BaseApplicationImpl.getContext())))
      {
        localbglh.installPlugin(parambggz.jdField_b_of_type_JavaLangString, new bghe(paramAppRuntime, parambggz, parambghf, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambggz.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bggx.a(paramAppRuntime, 1, parambggz.jdField_b_of_type_Int, parambggz.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambggz.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bggx.a(paramAppRuntime, 0, parambggz.jdField_b_of_type_Int, parambggz.c, parambghf.jdField_a_of_type_Int, parambghf.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambggz.d) });
    parambggz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bghd
 * JD-Core Version:    0.7.0.1
 */