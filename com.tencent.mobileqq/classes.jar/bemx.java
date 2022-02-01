import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bemx
  implements DialogInterface.OnClickListener
{
  bemx(bhpc parambhpc, bemy parambemy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_Bhpc.isShowing()) {
      this.jdField_a_of_type_Bhpc.dismiss();
    }
    if (this.jdField_a_of_type_Bemy != null) {
      this.jdField_a_of_type_Bemy.a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemx
 * JD-Core Version:    0.7.0.1
 */