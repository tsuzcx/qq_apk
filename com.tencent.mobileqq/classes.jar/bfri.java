import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfri
  implements View.OnClickListener
{
  public bfri(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, bkzi parambkzi) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bkzi.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfri
 * JD-Core Version:    0.7.0.1
 */