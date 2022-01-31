import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class bgnb
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public bgnb(bgmu parambgmu, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bgmu.a != null) {
      this.jdField_a_of_type_Bgmu.a.onClick(this.jdField_a_of_type_Bgmu, this.jdField_a_of_type_Bgmu.a(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bgmu.isShowing()) {
        this.jdField_a_of_type_Bgmu.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgnb
 * JD-Core Version:    0.7.0.1
 */