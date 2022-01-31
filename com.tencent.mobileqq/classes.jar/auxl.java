import com.tencent.mobileqq.nearby.now.SmallVideoFragment;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.CustomViewPager;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qphone.base.util.QLog;

public class auxl
  implements avbk
{
  public auxl(SmallVideoFragment paramSmallVideoFragment) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a() != null)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a().jdField_a_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a() == null) {
        break label168;
      }
    }
    label168:
    for (long l = this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a().jdField_a_of_type_Long;; l = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Native_ShortVideo_Report", 2, "onClickClose report module=short_video, action=view_click, obj1=6, res2=" + (String)localObject + ", anchor=" + l);
      }
      localObject = (VideoPlayerPagerAdapter)this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getAdapter();
      if ((((VideoPlayerPagerAdapter)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem()) instanceof ShortVideoCommentsView)) {
        ((ShortVideoCommentsView)((VideoPlayerPagerAdapter)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCustomViewPager.getCurrentItem())).j();
      }
      this.a.d();
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auxl
 * JD-Core Version:    0.7.0.1
 */