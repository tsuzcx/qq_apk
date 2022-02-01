import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bpgb
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bpga.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bpgb(bpga parambpga, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bpim localbpim = this.jdField_a_of_type_Bpga.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbpim == null)) {
      throw new AssertionError();
    }
    bpga.a(paramDialogInterface, localbpim);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bpga.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpgb
 * JD-Core Version:    0.7.0.1
 */