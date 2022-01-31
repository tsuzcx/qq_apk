import android.content.Context;
import android.content.res.AssetManager;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import java.io.File;
import java.lang.reflect.Method;

@begt(a="RuntimeCreateTask")
public class bfdo
  extends bfet
{
  bfar jdField_a_of_type_Bfar;
  private boolean jdField_a_of_type_Boolean;
  
  public bfdo(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
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
      besl.d("Tools.isFileExists", "" + paramString.getMessage());
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
        besl.d("miniapp-start-TISSUE", "loadAsset", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          besl.a("miniapp-start-TISSUE", String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
          bool = true;
          if (besl.a()) {
            besl.a("miniapp-start-TISSUE", String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
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
      besl.d("miniapp-start-TISSUE", String.format("assetsPath: %s not exist", new Object[] { paramString }));
      bool = true;
    }
  }
  
  public bfar a()
  {
    return this.jdField_a_of_type_Bfar;
  }
  
  public void a()
  {
    bexz.a(200, "", a().getMiniAppInfoForReport());
    if (this.jdField_a_of_type_Bfar != null)
    {
      c();
      return;
    }
    if ((bekd.a != null) && (!b(bekd.a.getNativeLibDir())))
    {
      this.jdField_a_of_type_Boolean = false;
      besl.d("miniapp-start-TISSUE", "flutter loadAssetRes failed!!! enableFlutter=false");
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bfar = new bfap();
        this.jdField_a_of_type_Bfar.a(a());
        c();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      besl.d("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
      f();
      return;
    }
    this.jdField_a_of_type_Bfar = new bfat();
    this.jdField_a_of_type_Bfar.a(a());
    Object localObject = bekd.a;
    if (localObject != null) {}
    try
    {
      FlutterMain.setNativeLibDir(bekd.a.getNativeLibDir());
      FlutterMain.startInitialization(a().getApplicationContext());
      FlutterMain.ensureInitializationComplete(a().getApplicationContext(), null);
      label170:
      localObject = new FlutterNativeView(a().getApplicationContext());
      ((bfat)this.jdField_a_of_type_Bfar).a((FlutterNativeView)localObject);
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
    this.jdField_a_of_type_Bfar = null;
  }
  
  public void c()
  {
    super.c();
    bexz.a(201, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdo
 * JD-Core Version:    0.7.0.1
 */