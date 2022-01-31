import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bafj
  implements View.OnClickListener
{
  bafj(bafb parambafb, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bafb, 1);
    }
    try
    {
      if ((this.jdField_a_of_type_Bafb.isShowing()) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bafj
 * JD-Core Version:    0.7.0.1
 */