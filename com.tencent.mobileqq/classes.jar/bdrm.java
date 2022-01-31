import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class bdrm
  implements DialogInterface.OnClickListener
{
  bdrm(bdrk parambdrk, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrm
 * JD-Core Version:    0.7.0.1
 */