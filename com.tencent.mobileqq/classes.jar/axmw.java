import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class axmw
  implements axmz
{
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private axnc jdField_a_of_type_Axnc;
  private axng jdField_a_of_type_Axng;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  private int a(String paramString, axnd paramaxnd)
  {
    int i = 0;
    if (!new File(paramString).exists()) {
      i = 5;
    }
    while (paramaxnd.jdField_a_of_type_Axna.jdField_a_of_type_Boolean) {
      return i;
    }
    try
    {
      System.load(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramaxnd.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
      return 0;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return 6;
  }
  
  private String a()
  {
    if (axnh.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  private String a(axnd paramaxnd)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).getString("key_last_succ_" + paramaxnd.jdField_a_of_type_JavaLangString + a(), "");
      return "";
    }
    catch (Throwable paramaxnd)
    {
      for (;;)
      {
        paramaxnd.printStackTrace();
      }
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
  
  private void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.c = true;
    VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, "ver=" + this.jdField_a_of_type_JavaLangString, "load.item.load", ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, paramInt, paramString);
    paramString = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_Boolean, this.b, ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    axqy.b(null, "dc00899", "SoLoad", "", "resSingle", ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, 0, paramInt, this.jdField_a_of_type_JavaLangString, "", "", "");
    if (this.jdField_a_of_type_Axng != null) {
      this.jdField_a_of_type_Axng.onLoadResult(paramInt, paramString);
    }
  }
  
  private void a(axnd paramaxnd, SoConfig.SoInfo paramSoInfo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + axnh.a());
    }
    if (paramSoInfo != null) {
      if (axnh.a()) {
        paramSoInfo = paramSoInfo.arm64Info;
      }
    }
    for (;;)
    {
      if ((paramSoInfo != null) && (!TextUtils.isEmpty(paramSoInfo.url)))
      {
        bool = true;
        label76:
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] isConfigValid=" + bool);
        }
        if (bool) {
          break label146;
        }
        if (!a(paramaxnd)) {
          break label141;
        }
      }
      for (;;)
      {
        a(i);
        return;
        paramSoInfo = paramSoInfo.arm32Info;
        break;
        bool = false;
        break label76;
        label141:
        i = 2;
      }
      label146:
      this.jdField_a_of_type_JavaLangString = paramSoInfo.ver;
      DownloadParam localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 1;
      localDownloadParam.url = paramSoInfo.url;
      localDownloadParam.md5ForChecked = paramSoInfo.md5;
      paramSoInfo = PreloadManager.a(localDownloadParam);
      if ((paramSoInfo != null) && (paramSoInfo.folderPath != null)) {}
      for (paramSoInfo = new File(paramSoInfo.folderPath, paramaxnd.b).getAbsolutePath(); (!TextUtils.isEmpty(paramSoInfo)) && (new File(paramSoInfo).exists()); paramSoInfo = "")
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile exist");
        }
        a(paramSoInfo, paramaxnd);
        return;
      }
      boolean bool = a(paramaxnd);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile not exist - loadOldSoSucc=" + bool);
      }
      if (bool)
      {
        a(0);
        PreloadManager.a().a(localDownloadParam, null);
        return;
      }
      VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, null, "load.item.download.start", null, 0, null);
      PreloadManager.a().a(localDownloadParam, new axmy(this, paramaxnd));
      return;
      paramSoInfo = null;
    }
  }
  
  private void a(axnd paramaxnd, String paramString)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).edit().putString("key_last_succ_" + paramaxnd.jdField_a_of_type_JavaLangString + a(), paramString).apply();
      return;
    }
    catch (Throwable paramaxnd)
    {
      paramaxnd.printStackTrace();
    }
  }
  
  private void a(String paramString, axnd paramaxnd)
  {
    int i = a(paramString, paramaxnd);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString);
    }
    if (i == 0)
    {
      a(i);
      a(paramaxnd, paramString);
      return;
    }
    if (b(paramaxnd))
    {
      a(0);
      return;
    }
    a(i);
  }
  
  private boolean a(axnd paramaxnd)
  {
    String str = paramaxnd.jdField_a_of_type_Axna.a();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, paramaxnd);
      VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private static int b()
  {
    QQAppInterface localQQAppInterface = ahiw.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return ampl.a().a(526, localQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean b(axnd paramaxnd)
  {
    if (paramaxnd.jdField_a_of_type_Axna.b)
    {
      String str = a(paramaxnd);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramaxnd);
        VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  public void a(axnc paramaxnc, axng paramaxng)
  {
    this.jdField_a_of_type_Axnc = paramaxnc;
    this.jdField_a_of_type_Axng = paramaxng;
    paramaxnc = (axnd)paramaxnc.jdField_a_of_type_JavaUtilList.get(0);
    VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, null, "load.item.start", paramaxnc.jdField_a_of_type_JavaLangString, 0, null);
    if (jdField_a_of_type_JavaUtilHashMap.keySet().contains(paramaxnc.jdField_a_of_type_JavaLangString))
    {
      this.b = false;
      this.jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_JavaUtilHashMap.get(paramaxnc.jdField_a_of_type_JavaLangString));
      a(0);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Axnc.jdField_a_of_type_Long, null, "load.item.getconfig.start", paramaxnc.jdField_a_of_type_JavaLangString, 0, null);
    axnl.a().a(paramaxnc.jdField_a_of_type_JavaLangString, new axmx(this, paramaxnc));
  }
  
  public void a(String paramString)
  {
    if (!this.c)
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a("ver=" + this.jdField_a_of_type_JavaLangString, "SoLoadModule", "SoLoadSingle", "Exception", ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str1 = ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
    String str2 = ((axnd)this.jdField_a_of_type_Axnc.jdField_a_of_type_JavaUtilList.get(0)).b;
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramString.contains(str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmw
 * JD-Core Version:    0.7.0.1
 */