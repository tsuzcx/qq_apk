import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bkzo
  implements DialogInterface.OnClickListener
{
  bkzo(bkzk parambkzk, Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (bkzk.a(this.jdField_a_of_type_Bkzk).isShowing()) {
      bkzk.a(this.jdField_a_of_type_Bkzk).dismiss();
    }
    aquy.a(this.jdField_a_of_type_AndroidAppActivity, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkzo
 * JD-Core Version:    0.7.0.1
 */