import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class azfi
  implements azfa, azfb, azgg
{
  private int jdField_a_of_type_Int;
  private azdn jdField_a_of_type_Azdn;
  private azez jdField_a_of_type_Azez;
  private azfg jdField_a_of_type_Azfg;
  private azfj jdField_a_of_type_Azfj;
  private azgs jdField_a_of_type_Azgs;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private volatile String c;
  
  public azfi(azfg paramazfg)
  {
    this.jdField_a_of_type_Azfg = paramazfg;
    this.jdField_a_of_type_Azfj = new azfj(this);
    this.jdField_a_of_type_Azgs = new azgs(this);
    this.jdField_a_of_type_Azdn = new azdn();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131719581);
    this.b = BaseApplicationImpl.getContext().getString(2131719595);
    c();
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString).append(",");
    int i = 0;
    while (i < azfu.a.length)
    {
      localStringBuffer.append(BaseApplicationImpl.getContext().getString(azfu.a[i])).append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(azfk paramazfk, List<azfv> paramList)
  {
    if (this.jdField_a_of_type_Azgs != null) {
      this.jdField_a_of_type_Azgs.a(paramazfk, paramList);
    }
  }
  
  private boolean a(azfk paramazfk)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Azgs != null) && (paramazfk != null))
    {
      int i = this.jdField_a_of_type_Azgs.a();
      if (i == 5) {
        if ((paramazfk.jdField_a_of_type_Int == 9) || (paramazfk.jdField_a_of_type_Int == 8) || (paramazfk.jdField_a_of_type_Int == 11) || (paramazfk.jdField_a_of_type_Int == 5) || (paramazfk.jdField_a_of_type_Int == 6))
        {
          i = 1;
          if (i != 0) {
            break label83;
          }
        }
      }
      label83:
      do
      {
        do
        {
          for (;;)
          {
            return true;
            i = 0;
            break;
            return false;
            if (i != 11) {
              break label148;
            }
            if ((paramazfk.jdField_a_of_type_Int == 8) || (paramazfk.jdField_a_of_type_Int == 9) || (paramazfk.jdField_a_of_type_Int == 5) || (paramazfk.jdField_a_of_type_Int == 11) || (paramazfk.jdField_a_of_type_Int == 6)) {}
            for (i = 1; i != 0; i = 0) {
              return false;
            }
          }
          if (!b()) {
            break label165;
          }
        } while (paramazfk.jdField_a_of_type_Int != 5);
        return false;
        if ((TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)) || (!paramazfk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
          break label246;
        }
      } while ((!TextUtils.isEmpty(this.c)) && ((this.c.equals(this.jdField_a_of_type_JavaLangString)) || (this.c.equals(a(this.b)))));
      label148:
      label165:
      if ((i == 6) || (i == 4)) {
        bool = true;
      }
      return bool;
    }
    label246:
    return false;
  }
  
  private void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Azgs != null) && (this.jdField_a_of_type_Azfg != null)) {}
    switch (this.jdField_a_of_type_Azgs.a())
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "dealChooseResult error type = " + this.jdField_a_of_type_Azgs.a());
      }
      return;
    case 4: 
      if (paramBoolean)
      {
        b(azgj.a(BaseApplicationImpl.getContext().getString(2131719587)));
        this.jdField_a_of_type_Boolean = false;
        d();
        return;
      }
      b(azgj.a(BaseApplicationImpl.getContext().getString(2131718126)));
      this.jdField_a_of_type_Boolean = true;
      return;
    case 6: 
      if (paramBoolean) {
        b(azgj.a(BaseApplicationImpl.getContext().getString(2131719587)));
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
        d();
        return;
        n(azgj.a(azfu.a(1), false));
      }
    }
    if (paramBoolean)
    {
      azfr localazfr = null;
      if (this.jdField_a_of_type_Azgs.a() != null) {
        localazfr = this.jdField_a_of_type_Azgs.a().jdField_a_of_type_Azfr;
      }
      this.jdField_a_of_type_Azfg.a(localazfr);
      h(azgj.b());
      azgl.b(1);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      return;
      this.jdField_a_of_type_Azfg.c();
      b(azgj.a(BaseApplicationImpl.getContext().getString(2131719584)));
      azgl.a(1);
    }
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Azgs != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Azgs.a() != null) {
        if (!azgm.c(this.jdField_a_of_type_Azgs.a().jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Azgs.a().jdField_a_of_type_Azfo != null)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Azgs.a().jdField_a_of_type_Azfo.jdField_a_of_type_Int != 115) {}
          }
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(this);
    }
  }
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "showOverSelectView commandDescription is null");
      }
    }
    azfk localazfk;
    do
    {
      return;
      localazfk = this.jdField_a_of_type_Azgs.a();
      localazfk.jdField_a_of_type_JavaLangString = paramString;
      a(localazfk, azfu.a(localazfk.jdField_a_of_type_JavaLangString, localazfk.jdField_a_of_type_JavaUtilList));
    } while (this.jdField_a_of_type_Azfg == null);
    this.jdField_a_of_type_Azfg.a(localazfk.jdField_a_of_type_JavaLangString);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Azdn != null) {
      this.jdField_a_of_type_Azdn.a();
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_Azgs != null) {
      return this.jdField_a_of_type_Azgs.a();
    }
    return null;
  }
  
  public List<azfv> a()
  {
    if (this.jdField_a_of_type_Azgs != null) {
      return this.jdField_a_of_type_Azgs.a();
    }
    return null;
  }
  
  public void a()
  {
    a(azgj.a(this.b, true), azfu.b(this.b));
    if (this.jdField_a_of_type_Azfg != null) {
      this.jdField_a_of_type_Azfg.a(a(this.b));
    }
    azgl.e();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Azfg != null)
    {
      if (paramInt == 11)
      {
        this.jdField_a_of_type_Azfg.c();
        b(azgj.a(BaseApplicationImpl.getContext().getString(2131719584)));
      }
      this.jdField_a_of_type_Boolean = false;
      d();
    }
  }
  
  public void a(azfk paramazfk)
  {
    if ((this.jdField_a_of_type_Azfg != null) && (paramazfk != null))
    {
      azeu.a(this.jdField_a_of_type_Azfg.a(), paramazfk);
      if (paramazfk.jdField_a_of_type_Azfo != null)
      {
        if (paramazfk.jdField_a_of_type_Azfo.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Azfg.a(false, false);
        }
        if (paramazfk.jdField_a_of_type_Boolean)
        {
          paramazfk.jdField_a_of_type_Int = 2;
          b(paramazfk);
        }
        if (paramazfk.jdField_a_of_type_Azfo.b) {
          n(azgj.b(paramazfk.jdField_a_of_type_JavaLangString));
        }
      }
      this.jdField_a_of_type_Boolean = false;
      d();
      azgl.a(paramazfk.jdField_a_of_type_Azfo);
    }
  }
  
  public void a(azfm paramazfm)
  {
    if (paramazfm != null)
    {
      a(azgj.a(paramazfm, paramazfm.jdField_a_of_type_Boolean));
      azgl.c(1);
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("VoiceMainPresenter", 2, "mCurrentSpeech = " + this.c);
    this.c = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    b(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azgs != null) {
      this.jdField_a_of_type_Azgs.b();
    }
    d();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.c = "";
  }
  
  public void b(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 2) && (!TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)))
    {
      a(paramazfk, azfu.c(paramazfk.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Azfg != null) {
        this.jdField_a_of_type_Azfg.a(paramazfk.jdField_a_of_type_JavaLangString);
      }
      if (azgm.f(paramazfk.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.c)) && (paramString.equals(this.c))) {
      this.c = "";
    }
    ThreadManager.getUIHandler().post(new VoiceMainPresenter.1(this, paramString));
  }
  
  public void c(azfk paramazfk)
  {
    if (this.jdField_a_of_type_Azfg != null)
    {
      paramazfk = BaseApplicationImpl.getContext().getString(2131719583);
      this.jdField_a_of_type_Azfg.a(new azfk(2, paramazfk));
      this.jdField_a_of_type_Azfg.a(paramazfk);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      azgl.d(3);
    }
  }
  
  public void d(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)))
    {
      if ((azgm.d(paramazfk.jdField_a_of_type_JavaLangString)) && (azgm.a(a()))) {
        n(azgj.a(BaseApplicationImpl.getContext().getString(2131719578)));
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Azgs != null) && (this.jdField_a_of_type_Azgs.a() == 7))
    {
      c(BaseApplicationImpl.getContext().getString(2131719582));
      return;
    }
    String str = paramazfk.jdField_a_of_type_JavaLangString;
    List localList;
    if (azgm.e(paramazfk.jdField_a_of_type_JavaLangString))
    {
      localList = azfu.a(paramazfk.jdField_a_of_type_JavaLangString);
      azgl.e(2);
    }
    for (;;)
    {
      a(paramazfk, localList);
      if ((this.jdField_a_of_type_Azfg == null) || (!paramazfk.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Azfg.a(str);
      return;
      if (azff.a())
      {
        str = BaseApplicationImpl.getContext().getString(2131719594);
        localList = azfu.b(str);
        paramazfk.jdField_a_of_type_JavaLangString = str;
        str = a(str);
        azff.a();
        azgl.e(1);
      }
      else
      {
        localList = azfu.a(paramazfk.jdField_a_of_type_JavaLangString);
        azgl.e(2);
      }
    }
  }
  
  public void e(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 4) && (!TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)))
    {
      a(paramazfk, azfu.d(paramazfk.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Azfg != null) {
        this.jdField_a_of_type_Azfg.a(paramazfk.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void f(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Azfp != null) && (paramazfk.jdField_a_of_type_Int == 5)) {
      a(paramazfk, azfu.a(paramazfk.jdField_a_of_type_Azfp.jdField_a_of_type_JavaLangString, paramazfk.jdField_a_of_type_Azfp.b));
    }
  }
  
  public void g(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Azfp != null) && (paramazfk.jdField_a_of_type_Int == 11)) {
      a(paramazfk, azfu.a(paramazfk.jdField_a_of_type_Azfp.jdField_a_of_type_JavaLangString, paramazfk.jdField_a_of_type_Azfp.b, paramazfk.jdField_a_of_type_Azfp.c));
    }
  }
  
  public void h(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 6))
    {
      a(paramazfk, azfu.d(paramazfk.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Azfg != null) {
        this.jdField_a_of_type_Azfg.a(paramazfk.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void i(azfk paramazfk)
  {
    if ((paramazfk != null) && (!TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)) && (paramazfk.jdField_a_of_type_Int == 7) && (paramazfk.jdField_a_of_type_JavaUtilList != null) && (!paramazfk.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Azfg != null))
    {
      if (paramazfk.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        paramazfk = (azfm)paramazfk.jdField_a_of_type_JavaUtilList.get(0);
        a(azgj.a(paramazfk, paramazfk.jdField_a_of_type_Boolean));
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Azez == null) {
      this.jdField_a_of_type_Azez = new azez();
    }
    List localList = this.jdField_a_of_type_Azez.a(this.jdField_a_of_type_Azfg.a(), paramazfk.jdField_a_of_type_JavaUtilList);
    if ((localList != null) && (localList.size() > 0))
    {
      paramazfk.jdField_a_of_type_JavaUtilList = localList;
      a(paramazfk, azfu.a(paramazfk.jdField_a_of_type_JavaLangString, localList));
      this.jdField_a_of_type_Azfg.a(paramazfk.jdField_a_of_type_JavaLangString);
      azgl.a();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void j(azfk paramazfk)
  {
    if ((this.jdField_a_of_type_Azgs != null) && ((this.jdField_a_of_type_Azgs.a() == 5) || (this.jdField_a_of_type_Azgs.a() == 11)))
    {
      if (this.jdField_a_of_type_Azfg != null) {
        this.jdField_a_of_type_Azfg.c();
      }
      if (paramazfk != null) {
        b(azgj.a(paramazfk.jdField_a_of_type_JavaLangString));
      }
      this.jdField_a_of_type_Boolean = false;
      d();
      azgl.a(2);
    }
  }
  
  public void k(azfk paramazfk)
  {
    if ((this.jdField_a_of_type_Azgs != null) && ((this.jdField_a_of_type_Azgs.a() == 5) || (this.jdField_a_of_type_Azgs.a() == 11)) && (this.jdField_a_of_type_Azfg != null))
    {
      this.jdField_a_of_type_Azfg.a(paramazfk.jdField_a_of_type_Azfr);
      h(azgj.b());
      this.jdField_a_of_type_Boolean = false;
      d();
      azgl.b(2);
    }
  }
  
  public void l(azfk paramazfk)
  {
    if ((this.jdField_a_of_type_Azfg != null) && (paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 10)) {
      b(paramazfk.b);
    }
  }
  
  public void m(azfk paramazfk)
  {
    if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 12) && (this.jdField_a_of_type_Azgs != null) && (this.jdField_a_of_type_Azgs.a() == 7)) {
      c(paramazfk.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void n(azfk paramazfk)
  {
    if ((this.jdField_a_of_type_Azgs != null) && (this.jdField_a_of_type_Azgs.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "panel is dragging, so return");
      }
    }
    do
    {
      do
      {
        return;
        if (!a(paramazfk)) {
          break;
        }
      } while ((paramazfk == null) || (this.jdField_a_of_type_Azgs == null) || (!QLog.isColorLevel()));
      QLog.d("VoiceMainPresenter", 2, "not need execute command, currentType = " + this.jdField_a_of_type_Azgs.a() + ", commandType = " + paramazfk.jdField_a_of_type_Int);
      return;
      if ((paramazfk != null) && (paramazfk.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(paramazfk.jdField_a_of_type_JavaLangString)) && (paramazfk.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int > 3)
        {
          this.jdField_a_of_type_Int = 0;
          a();
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 0;
      }
    } while (this.jdField_a_of_type_Azfj == null);
    this.jdField_a_of_type_Azfj.a(paramazfk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfi
 * JD-Core Version:    0.7.0.1
 */