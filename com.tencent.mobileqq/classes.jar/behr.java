import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class behr
  implements besz
{
  private behq a;
  
  public behr(behq parambehq)
  {
    this.a = parambehq;
  }
  
  public Activity a()
  {
    return this.a.a();
  }
  
  public besl a()
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null)
    {
      betc.c("MiniRuntime", "getShareState. Failed to get share state, mini app info is null");
      return null;
    }
    besl localbesl = (besl)this.a.a(beki.a());
    if ((localMiniAppInfo.verType != 3) || (bfhk.b()))
    {
      localbesl.b = true;
      localbesl.c = true;
    }
    if (bema.a("MiniApp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localbesl.f = false;
      localbesl.g = false;
    }
    localbesl.a = this.a.f();
    return localbesl;
  }
  
  public MiniAppInfo a()
  {
    return this.a.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      Bundle localBundle = paramBundle;
      if (paramBundle == null) {
        localBundle = new Bundle();
      }
      localBundle.putInt("id", paramInt);
      this.a.a(bekm.a(14, localBundle));
      return;
    case 1: 
      this.a.a(bekm.a(2));
      return;
    case 2: 
      this.a.a(bekm.a(6));
      return;
    case 3: 
      this.a.a(bekm.a(7));
      return;
    case 4: 
      this.a.a(bekm.a(8));
      return;
    }
    this.a.a(bekm.a(13, paramBundle));
  }
  
  public boolean a()
  {
    return ((Boolean)this.a.a(beko.a(2))).booleanValue();
  }
  
  public boolean b()
  {
    return ((Boolean)this.a.a(beko.a(1))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     behr
 * JD-Core Version:    0.7.0.1
 */