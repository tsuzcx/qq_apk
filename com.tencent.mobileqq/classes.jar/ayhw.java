import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;

class ayhw
  implements DialogInterface.OnClickListener
{
  ayhw(ayhv paramayhv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bhnv.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, anzj.a(2131707134), 0).a();
      return;
    }
    ((ayrf)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new ayhx(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayhw
 * JD-Core Version:    0.7.0.1
 */