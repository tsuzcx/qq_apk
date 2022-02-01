import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awpo
  implements View.OnClickListener
{
  awpo(awpn paramawpn) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Awti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.jdField_a_of_type_Awti.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpo
 * JD-Core Version:    0.7.0.1
 */