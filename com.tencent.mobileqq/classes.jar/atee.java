import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.intervideo.nowproxy.customized_interface.IShadow;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.now.dynamic.NowShadowImpl.1;
import com.tencent.mobileqq.intervideo.now.dynamic.NowShadowImpl.2;
import com.tencent.shadow.dynamic.host.EnterCallback;
import java.util.concurrent.ExecutorService;

public class atee
  implements IShadow
{
  private aszg a;
  
  private void a(String paramString)
  {
    try
    {
      ateg.a().a().b("enter_shadow_err").c(paramString).b();
      ThreadManagerV2.getUIHandlerV2().post(new NowShadowImpl.2(this));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public aszg a(Context paramContext, String paramString1, String paramString2)
  {
    return aszp.a(paramContext, paramString1, paramString2);
  }
  
  public void enter(Context paramContext, long paramLong, String paramString1, String paramString2, Bundle paramBundle, EnterCallback paramEnterCallback)
  {
    amdp.b(192).execute(new NowShadowImpl.1(this, paramContext, paramString1, paramString2, paramLong, paramBundle, paramEnterCallback));
  }
  
  public boolean hasPluginManager()
  {
    return this.a != null;
  }
  
  public void setILoggerFactory() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atee
 * JD-Core Version:    0.7.0.1
 */