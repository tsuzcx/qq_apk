import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.fileviewer.presenter.ZipFilePresenter.2;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.List;

public class aswb
  extends asuu
  implements assy, assz, asta
{
  protected asxe a;
  private List<aswh> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  private boolean e;
  
  public aswb(asst paramasst, Activity paramActivity)
  {
    super(paramasst, paramActivity);
    this.jdField_a_of_type_Asxe = new asxe(paramActivity);
    a(this.jdField_a_of_type_Asxe);
  }
  
  private void b(long paramLong)
  {
    this.jdField_a_of_type_Asxe.f(false);
    this.jdField_a_of_type_Asxe.d(true);
    b();
    if (FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d()))
    {
      this.jdField_a_of_type_Asxe.a(amtj.a(2131692525), new aswc(this));
      this.jdField_a_of_type_Asxe.a(true);
    }
    while (paramLong == -1000L) {
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Asst.a(16);
      this.jdField_a_of_type_Asxe.f(this.jdField_a_of_type_AndroidAppActivity.getString(2131692199));
      this.jdField_a_of_type_Asxe.e(false);
      return;
    }
    this.jdField_a_of_type_Asxe.e(false);
  }
  
  private void c()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new ZipFilePresenter.2(this), 3000L);
  }
  
  private void q()
  {
    int i = this.jdField_a_of_type_Asst.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Asxe.b(true);
      this.jdField_a_of_type_Asxe.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Asxe.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Asxe.a(true, amtj.a(2131716049) + "(" + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new aswf(this));
      return;
    }
    this.jdField_a_of_type_Asxe.a(true, amtj.a(2131716046) + "(" + bfvi.a(this.jdField_a_of_type_Asst.c()) + ")", new aswg(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("ZipFilePresenter<QFile>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Asxe.h(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Asxe.c(this.jdField_a_of_type_Asst.c());
      this.jdField_a_of_type_Asxe.d(this.jdField_a_of_type_Asst.f());
      this.jdField_a_of_type_Asxe.e(amtj.a(2131716045) + this.jdField_a_of_type_JavaUtilList.size() + amtj.a(2131716050) + FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()));
      this.jdField_a_of_type_Asst.a(this);
      this.jdField_a_of_type_Asst.a(this);
      if (NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) {
        break label265;
      }
      b(-1000L);
    }
    for (;;)
    {
      if ((!FileUtil.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d())) && (this.jdField_a_of_type_Asst.i()) && (this.jdField_a_of_type_Asst.a() != null))
      {
        b(this.jdField_a_of_type_Asst.a());
        this.jdField_a_of_type_Asxe.b(true);
        this.jdField_a_of_type_Asxe.c(false);
        this.jdField_a_of_type_Asxe.a(false);
        this.jdField_a_of_type_Asst.a().a();
      }
      this.jdField_a_of_type_Asst.a(this);
      return;
      bool = false;
      break;
      label265:
      if (!this.d)
      {
        this.jdField_a_of_type_Asst.f();
        this.d = true;
        this.jdField_a_of_type_Asxe.f(true);
        this.e = true;
        c();
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Asxe.c(false);
    this.jdField_a_of_type_Asxe.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    this.e = false;
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Asxe.b(paramString1, paramString2);
  }
  
  public void a(List<aswh> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (!this.e) {
      return;
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Asxe.a(paramList, this.jdField_a_of_type_Asst.d(), this.jdField_a_of_type_Asst.d(), this.jdField_a_of_type_Asst.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Asxe.e(amtj.a(2131716047) + this.jdField_a_of_type_JavaUtilList.size() + amtj.a(2131716048) + FileUtil.filesizeToString(this.jdField_a_of_type_Asst.c()));
      q();
    }
    for (;;)
    {
      this.e = false;
      return;
      QLog.e("ZipFilePresenter<QFile>", 1, "onGetZipFileList, mFiles is null");
      b(-1000L);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected void b()
  {
    String str;
    if (FileUtils.fileExistsAndNotEmpty(this.jdField_a_of_type_Asst.d())) {
      if (QbSdk.isSuportOpenFile(aszt.f(this.jdField_a_of_type_Asst.c()), 2))
      {
        str = this.jdField_a_of_type_AndroidAppActivity.getString(2131694266);
        this.jdField_a_of_type_Asxe.b(str, new aswd(this));
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Asst.i() == 4) {
        this.jdField_a_of_type_Asxe.e(false);
      }
      return;
      str = this.jdField_a_of_type_AndroidAppActivity.getString(2131692521);
      this.jdField_a_of_type_Asxe.b(str, new aswe(this));
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Asxe.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Asxe.c(false);
    this.jdField_a_of_type_Asxe.a(false);
    this.jdField_a_of_type_Asxe.b(true);
    b(this.jdField_a_of_type_Asst.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Asxe.c(true);
    this.jdField_a_of_type_Asxe.b(false);
    q();
    h();
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Asxe.c();
    this.jdField_a_of_type_Asxe.b(false);
    if (this.jdField_a_of_type_Asqp != null) {
      this.jdField_a_of_type_Asqp.a();
    }
    h();
    b();
  }
  
  public void g()
  {
    m();
    h();
    b();
  }
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    if (this.d) {
      this.jdField_a_of_type_Asxe.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Asst.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Asst.a() != null) {
        this.jdField_a_of_type_Asst.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Asxe.b(false);
      q();
      h();
      b();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Asst.a() != null) {
          this.jdField_a_of_type_Asst.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("ZipFilePresenter<QFile>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswb
 * JD-Core Version:    0.7.0.1
 */