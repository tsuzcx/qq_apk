import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterSendUpSms;
import com.tencent.mobileqq.activity.RegisterVerifyCodeActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.register.QueryAccount.1;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;

public class avpy
  extends avqb
{
  public int a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private avqc jdField_a_of_type_Avqc;
  public String a;
  private HashMap<String, avqa> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new avpz(this);
  public String b;
  public String c;
  private String d;
  
  public avpy(RegisterNewBaseActivity paramRegisterNewBaseActivity)
  {
    super(paramRegisterNewBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
  }
  
  private void a(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterVerifyCodeActivity.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.d);
    localIntent.putExtra("key_register_left_time", paramInt);
    localIntent.putExtra("key_register_exit_time", paramLong);
    localIntent.putExtra("register_verify_code_start_time", System.currentTimeMillis());
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131711231));
    localIntent.putExtra("key_register_from", 7);
    if (QLog.isColorLevel()) {
      QLog.d("QueryAccount", 2, "go2next countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString + ", phoneNum=" + bbfx.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString) + ", leftTime=" + paramInt + ", exitTime=" + paramLong);
    }
    b(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivityForResult(localIntent, 2);
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return TextUtils.isEmpty(paramString2);
    }
    return paramString1.equals(paramString2);
  }
  
  private void b(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, RegisterSendUpSms.class);
    localIntent.putExtra("phonenum", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("invite_code", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString);
    localIntent.putExtra("key", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("key_register_prompt_info", paramString);
    localIntent.putExtra("key_register_is_phone_num_registered", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_Boolean);
    localIntent.putExtra("key_register_has_pwd", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_Boolean);
    localIntent.putExtra("key_register_binded_qq", this.d);
    localIntent.putExtra("selfSet_leftViewText", ajya.a(2131711228));
    localIntent.putExtra("key_register_from", 7);
    b(localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.startActivity(localIntent);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_AndroidContentIntent != null) && (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)))
    {
      if (this.jdField_a_of_type_Avqc == null) {
        this.jdField_a_of_type_Avqc = new avqc(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      }
      this.jdField_a_of_type_Avqc.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
    RegisterPersonalInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString, "", this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_Boolean, false, null, 7);
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.finish();
  }
  
  private void c(String paramString)
  {
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_AndroidOsHandler.post(new QueryAccount.1(this, paramString));
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public String a(String paramString)
  {
    int k = 0;
    int j = 1;
    if (paramString != null) {}
    for (;;)
    {
      int i;
      try
      {
        if ("852".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString)) {
          break label189;
        }
        if ("853".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString))
        {
          break label189;
          paramString = paramString.toString().trim();
        }
      }
      catch (Exception paramString)
      {
        boolean bool;
        paramString = null;
      }
      try
      {
        Long.parseLong(paramString);
        if (paramString.length() < i) {
          j = 0;
        }
        i = j;
        if (!paramString.startsWith("1"))
        {
          i = j;
          if ("86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString)) {
            i = 0;
          }
        }
        if (!"86".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString)) {
          break label181;
        }
        j = paramString.length();
        if (j == 11) {
          break label181;
        }
        i = k;
      }
      catch (Exception localException)
      {
        break label164;
        continue;
        i = 3;
      }
      if (i == 0) {
        paramString = null;
      }
      return paramString;
      bool = "886".equals(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString);
      if (bool)
      {
        i = 9;
        continue;
        label164:
        i = 0;
        continue;
        i = 0;
        paramString = null;
      }
      else
      {
        label181:
        continue;
        label189:
        i = 6;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    if (this.jdField_a_of_type_Avqc != null) {
      this.jdField_a_of_type_Avqc.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    String str1;
    String str2;
    long l;
    if ((paramInt1 == 2) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("phonenum");
      String str3 = paramIntent.getStringExtra("key");
      str1 = paramIntent.getStringExtra("invite_code");
      str2 = str3 + (String)localObject;
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str2)) {
        this.jdField_a_of_type_JavaUtilHashMap.remove(str2);
      }
      paramInt1 = paramIntent.getIntExtra("key_register_left_time", 0);
      l = paramIntent.getLongExtra("key_register_exit_time", 0L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("doOnActivityResult countryCode=").append(str3).append(", phoneNum=").append(bbfx.a((String)localObject)).append(", leftTime=").append(paramInt1).append(", exitTime=").append(l).append(", inviteCode=");
        if (str1 != null) {
          break label231;
        }
      }
    }
    label231:
    for (paramIntent = "";; paramIntent = str1)
    {
      QLog.d("QueryAccount", 2, paramIntent);
      if ((paramInt1 > 0) && (l > 0L))
      {
        paramIntent = new avqa(this);
        paramIntent.jdField_a_of_type_Int = paramInt1;
        paramIntent.jdField_a_of_type_Long = l;
        paramIntent.jdField_a_of_type_JavaLangString = str1;
        this.jdField_a_of_type_JavaUtilHashMap.put(str2, paramIntent);
      }
      return;
    }
  }
  
  @RequiresApi(api=23)
  public void a(Context paramContext)
  {
    String str2 = Locale.getDefault().getLanguage();
    Object localObject = akwh.a(BaseApplicationImpl.getContext(), "key_local_cache", "0");
    if ("0".equals(localObject)) {
      QLog.e("QueryAccount", 1, "addLocaleIdCookie, localeIdStr = 0");
    }
    for (;;)
    {
      return;
      try
      {
        i = Integer.parseInt((String)localObject);
        try
        {
          paramContext = (WifiManager)paramContext.getSystemService("wifi");
          if (paramContext == null) {
            break label210;
          }
          paramContext = paramContext.getConnectionInfo();
          if (paramContext == null) {
            break label210;
          }
          paramContext = paramContext.getMacAddress();
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            QLog.e("QueryAccount", 1, paramContext, new Object[0]);
            paramContext = "02:00:00:00:00:00";
          }
        }
        localObject = "";
        try
        {
          String str1 = SosoInterface.b();
          localObject = str1;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            QLog.e("QueryAccount", 1, localThrowable, new Object[0]);
          }
        }
        this.jdField_a_of_type_JavaLangString = paramContext;
        this.jdField_b_of_type_JavaLangString = str2;
        this.jdField_a_of_type_Int = i;
        this.jdField_c_of_type_JavaLangString = ((String)localObject);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("QueryAccount", 2, new Object[] { "regMacAddr:", this.jdField_a_of_type_JavaLangString, " regOS:", this.jdField_b_of_type_JavaLangString, " regQQLang:", Integer.valueOf(this.jdField_a_of_type_Int), " regLocation:", this.jdField_c_of_type_JavaLangString });
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("QueryAccount", 1, localException.toString());
          int i = 0;
        }
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    if (QLog.isDevelopLevel()) {
      QLog.i("QueryAccount", 4, "setExtraInfo");
    }
  }
  
  public void a(String paramString)
  {
    if (!a()) {
      return;
    }
    try
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("wifi_mac", this.jdField_a_of_type_JavaLangString);
      localBundle.putString("os_language", this.jdField_b_of_type_JavaLangString);
      localBundle.putInt("qq_language", this.jdField_a_of_type_Int);
      localBundle.putString("gps_location", this.jdField_c_of_type_JavaLangString);
      ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString, Long.valueOf(AppSetting.a()), "8.3.0", localBundle, null);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public boolean a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString = a(str);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131717126, 1);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.b();
    return true;
  }
  
  public void b()
  {
    if (!a()) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(str))
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap.get(str);
      if ((localObject != null) && ((localObject instanceof avqa)))
      {
        avqa localavqa = (avqa)localObject;
        if ((localavqa.jdField_a_of_type_Int > 0) && (localavqa.jdField_a_of_type_Long > 0L) && (a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString, localavqa.jdField_a_of_type_JavaLangString)))
        {
          long l = System.currentTimeMillis() - localavqa.jdField_a_of_type_Long;
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("startQueryAccount countryCode=").append(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString).append(", phoneNum=").append(bbfx.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString)).append(", leftTime=").append(localavqa.jdField_a_of_type_Int).append(", exitTime=").append(localavqa.jdField_a_of_type_Long).append(", interval=").append(l).append(", inviteCode=");
            if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString != null) {
              break label281;
            }
          }
          label281:
          for (localObject = "";; localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_c_of_type_JavaLangString)
          {
            QLog.d("QueryAccount", 2, (String)localObject);
            if ((l <= 0L) || (l >= localavqa.jdField_a_of_type_Int * 1000L)) {
              break;
            }
            a(localavqa.jdField_a_of_type_Int, localavqa.jdField_a_of_type_Long);
            return;
          }
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(str);
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.a(2131692321, 0);
      return;
    }
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("queryMobile", 2, "startQueryAccount countryCode=" + this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString + " phoneNum=" + bbfx.a(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString));
      }
      ((AccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(0)).sendRegisterQueryMobile(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.jdField_a_of_type_JavaLangString, null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.b(2131717172);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((paramIntent != null) && (this.jdField_a_of_type_AndroidContentIntent != null)) {
      paramIntent.putExtras(this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avpy
 * JD-Core Version:    0.7.0.1
 */