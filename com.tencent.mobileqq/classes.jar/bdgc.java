import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdgc
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bdgc(bdfq parambdfq, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bdfq.onArrayItemClick != null) {
      this.jdField_a_of_type_Bdfq.onArrayItemClick.onClick(this.jdField_a_of_type_Bdfq, this.jdField_a_of_type_Bdfq.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bdfq.isShowing()) {
        this.jdField_a_of_type_Bdfq.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdgc
 * JD-Core Version:    0.7.0.1
 */