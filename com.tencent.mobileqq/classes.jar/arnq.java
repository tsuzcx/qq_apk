import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class arnq
  extends armd
  implements arkn, arko, arkp
{
  protected arot a;
  private List<arnw> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  public arnq(arki paramarki, Activity paramActivity)
  {
    super(paramarki, paramActivity);
    this.jdField_a_of_type_Arot = new arot(paramActivity);
    a(this.jdField_a_of_type_Arot);
  }
  
  private void b(long paramLong)
  {
    if (arso.b(this.jdField_a_of_type_Arki.d()))
    {
      this.jdField_a_of_type_Arot.a(true, new arnr(this));
      this.jdField_a_of_type_Arot.a(alud.a(2131717432), new arns(this));
      this.jdField_a_of_type_Arot.a(true);
      SpannableString localSpannableString = arrr.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692940), "用QQ浏览器打开", new arnt(this));
      this.jdField_a_of_type_Arot.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Arki.b(16);
      this.jdField_a_of_type_Arot.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692560), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Arot.a(false, null);
      return;
      this.jdField_a_of_type_Arot.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131721180), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Arki.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Arot.b(true);
      this.jdField_a_of_type_Arot.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Arot.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Arot.a(true, alud.a(2131717437) + "(" + bdha.a(this.jdField_a_of_type_Arki.c()) + ")", new arnu(this));
      return;
    }
    this.jdField_a_of_type_Arot.a(true, alud.a(2131717434) + "(" + bdha.a(this.jdField_a_of_type_Arki.c()) + ")", new arnv(this));
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
      this.jdField_a_of_type_Arot.c(this.jdField_a_of_type_Arki.c());
      this.jdField_a_of_type_Arot.d(alud.a(2131717433) + this.jdField_a_of_type_JavaUtilList.size() + alud.a(2131717438) + arso.a(this.jdField_a_of_type_Arki.c()));
      this.jdField_a_of_type_Arot.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Arki.a(this);
      this.jdField_a_of_type_Arki.a(this);
      c();
      if (bdin.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label284;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692398), 1).b(this.jdField_a_of_type_Arki.l());
    }
    for (;;)
    {
      if (arso.b(this.jdField_a_of_type_Arki.d()))
      {
        this.jdField_a_of_type_Arot.c();
        this.jdField_a_of_type_Arot.b(false);
      }
      if ((this.jdField_a_of_type_Arki.i()) && (this.jdField_a_of_type_Arki.a() != null))
      {
        b(this.jdField_a_of_type_Arki.a());
        this.jdField_a_of_type_Arot.b(true);
        this.jdField_a_of_type_Arot.c(false);
        this.jdField_a_of_type_Arki.a().a();
      }
      this.jdField_a_of_type_Arki.a(this);
      return;
      bool = false;
      break;
      label284:
      if (!this.d)
      {
        this.jdField_a_of_type_Arki.f();
        this.d = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Arot.c(false);
    this.jdField_a_of_type_Arot.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Arot.b(paramString1, paramString2);
  }
  
  public void a(List<arnw> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Arot.a(paramList, this.jdField_a_of_type_Arki.d(), this.jdField_a_of_type_Arki.d(), this.jdField_a_of_type_Arki.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Arot.d(alud.a(2131717435) + this.jdField_a_of_type_JavaUtilList.size() + alud.a(2131717436) + arso.a(this.jdField_a_of_type_Arki.c()));
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
    this.jdField_a_of_type_Arot.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arot.c(false);
    this.jdField_a_of_type_Arot.b(true);
    b(this.jdField_a_of_type_Arki.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Arot.c(true);
    this.jdField_a_of_type_Arot.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Arot.c();
    this.jdField_a_of_type_Arot.b(false);
    if (this.jdField_a_of_type_Arhw != null) {
      this.jdField_a_of_type_Arhw.a();
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
      this.jdField_a_of_type_Arot.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Arki.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Arki.a() != null) {
        this.jdField_a_of_type_Arki.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arot.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Arki.a() != null) {
          this.jdField_a_of_type_Arki.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arnq
 * JD-Core Version:    0.7.0.1
 */