import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bfmj
  implements DialogInterface.OnClickListener
{
  bfmj(bfmk parambfmk, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_Bfmk != null) {
      this.jdField_a_of_type_Bfmk.a();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      bdll.b(null, "dc00898", "", "", "0X800B224", "0X800B224", 0, 0, "", "", "", "");
      return;
    }
    bdll.b(null, "dc00898", "", "", "0X800B226", "0X800B226", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmj
 * JD-Core Version:    0.7.0.1
 */