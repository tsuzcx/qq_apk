import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axvq
  implements View.OnClickListener
{
  axvq(axvp paramaxvp) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Axzk.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.jdField_a_of_type_Axzk.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axvq
 * JD-Core Version:    0.7.0.1
 */