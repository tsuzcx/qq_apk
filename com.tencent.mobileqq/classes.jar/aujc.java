import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aujc
  extends auja
  implements View.OnClickListener, augn
{
  protected long a;
  protected boolean a;
  private boolean e;
  
  public aujc(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if (((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) || (this.jdField_a_of_type_Augj.c())) && (QLog.isDevelopLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    if ((this.jdField_a_of_type_Augj.a(this)) && (QLog.isColorLevel())) {
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
      Intent localIntent = new Intent();
      localIntent.putExtra("fileid", this.jdField_a_of_type_Augj.n());
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("cookie", paramString2);
      localIntent.putExtra("public_fragment_window_feature", 1);
      afez.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.jdField_a_of_type_Augj.b(3);
  }
  
  protected void aA_()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
    if (bhmi.b(this.jdField_a_of_type_Augj.d())) {
      super.aA_();
    }
    while (!this.e) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692473);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
  }
  
  public void aC_()
  {
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692473);
    this.e = true;
    aA_();
  }
  
  public void aD_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_Augj.b(4);
  }
  
  public void c()
  {
    auna.a(2131718222);
  }
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
      if (QLog.isColorLevel()) {
        QLog.d("PreviewVideoSimpleFilePresenter", 2, "click online preview video too fast");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (this.jdField_a_of_type_Augj.c()) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, anzj.a(2131707296), 0).b(this.jdField_a_of_type_Augj.m());
      } else if (!bhnv.d(BaseApplication.getContext())) {
        auna.a(2131692319);
      } else {
        this.jdField_a_of_type_Augj.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujc
 * JD-Core Version:    0.7.0.1
 */