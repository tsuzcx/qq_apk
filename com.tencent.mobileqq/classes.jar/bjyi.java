import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bjyi
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bjyh.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bjyi(bjyh parambjyh, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bkat localbkat = this.jdField_a_of_type_Bjyh.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbkat == null)) {
      throw new AssertionError();
    }
    bjyh.a(paramDialogInterface, localbkat);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjyh.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyi
 * JD-Core Version:    0.7.0.1
 */