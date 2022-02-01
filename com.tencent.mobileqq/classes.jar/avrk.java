import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusPushManager.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class avrk
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = avrk.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusPushManager.1(this);
  private WeakReference<BaseChatPie> jdField_a_of_type_JavaLangRefWeakReference;
  
  public avrk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  private avrg a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      return (avrg)((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getHelper(16);
    }
    return null;
  }
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && ((this.jdField_a_of_type_JavaLangRefWeakReference.get() instanceof aici))) {
      return c();
    }
    return b();
  }
  
  private boolean b()
  {
    try
    {
      avre localavre = (avre)aqxe.a().a(445);
      if (localavre != null)
      {
        boolean bool = localavre.a;
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
      avre localavre = (avre)aqxe.a().a(445);
      if (localavre != null)
      {
        boolean bool = localavre.b;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return true;
  }
  
  void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "receive fromUin =" + paramLong1 + "，toUin，timeStamp =" + paramLong3 + "，interval =" + paramInt1 + "，showTime =" + paramInt2 + "，eventType = " + paramInt3 + "，statusText =" + paramString);
    }
    String str1;
    boolean bool;
    if ((this.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) && (a()))
    {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (a() != null)
      {
        a().a = (paramInt1 * 1000);
        a().b = paramLong3;
      }
      str1 = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).sessionInfo.curFriendUin;
      String str2 = ((BaseChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get()).app.getCurrentAccountUin();
      if ((TextUtils.equals(str1, String.valueOf(paramLong1))) && (TextUtils.equals(str2, String.valueOf(paramLong2))))
      {
        if (paramInt3 == 2) {
          break label284;
        }
        bool = true;
        if (!bool) {
          break label300;
        }
        str1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          if (paramInt3 != 1) {
            break label290;
          }
          str1 = anvx.a(2131705270);
        }
        label246:
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt2 * 1000);
      }
    }
    for (;;)
    {
      if (a() != null) {
        a().a(bool, str1);
      }
      return;
      label284:
      bool = false;
      break;
      label290:
      str1 = anvx.a(2131705271);
      break label246;
      label300:
      str1 = "";
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avrk
 * JD-Core Version:    0.7.0.1
 */