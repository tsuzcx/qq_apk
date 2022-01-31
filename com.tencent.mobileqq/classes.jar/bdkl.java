import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdkl
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bdkl(bdjz parambdjz, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bdjz.onArrayItemClick != null) {
      this.jdField_a_of_type_Bdjz.onArrayItemClick.onClick(this.jdField_a_of_type_Bdjz, this.jdField_a_of_type_Bdjz.customWhichToCallBack(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bdjz.isShowing()) {
        this.jdField_a_of_type_Bdjz.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdkl
 * JD-Core Version:    0.7.0.1
 */