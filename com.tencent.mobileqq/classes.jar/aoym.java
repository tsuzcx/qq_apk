import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class aoym
  extends aoxe
  implements aovn, aovo, aovp
{
  protected aozk a;
  private List<aoys> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  public aoym(aovk paramaovk, Activity paramActivity)
  {
    super(paramaovk, paramActivity);
    this.jdField_a_of_type_Aozk = new aozk(paramActivity);
    a(this.jdField_a_of_type_Aozk);
  }
  
  private void b(long paramLong)
  {
    if (apdh.b(this.jdField_a_of_type_Aovk.c()))
    {
      this.jdField_a_of_type_Aozk.a(true, new aoyn(this));
      this.jdField_a_of_type_Aozk.a(ajjy.a(2131651246), new aoyo(this));
      this.jdField_a_of_type_Aozk.a(true);
      SpannableString localSpannableString = apck.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131627217), "用QQ浏览器打开", new aoyp(this));
      this.jdField_a_of_type_Aozk.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Aovk.b(16);
      this.jdField_a_of_type_Aozk.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131626869), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aozk.a(false, null);
      return;
      this.jdField_a_of_type_Aozk.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131654718), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Aovk.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Aozk.b(true);
      this.jdField_a_of_type_Aozk.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Aozk.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Aozk.a(true, ajjy.a(2131651251) + "(" + bacd.a(this.jdField_a_of_type_Aovk.c()) + ")", new aoyq(this));
      return;
    }
    this.jdField_a_of_type_Aozk.a(true, ajjy.a(2131651248) + "(" + bacd.a(this.jdField_a_of_type_Aovk.c()) + ")", new aoyr(this));
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
      this.jdField_a_of_type_Aozk.c(this.jdField_a_of_type_Aovk.b());
      this.jdField_a_of_type_Aozk.d(ajjy.a(2131651247) + this.jdField_a_of_type_JavaUtilList.size() + ajjy.a(2131651252) + apdh.a(this.jdField_a_of_type_Aovk.c()));
      this.jdField_a_of_type_Aozk.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Aovk.a(this);
      this.jdField_a_of_type_Aovk.a(this);
      c();
      if (badq.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label284;
      }
      bbmy.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131626719), 1).b(this.jdField_a_of_type_Aovk.l());
    }
    for (;;)
    {
      if (apdh.b(this.jdField_a_of_type_Aovk.c()))
      {
        this.jdField_a_of_type_Aozk.c();
        this.jdField_a_of_type_Aozk.b(false);
      }
      if ((this.jdField_a_of_type_Aovk.i()) && (this.jdField_a_of_type_Aovk.a() != null))
      {
        b(this.jdField_a_of_type_Aovk.a());
        this.jdField_a_of_type_Aozk.b(true);
        this.jdField_a_of_type_Aozk.c(false);
        this.jdField_a_of_type_Aovk.a().a();
      }
      this.jdField_a_of_type_Aovk.a(this);
      return;
      bool = false;
      break;
      label284:
      if (!this.d)
      {
        this.jdField_a_of_type_Aovk.g();
        this.d = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Aozk.c(false);
    this.jdField_a_of_type_Aozk.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Aozk.b(paramString1, paramString2);
  }
  
  public void a(List<aoys> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Aozk.a(paramList, this.jdField_a_of_type_Aovk.c(), this.jdField_a_of_type_Aovk.d(), this.jdField_a_of_type_Aovk.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Aozk.d(ajjy.a(2131651249) + this.jdField_a_of_type_JavaUtilList.size() + ajjy.a(2131651250) + apdh.a(this.jdField_a_of_type_Aovk.c()));
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
    this.jdField_a_of_type_Aozk.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Aozk.c(false);
    this.jdField_a_of_type_Aozk.b(true);
    b(this.jdField_a_of_type_Aovk.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Aozk.c(true);
    this.jdField_a_of_type_Aozk.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Aozk.c();
    this.jdField_a_of_type_Aozk.b(false);
    if (this.jdField_a_of_type_Aotc != null) {
      this.jdField_a_of_type_Aotc.a();
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
      this.jdField_a_of_type_Aozk.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Aovk.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Aovk.a() != null) {
        this.jdField_a_of_type_Aovk.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Aozk.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Aovk.a() != null) {
          this.jdField_a_of_type_Aovk.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoym
 * JD-Core Version:    0.7.0.1
 */