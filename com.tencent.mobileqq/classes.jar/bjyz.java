import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bjyz
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bjyy.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bjyz(bjyy parambjyy, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bkbk localbkbk = this.jdField_a_of_type_Bjyy.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbkbk == null)) {
      throw new AssertionError();
    }
    bjyy.a(paramDialogInterface, localbkbk);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjyy.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyz
 * JD-Core Version:    0.7.0.1
 */