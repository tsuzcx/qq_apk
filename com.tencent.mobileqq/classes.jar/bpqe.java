import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bpqe
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bpqd.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bpqe(bpqd parambpqd) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bpim localbpim = this.jdField_a_of_type_Bpqd.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbpim == null)) {
      throw new AssertionError();
    }
    bpga.a(paramDialogInterface, localbpim);
    paramDialogInterface.putInt("interact_type", bpqd.a(this.jdField_a_of_type_Bpqd));
    this.jdField_a_of_type_Bpqd.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqe
 * JD-Core Version:    0.7.0.1
 */