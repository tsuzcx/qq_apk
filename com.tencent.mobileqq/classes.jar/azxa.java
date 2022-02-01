import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class azxa
{
  private static volatile azxa jdField_a_of_type_Azxa;
  private azxf jdField_a_of_type_Azxf;
  
  public static azxa a()
  {
    if (jdField_a_of_type_Azxa == null) {}
    try
    {
      if (jdField_a_of_type_Azxa == null) {
        jdField_a_of_type_Azxa = new azxa();
      }
      return jdField_a_of_type_Azxa;
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
      paramBaseActivity = bglp.a(paramBaseActivity, 230);
      paramBaseActivity.setMessage(2131697826);
      paramBaseActivity.setTitle(2131697829);
      paramBaseActivity.setNegativeButton(2131697824, new azxb(this, paramBaseActivity));
      paramBaseActivity.setPositiveButton(2131697825, new azxc(this, paramQQAppInterface, paramBaseActivity));
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
      String str = paramBaseActivity.getString(2131697823);
      paramString = paramString + str;
      int i = paramString.indexOf(str);
      paramString = new SpannableString(paramString);
      paramString.setSpan(new azxd(this, new WeakReference(paramQQAppInterface), new WeakReference(paramBaseActivity)), i, str.length() + i, 33);
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
    this.jdField_a_of_type_Azxf = null;
  }
  
  public void a(azxf paramazxf)
  {
    QLog.d("ClosePCVerifyImpl", 1, "addObserver");
    this.jdField_a_of_type_Azxf = paramazxf;
  }
  
  public void a(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    azxg localazxg;
    try
    {
      QLog.d("ClosePCVerifyImpl", 1, "requestSetPCVerify isSwitchOn: " + paramBoolean);
      if (paramQQAppInterface == null)
      {
        QLog.e("ClosePCVerifyImpl", 1, "requestSetPCVerify error: appInterface == null");
        return;
      }
      localazxg = (azxg)paramQQAppInterface.a(181);
      if (localazxg == null)
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
    azxe localazxe = new azxe(l, new WeakReference(localHashMap), new WeakReference(paramQQAppInterface), new WeakReference(this.jdField_a_of_type_Azxf));
    QLog.d("ClosePCVerifyImpl", 1, "wrapper.put");
    localHashMap.put(Long.valueOf(l), localazxe);
    QLog.d("ClosePCVerifyImpl", 1, "appInterface.addObserver");
    paramQQAppInterface.addObserver(localazxe);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localazxg.a(i, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxa
 * JD-Core Version:    0.7.0.1
 */