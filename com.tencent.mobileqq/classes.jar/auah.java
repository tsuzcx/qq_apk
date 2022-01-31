import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Calendar;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import oicq.wlogin_sdk.request.WFastLoginInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONArray;

public class auah
  implements Handler.Callback, Manager
{
  public static String a;
  public int a;
  private long jdField_a_of_type_Long = -1L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public JSONArray a;
  public boolean a;
  public int b;
  public JSONArray b;
  public int c = 5;
  public int d = 24;
  private int e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TimJumpLoginManager";
  }
  
  public auah(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 60;
    this.jdField_b_of_type_Int = 72;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "switchKey false");
      }
    }
    label182:
    label482:
    for (;;)
    {
      return false;
      if (this.e > this.c)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "showCount = " + this.e + ", showTipTotalCount = " + this.c);
          return false;
        }
      }
      else if (System.currentTimeMillis() - this.jdField_a_of_type_Long < this.d * 60 * 60 * 1000)
      {
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "lastShowTime = " + this.jdField_a_of_type_Long + ", showTipHourInterval = " + this.d);
          return false;
        }
      }
      else
      {
        Object localObject = Calendar.getInstance();
        int j = ((Calendar)localObject).get(7);
        if (this.jdField_a_of_type_OrgJsonJSONArray != null)
        {
          i = 0;
          if (i < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            if (j - 1 != this.jdField_a_of_type_OrgJsonJSONArray.optInt(i)) {}
          }
        }
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label482;
          }
          i = ((Calendar)localObject).get(11);
          if ((this.jdField_b_of_type_OrgJsonJSONArray == null) || (this.jdField_b_of_type_OrgJsonJSONArray.length() != 2)) {
            break;
          }
          j = this.jdField_b_of_type_OrgJsonJSONArray.optInt(0);
          int k = this.jdField_b_of_type_OrgJsonJSONArray.optInt(1);
          if ((i < j) || (i >= k)) {
            break;
          }
          if (!bhtl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim"))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "tim not installed");
            return false;
            i += 1;
            break label182;
          }
          localObject = new File(Environment.getExternalStorageDirectory().getPath() + "/tencent/msflogs/com/tencent/tim");
          if ((((File)localObject).exists()) && (System.currentTimeMillis() - ((File)localObject).lastModified() < this.jdField_b_of_type_Int * 60 * 60 * 1000))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d(jdField_a_of_type_JavaLangString, 2, "timLogFile.lastModified() = " + ((File)localObject).lastModified() + ", androidLimit = " + this.jdField_b_of_type_Int);
            return false;
          }
          if ((BaseActivity.sTopActivity instanceof SplashActivity))
          {
            localObject = (SplashActivity)BaseActivity.sTopActivity;
            if (SplashActivity.jdField_a_of_type_Int != 1) {}
          }
          for (i = 1;; i = 0)
          {
            if (i == 0)
            {
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d(jdField_a_of_type_JavaLangString, 2, "is not in main tab");
              return false;
            }
            return true;
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {}
    Object localObject1;
    label123:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "showTimLoginDialog");
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
      try
      {
        localObject2 = ((SharedPreferences)localObject1).getString("tim_login_sd", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray((String)localObject2);
        }
        localObject2 = ((SharedPreferences)localObject1).getString("tim_login_st", "");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.jdField_b_of_type_OrgJsonJSONArray = new JSONArray((String)localObject2);
        }
      }
      catch (Exception localException2)
      {
        Object localObject2;
        int i;
        String str4;
        String str2;
        String str5;
        String str6;
        Object localObject3;
        String str3;
        JSONArray localJSONArray;
        String str1;
        break label123;
      }
      this.jdField_b_of_type_Int = ((SharedPreferences)localObject1).getInt("tim_login_l", 72);
      this.c = ((SharedPreferences)localObject1).getInt("tim_login_tc", 5);
      this.d = ((SharedPreferences)localObject1).getInt("tim_login_sti", 24);
      this.jdField_a_of_type_Long = ((SharedPreferences)localObject1).getLong("tim_login_lct", 0L);
      this.e = ((SharedPreferences)localObject1).getInt("tim_login_sc", 0);
    } while (!a());
    localObject2 = ((SharedPreferences)localObject1).edit();
    i = this.e + 1;
    this.e = i;
    ((SharedPreferences.Editor)localObject2).putInt("tim_login_sc", i);
    ((SharedPreferences.Editor)localObject2).putLong("tim_login_lct", System.currentTimeMillis());
    ((SharedPreferences.Editor)localObject2).commit();
    localObject2 = alud.a(2131715377);
    str4 = "登录TIM";
    str2 = alud.a(2131715376);
    str5 = ((SharedPreferences)localObject1).getString("tim_login_t", "QQ办公简洁版");
    str6 = ((SharedPreferences)localObject1).getString("tim_login_c", (String)localObject2);
    localObject2 = str2;
    try
    {
      localObject1 = ((SharedPreferences)localObject1).getString("tim_login_btns", "");
      localObject3 = str2;
      str3 = str4;
      localObject2 = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = str2;
        localJSONArray = new JSONArray((String)localObject1);
        localObject3 = str2;
        str3 = str4;
        if (localJSONArray != null)
        {
          localObject3 = str2;
          str3 = str4;
          localObject2 = str2;
          if (localJSONArray.length() == 2)
          {
            localObject1 = str2;
            localObject2 = str2;
            if (!TextUtils.isEmpty(localJSONArray.optString(0)))
            {
              localObject2 = str2;
              localObject1 = localJSONArray.optString(0);
            }
            localObject3 = localObject1;
            str3 = str4;
            localObject2 = localObject1;
            if (!TextUtils.isEmpty(localJSONArray.optString(1)))
            {
              localObject2 = localObject1;
              str3 = localJSONArray.optString(1);
              localObject3 = localObject1;
            }
          }
        }
      }
      localObject1 = str3;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        str1 = "登录TIM";
        localObject3 = localObject2;
      }
    }
    bdgm.a(BaseActivity.sTopActivity, 230, str5, str6, (String)localObject3, (String)localObject1, new auai(this), new auaj(this)).show();
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80085D9", "0X80085D9", 0, 0, "", "", "", "");
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(10011)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(10011);
    }
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("tim_login_shared_pre_" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 0);
    this.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("tim_login_s", false);
    this.jdField_a_of_type_Int = localSharedPreferences.getInt("tim_login_tal", 60);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "switchKey = " + this.jdField_a_of_type_Boolean + ", showTipTimeIntervalAfterLogined = " + this.jdField_a_of_type_Int);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_Int >= 0)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10011, this.jdField_a_of_type_Int * 1000);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (!bdiv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131720802, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "jumpTimLogin tim not install ");
      }
      return;
    }
    String str = bdiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim");
    int i = aoxg.a().b();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "jumpTimLogin tim timVersion=" + str + "tim limit version = " + i);
    }
    int j;
    do
    {
      bety localbety;
      try
      {
        j = Integer.parseInt(str.replace(".", ""));
        if (j != 0) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131720802, 0).a();
        return;
      }
      catch (Exception localException)
      {
        localbety = new bety(BaseActivity.sTopActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDimensionPixelOffset(2131298914));
        localbety.a(alud.a(2131715375));
        localbety.show();
        WtloginHelper localWtloginHelper = new WtloginHelper(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext());
        localWtloginHelper.SetTimeOut(20);
        localWtloginHelper.SetMsfTransportFlag(1);
        localWtloginHelper.SetListener(new auak(this, localbety, localWtloginHelper, paramBundle));
        paramBundle = util.getPkgSigFromApkName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), "com.tencent.tim");
        i = localWtloginHelper.GetA1WithA1(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 16L, 16L, "com.tencent.tim".getBytes(), 1L, 16L, 16L, "8.3.5".getBytes(), paramBundle, new WUserSigInfo(), new WFastLoginInfo());
      }
      if (i == -1001) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "jumpTimLogin GetA1WithA1, retCode = " + i);
      }
      if ((localbety != null) && (localbety.isShowing())) {
        localbety.dismiss();
      }
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131720801, 0).a();
      return;
    } while (j >= i);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 1, 2131720803, 0).a();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auah
 * JD-Core Version:    0.7.0.1
 */