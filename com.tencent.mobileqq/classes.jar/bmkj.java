import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bmkj
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bmki.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bmkj(bmki parambmki, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bmmu localbmmu = this.jdField_a_of_type_Bmki.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbmmu == null)) {
      throw new AssertionError();
    }
    bmki.a(paramDialogInterface, localbmmu);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmki.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmkj
 * JD-Core Version:    0.7.0.1
 */