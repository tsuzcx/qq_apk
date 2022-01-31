import android.app.Activity;
import android.content.res.Configuration;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.DocExportFilePresenter.1;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.SimpleFileViewer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import mqq.os.MqqHandler;

public class apos
  extends apow
  implements apnf
{
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private apjj jdField_a_of_type_Apjj = new apou(this);
  protected SimpleFileViewer a;
  protected boolean a;
  
  public apos(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer = new SimpleFileViewer(this.jdField_a_of_type_AndroidAppActivity);
    a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer);
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = simple");
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Apnb.b());
    if (apug.c(this.jdField_a_of_type_Apnb.c())) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Apnb.a(this);
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
      if (localView1 != null)
      {
        View localView2 = localView1.findViewById(2131377640);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView2 = localView1.findViewById(2131366229);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView1 = localView1.findViewById(2131366219);
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
      }
      return;
      h();
    }
  }
  
  public void a(float paramFloat)
  {
    b(paramFloat);
  }
  
  public void a(Configuration paramConfiguration)
  {
    super.a(paramConfiguration);
    paramConfiguration = new DisplayMetrics();
    this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getMetrics(paramConfiguration);
    int i = paramConfiguration.widthPixels;
    int j = paramConfiguration.heightPixels;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(i, j);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(ajya.a(2131703401) + (int)paramFloat + "%");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a((int)paramFloat);
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidAppActivity.setRequestedOrientation(1);
    }
    return !this.jdField_a_of_type_Boolean;
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Apnb.b() + "] filePath[" + this.jdField_a_of_type_Apnb.c() + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.jdField_a_of_type_Apkq != null) && (this.jdField_a_of_type_Apkq.a() != null) && (this.jdField_a_of_type_Apkq.a().c() != null) && (bbkb.B(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apkq.a().c())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131375809);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        bbkb.s(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apkq.a().c(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.jdField_a_of_type_Apnb.i() == 2) {
      apjd.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apjj, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apug.b(this.jdField_a_of_type_Apnb.b()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apnb.d());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692483);
    if (this.jdField_a_of_type_Apnb.b() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131692483);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      if (QbSdk.isSuportOpenFile(apug.f(this.jdField_a_of_type_Apnb.b()), 2))
      {
        this.jdField_a_of_type_AndroidTextSpannableString = apug.a(BaseApplicationImpl.getContext().getString(2131692856), BaseApplicationImpl.getContext().getString(2131694909), new apot(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
      }
      else
      {
        localObject = BaseApplicationImpl.getContext().getString(2131692855);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    b(this.jdField_a_of_type_Apnb.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
    if (this.jdField_a_of_type_Apkq != null) {
      this.jdField_a_of_type_Apkq.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    b();
  }
  
  protected void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Apnb.b() + "]");
    }
    int i = this.jdField_a_of_type_Apnb.e();
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843444);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Apnb.e());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Apnb.f())) && (16 != this.jdField_a_of_type_Apnb.b())) {
        break label182;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      label113:
      if (i != 1) {
        break label199;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692836));
      label134:
      if (this.jdField_a_of_type_Apnb.b() != 16) {
        break label242;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692483));
    }
    label182:
    label199:
    label242:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apug.b(this.jdField_a_of_type_Apnb.b()));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Apnb.f());
      break label113;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692840));
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692837));
      break label134;
      if (this.jdField_a_of_type_Apnb.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692671));
        return;
      }
      if (this.jdField_a_of_type_Apnb.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692483));
        return;
      }
    } while ((!this.jdField_a_of_type_Apnb.i()) || (this.jdField_a_of_type_Apnb.a() == null));
    this.jdField_a_of_type_Apnb.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    b(0.0F);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e();
    }
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apos
 * JD-Core Version:    0.7.0.1
 */