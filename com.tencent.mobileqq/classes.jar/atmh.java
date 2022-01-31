import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class atmh
  implements DialogInterface.OnClickListener
{
  atmh(atmg paramatmg) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bbev.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      bcpw.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, ajyc.a(2131708254), 0).a();
      return;
    }
    ((atvq)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new atmi(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmh
 * JD-Core Version:    0.7.0.1
 */