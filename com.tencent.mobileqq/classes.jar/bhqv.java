import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class bhqv
  implements View.OnClickListener
{
  bhqv(bhqp parambhqp, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_Bhqp.getInputValue();
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhqp, 1);
        this.jdField_a_of_type_Bhqp.a();
      }
      try
      {
        if (this.jdField_a_of_type_Bhqp.isShowing()) {
          this.jdField_a_of_type_Bhqp.dismiss();
        }
        label60:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.jdField_a_of_type_Bhqp.a == null) || (this.jdField_a_of_type_Bhqp.a.size() <= 0)) {
          continue;
        }
        int i = 0;
        while ((i < this.jdField_a_of_type_Bhqp.a.size()) && (!str.equals(this.jdField_a_of_type_Bhqp.a.get(i)))) {
          i += 1;
        }
      }
      catch (Exception localException)
      {
        break label60;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhqv
 * JD-Core Version:    0.7.0.1
 */