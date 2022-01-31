import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.PluginPreInstaller.2;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class biru
{
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qlink_plugin.apk" };
  private static final String[] b = { "qqreaderplugin.apk", "comic_plugin.apk", "Photoplus.apk" };
  private static final String[] c = { "qqhotspot_plugin.apk" };
  private static final String[] d = new String[0];
  private static final String[] e = { "qqreaderplugin.apk", "comic_plugin.apk" };
  private Context jdField_a_of_type_AndroidContentContext;
  private biqn jdField_a_of_type_Biqn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private OnPluginInstallListener jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener = new birv(this);
  
  public biru(Context paramContext, biqn parambiqn, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Biqn = parambiqn;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    c();
  }
  
  private int a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt("total_retried_times_" + paramString, 0);
  }
  
  private List<String> a()
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int i = 0;
    while (i < k)
    {
      localArrayList.add(arrayOfString[i]);
      i += 1;
    }
    if (bdin.a(this.jdField_a_of_type_AndroidContentContext))
    {
      arrayOfString = b;
      k = arrayOfString.length;
      i = 0;
      if (i < k)
      {
        String str = arrayOfString[i];
        if ((str.equals("Photoplus.apk")) && (bhtb.d())) {}
        for (;;)
        {
          i += 1;
          break;
          localArrayList.add(str);
        }
      }
    }
    if ((bdgk.e()) || (bdhb.a() <= 1.048576E+008F))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PluginPreInstaller", 2, "plugins " + Arrays.toString(e) + "filtered in low end phone");
      }
      arrayOfString = e;
      k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        localArrayList.remove(arrayOfString[i]);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("PluginPreInstaller", 4, "installPlugin plugin = " + paramString + ", totalTimes = " + paramInt1 + ", todayTimes = " + paramInt2);
    }
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
    Object localObject = new Date();
    localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
    localEditor.putInt("total_retried_times_" + paramString, paramInt1 + 1);
    localEditor.putInt("today_retried_times_" + paramString, paramInt2 + 1);
    localEditor.putString("last_retry_day_" + paramString, (String)localObject);
    localEditor.commit();
    this.jdField_a_of_type_Biqn.a(paramString, this.jdField_a_of_type_ComTencentMobileqqPluginsdkOnPluginInstallListener, true);
    if (("qqreaderplugin.apk".equals(paramString)) && (bizl.a(this.jdField_a_of_type_AndroidContentContext) == -1))
    {
      ThreadManager.post(new PluginPreInstaller.2(this), 5, null, false);
      if (QLog.isColorLevel()) {
        QLog.e("PluginPreInstaller", 2, "");
      }
    }
    while (!"comic_plugin.apk".equals(paramString)) {
      return;
    }
    bimq.a(1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private int b(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    Date localDate = new Date();
    if (jdField_a_of_type_JavaTextSimpleDateFormat.format(localDate).equals(localSharedPreferences.getString("last_retry_day_" + paramString, ""))) {
      i = localSharedPreferences.getInt("today_retried_times_" + paramString, 0);
    }
    return i;
  }
  
  private void c()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getString("plugin_pre_install_qq_version", "").equals(bdgk.c()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localEditor.remove("total_retried_times_" + str);
      }
      localEditor.commit();
    }
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = a().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          if (this.jdField_a_of_type_Biqn.isPlugininstalled(str)) {
            continue;
          }
          int i = a(str);
          if (i >= 10) {
            continue;
          }
          int j = b(str);
          if (j >= 2) {
            continue;
          }
          a(str, i, j);
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
        }
      }
    }
    finally {}
  }
  
  public void b()
  {
    for (;;)
    {
      int i;
      try
      {
        if (AppNetConnInfo.isWifiConn())
        {
          if (QLog.isColorLevel()) {
            QLog.e("PluginPreInstaller", 2, "preinstall start,wifi_reinstall_only.");
          }
          String[] arrayOfString = d;
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            try
            {
              if (!this.jdField_a_of_type_Biqn.isPlugininstalled(str))
              {
                a(str, a(str), b(str));
              }
              else if ("QQWifiPlugin.apk".equals(str))
              {
                Intent localIntent = new Intent("com.tencent.mobileqq.cooperation.plugin." + str);
                localIntent.putExtra("plugin", str);
                this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
              }
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label193;
              }
            }
            QLog.e("PluginPreInstaller", 2, "preinstall plugin : " + str + " failed.", localException);
          }
        }
      }
      finally {}
      return;
      label193:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biru
 * JD-Core Version:    0.7.0.1
 */