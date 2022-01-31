import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class bdpb
  implements ITTEngine.IListener
{
  bdpb(bdoz parambdoz) {}
  
  public void onFirstRender()
  {
    bdnw.b("GameRuntime", "onFirstRender");
    this.a.a(bdfl.a(2021));
    bdoz.a(this.a, System.currentTimeMillis());
    if (bdoz.a(this.a))
    {
      bdoz.a(this.a, false);
      bdnw.b("GameRuntime", "game[" + bdoz.a(this.a).appId + "][" + bdoz.a(this.a).name + "] 冷启动，首帧出现!");
      bdsu.a(bdoz.a(this.a), 1022, "1");
    }
    for (;;)
    {
      bdoz.a(this.a, 2);
      return;
      bdnw.b("GameRuntime", "game[" + bdoz.a(this.a).appId + "][" + bdoz.a(this.a).name + "] 热启动,二次启动游戏!");
      bdsu.a(bdoz.a(this.a), 1023, "1");
    }
  }
  
  public void onGameLaunched(long paramLong) {}
  
  public void onInitFinish()
  {
    bdnw.b("GameRuntime", "onInitFinish");
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdpb
 * JD-Core Version:    0.7.0.1
 */