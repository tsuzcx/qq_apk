import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.IliveLaunchFragment;
import cooperation.ilive.util.IlivePreloadHelper.1;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class bmfy
{
  private static WeakReference<bmfz> a;
  public static boolean a;
  public static boolean b;
  private static boolean c = true;
  
  public static void a()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference == null) {}
    bmfz localbmfz;
    do
    {
      return;
      localbmfz = (bmfz)jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localbmfz == null);
    localbmfz.onPreloadEnd();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new IlivePreloadHelper.1(paramInt, paramContext));
  }
  
  public static void a(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IlivePreloadHelper", 2, "preload LiveShopping");
    }
    if ((!c) || (b))
    {
      c = false;
      QLog.e("IlivePreloadHelper", 1, "ilive has preload");
      return;
    }
    c = false;
    jdField_a_of_type_Boolean = true;
    QLog.i("IlivePreloadHelper", 1, "preload start");
    IliveLaunchFragment localIliveLaunchFragment = new IliveLaunchFragment();
    if (paramIntent != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("source", paramIntent.getIntExtra("source", 0));
      localIliveLaunchFragment.setArguments(localBundle);
    }
    localIliveLaunchFragment.doLoading(true, BaseApplicationImpl.getApplication());
  }
  
  public static void a(bmfz parambmfz)
  {
    if (parambmfz == null) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(parambmfz);
  }
  
  private static boolean b()
  {
    boolean bool = true;
    int i = QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadModelLevel", 21);
    if (Build.VERSION.SDK_INT < i) {}
    do
    {
      do
      {
        return false;
      } while (!bhlo.f());
      if (c())
      {
        QLog.e("IlivePreloadHelper", 1, "checkDrawerSwitchEnable preload limit");
        return false;
      }
    } while (!bmfl.a());
    if (QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadSwitch", 1) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private static void c()
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).edit();
    localEditor.putLong("last_preload_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  private static boolean c()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_ilive", 4).getLong("last_preload_time", 0L);
    return System.currentTimeMillis() - l < 7200000L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfy
 * JD-Core Version:    0.7.0.1
 */