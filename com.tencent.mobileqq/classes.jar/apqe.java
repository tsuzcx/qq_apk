import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apqe
  extends apow
  implements apne, apnf, apng
{
  protected apri a;
  private List<apqk> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  public apqe(apnb paramapnb, Activity paramActivity)
  {
    super(paramapnb, paramActivity);
    this.jdField_a_of_type_Apri = new apri(paramActivity);
    a(this.jdField_a_of_type_Apri);
  }
  
  private void b(long paramLong)
  {
    if (apvd.b(this.jdField_a_of_type_Apnb.c()))
    {
      this.jdField_a_of_type_Apri.a(true, new apqf(this));
      this.jdField_a_of_type_Apri.a(ajya.a(2131717048), new apqg(this));
      this.jdField_a_of_type_Apri.a(true);
      SpannableString localSpannableString = apug.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692856), "用QQ浏览器打开", new apqh(this));
      this.jdField_a_of_type_Apri.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Apnb.b(16);
      this.jdField_a_of_type_Apri.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692483), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apri.a(false, null);
      return;
      this.jdField_a_of_type_Apri.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131720627), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Apnb.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Apri.b(true);
      this.jdField_a_of_type_Apri.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Apri.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Apri.a(true, ajya.a(2131717053) + "(" + bbdw.a(this.jdField_a_of_type_Apnb.c()) + ")", new apqi(this));
      return;
    }
    this.jdField_a_of_type_Apri.a(true, ajya.a(2131717050) + "(" + bbdw.a(this.jdField_a_of_type_Apnb.c()) + ")", new apqj(this));
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.i("FileBrowserPresenter<FileAssistant>", 1, "FileBrowserPresenter init: type = zip");
    }
    boolean bool;
    if ("1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId")))
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Apri.c(this.jdField_a_of_type_Apnb.b());
      this.jdField_a_of_type_Apri.d(ajya.a(2131717049) + this.jdField_a_of_type_JavaUtilList.size() + ajya.a(2131717054) + apvd.a(this.jdField_a_of_type_Apnb.c()));
      this.jdField_a_of_type_Apri.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Apnb.a(this);
      this.jdField_a_of_type_Apnb.a(this);
      c();
      if (bbfj.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label284;
      }
      bcql.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692321), 1).b(this.jdField_a_of_type_Apnb.l());
    }
    for (;;)
    {
      if (apvd.b(this.jdField_a_of_type_Apnb.c()))
      {
        this.jdField_a_of_type_Apri.c();
        this.jdField_a_of_type_Apri.b(false);
      }
      if ((this.jdField_a_of_type_Apnb.i()) && (this.jdField_a_of_type_Apnb.a() != null))
      {
        b(this.jdField_a_of_type_Apnb.a());
        this.jdField_a_of_type_Apri.b(true);
        this.jdField_a_of_type_Apri.c(false);
        this.jdField_a_of_type_Apnb.a().a();
      }
      this.jdField_a_of_type_Apnb.a(this);
      return;
      bool = false;
      break;
      label284:
      if (!this.d)
      {
        this.jdField_a_of_type_Apnb.g();
        this.d = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Apri.c(false);
    this.jdField_a_of_type_Apri.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Apri.b(paramString1, paramString2);
  }
  
  public void a(List<apqk> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Apri.a(paramList, this.jdField_a_of_type_Apnb.c(), this.jdField_a_of_type_Apnb.d(), this.jdField_a_of_type_Apnb.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Apri.d(ajya.a(2131717051) + this.jdField_a_of_type_JavaUtilList.size() + ajya.a(2131717052) + apvd.a(this.jdField_a_of_type_Apnb.c()));
      return;
    }
    QLog.e("FileBrowserPresenter<FileAssistant>", 1, "onGetZipFileList, mFiles is null");
    b(1L);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Apri.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apri.c(false);
    this.jdField_a_of_type_Apri.b(true);
    b(this.jdField_a_of_type_Apnb.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Apri.c(true);
    this.jdField_a_of_type_Apri.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Apri.c();
    this.jdField_a_of_type_Apri.b(false);
    if (this.jdField_a_of_type_Apkq != null) {
      this.jdField_a_of_type_Apkq.a();
    }
  }
  
  public void g()
  {
    m();
  }
  
  public void j()
  {
    super.j();
  }
  
  public void k()
  {
    if (this.d) {
      this.jdField_a_of_type_Apri.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Apnb.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Apnb.a() != null) {
        this.jdField_a_of_type_Apnb.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apri.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Apnb.a() != null) {
          this.jdField_a_of_type_Apnb.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqe
 * JD-Core Version:    0.7.0.1
 */