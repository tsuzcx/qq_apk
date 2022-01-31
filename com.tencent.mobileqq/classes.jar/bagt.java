import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class bagt
  implements View.OnClickListener
{
  bagt(bagn parambagn, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Bagn.getInputValue();
    if (TextUtils.isEmpty(paramView)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bagn, 1);
        this.jdField_a_of_type_Bagn.a();
      }
      try
      {
        if (this.jdField_a_of_type_Bagn.isShowing()) {
          this.jdField_a_of_type_Bagn.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      if ((this.jdField_a_of_type_Bagn.a != null) && (this.jdField_a_of_type_Bagn.a.size() > 0))
      {
        int i = 0;
        while ((i < this.jdField_a_of_type_Bagn.a.size()) && (!paramView.equals(this.jdField_a_of_type_Bagn.a.get(i)))) {
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bagt
 * JD-Core Version:    0.7.0.1
 */