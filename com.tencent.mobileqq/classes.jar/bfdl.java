import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

@begt(a="BaselibLoadAsyncTask")
public class bfdl
  extends bfeq
{
  private besc a;
  
  public bfdl(Context paramContext, bepv parambepv)
  {
    super(paramContext, parambepv);
  }
  
  public void a()
  {
    bexz.a(204, "", a().getMiniAppInfoForReport());
    besl.a("AppRuntimeLoader", "startLoadBaseLib.");
    if (a())
    {
      c();
      return;
    }
    beyr.a(beyn.a(), 10, "0");
    MiniAppEnv.g().getBaselibLoader().loadBaselib(a(), new bfdm(this));
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.a());
  }
  
  public void b()
  {
    super.b();
    this.a = null;
  }
  
  public void c()
  {
    super.c();
    bexz.a(205, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfdl
 * JD-Core Version:    0.7.0.1
 */