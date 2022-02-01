import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class axrz
  implements axte
{
  public axrz(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    bdla.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, axth paramaxth)
  {
    if (paramaxth.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, anvx.a(2131704584), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramaxth.jdField_a_of_type_JavaLangString, paramaxth.jdField_a_of_type_Int);
      paramaxth.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramaxth.jdField_a_of_type_Boolean);
      if (paramaxth.jdField_a_of_type_Int == 1)
      {
        bdla.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramaxth.jdField_a_of_type_Int != 0);
    bdla.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrz
 * JD-Core Version:    0.7.0.1
 */