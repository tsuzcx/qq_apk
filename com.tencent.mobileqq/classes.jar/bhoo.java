import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QzonePluginProxyService;
import cooperation.qzone.ServerListProvider;
import cooperation.qzone.util.QZoneDistributedAppCtrl.1;
import java.util.Map;
import mqq.app.AppRuntime;

public class bhoo
  implements Handler.Callback
{
  private static bhoo jdField_a_of_type_Bhoo;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  
  bhoo(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static bhoo a(String paramString)
  {
    if (jdField_a_of_type_Bhoo == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bhoo == null) {
        jdField_a_of_type_Bhoo = new bhoo(paramString);
      }
      return jdField_a_of_type_Bhoo;
    }
  }
  
  public static void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    bbbd.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
  }
  
  public static void a(Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("key_rndev_bundle_url");
    paramMap = (String)paramMap.get("key_rndev_bundle_on");
    LocalMultiProcConfig.putString("Qzone.React.DevBundleUrl", str);
    LocalMultiProcConfig.putString("Qzone.React.DevBundleOn", paramMap);
    QLog.i("QZoneDistributedAppCtrl", 1, "rnbundleurl=" + str + ",rndevon=" + paramMap);
  }
  
  private void a(boolean paramBoolean, int paramInt, String paramString)
  {
    LocalMultiProcConfig.putBool("comboqz_protect_enable", paramBoolean);
    LocalMultiProcConfig.putInt("qzapp_vercode", paramInt);
    if (paramBoolean)
    {
      if (!TextUtils.isEmpty(paramString)) {
        LocalMultiProcConfig.putString("qzh5_url", paramString);
      }
      LocalMultiProcConfig.putBool("qz_safe_mode_no_tip", false);
      LocalMultiProcConfig.putString("comboqz_qua", bgxr.a());
    }
  }
  
  private void b(bhop parambhop)
  {
    boolean bool2 = false;
    int i = parambhop.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.i("QZoneDistributedAppCtrl", 2, "execCtrl cmd:" + i);
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    long l1;
    long l2;
    switch (i)
    {
    case 6: 
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.w("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
    case 4: 
    case 1: 
    case 2: 
    case 3: 
    case 5: 
      do
      {
        do
        {
          return;
          a();
          return;
          bgxy.b(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
          return;
        } while (!(localObject instanceof QQAppInterface));
        bgxy.a((AppRuntime)localObject, true);
        return;
        a();
      } while (!(localObject instanceof QQAppInterface));
      bgxy.a((QQAppInterface)localObject, "QZoneDistributedAppCtrl");
      return;
    case 7: 
      parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_upload_dbname");
      bhok.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, parambhop);
      return;
    case 8: 
      bhok.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
    case 9: 
      localObject = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_trace_baseTime");
      parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(parambhop)) {
          break label451;
        }
        l2 = 1800000L;
        label311:
        if (l1 > 0L) {
          break label1190;
        }
        l1 = System.currentTimeMillis();
      }
      break;
    }
    label451:
    boolean bool1;
    label1190:
    for (;;)
    {
      for (;;)
      {
        for (;;)
        {
          l3 = l2;
          if (l2 <= 0L) {
            l3 = 1800000L;
          }
          l2 = l1 - l3;
          if (QLog.isDevelopLevel()) {
            QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "trace startTime: " + l2 + "ms\t offsettime: " + l3 + "\t trace endTime: " + l1 + "ms");
          }
          bhok.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l2, l1);
          return;
          try
          {
            l1 = Long.valueOf((String)localObject).longValue();
            l1 *= 1000L;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
            l1 = 0L;
          }
        }
        break;
        try
        {
          l2 = Long.valueOf(parambhop).longValue();
          l2 *= 1000L;
        }
        catch (NumberFormatException parambhop)
        {
          parambhop.printStackTrace();
          l2 = 0L;
        }
      }
      break label311;
      String str = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_avsdk_startTime");
      parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_avsdk_endTime");
      long l3 = bhok.a(str);
      l2 = bhok.a(parambhop);
      if (l3 == -1L) {
        break;
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = System.currentTimeMillis();
      }
      l2 = l1;
      if (l3 > l1) {
        l2 = System.currentTimeMillis();
      }
      bhok.b(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l3, l2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str + ",endTime=" + parambhop);
      return;
      bhok.c(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
      try
      {
        bool1 = Boolean.parseBoolean((String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_qzcombo_protect"));
        parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      }
      catch (Throwable parambhop)
      {
        for (;;)
        {
          try
          {
            i = Integer.parseInt((String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_qzapp_versioncode"));
          }
          catch (Throwable parambhop)
          {
            i = 82;
            continue;
          }
          try
          {
            parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_qzh5_url");
            a(bool1, i, parambhop);
            return;
          }
          catch (Throwable parambhop)
          {
            continue;
            bool1 = false;
            continue;
          }
          parambhop = parambhop;
          i = 82;
          bool1 = bool2;
          QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", parambhop);
          parambhop = "";
        }
      }
      if (!TextUtils.isEmpty(parambhop)) {
        ServerListProvider.enableDebug(Boolean.valueOf(parambhop).booleanValue());
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param：" + parambhop);
      return;
      parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(parambhop))
      {
        if (!Boolean.valueOf(parambhop).booleanValue()) {
          break label882;
        }
        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + parambhop);
        return;
        label882:
        LocalMultiProcConfig.putString("LooperMonitor", "-1");
      }
      str = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_path_tencent");
      if (TextUtils.isEmpty(str))
      {
        str = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_path_data");
        bool1 = true;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_upload_maxsize");
        try
        {
          l1 = Long.valueOf(parambhop).longValue();
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("CMD_UPLOAD_CUSTOM, param：");
            if (bool1)
            {
              parambhop = "dataPath";
              QLog.w("QZoneDistributedAppCtrl", 4, parambhop + "," + str);
            }
          }
          else
          {
            bhok.a(BaseApplicationImpl.getContext(), str, jdField_a_of_type_JavaLangString, l1, bool1);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param：" + parambhop + ",error:Not long");
            }
            l1 = 1048576L;
            continue;
            parambhop = "tencentPath";
          }
        }
        str = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_wns_config_main");
        parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_wns_config_second");
        QzoneConfig.getInstance().printWNSConfig(str, parambhop);
        bbui.d();
        return;
        parambhop = (String)parambhop.jdField_a_of_type_JavaUtilMap.get("key_url");
        bhok.b(BaseApplicationImpl.getContext(), parambhop);
        return;
        a(parambhop.jdField_a_of_type_JavaUtilMap);
        return;
      }
    }
  }
  
  private void c(bhop parambhop)
  {
    int i = parambhop.jdField_a_of_type_Int;
    switch (i)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
      break;
    }
  }
  
  public void a(bhop parambhop)
  {
    if (parambhop != null) {
      ThreadManager.executeOnNetWorkThread(new QZoneDistributedAppCtrl.1(this, parambhop));
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QZoneDistributedAppCtrl", 4, "recv msg " + paramMessage);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 1: 
      b((bhop)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((bhop)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhoo
 * JD-Core Version:    0.7.0.1
 */