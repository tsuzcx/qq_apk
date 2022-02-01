import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.IliveLaunchFragment;
import kotlin.Pair;

public class bkiy
  implements EnterCallback
{
  public bkiy(IliveLaunchFragment paramIliveLaunchFragment) {}
  
  public void onCloseLoadingView()
  {
    if (bkkf.a) {
      IliveLaunchFragment.access$900(this.a);
    }
  }
  
  public void onEnterComplete()
  {
    if (bkkf.a) {
      return;
    }
    bkkd.b("IliveLaunch pluginParse");
    if (azjl.b()) {}
    for (String str = "1";; str = "0")
    {
      bgha.b("live_player_ready", new Pair[] { new Pair("status_msg", str) });
      if (bkkc.a().a("ANCHOR_ENTER_ROOM"))
      {
        bkkc.a().a("ANCHOR_ENTER_ROOM").a("auchor_enter");
        bkkc.a().a("ANCHOR_ENTER_ROOM");
      }
      if (bkkc.a().a("WATCH_ENTER_ROOM"))
      {
        bkkc.a().a("WATCH_ENTER_ROOM").a("watch_enter");
        bkkc.a().a("WATCH_ENTER_ROOM");
      }
      bkkc.a().a("PLUGIN_LOAD").a("enter_complete");
      return;
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    bkkd.a("IliveLaunch pluginParse");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkiy
 * JD-Core Version:    0.7.0.1
 */