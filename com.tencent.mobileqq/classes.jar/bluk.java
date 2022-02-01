import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.IliveLaunchFragment;
import kotlin.Pair;

public final class bluk
  implements EnterCallback
{
  public void onCloseLoadingView()
  {
    if (blvn.a) {
      IliveLaunchFragment.access$900();
    }
  }
  
  public void onEnterComplete()
  {
    blvi.b("ilive_monitor_odex_plugin_load");
    if (blvn.a) {
      return;
    }
    blvl.b("IliveLaunch pluginParse");
    if (bapt.b()) {}
    for (String str = "1";; str = "0")
    {
      bhpu.b("live_player_ready", new Pair[] { new Pair("status_msg", str) });
      if (blvk.a().a("ANCHOR_ENTER_ROOM"))
      {
        blvk.a().a("ANCHOR_ENTER_ROOM").a("auchor_enter");
        blvk.a().a("ANCHOR_ENTER_ROOM");
      }
      if (blvk.a().a("WATCH_ENTER_ROOM"))
      {
        blvk.a().a("WATCH_ENTER_ROOM").a("watch_enter");
        blvk.a().a("WATCH_ENTER_ROOM");
      }
      blvk.a().a("PLUGIN_LOAD").a("enter_complete");
      return;
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    blvl.a("IliveLaunch pluginParse");
    blvi.a("ilive_monitor_odex_plugin_load");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bluk
 * JD-Core Version:    0.7.0.1
 */