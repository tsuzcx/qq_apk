import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axrk
  implements View.OnClickListener
{
  public axrk(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrk
 * JD-Core Version:    0.7.0.1
 */