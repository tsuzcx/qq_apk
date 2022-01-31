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

public class aoxa
  extends aoxe
  implements aovo
{
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private aorv jdField_a_of_type_Aorv = new aoxc(this);
  protected SimpleFileViewer a;
  protected boolean a;
  
  public aoxa(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Aovk.b());
    if (apck.c(this.jdField_a_of_type_Aovk.c())) {
      c();
    }
    for (;;)
    {
      this.jdField_a_of_type_Aovk.a(this);
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
      if (localView1 != null)
      {
        View localView2 = localView1.findViewById(2131311825);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView2 = localView1.findViewById(2131300627);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView1 = localView1.findViewById(2131300617);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(ajjy.a(2131637605) + (int)paramFloat + "%");
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
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Aovk.b() + "] filePath[" + this.jdField_a_of_type_Aovk.c() + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.jdField_a_of_type_Aotc != null) && (this.jdField_a_of_type_Aotc.a() != null) && (this.jdField_a_of_type_Aotc.a().c() != null) && (baig.B(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aotc.a().c())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131310043);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        baig.s(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aotc.a().c(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.jdField_a_of_type_Aovk.i() == 2) {
      aorp.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aorv, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apck.b(this.jdField_a_of_type_Aovk.b()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aovk.d());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131626869);
    if (this.jdField_a_of_type_Aovk.b() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131626869);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      if (QbSdk.isSuportOpenFile(apck.f(this.jdField_a_of_type_Aovk.b()), 2))
      {
        this.jdField_a_of_type_AndroidTextSpannableString = apck.a(BaseApplicationImpl.getContext().getString(2131627217), BaseApplicationImpl.getContext().getString(2131629231), new aoxb(this));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
      }
      else
      {
        localObject = BaseApplicationImpl.getContext().getString(2131627216);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    b(this.jdField_a_of_type_Aovk.a());
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
    if (this.jdField_a_of_type_Aotc != null) {
      this.jdField_a_of_type_Aotc.a();
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
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Aovk.b() + "]");
    }
    int i = this.jdField_a_of_type_Aovk.e();
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130843361);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Aovk.e());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Aovk.f())) && (16 != this.jdField_a_of_type_Aovk.b())) {
        break label182;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(false);
      label113:
      if (i != 1) {
        break label199;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627197));
      label134:
      if (this.jdField_a_of_type_Aovk.b() != 16) {
        break label242;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131626869));
    }
    label182:
    label199:
    label242:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(apck.b(this.jdField_a_of_type_Aovk.b()));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.f(this.jdField_a_of_type_Aovk.f());
      break label113;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627201));
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627198));
      break label134;
      if (this.jdField_a_of_type_Aovk.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131627033));
        return;
      }
      if (this.jdField_a_of_type_Aovk.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131626869));
        return;
      }
    } while ((!this.jdField_a_of_type_Aovk.i()) || (this.jdField_a_of_type_Aovk.a() == null));
    this.jdField_a_of_type_Aovk.a().a();
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
 * Qualified Name:     aoxa
 * JD-Core Version:    0.7.0.1
 */