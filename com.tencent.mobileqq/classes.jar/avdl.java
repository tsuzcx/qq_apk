import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avdl
  implements CompoundButton.OnCheckedChangeListener
{
  public avdl(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    GameCenterVideoViewController.access$000(this.a).setShown(paramBoolean);
    if (GameCenterVideoViewController.access$100(this.a) != null) {
      GameCenterVideoViewController.access$100(this.a).a(paramBoolean, GameCenterVideoViewController.access$200(this.a));
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdl
 * JD-Core Version:    0.7.0.1
 */