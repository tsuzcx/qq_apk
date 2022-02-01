import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class baqd
{
  private static volatile baqd jdField_a_of_type_Baqd;
  private baqi jdField_a_of_type_Baqi;
  
  public static baqd a()
  {
    if (jdField_a_of_type_Baqd == null) {}
    try
    {
      if (jdField_a_of_type_Baqd == null) {
        jdField_a_of_type_Baqd = new baqd();
      }
      return jdField_a_of_type_Baqd;
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
      paramBaseActivity = bhdj.a(paramBaseActivity, 230);
      paramBaseActivity.setMessage(2131698353);
      paramBaseActivity.setTitle(2131698356);
      paramBaseActivity.setNegativeButton(2131698351, new baqe(this, paramBaseActivity));
      paramBaseActivity.setPositiveButton(2131698352, new baqf(this, paramQQAppInterface, paramBaseActivity));
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
      String str = paramBaseActivity.getString(2131698350);
      paramString = paramString + str;
      int i = paramString.indexOf(str);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new baqg(this, new WeakReference(paramQQAppInterface), new WeakReference(paramBaseActivity)), i, str.length() + i, 33);
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
    this.jdField_a_of_type_Baqi = null;
  }
  
  public void a(baqi parambaqi)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.jdField_a_of_type_Baqi = parambaqi;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    baqj localbaqj;
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "requestSetPCVerify isSwitchOn: " + paramBoolean);
      if (paramQQAppInterface == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
        return;
      }
      localbaqj = (baqj)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QUICK_LOGIN);
      if (localbaqj == null)
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
    baqh localbaqh = new baqh(l, new WeakReference(localHashMap), new WeakReference(paramQQAppInterface), new WeakReference(this.jdField_a_of_type_Baqi));
    QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
    localHashMap.put(Long.valueOf(l), localbaqh);
    QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
    paramQQAppInterface.addObserver(localbaqh);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localbaqj.a(i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baqd
 * JD-Core Version:    0.7.0.1
 */