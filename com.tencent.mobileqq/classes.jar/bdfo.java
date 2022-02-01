import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.DownSoLoader.2;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class bdfo
  implements bdfw
{
  private static HashMap<String, SoLoadInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static Map<String, bdfn> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static Set<String> jdField_a_of_type_JavaUtilSet = new DownSoLoader.2();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bdgc jdField_a_of_type_Bdgc;
  private LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem;
  private LoadParam jdField_a_of_type_ComTencentMobileqqSoloadLoadParam;
  private SoLoadInfo jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo = SoLoadInfo.sDefault;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private int a(LoadParam.LoadItem paramLoadItem, @NonNull SoLoadInfo paramSoLoadInfo)
  {
    int i = 0;
    int j = a(paramSoLoadInfo.soPathToLoad, paramLoadItem);
    if (QLog.isColorLevel()) {
      QLog.d("SoLoadWidget.DownSoLoader", 2, "[loadConfigSo] res=" + j + ",filePath=" + paramSoLoadInfo.soPathToLoad);
    }
    boolean bool;
    if (j == 0)
    {
      bool = true;
      a(bool, this.jdField_a_of_type_JavaLangString, paramSoLoadInfo.soPathToLoad, paramLoadItem);
      if (j != 0) {
        break label116;
      }
      bdgf.a(paramLoadItem, paramSoLoadInfo.soPathToLoad);
      bdgf.a(paramLoadItem, paramSoLoadInfo);
      bdgf.a(paramLoadItem.name);
      i = j;
    }
    label116:
    while (b(paramLoadItem))
    {
      return i;
      bool = false;
      break;
    }
    return j;
  }
  
  private int a(@NonNull SoLoadInfo paramSoLoadInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo = paramSoLoadInfo;
    int j = this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.curCode;
    int i;
    if (j == 0) {
      i = a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo);
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (j != 2);
      i = j;
    } while (!a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem));
    return 0;
  }
  
  private int a(String paramString, LoadParam.LoadItem paramLoadItem)
  {
    int j = 0;
    int i;
    if ((!new File(paramString).exists()) && (b(paramString))) {
      i = 5;
    }
    for (;;)
    {
      return i;
      if ((paramLoadItem.lops.flag & 0x1) != 0)
      {
        i = j;
        if ((paramLoadItem.lops.flag & 0x2) != 0)
        {
          i = j;
          if (!jdField_a_of_type_JavaUtilSet.contains(paramLoadItem.name))
          {
            paramString = paramLoadItem.lops;
            paramString.flag &= 0xFFFFFFFD;
            return 0;
          }
        }
      }
      else
      {
        try
        {
          System.load(paramString);
          paramString = paramLoadItem.lops;
          paramString.flag |= 0x2;
          i = j;
          if (b())
          {
            jdField_a_of_type_JavaUtilHashMap.put(paramLoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo);
            return 0;
          }
        }
        catch (Throwable paramString)
        {
          QLog.e("SoLoadWidget.DownSoLoader", 1, paramString, new Object[0]);
          this.jdField_a_of_type_JavaLangString = albw.a(paramString);
        }
      }
    }
    return 6;
  }
  
  private LoadExtResult a(int paramInt)
  {
    String str = null;
    if (paramInt == 6) {
      str = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      return a(paramInt, str);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.failDetail)) {
        str = this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.failDetail;
      }
    }
  }
  
  private LoadExtResult a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    bdgd.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, "ver=" + this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.getVer(), "load.item.load", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, paramInt, paramString);
    LoadExtResult localLoadExtResult = LoadExtResult.create(paramInt, 1, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.lops);
    int i;
    if ((paramInt != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC))
    {
      bdfn localbdfn = (bdfn)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      paramString = localbdfn;
      if (localbdfn == null) {
        paramString = new bdfn();
      }
      boolean bool = NetworkUtil.isNetSupport(BaseApplicationImpl.getApplication());
      long l3 = NetConnInfoCenter.getServerTimeMillis();
      i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[onLoadResult]AsyncFailInfo:" + paramString + ",name:" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name + ",isNetSupport:" + bool + ",curTime=" + l3 + ",netType=" + i);
      }
      if (bool)
      {
        paramString.jdField_a_of_type_Int = paramInt;
        paramString.c = i;
        paramString.jdField_a_of_type_Long = l3;
        paramString.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.subErrCode;
        jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, paramString);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_SYNC) {
      localLoadExtResult.failInfo = ((bdfn)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name));
    }
    if (this.jdField_a_of_type_Bdgc != null) {
      this.jdField_a_of_type_Bdgc.onLoadResult(paramInt, localLoadExtResult);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.isFirstlyLoad) {
      i = 3;
    }
    for (;;)
    {
      if (!LoadParam.isCloseReport(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam)) {
        bdla.b(null, "dc00899", "SoLoad", "", "resSingle", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, paramInt, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.getVer(), i + "", l1 - l2 + "", this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.subErrCode + "");
      }
      return localLoadExtResult;
      if (this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.isNeedDownload) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static String a(String paramString)
  {
    paramString = (SoLoadInfo)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return "";
    }
    return paramString.getVer();
  }
  
  @Deprecated
  public static List<String> a()
  {
    return new LinkedList(jdField_a_of_type_JavaUtilHashMap.keySet());
  }
  
  private void a(boolean paramBoolean, String paramString1, String paramString2, LoadParam.LoadItem paramLoadItem)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name).append("_").append(this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.soDetailInfo.ver).append("_").append(this.c).append("_").append(this.d).append("_").append(this.jdField_b_of_type_Int).append("_").append(paramBoolean).append("_").append(this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.soDetailInfo.testFlag).append("_").append(paramLoadItem.lops.flag).append("_").append(this.jdField_a_of_type_Int);
      paramLoadItem = new StringBuilder();
      paramLoadItem.append(BaseApplicationImpl.processName).append("_").append(albw.c(paramString2));
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.DownSoLoader", 2, "[testNoExist] skey=" + localStringBuilder + ",step=" + paramLoadItem);
      }
      VACDReportUtil.a(localStringBuilder.toString(), "qqwallet", "SoLoadNotExist", paramLoadItem.toString(), null, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.soDetailInfo.testFlag, paramString1);
    }
  }
  
  private boolean a()
  {
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name))
    {
      this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo = ((SoLoadInfo)jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name));
      this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.isFirstlyLoad = false;
      LoadOptions localLoadOptions = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.lops;
      localLoadOptions.flag |= 0x2;
      return true;
    }
    return false;
  }
  
  private boolean a(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool2 = false;
    String str = paramLoadItem.lops.getOldSoPath();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      bool1 = bool2;
      if (new File(str).exists())
      {
        int i = a(str, paramLoadItem);
        bdgd.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.load.oldpath", null, i, null);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void b(LoadParam paramLoadParam, bdgc parambdgc)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam = paramLoadParam;
    this.jdField_a_of_type_Bdgc = parambdgc;
    this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem = ((LoadParam.LoadItem)paramLoadParam.mLoadItems.get(0));
    bdgd.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.start", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 0, null);
  }
  
  private boolean b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.soDetailInfo.relatedFileInfo == null) {}
    while (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.rFileFolder)) {
      return true;
    }
    return false;
  }
  
  private boolean b(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLoadItem.lops.isLoadLastSuccWhenFail)
    {
      String str = bdgf.a(paramLoadItem);
      bool1 = bool2;
      if (!TextUtils.isEmpty(str))
      {
        int i = a(str, paramLoadItem);
        bdgd.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.load.last", null, i, null);
        bool1 = bool2;
        if (i == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean b(String paramString)
  {
    return true;
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    b(paramLoadParam, null);
    if (a()) {
      return a(0);
    }
    return a(a(new bdfv(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem).a()));
  }
  
  public void a(LoadParam paramLoadParam, bdgc parambdgc)
  {
    b(paramLoadParam, parambdgc);
    if (a())
    {
      a(0);
      return;
    }
    new bdfq(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem).a(new bdfp(this));
  }
  
  public void a(String paramString)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType != LoadParam.CALL_TYPE_SYNC)) {
      a(8, paramString);
    }
    for (;;)
    {
      bdge.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.getVer(), 0);
      return;
      VACDReportUtil.a("ver=" + this.jdField_a_of_type_ComTencentMobileqqSoloadSoLoadInfo.getVer(), "SoLoadModule", "SoLoadSingle", "Exception", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 2, paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str1;
    String str2;
    do
    {
      return false;
      str1 = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name;
      str2 = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.soFileName;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (!paramString.contains(str2)));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdfo
 * JD-Core Version:    0.7.0.1
 */