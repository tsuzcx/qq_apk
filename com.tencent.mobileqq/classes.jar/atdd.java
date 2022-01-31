import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;

public class atdd
  implements atei
{
  public atdd(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    axqw.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, atel paramatel)
  {
    if (paramatel.jdField_a_of_type_Boolean) {
      bcpw.a(this.a, 1, ajyc.a(2131705106), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramatel.jdField_a_of_type_JavaLangString, paramatel.jdField_a_of_type_Int);
      paramatel.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramatel.jdField_a_of_type_Boolean);
      if (paramatel.jdField_a_of_type_Int == 1)
      {
        axqw.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramatel.jdField_a_of_type_Int != 0);
    axqw.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdd
 * JD-Core Version:    0.7.0.1
 */