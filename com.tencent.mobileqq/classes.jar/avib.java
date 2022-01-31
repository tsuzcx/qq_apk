import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

public class avib
  implements GestureDetector.OnDoubleTapListener
{
  avib(avhf paramavhf) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - avhf.a(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 6)) {
        ((LikeAniView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131369428)).a(i, j);
      }
      if (!avhf.a(this.a)) {
        break label98;
      }
    }
    for (;;)
    {
      avhf.a(this.a, System.currentTimeMillis());
      return true;
      label98:
      if ((!avhf.b(this.a)) && (this.a.jdField_a_of_type_AndroidViewView.findViewById(2131369428).getVisibility() == 0))
      {
        avhf.a(this.a, false);
        this.a.c(null);
        new aveg().h("video").i("playpage_double_click").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ThreadManagerV2.excute(new PlayOperationViewModel.3.1(this, (auul)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avib
 * JD-Core Version:    0.7.0.1
 */