import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.inputstatus.InputStatusPushManager.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;

public class aqjq
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = aqjq.class.getSimpleName();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new InputStatusPushManager.1(this);
  private WeakReference<aedo> jdField_a_of_type_JavaLangRefWeakReference;
  
  public aqjq(QQAppInterface paramQQAppInterface)
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
  
  private aqjm a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null) {
      return (aqjm)((aedo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).a(16);
    }
    return null;
  }
  
  private boolean a()
  {
    try
    {
      aqjk localaqjk = (aqjk)alzw.a().a(445);
      if (localaqjk != null)
      {
        boolean bool = localaqjk.a;
        return bool;
      }
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, localException, new Object[0]);
    }
    return false;
  }
  
  void a()
  {
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
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
      str1 = ((aedo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      String str2 = ((aedo)this.jdField_a_of_type_JavaLangRefWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if ((TextUtils.equals(str1, String.valueOf(paramLong1))) && (TextUtils.equals(str2, String.valueOf(paramLong2))))
      {
        if (paramInt3 == 2) {
          break label202;
        }
        bool = true;
        if (!bool) {
          break label218;
        }
        str1 = paramString;
        if (TextUtils.isEmpty(paramString))
        {
          if (paramInt3 != 1) {
            break label208;
          }
          str1 = ajjy.a(2131640001);
        }
        label164:
        a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt2 * 1000);
      }
    }
    for (;;)
    {
      if (a() != null) {
        a().a(bool, str1);
      }
      return;
      label202:
      bool = false;
      break;
      label208:
      str1 = ajjy.a(2131640002);
      break label164;
      label218:
      str1 = "";
    }
  }
  
  public void a(aedo paramaedo)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaedo);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjq
 * JD-Core Version:    0.7.0.1
 */