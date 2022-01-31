import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aotd
  implements bfoq
{
  aotd(aotc paramaotc, FileManagerEntity paramFileManagerEntity, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (QfileBaseRecentFileTabView.o(this.jdField_a_of_type_Aotc.a.a).a().b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId)) {}
    this.jdField_a_of_type_Aotc.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) && (3000 != this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType)) {
      QfileBaseRecentFileTabView.p(this.jdField_a_of_type_Aotc.a.a).a().a(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bDelInFM = true;
    QfileBaseRecentFileTabView.q(this.jdField_a_of_type_Aotc.a.a).a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_Aotc.a.a.g();
    if (this.jdField_a_of_type_Bfol.isShowing()) {
      this.jdField_a_of_type_Bfol.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aotd
 * JD-Core Version:    0.7.0.1
 */