import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bket
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bkep parambkep)
  {
    a(parambkep, 0L);
  }
  
  public static void a(bkep parambkep, long paramLong)
  {
    if ((parambkep == null) || (parambkep.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambkep), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bkep parambkep, int paramInt, bkev parambkev)
  {
    parambkep.a(parambkev);
    if (parambkep.jdField_b_of_type_JavaLangString != null)
    {
      bkkq localbkkq = (bkkq)paramAppRuntime.getManager(27);
      if (localbkkq == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambkep.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bken.a(paramAppRuntime, 1, parambkep.jdField_b_of_type_Int, parambkep.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambkep.d) });
        return;
      }
      PluginInfo localPluginInfo = localbkkq.a(parambkep.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambkep.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bken.a(paramAppRuntime, 1, parambkep.jdField_b_of_type_Int, parambkep.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambkep.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bken.a(paramAppRuntime, 0, parambkep.jdField_b_of_type_Int, parambkep.c, parambkev.jdField_a_of_type_Int, parambkev.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambkep.d) });
        parambkep.a();
        return;
      }
      if ((parambkep.jdField_a_of_type_Boolean) && (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())))
      {
        localbkkq.installPlugin(parambkep.jdField_b_of_type_JavaLangString, new bkeu(paramAppRuntime, parambkep, parambkev, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambkep.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bken.a(paramAppRuntime, 1, parambkep.jdField_b_of_type_Int, parambkep.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambkep.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bken.a(paramAppRuntime, 0, parambkep.jdField_b_of_type_Int, parambkep.c, parambkev.jdField_a_of_type_Int, parambkev.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambkep.d) });
    parambkep.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bket
 * JD-Core Version:    0.7.0.1
 */