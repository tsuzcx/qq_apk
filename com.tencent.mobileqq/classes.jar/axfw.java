import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class axfw
  implements axhb
{
  public axfw(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    bcst.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, axhe paramaxhe)
  {
    if (paramaxhe.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, anni.a(2131703897), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramaxhe.jdField_a_of_type_JavaLangString, paramaxhe.jdField_a_of_type_Int);
      paramaxhe.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramaxhe.jdField_a_of_type_Boolean);
      if (paramaxhe.jdField_a_of_type_Int == 1)
      {
        bcst.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramaxhe.jdField_a_of_type_Int != 0);
    bcst.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axfw
 * JD-Core Version:    0.7.0.1
 */