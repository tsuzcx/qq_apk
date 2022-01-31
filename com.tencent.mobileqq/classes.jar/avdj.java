import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;

class avdj
  implements DialogInterface.OnClickListener
{
  avdj(avdi paramavdi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdee.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, alpo.a(2131708637), 0).a();
      return;
    }
    ((avms)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new avdk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdj
 * JD-Core Version:    0.7.0.1
 */