import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.soload.LoadExtResult;
import com.tencent.widget.soload.config.SoConfig.SoDetailInfo;
import com.tencent.widget.soload.config.SoConfig.SoInfo;
import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class berw
  implements berz
{
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private besc jdField_a_of_type_Besc;
  private besg jdField_a_of_type_Besg;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  private boolean c;
  
  private int a(String paramString, besd parambesd)
  {
    if (!new File(paramString).exists()) {
      return 5;
    }
    try
    {
      System.load(paramString);
      jdField_a_of_type_JavaUtilSet.add(parambesd.jdField_a_of_type_JavaLangString);
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
    if (besh.a()) {
      return "_arm64_path";
    }
    return "_arm32_path";
  }
  
  private String a(besd parambesd)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).getString("key_last_succ_" + parambesd.jdField_a_of_type_JavaLangString + a(), "");
      return "";
    }
    catch (Throwable parambesd)
    {
      for (;;)
      {
        parambesd.printStackTrace();
      }
    }
  }
  
  @Deprecated
  public static List<String> a()
  {
    return new LinkedList(jdField_a_of_type_JavaUtilSet);
  }
  
  private void a(int paramInt)
  {
    a(paramInt, null);
  }
  
  private void a(int paramInt, String paramString)
  {
    this.c = true;
    VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.load", "", paramInt, paramString);
    paramString = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_Boolean, this.b, ((besd)this.jdField_a_of_type_Besc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Besg != null) {
      this.jdField_a_of_type_Besg.a(paramInt, paramString);
    }
  }
  
  private void a(besd parambesd, SoConfig.SoInfo paramSoInfo)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + besh.a());
    }
    if (paramSoInfo != null) {
      if (besh.a()) {
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
        if (!a(parambesd)) {
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
      DownloadParam localDownloadParam = new DownloadParam();
      localDownloadParam.filePos = 1;
      localDownloadParam.url = paramSoInfo.url;
      localDownloadParam.md5ForChecked = paramSoInfo.md5;
      paramSoInfo = PreloadManager.a(localDownloadParam);
      if ((paramSoInfo != null) && (paramSoInfo.folderPath != null)) {}
      for (paramSoInfo = new File(paramSoInfo.folderPath, parambesd.b).getAbsolutePath(); (!TextUtils.isEmpty(paramSoInfo)) && (new File(paramSoInfo).exists()); paramSoInfo = "")
      {
        if (QLog.isColorLevel()) {
          QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile exist");
        }
        a(paramSoInfo, parambesd);
        return;
      }
      boolean bool = a(parambesd);
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[handleConfig] configSoFile not exist - loadOldSoSucc=" + bool);
      }
      if (bool)
      {
        a(0);
        PreloadManager.a().a(localDownloadParam, null);
        return;
      }
      VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.download.start", null, 0, null);
      PreloadManager.a().a(localDownloadParam, new bery(this, parambesd));
      return;
      paramSoInfo = null;
    }
  }
  
  private void a(besd parambesd, String paramString)
  {
    try
    {
      BaseApplicationImpl.getApplication().getSharedPreferences("dynamic_so_load", 0).edit().putString("key_last_succ_" + parambesd.jdField_a_of_type_JavaLangString + a(), paramString).apply();
      return;
    }
    catch (Throwable parambesd)
    {
      parambesd.printStackTrace();
    }
  }
  
  private void a(String paramString, besd parambesd)
  {
    int i = a(paramString, parambesd);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + i + ",filePath=" + paramString);
    }
    if (i == 0)
    {
      a(i);
      a(parambesd, paramString);
      return;
    }
    if (b(parambesd))
    {
      a(0);
      return;
    }
    a(i);
  }
  
  private boolean a(besd parambesd)
  {
    String str = parambesd.jdField_a_of_type_Besa.a();
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      int i = a(str, parambesd);
      VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.load.oldpath", null, i, null);
      return i == 0;
    }
    return false;
  }
  
  private static int b()
  {
    QQAppInterface localQQAppInterface = agwj.a();
    if (localQQAppInterface == null) {
      return 0;
    }
    return alzw.a().a(526, localQQAppInterface.getCurrentAccountUin());
  }
  
  private boolean b(besd parambesd)
  {
    if (parambesd.jdField_a_of_type_Besa.jdField_a_of_type_Boolean)
    {
      String str = a(parambesd);
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, parambesd);
        VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.load.last", null, i, null);
        return i == 0;
      }
    }
    return false;
  }
  
  public void a(besc parambesc, besg parambesg)
  {
    this.jdField_a_of_type_Besc = parambesc;
    this.jdField_a_of_type_Besg = parambesg;
    parambesc = (besd)parambesc.jdField_a_of_type_JavaUtilList.get(0);
    VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.start", parambesc.jdField_a_of_type_JavaLangString, 0, null);
    if (jdField_a_of_type_JavaUtilSet.contains(parambesc.jdField_a_of_type_JavaLangString))
    {
      this.b = false;
      a(0);
      return;
    }
    VACDReportUtil.a(this.jdField_a_of_type_Besc.jdField_a_of_type_Long, null, "load.item.getconfig.start", parambesc.jdField_a_of_type_JavaLangString, 0, null);
    besl.a().a(parambesc.jdField_a_of_type_JavaLangString, new berx(this, parambesc));
  }
  
  public void a(String paramString)
  {
    if (!this.c)
    {
      a(8, paramString);
      return;
    }
    VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", ((besd)this.jdField_a_of_type_Besc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString, 2, paramString);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str1 = ((besd)this.jdField_a_of_type_Besc.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaLangString;
    String str2 = ((besd)this.jdField_a_of_type_Besc.jdField_a_of_type_JavaUtilList.get(0)).b;
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (paramString.contains(str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     berw
 * JD-Core Version:    0.7.0.1
 */