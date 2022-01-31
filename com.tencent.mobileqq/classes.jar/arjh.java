import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class arjh
  extends arhu
  implements arge, argf, argg
{
  protected arkk a;
  private List<arjn> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean d;
  
  public arjh(arfz paramarfz, Activity paramActivity)
  {
    super(paramarfz, paramActivity);
    this.jdField_a_of_type_Arkk = new arkk(paramActivity);
    a(this.jdField_a_of_type_Arkk);
  }
  
  private void b(long paramLong)
  {
    if (arof.b(this.jdField_a_of_type_Arfz.d()))
    {
      this.jdField_a_of_type_Arkk.a(true, new arji(this));
      this.jdField_a_of_type_Arkk.a(alpo.a(2131717420), new arjj(this));
      this.jdField_a_of_type_Arkk.a(true);
      SpannableString localSpannableString = arni.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692938), "用QQ浏览器打开", new arjk(this));
      this.jdField_a_of_type_Arkk.a(localSpannableString, LinkMovementMethod.getInstance());
      return;
    }
    if ((paramLong == -7003L) || (paramLong == -6101L))
    {
      this.jdField_a_of_type_Arfz.b(16);
      this.jdField_a_of_type_Arkk.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131692559), null);
    }
    for (;;)
    {
      this.jdField_a_of_type_Arkk.a(false, null);
      return;
      this.jdField_a_of_type_Arkk.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131721167), null);
    }
  }
  
  private void c()
  {
    int i = this.jdField_a_of_type_Arfz.i();
    if (i == 4)
    {
      this.jdField_a_of_type_Arkk.b(true);
      this.jdField_a_of_type_Arkk.c(false);
      return;
    }
    if (i == 2)
    {
      this.jdField_a_of_type_Arkk.c(false);
      return;
    }
    if (i == 6)
    {
      this.jdField_a_of_type_Arkk.a(true, alpo.a(2131717425) + "(" + bdcr.a(this.jdField_a_of_type_Arfz.c()) + ")", new arjl(this));
      return;
    }
    this.jdField_a_of_type_Arkk.a(true, alpo.a(2131717422) + "(" + bdcr.a(this.jdField_a_of_type_Arfz.c()) + ")", new arjm(this));
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
      this.jdField_a_of_type_Arkk.c(this.jdField_a_of_type_Arfz.c());
      this.jdField_a_of_type_Arkk.d(alpo.a(2131717421) + this.jdField_a_of_type_JavaUtilList.size() + alpo.a(2131717426) + arof.a(this.jdField_a_of_type_Arfz.c()));
      this.jdField_a_of_type_Arkk.d(this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Arfz.a(this);
      this.jdField_a_of_type_Arfz.a(this);
      c();
      if (bdee.g(this.jdField_a_of_type_AndroidAppActivity)) {
        break label284;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, this.jdField_a_of_type_AndroidAppActivity.getString(2131692397), 1).b(this.jdField_a_of_type_Arfz.l());
    }
    for (;;)
    {
      if (arof.b(this.jdField_a_of_type_Arfz.d()))
      {
        this.jdField_a_of_type_Arkk.c();
        this.jdField_a_of_type_Arkk.b(false);
      }
      if ((this.jdField_a_of_type_Arfz.i()) && (this.jdField_a_of_type_Arfz.a() != null))
      {
        b(this.jdField_a_of_type_Arfz.a());
        this.jdField_a_of_type_Arkk.b(true);
        this.jdField_a_of_type_Arkk.c(false);
        this.jdField_a_of_type_Arfz.a().a();
      }
      this.jdField_a_of_type_Arfz.a(this);
      return;
      bool = false;
      break;
      label284:
      if (!this.d)
      {
        this.jdField_a_of_type_Arfz.f();
        this.d = true;
      }
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Arkk.c(false);
    this.jdField_a_of_type_Arkk.b(true);
    b(paramFloat);
  }
  
  public void a(long paramLong)
  {
    b(paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Arkk.b(paramString1, paramString2);
  }
  
  public void a(List<arjn> paramList, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, short paramShort)
  {
    if (paramList != null)
    {
      this.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Arkk.a(paramList, this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.d(), this.jdField_a_of_type_Arfz.b(), paramString2, paramString3, paramString4, paramString1, paramBoolean, paramString5, paramShort);
      this.jdField_a_of_type_Arkk.d(alpo.a(2131717423) + this.jdField_a_of_type_JavaUtilList.size() + alpo.a(2131717424) + arof.a(this.jdField_a_of_type_Arfz.c()));
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
    this.jdField_a_of_type_Arkk.a(paramString1, paramString2);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Arkk.c(false);
    this.jdField_a_of_type_Arkk.b(true);
    b(this.jdField_a_of_type_Arfz.a());
  }
  
  public void e()
  {
    this.jdField_a_of_type_Arkk.c(true);
    this.jdField_a_of_type_Arkk.b(false);
    c();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Arkk.c();
    this.jdField_a_of_type_Arkk.b(false);
    if (this.jdField_a_of_type_Ardn != null) {
      this.jdField_a_of_type_Ardn.a();
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
      this.jdField_a_of_type_Arkk.b("", "");
    }
  }
  
  protected void m()
  {
    int i = this.jdField_a_of_type_Arfz.h();
    if ((i == 2) || (i == 3)) {
      if (this.jdField_a_of_type_Arfz.a() != null) {
        this.jdField_a_of_type_Arfz.a().b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Arkk.b(false);
      c();
      return;
      if (i == 1)
      {
        if (this.jdField_a_of_type_Arfz.a() != null) {
          this.jdField_a_of_type_Arfz.a().b();
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.i("FileBrowserPresenter<FileAssistant>", 2, "zip file stop trans, but can not handle trans type");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjh
 * JD-Core Version:    0.7.0.1
 */