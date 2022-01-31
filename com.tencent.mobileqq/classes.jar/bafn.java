import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bafn
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bafn(bafb parambafb, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bafb.onArrayItemClick != null) {
      this.jdField_a_of_type_Bafb.onArrayItemClick.onClick(this.jdField_a_of_type_Bafb, this.jdField_a_of_type_Bafb.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bafb.isShowing()) {
        this.jdField_a_of_type_Bafb.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bafn
 * JD-Core Version:    0.7.0.1
 */