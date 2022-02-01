import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class azjv
{
  private static volatile azjv jdField_a_of_type_Azjv;
  private azka jdField_a_of_type_Azka;
  
  public static azjv a()
  {
    if (jdField_a_of_type_Azjv == null) {}
    try
    {
      if (jdField_a_of_type_Azjv == null) {
        jdField_a_of_type_Azjv = new azjv();
      }
      return jdField_a_of_type_Azjv;
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
      paramBaseActivity = bfur.a(paramBaseActivity, 230);
      paramBaseActivity.setMessage(2131698067);
      paramBaseActivity.setTitle(2131698070);
      paramBaseActivity.setNegativeButton(2131698065, new azjw(this, paramBaseActivity));
      paramBaseActivity.setPositiveButton(2131698066, new azjx(this, paramQQAppInterface, paramBaseActivity));
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
      String str = paramBaseActivity.getString(2131698064);
      paramString = paramString + str;
      int i = paramString.indexOf(str);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new azjy(this, new WeakReference(paramQQAppInterface), new WeakReference(paramBaseActivity)), i, str.length() + i, 33);
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
    this.jdField_a_of_type_Azka = null;
  }
  
  public void a(azka paramazka)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.jdField_a_of_type_Azka = paramazka;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    azkb localazkb;
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "requestSetPCVerify isSwitchOn: " + paramBoolean);
      if (paramQQAppInterface == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
        return;
      }
      localazkb = (azkb)paramQQAppInterface.getBusinessHandler(181);
      if (localazkb == null)
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
    azjz localazjz = new azjz(l, new WeakReference(localHashMap), new WeakReference(paramQQAppInterface), new WeakReference(this.jdField_a_of_type_Azka));
    QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
    localHashMap.put(Long.valueOf(l), localazjz);
    QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
    paramQQAppInterface.addObserver(localazjz);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localazkb.a(i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjv
 * JD-Core Version:    0.7.0.1
 */