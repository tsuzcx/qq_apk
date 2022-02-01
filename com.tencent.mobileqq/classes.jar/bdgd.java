import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

class bdgd
{
  private static final Map<String, Object> jdField_a_of_type_JavaUtilMap = new HashMap();
  int jdField_a_of_type_Int;
  LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem;
  LoadParam jdField_a_of_type_ComTencentMobileqqSoloadLoadParam;
  SoConfig.SoDetailInfo jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = false;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = true;
  String c;
  
  bdgd(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam = paramLoadParam;
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem = paramLoadItem;
  }
  
  static int a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return 0;
    }
    return aran.a().a(526, ((QQAppInterface)localAppRuntime).getCurrentAccountUin());
  }
  
  static boolean a()
  {
    return !(BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface);
  }
  
  protected static boolean a(@NonNull bdhi parambdhi)
  {
    return (!TextUtils.isEmpty(parambdhi.c)) && (new File(parambdhi.c).exists());
  }
  
  protected static boolean a(@NonNull bdhi parambdhi, @NonNull SoConfig.SoDetailInfo paramSoDetailInfo)
  {
    return (paramSoDetailInfo.relatedFileInfo == null) || ((!TextUtils.isEmpty(parambdhi.f)) && (new File(parambdhi.f).exists()));
  }
  
  static boolean a(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    Object localObject;
    for (;;)
    {
      boolean bool;
      synchronized (jdField_a_of_type_JavaUtilMap)
      {
        localObject = jdField_a_of_type_JavaUtilMap.get(paramLoadItem.name);
        if (localObject == null)
        {
          localObject = new byte[0];
          jdField_a_of_type_JavaUtilMap.put(paramLoadItem.name, localObject);
        }
      }
    }
  }
  
  private static boolean b(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLong == -1L) && (paramSoDetailInfo.crc == -1L)) {
      return true;
    }
    long l1;
    boolean bool2;
    long l2;
    label145:
    boolean bool3;
    label161:
    int i;
    boolean bool1;
    if (paramSoDetailInfo.crc != -1L)
    {
      l1 = paramSoDetailInfo.crc;
      bool2 = true;
      l2 = IOUtil.getCRC32Value(new File(paramString));
      if (l1 == l2) {
        break label424;
      }
      bdgv.c(paramLoadItem.name);
      paramString = new DownloadParam();
      paramString.filePos = 1;
      paramString.url = paramSoDetailInfo.url;
      paramString.md5ForChecked = paramSoDetailInfo.md5;
      PreloadManager.PathResult localPathResult = PreloadManager.a(paramString);
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.folderPath))) {
        break label379;
      }
      paramString = new File(localPathResult.folderPath, paramLoadItem.soFileName).getAbsolutePath();
      if ((localPathResult == null) || (!localPathResult.retryUnzip())) {
        break label385;
      }
      bool3 = true;
      i = 0;
      if (!bool3) {
        break label406;
      }
      paramLong = IOUtil.getCRC32Value(new File(paramString));
      if (!bool2) {
        break label400;
      }
      if (paramLong != l1) {
        break label391;
      }
      bool1 = true;
      label196:
      if (i == 0) {
        break label426;
      }
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.filePath))) {
        break label419;
      }
      paramString = MD5Coding.encodeFile2HexStr(localPathResult.filePath);
      label226:
      if ((TextUtils.isEmpty(paramSoDetailInfo.md5)) || (paramSoDetailInfo.md5.equalsIgnoreCase(paramString))) {
        break label426;
      }
      PreloadManager.a(paramSoDetailInfo.url, false, 1);
    }
    label385:
    label391:
    label400:
    label406:
    label419:
    label424:
    label426:
    for (boolean bool4 = false;; bool4 = true)
    {
      VACDReportUtil.a(paramLoadItem.name + "_" + paramSoDetailInfo.ver, "qqwallet", "SoLoadCRC", l2 + "_" + l1 + "_" + bool3 + "_" + paramLong + "_" + bool2 + "_" + bool4, null, paramInt, null);
      return bool1;
      bool2 = false;
      l1 = paramLong;
      break;
      label379:
      paramString = "";
      break label145;
      bool3 = false;
      break label161;
      i = 1;
      bool1 = false;
      break label196;
      bool1 = true;
      break label196;
      i = 1;
      bool1 = false;
      paramLong = -1L;
      break label196;
      paramString = null;
      break label226;
      return true;
    }
  }
  
  @NonNull
  SoLoadInfo a(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = new SoLoadInfo();
    localSoLoadInfo.curCode = paramInt;
    localSoLoadInfo.soPathToLoad = this.jdField_a_of_type_JavaLangString;
    localSoLoadInfo.subErrCode = this.jdField_a_of_type_Int;
    localSoLoadInfo.isFinishDownload = this.jdField_a_of_type_Boolean;
    localSoLoadInfo.isNeedDownload = this.jdField_b_of_type_Boolean;
    localSoLoadInfo.soDetailInfo = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo;
    localSoLoadInfo.rFileFolder = this.jdField_b_of_type_JavaLangString;
    localSoLoadInfo.failDetail = this.c;
    return localSoLoadInfo;
  }
  
  boolean a(SoConfig.SoInfo paramSoInfo)
  {
    SoConfig.SoDetailInfo localSoDetailInfo;
    if (paramSoInfo != null)
    {
      if (bdgw.a())
      {
        localSoDetailInfo = paramSoInfo.arm64Info;
        this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo = localSoDetailInfo;
      }
    }
    else {
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url))) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.AbsGetSoTask", 2, "[initConfig] isConfValid=" + bool + ",info:" + paramSoInfo + ",is64:" + bdgw.a());
      }
      return bool;
      localSoDetailInfo = paramSoInfo.arm32Info;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgd
 * JD-Core Version:    0.7.0.1
 */