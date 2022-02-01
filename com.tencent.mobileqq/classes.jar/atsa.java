import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class atsa
  implements DialogInterface.OnClickListener
{
  atsa(atrz paramatrz, atsf paramatsf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bdll.b(null, "dc00898", "", "", "0X800AE40", "0X800AE40", 0, 0, "", "", "", "");
    if (this.jdField_a_of_type_Atsf != null) {
      this.jdField_a_of_type_Atsf.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsa
 * JD-Core Version:    0.7.0.1
 */