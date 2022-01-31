import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class apiv
  implements View.OnClickListener
{
  apiv(FileManagerEntity paramFileManagerEntity, apkq paramapkq) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      paramView.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
      aptx.d(BaseActivity.sTopActivity.getString(2131692830));
      if ((this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.b())) {
        apug.a(paramView, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apiv
 * JD-Core Version:    0.7.0.1
 */