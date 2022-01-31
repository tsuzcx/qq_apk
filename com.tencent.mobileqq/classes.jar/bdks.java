import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bdks
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bdks(bdkn parambdkn, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bdkn.a != null)
    {
      this.jdField_a_of_type_Bdkn.a.onClick(this.jdField_a_of_type_Bdkn, this.jdField_a_of_type_Bdkn.a(this.jdField_a_of_type_Int));
      this.jdField_a_of_type_Bdkn.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdks
 * JD-Core Version:    0.7.0.1
 */