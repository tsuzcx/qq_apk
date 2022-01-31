import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbhg
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bbhg(bbgu parambbgu, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bbgu.onArrayItemClick != null) {
      this.jdField_a_of_type_Bbgu.onArrayItemClick.onClick(this.jdField_a_of_type_Bbgu, this.jdField_a_of_type_Bbgu.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bbgu.isShowing()) {
        this.jdField_a_of_type_Bbgu.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhg
 * JD-Core Version:    0.7.0.1
 */