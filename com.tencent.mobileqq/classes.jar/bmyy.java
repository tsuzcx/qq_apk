import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bmyy
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bmyx.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bmyy(bmyx parambmyx) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bmrg localbmrg = this.jdField_a_of_type_Bmyx.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbmrg == null)) {
      throw new AssertionError();
    }
    bmou.a(paramDialogInterface, localbmrg);
    paramDialogInterface.putInt("interact_type", bmyx.a(this.jdField_a_of_type_Bmyx));
    this.jdField_a_of_type_Bmyx.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyy
 * JD-Core Version:    0.7.0.1
 */