import android.app.Activity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.StoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.1;
import com.tencent.mobileqq.nearby.now.view.logic.VideoInfoListenerImpl.3;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class avgh
  implements avgg
{
  int jdField_a_of_type_Int = -1;
  private avfw jdField_a_of_type_Avfw;
  private StoryPlayController jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController;
  private ShortVideoCommentsView jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView;
  private HorizontalBallLoadingView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView;
  Runnable jdField_a_of_type_JavaLangRunnable = new VideoInfoListenerImpl.3(this);
  private final String jdField_a_of_type_JavaLangString = "VideoInfoListener";
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public avgh(avfw paramavfw, StoryPlayController paramStoryPlayController, ShortVideoCommentsView paramShortVideoCommentsView, boolean paramBoolean)
  {
    this.jdField_a_of_type_Avfw = paramavfw;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController = paramStoryPlayController;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView = paramShortVideoCommentsView;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onComplete");
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (((Activity)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new VideoInfoListenerImpl.1(this), 1000L);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 0) || (this.jdField_a_of_type_Int == paramInt)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    int i = paramInt;
    if (paramInt > 100) {
      i = 100;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a.a(this.jdField_a_of_type_Avfw.jdField_a_of_type_Int, i);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewStuffContainerView.a.a(0, i);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onCoverComplete() called with: imageWidth = [" + paramInt1 + "], imageHeight = [" + paramInt2 + "], isSuc = [" + paramBoolean + "]");
    }
    this.b = paramInt1;
    this.c = paramInt2;
    if ((paramBoolean) && (this.jdField_a_of_type_Boolean)) {
      avej.a(this.jdField_a_of_type_Avfw, paramInt1, paramInt2);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPrepareVideo");
    }
    if (this.jdField_a_of_type_Avfw == null) {}
    do
    {
      return;
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a != null) && (((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_Avfw.jdField_a_of_type_Int)).jdField_a_of_type_Int != 4)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a.setVisibility(8);
      }
    } while (this.jdField_a_of_type_Avfw == null);
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPlaying");
    }
    VideoData localVideoData;
    if (this.jdField_a_of_type_Avfw != null)
    {
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a != null) && (((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_Avfw.jdField_a_of_type_Int)).jdField_a_of_type_Int != 4)) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.a.setVisibility(8);
      }
      g();
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.e();
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
      if ((this.jdField_a_of_type_Avfw.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_Avfw.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size()))
      {
        localVideoData = (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_Avfw.jdField_a_of_type_Int);
        if (1 != localVideoData.jdField_a_of_type_Int) {
          break label195;
        }
      }
    }
    label195:
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int != this.jdField_a_of_type_Avfw.jdField_a_of_type_Int)
    {
      return;
      QLog.e("VideoInfoListener", 1, "mHolder == null!");
      return;
    }
    localVideoData.c = true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onDoingStartPlayback");
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.k();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfoListener", 2, "VideoInfoListenerImpl onLayoutChange");
    }
    if (this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getVisibility() == 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.size() > this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int) && (((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int)).jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        avej.a(this.jdField_a_of_type_Avfw, ((avcr)((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int)).jdField_a_of_type_JavaUtilArrayList.get(0)).b, ((avcr)((VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int)).jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_a_of_type_Int, (VideoData)this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter.a.get(this.jdField_a_of_type_ComTencentMobileqqNearbyNowStoryPlayController.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView);
      }
    }
    while ((this.b <= 0) || (this.c <= 0)) {
      return;
    }
    avej.a(this.jdField_a_of_type_Avfw, this.b, this.c);
  }
  
  public void f()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("showLoading： mHorizontalBallLoadingView is null? : ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null) {
        break label76;
      }
    }
    label76:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VideoInfoListener", 2, bool);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369767));
      ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      return;
    }
  }
  
  public void g()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("hideLoading： mHorizontalBallLoadingView is null? : ");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null) {
        break label61;
      }
    }
    label61:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("VideoInfoListener", 2, bool);
      ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = null;
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avgh
 * JD-Core Version:    0.7.0.1
 */