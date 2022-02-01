import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asgn
  implements View.OnClickListener
{
  asgn(asgl paramasgl, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    if ((!((Activity)this.jdField_a_of_type_Asgl.a).isFinishing()) && (this.jdField_a_of_type_AndroidAppDialog.isShowing())) {
      this.jdField_a_of_type_AndroidAppDialog.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asgn
 * JD-Core Version:    0.7.0.1
 */