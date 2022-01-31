import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

@bdcu(a="BaselibLoadAsyncTask")
public class bdwx
  extends bdxy
{
  private bdnn a;
  
  public bdwx(Context paramContext, bdlq parambdlq)
  {
    super(paramContext, parambdlq);
  }
  
  public void a()
  {
    bdsc.a(204, "", a().getMiniAppInfoForReport());
    bdnw.a("AppRuntimeLoader", "startLoadBaseLib.");
    if (a())
    {
      c();
      return;
    }
    bdsu.a(bdsq.a(), 10, "0");
    MiniAppEnv.g().getBaselibLoader().loadBaselib(a(), new bdwy(this));
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
    bdsc.a(205, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdwx
 * JD-Core Version:    0.7.0.1
 */