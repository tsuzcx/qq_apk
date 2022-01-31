import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bemu
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bemu(bemn parambemn, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bemn.a != null) {
      this.jdField_a_of_type_Bemn.a.onClick(this.jdField_a_of_type_Bemn, this.jdField_a_of_type_Bemn.a(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bemn.isShowing()) {
        this.jdField_a_of_type_Bemn.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemu
 * JD-Core Version:    0.7.0.1
 */