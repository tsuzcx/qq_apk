import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.widget.QQToast;

public class auub
  implements View.OnClickListener
{
  public auub(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtils.isNetworkAvailable(this.a))
    {
      QQToast.a(this.a, 1, 2131694766, 1).a();
      return;
    }
    this.a.d();
    this.a.a("invite_page", "clk_exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auub
 * JD-Core Version:    0.7.0.1
 */