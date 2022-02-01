import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bqhw
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bqhv.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bqhw(bqhv parambqhv, int paramInt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bqkh localbqkh = this.jdField_a_of_type_Bqhv.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbqkh == null)) {
      throw new AssertionError();
    }
    bqhv.a(paramDialogInterface, localbqkh);
    paramDialogInterface.putInt("element_index", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bqhv.a.a(35, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqhw
 * JD-Core Version:    0.7.0.1
 */