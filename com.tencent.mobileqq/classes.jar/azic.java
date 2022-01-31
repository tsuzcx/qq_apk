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

public class azic
  implements azig
{
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, azif> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private azij jdField_a_of_type_Azij;
  private azik jdField_a_of_type_Azik;
  private azin jdField_a_of_type_Azin;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  
  private int a(String paramString, azik paramazik)
  {
    int i = 0;
    if (!new File(paramString).exists()) {
      i = 5;
    }
    while (paramazik.jdField_a_of_type_Azih.jdField_a_of_type_Boolean) {
      return i;
    }
    try
    {
      System.load(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramazik.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_JavaLangString = paramString;
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("SoLoadWidget.DownSoLoader", 1, paramString, new Object[0]);
      this.jdField_c_of_type_JavaLangString = ajaf.a(paramString);
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
  
  private azja a(azik paramazik, SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    Object localObject = a(paramazik, paramSoDetailInfo.url);
    String str = ((azja)localObject).jdField_c_of_type_JavaLangString;
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      localObject = new DownloadParam();
      ((DownloadParam)localObject).filePos = 1;
      ((DownloadParam)localObject).url = paramSoDetailInfo.url;
      ((DownloadParam)localObject).md5ForChecked = paramSoDetailInfo.md5;
      paramSoDetailInfo = PreloadManager.a((DownloadParam)localObject);
      if ((paramSoDetailInfo != null) && (paramSoDetailInfo.folderPath != null))
      {
        paramazik = new File(paramSoDetailInfo.folderPath, paramazik.jdField_b_of_type_JavaLangString).getAbsolutePath();
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[getLocalInfoFromCacheOrConfig] return info from sync method");
        }
        paramazik = new azja(paramazik);
      }
    }
    do
    {
      return paramazik;
      paramazik = "";
      break;
      paramazik = (azik)localObject;
    } while (!QLog.isColorLevel());
    QLog.i("SoLoadWidget.DownSoLoader", 2, "[getLocalInfoFromCacheOrConfig] return info from cache");
    return localObject;
  }
  
  private azja a(azik paramazik, String paramString)
  {
    try
    {
      paramazik = azja.a(a().getString(a(paramazik), ""));
      boolean bool = TextUtils.equals(paramString, paramazik.d);
      if (bool) {
        return paramazik;
      }
    }
    catch (Throwable paramazik)
    {
      QLog.e("SoLoadWidget.DownSoLoader", 1, paramazik, new Object[0]);
    }
    return new azja();
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
    VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, "ver=" + this.jdField_a_of_type_JavaLangString, "load.item.load", this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, paramInt, paramString);
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
    if ((paramInt != 0) && (this.jdField_a_of_type_Azij.d == azij.c))
    {
      azif localazif = (azif)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString);
      paramString = localazif;
      if (localazif == null) {
        paramString = new azif();
      }
      boolean bool = bdee.d(BaseApplicationImpl.getApplication());
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      int j = bdee.a(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[onLoadResult]AsyncFailInfo:" + paramString + ",name:" + this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString + ",isNetSupport:" + bool + ",curTime=" + l3 + ",netType=" + j);
      }
      if (bool)
      {
        paramString.jdField_a_of_type_Int = paramInt;
        paramString.c = j;
        paramString.jdField_a_of_type_Long = l3;
        paramString.b = this.jdField_a_of_type_Int;
        jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, paramString);
      }
    }
    if (this.jdField_a_of_type_Azij.d == azij.b) {
      localLoadExtResult.failInfo = ((azif)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString));
    }
    if (this.jdField_a_of_type_Azin != null) {
      this.jdField_a_of_type_Azin.a(paramInt, localLoadExtResult);
    }
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      azmj.b(null, "dc00899", "SoLoad", "", "resSingle", this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Azij.d, paramInt, this.jdField_a_of_type_JavaLangString, i + "", l1 - l2 + "", "");
      return localLoadExtResult;
      if (this.jdField_b_of_type_Boolean) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  private LoadExtResult a(azik paramazik, SoConfig.SoInfo paramSoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + azio.a());
    }
    SoConfig.SoInfo localSoInfo = null;
    if (paramSoInfo != null)
    {
      if (azio.a())
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
      if (!a(paramazik)) {
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
        if ((TextUtils.equals("TcHevcDec", paramazik.jdField_a_of_type_JavaLangString)) && (a(paramazik, localSoInfo.url).jdField_a_of_type_Long == -1L))
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
    paramSoInfo = a(paramazik, localSoInfo);
    String str = paramSoInfo.jdField_c_of_type_JavaLangString;
    long l = paramSoInfo.jdField_a_of_type_Long;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile exist");
      }
      if (a(str, l, paramazik, localSoInfo, 1)) {
        return a(str, paramazik, localSoInfo.url);
      }
      return a(10);
    }
    boolean bool = a(paramazik);
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
    VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, null, "load.item.download.start", null, 0, null);
    if (this.jdField_a_of_type_Azij.d == azij.b) {
      return a(3);
    }
    if (this.jdField_a_of_type_Azij.d == azij.c) {
      paramSoInfo.isPreDownload = true;
    }
    PreloadManager.a().a(paramSoInfo, new azie(this, paramazik, localSoInfo, paramSoInfo));
    return null;
  }
  
  private LoadExtResult a(String paramString1, azik paramazik, String paramString2)
  {
    int i = a(paramString1, paramazik);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString1);
    }
    if (i == 0)
    {
      a(paramazik, paramString1);
      a(paramazik, this.jdField_a_of_type_JavaLangString, paramString1, paramString2);
      return a(i);
    }
    if (b(paramazik)) {
      return a(0);
    }
    return a(i);
  }
  
  private String a()
  {
    if (azio.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  private String a(azik paramazik)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("key_local_info_").append(paramazik.jdField_a_of_type_JavaLangString);
    if (!azio.a()) {}
    for (paramazik = "_32";; paramazik = "_64") {
      return paramazik;
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
  
  private void a(azik paramazik)
  {
    SharedPreferences localSharedPreferences = a();
    paramazik = a(paramazik);
    localSharedPreferences.edit().remove(paramazik).apply();
  }
  
  private void a(azik paramazik, String paramString)
  {
    try
    {
      a().edit().putString("key_last_succ_" + paramazik.jdField_a_of_type_JavaLangString + a(), paramString).apply();
      return;
    }
    catch (Throwable paramazik)
    {
      paramazik.printStackTrace();
    }
  }
  
  private void a(azik paramazik, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      SharedPreferences localSharedPreferences = a();
      String str = a(paramazik);
      azja localazja = a(paramazik, paramString3);
      if ((TextUtils.equals(localazja.jdField_c_of_type_JavaLangString, paramString2)) && (localazja.jdField_a_of_type_Long != -1L)) {
        return;
      }
      long l = IOUtil.getCRC32Value(new File(paramString2));
      paramazik = new azja(paramString1, paramazik.jdField_a_of_type_JavaLangString, paramString2, l, paramString3);
      localSharedPreferences.edit().putString(str, paramazik.a()).commit();
      return;
    }
    catch (Throwable paramazik)
    {
      paramazik.printStackTrace();
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    if (jdField_a_of_type_JavaUtilHashMap.keySet().contains(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString));
      bool = true;
    }
    return bool;
  }
  
  private boolean a(azik paramazik)
  {
    String str = paramazik.jdField_a_of_type_Azih.a();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, paramazik);
      VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private boolean a(String paramString, long paramLong, azik paramazik, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
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
      a(paramazik);
      ajaf.a(paramString);
      paramString = new DownloadParam();
      paramString.filePos = 1;
      paramString.url = paramSoDetailInfo.url;
      paramString.md5ForChecked = paramSoDetailInfo.md5;
      PreloadManager.PathResult localPathResult = PreloadManager.a(paramString);
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.folderPath))) {
        break label387;
      }
      paramString = new File(localPathResult.folderPath, paramazik.jdField_b_of_type_JavaLangString).getAbsolutePath();
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
      VACDReportUtil.a(paramazik.jdField_a_of_type_JavaLangString + "_" + this.jdField_a_of_type_JavaLangString, "qqwallet", "SoLoadCRC", l2 + "_" + l1 + "_" + bool3 + "_" + paramLong + "_" + bool2 + "_" + paramString, null, paramInt, null);
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
    QQAppInterface localQQAppInterface = ajaf.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return aogj.a().a(526, localQQAppInterface.getCurrentAccountUin());
  }
  
  private String b(azik paramazik)
  {
    try
    {
      paramazik = a().getString("key_last_succ_" + paramazik.jdField_a_of_type_JavaLangString + a(), "");
      return paramazik;
    }
    catch (Throwable paramazik)
    {
      paramazik.printStackTrace();
    }
    return "";
  }
  
  private void b(azij paramazij, azin paramazin)
  {
    this.jdField_a_of_type_Azij = paramazij;
    this.jdField_a_of_type_Azin = paramazin;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_Azik = ((azik)paramazij.jdField_a_of_type_JavaUtilList.get(0));
    VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, null, "load.item.start", this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, 0, null);
  }
  
  private boolean b(azik paramazik)
  {
    if (paramazik.jdField_a_of_type_Azih.jdField_b_of_type_Boolean)
    {
      String str = b(paramazik);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramazik);
        VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  public LoadExtResult a(azij paramazij)
  {
    int i = 0;
    b(paramazij, null);
    if (a()) {
      return a(0);
    }
    paramazij = azit.a().a(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, null, paramazij.d);
    long l = this.jdField_a_of_type_Azij.jdField_a_of_type_Long;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (azio.a()) {
      i = 1;
    }
    VACDReportUtil.a(l, null, "load.item.getconfig.end", i + "&v=" + b() + "&f=" + this.jdField_a_of_type_Azij.d, SoConfig.SoInfo.getReportCode(paramazij), null);
    return a(this.jdField_a_of_type_Azik, paramazij);
  }
  
  public void a(azij paramazij, azin paramazin)
  {
    b(paramazij, paramazin);
    if (a())
    {
      a(0);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Azij.jdField_a_of_type_Long, null, "load.item.getconfig.start", this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, 0, null);
    azit.a().a(this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, new azid(this), this.jdField_a_of_type_Azij.d);
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Azij.d != azij.b))
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a("ver=" + this.jdField_a_of_type_JavaLangString, "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = this.jdField_a_of_type_Azik.jdField_a_of_type_JavaLangString;
      str2 = this.jdField_a_of_type_Azik.jdField_b_of_type_JavaLangString;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!paramString.contains(str2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azic
 * JD-Core Version:    0.7.0.1
 */