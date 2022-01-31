import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.video.VipVideoPlayActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class appn
  extends appl
  implements View.OnClickListener, apnd
{
  protected long a;
  protected boolean a;
  
  public appn(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
  }
  
  public void a()
  {
    super.a();
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692858);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(str, false, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if ((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) || (this.jdField_a_of_type_Apnb.c()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(false);
      if (QLog.isDevelopLevel()) {
        QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
      }
    }
    if ((this.jdField_a_of_type_Apnb.a(this)) && (QLog.isColorLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "requestWhitelist 本地信息为空!!!!");
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 2, "clickPlay url = " + paramString1 + ", cookie = " + paramString2);
    }
    if (!TextUtils.isEmpty(paramString1))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, VipVideoPlayActivity.class);
      localIntent.putExtra("vtype", 2);
      localIntent.putExtra("video_url", paramString1);
      localIntent.putExtra("video_url_cookies", "FTN5K=" + paramString2);
      localIntent.putExtra("screenOrientation", "portrait");
      localIntent.putExtra("report_bus_type", "bus_type_troop_file_cloud_play");
      this.jdField_a_of_type_AndroidAppActivity.startActivityForResult(localIntent, 100);
    }
    this.jdField_a_of_type_Apnb.a(3);
  }
  
  public void aA_()
  {
    if (bbfj.h(BaseApplicationImpl.getContext())) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692859));
    }
    while (this.jdField_a_of_type_Apnb.i())
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(false);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692861));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(true);
  }
  
  public void aB_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(false);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_Apnb.a(4);
  }
  
  public void c() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
    return;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_Apnb.c())
    {
      bcql.a(BaseApplicationImpl.getContext(), 1, ajya.a(2131708427), 0).b(this.jdField_a_of_type_Apnb.l());
      return;
    }
    this.jdField_a_of_type_Apnb.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     appn
 * JD-Core Version:    0.7.0.1
 */