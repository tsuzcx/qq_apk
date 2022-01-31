import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class auue
  implements auvj
{
  public auue(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    azmj.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, auvm paramauvm)
  {
    if (paramauvm.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, alpo.a(2131705489), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramauvm.jdField_a_of_type_JavaLangString, paramauvm.jdField_a_of_type_Int);
      paramauvm.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramauvm.jdField_a_of_type_Boolean);
      if (paramauvm.jdField_a_of_type_Int == 1)
      {
        azmj.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramauvm.jdField_a_of_type_Int != 0);
    azmj.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auue
 * JD-Core Version:    0.7.0.1
 */