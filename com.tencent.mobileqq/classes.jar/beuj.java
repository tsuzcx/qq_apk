import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntime.2.1;

public class beuj
  implements ITTEngine.IListener
{
  beuj(beuh parambeuh) {}
  
  public void onFirstRender()
  {
    besl.b("GameRuntime", "onFirstRender");
    this.a.a(bejl.a(2021));
    beuh.a(this.a, System.currentTimeMillis());
    if (beuh.a(this.a))
    {
      beuh.a(this.a, false);
      besl.b("GameRuntime", "game[" + beuh.a(this.a).appId + "][" + beuh.a(this.a).name + "] 冷启动，首帧出现!");
      beyr.a(beuh.a(this.a), 1022, "1");
    }
    for (;;)
    {
      long l1 = beuh.b(this.a);
      long l2 = beuh.c(this.a);
      beyr.a(beuh.a(this.a), 1042, null, null, null, 0, "1", l1 - l2, null);
      begv.a(beuh.b(this.a));
      beuh.a(this.a).post(new GameRuntime.2.1(this));
      return;
      besl.b("GameRuntime", "game[" + beuh.a(this.a).appId + "][" + beuh.a(this.a).name + "] 热启动,二次启动游戏!");
      beyr.a(beuh.a(this.a), 1023, "1");
      bevn.a(beuh.a(this.a), beuh.a(this.a));
    }
  }
  
  public void onGameLaunched(int paramInt, long paramLong)
  {
    beuh.b(this.a, System.currentTimeMillis());
    beyr.a(beuh.a(this.a), 1040, null, null, null, 0, "1", paramLong, null);
    bepo.a().a(63, new Object[] { Integer.valueOf(paramInt) });
    bexz.a("2load_end", String.valueOf(beuh.a(this.a)), null, beuh.a(this.a));
    if (beuh.a(this.a) >= 0)
    {
      MiniAppInfo localMiniAppInfo = beuh.a(this.a);
      if (beuh.a(this.a)) {}
      for (String str = "1";; str = "0")
      {
        beyr.b(localMiniAppInfo, 1008, str);
        beyr.a(beuh.a(this.a), 1008, "1");
        return;
      }
    }
    beyu.a(beuh.a(this.a), "1", null, "show_fail", "load_pkg_fail");
    bexz.a("2launch_fail", "load_pkg_fail", null, beuh.a(this.a));
    beye.a(bevi.a().a(), 512);
  }
  
  public void onInitFinish()
  {
    besl.b("GameRuntime", "onInitFinish");
    long l1 = System.currentTimeMillis();
    long l2 = beuh.a(this.a);
    beyr.a(beuh.a(this.a), 1039, null, null, null, 0, "1", l1 - l2, null);
    this.a.f();
    beuh.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beuj
 * JD-Core Version:    0.7.0.1
 */