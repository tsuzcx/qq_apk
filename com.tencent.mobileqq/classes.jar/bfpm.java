import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bfpm
  implements View.OnClickListener
{
  bfpm(bfpl parambfpl, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bfpl, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bfpl.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfpm
 * JD-Core Version:    0.7.0.1
 */