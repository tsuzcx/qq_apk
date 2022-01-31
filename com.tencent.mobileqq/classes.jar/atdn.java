import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.List;

class atdn
  implements View.OnClickListener
{
  atdn(atdm paramatdm, int paramInt, bcic parambcic) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((atdl)this.jdField_a_of_type_Atdm.a.a.get(this.jdField_a_of_type_Int)).a);
      this.jdField_a_of_type_Bcic.a(this.jdField_a_of_type_Atdm.a.b, l, null);
      this.jdField_a_of_type_Atdm.a.a("invite_page", "kick_out");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdn
 * JD-Core Version:    0.7.0.1
 */