import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class apme
  implements DialogInterface.OnClickListener
{
  apme(apma paramapma, bafb parambafb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bafb.dismiss();
    this.jdField_a_of_type_Apma.a.setResult(-1);
    this.jdField_a_of_type_Apma.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apme
 * JD-Core Version:    0.7.0.1
 */