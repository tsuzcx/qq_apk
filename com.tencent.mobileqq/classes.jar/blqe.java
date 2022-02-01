import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class blqe
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(blqa paramblqa)
  {
    a(paramblqa, 0L);
  }
  
  public static void a(blqa paramblqa, long paramLong)
  {
    if ((paramblqa == null) || (paramblqa.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(paramblqa), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, blqa paramblqa, int paramInt, blqg paramblqg)
  {
    paramblqa.a(paramblqg);
    if (paramblqa.jdField_b_of_type_JavaLangString != null)
    {
      blvy localblvy = (blvy)paramAppRuntime.getManager(QQManagerFactory.MGR_PLUGIN);
      if (localblvy == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramblqa.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        blpy.a(paramAppRuntime, 1, paramblqa.jdField_b_of_type_Int, paramblqa.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(paramblqa.d) });
        return;
      }
      PluginInfo localPluginInfo = localblvy.a(paramblqa.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + paramblqa.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        blpy.a(paramAppRuntime, 1, paramblqa.jdField_b_of_type_Int, paramblqa.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(paramblqa.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        blpy.a(paramAppRuntime, 0, paramblqa.jdField_b_of_type_Int, paramblqa.c, paramblqg.jdField_a_of_type_Int, paramblqg.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(paramblqa.d) });
        paramblqa.a();
        return;
      }
      if ((paramblqa.jdField_a_of_type_Boolean) && (NetworkUtil.isWifiConnected(BaseApplicationImpl.getContext())))
      {
        localblvy.installPlugin(paramblqa.jdField_b_of_type_JavaLangString, new blqf(paramAppRuntime, paramblqa, paramblqg, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + paramblqa.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      blpy.a(paramAppRuntime, 1, paramblqa.jdField_b_of_type_Int, paramblqa.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(paramblqa.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    blpy.a(paramAppRuntime, 0, paramblqa.jdField_b_of_type_Int, paramblqa.c, paramblqg.jdField_a_of_type_Int, paramblqg.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(paramblqa.d) });
    paramblqa.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqe
 * JD-Core Version:    0.7.0.1
 */