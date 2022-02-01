import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class bgqt
  implements View.OnClickListener
{
  bgqt(bgqn parambgqn, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    String str = this.jdField_a_of_type_Bgqn.getInputValue();
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bgqn, 1);
        this.jdField_a_of_type_Bgqn.a();
      }
      try
      {
        if (this.jdField_a_of_type_Bgqn.isShowing()) {
          this.jdField_a_of_type_Bgqn.dismiss();
        }
        label60:
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.jdField_a_of_type_Bgqn.a == null) || (this.jdField_a_of_type_Bgqn.a.size() <= 0)) {
          continue;
        }
        int i = 0;
        while ((i < this.jdField_a_of_type_Bgqn.a.size()) && (!str.equals(this.jdField_a_of_type_Bgqn.a.get(i)))) {
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
 * Qualified Name:     bgqt
 * JD-Core Version:    0.7.0.1
 */