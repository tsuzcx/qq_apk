import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awld
  implements View.OnClickListener
{
  awld(awlc paramawlc, int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_Int == 1)
    {
      localIntent = new Intent(this.jdField_a_of_type_Awlc.a, SplashActivity.class);
      localIntent.putExtra("uin", this.jdField_a_of_type_Long + "");
      localIntent.putExtra("uintype", 1);
      localIntent.putExtra("troop_uin", this.jdField_a_of_type_Long + "");
      localIntent.putExtra("uinname", this.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("isGameRoom", true);
      localIntent = AIOUtils.setOpenAIOIntent(localIntent, new int[] { 1, 2 });
      this.jdField_a_of_type_Awlc.a.startActivity(localIntent);
      if ((this.jdField_a_of_type_Awlc.a instanceof ChatActivity)) {
        ((ChatActivity)this.jdField_a_of_type_Awlc.a).finish();
      }
      bcef.b(null, "dc00899", "Grp_wolf", "", "in_game", "active_ball", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent = AIOUtils.setOpenAIOIntent(new Intent(this.jdField_a_of_type_Awlc.a, GameRoomInviteActivity.class), new int[] { 2 });
      localIntent.putExtra("inviteId", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("roomNum", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_Awlc.a.startActivity(localIntent);
      this.jdField_a_of_type_Awlc.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awld
 * JD-Core Version:    0.7.0.1
 */