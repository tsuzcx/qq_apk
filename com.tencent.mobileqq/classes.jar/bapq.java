import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class bapq
{
  private static volatile bapq jdField_a_of_type_Bapq;
  private bapv jdField_a_of_type_Bapv;
  
  public static bapq a()
  {
    if (jdField_a_of_type_Bapq == null) {}
    try
    {
      if (jdField_a_of_type_Bapq == null) {
        jdField_a_of_type_Bapq = new bapq();
      }
      return jdField_a_of_type_Bapq;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "showCloseVerifyDialog");
      if ((paramQQAppInterface == null) || (paramBaseActivity == null))
      {
        QLog.e("ClosePCVerifyImpl", 1, "showCloseVerifyDialog error: params wrong");
        return;
      }
      paramBaseActivity = bhlq.a(paramBaseActivity, 230);
      paramBaseActivity.setMessage(2131697910);
      paramBaseActivity.setTitle(2131697913);
      paramBaseActivity.setNegativeButton(2131697908, new bapr(this, paramBaseActivity));
      paramBaseActivity.setPositiveButton(2131697909, new baps(this, paramQQAppInterface, paramBaseActivity));
      if (!paramBaseActivity.isShowing())
      {
        paramBaseActivity.show();
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ClosePCVerifyImpl", 1, "showCloseVerifyDialog error: " + paramQQAppInterface.getMessage());
    }
  }
  
  private boolean a(String paramString, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    return (TextUtils.isEmpty(paramString)) || (paramQQAppInterface == null) || (paramBaseActivity == null);
  }
  
  public SpannableString a(String paramString, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable subTips: " + paramString);
      if (a(paramString, paramQQAppInterface, paramBaseActivity))
      {
        QLog.e("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable error: params wrong");
        return new SpannableString("");
      }
      String str = paramBaseActivity.getString(2131697907);
      paramString = paramString + str;
      int i = paramString.indexOf(str);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new bapt(this, new WeakReference(paramQQAppInterface), new WeakReference(paramBaseActivity)), i, str.length() + i, 33);
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("ClosePCVerifyImpl", 1, "getClosePCVerifySpannable error: " + paramString.getMessage());
    }
    return new SpannableString("");
  }
  
  public void a()
  {
    QLog.d("ClosePCVerifyImpl", 1, "removeObserver");
    this.jdField_a_of_type_Bapv = null;
  }
  
  public void a(bapv parambapv)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.jdField_a_of_type_Bapv = parambapv;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    bapw localbapw;
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "requestSetPCVerify isSwitchOn: " + paramBoolean);
      if (paramQQAppInterface == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
        return;
      }
      localbapw = (bapw)paramQQAppInterface.a(181);
      if (localbapw == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: handler == null");
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: " + paramQQAppInterface.getMessage());
      return;
    }
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    bapu localbapu = new bapu(l, new WeakReference(localHashMap), new WeakReference(paramQQAppInterface), new WeakReference(this.jdField_a_of_type_Bapv));
    QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
    localHashMap.put(Long.valueOf(l), localbapu);
    QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
    paramQQAppInterface.addObserver(localbapu);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbapw.a(i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapq
 * JD-Core Version:    0.7.0.1
 */