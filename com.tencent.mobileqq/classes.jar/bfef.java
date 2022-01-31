import android.content.Context;
import android.content.res.AssetManager;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;
import java.io.File;
import java.lang.reflect.Method;

@behk(a="RuntimeCreateTask")
public class bfef
  extends bffk
{
  bfbi jdField_a_of_type_Bfbi;
  private boolean jdField_a_of_type_Boolean;
  
  public bfef(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
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
      betc.d("Tools.isFileExists", "" + paramString.getMessage());
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
        betc.d("miniapp-start-TISSUE", "loadAsset", paramString);
      }
      catch (Exception paramString)
      {
        try
        {
          betc.a("miniapp-start-TISSUE", String.format("load asset file %s cost %s ms", new Object[] { paramString, Long.valueOf(l2 - l1) }));
          bool = true;
          if (betc.a()) {
            betc.a("miniapp-start-TISSUE", String.format("loadAssetRes, isSuccess: %s", new Object[] { Boolean.valueOf(bool) }));
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
      betc.d("miniapp-start-TISSUE", String.format("assetsPath: %s not exist", new Object[] { paramString }));
      bool = true;
    }
  }
  
  public bfbi a()
  {
    return this.jdField_a_of_type_Bfbi;
  }
  
  public void a()
  {
    beyq.a(200, "", a().getMiniAppInfoForReport());
    if (this.jdField_a_of_type_Bfbi != null)
    {
      c();
      return;
    }
    if ((beku.a != null) && (!b(beku.a.getNativeLibDir())))
    {
      this.jdField_a_of_type_Boolean = false;
      betc.d("miniapp-start-TISSUE", "flutter loadAssetRes failed!!! enableFlutter=false");
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bfbi = new bfbg();
        this.jdField_a_of_type_Bfbi.a(a());
        c();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      betc.d("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
      f();
      return;
    }
    this.jdField_a_of_type_Bfbi = new bfbk();
    this.jdField_a_of_type_Bfbi.a(a());
    Object localObject = beku.a;
    if (localObject != null) {}
    try
    {
      FlutterMain.setNativeLibDir(beku.a.getNativeLibDir());
      FlutterMain.startInitialization(a().getApplicationContext());
      FlutterMain.ensureInitializationComplete(a().getApplicationContext(), null);
      label170:
      localObject = new FlutterNativeView(a().getApplicationContext());
      ((bfbk)this.jdField_a_of_type_Bfbi).a((FlutterNativeView)localObject);
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
  
  public void aU_()
  {
    beyq.a(221, "", a().getMiniAppInfoForReport());
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bfbi = null;
  }
  
  public void c()
  {
    super.c();
    beyq.a(201, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfef
 * JD-Core Version:    0.7.0.1
 */