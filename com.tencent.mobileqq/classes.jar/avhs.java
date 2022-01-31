import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.widget.QQToast;

class avhs
  implements DialogInterface.OnClickListener
{
  avhs(avhr paramavhr) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!bdin.g(this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
    {
      QQToast.a(this.a.a.jdField_a_of_type_AndroidViewView.getContext(), 1, alud.a(2131708649), 0).a();
      return;
    }
    ((avrb)this.a.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(263)).a(this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e, this.a.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j, new avht(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avhs
 * JD-Core Version:    0.7.0.1
 */