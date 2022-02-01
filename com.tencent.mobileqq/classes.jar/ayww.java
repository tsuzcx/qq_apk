import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class ayww
  implements View.OnClickListener
{
  ayww(FragmentActivity paramFragmentActivity, aywt paramaywt) {}
  
  public void onClick(View paramView)
  {
    aywu.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Aywt);
    aaak.a().a(new NoRecommendDataEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayww
 * JD-Core Version:    0.7.0.1
 */