import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import mqq.manager.Manager;

public class bezz
  implements Handler.Callback, Manager
{
  private double jdField_a_of_type_Double = 0.0D;
  private long jdField_a_of_type_Long;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bezy jdField_a_of_type_Bezy;
  private bfab jdField_a_of_type_Bfab = new bfab(null);
  private bhgv jdField_a_of_type_Bhgv = new bfaa(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<bezy> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private boolean jdField_a_of_type_Boolean;
  private double jdField_b_of_type_Double = 0.0D;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private ArrayList<bezy> jdField_b_of_type_JavaUtilArrayList = new ArrayList(10);
  private boolean jdField_b_of_type_Boolean;
  private double jdField_c_of_type_Double = 30.0D;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private double jdField_d_of_type_Double = 50.0D;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private long jdField_e_of_type_Long;
  private boolean jdField_e_of_type_Boolean;
  private long jdField_f_of_type_Long;
  private boolean jdField_f_of_type_Boolean;
  private long jdField_g_of_type_Long = 6L;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h;
  
  public bezz(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface);
  }
  
  private int a()
  {
    int i = 0;
    if (BaseApplicationImpl.isFirstLaunchNew) {
      i = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " getStartUpCondition  condition = " + i);
      }
      return i;
      if (BaseApplicationImpl.isCurrentVersionFirstLaunch) {
        i = 2;
      }
    }
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "department should not be empty");
      }
      paramString = null;
      return paramString;
    }
    String str3 = (String)bezx.b.get(Integer.valueOf(paramInt));
    if (TextUtils.isEmpty(str3))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return null;
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        String str1 = bigv.a(Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
        File localFile = new File(str1);
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        str1 = str1 + paramString + "/" + str3;
        paramString = str1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("PreDownloadScheduler", 1, "[getPreDownloadPath] path = " + str1);
        return str1;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, "Exception:", localException);
        }
        str2 = bigv.a("/sdcard/tencent/MobileQQ/pddata/");
        continue;
      }
      String str2 = BaseApplicationImpl.getContext().getFilesDir() + "/pddata/";
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (nny.a(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private void a(double paramDouble1, double paramDouble2, String paramString, long paramLong)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("downloadUrl", paramString);
    localHashMap.put("downloadSize", String.valueOf(paramLong));
    localHashMap.put("CPU", String.valueOf(paramDouble2));
    localHashMap.put("FPS", String.valueOf(paramDouble1));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report puse info]:");
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(paramString);
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(paramLong));
      localStringBuilder.append(", ").append("CPU").append("=").append(String.valueOf(paramDouble2));
      localStringBuilder.append(", ").append("FPS").append("=").append(String.valueOf(paramDouble1));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    bdmc.a(BaseApplicationImpl.getApplication()).a(null, "PreDownloadReportPause", true, 0L, 0L, localHashMap, null);
  }
  
  private void a(int paramInt, bezy parambezy)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[network or reqconditon not fit] donot download task :\n");
      localStringBuilder.append(",businessID=").append(parambezy.jdField_a_of_type_Int);
      localStringBuilder.append(",businessName=").append(parambezy.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",downloadUrl=").append(parambezy.jdField_e_of_type_JavaLangString);
      localStringBuilder.append(",reqCondition=").append(parambezy.jdField_f_of_type_Int);
      localStringBuilder.append(",current appBackground=").append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(",reqNetWork=").append(parambezy.jdField_b_of_type_Int);
      localStringBuilder.append(",current netWorkType=").append(paramInt);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (bezs)paramMessage.obj;
    if ((this.jdField_a_of_type_Bezy != null) && (this.jdField_a_of_type_Bezy.jdField_a_of_type_Bezs != null) && (paramMessage != null) && (this.jdField_a_of_type_Bezy.jdField_a_of_type_Bezs == paramMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " pre download onTaskEnd task key = " + this.jdField_a_of_type_Bezy.jdField_a_of_type_Bezs.key);
      }
      this.jdField_a_of_type_Bezy = null;
    }
    e();
  }
  
  private void a(bezy parambezy)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[forbidden on first start] remove task :\n");
      localStringBuilder.append(",businessID=").append(parambezy.jdField_a_of_type_Int);
      localStringBuilder.append(",businessName=").append(parambezy.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(",downloadUrl=").append(parambezy.jdField_e_of_type_JavaLangString);
      localStringBuilder.append(",reqCondition=").append(parambezy.jdField_f_of_type_Int);
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, bezy parambezy)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder(paramString);
      paramString.append(",businessID=").append(parambezy.jdField_a_of_type_Int);
      paramString.append(",businessName=").append(parambezy.jdField_a_of_type_JavaLangString);
      paramString.append(",downloadUrl=").append(parambezy.jdField_e_of_type_JavaLangString);
      paramString.append(",fileKey=").append(parambezy.jdField_d_of_type_JavaLangString);
      QLog.d("PreDownloadScheduler", 2, paramString.toString());
    }
  }
  
  private void b(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    int j = paramMessage.arg1;
    if (!TextUtils.isEmpty(str))
    {
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        paramMessage = (bezy)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (str.equals(paramMessage.jdField_e_of_type_JavaLangString))
        {
          paramMessage.jdField_d_of_type_Long = j;
          paramMessage.jdField_c_of_type_Long = (System.currentTimeMillis() - paramMessage.jdField_b_of_type_Long);
          paramMessage.jdField_e_of_type_Int = 2;
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[msg download sucess] task.url = " + paramMessage.jdField_e_of_type_JavaLangString);
          }
          c(paramMessage);
          this.jdField_b_of_type_JavaUtilArrayList.remove(i);
          if (paramMessage == this.jdField_a_of_type_Bezy) {
            this.jdField_a_of_type_Bezy = null;
          }
        }
        i += 1;
      }
    }
    e();
  }
  
  private void b(bezy parambezy)
  {
    int i = nny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    if ((i <= 1) || (i >= parambezy.jdField_b_of_type_Int))
    {
      parambezy.jdField_g_of_type_Int = a();
      parambezy.jdField_b_of_type_Long = System.currentTimeMillis();
      parambezy.jdField_g_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      parambezy.jdField_e_of_type_Int = 1;
      parambezy.jdField_a_of_type_Bezs.start();
      this.jdField_b_of_type_JavaUtilArrayList.add(parambezy);
      a("[start downloading direct without contrl] begin task :", parambezy);
      c(parambezy);
    }
  }
  
  private void c(Message paramMessage)
  {
    paramMessage = (String)paramMessage.obj;
    if (!TextUtils.isEmpty(paramMessage))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bezy localbezy = (bezy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramMessage.equals(localbezy.jdField_e_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.remove(localbezy);
          localbezy.jdField_e_of_type_Int = 3;
          c(localbezy);
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[ msg cancel] task.url = " + localbezy.jdField_e_of_type_JavaLangString);
          }
          if (localbezy == this.jdField_a_of_type_Bezy) {
            this.jdField_a_of_type_Bezy = null;
          }
          g();
        }
        i += 1;
      }
    }
    e();
  }
  
  private void c(bezy parambezy)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    HashMap localHashMap = new HashMap(20);
    localHashMap.put("businessID", String.valueOf(parambezy.jdField_a_of_type_Int));
    localHashMap.put("businessName", parambezy.jdField_a_of_type_JavaLangString);
    localHashMap.put("businessEngName", parambezy.jdField_b_of_type_JavaLangString);
    localHashMap.put("department", parambezy.jdField_c_of_type_JavaLangString);
    localHashMap.put("fileKey", parambezy.jdField_d_of_type_JavaLangString);
    localHashMap.put("downloadUrl", parambezy.jdField_e_of_type_JavaLangString);
    localHashMap.put("filePath", parambezy.jdField_f_of_type_JavaLangString);
    localHashMap.put("reqTime", String.valueOf(parambezy.jdField_a_of_type_Long));
    localHashMap.put("reqNetWork", String.valueOf(parambezy.jdField_b_of_type_Int));
    localHashMap.put("downNetWork", String.valueOf(parambezy.jdField_g_of_type_JavaLangString));
    localHashMap.put("startTime", String.valueOf(parambezy.jdField_b_of_type_Long));
    localHashMap.put("downloadTime", String.valueOf(parambezy.jdField_c_of_type_Long));
    localHashMap.put("downloadSize", String.valueOf(parambezy.jdField_d_of_type_Long));
    localHashMap.put("businessPriority", String.valueOf(parambezy.jdField_c_of_type_Int));
    localHashMap.put("innerPriority", String.valueOf(parambezy.jdField_d_of_type_Int));
    localHashMap.put("state", String.valueOf(parambezy.jdField_e_of_type_Int));
    localHashMap.put("reqCondition", String.valueOf(parambezy.jdField_f_of_type_Int));
    localHashMap.put("startCondition", String.valueOf(parambezy.jdField_g_of_type_Int));
    localHashMap.put("saveOnSD", String.valueOf(parambezy.jdField_a_of_type_Boolean));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("[report item]:");
      localStringBuilder.append(", ").append("businessID").append("=").append(parambezy.jdField_a_of_type_Int);
      localStringBuilder.append(", ").append("businessName").append("=").append(parambezy.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", ").append("businessEngName").append("=").append(parambezy.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", ").append("department").append("=").append(parambezy.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(", ").append("fileKey").append("=").append(parambezy.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(", ").append("downloadUrl").append("=").append(parambezy.jdField_e_of_type_JavaLangString);
      localStringBuilder.append(", ").append("filePath").append("=").append(parambezy.jdField_f_of_type_JavaLangString);
      localStringBuilder.append(", ").append("reqTime").append("=").append(String.valueOf(parambezy.jdField_a_of_type_Long));
      localStringBuilder.append(", ").append("reqNetWork").append("=").append(String.valueOf(parambezy.jdField_b_of_type_Int));
      localStringBuilder.append(", ").append("downNetWork").append("=").append(String.valueOf(parambezy.jdField_g_of_type_JavaLangString));
      localStringBuilder.append(", ").append("startTime").append("=").append(String.valueOf(parambezy.jdField_b_of_type_Long));
      localStringBuilder.append(", ").append("downloadTime").append("=").append(String.valueOf(parambezy.jdField_c_of_type_Long));
      localStringBuilder.append(", ").append("downloadSize").append("=").append(String.valueOf(parambezy.jdField_d_of_type_Long));
      localStringBuilder.append(", ").append("businessPriority").append("=").append(String.valueOf(parambezy.jdField_c_of_type_Int));
      localStringBuilder.append(", ").append("innerPriority").append("=").append(String.valueOf(parambezy.jdField_d_of_type_Int));
      localStringBuilder.append(", ").append("state").append("=").append(String.valueOf(parambezy.jdField_e_of_type_Int));
      localStringBuilder.append(", ").append("reqCondition").append("=").append(String.valueOf(parambezy.jdField_f_of_type_Int));
      localStringBuilder.append(", ").append("startCondition").append("=").append(String.valueOf(parambezy.jdField_g_of_type_Int));
      localStringBuilder.append(", ").append("saveOnSD").append("=").append(String.valueOf(parambezy.jdField_a_of_type_Boolean));
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
    bdmc.a(BaseApplicationImpl.getApplication()).a(null, "PreDownloadReport", true, 0L, 0L, localHashMap, null);
  }
  
  private void d()
  {
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "startPreDownload mBeReady set true, all pre download will start ");
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    int i = localSharedPreferences.getInt("sp_key_pre_download_version", 0);
    if (i != 0)
    {
      ArrayList localArrayList = bezv.a(i, 0);
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        i = 0;
        while (i < localArrayList.size())
        {
          if (QLog.isColorLevel()) {
            QLog.e("PreDownloadScheduler", 1, "[onVersionUpdate PreDownloadScheduler]  delete file: " + (String)localArrayList.get(i));
          }
          bhmi.a((String)localArrayList.get(i), false);
          i += 1;
        }
      }
    }
    localSharedPreferences.edit().putInt("sp_key_pre_download_version", 0).commit();
    e();
    g();
  }
  
  private void d(Message paramMessage)
  {
    int j = 0;
    bezy localbezy1 = (bezy)paramMessage.obj;
    int i;
    label138:
    int k;
    if (this.jdField_g_of_type_Boolean)
    {
      paramMessage = this.jdField_a_of_type_JavaLangObject;
      i = 0;
      bezy localbezy3;
      try
      {
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label332;
        }
        localbezy3 = (bezy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (!localbezy1.jdField_e_of_type_JavaLangString.equals(localbezy3.jdField_e_of_type_JavaLangString)) {
          break label337;
        }
        if ((!localbezy1.jdField_e_of_type_JavaLangString.contains("doodle")) || (localbezy1.jdField_f_of_type_JavaLangString == null) || (localbezy1.jdField_f_of_type_JavaLangString.equals(localbezy3.jdField_f_of_type_JavaLangString))) {
          break label344;
        }
        if (!QLog.isColorLevel()) {
          break label337;
        }
        QLog.d("PreDownloadScheduler", 2, new Object[] { "mPendingList, same url, filePath diff, ", localbezy1.jdField_e_of_type_JavaLangString });
      }
      finally {}
      k = i;
      if (j < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localbezy3 = (bezy)this.jdField_b_of_type_JavaUtilArrayList.get(j);
        if (!localbezy1.jdField_e_of_type_JavaLangString.equals(localbezy3.jdField_e_of_type_JavaLangString)) {
          break label349;
        }
        if ((!localbezy1.jdField_e_of_type_JavaLangString.contains("doodle")) || (localbezy1.jdField_f_of_type_JavaLangString == null) || (localbezy1.jdField_f_of_type_JavaLangString.equals(localbezy3.jdField_f_of_type_JavaLangString))) {
          break label356;
        }
        if (!QLog.isColorLevel()) {
          break label349;
        }
        QLog.d("PreDownloadScheduler", 2, new Object[] { "downloadUrl, same url, filePath diff, ", localbezy1.jdField_e_of_type_JavaLangString });
        break label349;
      }
    }
    for (;;)
    {
      if (k == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(localbezy1);
      }
      for (;;)
      {
        e();
        g();
        if (QLog.isColorLevel()) {
          QLog.e("PreDownloadScheduler", 1, " [msg request add to list]  mPendingList size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        return;
        b(localbezy2);
      }
      label332:
      i = 0;
      break label138;
      label337:
      i += 1;
      break;
      label344:
      i = 1;
      break label138;
      label349:
      j += 1;
      break label138;
      label356:
      k = 1;
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Bezy != null) && (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Bezy.jdField_b_of_type_Long) >= 60000L)) {
      this.jdField_a_of_type_Bezy = null;
    }
    int j;
    int k;
    if ((a()) && (this.jdField_a_of_type_Bezy == null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Bfab);
      j = a();
      k = nny.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      if (k != 0) {
        break label104;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, " [no network] donot start any task! ");
      }
    }
    return;
    for (;;)
    {
      label104:
      int i;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        f();
        i = 0;
        if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
          break;
        }
        bezy localbezy1 = (bezy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localbezy1 != null) && (localbezy1.jdField_f_of_type_Int == 1) && (j == 1))
        {
          a(localbezy1);
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          return;
        }
      }
      if ((localbezy2 != null) && (((localbezy2.jdField_f_of_type_Int == 2) && (!this.jdField_b_of_type_Boolean)) || ((localbezy2.jdField_b_of_type_Int == 1) && (k > 1)) || ((k > 1) && (k < localbezy2.jdField_b_of_type_Int)) || ((localbezy2.jdField_f_of_type_Int == 3) && (!this.jdField_c_of_type_Boolean))))
      {
        a(k, localbezy2);
        i += 1;
      }
      else
      {
        this.jdField_a_of_type_Bezy = ((bezy)this.jdField_a_of_type_JavaUtilArrayList.remove(i));
      }
    }
    if ((this.jdField_a_of_type_Bezy != null) && (this.jdField_a_of_type_Bezy.jdField_a_of_type_Bezs != null))
    {
      if (this.jdField_e_of_type_Long == 0L) {
        this.jdField_e_of_type_Long = System.currentTimeMillis();
      }
      this.jdField_a_of_type_Bezy.jdField_g_of_type_Int = j;
      this.jdField_a_of_type_Bezy.jdField_b_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Bezy.jdField_g_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_Bezy.jdField_e_of_type_Int = 1;
      this.jdField_a_of_type_Bezy.jdField_a_of_type_Bezs.start();
      this.jdField_b_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_Bezy);
      a("[start downloading] begin task :", this.jdField_a_of_type_Bezy);
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_Bezy = null;
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("pending task id:");
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        bezy localbezy = (bezy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (localbezy != null) {
          localStringBuilder.append(localbezy.jdField_a_of_type_Int).append(",");
        }
        i += 1;
      }
      QLog.d("PreDownloadScheduler", 2, localStringBuilder.toString());
    }
  }
  
  private void g()
  {
    if (this.h)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
      {
        bhgt.a().b(this.jdField_a_of_type_Bhgv);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback disabled],there is no pending task!");
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        bhgt.a().a(this.jdField_a_of_type_Bhgv);
        if (QLog.isColorLevel()) {
          QLog.d("PreDownloadScheduler", 2, "[fps callback enabled],there is pending tasks!");
        }
      }
    }
  }
  
  public bezs a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ cancelPreDownload ] downloadUrl = " + paramString);
    }
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject3 = this.jdField_a_of_type_JavaLangObject;
      i = 0;
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject2 = (bezy)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (paramString.equals(((bezy)localObject2).jdField_e_of_type_JavaLangString)) {
            localObject1 = ((bezy)localObject2).jdField_a_of_type_Bezs;
          }
        }
        else
        {
          localObject2 = new Message();
          ((Message)localObject2).what = 1003;
          ((Message)localObject2).obj = paramString;
          this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject2);
          return localObject1;
        }
      }
      finally {}
      i += 1;
    }
  }
  
  public void a()
  {
    this.jdField_f_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ startPreDownload ] enable time = " + this.jdField_f_of_type_Long);
    }
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1001, 10000L);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
  }
  
  public void a(bezs parambezs)
  {
    Message localMessage = new Message();
    localMessage.what = 1006;
    localMessage.obj = parambezs;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_JavaLangString = (BaseApplicationImpl.getContext().getFilesDir() + "/pddata/");
    paramQQAppInterface = new File(this.jdField_b_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.jdField_c_of_type_JavaLangString = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/tencent/MobileQQ/pddata/");
    this.jdField_c_of_type_JavaLangString = bigv.a(this.jdField_c_of_type_JavaLangString);
    paramQQAppInterface = new File(this.jdField_c_of_type_JavaLangString);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    this.jdField_g_of_type_Long = 6L;
    this.jdField_c_of_type_Double = 30.0D;
    this.jdField_d_of_type_Double = 50.0D;
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences("sp_pre_downlaod", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("sp_key_pre_sample_mark", false);
    QLog.e("PreDownloadScheduler", 1, " pre download bSampledLastTime = " + bool2);
    double d1 = Math.random();
    boolean bool1;
    if (9.999999747378752E-006D >= d1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      QLog.e("PreDownloadScheduler", 1, " pre download random = " + d1);
      if (!bool2) {
        break label329;
      }
      this.jdField_a_of_type_Boolean = true;
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", false).commit();
      QLog.e("PreDownloadScheduler", 1, " pre download last time sampled, also sampled this time");
    }
    for (;;)
    {
      QLog.e("PreDownloadScheduler", 1, " pre download set mNeedReport = " + this.jdField_a_of_type_Boolean);
      return;
      bool1 = false;
      break;
      label329:
      paramQQAppInterface.edit().putBoolean("sp_key_pre_sample_mark", this.jdField_a_of_type_Boolean).commit();
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ preDownloadSuccess ] downloadUrl = " + paramString + ",size = " + paramLong);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_d_of_type_Long = paramLong;
    Message localMessage = new Message();
    localMessage.what = 1004;
    localMessage.obj = paramString;
    localMessage.arg1 = ((int)paramLong);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_d_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreDownloadScheduler", 2, "[System busy] dowload not ready!");
      }
      if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (Math.abs(System.currentTimeMillis() - this.jdField_f_of_type_Long) >= 60000L) && (this.jdField_e_of_type_Long == 0L))
      {
        this.jdField_g_of_type_Long -= 2L;
        this.jdField_d_of_type_Double += 10.0D;
        this.jdField_c_of_type_Double -= 10.0D;
        this.jdField_e_of_type_Boolean = true;
        this.jdField_f_of_type_Boolean = true;
        this.jdField_d_of_type_Boolean = true;
        QLog.d("PreDownloadScheduler", 2, "[System busy] for 60 seconds after pull msg, set download enable");
        QLog.d("PreDownloadScheduler", 2, "mCPUThreshold = " + this.jdField_d_of_type_Double + ",mFPSThreshold=" + this.jdField_c_of_type_Double);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, bezs parambezs)
  {
    if ((bdho.jdField_e_of_type_Boolean) && (!bdho.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt1))) && (!bezx.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt1))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Perf", 2, "delay pre_download,busindessID:" + paramInt1);
      }
      bdho.jdField_f_of_type_Long = System.currentTimeMillis();
      return false;
    }
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString3)) || (parambezs == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "requestPreDownload param error! busindessID=0 or downloadUrl is empty or task is empty\n");
      }
      return false;
    }
    String str1 = (String)bezx.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define name in PreDownloadConstants.BUSINESS_NAME for business");
      }
      return false;
    }
    String str2 = (String)bezx.b.get(Integer.valueOf(paramInt1));
    if (TextUtils.isEmpty(str2))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define english name in PreDownloadConstants.BUSINESS_NAME_ENG for business");
      }
      return false;
    }
    Object localObject = (Integer)bezx.c.get(Integer.valueOf(paramInt1));
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, "Should define priority in PreDownloadConstants.BUSINESS_PRIORITY for business");
      }
      return false;
    }
    int i = ((Integer)localObject).intValue();
    if ((i < 0) || (i > 4))
    {
      if (QLog.isColorLevel()) {
        QLog.e("PreDownloadScheduler", 1, " requestPreDownload param priority error,priority value should be in[0,1,2,3,4]!");
      }
      return false;
    }
    localObject = new bezy();
    ((bezy)localObject).jdField_a_of_type_Int = paramInt1;
    ((bezy)localObject).jdField_a_of_type_JavaLangString = str1;
    ((bezy)localObject).jdField_b_of_type_JavaLangString = str2;
    ((bezy)localObject).jdField_c_of_type_JavaLangString = paramString1;
    ((bezy)localObject).jdField_d_of_type_JavaLangString = paramString2;
    ((bezy)localObject).jdField_e_of_type_JavaLangString = paramString3;
    ((bezy)localObject).jdField_b_of_type_Int = paramInt3;
    ((bezy)localObject).jdField_d_of_type_Int = paramInt2;
    ((bezy)localObject).jdField_f_of_type_JavaLangString = paramString4;
    ((bezy)localObject).jdField_e_of_type_Int = 0;
    ((bezy)localObject).jdField_a_of_type_Long = System.currentTimeMillis();
    ((bezy)localObject).jdField_c_of_type_Int = i;
    ((bezy)localObject).jdField_f_of_type_Int = paramInt4;
    ((bezy)localObject).jdField_a_of_type_Boolean = paramBoolean;
    ((bezy)localObject).jdField_a_of_type_Bezs = parambezs;
    paramString1 = new Message();
    paramString1.what = 1002;
    paramString1.obj = localObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ requestPreDownload ]  downloadUrl = " + paramString3);
    }
    return a();
  }
  
  public void b()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppForground ] mAppBackground = " + this.jdField_b_of_type_Boolean);
    }
    Message localMessage = new Message();
    localMessage.what = 1008;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[setEnable] enable = " + this.jdField_g_of_type_Boolean);
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.e("PreDownloadScheduler", 1, "[ onAppBackground ] mAppBackground = " + this.jdField_b_of_type_Boolean);
    }
    Message localMessage = new Message();
    localMessage.what = 1009;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      d();
      continue;
      d(paramMessage);
      continue;
      c(paramMessage);
      continue;
      b(paramMessage);
      continue;
      e();
      g();
      continue;
      paramMessage = (Bundle)paramMessage.obj;
      a(paramMessage.getDouble("FPS"), paramMessage.getDouble("CPU"), this.jdField_a_of_type_JavaLangString, this.jdField_d_of_type_Long);
      continue;
      a(paramMessage);
      continue;
      e();
    }
  }
  
  public void onDestroy()
  {
    if (this.h) {
      bhgt.a().b(this.jdField_a_of_type_Bhgv);
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(Boolean.valueOf(true));
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.removeAll(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.removeAll(this.jdField_b_of_type_JavaUtilArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bezz
 * JD-Core Version:    0.7.0.1
 */