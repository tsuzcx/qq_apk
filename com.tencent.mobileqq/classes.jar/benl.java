import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class benl
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  
  public benl(bene parambene, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Bene.a != null) {
      this.jdField_a_of_type_Bene.a.onClick(this.jdField_a_of_type_Bene, this.jdField_a_of_type_Bene.a(this.jdField_a_of_type_Int));
    }
    try
    {
      if (this.jdField_a_of_type_Bene.isShowing()) {
        this.jdField_a_of_type_Bene.dismiss();
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     benl
 * JD-Core Version:    0.7.0.1
 */