import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class audb
  implements View.OnClickListener
{
  audb(FileManagerEntity paramFileManagerEntity, auef paramauef) {}
  
  public void onClick(View paramView)
  {
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
      auna.d(BaseActivity.sTopActivity.getString(2131692445));
      if ((this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.c())) {
        aunj.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      }
      label70:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audb
 * JD-Core Version:    0.7.0.1
 */