import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.2;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import mqq.os.MqqHandler;

public class aoxx
  extends axey
{
  aoxx(aoxw paramaoxw) {}
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(paramInt);
    }
  }
  
  public void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramTeamWorkFileImportInfo);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
    }
    QQAppInterface localQQAppInterface;
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramTeamWorkFileImportInfo.b()) {
        awqx.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.h)) {
        bbmy.a(localQQAppInterface.getApp(), 1, paramTeamWorkFileImportInfo.h, 0).a();
      }
    }
    else
    {
      return;
    }
    bbmy.a(localQQAppInterface.getApp(), 1, 2131654348, 0).a();
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    int i;
    if (paramTeamWorkFileImportInfo != null) {
      if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString != this.a.jdField_a_of_type_Aovk.h()))
      {
        i = 1;
        if ((i == 0) || (!paramTeamWorkFileImportInfo.b()) || (paramTeamWorkFileImportInfo.g != 0) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a == null)) {
          break label247;
        }
        long l = axhg.a(paramTeamWorkFileImportInfo.k + "-" + paramTeamWorkFileImportInfo.d);
        if (l > 0L) {
          awqx.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a.a(paramString, paramTeamWorkFileImportInfo, true, this.a.jdField_a_of_type_Aovk.h());
        paramString = new Intent();
        paramString.putExtra("uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        paramString.putExtra("uintype", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
        this.a.a(2864, -1, paramString);
      }
    }
    label247:
    do
    {
      return;
      i = 0;
      break;
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))))
      {
        ThreadManager.excute(new SimpleFilePresenter.1.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
        return;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
  }
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      amlv localamlv = amlz.a();
      ThreadManager.getFileThreadHandler().post(new SimpleFilePresenter.1.2(this, localamlv, paramTeamWorkFileImportInfo, paramString2, localQQAppInterface, paramString1));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(paramBoolean);
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.b(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null))
    {
      String str = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131632731);
      if (paramTeamWorkFileImportInfo.b()) {
        str = ajjy.a(2131648373);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.h(str);
      axhg.a(null, "0X800A21E");
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b()) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramTeamWorkFileImportInfo);
      aoxw.a(this.a, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoxx
 * JD-Core Version:    0.7.0.1
 */