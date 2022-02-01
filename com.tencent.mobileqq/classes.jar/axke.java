import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class axke
  implements View.OnClickListener
{
  axke(FragmentActivity paramFragmentActivity, axkb paramaxkb) {}
  
  public void onClick(View paramView)
  {
    axkc.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_Axkb);
    SimpleEventBus.getInstance().dispatchEvent(new NoRecommendDataEvent());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axke
 * JD-Core Version:    0.7.0.1
 */