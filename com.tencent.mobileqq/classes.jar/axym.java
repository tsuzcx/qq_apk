import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axym
  implements View.OnClickListener
{
  public axym(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtils.isNetworkAvailable(this.a)) {
      QQToast.a(this.a, 1, 2131693965, 1).a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.d();
      this.a.a("invite_page", "clk_exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axym
 * JD-Core Version:    0.7.0.1
 */