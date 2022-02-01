import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class aqdb
  implements DialogInterface.OnClickListener
{
  aqdb(bgpa parambgpa, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Bgpa.isShowing()) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
    aqfv.a(this.jdField_a_of_type_AndroidContentContext, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdb
 * JD-Core Version:    0.7.0.1
 */