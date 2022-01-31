import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusHelper.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class asyq
  implements affa
{
  private static final String jdField_a_of_type_JavaLangString = asyq.class.getSimpleName();
  private int jdField_a_of_type_Int;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new asyr(this);
  private asyt jdField_a_of_type_Asyt;
  private asyu jdField_a_of_type_Asyu;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusHelper.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  public long b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public asyq(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Long = 5000L;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private asyu a()
  {
    if (this.jdField_a_of_type_Asyu == null)
    {
      Manager localManager = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(316);
      if ((localManager instanceof asyu)) {
        this.jdField_a_of_type_Asyu = ((asyu)localManager);
      }
    }
    return this.jdField_a_of_type_Asyu;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agse))) {
      return c();
    }
    return b();
  }
  
  private void b(int paramInt)
  {
    if ((e()) && (f()) && (a())) {}
    try
    {
      this.jdField_a_of_type_Int = paramInt;
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      asyp localasyp = (asyp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(150);
      if (localasyp != null) {
        localasyp.a(paramInt, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  private boolean b()
  {
    try
    {
      asyo localasyo = (asyo)aoks.a().a(445);
      if (localasyo != null)
      {
        boolean bool = localasyo.jdField_a_of_type_Boolean;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return false;
  }
  
  private boolean c()
  {
    try
    {
      asyo localasyo = (asyo)aoks.a().a(445);
      if (localasyo != null)
      {
        boolean bool = localasyo.jdField_b_of_type_Boolean;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return true;
  }
  
  private boolean d()
  {
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStatus();
    return (localStatus != AppRuntime.Status.away) && (localStatus != AppRuntime.Status.busy) && (localStatus != AppRuntime.Status.dnd) && (localStatus != AppRuntime.Status.invisiable);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && (f()) && (a())) {}
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      asyp localasyp = (asyp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(150);
      if (localasyp != null) {
        localasyp.a(2, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  private boolean e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agse))) {
      return true;
    }
    return d();
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof agse))) {
      return true;
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public void a()
  {
    if (!this.d)
    {
      this.d = true;
      if ((f()) && (a())) {
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    d();
    switch (paramInt)
    {
    default: 
    case 6: 
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie == null) || (!a()));
        if (this.jdField_a_of_type_Asyt == null) {
          this.jdField_a_of_type_Asyt = new asys(this, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Asyt);
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d(true);
      } while (!f());
      if (a() != null) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      return;
    }
    if (a() != null) {
      a().onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Asyt);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    e();
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (;;)
    {
      localBaseChatPie.a(paramBoolean, paramString);
      return;
      paramString = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  public int[] a()
  {
    return new int[] { 6, 11 };
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
    if (a() != null) {
      a().a();
    }
  }
  
  public void c()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((f()) && (a())) {}
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      asyp localasyp = (asyp)this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(150);
      if (localasyp != null) {
        localasyp.a(2, l);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
  }
  
  public void d()
  {
    this.d = false;
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyq
 * JD-Core Version:    0.7.0.1
 */