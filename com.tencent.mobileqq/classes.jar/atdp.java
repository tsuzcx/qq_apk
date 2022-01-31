import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import java.util.List;

class atdp
  implements View.OnClickListener
{
  atdp(atdo paramatdo, int paramInt, bciq parambciq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((atdn)this.jdField_a_of_type_Atdo.a.a.get(this.jdField_a_of_type_Int)).a);
      this.jdField_a_of_type_Bciq.a(this.jdField_a_of_type_Atdo.a.b, l, null);
      this.jdField_a_of_type_Atdo.a.a("invite_page", "kick_out");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atdp
 * JD-Core Version:    0.7.0.1
 */