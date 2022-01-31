import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.minigame.GameRuntime.2.1;

public class beva
  implements ITTEngine.IListener
{
  beva(beuy parambeuy) {}
  
  public void onFirstRender()
  {
    betc.b("GameRuntime", "onFirstRender");
    this.a.a(bekc.a(2021));
    beuy.a(this.a, System.currentTimeMillis());
    if (beuy.a(this.a))
    {
      beuy.a(this.a, false);
      betc.b("GameRuntime", "game[" + beuy.a(this.a).appId + "][" + beuy.a(this.a).name + "] 冷启动，首帧出现!");
      bezi.a(beuy.a(this.a), 1022, "1");
    }
    for (;;)
    {
      long l1 = beuy.b(this.a);
      long l2 = beuy.c(this.a);
      bezi.a(beuy.a(this.a), 1042, null, null, null, 0, "1", l1 - l2, null);
      behm.a(beuy.b(this.a));
      beuy.a(this.a).post(new GameRuntime.2.1(this));
      return;
      betc.b("GameRuntime", "game[" + beuy.a(this.a).appId + "][" + beuy.a(this.a).name + "] 热启动,二次启动游戏!");
      bezi.a(beuy.a(this.a), 1023, "1");
      bewe.a(beuy.a(this.a), beuy.a(this.a));
    }
  }
  
  public void onGameLaunched(int paramInt, long paramLong)
  {
    beuy.b(this.a, System.currentTimeMillis());
    bezi.a(beuy.a(this.a), 1040, null, null, null, 0, "1", paramLong, null);
    beqf.a().a(63, new Object[] { Integer.valueOf(paramInt) });
    beyq.a("2load_end", String.valueOf(beuy.a(this.a)), null, beuy.a(this.a));
    if (beuy.a(this.a) >= 0)
    {
      MiniAppInfo localMiniAppInfo = beuy.a(this.a);
      if (beuy.a(this.a)) {}
      for (String str = "1";; str = "0")
      {
        bezi.b(localMiniAppInfo, 1008, str);
        bezi.a(beuy.a(this.a), 1008, "1");
        return;
      }
    }
    bezl.a(beuy.a(this.a), "1", null, "show_fail", "load_pkg_fail");
    beyq.a("2launch_fail", "load_pkg_fail", null, beuy.a(this.a));
    beyv.a(bevz.a().a(), 512);
  }
  
  public void onInitFinish()
  {
    betc.b("GameRuntime", "onInitFinish");
    long l1 = System.currentTimeMillis();
    long l2 = beuy.a(this.a);
    bezi.a(beuy.a(this.a), 1039, null, null, null, 0, "1", l1 - l2, null);
    this.a.f();
    beuy.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beva
 * JD-Core Version:    0.7.0.1
 */