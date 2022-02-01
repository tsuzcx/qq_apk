import android.view.View;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;

public class aycf
  implements ayfr
{
  public aycf(StoryPlayController paramStoryPlayController, ayga paramayga, VideoData paramVideoData) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().a.findViewById(2131369920).setVisibility(0);
    }
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a.c();
  }
  
  public void a(String paramString, View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView != null) {
      this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a().a.findViewById(2131369920).setVisibility(8);
    }
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a();
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
    this.jdField_a_of_type_Ayga.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new aycg(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycf
 * JD-Core Version:    0.7.0.1
 */