import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class bfwi
{
  public static boolean a;
  private static boolean jdField_b_of_type_Boolean;
  bfvp jdField_a_of_type_Bfvp = null;
  String jdField_a_of_type_JavaLangString = "-1";
  private String jdField_b_of_type_JavaLangString = "-1";
  private String jdField_c_of_type_JavaLangString = "-1";
  private boolean jdField_c_of_type_Boolean;
  private String d = "-1";
  private String e = "-1";
  private String f = "-1";
  private String g = "-1";
  
  public bfwi()
  {
    if (jdField_b_of_type_Boolean) {}
    label200:
    for (;;)
    {
      return;
      jdField_b_of_type_Boolean = true;
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("JumpReportCtr_SP", 0);
      long l = localSharedPreferences.getLong("lastShotTime", 0L);
      if (Math.abs(System.currentTimeMillis() - l) >= 43200000L) {
        if (0.01F >= Math.random())
        {
          jdField_a_of_type_Boolean = bool;
          localSharedPreferences.edit().putLong("lastShotTime", System.currentTimeMillis()).putBoolean("lastShotResult", jdField_a_of_type_Boolean).apply();
        }
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label200;
        }
        QLog.d("JumpActivity.Report", 2, "JumpReportCtr init needReport= " + jdField_a_of_type_Boolean);
        return;
        bool = false;
        break;
        jdField_a_of_type_Boolean = localSharedPreferences.getBoolean("lastShotResult", false);
      }
    }
  }
  
  public void a(Intent paramIntent)
  {
    if (!jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramIntent != null) {
        this.jdField_c_of_type_JavaLangString = paramIntent.getComponent().getClassName();
      }
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      paramIntent = new HashMap(5);
      paramIntent.put("action", this.d);
      paramIntent.put("scheme", this.e);
      paramIntent.put("type", this.f);
      paramIntent.put("data", this.g);
      paramIntent.put("fromPkg", this.jdField_b_of_type_JavaLangString);
      paramIntent.put("jumpToAct", this.jdField_c_of_type_JavaLangString);
      paramIntent.put("shareContext", this.jdField_a_of_type_JavaLangString);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "jump_act_system_report", true, 0L, 0L, paramIntent, null);
      paramIntent = new StringBuilder(256);
      paramIntent.append("action=").append(this.d).append(", pkgName=").append(this.jdField_b_of_type_JavaLangString).append(", jumpToAct=").append(this.jdField_c_of_type_JavaLangString).append(", scheme=").append(this.e).append(", type=").append(this.f).append(", shareContext=").append(this.jdField_a_of_type_JavaLangString).append("\n data=").append(this.g);
    } while (!QLog.isColorLevel());
    QLog.d("JumpActivity.Report", 2, "systemShare|report : \n" + paramIntent.toString());
    return;
    String str;
    if (this.jdField_a_of_type_Bfvp != null)
    {
      str = this.jdField_a_of_type_Bfvp.jdField_b_of_type_JavaLangString;
      paramIntent = this.jdField_a_of_type_Bfvp.jdField_c_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject = new HashMap(8);
      ((HashMap)localObject).put("action", this.d);
      ((HashMap)localObject).put("scheme", this.e);
      ((HashMap)localObject).put("type", this.f);
      ((HashMap)localObject).put("data", this.g);
      ((HashMap)localObject).put("fromPkg", this.jdField_b_of_type_JavaLangString);
      ((HashMap)localObject).put("jumpToAct", this.jdField_c_of_type_JavaLangString);
      ((HashMap)localObject).put("server_name", str);
      ((HashMap)localObject).put("action_name", paramIntent);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "jump_act_business_report", true, 0L, 0L, (HashMap)localObject, null);
      localObject = new StringBuilder(256);
      ((StringBuilder)localObject).append("action=").append(this.d).append(", type=").append(this.f).append(", pkgName=").append(this.jdField_b_of_type_JavaLangString).append(", jumpToAct=").append(this.jdField_c_of_type_JavaLangString).append(", scheme=").append(this.e).append(", server_name=").append(str).append(", action_name=").append(paramIntent).append("\n data=").append(this.g);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("JumpActivity.Report", 2, "business share |report params: \n" + ((StringBuilder)localObject).toString());
      return;
      paramIntent = "-1";
      str = "-1";
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent)
  {
    if (paramIntent == null) {}
    label4:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              break label4;
              break label4;
              break label4;
              do
              {
                return;
              } while (!jdField_a_of_type_Boolean);
              Object localObject = bfwf.a(paramActivity);
              StringBuilder localStringBuilder = new StringBuilder();
              if ((localObject != null) && (!((HashSet)localObject).isEmpty()))
              {
                localObject = ((HashSet)localObject).iterator();
                while (((Iterator)localObject).hasNext())
                {
                  String str = (String)((Iterator)localObject).next();
                  if (localStringBuilder.length() > 0) {
                    localStringBuilder.append("|");
                  }
                  localStringBuilder.append(str);
                }
              }
              this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
              this.jdField_c_of_type_Boolean = a(paramIntent);
              this.d = paramIntent.getAction();
              this.e = paramIntent.getScheme();
              this.f = paramIntent.getType();
              this.g = paramIntent.getDataString();
              if (!this.jdField_c_of_type_Boolean) {
                break;
              }
            } while ((!this.d.equals("android.intent.action.SEND")) && (!this.d.equals("android.intent.action.SEND_MULTIPLE")));
            paramQQAppInterface = paramIntent.getExtras();
          } while (paramQQAppInterface == null);
          if (!TextUtils.isEmpty(paramQQAppInterface.getString("android.intent.extra.TEXT")))
          {
            this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getString("android.intent.extra.TEXT");
            return;
          }
          paramQQAppInterface = paramQQAppInterface.get("android.intent.extra.STREAM");
        } while (paramQQAppInterface == null);
        if ((paramQQAppInterface instanceof Uri))
        {
          this.jdField_a_of_type_JavaLangString = ((Uri)paramQQAppInterface).toString();
          return;
        }
        if ((paramQQAppInterface instanceof String))
        {
          this.jdField_a_of_type_JavaLangString = ((String)paramQQAppInterface);
          return;
        }
      } while (!(paramQQAppInterface instanceof ArrayList));
      this.jdField_a_of_type_JavaLangString = "MULTIPLE_SHARE";
      return;
    } while ((TextUtils.isEmpty(this.g)) || (paramQQAppInterface == null));
    this.jdField_a_of_type_Bfvp = bfwg.a(paramQQAppInterface, paramActivity, this.g);
  }
  
  public boolean a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramIntent.getAction();
      } while (TextUtils.isEmpty(str));
      if ((str.equals("android.intent.action.SEND")) || (str.equals("android.intent.action.SEND_MULTIPLE"))) {
        return true;
      }
      paramIntent = paramIntent.getScheme();
    } while ((!str.equals("android.intent.action.VIEW")) || (TextUtils.isEmpty(paramIntent)) || ((!paramIntent.equals("file")) && (!paramIntent.equals("content"))));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfwi
 * JD-Core Version:    0.7.0.1
 */