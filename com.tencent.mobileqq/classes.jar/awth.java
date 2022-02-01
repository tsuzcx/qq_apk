import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awth
  implements View.OnClickListener
{
  public awth(VideoPlayerPagerAdapter paramVideoPlayerPagerAdapter, ShortVideoCommentsView paramShortVideoCommentsView) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.l();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awth
 * JD-Core Version:    0.7.0.1
 */