import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class awlx
  implements awnc
{
  public awlx(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    bcef.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, awnf paramawnf)
  {
    if (paramawnf.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, amtj.a(2131704233), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramawnf.jdField_a_of_type_JavaLangString, paramawnf.jdField_a_of_type_Int);
      paramawnf.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramawnf.jdField_a_of_type_Boolean);
      if (paramawnf.jdField_a_of_type_Int == 1)
      {
        bcef.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramawnf.jdField_a_of_type_Int != 0);
    bcef.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlx
 * JD-Core Version:    0.7.0.1
 */