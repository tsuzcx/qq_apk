import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

public class awvn
  implements GestureDetector.OnDoubleTapListener
{
  awvn(awur paramawur) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - awur.a(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 6)) {
        ((LikeAniView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131369914)).a(i, j);
      }
      if (!awur.a(this.a)) {
        break label98;
      }
    }
    for (;;)
    {
      awur.a(this.a, System.currentTimeMillis());
      return true;
      label98:
      if ((!awur.b(this.a)) && (this.a.jdField_a_of_type_AndroidViewView.findViewById(2131369914).getVisibility() == 0))
      {
        awur.a(this.a, false);
        this.a.c(null);
        new awrs().h("video").i("playpage_double_click").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ThreadManagerV2.excute(new PlayOperationViewModel.3.1(this, (awhw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
      }
    }
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvn
 * JD-Core Version:    0.7.0.1
 */