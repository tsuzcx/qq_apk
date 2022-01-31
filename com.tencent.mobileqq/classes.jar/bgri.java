import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bgri
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bgri(bgrb parambgrb, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgrb.a != null) {
      this.jdField_a_of_type_Bgrb.a.onClick(this.jdField_a_of_type_Bgrb, this.jdField_a_of_type_Bgrb.a(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bgrb.isShowing()) {
        this.jdField_a_of_type_Bgrb.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgri
 * JD-Core Version:    0.7.0.1
 */