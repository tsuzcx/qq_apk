import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bflf
  implements View.OnClickListener
{
  bflf(bflc parambflc, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bflc, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bflc.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bflf
 * JD-Core Version:    0.7.0.1
 */