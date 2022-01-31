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

public class axmu
  implements axmx
{
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private axna jdField_a_of_type_Axna;
  private axne jdField_a_of_type_Axne;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  private int a(String paramString, axnb paramaxnb)
  {
    int i = 0;
    if (!new File(paramString).exists()) {
      i = 5;
    }
    while (paramaxnb.jdField_a_of_type_Axmy.jdField_a_of_type_Boolean) {
      return i;
    }
    try
    {
      System.load(paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramaxnb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
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
    if (axnf.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  private String a(axnb paramaxnb)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).getString("key_last_succ_" + paramaxnb.jdField_a_of_type_JavaLangString + a(), "");
      return "";
    }
    catch (Throwable paramaxnb)
    {
      for (;;)
      {
        paramaxnb.printStackTrace();
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
    VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, "ver=" + this.jdField_a_of_type_JavaLangString, "load.item.load", ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, paramInt, paramString);
    paramString = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_Boolean, this.b, ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    axqw.b(null, "dc00899", "SoLoad", "", "resSingle", ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, 0, paramInt, this.jdField_a_of_type_JavaLangString, "", "", "");
    if (this.jdField_a_of_type_Axne != null) {
      this.jdField_a_of_type_Axne.onLoadResult(paramInt, paramString);
    }
  }
  
  private void a(axnb paramaxnb, SoConfig.SoInfo paramSoInfo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + axnf.a());
    }
    if (paramSoInfo != null) {
      if (axnf.a()) {
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
        if (!a(paramaxnb)) {
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
      for (paramSoInfo = new File(paramSoInfo.folderPath, paramaxnb.b).getAbsolutePath(); (!TextUtils.isEmpty(paramSoInfo)) && (new File(paramSoInfo).exists()); paramSoInfo = "")
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile exist");
        }
        a(paramSoInfo, paramaxnb);
        return;
      }
      boolean bool = a(paramaxnb);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile not exist - loadOldSoSucc=" + bool);
      }
      if (bool)
      {
        a(0);
        PreloadManager.a().a(localDownloadParam, null);
        return;
      }
      VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, null, "load.item.download.start", null, 0, null);
      PreloadManager.a().a(localDownloadParam, new axmw(this, paramaxnb));
      return;
      paramSoInfo = null;
    }
  }
  
  private void a(axnb paramaxnb, String paramString)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).edit().putString("key_last_succ_" + paramaxnb.jdField_a_of_type_JavaLangString + a(), paramString).apply();
      return;
    }
    catch (Throwable paramaxnb)
    {
      paramaxnb.printStackTrace();
    }
  }
  
  private void a(String paramString, axnb paramaxnb)
  {
    int i = a(paramString, paramaxnb);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString);
    }
    if (i == 0)
    {
      a(i);
      a(paramaxnb, paramString);
      return;
    }
    if (b(paramaxnb))
    {
      a(0);
      return;
    }
    a(i);
  }
  
  private boolean a(axnb paramaxnb)
  {
    String str = paramaxnb.jdField_a_of_type_Axmy.a();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, paramaxnb);
      VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private static int b()
  {
    QQAppInterface localQQAppInterface = ahiy.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return ampm.a().a(526, localQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean b(axnb paramaxnb)
  {
    if (paramaxnb.jdField_a_of_type_Axmy.b)
    {
      String str = a(paramaxnb);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramaxnb);
        VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  public void a(axna paramaxna, axne paramaxne)
  {
    this.jdField_a_of_type_Axna = paramaxna;
    this.jdField_a_of_type_Axne = paramaxne;
    paramaxna = (axnb)paramaxna.jdField_a_of_type_JavaUtilList.get(0);
    VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, null, "load.item.start", paramaxna.jdField_a_of_type_JavaLangString, 0, null);
    if (jdField_a_of_type_JavaUtilHashMap.keySet().contains(paramaxna.jdField_a_of_type_JavaLangString))
    {
      this.b = false;
      this.jdField_a_of_type_JavaLangString = ((String)jdField_a_of_type_JavaUtilHashMap.get(paramaxna.jdField_a_of_type_JavaLangString));
      a(0);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Axna.jdField_a_of_type_Long, null, "load.item.getconfig.start", paramaxna.jdField_a_of_type_JavaLangString, 0, null);
    axnj.a().a(paramaxna.jdField_a_of_type_JavaLangString, new axmv(this, paramaxna));
  }
  
  public void a(String paramString)
  {
    if (!this.c)
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a("ver=" + this.jdField_a_of_type_JavaLangString, "SoLoadModule", "SoLoadSingle", "Exception", ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str1 = ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
    String str2 = ((axnb)this.jdField_a_of_type_Axna.jdField_a_of_type_JavaUtilList.get(0)).b;
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramString.contains(str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axmu
 * JD-Core Version:    0.7.0.1
 */