import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

class bqrz
  implements DialogInterface.OnClickListener
{
  static
  {
    if (!bqry.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  bqrz(bqry parambqry) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = new Bundle();
    bqkh localbqkh = this.jdField_a_of_type_Bqry.a().a;
    if ((!jdField_a_of_type_Boolean) && (localbqkh == null)) {
      throw new AssertionError();
    }
    bqhv.a(paramDialogInterface, localbqkh);
    paramDialogInterface.putInt("interact_type", bqry.a(this.jdField_a_of_type_Bqry));
    this.jdField_a_of_type_Bqry.a.a(38, paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqrz
 * JD-Core Version:    0.7.0.1
 */