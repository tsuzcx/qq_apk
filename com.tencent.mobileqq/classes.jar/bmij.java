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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.pluginsdk.PluginManagerClient;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper;
import com.tencent.mobileqq.pluginsdk.PluginManagerHelper.OnPluginManagerLoadedListener;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginInfo;
import cooperation.smartdevice.ipc.SmartDeviceProxyService;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import mqq.app.AppRuntime;

public class bmij
  extends Observable
  implements Handler.Callback, PluginManagerHelper.OnPluginManagerLoadedListener
{
  private static bmij jdField_a_of_type_Bmij;
  private static String jdField_a_of_type_JavaLangString = "SmartDevicePluginLoader";
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Context jdField_a_of_type_AndroidContentContext;
  private bisl jdField_a_of_type_Bisl;
  private bkyc jdField_a_of_type_Bkyc = new bkyc(Looper.getMainLooper(), this);
  private blwh jdField_a_of_type_Blwh;
  private PluginManagerClient jdField_a_of_type_ComTencentMobileqqPluginsdkPluginManagerClient;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private blwh jdField_b_of_type_Blwh;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public static bmij a()
  {
    if (jdField_a_of_type_Bmij == null) {
      jdField_a_of_type_Bmij = new bmij();
    }
    return jdField_a_of_type_Bmij;
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
    this.jdField_a_of_type_Blwh = null;
    this.jdField_a_of_type_AndroidAppActivity = null;
    this.jdField_b_of_type_Blwh = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    b(paramInt);
    String str = anvx.a(2131713664);
    if (-4 == paramInt) {
      str = anvx.a(2131713659);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] handleFailed errCode:" + str);
      }
      return;
      if (-5 == paramInt) {
        str = anvx.a(2131713661);
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
        this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1001, 400L);
        return;
      }
      a(-1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] queryPluginInfo mState : " + paramPluginBaseInfo.mState + " progress:" + paramPluginBaseInfo.mDownloadProgress);
    }
    if ((-2 != paramPluginBaseInfo.mState) && (4 != paramPluginBaseInfo.mState) && (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext())) && (System.currentTimeMillis() - this.jdField_a_of_type_Long > 5000L))
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
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1001, 400L);
      return;
    case 3: 
      if (i != 0)
      {
        a(-5);
        return;
      }
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1001, 400L);
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
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1002, 2000L);
    }
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.compareToIgnoreCase("launchService") == 0))
    {
      this.jdField_b_of_type_JavaLangString = null;
      if ((this.jdField_a_of_type_AndroidContentContext != null) && (this.jdField_b_of_type_Blwh != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginService:");
        }
        blvy.c(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Blwh);
        this.jdField_b_of_type_Blwh = null;
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
    paramAppRuntime = new bisl(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299080));
    if ((!bool) || (paramOnDismissListener != null))
    {
      paramAppRuntime.a(anvx.a(2131713657));
      paramAppRuntime.setOnDismissListener(new bmik(this, paramOnDismissListener));
      if (bool) {
        paramAppRuntime.setOnShowListener(new bmil(this, paramAppRuntime));
      }
    }
    for (;;)
    {
      paramOnDismissListener = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ((abgm)paramOnDismissListener.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b();
      paramIntent.putExtra("userQqResources", 2);
      paramIntent.putExtra("useSkinEngine", true);
      paramIntent.putExtra("param_plugin_gesturelock", true);
      this.jdField_a_of_type_Blwh = new blwh(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Blwh.jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
      this.jdField_a_of_type_Blwh.d = PluginInfo.e;
      this.jdField_a_of_type_Blwh.jdField_a_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_Blwh.e = paramString2;
      this.jdField_a_of_type_Blwh.jdField_a_of_type_JavaLangClass = paramClass;
      this.jdField_a_of_type_Blwh.jdField_a_of_type_AndroidContentIntent = paramIntent;
      this.jdField_a_of_type_Blwh.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_Blwh.jdField_a_of_type_AndroidAppDialog = paramAppRuntime;
      this.jdField_a_of_type_Blwh.c = 10000;
      this.jdField_a_of_type_Blwh.f = null;
      this.jdField_a_of_type_AndroidAppActivity = paramActivity;
      if (!this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Boolean = a(paramOnDismissListener);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginActivity: plugin is installed " + this.jdField_a_of_type_Blwh.e);
        }
        if (bool)
        {
          blvy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Blwh);
          this.jdField_a_of_type_AndroidAppActivity = null;
          this.jdField_a_of_type_Blwh = null;
          return;
        }
        if (this.jdField_a_of_type_Bisl == null)
        {
          this.jdField_a_of_type_Bisl = new bisl(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299080));
          this.jdField_a_of_type_Bisl.a(anvx.a(2131713658));
        }
        this.jdField_a_of_type_Bisl.show();
        this.c = "openActivity";
        b();
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginActivity: waiting for plugin to install " + this.jdField_a_of_type_Blwh.e);
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
    this.jdField_b_of_type_Blwh = new blwh(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Blwh.jdField_b_of_type_JavaLangString = "qqsmartdevice.apk";
    this.jdField_b_of_type_Blwh.d = PluginInfo.e;
    this.jdField_b_of_type_Blwh.jdField_a_of_type_JavaLangString = paramAppRuntime.getAccount();
    this.jdField_b_of_type_Blwh.e = "com.tencent.device.ipc.QQSmartDeviceService";
    this.jdField_b_of_type_Blwh.jdField_a_of_type_AndroidContentIntent = localIntent;
    this.jdField_b_of_type_Blwh.jdField_a_of_type_AndroidContentServiceConnection = paramServiceConnection;
    this.jdField_a_of_type_AndroidContentContext = paramAppRuntime.getApplication();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader] launchPluginService directly");
      }
      blvy.c(paramAppRuntime.getApplication(), this.jdField_b_of_type_Blwh);
      this.jdField_b_of_type_Blwh = null;
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
    paramQQAppInterface = (blvy)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
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
      if ((this.jdField_a_of_type_AndroidAppActivity != null) && (this.jdField_a_of_type_Blwh != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "[SmartDevicePluginLoader]  launchPluginActivity:" + this.jdField_a_of_type_Blwh.e);
        }
        blvy.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Blwh);
      }
      this.jdField_a_of_type_AndroidAppActivity = null;
      this.jdField_a_of_type_Blwh = null;
      this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1003, 600L);
      continue;
      if (this.jdField_a_of_type_Bisl != null)
      {
        this.jdField_a_of_type_Bisl.hide();
        this.jdField_a_of_type_Bisl = null;
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
        this.jdField_a_of_type_Bkyc.sendEmptyMessageDelayed(1001, 400L);
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
 * Qualified Name:     bmij
 * JD-Core Version:    0.7.0.1
 */