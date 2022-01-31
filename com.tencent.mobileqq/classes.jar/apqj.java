import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.FavEmosmManageActivity;
import com.tencent.mobileqq.app.BaseActivity;

class apqj
  implements DialogInterface.OnClickListener
{
  apqj(apqf paramapqf, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Intent(this.jdField_a_of_type_AndroidContentContext, FavEmosmManageActivity.class);
    paramDialogInterface.putExtra("camera_emo_mode", 1);
    this.jdField_a_of_type_AndroidContentContext.startActivity(paramDialogInterface);
    azmj.b(((BaseActivity)this.jdField_a_of_type_AndroidContentContext).app, "dc00898", "", "", "0X800A36F", "0X800A36F", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apqj
 * JD-Core Version:    0.7.0.1
 */