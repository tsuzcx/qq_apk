import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.1;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.SimpleFilePresenter.InnerTeamWorkFileImportObserver.2;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class auji
  extends bebi
{
  private auji(aujd paramaujd) {}
  
  private void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString, boolean paramBoolean)
  {
    if (((paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 0) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 3000)) && (paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString != this.a.jdField_a_of_type_Augj.m())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
        this.a.a(localArrayList, paramString, paramBoolean, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
      }
      return;
    }
  }
  
  private void a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") != 0)
      {
        this.a.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.2(this));
        if (paramTeamWorkFileImportInfo.b()) {
          bebl.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_Augj.m());
        }
        bdll.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 2, 0, "", "", "", "");
        return;
      }
      b(paramJSONObject, paramTeamWorkFileImportInfo, paramString);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      bdll.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 3, 0, "", "", "", "");
      QLog.e("SimpleFilePresenter<FileAssistant>", 1, "direct share fail", paramJSONObject);
      QQToast.a(BaseApplicationImpl.getApplication(), 1, 2131718695, 0).a();
    }
  }
  
  private void b(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    ThreadManager.excute(new SimpleFilePresenter.InnerTeamWorkFileImportObserver.1(this, paramString, paramTeamWorkFileImportInfo), 128, null, false);
  }
  
  private void b(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    TencentDocData localTencentDocData = new TencentDocData();
    TencentDocData.obtainFromJsonObject(paramJSONObject, null, localTencentDocData);
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("key_flag_from_plugin", true);
    paramJSONObject.putExtra("k_forward_show_direct_share_tips", true);
    if (paramTeamWorkFileImportInfo.a())
    {
      paramJSONObject.setClass(this.a.jdField_a_of_type_AndroidAppActivity, ForwardRecentActivity.class);
      bhse.a(this.a.jdField_a_of_type_AndroidAppActivity, 1001, 95, "web_share", "", localTencentDocData.docIcon, localTencentDocData.title, localTencentDocData.summary, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131695740, new Object[] { localTencentDocData.title }), paramString, "web", null, null, null, "web", null, null, null, becb.d, this.a.jdField_a_of_type_AndroidAppActivity.getString(2131718648), "", paramJSONObject, -1, "https://docs.qq.com/desktop/m/index.html?_wv=2097154", -1L);
      bedq.a(null, "0X800A21F");
    }
    while (!paramTeamWorkFileImportInfo.b()) {
      return;
    }
    if (!aujd.c(this.a))
    {
      long l = bedq.a(paramTeamWorkFileImportInfo.k + "-" + paramTeamWorkFileImportInfo.d);
      if (l > 0L) {
        bdll.b(null, "dc00898", "", "", "0X800A62E", "0X800A62E", 0, 0, "", "", String.valueOf(l), "");
      }
      paramJSONObject = arqq.a();
      if (paramJSONObject.b(paramTeamWorkFileImportInfo.b))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString, Boolean.valueOf(false));
        return;
      }
      boolean bool = paramJSONObject.a(paramTeamWorkFileImportInfo.b);
      a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.m, bool);
      paramJSONObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      localTencentDocData.docUrl = paramString;
      becb.a(paramJSONObject, this.a.jdField_a_of_type_AndroidAppActivity, localTencentDocData, paramTeamWorkFileImportInfo);
      return;
    }
    bebl.a(paramTeamWorkFileImportInfo.m, this.a.jdField_a_of_type_Augj.m());
  }
  
  private void c(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    int i;
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c()))
    {
      if (paramTeamWorkFileImportInfo.l != 2) {
        break label99;
      }
      i = 1;
      if (i == 0) {
        break label104;
      }
      bedq.a(null, "0X800ABA7");
    }
    for (;;)
    {
      if (i == 0) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString, Boolean.valueOf(false));
      }
      if ((aujd.d(this.a)) && (i != 0)) {
        aujd.e(this.a, true);
      }
      if (i == 0) {
        a(paramTeamWorkFileImportInfo, paramTeamWorkFileImportInfo.q, true);
      }
      paramTeamWorkFileImportInfo.q = null;
      paramTeamWorkFileImportInfo.l = 0;
      return;
      label99:
      i = 0;
      break;
      label104:
      bedq.a(null, "0X800ABA8");
    }
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(paramInt);
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
        bdll.b(null, "dc00898", "", "", "0X800A627", "0X800A627", 1, 0, "", "", "", "");
      }
      if (TextUtils.isEmpty(paramTeamWorkFileImportInfo.h)) {
        break label174;
      }
      QQToast.a(localQQAppInterface.getApp(), 1, paramTeamWorkFileImportInfo.h, 0).a();
    }
    for (;;)
    {
      if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.c())) {
        bedq.a(null, "0X800ABAD");
      }
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 1)) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(3);
      }
      return;
      label174:
      QQToast.a(localQQAppInterface.getApp(), 1, 2131718695, 0).a();
    }
  }
  
  public void a(String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString, paramTeamWorkFileImportInfo);
    c(paramString, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0)))) {
      b(paramString, paramTeamWorkFileImportInfo);
    }
    while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
  }
  
  public void a(String paramString1, String paramString2, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.a(paramString1, paramString2, paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.b()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString1, null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
      aujd.a(this.a, false, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    }
    if ((paramTeamWorkFileImportInfo != null) && (paramString2 != null) && (paramTeamWorkFileImportInfo.c())) {
      if (paramTeamWorkFileImportInfo.l != 2) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      paramTeamWorkFileImportInfo.l = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramString1, Boolean.valueOf(bool));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(paramBoolean);
    }
  }
  
  public void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.b(paramTeamWorkFileImportInfo);
    String str;
    if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.a()) || ((paramTeamWorkFileImportInfo.b()) && (paramTeamWorkFileImportInfo.g == 0))) && (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null))
    {
      str = this.a.jdField_a_of_type_AndroidAppActivity.getString(2131697754);
      if (!paramTeamWorkFileImportInfo.b()) {
        break label149;
      }
      if (!arqq.a().b(paramTeamWorkFileImportInfo.b))
      {
        str = anzj.a(2131697481);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.i(str);
      }
    }
    for (;;)
    {
      bedq.a(null, "0X800A21E");
      if ((paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.c()) || (paramTeamWorkFileImportInfo.b())) && (paramTeamWorkFileImportInfo.g == 1))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(paramTeamWorkFileImportInfo);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(1);
      }
      return;
      label149:
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.i(str);
    }
  }
  
  public void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    super.c(paramTeamWorkFileImportInfo);
    if ((paramTeamWorkFileImportInfo != null) && (paramTeamWorkFileImportInfo.b()))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(4);
      aujd.a(this.a, true, paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
    }
    while ((paramTeamWorkFileImportInfo == null) || (!paramTeamWorkFileImportInfo.c())) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(5);
    bedq.a(null, "0X800ABA4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auji
 * JD-Core Version:    0.7.0.1
 */