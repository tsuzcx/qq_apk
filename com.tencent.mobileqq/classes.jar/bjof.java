import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjof
  implements View.OnClickListener
{
  bjof(bjob parambjob, DialogInterface.OnClickListener paramOnClickListener, int paramInt, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null) {
      this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(this.jdField_a_of_type_Bjob, this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Bjob.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjof
 * JD-Core Version:    0.7.0.1
 */