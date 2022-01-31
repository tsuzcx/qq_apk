import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

class autk
  implements View.OnClickListener
{
  autk(autj paramautj, int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      paramView = new Intent(this.jdField_a_of_type_Autj.a, SplashActivity.class);
      paramView.putExtra("uin", this.jdField_a_of_type_Long + "");
      paramView.putExtra("uintype", 1);
      paramView.putExtra("troop_uin", this.jdField_a_of_type_Long + "");
      paramView.putExtra("uinname", this.jdField_a_of_type_JavaLangString);
      paramView.putExtra("isGameRoom", true);
      paramView = aekt.a(paramView, new int[] { 1, 2 });
      this.jdField_a_of_type_Autj.a.startActivity(paramView);
      if ((this.jdField_a_of_type_Autj.a instanceof ChatActivity)) {
        ((ChatActivity)this.jdField_a_of_type_Autj.a).finish();
      }
      azmj.b(null, "dc00899", "Grp_wolf", "", "in_game", "active_ball", 0, 0, "", "", "", "");
      return;
    }
    paramView = aekt.a(new Intent(this.jdField_a_of_type_Autj.a, GameRoomInviteActivity.class), new int[] { 2 });
    paramView.putExtra("inviteId", this.jdField_b_of_type_JavaLangString);
    paramView.putExtra("roomNum", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Autj.a.startActivity(paramView);
    this.jdField_a_of_type_Autj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     autk
 * JD-Core Version:    0.7.0.1
 */