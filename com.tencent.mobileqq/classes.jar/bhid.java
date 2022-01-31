import android.content.Context;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;

@bglp(a="BaselibLoadAsyncTask")
public class bhid
  extends bhlt
{
  private BaselibLoader.BaselibContent a;
  
  public bhid(Context paramContext, bgun parambgun)
  {
    super(paramContext, parambgun);
  }
  
  public void a()
  {
    bhbs.a(204, "", a().getMiniAppInfoForReport());
    if (a().getMiniAppInfoForReport() != null) {}
    for (String str = a().getMiniAppInfoForReport().appId;; str = "")
    {
      QMLog.d("BaseRuntimeLoader", "startLoadBaseLib. appid:" + str);
      if (!a()) {
        break;
      }
      c();
      return;
    }
    bhck.a(bhcg.a(), 10, "0");
    AppLoaderFactory.g().getMiniAppEnv().getBaselibLoader().loadBaselib(a(), new bhie(this));
  }
  
  public boolean a()
  {
    return (this.a != null) && (this.a.isBaseLibInited());
  }
  
  public void b()
  {
    super.b();
    this.a = null;
  }
  
  public void c()
  {
    super.c();
    bhbs.a(205, "", a().getMiniAppInfoForReport());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhid
 * JD-Core Version:    0.7.0.1
 */