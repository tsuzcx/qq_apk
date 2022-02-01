import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class axjm
  implements View.OnClickListener
{
  axjm(axjl paramaxjl) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Axng.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.a.jdField_a_of_type_Axng.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjm
 * JD-Core Version:    0.7.0.1
 */