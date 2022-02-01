import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3.1;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

public class aybp
  implements GestureDetector.OnDoubleTapListener
{
  aybp(ayat paramayat) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - ayat.a(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 6)) {
        ((LikeAniView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370084)).a(i, j);
      }
      if (!ayat.a(this.a)) {
        break label98;
      }
    }
    for (;;)
    {
      ayat.a(this.a, System.currentTimeMillis());
      return true;
      label98:
      if ((!ayat.b(this.a)) && (this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370084).getVisibility() == 0))
      {
        ayat.a(this.a, false);
        this.a.c(null);
        new axxu().h("video").i("playpage_double_click").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ThreadManagerV2.excute(new PlayOperationViewModel.3.1(this, (axny)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
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
 * Qualified Name:     aybp
 * JD-Core Version:    0.7.0.1
 */