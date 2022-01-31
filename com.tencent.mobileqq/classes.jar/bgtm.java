import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.GameRuntime.3.1;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class bgtm
  implements ITTEngine.IListener
{
  bgtm(bgtj parambgtj) {}
  
  public void onExit()
  {
    bgtj.a(this.a);
  }
  
  public void onFirstRender()
  {
    QMLog.i("GameRuntime", "onFirstRender. " + bgtj.a(this.a));
    if (bgtj.a(this.a) != null) {
      bgtj.a(this.a).b();
    }
    this.a.a(bghw.a(2032, Integer.valueOf(bgtj.b(this.a))));
    bgtj.a(this.a, System.currentTimeMillis());
    String str = bgtj.a(this.a);
    if (bgtj.a(this.a))
    {
      bgtj.a(this.a, false);
      QMLog.i("GameRuntime", "game[" + bgtj.a(this.a).appId + "][" + bgtj.a(this.a).name + "] 冷启动，首帧出现!");
      bgyd.a(bgtj.a(this.a), 1022, "1");
    }
    for (;;)
    {
      long l1 = bgtj.b(this.a);
      long l2 = bgtj.c(this.a);
      bgyd.a(bgtj.a(this.a), 1042, null, str, null, 0, "1", l1 - l2, null);
      bghk.a(bgtj.b(this.a));
      bgtj.a(this.a).post(new GameRuntime.3.1(this));
      return;
      QMLog.i("GameRuntime", "game[" + bgtj.a(this.a).appId + "][" + bgtj.a(this.a).name + "] 热启动,二次启动游戏!");
      bgyd.a(bgtj.a(this.a), 1023, "1");
      bguz.a(bgtj.a(this.a), bgtj.a(this.a));
    }
  }
  
  public void onGameLaunched(int paramInt, long paramLong)
  {
    Object localObject = this.a;
    int i;
    MiniAppInfo localMiniAppInfo;
    if (paramInt >= 0)
    {
      i = 0;
      bgtj.a((bgtj)localObject, i);
      bgtj.b(this.a, System.currentTimeMillis());
      QMLog.i("[minigame][timecost] ", "step[launchGame] launchResult: " + paramInt + ", timeCost: " + paramLong + ", " + bgtj.a(this.a));
      bgyd.a(bgtj.a(this.a), 1040, null, bgtj.a(this.a), null, 0, "1", paramLong, null);
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(63, new Object[] { Integer.valueOf(paramInt) });
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(2051, new Object[0]);
      bgxl.a("2load_end", String.valueOf(bgtj.b(this.a)), null, bgtj.a(this.a));
      if (bgtj.b(this.a) < 0) {
        break label234;
      }
      localMiniAppInfo = bgtj.a(this.a);
      if (!bgtj.a(this.a)) {
        break label227;
      }
    }
    label227:
    for (localObject = "1";; localObject = "0")
    {
      bgyd.b(localMiniAppInfo, 1008, (String)localObject);
      bgyd.a(bgtj.a(this.a), 1008, "1");
      return;
      i = paramInt;
      break;
    }
    label234:
    bgyg.a(bgtj.a(this.a), "1", null, "show_fail", "load_pkg_fail");
    bgxl.a("2launch_fail", "load_pkg_fail", null, bgtj.a(this.a));
    bgxq.a(bgtj.a(this.a), 512);
    bgiv.a(bgtj.a(this.a), bgte.a().a(), bgtj.a(this.a), GameWnsUtils.getGameLaunchFailContent());
  }
  
  public void onInitFinish()
  {
    QMLog.i("GameRuntime", "onInitFinish");
    long l = System.currentTimeMillis() - bgtj.a(this.a);
    bgyd.a(bgtj.a(this.a), 1039, null, String.valueOf(bgtj.a(this.a)), null, 0, "1", l, null);
    QMLog.e("[minigame][timecost] ", "step[create surfaceView] cost time: " + l + "(from create SurfaceView)");
    this.a.f();
    bgtj.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgtm
 * JD-Core Version:    0.7.0.1
 */