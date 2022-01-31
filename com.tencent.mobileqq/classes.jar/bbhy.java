import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;

class bbhy
  implements View.OnClickListener
{
  bbhy(bbhs parambbhs, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_Bbhs.getInputValue();
    if (TextUtils.isEmpty(paramView)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bbhs, 1);
        this.jdField_a_of_type_Bbhs.a();
      }
      try
      {
        if (this.jdField_a_of_type_Bbhs.isShowing()) {
          this.jdField_a_of_type_Bbhs.dismiss();
        }
        return;
      }
      catch (Exception paramView) {}
      if ((this.jdField_a_of_type_Bbhs.a != null) && (this.jdField_a_of_type_Bbhs.a.size() > 0))
      {
        int i = 0;
        while ((i < this.jdField_a_of_type_Bbhs.a.size()) && (!paramView.equals(this.jdField_a_of_type_Bbhs.a.get(i)))) {
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bbhy
 * JD-Core Version:    0.7.0.1
 */