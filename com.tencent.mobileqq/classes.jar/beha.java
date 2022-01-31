import android.app.Activity;
import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class beha
  implements besi
{
  private begz a;
  
  public beha(begz parambegz)
  {
    this.a = parambegz;
  }
  
  public Activity a()
  {
    return this.a.a();
  }
  
  public beru a()
  {
    MiniAppInfo localMiniAppInfo = a();
    if (localMiniAppInfo == null)
    {
      besl.c("MiniRuntime", "getShareState. Failed to get share state, mini app info is null");
      return null;
    }
    beru localberu = (beru)this.a.a(bejr.a());
    if ((localMiniAppInfo.verType != 3) || (bfgt.b()))
    {
      localberu.b = true;
      localberu.c = true;
    }
    if (belj.a("MiniApp", "mini_app_share_to_wx_switcher", 1) != 1)
    {
      localberu.f = false;
      localberu.g = false;
    }
    localberu.a = this.a.f();
    return localberu;
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
      this.a.a(bejv.a(14, localBundle));
      return;
    case 1: 
      this.a.a(bejv.a(2));
      return;
    case 2: 
      this.a.a(bejv.a(6));
      return;
    case 3: 
      this.a.a(bejv.a(7));
      return;
    case 4: 
      this.a.a(bejv.a(8));
      return;
    }
    this.a.a(bejv.a(13, paramBundle));
  }
  
  public boolean a()
  {
    return ((Boolean)this.a.a(bejx.a(2))).booleanValue();
  }
  
  public boolean b()
  {
    return ((Boolean)this.a.a(bejx.a(1))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beha
 * JD-Core Version:    0.7.0.1
 */