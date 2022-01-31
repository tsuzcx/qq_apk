import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bmum
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bmul.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bmum(bmul parambmul) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bmmu localbmmu = this.jdField_a_of_type_Bmul.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbmmu == null)) {
      throw new AssertionError();
    }
    bmki.a(paramDialogInterface, localbmmu);
    paramDialogInterface.putInt("interact_type", bmul.a(this.jdField_a_of_type_Bmul));
    this.jdField_a_of_type_Bmul.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmum
 * JD-Core Version:    0.7.0.1
 */