import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

final class bhap
  implements View.OnClickListener
{
  bhap(AtomicBoolean paramAtomicBoolean, ayvn paramayvn) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_Ayvn.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhap
 * JD-Core Version:    0.7.0.1
 */