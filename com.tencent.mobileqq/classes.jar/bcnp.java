import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.RelatedFileInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bcnp
  extends bcnl
{
  private static final Map<String, List<bcoa>> a;
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public bcnp(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private void a(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = a(paramInt);
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Object localObject3 = (List)jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      jdField_a_of_type_JavaUtilMap.remove(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      if (localObject3 != null)
      {
        ??? = ((List)localObject3).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (bcoa)((Iterator)???).next();
          if (localObject3 != null) {
            ((bcoa)localObject3).a(localSoLoadInfo);
          }
        }
      }
    }
  }
  
  private void a(akse paramakse)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.relatedFileInfo.url;
    localDownloadParam.md5ForChecked = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.relatedFileInfo.md5;
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
      localDownloadParam.isPreDownload = true;
    }
    PreloadManager.a().a(localDownloadParam, paramakse);
  }
  
  private void a(LoadParam.LoadItem paramLoadItem)
  {
    boolean bool2 = false;
    paramLoadItem = bcod.b(paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
    boolean bool3 = a(paramLoadItem);
    boolean bool4 = a(paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
    if (((this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.lops.flag & 0x4) != 0) && (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] soExist=" + bool3 + ",rfolderOk=" + bool4 + ",isWeak:" + bool1);
      }
      if (!bool3) {
        bool2 = true;
      }
      this.jdField_b_of_type_Boolean = bool2;
      if (bool3) {
        break;
      }
      b(new bcns(this, bool4, bool1, paramLoadItem));
      return;
    }
    a(bool4, bool1, paramLoadItem, paramLoadItem.c, paramLoadItem.a, 1);
  }
  
  private void a(LoadParam.LoadItem paramLoadItem, SoConfig.SoInfo paramSoInfo)
  {
    if (!a(paramSoInfo))
    {
      a(2);
      return;
    }
    paramSoInfo = bcod.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.ver);
    if ((paramSoInfo != null) && (paramSoInfo.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + paramSoInfo);
      }
      this.c = "loadcrash";
      a(8);
      return;
    }
    if ((paramSoInfo != null) && (paramSoInfo.f()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] isNeedReqForCrash, crashInfo=" + paramSoInfo);
      }
      String str = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.ver;
      bcoj.a().a(paramLoadItem.name, paramSoInfo, new bcnr(this, str, paramSoInfo, paramLoadItem));
      return;
    }
    a(paramLoadItem);
  }
  
  private void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    if (a(paramString2, paramLong, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, paramInt))
    {
      this.jdField_b_of_type_JavaLangString = paramString1;
      this.jdField_a_of_type_JavaLangString = paramString2;
      a(0);
      return;
    }
    a(10);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, bcoq parambcoq, String paramString, long paramLong, int paramInt)
  {
    if (paramBoolean1)
    {
      a(parambcoq.f, paramString, paramLong, paramInt);
      return;
    }
    if (paramBoolean2)
    {
      a(null);
      a(null, paramString, paramLong, paramInt);
      return;
    }
    a(new bcnt(this, paramString, paramLong, paramInt));
  }
  
  private boolean a(bcoa parambcoa)
  {
    synchronized (jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name)))
        {
          ((List)localEntry.getValue()).add(parambcoa);
          return true;
        }
      }
      localObject = new LinkedList();
      ((List)localObject).add(parambcoa);
      jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, localObject);
      return false;
    }
  }
  
  private void b(akse paramakse)
  {
    DownloadParam localDownloadParam = new DownloadParam();
    localDownloadParam.filePos = 1;
    localDownloadParam.url = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url;
    localDownloadParam.md5ForChecked = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.md5;
    VACDReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.download.start", null, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
      localDownloadParam.isPreDownload = true;
    }
    PreloadManager.a().a(localDownloadParam, paramakse);
  }
  
  public void a(bcoa parambcoa)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "not main process get loadInfo by IPC");
      }
      akwm.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, parambcoa);
    }
    do
    {
      return;
      if (!a(parambcoa)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "insert into same req list");
    return;
    VACDReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.getconfig.start", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 0, null);
    bcoj.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, new bcnq(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcnp
 * JD-Core Version:    0.7.0.1
 */