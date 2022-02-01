import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfbd
  implements View.OnClickListener
{
  public bfbd(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, bkho parambkho) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_Bkho.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbd
 * JD-Core Version:    0.7.0.1
 */