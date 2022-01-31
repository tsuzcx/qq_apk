import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;

class atmj
  implements DialogInterface.OnClickListener
{
  atmj(atmi paramatmi) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bbfj.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      bcql.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, ajya.a(2131708265), 0).a();
      return;
    }
    ((atvs)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new atmk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atmj
 * JD-Core Version:    0.7.0.1
 */