import android.view.View;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.mobileqq.nearby.gameroom.RecentUserInvitePanel;
import com.tencent.mobileqq.widget.QQToast;

public class auyn
  implements auzs
{
  public auyn(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.f();
    azqs.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, auzv paramauzv)
  {
    if (paramauzv.jdField_a_of_type_Boolean) {
      QQToast.a(this.a, 1, alud.a(2131705501), 1).a();
    }
    do
    {
      return;
      GameRoomInviteActivity.a(this.a, paramauzv.jdField_a_of_type_JavaLangString, paramauzv.jdField_a_of_type_Int);
      paramauzv.jdField_a_of_type_Boolean = true;
      this.a.a.a(paramView, paramauzv.jdField_a_of_type_Boolean);
      if (paramauzv.jdField_a_of_type_Int == 1)
      {
        azqs.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
        return;
      }
    } while (paramauzv.jdField_a_of_type_Int != 0);
    azqs.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auyn
 * JD-Core Version:    0.7.0.1
 */