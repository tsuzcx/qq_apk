import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.BoostLifecycleListener;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.qflutter.resource_loader.QFlutterResourceLoader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher.2;
import com.tencent.mobileqq.flutter.launch.QFlutterLauncher.4;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.view.FlutterMain;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class auxj
{
  private static auxj jdField_a_of_type_Auxj;
  private int jdField_a_of_type_Int = 0;
  private final Handler jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidOsLooper);
  private final Looper jdField_a_of_type_AndroidOsLooper = Looper.getMainLooper();
  private auxi jdField_a_of_type_Auxi = new auxi();
  private FlutterBoost.BoostLifecycleListener jdField_a_of_type_ComIdlefishFlutterboostFlutterBoost$BoostLifecycleListener = new auxl(this);
  private final Set<auxg> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  public static auxj a()
  {
    if (jdField_a_of_type_Auxj == null) {}
    try
    {
      if (jdField_a_of_type_Auxj == null) {
        jdField_a_of_type_Auxj = new auxj();
      }
      return jdField_a_of_type_Auxj;
    }
    finally {}
  }
  
  private void a()
  {
    if (Looper.myLooper() != this.jdField_a_of_type_AndroidOsLooper) {}
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("QFlutter.launcher", 1, String.format("notifyResult, errCode: %s, isFirstLaunch: %s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
    {
      b(paramInt, paramBoolean);
      return;
    }
    ThreadManager.getUIHandler().post(new QFlutterLauncher.4(this, paramInt, paramBoolean));
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, "start install");
    }
    this.jdField_a_of_type_Auxi.a();
    if (auxf.a())
    {
      this.jdField_a_of_type_Boolean = true;
      auxf.a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    auxe.a();
    Bundle localBundle = new Bundle();
    if (2 == BaseApplicationImpl.sProcessId) {
      localBundle.putString("FlutterCallerIpcProcessName", "com.tencent.mobileqq:qzone");
    }
    QIPCClientHelper.getInstance().getClient().callServer("FlutterMainQIPCModule", "ACTION_INSTALL_ENGINE", localBundle, new auxk(this));
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    if (paramInt == 0) {}
    for (this.jdField_a_of_type_Int = 2;; this.jdField_a_of_type_Int = 0)
    {
      auxh localauxh = new auxh(paramInt, paramBoolean, this.jdField_a_of_type_Boolean);
      if (paramBoolean)
      {
        this.jdField_a_of_type_Auxi.a(paramInt, this.jdField_a_of_type_Boolean);
        localauxh.a(this.jdField_a_of_type_Auxi);
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext()) {
        ((auxg)localIterator.next()).a(localauxh);
      }
    }
  }
  
  private void b(auxg paramauxg)
  {
    if (paramauxg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.add(paramauxg);
      return;
    }
  }
  
  public void a(auxg paramauxg)
  {
    if (paramauxg == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.remove(paramauxg);
      return;
    }
  }
  
  public void a(auxg paramauxg, boolean paramBoolean1, boolean paramBoolean2)
  {
    a();
    b(paramauxg);
    if (this.jdField_a_of_type_Int == 2)
    {
      QLog.d("QFlutter.launcher", 1, "engine is running");
      a(0, false);
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      QLog.d("QFlutter.launcher", 1, "engine is launching");
      return;
    }
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_Auxi.f();
    this.jdField_a_of_type_Auxi.a(paramBoolean1, paramBoolean2);
    b();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Auxi.b();
    String str = paramString + File.separator + "res.apk";
    if (auog.a(str)) {
      try
      {
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { str });
        this.jdField_a_of_type_Auxi.c();
        if (Looper.myLooper() == this.jdField_a_of_type_AndroidOsLooper)
        {
          b(paramString);
          return;
        }
        ThreadManager.getUIHandler().postAtFrontOfQueue(new QFlutterLauncher.2(this, paramString));
        return;
      }
      catch (Exception paramString)
      {
        QLog.e("QFlutter.launcher", 1, "loadAsset", paramString);
        a(5, true);
        return;
      }
    }
    QLog.e("QFlutter.launcher", 1, String.format("assetsPath: %s not exist", new Object[] { str }));
    a(4, true);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.launcher", 2, String.format("onInstallResult, isSuccess: %s, installDir: %s, isLocalEngineExist: %s, isLocalAppExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) }));
    }
    if ((paramBoolean1) && (auog.a(paramString)))
    {
      this.jdField_a_of_type_Auxi.b(paramBoolean2, paramBoolean3);
      a(paramString);
      return;
    }
    QLog.d("QFlutter.launcher", 1, String.format("onInstallResult, isSuccess: %s, installDir: %s, fileIsExist: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString, Boolean.valueOf(auog.a(paramString)) }));
    a(3, true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void b(String paramString)
  {
    a();
    this.jdField_a_of_type_Auxi.d();
    FlutterMain.setNativeLibDir(paramString);
    auxa.a(paramString);
    com.tencent.qflutter.utils.FLog.sLog = new auwy();
    QFlutterResourceLoader.get().init(BaseApplicationImpl.getContext(), new auxa(BaseApplicationImpl.getContext()));
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    paramString = new FlutterBoost.ConfigBuilder(BaseApplicationImpl.getApplication(), auwx.a()).isDebug(false).whenEngineStart(FlutterBoost.ConfigBuilder.IMMEDIATELY).renderMode(FlutterView.RenderMode.texture).lifecycleListener(this.jdField_a_of_type_ComIdlefishFlutterboostFlutterBoost$BoostLifecycleListener).build();
    try
    {
      FlutterBoost.instance().init(paramString);
      this.jdField_a_of_type_Auxi.e();
      a(0, true);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("QFlutter.launcher", 1, "loadEngine", paramString);
      a(6, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxj
 * JD-Core Version:    0.7.0.1
 */