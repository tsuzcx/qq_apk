import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bgax
  implements View.OnClickListener
{
  public bgax(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, blir paramblir) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Blir.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgax
 * JD-Core Version:    0.7.0.1
 */