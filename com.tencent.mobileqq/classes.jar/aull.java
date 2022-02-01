import android.os.Handler;
import android.os.Looper;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusHelper.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import mqq.app.AppRuntime.Status;
import mqq.manager.Manager;

public class aull
  implements afrc
{
  private static final String jdField_a_of_type_JavaLangString = aull.class.getSimpleName();
  private int jdField_a_of_type_Int;
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new aulm(this);
  private aulo jdField_a_of_type_Aulo;
  private aulp jdField_a_of_type_Aulp;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusHelper.2(this);
  private boolean jdField_a_of_type_Boolean = true;
  public long b;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public aull(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Long = 5000L;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private aulp a()
  {
    if (this.jdField_a_of_type_Aulp == null)
    {
      Manager localManager = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(316);
      if ((localManager instanceof aulp)) {
        this.jdField_a_of_type_Aulp = ((aulp)localManager);
      }
    }
    return this.jdField_a_of_type_Aulp;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahhp))) {
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
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      aulk localaulk = (aulk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(150);
      if (localaulk != null) {
        localaulk.a(paramInt, l);
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
      aulj localaulj = (aulj)apub.a().a(445);
      if (localaulj != null)
      {
        boolean bool = localaulj.jdField_a_of_type_Boolean;
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
      aulj localaulj = (aulj)apub.a().a(445);
      if (localaulj != null)
      {
        boolean bool = localaulj.jdField_b_of_type_Boolean;
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
    AppRuntime.Status localStatus = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getOnlineStatus();
    return (localStatus != AppRuntime.Status.away) && (localStatus != AppRuntime.Status.busy) && (localStatus != AppRuntime.Status.dnd) && (localStatus != AppRuntime.Status.invisiable);
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && (f()) && (a())) {}
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      aulk localaulk = (aulk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(150);
      if (localaulk != null) {
        localaulk.a(2, l);
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
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahhp)) {
      return true;
    }
    return d();
  }
  
  private boolean f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof ahhp))) {
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
    case 7: 
      do
      {
        do
        {
          return;
        } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (!a()));
        if (this.jdField_a_of_type_Aulo == null) {
          this.jdField_a_of_type_Aulo = new auln(this, null);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.addObserver(this.jdField_a_of_type_Aulo);
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getVisibilityForInputStatus(true);
      } while (!f());
      if (a() != null) {
        a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      return;
    }
    if (a() != null) {
      a().onDestroy();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.input.removeTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.removeObserver(this.jdField_a_of_type_Aulo);
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
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onShowSubTitleText(this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    for (;;)
    {
      localBaseChatPie.onShowSubTitleText(paramBoolean, paramString);
      return;
      paramString = this.jdField_b_of_type_JavaLangString;
    }
  }
  
  public int[] a()
  {
    return new int[] { 7, 13 };
  }
  
  public void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.onShowSubTitleText(this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaLangString);
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
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.sessionInfo.curFriendUin);
      aulk localaulk = (aulk)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getBusinessHandler(150);
      if (localaulk != null) {
        localaulk.a(2, l);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aull
 * JD-Core Version:    0.7.0.1
 */