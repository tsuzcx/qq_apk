import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.EnterCallback;
import cooperation.ilive.IliveLaunchFragment;
import kotlin.Pair;

public class bldy
  implements EnterCallback
{
  public bldy(IliveLaunchFragment paramIliveLaunchFragment) {}
  
  public void onCloseLoadingView()
  {
    if (blev.a)
    {
      QLog.i("IliveLaunchActivity", 1, "preload end");
      blev.a = false;
      blev.a();
    }
  }
  
  public void onEnterComplete()
  {
    if (blev.a) {
      return;
    }
    blet.b("IliveLaunch pluginParse");
    if (azwq.b()) {}
    for (String str = "1";; str = "0")
    {
      bhak.b("live_player_ready", new Pair[] { new Pair("status_msg", str) });
      if (bles.a().a("ANCHOR_ENTER_ROOM"))
      {
        bles.a().a("ANCHOR_ENTER_ROOM").a("auchor_enter");
        bles.a().a("ANCHOR_ENTER_ROOM");
      }
      if (bles.a().a("WATCH_ENTER_ROOM"))
      {
        bles.a().a("WATCH_ENTER_ROOM").a("watch_enter");
        bles.a().a("WATCH_ENTER_ROOM");
      }
      bles.a().a("PLUGIN_LOAD").a("enter_complete");
      return;
    }
  }
  
  public void onShowLoadingView(View paramView)
  {
    blet.a("IliveLaunch pluginParse");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bldy
 * JD-Core Version:    0.7.0.1
 */