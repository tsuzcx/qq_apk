import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhpk
  implements View.OnClickListener
{
  bhpk(bhpc parambhpc, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bhpc, 1);
    }
    try
    {
      if ((this.jdField_a_of_type_Bhpc.isShowing()) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_Bhpc.dismiss();
      }
      label45:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label45;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhpk
 * JD-Core Version:    0.7.0.1
 */