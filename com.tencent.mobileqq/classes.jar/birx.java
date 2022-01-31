import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class birx
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!birw.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  birx(birw parambirw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bijy localbijy = this.jdField_a_of_type_Birw.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbijy == null)) {
      throw new AssertionError();
    }
    bihm.a(paramDialogInterface, localbijy);
    paramDialogInterface.putInt("interact_type", birw.a(this.jdField_a_of_type_Birw));
    this.jdField_a_of_type_Birw.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birx
 * JD-Core Version:    0.7.0.1
 */