import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class axsj
  implements View.OnClickListener
{
  axsj(axsi paramaxsi, int paramInt, bikt parambikt) {}
  
  public void onClick(View paramView)
  {
    try
    {
      long l = Long.parseLong(((axsh)this.jdField_a_of_type_Axsi.a.a.get(this.jdField_a_of_type_Int)).a);
      this.jdField_a_of_type_Bikt.a(this.jdField_a_of_type_Axsi.a.b, l, null);
      this.jdField_a_of_type_Axsi.a.a("invite_page", "kick_out");
      label62:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsj
 * JD-Core Version:    0.7.0.1
 */