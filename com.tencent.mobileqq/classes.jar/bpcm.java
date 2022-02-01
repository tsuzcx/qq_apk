import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.widget.EditText;

class bpcm
  implements DialogInterface.OnDismissListener
{
  bpcm(bpcg parambpcg, bpqa parambpqa) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bpcg.a.a(0);
    bpcg.a(this.jdField_a_of_type_Bpcg).setText(this.jdField_a_of_type_Bpqa.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpcm
 * JD-Core Version:    0.7.0.1
 */