import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.PluginPreloader.1;
import cooperation.plugin.PluginInfo;
import mqq.app.AppRuntime;

public class biib
{
  private static final Handler a;
  
  static
  {
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("PluginPreloader", 0);
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(bihx parambihx)
  {
    a(parambihx, 0L);
  }
  
  public static void a(bihx parambihx, long paramLong)
  {
    if ((parambihx == null) || (parambihx.jdField_a_of_type_JavaLangString == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "the preload strategy or target process is null.");
      }
      return;
    }
    a.postDelayed(new PluginPreloader.1(parambihx), paramLong);
  }
  
  public static void a(AppRuntime paramAppRuntime, bihx parambihx, int paramInt, biid parambiid)
  {
    parambihx.a(parambiid);
    if (parambihx.jdField_b_of_type_JavaLangString != null)
    {
      bimg localbimg = (bimg)paramAppRuntime.getManager(27);
      if (localbimg == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambihx.jdField_b_of_type_Int + " preload:fail:nopluginmanager");
        }
        bihv.a(paramAppRuntime, 1, parambihx.jdField_b_of_type_Int, parambihx.c, 3, "preload:fail:nopluginmanager", paramInt, new String[] { String.valueOf(parambihx.d) });
        return;
      }
      PluginInfo localPluginInfo = localbimg.a(parambihx.jdField_b_of_type_JavaLangString);
      if (localPluginInfo == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "pluginType:" + parambihx.jdField_b_of_type_Int + " preload:fail:noplugininfo");
        }
        bihv.a(paramAppRuntime, 1, parambihx.jdField_b_of_type_Int, parambihx.c, 3, "preload:fail:noplugininfo", paramInt, new String[] { String.valueOf(parambihx.d) });
        return;
      }
      if (localPluginInfo.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PluginPreloader", 2, "plugin already installed, do preload.");
        }
        bihv.a(paramAppRuntime, 0, parambihx.jdField_b_of_type_Int, parambihx.c, parambiid.jdField_a_of_type_Int, parambiid.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambihx.d) });
        parambihx.a();
        return;
      }
      if ((parambihx.jdField_a_of_type_Boolean) && (bdee.h(BaseApplicationImpl.getContext())))
      {
        localbimg.installPlugin(parambihx.jdField_b_of_type_JavaLangString, new biic(paramAppRuntime, parambihx, parambiid, paramInt));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreloader", 2, "pluginType:" + parambihx.jdField_b_of_type_Int + " preload:fail:uninstall");
      }
      bihv.a(paramAppRuntime, 1, parambihx.jdField_b_of_type_Int, parambihx.c, 3, "preload:fail:uninstall", paramInt, new String[] { String.valueOf(parambihx.d) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloader", 2, "do preload");
    }
    bihv.a(paramAppRuntime, 0, parambihx.jdField_b_of_type_Int, parambihx.c, parambiid.jdField_a_of_type_Int, parambiid.jdField_a_of_type_JavaLangString, paramInt, new String[] { String.valueOf(parambihx.d) });
    parambihx.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biib
 * JD-Core Version:    0.7.0.1
 */