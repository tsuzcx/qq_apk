import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdir
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bdir(bdik parambdik, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bdik.a != null) {
      this.jdField_a_of_type_Bdik.a.onClick(this.jdField_a_of_type_Bdik, this.jdField_a_of_type_Bdik.a(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bdik.isShowing()) {
        this.jdField_a_of_type_Bdik.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdir
 * JD-Core Version:    0.7.0.1
 */