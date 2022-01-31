import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;
import com.tencent.qqmini.sdk.log.QMLog;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import java.io.File;
import java.lang.reflect.Method;

@bghi(a="RuntimeCreateTask")
public class bhea
  extends bhhp
{
  bhar jdField_a_of_type_Bhar;
  private boolean jdField_a_of_type_Boolean;
  
  public bhea(Context paramContext, bgqg parambgqg)
  {
    super(paramContext, parambgqg);
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (paramString.length() <= 0) {}
    }
    try
    {
      bool1 = new File(paramString).exists();
      return bool1;
    }
    catch (Exception paramString)
    {
      QMLog.e("Tools.isFileExists", "" + paramString.getMessage());
    }
    return false;
  }
  
  private boolean b(String paramString)
  {
    paramString = paramString + "/res.apk";
    if (a(paramString)) {}
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        AssetManager localAssetManager = a().getAssets();
        Method localMethod = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
        localMethod.setAccessible(true);
        localMethod.invoke(localAssetManager, new Object[] { paramString });
        long l2 = System.currentTimeMillis();
        QMLog.e("miniapp-start-TISSUE", "loadAsset", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          QMLog.d("miniapp-start-TISSUE", String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
          bool = true;
          if (QMLog.isColorLevel()) {
            QMLog.d("miniapp-start-TISSUE", String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
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
      QMLog.e("miniapp-start-TISSUE", String.format("assetsPath: %s not exist", new Object[] { paramString }));
      bool = true;
    }
  }
  
  public bhar a()
  {
    return this.jdField_a_of_type_Bhar;
  }
  
  public void a()
  {
    bgxl.a(200, "", a().getMiniAppInfoForReport());
    if (this.jdField_a_of_type_Bhar != null)
    {
      c();
      return;
    }
    if ((TissueGlobal.tissueEnv != null) && (!b(TissueGlobal.tissueEnv.getNativeLibDir())))
    {
      this.jdField_a_of_type_Boolean = false;
      QMLog.e("miniapp-start-TISSUE", "flutter loadAssetRes failed!!! enableFlutter=false");
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bhar = new bhap();
        this.jdField_a_of_type_Bhar.a(a());
        c();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
      e();
      return;
    }
    this.jdField_a_of_type_Bhar = new bhat();
    this.jdField_a_of_type_Bhar.a(a());
    Object localObject = TissueGlobal.tissueEnv;
    if (localObject != null) {}
    try
    {
      FlutterMain.setNativeLibDir(TissueGlobal.tissueEnv.getNativeLibDir());
      FlutterMain.startInitialization(a().getApplicationContext());
      FlutterMain.ensureInitializationComplete(a().getApplicationContext(), null);
      label170:
      localObject = new FlutterNativeView(a().getApplicationContext());
      ((bhat)this.jdField_a_of_type_Bhar).a((FlutterNativeView)localObject);
      c();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label170;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bhar = null;
  }
  
  public void c()
  {
    super.c();
    bgxl.a(201, "", a().getMiniAppInfoForReport());
  }
  
  public void d()
  {
    bgxl.a(221, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhea
 * JD-Core Version:    0.7.0.1
 */