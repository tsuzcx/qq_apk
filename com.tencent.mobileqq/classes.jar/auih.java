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

public class auih
  extends auik
  implements augp
{
  private SpannableString jdField_a_of_type_AndroidTextSpannableString;
  private audo jdField_a_of_type_Audo = new auij(this);
  protected SimpleFileViewer a;
  protected boolean a;
  
  public auih(augj paramaugj, Activity paramActivity)
  {
    super(paramaugj, paramActivity);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(this.jdField_a_of_type_Augj.c());
    if (aunj.c(this.jdField_a_of_type_Augj.d())) {
      b();
    }
    for (;;)
    {
      this.jdField_a_of_type_Augj.a(this);
      View localView1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
      if (localView1 != null)
      {
        View localView2 = localView1.findViewById(2131379251);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView2 = localView1.findViewById(2131366621);
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        localView1 = localView1.findViewById(2131366612);
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
      }
      return;
      c();
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
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleLocalFile: fileName[" + this.jdField_a_of_type_Augj.c() + "] filePath[" + this.jdField_a_of_type_Augj.d() + "]");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a();
    if ((localObject != null) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null) && (this.jdField_a_of_type_Auef != null) && (this.jdField_a_of_type_Auef.a() != null) && (this.jdField_a_of_type_Auef.a().c() != null) && (bhsi.B(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Auef.a().c())) && (((View)localObject).getParent() != null) && (((View)localObject).getParent().getParent() != null))
    {
      localObject = ((ViewGroup)((View)localObject).getParent().getParent()).findViewById(2131377290);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        bhsi.t(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Auef.a().c(), false);
        new MqqHandler().postDelayed(new DocExportFilePresenter.1(this, (View)localObject), 5000L);
      }
    }
    if (this.jdField_a_of_type_Augj.i() == 2) {
      audj.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Augj.d(), this.jdField_a_of_type_Audo, true);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(aunj.b(this.jdField_a_of_type_Augj.c()));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.f());
    this.jdField_a_of_type_AndroidAppActivity.getString(2131692151);
    if (this.jdField_a_of_type_Augj.b() == 16)
    {
      localObject = BaseApplicationImpl.getContext().getString(2131692151);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
    }
    if (QbSdk.isSuportOpenFile(aunj.f(this.jdField_a_of_type_Augj.c()), 2))
    {
      this.jdField_a_of_type_AndroidTextSpannableString = aunj.a(BaseApplicationImpl.getContext().getString(2131692471), BaseApplicationImpl.getContext().getString(2131694163), new auii(this));
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(this.jdField_a_of_type_AndroidTextSpannableString);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(true);
      return;
      localObject = BaseApplicationImpl.getContext().getString(2131692470);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c((String)localObject);
    }
  }
  
  protected void b(float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(anzj.a(2131702289) + (int)paramFloat + "%");
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
      QLog.i("DocExportFilePresenter<FileAssistant>", 1, "SimpleFilePresenter handleCloudFile: fileName[" + this.jdField_a_of_type_Augj.c() + "]");
    }
    int i = this.jdField_a_of_type_Augj.e();
    if (i == 5)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.d(2130844277);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(this.jdField_a_of_type_Augj.g());
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_Augj.h())) && (16 != this.jdField_a_of_type_Augj.b())) {
        break label182;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.e(false);
      label113:
      if (i != 1) {
        break label199;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692451));
      label134:
      if (this.jdField_a_of_type_Augj.b() != 16) {
        break label242;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692151));
    }
    label182:
    label199:
    label242:
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(aunj.b(this.jdField_a_of_type_Augj.c()));
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.g(this.jdField_a_of_type_Augj.h());
      break label113;
      if (i == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692455));
        break label134;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692452));
      break label134;
      if (this.jdField_a_of_type_Augj.d())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692324));
        return;
      }
      if (this.jdField_a_of_type_Augj.e())
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.c(BaseApplicationImpl.getContext().getString(2131692151));
        return;
      }
    } while ((!this.jdField_a_of_type_Augj.i()) || (this.jdField_a_of_type_Augj.a() == null));
    this.jdField_a_of_type_Augj.a().a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    b(0.0F);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(false);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(true);
    b(this.jdField_a_of_type_Augj.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.a(true);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
    if (this.jdField_a_of_type_Auef != null) {
      this.jdField_a_of_type_Auef.a();
    }
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerViewerSimpleFileViewer.b(false);
    h();
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
 * Qualified Name:     auih
 * JD-Core Version:    0.7.0.1
 */