import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class aovt
{
  private static String jdField_a_of_type_JavaLangString = "en.lang";
  private static String b = "en-release.zip";
  private aovs jdField_a_of_type_Aovs;
  private aovw jdField_a_of_type_Aovw;
  
  public static aovt a()
  {
    return aovu.a();
  }
  
  private static String a()
  {
    File localFile = new File(BaseApplicationImpl.getApplication().getFilesDir(), "/multi_language");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile.getAbsolutePath() + File.separator;
  }
  
  private void a(Context paramContext, String paramString)
  {
    long l;
    String str;
    if (!new File(paramString).exists())
    {
      QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLanguage need unzip:", b });
      l = System.currentTimeMillis();
      paramString = "language" + File.separator + b;
      str = a() + b;
      bhmi.a(paramContext, paramString, str);
    }
    try
    {
      nof.a(new File(str), a());
      if (QLog.isColorLevel()) {
        QLog.e("MultiLanguageEngine", 2, new Object[] { "copy and unzip success! cost:", Long.valueOf(System.currentTimeMillis() - Long.valueOf(l).longValue()) });
      }
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    a(paramContext, paramString);
    try
    {
      long l = System.currentTimeMillis();
      AssetManager localAssetManager = (AssetManager)AssetManager.class.getConstructor(new Class[0]).newInstance(new Object[0]);
      Object localObject = AssetManager.class.getDeclaredMethod("addAssetPath", new Class[] { String.class });
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(localAssetManager, new Object[] { paramString });
      Resources localResources = new Resources(localAssetManager, this.jdField_a_of_type_Aovw.b().getDisplayMetrics(), this.jdField_a_of_type_Aovw.b().getConfiguration());
      localObject = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramString, 1);
      if (paramContext != null) {}
      for (paramContext = paramContext.packageName;; paramContext = (Context)localObject)
      {
        this.jdField_a_of_type_Aovw.a(localResources, paramContext);
        QLog.d("MultiLanguageEngine", 1, new Object[] { "loadLangPkg:", localAssetManager.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
        return true;
        QLog.d("MultiLanguageEngine", 1, "pkgInfo is null");
      }
      return false;
    }
    catch (Exception paramContext)
    {
      QLog.d("MultiLanguageEngine", 1, paramContext, new Object[0]);
    }
  }
  
  private void e(Context paramContext)
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject1 = Class.forName("android.app.ContextImpl");
      Object localObject2 = ((Class)localObject1).getDeclaredField("mResources");
      ((Field)localObject2).setAccessible(true);
      Object localObject3 = ((Field)localObject2).get(paramContext);
      ((Field)localObject2).set(paramContext, this.jdField_a_of_type_Aovs);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate ContextImpl resources:", this.jdField_a_of_type_Aovs.toString(), " ,old:", localObject3.toString() });
      localObject1 = ((Class)localObject1).getDeclaredField("mPackageInfo");
      ((Field)localObject1).setAccessible(true);
      paramContext = ((Field)localObject1).get(paramContext);
      localObject1 = Class.forName("android.app.LoadedApk").getDeclaredField("mResources");
      ((Field)localObject1).setAccessible(true);
      localObject2 = ((Field)localObject1).get(paramContext);
      ((Field)localObject1).set(paramContext, this.jdField_a_of_type_Aovs);
      QLog.d("MultiLanguageEngine", 1, new Object[] { "success in delegate LoadedApk resources:", this.jdField_a_of_type_Aovs.toString(), " ,old:", localObject2.toString(), " ,cost:", Long.valueOf(System.currentTimeMillis() - l) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (aobf.a()) {}
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      LayoutInflater.from(paramActivity).setFactory2(new aovv(paramActivity));
    } while (!QLog.isColorLevel());
    QLog.d("MultiLanguageEngine", 2, new Object[] { "register cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void a(Context paramContext)
  {
    boolean bool = false;
    if (!aobf.a()) {
      bool = true;
    }
    QLog.d("MultiLanguageEngine", 1, new Object[] { "initAndDelegate:", Boolean.valueOf(bool), ", context:", paramContext });
    if (paramContext == null) {}
    while (aobf.a()) {
      return;
    }
    this.jdField_a_of_type_Aovw = new aovw(paramContext);
    this.jdField_a_of_type_Aovs = new aovs(this.jdField_a_of_type_Aovw);
    e(paramContext);
  }
  
  public void b(Context paramContext)
  {
    if (aobf.b()) {
      a(paramContext, a() + jdField_a_of_type_JavaLangString);
    }
    while (this.jdField_a_of_type_Aovw == null) {
      return;
    }
    this.jdField_a_of_type_Aovw.a(null, null);
  }
  
  public void c(Context paramContext)
  {
    long l = System.currentTimeMillis();
    bhmi.a(a());
    b(paramContext);
    QLog.d("MultiLanguageEngine", 1, new Object[] { "update lang pkg! cost:", Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void d(Context paramContext)
  {
    a(paramContext, a() + jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovt
 * JD-Core Version:    0.7.0.1
 */