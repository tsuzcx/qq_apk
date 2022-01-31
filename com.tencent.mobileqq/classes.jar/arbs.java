import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

final class arbs
  implements View.OnClickListener
{
  arbs(FileManagerEntity paramFileManagerEntity, ardn paramardn) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      paramView.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
      armz.d(BaseActivity.sTopActivity.getString(2131692912));
      if ((this.jdField_a_of_type_Ardn != null) && (this.jdField_a_of_type_Ardn.b())) {
        arni.a(paramView, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      }
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbs
 * JD-Core Version:    0.7.0.1
 */