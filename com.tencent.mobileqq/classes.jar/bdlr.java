import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class bdlr
  implements View.OnClickListener
{
  bdlr(bdll parambdll, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Bdll.getInputValue();
    if (TextUtils.isEmpty(paramView)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bdll, 1);
        this.jdField_a_of_type_Bdll.a();
      }
      try
      {
        if (this.jdField_a_of_type_Bdll.isShowing()) {
          this.jdField_a_of_type_Bdll.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      if ((this.jdField_a_of_type_Bdll.a != null) && (this.jdField_a_of_type_Bdll.a.size() > 0))
      {
        int i = 0;
        while ((i < this.jdField_a_of_type_Bdll.a.size()) && (!paramView.equals(this.jdField_a_of_type_Bdll.a.get(i)))) {
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdlr
 * JD-Core Version:    0.7.0.1
 */