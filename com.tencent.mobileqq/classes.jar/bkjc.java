import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bkjc
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bkjb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bkjc(bkjb parambkjb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bkbk localbkbk = this.jdField_a_of_type_Bkjb.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbkbk == null)) {
      throw new AssertionError();
    }
    bjyy.a(paramDialogInterface, localbkbk);
    paramDialogInterface.putInt("interact_type", bkjb.a(this.jdField_a_of_type_Bkjb));
    this.jdField_a_of_type_Bkjb.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkjc
 * JD-Core Version:    0.7.0.1
 */