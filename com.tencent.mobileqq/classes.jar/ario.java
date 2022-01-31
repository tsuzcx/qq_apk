import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.1.3;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ario
  extends bada
{
  ario(arin paramarin) {}
  
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
        azmj.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.h)) {
        break label136;
      }
      QQToast.a(localQQAppInterface.getApp(), 1, paramTeamWorkFileImportInfo.h, 0).a();
    }
    for (;;)
    {
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c())) {
        bafi.a(null, "0X800ABAD");
      }
      return;
      label136:
      QQToast.a(localQQAppInterface.getApp(), 1, 2131720789, 0).a();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    boolean bool;
    label39:
    int i;
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      if (paramTeamWorkFileImportInfo.l == 2)
      {
        bool = true;
        if (!bool) {
          break label443;
        }
        bafi.a(null, "0X800ABA7");
        if ((!bool) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqc != null)) {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqc.a(1, paramString, bool);
        }
        if ((arin.a(this.a)) && (bool)) {
          arin.a(this.a, true);
        }
        if (!bool)
        {
          if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000)) || (paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString == this.a.jdField_a_of_type_Arfz.j())) {
            break label452;
          }
          i = 1;
          label147:
          if (i != 0)
          {
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
            this.a.a(localArrayList, paramTeamWorkFileImportInfo.q, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          }
        }
        paramTeamWorkFileImportInfo.q = null;
        paramTeamWorkFileImportInfo.l = 0;
      }
    }
    else
    {
      if (paramTeamWorkFileImportInfo == null) {
        break label462;
      }
      if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 0) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 3000)) || (paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString == this.a.jdField_a_of_type_Arfz.j())) {
        break label457;
      }
      i = 1;
      label249:
      if ((i == 0) || (!paramTeamWorkFileImportInfo.b()) || (paramTeamWorkFileImportInfo.g != 0) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqe == null)) {
        break label462;
      }
      long l = bafi.a(paramTeamWorkFileImportInfo.k + "-" + paramTeamWorkFileImportInfo.d);
      if (l > 0L) {
        azmj.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqe.a(paramString, paramTeamWorkFileImportInfo, true, this.a.jdField_a_of_type_Arfz.j());
      paramString = new Intent();
      paramString.putExtra("uin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
      paramString.putExtra("uintype", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      this.a.a(2864, -1, paramString);
    }
    label443:
    label452:
    label457:
    label462:
    do
    {
      return;
      bool = false;
      break;
      bafi.a(null, "0X800ABA8");
      break label39;
      i = 0;
      break label147;
      i = 0;
      break label249;
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
    QQAppInterface localQQAppInterface;
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      aoto localaoto = aots.a();
      ThreadManager.getFileThreadHandler().post(new SimpleFilePresenter.1.2(this, localaoto, paramTeamWorkFileImportInfo, paramString2, localQQAppInterface, paramString1));
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.c()))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (paramTeamWorkFileImportInfo.l != 2) {
        break label125;
      }
    }
    label125:
    for (boolean bool = true;; bool = false)
    {
      paramTeamWorkFileImportInfo.l = 0;
      ThreadManager.getFileThreadHandler().post(new SimpleFilePresenter.1.3(this, bool, paramString2, localQQAppInterface, paramTeamWorkFileImportInfo, paramString1));
      return;
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
      String str = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131698772);
      if (paramTeamWorkFileImportInfo.b()) {
        str = alpo.a(2131714544);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.h(str);
      bafi.a(null, "0X800A21E");
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b())) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramTeamWorkFileImportInfo);
        arin.a(this.a, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      }
    }
    while ((paramTeamWorkFileImportInfo == null) || (!paramTeamWorkFileImportInfo.c()) || (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null)) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqc == null)
    {
      bafi.a(null, "0X800ABA4");
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(paramTeamWorkFileImportInfo);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.jdField_a_of_type_Arqc.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ario
 * JD-Core Version:    0.7.0.1
 */