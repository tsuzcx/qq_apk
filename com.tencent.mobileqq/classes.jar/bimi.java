import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class bimi
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bime parambime)
  {
    a(parambime, 0L);
  }
  
  public static void a(bime parambime, long paramLong)
  {
    if ((parambime == null) || (parambime.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambime), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bime parambime, int paramInt, bimk parambimk)
  {
    parambime.a(parambimk);
    if (parambime.jdField_b_of_type_JavaLangString != null)
    {
      biqn localbiqn = (biqn)paramAppRuntime.getManager(27);
      if (localbiqn == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambime.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bimc.a(paramAppRuntime, 1, parambime.jdField_b_of_type_Int, parambime.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambime.d) });
        return;
      }
      PluginInfo localPluginInfo = localbiqn.a(parambime.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambime.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bimc.a(paramAppRuntime, 1, parambime.jdField_b_of_type_Int, parambime.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambime.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bimc.a(paramAppRuntime, 0, parambime.jdField_b_of_type_Int, parambime.c, parambimk.jdField_a_of_type_Int, parambimk.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambime.d) });
        parambime.a();
        return;
      }
      if ((parambime.jdField_a_of_type_Boolean) && (bdin.h(BaseApplicationImpl.getContext())))
      {
        localbiqn.installPlugin(parambime.jdField_b_of_type_JavaLangString, new bimj(paramAppRuntime, parambime, parambimk, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambime.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bimc.a(paramAppRuntime, 1, parambime.jdField_b_of_type_Int, parambime.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambime.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bimc.a(paramAppRuntime, 0, parambime.jdField_b_of_type_Int, parambime.c, parambimk.jdField_a_of_type_Int, parambimk.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambime.d) });
    parambime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bimi
 * JD-Core Version:    0.7.0.1
 */