import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Content;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.SportManager.1;
import com.tencent.mobileqq.vashealth.StepAlarmReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public class bige
  implements Manager
{
  public static SensorManager a;
  public static volatile boolean a;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  AlarmManager jdField_a_of_type_AndroidAppAlarmManager = null;
  PendingIntent jdField_a_of_type_AndroidAppPendingIntent = null;
  Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new bigh(this);
  Handler jdField_a_of_type_AndroidOsHandler;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  StepAlarmReceiver jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver;
  BusinessObserver jdField_a_of_type_MqqObserverBusinessObserver = new bigg(this);
  PendingIntent b = null;
  
  static
  {
    jdField_a_of_type_Boolean = true;
  }
  
  public bige(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
    ThreadManager.post(new SportManager.1(this), 5, null, true);
  }
  
  public static SharedPreferences a()
  {
    String str2 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "noLogin";
    }
    return BaseApplicationImpl.getApplication().getSharedPreferences("Sport" + str1, 0);
  }
  
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT < 19) {
      return false;
    }
    if (jdField_a_of_type_AndroidHardwareSensorManager == null) {
      jdField_a_of_type_AndroidHardwareSensorManager = (SensorManager)BaseApplicationImpl.getApplication().getApplicationContext().getSystemService("sensor");
    }
    return jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(19) != null;
  }
  
  public static void d()
  {
    SharedPreferences localSharedPreferences = a();
    if (localSharedPreferences != null)
    {
      QLog.i("SportManager", 1, "max_interval:" + localSharedPreferences.getInt("max_interval", 0));
      QLog.i("SportManager", 1, "max_increment:" + localSharedPreferences.getInt("max_increment", 0));
      QLog.i("SportManager", 1, "timer1_start_hour:" + localSharedPreferences.getInt("timer1_start_hour", 0));
      QLog.i("SportManager", 1, "timer1_start_min:" + localSharedPreferences.getInt("timer1_start_min", 0));
      QLog.i("SportManager", 1, "timer1_end_hour:" + localSharedPreferences.getInt("timer1_end_hour", 0));
      QLog.i("SportManager", 1, "timer1_end_min:" + localSharedPreferences.getInt("timer1_end_min", 0));
      QLog.i("SportManager", 1, "timer1_interval:" + localSharedPreferences.getInt("timer1_interval", 0));
      QLog.i("SportManager", 1, "timer1_increment:" + localSharedPreferences.getInt("timer1_increment", 0));
      QLog.i("SportManager", 1, "timer1_span_minute:" + localSharedPreferences.getInt("timer1_span_minute", 0));
      QLog.i("SportManager", 1, "timer2_start_hour:" + localSharedPreferences.getInt("timer2_start_hour", 0));
      QLog.i("SportManager", 1, "timer2_end_hour:" + localSharedPreferences.getInt("timer2_end_hour", 0));
      QLog.i("SportManager", 1, "timer2_interval:" + localSharedPreferences.getInt("timer2_interval", 0));
      QLog.i("SportManager", 1, "timer2_retry_times:" + localSharedPreferences.getInt("timer2_retry_times", 0));
      QLog.i("SportManager", 1, "config_ready:" + localSharedPreferences.getBoolean("config_ready", false));
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver == null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver = new StepAlarmReceiver(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject2 = new IntentFilter();
    ((IntentFilter)localObject2).addAction("action_sport_timer1");
    ((IntentFilter)localObject2).addAction("action_sport_timer2");
    ((IntentFilter)localObject2).addAction("StepAlarmReceiver_long_time_report");
    try
    {
      ((Context)localObject1).registerReceiver(this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver, (IntentFilter)localObject2);
      localObject2 = a();
      bool = ((SharedPreferences)localObject2).getBoolean("config_ready", false);
      if (bool)
      {
        Intent localIntent1 = new Intent("action_sport_timer1");
        Intent localIntent2 = new Intent("action_sport_timer2");
        if (this.jdField_a_of_type_AndroidAppPendingIntent == null) {
          this.jdField_a_of_type_AndroidAppPendingIntent = PendingIntent.getBroadcast((Context)localObject1, 0, localIntent1, 0);
        }
        if (this.b == null) {
          this.b = PendingIntent.getBroadcast((Context)localObject1, 0, localIntent2, 0);
        }
        if (this.jdField_a_of_type_AndroidAppAlarmManager == null) {
          this.jdField_a_of_type_AndroidAppAlarmManager = ((AlarmManager)((Context)localObject1).getSystemService("alarm"));
        }
        int j = ((SharedPreferences)localObject2).getInt("timer1_span_minute", 20);
        int i = j;
        if (j <= 0) {
          i = 20;
        }
        i = new Random().nextInt(i);
        j = new Random().nextInt(59);
        localObject1 = Calendar.getInstance();
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        ((Calendar)localObject1).set(11, ((SharedPreferences)localObject2).getInt("timer1_start_hour", 0));
        ((Calendar)localObject1).set(12, i + ((SharedPreferences)localObject2).getInt("timer1_start_min", 0));
        ((Calendar)localObject1).set(13, j);
        ((Calendar)localObject1).set(14, 0);
        long l = ((Calendar)localObject1).getTimeInMillis();
        this.jdField_a_of_type_AndroidAppAlarmManager.set(1, l, this.jdField_a_of_type_AndroidAppPendingIntent);
        QLog.i("SportManager", 1, "register AlarmManager, alarmTime1:" + l);
        ((Calendar)localObject1).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
        i = new Random().nextInt(25);
        j = new Random().nextInt(59);
        ((Calendar)localObject1).set(12, i + 5);
        ((Calendar)localObject1).set(13, j);
        ((Calendar)localObject1).set(14, 0);
        if (((Calendar)localObject1).get(11) < ((SharedPreferences)localObject2).getInt("timer2_end_hour", 0))
        {
          ((Calendar)localObject1).set(11, 0);
          l = ((Calendar)localObject1).getTimeInMillis();
          this.jdField_a_of_type_AndroidAppAlarmManager.set(1, l, this.b);
          QLog.i("SportManager", 1, "register AlarmManager, alarmTime2:" + l);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      boolean bool;
      for (;;)
      {
        QLog.e("SportManager", 1, "registerReceiver error", localException);
        continue;
        ((Calendar)localObject1).set(11, localException.getInt("timer2_start_hour", 0));
      }
      QLog.e("SportManager", 1, "isConfigReady:" + bool);
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    if ((paramConfig.msg_content_list != null) && (paramConfig.msg_content_list.size() > 0))
    {
      paramConfig = (ConfigurationService.Content)paramConfig.msg_content_list.get(0);
      if (paramConfig != null) {}
      for (;;)
      {
        try
        {
          if (paramConfig.compress.get() == 1)
          {
            paramConfig = apjh.a(paramConfig.content.get().toByteArray());
            if (paramConfig == null) {
              break label357;
            }
            paramConfig = new String(paramConfig, "utf-8");
            if (QLog.isColorLevel()) {
              QLog.i("SportManager", 2, "get sport config:" + paramConfig);
            }
            if (!TextUtils.isEmpty(paramConfig)) {}
          }
          else
          {
            paramConfig = new String(paramConfig.content.get().toByteArray(), "utf-8");
            continue;
          }
          paramConfig = new JSONObject(paramConfig).getJSONObject("android");
          a().edit().putInt("max_interval", paramConfig.optInt("max_interval")).putInt("max_increment", paramConfig.optInt("max_increment")).putInt("timer1_start_hour", paramConfig.optInt("timer1_start_hour")).putInt("timer1_start_min", paramConfig.optInt("timer1_start_min")).putInt("timer1_end_hour", paramConfig.optInt("timer1_end_hour")).putInt("timer1_end_min", paramConfig.optInt("timer1_end_min")).putInt("timer1_interval", paramConfig.optInt("timer1_interval")).putInt("timer1_increment", paramConfig.optInt("timer1_increment")).putInt("timer1_span_minute", paramConfig.optInt("timer1_span_minute")).putInt("timer2_start_hour", paramConfig.optInt("timer2_start_hour")).putInt("timer2_end_hour", paramConfig.optInt("timer2_end_hour")).putInt("timer2_interval", paramConfig.optInt("timer2_interval")).putInt("timer2_retry_times", paramConfig.optInt("timer2_retry_times")).putBoolean("config_ready", true).commit();
          return;
        }
        catch (Exception paramConfig)
        {
          QLog.e("SportManager", 1, "handleSportConfig error:", paramConfig);
          return;
        }
        label357:
        paramConfig = null;
        continue;
        paramConfig = null;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("SportManager", 1, "refreshCurrentStep call from:" + paramString);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (System.currentTimeMillis() - this.jdField_a_of_type_Long < 10000L)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    paramString = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), bigj.class);
    paramString.putExtra("msf_cmd_type", "cmd_refresh_steps");
    paramString.setObserver(this.jdField_a_of_type_MqqObserverBusinessObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SportManager", 2, "doOnTimer1");
    }
    Object localObject1 = a();
    int i = ((SharedPreferences)localObject1).getInt("timer1_interval", 0);
    int j = ((SharedPreferences)localObject1).getInt("timer1_increment", 0);
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(NetConnInfoCenter.getServerTimeMillis());
    ((Calendar)localObject2).set(11, ((SharedPreferences)localObject1).getInt("timer1_end_hour", 0));
    ((Calendar)localObject2).set(12, ((SharedPreferences)localObject1).getInt("timer1_end_min", 0));
    ((Calendar)localObject2).set(13, 0);
    ((Calendar)localObject2).set(14, 0);
    long l = ((Calendar)localObject2).getTimeInMillis();
    QLog.i("SportManager", 1, "do on timer 1,interval:" + i + ",increment:" + j + ",enable:" + jdField_a_of_type_Boolean);
    if ((!jdField_a_of_type_Boolean) || (j == 0) || (i == 0)) {}
    do
    {
      return;
      localObject1 = new bigf(this, l, i, j);
    } while (jdField_a_of_type_AndroidHardwareSensorManager == null);
    localObject2 = jdField_a_of_type_AndroidHardwareSensorManager.getDefaultSensor(19);
    try
    {
      jdField_a_of_type_AndroidHardwareSensorManager.registerListener((SensorEventListener)localObject1, (Sensor)localObject2, 3, 60000);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("SportManager", 1, localException, new Object[0]);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SportManager", 2, "doOnTimer2");
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void onDestroy()
  {
    if ((this.jdField_a_of_type_AndroidAppAlarmManager != null) && (this.jdField_a_of_type_AndroidAppPendingIntent != null) && (this.b != null))
    {
      this.jdField_a_of_type_AndroidAppAlarmManager.cancel(this.jdField_a_of_type_AndroidAppPendingIntent);
      this.jdField_a_of_type_AndroidAppAlarmManager.cancel(this.b);
      this.jdField_a_of_type_AndroidAppAlarmManager = null;
      this.jdField_a_of_type_AndroidAppPendingIntent = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver != null) {}
    try
    {
      BaseApplicationImpl.getApplication().getApplicationContext().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver);
      this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver.a();
      this.jdField_a_of_type_ComTencentMobileqqVashealthStepAlarmReceiver = null;
      label85:
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_AndroidHardwareSensorManager = null;
      return;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bige
 * JD-Core Version:    0.7.0.1
 */