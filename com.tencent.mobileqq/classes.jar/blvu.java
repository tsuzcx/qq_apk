import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.startup.step.InstallPlugins;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Servlet;
import mqq.app.ServletContainer;
import mqq.util.WeakReference;

public class blvu
{
  private static volatile Class<?> jdField_a_of_type_JavaLangClass;
  private static volatile Constructor<?> jdField_a_of_type_JavaLangReflectConstructor;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static final AtomicReference<SharedPreferences> jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference = new AtomicReference();
  private static volatile WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  public static volatile boolean a;
  private static volatile WeakReference<PluginManagerClient> b;
  public static volatile boolean b;
  private static volatile boolean c;
  private static volatile boolean d;
  
  static
  {
    jdField_b_of_type_MqqUtilWeakReference = new WeakReference(null);
  }
  
  @Nullable
  public static Fragment a(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface, @NonNull String paramString)
  {
    if (!c) {
      QZLog.w("QZoneApiProxy", "createLebaFragment: not init yet");
    }
    for (;;)
    {
      return null;
      paramString = a(paramQQAppInterface.getApp(), paramString);
      if (paramString == null)
      {
        QZLog.e("QZoneApiProxy", "clazz==null");
        return null;
      }
      try
      {
        paramString = (Fragment)paramString.newInstance();
        if (paramString == null) {
          continue;
        }
        if ((paramString instanceof blwb))
        {
          try
          {
            ((blwb)paramString).attachQQContext(paramActivity, paramQQAppInterface);
            i = 1;
          }
          catch (Throwable paramActivity)
          {
            for (;;)
            {
              QZLog.w("QZoneApiProxy", "createLebaFragment: failed to init instance", paramActivity);
              i = 0;
              continue;
              paramString = null;
            }
          }
          if (i != 0) {
            return paramString;
          }
        }
      }
      catch (Throwable paramString)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "createLebaFragment: failed to create instance", paramString);
          paramString = null;
          continue;
          int i = 1;
        }
      }
    }
  }
  
  @NonNull
  private static SharedPreferences a(@NonNull Context paramContext)
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.compareAndSet(null, paramContext.getSharedPreferences("qzone_api_proxy_sp_name", 0));
    return (SharedPreferences)jdField_a_of_type_JavaUtilConcurrentAtomicAtomicReference.get();
  }
  
  public static View a(Context paramContext, AttributeSet paramAttributeSet)
  {
    boolean bool = true;
    StringBuilder localStringBuilder = new StringBuilder().append("createSchoolExtendList: ");
    if (jdField_a_of_type_JavaLangReflectConstructor != null) {}
    for (;;)
    {
      QZLog.i("QZoneApiProxy", bool);
      if (jdField_a_of_type_JavaLangReflectConstructor != null) {
        break;
      }
      return null;
      bool = false;
    }
    try
    {
      paramContext = (View)jdField_a_of_type_JavaLangReflectConstructor.newInstance(new Object[] { paramContext, paramAttributeSet });
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      QZLog.w("QZoneApiProxy", "onCreateView: failed", paramContext);
    }
    return null;
  }
  
  @Nullable
  public static blvt a(@NonNull Activity paramActivity)
  {
    if (!c) {
      QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: not init yet");
    }
    for (;;)
    {
      return null;
      Object localObject1 = a(paramActivity, "com.qzone.feed.ui.activity.QZoneMsgFeedViewHolder");
      if (localObject1 == null)
      {
        QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder: failed to get class");
        return null;
      }
      try
      {
        localObject1 = ((Class)localObject1).getConstructor(new Class[] { Activity.class });
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          paramActivity = (blvt)((Constructor)localObject1).newInstance(new Object[] { paramActivity });
          return paramActivity;
          localThrowable = localThrowable;
          QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to get constructor", localThrowable);
          Object localObject2 = null;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "createMsgFeedViewHolder failed to create instance", paramActivity);
            paramActivity = null;
          }
        }
      }
    }
  }
  
  public static QQAppInterface a()
  {
    if (jdField_a_of_type_MqqUtilWeakReference == null) {
      return null;
    }
    return (QQAppInterface)jdField_a_of_type_MqqUtilWeakReference.get();
  }
  
  @Nullable
  private static <T> Class<T> a(@NonNull Context paramContext, @NonNull String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.a(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QZLog.w("QZoneApiProxy", "createAdapter: failed to get class by qzone plugin class loader", paramContext);
        }
        localThrowable = localThrowable;
        QZLog.d("QZoneApiProxy", 2, "createAdapter: failed to get class by normal class loader", localThrowable);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static String a(Context paramContext)
  {
    String str = a(paramContext).getString("msg_page_title", "");
    paramContext = str;
    if (TextUtils.isEmpty(str)) {
      paramContext = anni.a(2131718385);
    }
    return paramContext;
  }
  
  public static void a()
  {
    PublicFragmentActivity.a("com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView", new blvy(null));
  }
  
  public static void a(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    QZLog.i("QZoneApiProxy", "onAccountChange: " + paramQQAppInterface.c() + " " + d + " " + c);
    if (!d) {
      a(paramContext, paramQQAppInterface);
    }
    for (;;)
    {
      return;
      if (jdField_a_of_type_JavaLangClass == null) {
        jdField_a_of_type_JavaLangClass = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      if (jdField_a_of_type_JavaLangClass == null) {
        continue;
      }
      if (jdField_a_of_type_JavaLangReflectMethod == null) {}
      try
      {
        jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getMethod("onAccountChange", new Class[] { QQAppInterface.class });
        if (jdField_a_of_type_JavaLangReflectMethod == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          jdField_a_of_type_JavaLangReflectMethod.invoke(null, new Object[] { paramQQAppInterface });
          if (!c) {
            continue;
          }
          c = false;
          b(paramContext, paramQQAppInterface);
          return;
          localThrowable1 = localThrowable1;
          QZLog.w("QZoneApiProxy", "onAccountChange: failed to get change account method", localThrowable1);
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "onAccountChange: failed to call change account method", localThrowable2);
          }
        }
      }
    }
  }
  
  public static void a(@NonNull Context paramContext, boolean paramBoolean, @Nullable String paramString)
  {
    QZLog.i("QZoneApiProxy", "recordShowSubFeedConfig: " + paramBoolean + " " + paramString);
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    a(paramContext).edit().putBoolean("show_sub_feeds", paramBoolean).putString("msg_page_title", str).apply();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT != 19;
  }
  
  public static boolean a(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      if (paramQQAppInterface != null) {
        break label19;
      }
      bool1 = bool2;
    }
    label19:
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (!c());
        if (!bcnj.a())
        {
          QZLog.e("QZoneApiProxy", "isNowSimpleUI no");
          return false;
        }
        int i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 0, paramQQAppInterface.getLongAccountUin());
        if ((0x10000 & i) == 0)
        {
          QZLog.e("QZoneApiProxy", "grayMask no" + i);
          return false;
        }
        bool2 = e(paramActivity, paramQQAppInterface);
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (paramQQAppInterface == a());
    a(paramActivity, paramQQAppInterface);
    return bool2;
  }
  
  public static boolean a(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    long l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initEnv: start");
    boolean bool1;
    if (d) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (jdField_a_of_type_JavaLangClass == null) {
        jdField_a_of_type_JavaLangClass = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "initEnv: loadQZoneClass");
      bool1 = bool2;
      if (jdField_a_of_type_JavaLangClass == null) {
        continue;
      }
      try
      {
        paramContext = jdField_a_of_type_JavaLangClass.getMethod("init", new Class[] { QQAppInterface.class });
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[] { paramQQAppInterface })).booleanValue();
          d = bool1;
          long l2 = System.nanoTime();
          QZLog.e("QZoneApiProxy", "initEnv: end " + d + " " + (l2 - l1));
          return d;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "initEnv: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "initEnv: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean a(@Nullable blvx paramblvx)
  {
    QZLog.i("QZoneApiProxy", "needLoadQZoneEnv: is launch ? " + BaseApplicationImpl.isCurrentVersionFirstLaunch);
    if (!a())
    {
      if (paramblvx != null) {
        paramblvx.onLoadOver(false);
      }
      return false;
    }
    if (c)
    {
      if (paramblvx != null) {
        paramblvx.onLoadOver(true);
      }
      return true;
    }
    return b(paramblvx);
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT > 19;
  }
  
  public static boolean b(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    boolean bool1 = true;
    if ((paramActivity == null) || (paramQQAppInterface == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      boolean bool2 = e(paramActivity, paramQQAppInterface);
      if ((bool2) && (paramQQAppInterface != a())) {
        a(paramActivity, paramQQAppInterface);
      }
      if (jdField_a_of_type_JavaLangReflectConstructor == null)
      {
        paramQQAppInterface = a(paramActivity, "com.qzone.feed.ui.activity.QQSchoolExtendFeedsListView");
        if (paramQQAppInterface == null) {}
      }
      try
      {
        jdField_a_of_type_JavaLangReflectConstructor = paramQQAppInterface.getConstructor(new Class[] { Context.class, AttributeSet.class });
        try
        {
          paramActivity.getLayoutInflater().inflate(2131561141, null);
          i = 1;
        }
        catch (Throwable paramActivity)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: inflate failed", paramActivity);
            int i = 0;
          }
        }
        if ((bool2) && (jdField_a_of_type_JavaLangReflectConstructor != null) && (i != 0)) {
          continue;
        }
        return false;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "needShowSchoolExtendFeed: failed to get school extend list view constructor", paramQQAppInterface);
        }
      }
    }
  }
  
  private static boolean b(@NonNull Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (jdField_a_of_type_Boolean) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      if (jdField_a_of_type_JavaLangClass == null) {
        jdField_a_of_type_JavaLangClass = a(paramContext, "com.qzone.app.QZoneRunInQQEnv");
      }
      QZLog.e("QZoneApiProxy", "isQzoneVersionRight: loadQZoneClass");
      bool1 = bool2;
      if (jdField_a_of_type_JavaLangClass == null) {
        continue;
      }
      try
      {
        paramContext = jdField_a_of_type_JavaLangClass.getMethod("isQzoneVersionRight", new Class[0]);
        bool1 = bool2;
        if (paramContext == null) {
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        try
        {
          bool1 = ((Boolean)paramContext.invoke(null, new Object[0])).booleanValue();
          jdField_a_of_type_Boolean = bool1;
          return bool1;
          paramContext = paramContext;
          QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to get init env method", paramContext);
          paramContext = null;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QZLog.w("QZoneApiProxy", "isQzoneVersionRight: failed to init", paramContext);
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static boolean b(@NonNull Context paramContext, @NonNull QQAppInterface paramQQAppInterface)
  {
    j = 0;
    l1 = System.nanoTime();
    QZLog.e("QZoneApiProxy", "initServlet: start");
    if (c) {
      return true;
    }
    ((blfh)paramQQAppInterface.getManager(27)).a("qzone_plugin.apk");
    paramContext = a(paramContext, "com.qzone.common.servlet.QZoneServlet");
    if (paramContext == null) {
      return false;
    }
    ServletContainer localServletContainer;
    try
    {
      localObject1 = (MSFServlet)paramContext.newInstance();
      if (localObject1 == null) {
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get servlet instance", paramContext);
        localObject1 = null;
      }
      try
      {
        paramContext = AppRuntime.class.getDeclaredField("mServletContainer");
        paramContext.setAccessible(true);
        localServletContainer = (ServletContainer)paramContext.get(paramQQAppInterface);
        if (localServletContainer == null) {
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          QZLog.w("QZoneApiProxy", "initServlet: failed to get container", paramContext);
          localServletContainer = null;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramContext = ServletContainer.class.getDeclaredField("managedServlet");
        paramContext.setAccessible(true);
        paramContext = (Map)paramContext.get(localServletContainer);
        Object localObject2;
        QZLog.w("QZoneApiProxy", "initServlet: failed to get container field", localThrowable2);
      }
      catch (Throwable localThrowable2)
      {
        try
        {
          localObject2 = ServletContainer.class.getDeclaredField("actionMap");
          ((Field)localObject2).setAccessible(true);
          localObject2 = (Map)((Field)localObject2).get(localServletContainer);
          if ((paramContext != null) && (localObject2 != null)) {
            break;
          }
          return false;
        }
        catch (Throwable localThrowable3)
        {
          Object localObject3;
          Object localObject4;
          Method localMethod;
          int i;
          int k;
          Set localSet;
          long l2;
          break label201;
        }
        localThrowable2 = localThrowable2;
        paramContext = null;
      }
      label201:
      localObject3 = null;
    }
    try
    {
      localObject4 = Servlet.class.getDeclaredMethod("init", new Class[] { AppRuntime.class, ServletContainer.class });
      ((Method)localObject4).setAccessible(true);
      localMethod = Servlet.class.getDeclaredMethod("onCreate", new Class[0]);
      localMethod.setAccessible(true);
      ((Method)localObject4).invoke(localObject1, new Object[] { paramQQAppInterface, localServletContainer });
      localMethod.invoke(localObject1, new Object[0]);
      i = 1;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        QZLog.w("QZoneApiProxy", "initServlet: failed to get init method", localThrowable1);
        i = 0;
      }
      try
      {
        paramContext.put("com.qzone.common.servlet.QZoneServlet", localObject1);
        localObject4 = ((MSFServlet)localObject1).getPreferSSOCommands();
        if (localObject4 == null) {
          break label436;
        }
        k = localObject4.length;
        i = j;
        while (i < k)
        {
          localMethod = localObject4[i];
          localSet = (Set)localObject3.get(localMethod);
          localObject1 = localSet;
          if (localSet == null)
          {
            localObject1 = new HashSet();
            localObject3.put(localMethod, localObject1);
          }
          ((Set)localObject1).add("com.qzone.common.servlet.QZoneServlet");
          i += 1;
        }
        a(paramQQAppInterface);
        l2 = System.nanoTime();
        QZLog.i("QZoneApiProxy", "initServlet: ok " + paramQQAppInterface.c() + " " + (l2 - l1));
        c = true;
        return true;
      }
      finally {}
    }
    if (i == 0) {
      return false;
    }
  }
  
  public static boolean b(@Nullable blvx paramblvx)
  {
    QZLog.i("QZoneApiProxy", "isQzonePluginInstalledAndVersionRight: sIsQzoneVInstalled=" + jdField_b_of_type_Boolean + "    isQzoneVersionRight=" + jdField_a_of_type_Boolean);
    boolean bool2;
    if ((jdField_b_of_type_Boolean) && (b(BaseApplicationImpl.getApplication())))
    {
      if (paramblvx != null) {
        paramblvx.onLoadOver(true);
      }
      bool2 = true;
      return bool2;
    }
    PluginManagerClient localPluginManagerClient = (PluginManagerClient)jdField_b_of_type_MqqUtilWeakReference.get();
    if (localPluginManagerClient != null)
    {
      boolean bool1 = localPluginManagerClient.isPluginInstalled("qzone_plugin.apk");
      if (bool1)
      {
        QZLog.i("QZoneApiProxy", " sIsQzoneVInstalled = true");
        jdField_b_of_type_Boolean = true;
      }
      if ((bool1) && (b(BaseApplicationImpl.getApplication()))) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = bool1;
        if (paramblvx == null) {
          break;
        }
        paramblvx.onLoadOver(bool1);
        return bool1;
      }
    }
    long l = System.nanoTime();
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new blvv(l, paramblvx));
    return false;
  }
  
  public static boolean c()
  {
    return a(null);
  }
  
  public static boolean c(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "AioShowFeedList", 1) == 0) {
      return false;
    }
    return e(paramActivity, paramQQAppInterface);
  }
  
  public static boolean d()
  {
    return !c;
  }
  
  public static boolean d(@Nullable Activity paramActivity, @Nullable QQAppInterface paramQQAppInterface)
  {
    if ((paramActivity == null) || (paramQQAppInterface == null)) {}
    while (QzoneConfig.getInstance().getConfig("QZoneSetting", "SubShowFeedList", 1) == 0) {
      return false;
    }
    if (!a(paramActivity).getBoolean("show_sub_feeds", false)) {
      QZLog.i("QZoneApiProxy", "needShowSubFeedList: close by server");
    }
    return e(paramActivity, paramQQAppInterface);
  }
  
  public static boolean e()
  {
    boolean bool1;
    if (jdField_b_of_type_Boolean) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      PluginManagerClient localPluginManagerClient = (PluginManagerClient)jdField_b_of_type_MqqUtilWeakReference.get();
      if (localPluginManagerClient == null) {
        break;
      }
      bool2 = localPluginManagerClient.isPluginInstalled("qzone_plugin.apk");
      bool1 = bool2;
    } while (!bool2);
    QZLog.i("QZoneApiProxy", " isQzoneInstalled = true");
    jdField_b_of_type_Boolean = true;
    return bool2;
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getApplication(), new blvw());
    return false;
  }
  
  private static boolean e(@NonNull Activity paramActivity, @NonNull QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    int i = LocalMultiProcConfig.getInt4Uin("creditlevel", 0, paramQQAppInterface.getLongAccountUin());
    if (i == 8)
    {
      QZLog.e("QZoneApiProxy", "creditLevel" + i);
      return false;
    }
    if ((c) && (d)) {
      return true;
    }
    if (!b(null))
    {
      QZLog.e("QZoneApiProxy", "file not exists");
      return false;
    }
    if (BaseApplicationImpl.isCurrentVersionFirstLaunch)
    {
      if (InstallPlugins.a == null)
      {
        i = Build.VERSION.SDK_INT;
        if ((i == 21) || (i == 22))
        {
          QZLog.e("QZoneApiProxy", "isQZonePluginValid null install result");
          return false;
        }
      }
      else if (!InstallPlugins.a.jdField_a_of_type_Boolean)
      {
        QZLog.i("QZoneApiProxy", "isQZonePluginValid qzone install failed");
        return false;
      }
      try
      {
        QzonePluginProxyActivity.a(BaseApplicationImpl.getApplication());
        if ((!b(paramActivity, paramQQAppInterface)) || (!a(paramActivity, paramQQAppInterface)))
        {
          QZLog.e("QZoneApiProxy", "initServlet erro");
          return false;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("QZoneApiProxy", 1, "needShowQzoneFrame", paramActivity);
        return false;
      }
      return true;
    }
    if ((b(paramActivity, paramQQAppInterface)) && (a(paramActivity, paramQQAppInterface))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blvu
 * JD-Core Version:    0.7.0.1
 */