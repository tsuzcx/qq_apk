import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

class aybg
  implements DialogInterface.OnClickListener
{
  aybg(aybf paramaybf) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!NetworkUtil.isNetworkAvailable(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, anvx.a(2131707713), 0).a();
      return;
    }
    ((ayks)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new aybh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybg
 * JD-Core Version:    0.7.0.1
 */