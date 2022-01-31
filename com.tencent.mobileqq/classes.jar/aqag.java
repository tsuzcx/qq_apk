import android.content.res.AssetManager;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.FlutterBoost.ConfigBuilder;
import com.qflutter.qflutter_skin_engine.QFlutterSkinEngine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.engine.QFlutterEngineEnv.2;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import io.flutter.embedding.android.FlutterView.RenderMode;
import io.flutter.view.FlutterMain;
import java.io.File;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import mqq.os.MqqHandler;

public class aqag
{
  public static volatile int a;
  private static final String jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + File.separator + "qflutter-so" + File.separator;
  private static List<aqae> jdField_a_of_type_JavaUtilList;
  private static boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_JavaUtilList = new Vector();
  }
  
  private static void a()
  {
    
    if (!QIPCClientHelper.getInstance().getClient().callServer("FlutterMainQIPCModule", "ACTION_INSTALL_ENGINE", null).isSuccess())
    {
      QLog.d("QFlutter.engine", 1, "install IPC fail");
      aqam.b();
      a(-2);
    }
  }
  
  private static void a(int paramInt)
  {
    QLog.d("QFlutter.engine", 1, String.format("notifyResult, errorCode: %s", new Object[] { Integer.valueOf(paramInt) }));
    if (jdField_a_of_type_JavaUtilList.size() > 0)
    {
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext()) {
          ((aqae)localIterator.next()).a(paramInt);
        }
      }
      jdField_a_of_type_JavaUtilList.clear();
      if (paramInt == 0) {}
      for (jdField_a_of_type_Int = 2;; jdField_a_of_type_Int = 0) {
        return;
      }
    }
  }
  
  public static void a(aqae paramaqae)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      if (!jdField_a_of_type_JavaUtilList.contains(paramaqae)) {
        jdField_a_of_type_JavaUtilList.add(paramaqae);
      }
      return;
    }
  }
  
  public static void a(boolean paramBoolean1, String arg1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramBoolean1) && (apvb.a(???))) {
      ThreadManager.getUIHandler().post(new QFlutterEngineEnv.2(???));
    }
    for (;;)
    {
      aqam.b();
      if (QLog.isColorLevel()) {
        QLog.d("QFlutter.engine", 2, String.format("onInstallCallback, engineDir: %s", new Object[] { ??? }));
      }
      if (jdField_a_of_type_JavaUtilList.size() <= 0) {
        return;
      }
      synchronized (jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        ((aqae)localIterator.next()).a(paramBoolean1, paramBoolean2, paramBoolean3);
      }
      QLog.d("QFlutter.engine", 1, "download success but engine not exist");
      a(-2);
    }
  }
  
  private static boolean a()
  {
    if (!jdField_a_of_type_Boolean) {
      return false;
    }
    String str1 = "";
    File localFile = new File(ajsf.aV, "qflutter");
    QLog.d("QFlutter.engine", 4, String.format("checkDebugMode, inDir: %s, outDir: %s", new Object[] { localFile.getAbsolutePath(), jdField_a_of_type_JavaLangString }));
    String str2 = str1;
    if (localFile.exists())
    {
      int i = bbdj.a(localFile.getAbsolutePath(), jdField_a_of_type_JavaLangString + "/", false, true, true);
      if (i == 0) {
        str1 = jdField_a_of_type_JavaLangString;
      }
      QLog.d("QFlutter.engine", 4, String.format("debugDir: file list: %s, copy result: %s", new Object[] { new File(jdField_a_of_type_JavaLangString).list(), Integer.valueOf(i) }));
      str2 = str1;
    }
    QLog.d("QFlutter.engine", 4, String.format("checkDebugMode: %s", new Object[] { str2 }));
    if (apvb.a(str2))
    {
      QLog.d("QFlutter.engine", 1, "use debug product");
      b(str2);
      bcpw.a(BaseApplicationImpl.getContext(), 0, 2131698235, 0).a();
      return true;
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    paramString = paramString + File.separator + "res.apk";
    if (apvb.a(paramString)) {}
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        AssetManager localAssetManager = BaseApplicationImpl.getContext().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { paramString });
        long l2 = System.currentTimeMillis();
        QLog.e("QFlutter.engine", 1, "loadAsset", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          QLog.d("QFlutter.engine", 1, String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
          bool = true;
          if (QLog.isColorLevel()) {
            QLog.d("QFlutter.engine", 2, String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
          }
          return bool;
        }
        catch (Exception paramString)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
        paramString = paramString;
        bool = false;
      }
      continue;
      QLog.e("QFlutter.engine", 1, String.format("assetsPath: %s not exist", new Object[] { paramString }));
      bool = false;
    }
  }
  
  public static void b(aqae paramaqae)
  {
    synchronized (jdField_a_of_type_JavaUtilList)
    {
      jdField_a_of_type_JavaUtilList.remove(paramaqae);
      return;
    }
  }
  
  private static void b(String arg0)
  {
    System.currentTimeMillis();
    FlutterMain.setNativeLibDir(???);
    int i;
    if (a(???))
    {
      com.tencent.qflutter.utils.FLog.sLog = new aqai();
      QFlutterSkinEngine.get().init(BaseApplicationImpl.getContext(), new aqad(BaseApplicationImpl.getContext()));
      ??? = new aqah();
      QFlutterSkinEngine.get().setCurrentThemeId(ThemeUtil.getCurrentThemeId());
      ??? = new FlutterBoost.ConfigBuilder(BaseApplicationImpl.getApplication(), aqaf.a()).isDebug(false).whenEngineStart(FlutterBoost.ConfigBuilder.IMMEDIATELY).renderMode(FlutterView.RenderMode.texture).pluginsRegister(???).build();
      FlutterBoost.instance().init(???);
      FlutterBoost.instance().boostPluginRegistry();
      i = 0;
      if (jdField_a_of_type_JavaUtilList.size() <= 0) {}
    }
    else
    {
      for (;;)
      {
        synchronized (jdField_a_of_type_JavaUtilList)
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
          if (!localIterator.hasNext()) {
            break label191;
          }
          aqae localaqae = (aqae)localIterator.next();
          if (i != 0) {
            break label186;
          }
          bool = true;
          localaqae.a(bool);
        }
        i = -1;
        break;
        label186:
        boolean bool = false;
      }
    }
    label191:
    a(i);
  }
  
  public static void c(aqae paramaqae)
  {
    if (jdField_a_of_type_Int == 2) {
      paramaqae.a(0);
    }
    do
    {
      do
      {
        return;
        a(paramaqae);
      } while (jdField_a_of_type_Int != 0);
      jdField_a_of_type_Int = 1;
    } while (a());
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqag
 * JD-Core Version:    0.7.0.1
 */