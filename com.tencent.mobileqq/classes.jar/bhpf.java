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

public class bhpf
  implements Handler.Callback
{
  private static bhpf jdField_a_of_type_Bhpf;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  public static String a;
  
  bhpf(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static bhpf a(String paramString)
  {
    if (jdField_a_of_type_Bhpf == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Bhpf == null) {
        jdField_a_of_type_Bhpf = new bhpf(paramString);
      }
      return jdField_a_of_type_Bhpf;
    }
  }
  
  public static void a()
  {
    Intent localIntent = new Intent(BaseApplicationImpl.getContext(), QzonePluginProxyService.class);
    BaseApplicationImpl.getContext().stopService(localIntent);
    bbbr.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:qzone");
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
      LocalMultiProcConfig.putString("comboqz_qua", bgyi.a());
    }
  }
  
  private void b(bhpg parambhpg)
  {
    boolean bool2 = false;
    int i = parambhpg.jdField_a_of_type_Int;
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
          bgyp.b(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
          return;
        } while (!(localObject instanceof QQAppInterface));
        bgyp.a((AppRuntime)localObject, true);
        return;
        a();
      } while (!(localObject instanceof QQAppInterface));
      bgyp.a((QQAppInterface)localObject, "QZoneDistributedAppCtrl");
      return;
    case 7: 
      parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_upload_dbname");
      bhpb.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, parambhpg);
      return;
    case 8: 
      bhpb.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
    case 9: 
      localObject = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_trace_baseTime");
      parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_trace_offset");
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        l1 = System.currentTimeMillis();
        if (!TextUtils.isEmpty(parambhpg)) {
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
          bhpb.a(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l2, l1);
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
          l2 = Long.valueOf(parambhpg).longValue();
          l2 *= 1000L;
        }
        catch (NumberFormatException parambhpg)
        {
          parambhpg.printStackTrace();
          l2 = 0L;
        }
      }
      break label311;
      String str = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_avsdk_startTime");
      parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_avsdk_endTime");
      long l3 = bhpb.a(str);
      l2 = bhpb.a(parambhpg);
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
      bhpb.b(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString, l3, l2);
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.d("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 4, "avsdk log push, starttime=" + str + ",endTime=" + parambhpg);
      return;
      bhpb.c(BaseApplicationImpl.getContext(), jdField_a_of_type_JavaLangString);
      return;
      try
      {
        bool1 = Boolean.parseBoolean((String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_qzcombo_protect"));
        parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      }
      catch (Throwable parambhpg)
      {
        for (;;)
        {
          try
          {
            i = Integer.parseInt((String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_qzapp_versioncode"));
          }
          catch (Throwable parambhpg)
          {
            i = 82;
            continue;
          }
          try
          {
            parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_qzh5_url");
            a(bool1, i, parambhpg);
            return;
          }
          catch (Throwable parambhpg)
          {
            continue;
            bool1 = false;
            continue;
          }
          parambhpg = parambhpg;
          i = 82;
          bool1 = bool2;
          QLog.e("QZoneDistributedAppCtrlQZoneAppCtrlUploadFileLogic", 1, "error: execute CMD_COMBQZ_PROTECT", parambhpg);
          parambhpg = "";
        }
      }
      if (!TextUtils.isEmpty(parambhpg)) {
        ServerListProvider.enableDebug(Boolean.valueOf(parambhpg).booleanValue());
      }
      if (!QLog.isDevelopLevel()) {
        break;
      }
      QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_DEBUG, param：" + parambhpg);
      return;
      parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_ctrl_param_enable");
      if (!TextUtils.isEmpty(parambhpg))
      {
        if (!Boolean.valueOf(parambhpg).booleanValue()) {
          break label882;
        }
        LocalMultiProcConfig.putString("LooperMonitor", System.currentTimeMillis() + "");
      }
      while (QLog.isDevelopLevel())
      {
        QLog.w("QZoneDistributedAppCtrl", 4, "CMD_ENABLE_PERFORMANCE_MONITOR, param：" + parambhpg);
        return;
        label882:
        LocalMultiProcConfig.putString("LooperMonitor", "-1");
      }
      str = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_path_tencent");
      if (TextUtils.isEmpty(str))
      {
        str = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_path_data");
        bool1 = true;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_upload_maxsize");
        try
        {
          l1 = Long.valueOf(parambhpg).longValue();
          if (QLog.isDevelopLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder().append("CMD_UPLOAD_CUSTOM, param：");
            if (bool1)
            {
              parambhpg = "dataPath";
              QLog.w("QZoneDistributedAppCtrl", 4, parambhpg + "," + str);
            }
          }
          else
          {
            bhpb.a(BaseApplicationImpl.getContext(), str, jdField_a_of_type_JavaLangString, l1, bool1);
            return;
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isDevelopLevel()) {
              QLog.w("QZoneDistributedAppCtrl", 4, "CMD_UPLOAD_CUSTOM, param：" + parambhpg + ",error:Not long");
            }
            l1 = 1048576L;
            continue;
            parambhpg = "tencentPath";
          }
        }
        str = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_wns_config_main");
        parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_wns_config_second");
        QzoneConfig.getInstance().printWNSConfig(str, parambhpg);
        bbuw.d();
        return;
        parambhpg = (String)parambhpg.jdField_a_of_type_JavaUtilMap.get("key_url");
        bhpb.b(BaseApplicationImpl.getContext(), parambhpg);
        return;
        a(parambhpg.jdField_a_of_type_JavaUtilMap);
        return;
      }
    }
  }
  
  private void c(bhpg parambhpg)
  {
    int i = parambhpg.jdField_a_of_type_Int;
    switch (i)
    {
    default: 
      if (QLog.isDevelopLevel()) {
        QLog.e("QZoneDistributedAppCtrl", 4, "unknown ctrl cmd " + i);
      }
      break;
    }
  }
  
  public void a(bhpg parambhpg)
  {
    if (parambhpg != null) {
      ThreadManager.executeOnNetWorkThread(new QZoneDistributedAppCtrl.1(this, parambhpg));
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
      b((bhpg)paramMessage.obj);
    }
    for (;;)
    {
      return true;
      c((bhpg)paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhpf
 * JD-Core Version:    0.7.0.1
 */