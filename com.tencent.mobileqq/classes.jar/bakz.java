import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.1;
import com.tencent.mobileqq.qassistant.core.VoiceMainPresenter.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public class bakz
  implements bakr, baks, bamo
{
  private int jdField_a_of_type_Int;
  private bajc jdField_a_of_type_Bajc;
  private bakq jdField_a_of_type_Bakq;
  private bakx jdField_a_of_type_Bakx;
  private bala jdField_a_of_type_Bala;
  private bana jdField_a_of_type_Bana;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private volatile String c;
  
  public bakz(bakx parambakx)
  {
    this.jdField_a_of_type_Bakx = parambakx;
    this.jdField_a_of_type_Bala = new bala(this);
    this.jdField_a_of_type_Bana = new bana(this);
    this.jdField_a_of_type_Bajc = new bajc();
    this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720034);
    this.b = BaseApplicationImpl.getContext().getString(2131720048);
    d();
  }
  
  private String a(String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramString).append(",");
    int i = 0;
    while (i < ball.a.length)
    {
      localStringBuffer.append(BaseApplicationImpl.getContext().getString(ball.a[i])).append(",");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(balb parambalb, List<balm> paramList)
  {
    if (this.jdField_a_of_type_Bana != null) {
      this.jdField_a_of_type_Bana.a(parambalb, paramList);
    }
  }
  
  private boolean a(balb parambalb)
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Bana != null) && (parambalb != null))
    {
      int i = this.jdField_a_of_type_Bana.a();
      if (i == 5) {
        if ((parambalb.jdField_a_of_type_Int == 9) || (parambalb.jdField_a_of_type_Int == 8) || (parambalb.jdField_a_of_type_Int == 11) || (parambalb.jdField_a_of_type_Int == 5) || (parambalb.jdField_a_of_type_Int == 6))
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
            if ((parambalb.jdField_a_of_type_Int == 8) || (parambalb.jdField_a_of_type_Int == 9) || (parambalb.jdField_a_of_type_Int == 5) || (parambalb.jdField_a_of_type_Int == 11) || (parambalb.jdField_a_of_type_Int == 6)) {}
            for (i = 1; i != 0; i = 0) {
              return false;
            }
          }
          if (!b()) {
            break label165;
          }
        } while (parambalb.jdField_a_of_type_Int != 5);
        return false;
        if ((TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)) || (!parambalb.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))) {
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
    if ((this.jdField_a_of_type_Bana != null) && (this.jdField_a_of_type_Bakx != null)) {
      switch (this.jdField_a_of_type_Bana.a())
      {
      default: 
        if (QLog.isColorLevel()) {
          QLog.d("VoiceMainPresenter", 2, "dealChooseResult error type = " + this.jdField_a_of_type_Bana.a());
        }
        break;
      }
    }
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        b(bamr.a(BaseApplicationImpl.getContext().getString(2131720040)));
        if (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
        }
      }
      else
      {
        b(bamr.a(BaseApplicationImpl.getContext().getString(2131718511)));
        this.jdField_a_of_type_Boolean = true;
        return;
        if (paramBoolean) {
          b(bamr.a(BaseApplicationImpl.getContext().getString(2131720040)));
        }
        while (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
          return;
          p(bamr.a(ball.a(1), false));
        }
        continue;
        if (paramBoolean)
        {
          bali localbali = null;
          if (this.jdField_a_of_type_Bana.a() != null) {
            localbali = this.jdField_a_of_type_Bana.a().jdField_a_of_type_Bali;
          }
          this.jdField_a_of_type_Bakx.a(localbali);
          h(bamr.b());
          bamt.b(1);
        }
        while (this.jdField_a_of_type_Boolean)
        {
          e();
          this.jdField_a_of_type_Boolean = false;
          return;
          this.jdField_a_of_type_Bakx.c();
          b(bamr.a(BaseApplicationImpl.getContext().getString(2131720037)));
          bamt.a(1);
        }
      }
    }
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bana != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bana.a() != null) {
        if (!bamu.c(this.jdField_a_of_type_Bana.a().jdField_a_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (this.jdField_a_of_type_Bana.a().jdField_a_of_type_Balf != null)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Bana.a().jdField_a_of_type_Balf.jdField_a_of_type_Int != 115) {}
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
  
  private void c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "showOverSelectView commandDescription is null");
      }
    }
    balb localbalb;
    do
    {
      return;
      localbalb = this.jdField_a_of_type_Bana.a();
      localbalb.jdField_a_of_type_JavaLangString = paramString;
      a(localbalb, ball.a(localbalb.jdField_a_of_type_JavaLangString, localbalb.jdField_a_of_type_JavaUtilList));
    } while (this.jdField_a_of_type_Bakx == null);
    this.jdField_a_of_type_Bakx.a(localbalb.jdField_a_of_type_JavaLangString);
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_Bakx != null) && (this.jdField_a_of_type_Bakx.a() != null) && (this.jdField_a_of_type_Bakx.a().isBackgroundPause)) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "isNeedFilterBackCommand isBackgroundStop");
      }
    }
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_Bakx == null) || (!(this.jdField_a_of_type_Bakx.a() instanceof SplashActivity)));
      localObject = ((SplashActivity)this.jdField_a_of_type_Bakx.a()).getSupportFragmentManager();
    } while (localObject == null);
    Object localObject = ((FragmentManager)localObject).findFragmentByTag(MainFragment.class.getName());
    if ((localObject != null) && (((Fragment)localObject).isVisible())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Bakx != null) {
      this.jdField_a_of_type_Bakx.a(this);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bajc != null) {
      this.jdField_a_of_type_Bajc.a();
    }
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_Bana != null) {
      return this.jdField_a_of_type_Bana.a();
    }
    return null;
  }
  
  public List<balm> a()
  {
    if (this.jdField_a_of_type_Bana != null) {
      return this.jdField_a_of_type_Bana.a();
    }
    return null;
  }
  
  public void a()
  {
    a(bamr.a(this.b, true), ball.b(this.b));
    if (this.jdField_a_of_type_Bakx != null) {
      this.jdField_a_of_type_Bakx.a(a(this.b));
    }
    bamt.c();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Bakx != null)
    {
      if (paramInt == 11)
      {
        this.jdField_a_of_type_Bakx.c();
        b(bamr.a(BaseApplicationImpl.getContext().getString(2131720037)));
        bamt.a(1);
      }
      if (this.jdField_a_of_type_Boolean)
      {
        e();
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void a(balb parambalb)
  {
    if ((this.jdField_a_of_type_Bakx != null) && (parambalb != null))
    {
      bakl.a(this.jdField_a_of_type_Bakx.a(), parambalb);
      if (parambalb.jdField_a_of_type_Balf != null)
      {
        if (parambalb.jdField_a_of_type_Balf.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_Bakx.a(false, false);
        }
        if (parambalb.jdField_a_of_type_Boolean)
        {
          parambalb.jdField_a_of_type_Int = 2;
          b(parambalb);
        }
        if (!parambalb.jdField_a_of_type_Balf.b) {
          break label99;
        }
        p(bamr.b(parambalb.jdField_a_of_type_JavaLangString));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      bamt.a(parambalb.jdField_a_of_type_Balf);
      return;
      label99:
      parambalb.jdField_a_of_type_Int = 2;
      a(parambalb, ball.c(parambalb.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void a(bald parambald)
  {
    if (parambald != null)
    {
      a(bamr.a(parambald, parambald.jdField_a_of_type_Boolean));
      bamt.c(1);
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
    if (this.jdField_a_of_type_Bana != null) {
      this.jdField_a_of_type_Bana.b();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      e();
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Int = 0;
    this.c = "";
  }
  
  public void b(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 2) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)))
    {
      a(parambalb, ball.c(parambalb.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Bakx != null) {
        this.jdField_a_of_type_Bakx.a(parambalb.jdField_a_of_type_JavaLangString);
      }
      if (bamu.f(parambalb.jdField_a_of_type_JavaLangString)) {
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
  
  public void c()
  {
    ThreadManager.getSubThreadHandler().post(new VoiceMainPresenter.2(this));
  }
  
  public void c(balb parambalb)
  {
    if (this.jdField_a_of_type_Bakx != null)
    {
      parambalb = BaseApplicationImpl.getContext().getString(2131720036);
      this.jdField_a_of_type_Bakx.a(new balb(2, parambalb));
      this.jdField_a_of_type_Bakx.a(parambalb);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      bamt.d(3);
    }
  }
  
  public void d(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)))
    {
      if ((bamu.d(parambalb.jdField_a_of_type_JavaLangString)) && (bamu.a(a()))) {
        p(bamr.a(BaseApplicationImpl.getContext().getString(2131720031)));
      }
    }
    else {
      return;
    }
    if ((this.jdField_a_of_type_Bana != null) && (this.jdField_a_of_type_Bana.a() == 7))
    {
      c(BaseApplicationImpl.getContext().getString(2131720035));
      return;
    }
    String str = parambalb.jdField_a_of_type_JavaLangString;
    List localList;
    if (bamu.e(parambalb.jdField_a_of_type_JavaLangString)) {
      localList = ball.a(parambalb.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      a(parambalb, localList);
      if ((this.jdField_a_of_type_Bakx == null) || (!parambalb.jdField_a_of_type_Boolean)) {
        break;
      }
      this.jdField_a_of_type_Bakx.a(str);
      return;
      if (bakw.a())
      {
        str = BaseApplicationImpl.getContext().getString(2131720047);
        localList = ball.b(str);
        parambalb.jdField_a_of_type_JavaLangString = str;
        str = a(str);
        bakw.a();
      }
      else
      {
        localList = ball.a(parambalb.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void e(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 4) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)))
    {
      a(parambalb, ball.d(parambalb.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Bakx != null) {
        this.jdField_a_of_type_Bakx.a(parambalb.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void f(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Balg != null) && (parambalb.jdField_a_of_type_Int == 5)) {
      a(parambalb, ball.a(parambalb.jdField_a_of_type_Balg.jdField_a_of_type_JavaLangString, parambalb.jdField_a_of_type_Balg.b));
    }
  }
  
  public void g(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Balg != null) && (parambalb.jdField_a_of_type_Int == 11)) {
      a(parambalb, ball.a(parambalb.jdField_a_of_type_Balg.jdField_a_of_type_JavaLangString, parambalb.jdField_a_of_type_Balg.b, parambalb.jdField_a_of_type_Balg.c));
    }
  }
  
  public void h(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 6))
    {
      a(parambalb, ball.d(parambalb.jdField_a_of_type_JavaLangString));
      if (this.jdField_a_of_type_Bakx != null) {
        this.jdField_a_of_type_Bakx.a(parambalb.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void i(balb parambalb)
  {
    if ((parambalb != null) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)) && (parambalb.jdField_a_of_type_Int == 7) && (parambalb.jdField_a_of_type_JavaUtilList != null) && (!parambalb.jdField_a_of_type_JavaUtilList.isEmpty()) && (this.jdField_a_of_type_Bakx != null))
    {
      if (parambalb.jdField_a_of_type_JavaUtilList.size() == 1)
      {
        parambalb = (bald)parambalb.jdField_a_of_type_JavaUtilList.get(0);
        a(bamr.a(parambalb, parambalb.jdField_a_of_type_Boolean));
      }
    }
    else {
      return;
    }
    if (this.jdField_a_of_type_Bakq == null) {
      this.jdField_a_of_type_Bakq = new bakq();
    }
    List localList = this.jdField_a_of_type_Bakq.a(this.jdField_a_of_type_Bakx.a(), parambalb.jdField_a_of_type_JavaUtilList);
    if ((localList != null) && (localList.size() > 0))
    {
      parambalb.jdField_a_of_type_JavaUtilList = localList;
      a(parambalb, ball.a(parambalb.jdField_a_of_type_JavaLangString, localList));
      this.jdField_a_of_type_Bakx.a(parambalb.jdField_a_of_type_JavaLangString);
      bamt.a();
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void j(balb parambalb)
  {
    if ((this.jdField_a_of_type_Bana != null) && ((this.jdField_a_of_type_Bana.a() == 5) || (this.jdField_a_of_type_Bana.a() == 11)))
    {
      if (this.jdField_a_of_type_Bakx != null) {
        this.jdField_a_of_type_Bakx.c();
      }
      if (parambalb != null) {
        b(bamr.a(parambalb.jdField_a_of_type_JavaLangString));
      }
      this.jdField_a_of_type_Boolean = false;
      bamt.a(2);
    }
  }
  
  public void k(balb parambalb)
  {
    if ((this.jdField_a_of_type_Bana != null) && ((this.jdField_a_of_type_Bana.a() == 5) || (this.jdField_a_of_type_Bana.a() == 11)) && (this.jdField_a_of_type_Bakx != null))
    {
      this.jdField_a_of_type_Bakx.a(parambalb.jdField_a_of_type_Bali);
      h(bamr.b());
      this.jdField_a_of_type_Boolean = false;
      bamt.b(2);
    }
  }
  
  public void l(balb parambalb)
  {
    if ((this.jdField_a_of_type_Bakx != null) && (parambalb != null) && (parambalb.jdField_a_of_type_Int == 10)) {
      b(parambalb.b);
    }
  }
  
  public void m(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 12) && (this.jdField_a_of_type_Bana != null) && (this.jdField_a_of_type_Bana.a() == 7)) {
      c(parambalb.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void n(balb parambalb)
  {
    if (c())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "backCommand isNeedFilterBackCommand");
      }
      return;
    }
    c();
    b(bamr.a(BaseApplicationImpl.getContext().getString(2131720018)));
  }
  
  public void o(balb parambalb)
  {
    if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 14) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString))) {
      b(bamr.a(parambalb.jdField_a_of_type_JavaLangString));
    }
  }
  
  public void p(balb parambalb)
  {
    if ((this.jdField_a_of_type_Bana != null) && (this.jdField_a_of_type_Bana.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMainPresenter", 2, "panel is dragging, so return");
      }
    }
    do
    {
      do
      {
        return;
        if (!a(parambalb)) {
          break;
        }
      } while ((parambalb == null) || (this.jdField_a_of_type_Bana == null) || (!QLog.isColorLevel()));
      QLog.d("VoiceMainPresenter", 2, "not need execute command, currentType = " + this.jdField_a_of_type_Bana.a() + ", commandType = " + parambalb.jdField_a_of_type_Int);
      return;
      if ((parambalb != null) && (parambalb.jdField_a_of_type_Int == 3) && (!TextUtils.isEmpty(parambalb.jdField_a_of_type_JavaLangString)) && (parambalb.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)))
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
    } while (this.jdField_a_of_type_Bala == null);
    this.jdField_a_of_type_Bala.a(parambalb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakz
 * JD-Core Version:    0.7.0.1
 */