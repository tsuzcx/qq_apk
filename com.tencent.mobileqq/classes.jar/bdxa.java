import android.content.Context;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterNativeView;

@bdcu(a="RuntimeCreateTask")
public class bdxa
  extends bdyb
{
  bduj jdField_a_of_type_Bduj;
  private boolean jdField_a_of_type_Boolean;
  
  public bdxa(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public bduj a()
  {
    return this.jdField_a_of_type_Bduj;
  }
  
  public void a()
  {
    bdsc.a(200, "", a().getMiniAppInfoForReport());
    if (this.jdField_a_of_type_Bduj != null)
    {
      c();
      return;
    }
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Bduj = new bduh();
        this.jdField_a_of_type_Bduj.a(a());
        c();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("minisdk-start", "RuntimeCreateTask exception!", localThrowable);
      f();
      return;
    }
    this.jdField_a_of_type_Bduj = new bdul();
    this.jdField_a_of_type_Bduj.a(a());
    Object localObject = bdgd.a;
    if (localObject != null) {}
    try
    {
      FlutterMain.setNativeLibDir(bdgd.a.getNativeLibDir());
      FlutterMain.startInitialization(a().getApplicationContext());
      FlutterMain.ensureInitializationComplete(a().getApplicationContext(), null);
      label137:
      localObject = new FlutterNativeView(a().getApplicationContext());
      ((bdul)this.jdField_a_of_type_Bduj).a((FlutterNativeView)localObject);
      c();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label137;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Bduj = null;
  }
  
  public void c()
  {
    super.c();
    bdsc.a(201, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdxa
 * JD-Core Version:    0.7.0.1
 */