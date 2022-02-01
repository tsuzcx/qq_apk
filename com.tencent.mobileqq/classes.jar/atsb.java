import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class atsb
  implements DialogInterface.OnClickListener
{
  atsb(atrz paramatrz, atsf paramatsf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(null, "dc00898", "", "", "0X800AE41", "0X800AE41", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Atsf != null) {
      this.jdField_a_of_type_Atsf.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsb
 * JD-Core Version:    0.7.0.1
 */