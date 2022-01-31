import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bbgs
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bbgs(bbgg parambbgg, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bbgg.onArrayItemClick != null) {
      this.jdField_a_of_type_Bbgg.onArrayItemClick.onClick(this.jdField_a_of_type_Bbgg, this.jdField_a_of_type_Bbgg.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bbgg.isShowing()) {
        this.jdField_a_of_type_Bbgg.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbgs
 * JD-Core Version:    0.7.0.1
 */