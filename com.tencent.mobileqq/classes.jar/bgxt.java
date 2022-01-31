import android.os.Handler;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qqmini.sdk.launcher.AppRuntimeLoaderManager;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.minigame.GameRuntime.3.1;
import com.tencent.qqmini.sdk.utils.GameWnsUtils;

public class bgxt
  implements ITTEngine.IListener
{
  bgxt(bgxq parambgxq) {}
  
  public void onExit()
  {
    bgxq.a(this.a);
  }
  
  public void onFirstRender()
  {
    QMLog.i("GameRuntime", "onFirstRender. " + bgxq.a(this.a));
    if (bgxq.a(this.a) != null) {
      bgxq.a(this.a).b();
    }
    this.a.a(bgmd.a(2032, Integer.valueOf(bgxq.b(this.a))));
    bgxq.a(this.a, System.currentTimeMillis());
    String str = bgxq.a(this.a);
    if (bgxq.a(this.a))
    {
      bgxq.a(this.a, false);
      QMLog.i("GameRuntime", "game[" + bgxq.a(this.a).appId + "][" + bgxq.a(this.a).name + "] 冷启动，首帧出现!");
      bhck.a(bgxq.a(this.a), 1022, "1");
    }
    for (;;)
    {
      long l1 = bgxq.b(this.a);
      long l2 = bgxq.c(this.a);
      bhck.a(bgxq.a(this.a), 1042, null, str, null, 0, "1", l1 - l2, null);
      bglr.a(bgxq.b(this.a));
      bgxq.a(this.a).post(new GameRuntime.3.1(this));
      return;
      QMLog.i("GameRuntime", "game[" + bgxq.a(this.a).appId + "][" + bgxq.a(this.a).name + "] 热启动,二次启动游戏!");
      bhck.a(bgxq.a(this.a), 1023, "1");
      bgzg.a(bgxq.a(this.a), bgxq.a(this.a));
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
      bgxq.a((bgxq)localObject, i);
      bgxq.b(this.a, System.currentTimeMillis());
      QMLog.i("[minigame][timecost] ", "step[launchGame] launchResult: " + paramInt + ", timeCost: " + paramLong + ", " + bgxq.a(this.a));
      bhck.a(bgxq.a(this.a), 1040, null, bgxq.a(this.a), null, 0, "1", paramLong, null);
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(63, new Object[] { Integer.valueOf(paramInt) });
      AppRuntimeLoaderManager.g().notifyRuntimeEvent(2051, new Object[0]);
      bhbs.a("2load_end", String.valueOf(bgxq.b(this.a)), null, bgxq.a(this.a));
      if (bgxq.b(this.a) < 0) {
        break label234;
      }
      localMiniAppInfo = bgxq.a(this.a);
      if (!bgxq.a(this.a)) {
        break label227;
      }
    }
    label227:
    for (localObject = "1";; localObject = "0")
    {
      bhck.b(localMiniAppInfo, 1008, (String)localObject);
      bhck.a(bgxq.a(this.a), 1008, "1");
      return;
      i = paramInt;
      break;
    }
    label234:
    bhcn.a(bgxq.a(this.a), "1", null, "show_fail", "load_pkg_fail");
    bhbs.a("2launch_fail", "load_pkg_fail", null, bgxq.a(this.a));
    bhbx.a(bgxq.a(this.a), 512);
    bgnc.a(bgxq.a(this.a), bgxl.a().a(), bgxq.a(this.a), GameWnsUtils.getGameLaunchFailContent());
  }
  
  public void onInitFinish()
  {
    QMLog.i("GameRuntime", "onInitFinish");
    long l = System.currentTimeMillis() - bgxq.a(this.a);
    bhck.a(bgxq.a(this.a), 1039, null, String.valueOf(bgxq.a(this.a)), null, 0, "1", l, null);
    QMLog.e("[minigame][timecost] ", "step[create surfaceView] cost time: " + l + "(from create SurfaceView)");
    this.a.f();
    bgxq.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgxt
 * JD-Core Version:    0.7.0.1
 */