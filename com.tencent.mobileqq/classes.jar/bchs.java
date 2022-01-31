import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bchs
  implements View.OnClickListener
{
  bchs(bchp parambchp, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bchp, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bchp.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bchs
 * JD-Core Version:    0.7.0.1
 */