import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class azml
  implements azmp
{
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, azmo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private azms jdField_a_of_type_Azms;
  private azmt jdField_a_of_type_Azmt;
  private azmw jdField_a_of_type_Azmw;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private int a(String paramString, azmt paramazmt)
  {
    int i = 0;
    if (!new File(paramString).exists()) {
      i = 5;
    }
    while (paramazmt.jdField_a_of_type_Azmq.jdField_a_of_type_Boolean) {
      return i;
    }
    try
    {
      System.load(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramazmt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = paramString;
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.DownSoLoader", 1, paramString, new Object[0]);
      this.jdField_c_of_type_JavaLangString = ajeu.a(paramString);
    }
    return 6;
  }
  
  private SharedPreferences a()
  {
    if (this.jdField_a_of_type_AndroidContentSharedPreferences == null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 4);
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  private aznj a(azmt paramazmt, SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    Object localObject = a(paramazmt, paramSoDetailInfo.url);
    String str = ((aznj)localObject).jdField_c_of_type_JavaLangString;
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).filePos = 1;
      ((DownloadParam)localObject).url = paramSoDetailInfo.url;
      ((DownloadParam)localObject).md5ForChecked = paramSoDetailInfo.md5;
      paramSoDetailInfo = PreloadManager.a((DownloadParam)localObject);
      if ((paramSoDetailInfo != null) && (paramSoDetailInfo.folderPath != null))
      {
        paramazmt = new File(paramSoDetailInfo.folderPath, paramazmt.jdField_b_of_type_JavaLangString).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[getLocalInfoFromCacheOrConfig] return info from sync method");
        }
        paramazmt = new aznj(paramazmt);
      }
    }
    do
    {
      return paramazmt;
      paramazmt = "";
      break;
      paramazmt = (azmt)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("SoLoadWidget.DownSoLoader", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
    return localObject;
  }
  
  private aznj a(azmt paramazmt, String paramString)
  {
    try
    {
      paramazmt = aznj.a(a().getString(a(paramazmt), ""));
      boolean bool = TextUtils.equals(paramString, paramazmt.d);
      if (bool) {
        return paramazmt;
      }
    }
    catch (Throwable paramazmt)
    {
      QLog.e("SoLoadWidget.DownSoLoader", 1, paramazmt, new Object[0]);
    }
    return new aznj();
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str = null;
    if (paramInt == 6) {
      str = this.jdField_c_of_type_JavaLangString;
    }
    return a(paramInt, str);
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    int i = 1;
    this.jdField_c_of_type_Boolean = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, "ver=" + this.jdField_a_of_type_JavaLangString, "load.item.load", this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, paramInt, paramString);
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((paramInt != 0) && (this.jdField_a_of_type_Azms.d == azms.c))
    {
      azmo localazmo = (azmo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString);
      paramString = localazmo;
      if (localazmo == null) {
        paramString = new azmo();
      }
      boolean bool = bdin.d(BaseApplicationImpl.getApplication());
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      int j = bdin.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[onLoadResult]AsyncFailInfo:" + paramString + ",name:" + this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString + ",isNetSupport:" + bool + ",curTime=" + l3 + ",netType=" + j);
      }
      if (bool)
      {
        paramString.jdField_a_of_type_Int = paramInt;
        paramString.c = j;
        paramString.jdField_a_of_type_Long = l3;
        paramString.b = this.jdField_a_of_type_Int;
        jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, paramString);
      }
    }
    if (this.jdField_a_of_type_Azms.d == azms.b) {
      localLoadExtResult.failInfo = ((azmo)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Azmw != null) {
      this.jdField_a_of_type_Azmw.a(paramInt, localLoadExtResult);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      azqs.b(null, "dc00899", "SoLoad", "", "resSingle", this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azms.d, paramInt, this.jdField_a_of_type_JavaLangString, i + "", l1 - l2 + "", "");
      return localLoadExtResult;
      if (this.jdField_b_of_type_Boolean) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  private LoadExtResult a(azmt paramazmt, SoConfig.SoInfo paramSoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + azmx.a());
    }
    SoConfig.SoInfo localSoInfo = null;
    if (paramSoInfo != null)
    {
      if (azmx.a())
      {
        paramSoInfo = paramSoInfo.arm64Info;
        localSoInfo = paramSoInfo;
      }
    }
    else
    {
      if ((localSoInfo == null) || (TextUtils.isEmpty(localSoInfo.url))) {
        break label146;
      }
      bool = true;
      label84:
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] isConfigValid=" + bool);
      }
      if (bool) {
        break label157;
      }
      if (!a(paramazmt)) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = 0;; i = 2)
    {
      return a(i);
      paramSoInfo = paramSoInfo.arm32Info;
      break;
      bool = false;
      break label84;
    }
    label157:
    this.jdField_a_of_type_JavaLangString = localSoInfo.ver;
    if (((Build.VERSION.SDK_INT == 22) || (Build.VERSION.SDK_INT == 21)) && (!(BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface))) {
      try
      {
        if ((TextUtils.equals("TcHevcDec", paramazmt.jdField_a_of_type_JavaLangString)) && (a(paramazmt, localSoInfo.url).jdField_a_of_type_Long == -1L))
        {
          paramSoInfo = a(3);
          return paramSoInfo;
        }
      }
      catch (Throwable paramSoInfo)
      {
        QLog.e("SoLoadWidget.DownSoLoader", 1, paramSoInfo, new Object[0]);
      }
    }
    paramSoInfo = a(paramazmt, localSoInfo);
    String str = paramSoInfo.jdField_c_of_type_JavaLangString;
    long l = paramSoInfo.jdField_a_of_type_Long;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile exist");
      }
      if (a(str, l, paramazmt, localSoInfo, 1)) {
        return a(str, paramazmt, localSoInfo.url);
      }
      return a(10);
    }
    boolean bool = a(paramazmt);
    paramSoInfo = new DownloadParam();
    paramSoInfo.filePos = 1;
    paramSoInfo.url = localSoInfo.url;
    paramSoInfo.md5ForChecked = localSoInfo.md5;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile not exist - loadOldSoSucc=" + bool);
    }
    if (bool)
    {
      PreloadManager.a().a(paramSoInfo, null);
      return a(0);
    }
    VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, null, "load.item.download.start", null, 0, null);
    if (this.jdField_a_of_type_Azms.d == azms.b) {
      return a(3);
    }
    if (this.jdField_a_of_type_Azms.d == azms.c) {
      paramSoInfo.isPreDownload = true;
    }
    PreloadManager.a().a(paramSoInfo, new azmn(this, paramazmt, localSoInfo, paramSoInfo));
    return null;
  }
  
  private LoadExtResult a(String paramString1, azmt paramazmt, String paramString2)
  {
    int i = a(paramString1, paramazmt);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString1);
    }
    if (i == 0)
    {
      a(paramazmt, paramString1);
      a(paramazmt, this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      return a(i);
    }
    if (b(paramazmt)) {
      return a(0);
    }
    return a(i);
  }
  
  private String a()
  {
    if (azmx.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  private String a(azmt paramazmt)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_local_info_").append(paramazmt.jdField_a_of_type_JavaLangString);
    if (!azmx.a()) {}
    for (paramazmt = "_32";; paramazmt = "_64") {
      return paramazmt;
    }
  }
  
  public static String a(String paramString)
  {
    return (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
  }
  
  @Deprecated
  public static List<String> a()
  {
    return new LinkedList(jdField_a_of_type_JavaUtilHashMap.keySet());
  }
  
  private void a(azmt paramazmt)
  {
    SharedPreferences localSharedPreferences = a();
    paramazmt = a(paramazmt);
    localSharedPreferences.edit().remove(paramazmt).apply();
  }
  
  private void a(azmt paramazmt, String paramString)
  {
    try
    {
      a().edit().putString("key_last_succ_" + paramazmt.jdField_a_of_type_JavaLangString + a(), paramString).apply();
      return;
    }
    catch (Throwable paramazmt)
    {
      paramazmt.printStackTrace();
    }
  }
  
  private void a(azmt paramazmt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences localSharedPreferences = a();
      String str = a(paramazmt);
      aznj localaznj = a(paramazmt, paramString3);
      if ((TextUtils.equals(localaznj.jdField_c_of_type_JavaLangString, paramString2)) && (localaznj.jdField_a_of_type_Long != -1L)) {
        return;
      }
      long l = IOUtil.getCRC32Value(new File(paramString2));
      paramazmt = new aznj(paramString1, paramazmt.jdField_a_of_type_JavaLangString, paramString2, l, paramString3);
      localSharedPreferences.edit().putString(str, paramazmt.a()).commit();
      return;
    }
    catch (Throwable paramazmt)
    {
      paramazmt.printStackTrace();
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (jdField_a_of_type_JavaUtilHashMap.keySet().contains(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString));
      bool = true;
    }
    return bool;
  }
  
  private boolean a(azmt paramazmt)
  {
    String str = paramazmt.jdField_a_of_type_Azmq.a();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, paramazmt);
      VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private boolean a(String paramString, long paramLong, azmt paramazmt, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLong == -1L) && (paramSoDetailInfo.crc == -1L)) {
      return true;
    }
    long l1;
    boolean bool2;
    long l2;
    label149:
    boolean bool3;
    label165:
    int i;
    boolean bool1;
    if (paramSoDetailInfo.crc != -1L)
    {
      l1 = paramSoDetailInfo.crc;
      bool2 = true;
      l2 = IOUtil.getCRC32Value(new File(paramString));
      if (l1 == l2) {
        break label432;
      }
      a(paramazmt);
      ajeu.a(paramString);
      paramString = new DownloadParam();
      paramString.filePos = 1;
      paramString.url = paramSoDetailInfo.url;
      paramString.md5ForChecked = paramSoDetailInfo.md5;
      PreloadManager.PathResult localPathResult = PreloadManager.a(paramString);
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.folderPath))) {
        break label387;
      }
      paramString = new File(localPathResult.folderPath, paramazmt.jdField_b_of_type_JavaLangString).getAbsolutePath();
      if ((localPathResult == null) || (!localPathResult.retryUnzip())) {
        break label393;
      }
      bool3 = true;
      i = 0;
      if (!bool3) {
        break label414;
      }
      paramLong = IOUtil.getCRC32Value(new File(paramString));
      if (!bool2) {
        break label408;
      }
      if (paramLong != l1) {
        break label399;
      }
      bool1 = true;
      label200:
      if (i == 0) {
        break label434;
      }
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.filePath))) {
        break label427;
      }
      paramString = MD5Coding.encodeFile2HexStr(localPathResult.filePath);
      label230:
      if ((!TextUtils.isEmpty(paramSoDetailInfo.md5)) && (!paramSoDetailInfo.md5.equalsIgnoreCase(paramString))) {
        PreloadManager.a(paramSoDetailInfo.url, false, 1);
      }
    }
    for (;;)
    {
      VACDReportUtil.a(paramazmt.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_JavaLangString, "qqwallet", "SoLoadCRC", l2 + "_" + l1 + "_" + bool3 + "_" + paramLong + "_" + bool2 + "_" + paramString, null, paramInt, null);
      return bool1;
      bool2 = false;
      l1 = paramLong;
      break;
      label387:
      paramString = "";
      break label149;
      label393:
      bool3 = false;
      break label165;
      label399:
      i = 1;
      bool1 = false;
      break label200;
      label408:
      bool1 = true;
      break label200;
      label414:
      i = 1;
      bool1 = false;
      paramLong = -1L;
      break label200;
      label427:
      paramString = null;
      break label230;
      label432:
      return true;
      label434:
      paramString = null;
    }
  }
  
  private static int b()
  {
    QQAppInterface localQQAppInterface = ajeu.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return aoks.a().a(526, localQQAppInterface.getCurrentAccountUin());
  }
  
  private String b(azmt paramazmt)
  {
    try
    {
      paramazmt = a().getString("key_last_succ_" + paramazmt.jdField_a_of_type_JavaLangString + a(), "");
      return paramazmt;
    }
    catch (Throwable paramazmt)
    {
      paramazmt.printStackTrace();
    }
    return "";
  }
  
  private void b(azms paramazms, azmw paramazmw)
  {
    this.jdField_a_of_type_Azms = paramazms;
    this.jdField_a_of_type_Azmw = paramazmw;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Azmt = ((azmt)paramazms.jdField_a_of_type_JavaUtilList.get(0));
    VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, null, "load.item.start", this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, 0, null);
  }
  
  private boolean b(azmt paramazmt)
  {
    if (paramazmt.jdField_a_of_type_Azmq.jdField_b_of_type_Boolean)
    {
      String str = b(paramazmt);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramazmt);
        VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  public LoadExtResult a(azms paramazms)
  {
    int i = 0;
    b(paramazms, null);
    if (a()) {
      return a(0);
    }
    paramazms = aznc.a().a(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, null, paramazms.d);
    long l = this.jdField_a_of_type_Azms.jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (azmx.a()) {
      i = 1;
    }
    VACDReportUtil.a(l, null, "load.item.getconfig.end", i + "&v=" + b() + "&f=" + this.jdField_a_of_type_Azms.d, SoConfig.SoInfo.getReportCode(paramazms), null);
    return a(this.jdField_a_of_type_Azmt, paramazms);
  }
  
  public void a(azms paramazms, azmw paramazmw)
  {
    b(paramazms, paramazmw);
    if (a())
    {
      a(0);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Azms.jdField_a_of_type_Long, null, "load.item.getconfig.start", this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, 0, null);
    aznc.a().a(this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, new azmm(this), this.jdField_a_of_type_Azms.d);
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Azms.d != azms.b))
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a("ver=" + this.jdField_a_of_type_JavaLangString, "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = this.jdField_a_of_type_Azmt.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_Azmt.jdField_b_of_type_JavaLangString;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!paramString.contains(str2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azml
 * JD-Core Version:    0.7.0.1
 */