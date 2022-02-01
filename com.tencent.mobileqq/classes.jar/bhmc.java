import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class bhmc
  implements View.OnClickListener
{
  bhmc(DialogInterface.OnClickListener paramOnClickListener, bhpc parambhpc) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhpc, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhmc
 * JD-Core Version:    0.7.0.1
 */