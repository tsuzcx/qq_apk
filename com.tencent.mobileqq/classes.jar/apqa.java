import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class apqa
  extends apos
  implements apna, apnb, apnc
{
  protected apre a;
  private List<apqg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  public apqa(apmx paramapmx, Activity paramActivity)
  {
    super(paramapmx, paramActivity);
    this.jdField_a_of_type_Apre = new apre(paramActivity);
    a(this.jdField_a_of_type_Apre);
  }
  
  private void b(long paramLong)
  {
    if (apvb.b(this.jdField_a_of_type_Apmx.c()))
    {
      this.jdField_a_of_type_Apre.a(true, new apqb(this));
      this.jdField_a_of_type_Apre.a(ajyc.a(2131717037), new apqc(this));
      this.jdField_a_of_type_Apre.a(true);
      SpannableString localSpannableString = apue.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692855), "用QQ浏览器打开", new apqd(this));
      this.jdField_a_of_type_Apre.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Apmx.b(16);
      this.jdField_a_of_type_Apre.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692482), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Apre.a(false, null);
      return;
      this.jdField_a_of_type_Apre.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131720616), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Apmx.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Apre.b(true);
      this.jdField_a_of_type_Apre.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Apre.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Apre.a(true, ajyc.a(2131717042) + "(" + bbdi.a(this.jdField_a_of_type_Apmx.c()) + ")", new apqe(this));
      return;
    }
    this.jdField_a_of_type_Apre.a(true, ajyc.a(2131717039) + "(" + bbdi.a(this.jdField_a_of_type_Apmx.c()) + ")", new apqf(this));
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
      this.jdField_a_of_type_Apre.c(this.jdField_a_of_type_Apmx.b());
      this.jdField_a_of_type_Apre.d(ajyc.a(2131717038) + this.jdField_a_of_type_JavaUtilList.size() + ajyc.a(2131717043) + apvb.a(this.jdField_a_of_type_Apmx.c()));
      this.jdField_a_of_type_Apre.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Apmx.a(this);
      this.jdField_a_of_type_Apmx.a(this);
      c();
      if (bbev.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label284;
      }
      bcpw.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692321), 1).b(this.jdField_a_of_type_Apmx.l());
    }
    for (;;)
    {
      if (apvb.b(this.jdField_a_of_type_Apmx.c()))
      {
        this.jdField_a_of_type_Apre.c();
        this.jdField_a_of_type_Apre.b(false);
      }
      if ((this.jdField_a_of_type_Apmx.i()) && (this.jdField_a_of_type_Apmx.a() != null))
      {
        b(this.jdField_a_of_type_Apmx.a());
        this.jdField_a_of_type_Apre.b(true);
        this.jdField_a_of_type_Apre.c(false);
        this.jdField_a_of_type_Apmx.a().a();
      }
      this.jdField_a_of_type_Apmx.a(this);
      return;
      bool = false;
      break;
      label284:
      if (!this.d)
      {
        this.jdField_a_of_type_Apmx.g();
        this.d = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Apre.c(false);
    this.jdField_a_of_type_Apre.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Apre.b(paramString1, paramString2);
  }
  
  public void a(List<apqg> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Apre.a(paramList, this.jdField_a_of_type_Apmx.c(), this.jdField_a_of_type_Apmx.d(), this.jdField_a_of_type_Apmx.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Apre.d(ajyc.a(2131717040) + this.jdField_a_of_type_JavaUtilList.size() + ajyc.a(2131717041) + apvb.a(this.jdField_a_of_type_Apmx.c()));
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
    this.jdField_a_of_type_Apre.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Apre.c(false);
    this.jdField_a_of_type_Apre.b(true);
    b(this.jdField_a_of_type_Apmx.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Apre.c(true);
    this.jdField_a_of_type_Apre.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Apre.c();
    this.jdField_a_of_type_Apre.b(false);
    if (this.jdField_a_of_type_Apkm != null) {
      this.jdField_a_of_type_Apkm.a();
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
      this.jdField_a_of_type_Apre.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Apmx.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Apmx.a() != null) {
        this.jdField_a_of_type_Apmx.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Apre.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Apmx.a() != null) {
          this.jdField_a_of_type_Apmx.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqa
 * JD-Core Version:    0.7.0.1
 */