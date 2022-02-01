import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.IliveLaunchFragment;
import kotlin.Pair;

public class bmfb
  implements EnterCallback
{
  public bmfb(IliveLaunchFragment paramIliveLaunchFragment) {}
  
  public void onCloseLoadingView()
  {
    if (bmfy.a) {
      IliveLaunchFragment.access$900(this.a);
    }
  }
  
  public void onEnterComplete()
  {
    if (bmfy.a) {
      return;
    }
    bmfw.b("IliveLaunch pluginParse");
    if (bapg.b()) {}
    for (String str = "1";; str = "0")
    {
      biaq.b("live_player_ready", new Pair[] { new Pair("status_msg", str) });
      if (bmfv.a().a("ANCHOR_ENTER_ROOM"))
      {
        bmfv.a().a("ANCHOR_ENTER_ROOM").a("auchor_enter");
        bmfv.a().a("ANCHOR_ENTER_ROOM");
      }
      if (bmfv.a().a("WATCH_ENTER_ROOM"))
      {
        bmfv.a().a("WATCH_ENTER_ROOM").a("watch_enter");
        bmfv.a().a("WATCH_ENTER_ROOM");
      }
      bmfv.a().a("PLUGIN_LOAD").a("enter_complete");
      return;
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    bmfw.a("IliveLaunch pluginParse");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfb
 * JD-Core Version:    0.7.0.1
 */