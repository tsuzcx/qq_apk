import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class amsy
  implements DialogInterface.OnClickListener
{
  amsy(amsv paramamsv, amtd paramamtd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Amtd != null) {
      this.jdField_a_of_type_Amtd.a(this.jdField_a_of_type_Amsv.a(), "sc.xy_alert_show_success.local", "{\"cancel\":1}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsy
 * JD-Core Version:    0.7.0.1
 */