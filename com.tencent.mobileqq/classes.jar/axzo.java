import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity;

final class axzo
  implements DialogInterface.OnClickListener
{
  axzo(Activity paramActivity, String paramString, int paramInt, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidAppActivity, GameRoomInviteActivity.class);
    paramDialogInterface.putExtra("inviteId", this.jdField_a_of_type_JavaLangString);
    paramDialogInterface.putExtra("roomNum", this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Long > 0L)
    {
      paramDialogInterface.putExtra("gc", this.jdField_a_of_type_Long);
      paramDialogInterface.putExtra("isInviteTroop", false);
    }
    this.jdField_a_of_type_AndroidAppActivity.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzo
 * JD-Core Version:    0.7.0.1
 */