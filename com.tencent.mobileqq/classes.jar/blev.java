import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.ilive.IliveLaunchFragment;
import java.lang.ref.WeakReference;

public class blev
{
  private static WeakReference<blew> a;
  public static boolean a;
  public static boolean b;
  private static boolean c = true;
  
  public static void a()
  {
    if (jdField_a_of_type_JavaLangRefWeakReference == null) {}
    blew localblew;
    do
    {
      return;
      localblew = (blew)jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localblew == null);
    localblew.onPreloadEnd();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (!aqyj.c().d()) {}
    do
    {
      return;
      if ((paramInt == 1) && (!a()))
      {
        QLog.e("IlivePreloadHelper", 1, "preloadLiveShopping checkDrawerSwitchEnable = false");
        return;
      }
      QLog.e("IlivePreloadHelper", 1, "ilive start preloadLiveShopping , source = " + paramInt);
      bhle.b(-1);
      Intent localIntent = new Intent(paramContext, PreloadWebService.class);
      localIntent.putExtra("isPreloadLiveShopping", true);
      localIntent.putExtra("source", paramInt);
      try
      {
        paramContext.startService(localIntent);
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("IlivePreloadHelper", 2, "preDownloadIfNecessary=>" + paramContext.getMessage());
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
  
  public static void a(blew paramblew)
  {
    if (paramblew == null) {
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramblew);
  }
  
  private static boolean a()
  {
    boolean bool = true;
    int i = QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadModelLevel", 21);
    if (Build.VERSION.SDK_INT < i) {}
    while (!blei.a()) {
      return false;
    }
    if (QzoneConfig.getInstance().getConfig("qqLive", "drawerPreloadSwitch", 1) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blev
 * JD-Core Version:    0.7.0.1
 */