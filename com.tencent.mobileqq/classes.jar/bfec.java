import android.content.Context;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

@behk(a="BaselibLoadAsyncTask")
public class bfec
  extends bffh
{
  private best a;
  
  public bfec(Context paramContext, beqm parambeqm)
  {
    super(paramContext, parambeqm);
  }
  
  public void a()
  {
    beyq.a(204, "", a().getMiniAppInfoForReport());
    betc.a("AppRuntimeLoader", "startLoadBaseLib.");
    boolean bool = a();
    if (a().getMiniAppInfoForReport() != null) {}
    for (String str = a().getMiniAppInfoForReport().appId; bool; str = "")
    {
      c();
      return;
    }
    bezi.a(beze.a(), 10, "0");
    beys.b(str, true);
    MiniAppEnv.g().getBaselibLoader().loadBaselib(a(), new bfed(this));
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
    beyq.a(205, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfec
 * JD-Core Version:    0.7.0.1
 */