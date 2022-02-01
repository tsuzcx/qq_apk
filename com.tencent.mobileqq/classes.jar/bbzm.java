import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.SoLoadManager.1;
import com.tencent.mobileqq.soload.SoLoadManager.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class bbzm
{
  private static volatile bbzm jdField_a_of_type_Bbzm;
  private static final Map<LoadParam, bbzb> b = new HashMap();
  private final Map<LoadParam, List<bbzh>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Set<LoadParam> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private long a(LoadParam paramLoadParam)
  {
    int i = LoadParam.getItemSize(paramLoadParam);
    long l = bbzi.a(paramLoadParam, null, "SoLoadModule", "SoLoad", "load.start", LoadParam.getReportStr(paramLoadParam), i, null);
    paramLoadParam.mReportSeq = l;
    return l;
  }
  
  private static bbzb a(LoadParam paramLoadParam)
  {
    if (paramLoadParam.mLoadItems.size() > 1) {
      return new bbze();
    }
    return new bbyt();
  }
  
  private static bbzb a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (b)
    {
      Object localObject2 = new LinkedList(b.values());
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (bbzb)((Iterator)???).next();
        if ((localObject2 != null) && (((bbzb)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private bbzh a(LoadParam paramLoadParam, long paramLong)
  {
    return new bbzn(this, paramLoadParam);
  }
  
  public static bbzm a()
  {
    if (jdField_a_of_type_Bbzm == null) {}
    try
    {
      if (jdField_a_of_type_Bbzm == null) {
        jdField_a_of_type_Bbzm = new bbzm();
      }
      return jdField_a_of_type_Bbzm;
    }
    finally {}
  }
  
  private LoadExtResult a(LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "loadSync loadParam=" + paramLoadParam);
    }
    long l = a(paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam)) {}
    for (Object localObject = LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam));; localObject = ((bbzb)localObject).a(paramLoadParam))
    {
      b(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramLoadParam);
      if (((LoadExtResult)localObject).isNeedRetry(paramLoadParam)) {
        a((LoadExtResult)localObject, paramLoadParam);
      }
      return localObject;
      localObject = a(paramLoadParam);
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
      a(paramLoadParam, (bbzb)localObject);
    }
  }
  
  private LoadParam a(LoadParam paramLoadParam, bbzh parambbzh)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        localObject1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label258;
        }
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        LoadParam localLoadParam = (LoadParam)((Map.Entry)localObject2).getKey();
        if ((localLoadParam == null) || (!localLoadParam.isSame(paramLoadParam))) {
          continue;
        }
        if (localLoadParam.isOverTime())
        {
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          ((Iterator)localObject1).remove();
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("SoLoadWidget.SoLoadManager", 2, "[getSameParamInLoad] isOverTime:" + localObject2);
            localObject1 = localObject2;
          }
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(parambbzh);
          paramLoadParam.mLoadTime = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_JavaUtilMap.put(paramLoadParam, localObject2);
          if (localObject1 != null)
          {
            parambbzh = ((List)localObject1).iterator();
            if (parambbzh.hasNext())
            {
              localObject1 = (bbzh)parambbzh.next();
              if (localObject1 == null) {
                continue;
              }
              ((bbzh)localObject1).onLoadResult(7, LoadExtResult.create(7, LoadParam.getItemSize(paramLoadParam)));
              continue;
            }
          }
        }
        else
        {
          ((List)((Map.Entry)localObject2).getValue()).add(parambbzh);
          return localLoadParam;
        }
      }
      return null;
      label258:
      Object localObject1 = null;
    }
  }
  
  private LoadParam a(String paramString, LoadOptions paramLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.addItem(paramString, paramLoadOptions);
    return localLoadParam;
  }
  
  private LoadParam a(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i];
        if (TextUtils.isEmpty(str))
        {
          i += 1;
        }
        else
        {
          if ((paramArrayOfLoadOptions != null) && (paramArrayOfLoadOptions.length > i)) {}
          for (LoadOptions localLoadOptions = paramArrayOfLoadOptions[i];; localLoadOptions = null)
          {
            localLoadParam.addItem(str, localLoadOptions);
            break;
          }
        }
      }
    }
    return localLoadParam;
  }
  
  private void a(LoadExtResult arg1, LoadParam paramLoadParam)
  {
    paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC_BY_SYNC;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[handleLoadSyncFail]delayTime:" + l);
    }
    if (l <= 0L)
    {
      a(paramLoadParam, null);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        LoadParam localLoadParam = (LoadParam)localIterator.next();
        if (localLoadParam.isSame(paramLoadParam))
        {
          ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(localLoadParam);
          localIterator.remove();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postAtTime(new SoLoadManager.1(this, paramLoadParam), paramLoadParam, l + NetConnInfoCenter.getServerTimeMillis());
    this.jdField_a_of_type_JavaUtilSet.add(paramLoadParam);
  }
  
  private static void a(LoadParam paramLoadParam)
  {
    synchronized (b)
    {
      b.remove(paramLoadParam);
      return;
    }
  }
  
  private static void a(LoadParam paramLoadParam, bbzb parambbzb)
  {
    if ((paramLoadParam == null) || (parambbzb == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramLoadParam, parambbzb);
      return;
    }
  }
  
  private void a(LoadParam paramLoadParam, bbzh parambbzh)
  {
    ThreadManager.excute(new SoLoadManager.2(this, paramLoadParam, parambbzh), 16, null, false);
  }
  
  public static void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    paramString2 = null;
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      return;
      try
      {
        String str = b(paramString3);
        if (TextUtils.isEmpty(str))
        {
          localObject = a(paramString3);
          paramString2 = (String)localObject;
          if (localObject == null)
          {
            if (!paramString3.contains("com.tencent.mobileqq.soload")) {
              continue;
            }
            paramString2 = (String)localObject;
          }
        }
        Object localObject = BaseApplicationImpl.processName;
        paramString1 = "process:" + (String)localObject + "msg:" + paramString1 + paramString3;
        if (!TextUtils.isEmpty(str))
        {
          paramString2 = bbyt.a(str);
          bbzj.a(str, paramString2, 1);
          VACDReportUtil.a("ver=" + paramString2, "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    if (paramString2 != null)
    {
      paramString2.a(paramString1);
      return;
    }
    VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", "SoLoadWidget", 2, paramString1);
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = bbyt.a().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = "lib" + str1 + ".so";
      if ((!TextUtils.isEmpty(str2)) && (paramString.contains(str2))) {
        return str1;
      }
    }
    return null;
  }
  
  private static void b(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, bbzh parambbzh, LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[LoadResult] resCode：" + paramInt);
    }
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label136;
      }
    }
    label136:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        bbzi.a(paramLoadParam, paramLong, "load.end", str, i, null);
      }
      if (parambbzh != null) {
        parambbzh.onLoadResult(paramInt, paramLoadExtResult);
      }
      a(paramLoadParam);
      if (!LoadParam.isCloseReport(paramLoadParam)) {
        bcef.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void b(LoadParam paramLoadParam, bbzh parambbzh)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramLoadParam);
    }
    long l = a(paramLoadParam);
    parambbzh = new bbzo(parambbzh, l, paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam))
    {
      parambbzh.onLoadResult(1, LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam)));
      return;
    }
    if ((paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC) && (paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC;
    }
    parambbzh = a(paramLoadParam, parambbzh);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (parambbzh == null) {
        break label190;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (parambbzh == null) {
        break;
      }
      bbzi.a(paramLoadParam, l, null, "load.join.same.queue", "first=" + parambbzh.mReportSeq, 0, null);
      return;
      label190:
      bool = false;
    }
    parambbzh = a(paramLoadParam, l);
    Object localObject = a(paramLoadParam);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramLoadParam, (bbzb)localObject);
    ((bbzb)localObject).a(paramLoadParam, parambbzh);
  }
  
  public LoadExtResult a(String paramString)
  {
    return a(paramString, null);
  }
  
  public LoadExtResult a(String paramString, LoadOptions paramLoadOptions)
  {
    return a(a(paramString, paramLoadOptions));
  }
  
  public String a(String paramString)
  {
    String str = a(paramString, new bbzd().a(true).b(true).c(true).d(true).a()).getVer();
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  public void a(String paramString, bbzh parambbzh)
  {
    a(paramString, parambbzh, null);
  }
  
  public void a(String paramString, bbzh parambbzh, LoadOptions paramLoadOptions)
  {
    a(a(paramString, paramLoadOptions), parambbzh);
  }
  
  public void a(String[] paramArrayOfString, bbzh parambbzh)
  {
    a(paramArrayOfString, parambbzh, null);
  }
  
  public void a(String[] paramArrayOfString, bbzh parambbzh, LoadOptions[] paramArrayOfLoadOptions)
  {
    a(a(paramArrayOfString, paramArrayOfLoadOptions), parambbzh);
  }
  
  public void b(String paramString, bbzh parambbzh)
  {
    a(paramString, parambbzh, new bbzd().a(true).a());
  }
  
  public void b(String[] paramArrayOfString, bbzh parambbzh)
  {
    int j = 0;
    if (paramArrayOfString == null) {}
    Object localObject;
    for (int i = 0;; i = paramArrayOfString.length)
    {
      localObject = null;
      if (i <= 0) {
        break;
      }
      LoadOptions[] arrayOfLoadOptions = new LoadOptions[i];
      for (;;)
      {
        localObject = arrayOfLoadOptions;
        if (j >= i) {
          break;
        }
        arrayOfLoadOptions[j] = new bbzd().a(true).a();
        j += 1;
      }
    }
    a(paramArrayOfString, parambbzh, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbzm
 * JD-Core Version:    0.7.0.1
 */