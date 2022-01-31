import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class arzg
  implements DialogInterface.OnClickListener
{
  arzg(arzf paramarzf, bdfq parambdfq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_Bdfq.dismiss();
    this.jdField_a_of_type_Arzf.a.setResult(-1);
    this.jdField_a_of_type_Arzf.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzg
 * JD-Core Version:    0.7.0.1
 */