import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.qq.jce.wup.BasicClassTypeUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.smartdevice.ipc.SmartDeviceProxyService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;

public class bkce
  extends Observable
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static bkce jdField_a_of_type_Bkce;
  private static String jdField_a_of_type_JavaLangString = "SmartDevicePluginLoader";
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private bety jdField_a_of_type_Bety;
  private bhsl jdField_a_of_type_Bhsl = new bhsl(Looper.getMainLooper(), this);
  private biqw jdField_a_of_type_Biqw;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private biqw jdField_b_of_type_Biqw;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public static bkce a()
  {
    if (jdField_a_of_type_Bkce == null) {
      jdField_a_of_type_Bkce = new bkce();
    }
    return jdField_a_of_type_Bkce;
  }
  
  public static AppInterface a(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    if ((paramBaseApplicationImpl == null) || (paramString == null)) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName("com.tencent.device.app.SmartDeviceAppInterface");
      if (localClass1 == null) {
        return null;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class localClass2;
      try
      {
        ClassLoader localClassLoader = a(paramBaseApplicationImpl);
        localClass2 = localClassLoader.loadClass("com.tencent.device.app.SmartDeviceAppInterface");
        BasicClassTypeUtil.setClassLoader(true, localClassLoader);
      }
      catch (ClassNotFoundException paramBaseApplicationImpl)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
      do
      {
        return null;
        paramBaseApplicationImpl = localClass2.getDeclaredConstructor(new Class[] { paramBaseApplicationImpl.getClass(), paramString.getClass() }).newInstance(new Object[] { paramBaseApplicationImpl, paramString });
      } while ((paramBaseApplicationImpl == null) || (!(paramBaseApplicationImpl instanceof AppInterface)));
      paramBaseApplicationImpl = (AppInterface)paramBaseApplicationImpl;
      return paramBaseApplicationImpl;
    }
    catch (IllegalArgumentException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (IllegalAccessException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InstantiationException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (InvocationTargetException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (NoSuchMethodException paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
    catch (Exception paramBaseApplicationImpl)
    {
      for (;;)
      {
        paramBaseApplicationImpl.printStackTrace();
      }
    }
  }
  
  public static ClassLoader a(Context paramContext)
  {
    return PluginStatic.getOrCreateClassLoader(paramContext, "qqsmartdevice.apk");
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] handleFailed errCode:" + paramInt);
    }
    this.jdField_a_of_type_Biqw = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_Biqw = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    b(paramInt);
    String str = alud.a(2131714608);
    if (-4 == paramInt) {
      str = alud.a(2131714603);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] handleFailed errCode:" + str);
      }
      return;
      if (-5 == paramInt) {
        str = alud.a(2131714605);
      }
    }
  }
  
  private void a(String paramString, PluginBaseInfo paramPluginBaseInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo!");
    }
    int i = 0;
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L) {
      i = 1;
    }
    if (paramPluginBaseInfo == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.isReady())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo is no ready and query it");
        }
        if (i != 0)
        {
          a(-5);
          return;
        }
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!bdin.g(BaseApplicationImpl.getContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
    {
      a(-4);
      return;
    }
    switch (paramPluginBaseInfo.mState)
    {
    default: 
      a(-3);
      return;
    case -1: 
      a(-6);
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qqsmartdevice.apk");
    case 1: 
    case 2: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 4: 
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] install plugin success");
      }
      this.jdField_a_of_type_Boolean = true;
      b(0);
      b();
      return;
    }
    a(-2);
  }
  
  private boolean a(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.iterator();
    while (paramContext.hasNext()) {
      if ("com.tencent.mobileqq:smartdevice".compareTo(((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName) == 0) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    if ((this.c != null) && (this.c.compareToIgnoreCase("openActivity") == 0))
    {
      this.c = null;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginActivity delay 2 second");
      }
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1002, 2000L);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.compareToIgnoreCase("launchService") == 0))
    {
      this.jdField_b_of_type_JavaLangString = null;
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_b_of_type_Biqw != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginService:");
        }
        biqn.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Biqw);
        this.jdField_b_of_type_Biqw = null;
        this.jdField_a_of_type_AndroidContentContext = null;
      }
    }
  }
  
  private void b(int paramInt)
  {
    super.setChanged();
    super.notifyObservers(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_b_of_type_Int = 0;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((!this.jdField_a_of_type_Boolean) && (!a(localQQAppInterface))) {
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
    }
  }
  
  public void a(Activity paramActivity, AppRuntime paramAppRuntime, String paramString1, Intent paramIntent, String paramString2, int paramInt, DialogInterface.OnDismissListener paramOnDismissListener, Class<? extends Activity> paramClass)
  {
    boolean bool = a(paramActivity);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "launchPluingActivityForResult.isPluginInstalled end: " + bool);
    }
    paramAppRuntime = new bety(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
    if ((!bool) || (paramOnDismissListener != null))
    {
      paramAppRuntime.a(alud.a(2131714601));
      paramAppRuntime.setOnDismissListener(new bkcf(this, paramOnDismissListener));
      if (bool) {
        paramAppRuntime.setOnShowListener(new bkcg(this, paramAppRuntime));
      }
    }
    for (;;)
    {
      paramOnDismissListener = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((ztp)paramOnDismissListener.a(51)).b();
      paramIntent.putExtra("userQqResources", 2);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("param_plugin_gesturelock", true);
      this.jdField_a_of_type_Biqw = new biqw(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Biqw.jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
      this.jdField_a_of_type_Biqw.d = PluginInfo.e;
      this.jdField_a_of_type_Biqw.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Biqw.e = paramString2;
      this.jdField_a_of_type_Biqw.jdField_a_of_type_JavaLangClass = paramClass;
      this.jdField_a_of_type_Biqw.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_a_of_type_Biqw.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Biqw.jdField_a_of_type_AndroidAppDialog = paramAppRuntime;
      this.jdField_a_of_type_Biqw.c = 10000;
      this.jdField_a_of_type_Biqw.f = null;
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = a(paramOnDismissListener);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginActivity: plugin is installed " + this.jdField_a_of_type_Biqw.e);
        }
        if (bool)
        {
          biqn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Biqw);
          this.jdField_a_of_type_AndroidAppActivity = null;
          this.jdField_a_of_type_Biqw = null;
          return;
        }
        if (this.jdField_a_of_type_Bety == null)
        {
          this.jdField_a_of_type_Bety = new bety(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131298914));
          this.jdField_a_of_type_Bety.a(alud.a(2131714602));
        }
        this.jdField_a_of_type_Bety.show();
        this.c = "openActivity";
        b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginActivity: waiting for plugin to install " + this.jdField_a_of_type_Biqw.e);
      }
      this.c = "openActivity";
      PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
      return;
      paramAppRuntime = null;
    }
  }
  
  public void a(AppRuntime paramAppRuntime, ServiceConnection paramServiceConnection)
  {
    Intent localIntent = new Intent(paramAppRuntime.getApplication(), SmartDeviceProxyService.class);
    localIntent.putExtra("userQqResources", 2);
    localIntent.putExtra("useSkinEngine", true);
    this.jdField_b_of_type_Biqw = new biqw(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Biqw.jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
    this.jdField_b_of_type_Biqw.d = PluginInfo.e;
    this.jdField_b_of_type_Biqw.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    this.jdField_b_of_type_Biqw.e = "com.tencent.device.ipc.QQSmartDeviceService";
    this.jdField_b_of_type_Biqw.jdField_a_of_type_AndroidContentIntent = localIntent;
    this.jdField_b_of_type_Biqw.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    this.jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginService directly");
      }
      biqn.c(paramAppRuntime.getApplication(), this.jdField_b_of_type_Biqw);
      this.jdField_b_of_type_Biqw = null;
      this.jdField_a_of_type_AndroidContentContext = null;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginService: waiting for plugin to install ");
    }
    this.jdField_b_of_type_JavaLangString = "launchService";
    PluginManagerHelper.getPluginInterface(BaseApplicationImpl.getContext(), this);
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (biqn)paramQQAppInterface.getManager(27);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a("qqsmartdevice.apk");
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.mState == 4;
      }
    }
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  ACTION_QUERY!");
      }
      a("qqsmartdevice.apk", this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qqsmartdevice.apk"));
      continue;
      b(0);
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_Biqw != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginActivity:" + this.jdField_a_of_type_Biqw.e);
        }
        biqn.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Biqw);
      }
      this.jdField_a_of_type_AndroidAppActivity = null;
      this.jdField_a_of_type_Biqw = null;
      this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1003, 600L);
      continue;
      if (this.jdField_a_of_type_Bety != null)
      {
        this.jdField_a_of_type_Bety.hide();
        this.jdField_a_of_type_Bety = null;
      }
    }
  }
  
  public void onPluginManagerLoaded(PluginManagerClient paramPluginManagerClient)
  {
    int i = 1;
    this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient = paramPluginManagerClient;
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded SUPPORT_NETWORKING:true");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient != null)
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      paramPluginManagerClient = this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.queryPlugin("qqsmartdevice.apk");
      if (paramPluginManagerClient == null) {
        break label206;
      }
      if (paramPluginManagerClient.mState == 4)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] plugin is installed");
        }
        this.jdField_a_of_type_Boolean = true;
        b(0);
        b();
      }
    }
    for (;;)
    {
      if (i == 0) {
        this.jdField_a_of_type_Bhsl.sendEmptyMessageDelayed(1001, 400L);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] onPluginManagerLoaded start down or install... retryCount: " + this.jdField_b_of_type_Int);
      }
      int j = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (j + 1);
      if (j < 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient.installPlugin("qqsmartdevice.apk");
        i = 0;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] not support networking");
        }
        this.jdField_a_of_type_Boolean = true;
        b(0);
        b();
        return;
        label206:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkce
 * JD-Core Version:    0.7.0.1
 */