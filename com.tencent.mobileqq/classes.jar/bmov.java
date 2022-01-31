import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bmov
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bmou.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bmov(bmou parambmou, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bmrg localbmrg = this.jdField_a_of_type_Bmou.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbmrg == null)) {
      throw new AssertionError();
    }
    bmou.a(paramDialogInterface, localbmrg);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmou.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmov
 * JD-Core Version:    0.7.0.1
 */