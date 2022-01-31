import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;

final class arfy
  implements View.OnClickListener
{
  arfy(FileManagerEntity paramFileManagerEntity, Activity paramActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    TeamWorkFileImportInfo localTeamWorkFileImportInfo;
    label96:
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_AndroidAppActivity != null))
    {
      paramView = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (this.jdField_a_of_type_Boolean)
      {
        bajr.a(null, "0X800A21D");
        localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
        localTeamWorkFileImportInfo.c = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath;
        localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        localTeamWorkFileImportInfo.jdField_e_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType;
        if (!this.jdField_a_of_type_Boolean) {
          break label232;
        }
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 8;
        localTeamWorkFileImportInfo.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
        if (!(this.jdField_a_of_type_AndroidAppActivity instanceof FileBrowserActivity)) {
          break label401;
        }
        bool2 = ((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).f();
        if ((!((FileBrowserActivity)this.jdField_a_of_type_AndroidAppActivity).b()) || (bool2)) {
          break label241;
        }
        bool1 = true;
        label148:
        localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = bool1;
      }
    }
    label401:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if ((bool1) && (!bdhb.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath())))
      {
        QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720682), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
        return;
        azqs.b(paramView, "dc00898", "", "", "0X8009063", "0X8009063", 0, 0, "", "", "", "");
        break;
        label232:
        localTeamWorkFileImportInfo.jdField_d_of_type_Int = 5;
        break label96;
        label241:
        bool1 = false;
        break label148;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin))
      {
        localTeamWorkFileImportInfo.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
        localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.TroopUin);
        localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strTroopFilePath;
        localTeamWorkFileImportInfo.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.busId;
        localTeamWorkFileImportInfo.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
          localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
        }
      }
      bagk.a(localTeamWorkFileImportInfo, this.jdField_a_of_type_AndroidAppActivity, paramView, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
      return;
      QQToast.a(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(2131720677), 0).b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131298914));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arfy
 * JD-Core Version:    0.7.0.1
 */