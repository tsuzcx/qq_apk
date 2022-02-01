import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class axyp
  implements axzu
{
  public axyp(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    bdll.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, axzx paramaxzx)
  {
    if (paramaxzx.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, anzj.a(2131704004), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramaxzx.jdField_a_of_type_JavaLangString, paramaxzx.jdField_a_of_type_Int);
      paramaxzx.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramaxzx.jdField_a_of_type_Boolean);
      if (paramaxzx.jdField_a_of_type_Int == 1)
      {
        bdll.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramaxzx.jdField_a_of_type_Int != 0);
    bdll.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axyp
 * JD-Core Version:    0.7.0.1
 */