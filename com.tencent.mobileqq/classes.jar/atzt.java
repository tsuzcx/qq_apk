import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.filemanager.fileviewer.FileVideoOnlinePlayerFragment;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atzt
  extends atzr
  implements View.OnClickListener, atxe
{
  protected long a;
  protected boolean a;
  private boolean e;
  
  public atzt(atxa paramatxa, Activity paramActivity)
  {
    super(paramatxa, paramActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(false);
    if (((!TVK_SDKMgr.isInstalled(BaseApplicationImpl.getContext())) || (this.jdField_a_of_type_Atxa.c())) && (QLog.isDevelopLevel())) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    if ((this.jdField_a_of_type_Atxa.a(this)) && (QLog.isColorLevel())) {
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
      localIntent.putExtra("fileid", this.jdField_a_of_type_Atxa.n());
      localIntent.putExtra("url", paramString1);
      localIntent.putExtra("cookie", paramString2);
      localIntent.putExtra("public_fragment_window_feature", 1);
      aeow.a(this.jdField_a_of_type_AndroidAppActivity, localIntent, PublicFragmentActivity.class, FileVideoOnlinePlayerFragment.class);
    }
    this.jdField_a_of_type_Atxa.b(3);
  }
  
  protected void ar_()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Atxa.d())) {
      super.ar_();
    }
    while (!this.e) {
      return;
    }
    String str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692623);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(str, this);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.e);
  }
  
  public void at_()
  {
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692623);
    this.e = true;
    ar_();
  }
  
  public void au_()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
    if (QLog.isDevelopLevel()) {
      QLog.d("PreviewVideoSimpleFilePresenter", 4, "executeOnNetWorkThread setCanPreview false-------------");
    }
    this.jdField_a_of_type_Atxa.b(4);
  }
  
  public void c()
  {
    audr.a(2131718849);
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
      if (this.jdField_a_of_type_Atxa.c()) {
        QQToast.a(BaseApplicationImpl.getContext(), 1, anvx.a(2131707875), 0).b(this.jdField_a_of_type_Atxa.m());
      } else if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        audr.a(2131692469);
      } else {
        this.jdField_a_of_type_Atxa.a(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atzt
 * JD-Core Version:    0.7.0.1
 */