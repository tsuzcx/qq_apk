import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

public class atdc
  implements View.OnClickListener
{
  public atdc(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtils.isNetworkAvailable(this.a))
    {
      bcql.a(this.a, 1, 2131694610, 1).a();
      return;
    }
    this.a.d();
    this.a.a("invite_page", "clk_exit");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdc
 * JD-Core Version:    0.7.0.1
 */