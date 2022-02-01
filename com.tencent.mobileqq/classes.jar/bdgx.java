import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.mobileqq.soload.LoadOptions;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
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

public class bdgx
{
  private static volatile bdgx jdField_a_of_type_Bdgx;
  private static final Map<LoadParam, bdgn> b = new HashMap();
  private final Map<LoadParam, List<bdgt>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Set<LoadParam> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private long a(LoadParam paramLoadParam)
  {
    int i = LoadParam.getItemSize(paramLoadParam);
    long l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", LoadParam.getReportStr(paramLoadParam), i, null);
    paramLoadParam.mReportSeq = l;
    return l;
  }
  
  private static bdgn a(LoadParam paramLoadParam)
  {
    if (paramLoadParam.mLoadItems.size() > 1) {
      return new bdgq();
    }
    return new bdgf();
  }
  
  private static bdgn a(String paramString)
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
        localObject2 = (bdgn)((Iterator)???).next();
        if ((localObject2 != null) && (((bdgn)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private bdgt a(LoadParam paramLoadParam, long paramLong)
  {
    return new bdgy(this, paramLoadParam);
  }
  
  public static bdgx a()
  {
    if (jdField_a_of_type_Bdgx == null) {}
    try
    {
      if (jdField_a_of_type_Bdgx == null) {
        jdField_a_of_type_Bdgx = new bdgx();
      }
      return jdField_a_of_type_Bdgx;
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
    for (Object localObject = LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam));; localObject = ((bdgn)localObject).a(paramLoadParam))
    {
      b(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramLoadParam);
      if (((LoadExtResult)localObject).isNeedRetry()) {
        a((LoadExtResult)localObject, paramLoadParam);
      }
      return localObject;
      localObject = a(paramLoadParam);
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
      a(paramLoadParam, (bdgn)localObject);
    }
  }
  
  private LoadParam a(LoadParam paramLoadParam, bdgt parambdgt)
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
          ((LinkedList)localObject2).add(parambdgt);
          paramLoadParam.mLoadTime = NetConnInfoCenter.getServerTimeMillis();
          this.jdField_a_of_type_JavaUtilMap.put(paramLoadParam, localObject2);
          if (localObject1 != null)
          {
            parambdgt = ((List)localObject1).iterator();
            if (parambdgt.hasNext())
            {
              localObject1 = (bdgt)parambdgt.next();
              if (localObject1 == null) {
                continue;
              }
              ((bdgt)localObject1).onLoadResult(7, LoadExtResult.create(7, LoadParam.getItemSize(paramLoadParam)));
              continue;
            }
          }
        }
        else
        {
          ((List)((Map.Entry)localObject2).getValue()).add(parambdgt);
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
    localLoadParam.mLoadItems.add(new LoadParam.LoadItem(paramString, paramLoadOptions));
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
            localLoadParam.mLoadItems.add(new LoadParam.LoadItem(str, localLoadOptions));
            break;
          }
        }
      }
    }
    return localLoadParam;
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = bdgf.a().iterator();
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
  
  private static void a(LoadParam paramLoadParam, bdgn parambdgn)
  {
    if ((paramLoadParam == null) || (parambdgn == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramLoadParam, parambdgn);
      return;
    }
  }
  
  private void a(LoadParam paramLoadParam, bdgt parambdgt)
  {
    ThreadManager.excute(new SoLoadManager.2(this, paramLoadParam, parambdgt), 16, null, false);
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
        String str = a(paramString3);
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
          paramString2 = bdgf.a(str);
          bdgu.a(str, paramString2, 1);
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
  
  private static void b(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, bdgt parambdgt, LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[LoadResult] resCode：" + paramInt);
    }
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label126;
      }
    }
    label126:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        VACDReportUtil.endReport(paramLong, "load.end", str, i, null);
      }
      if (parambdgt != null) {
        parambdgt.onLoadResult(paramInt, paramLoadExtResult);
      }
      a(paramLoadParam);
      bdll.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  private void b(LoadParam paramLoadParam, bdgt parambdgt)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramLoadParam);
    }
    long l = a(paramLoadParam);
    parambdgt = new bdgz(parambdgt, l, paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam))
    {
      parambdgt.onLoadResult(1, LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam)));
      return;
    }
    if ((paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC) && (paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC;
    }
    parambdgt = a(paramLoadParam, parambdgt);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (parambdgt == null) {
        break label189;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (parambdgt == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + parambdgt.mReportSeq, 0, null);
      return;
      label189:
      bool = false;
    }
    parambdgt = a(paramLoadParam, l);
    Object localObject = a(paramLoadParam);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramLoadParam, (bdgn)localObject);
    ((bdgn)localObject).a(paramLoadParam, parambdgt);
  }
  
  public LoadExtResult a(String paramString)
  {
    return a(paramString, null);
  }
  
  public LoadExtResult a(String paramString, LoadOptions paramLoadOptions)
  {
    return a(a(paramString, paramLoadOptions));
  }
  
  public void a(String paramString, bdgt parambdgt)
  {
    a(paramString, parambdgt, null);
  }
  
  public void a(String paramString, bdgt parambdgt, LoadOptions paramLoadOptions)
  {
    a(a(paramString, paramLoadOptions), parambdgt);
  }
  
  public void a(String[] paramArrayOfString, bdgt parambdgt)
  {
    a(paramArrayOfString, parambdgt, null);
  }
  
  public void a(String[] paramArrayOfString, bdgt parambdgt, LoadOptions[] paramArrayOfLoadOptions)
  {
    a(a(paramArrayOfString, paramArrayOfLoadOptions), parambdgt);
  }
  
  public void b(String paramString, bdgt parambdgt)
  {
    a(paramString, parambdgt, new bdgp().a(true).a());
  }
  
  public void b(String[] paramArrayOfString, bdgt parambdgt)
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
        arrayOfLoadOptions[j] = new bdgp().a(true).a();
        j += 1;
      }
    }
    a(paramArrayOfString, parambdgt, localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdgx
 * JD-Core Version:    0.7.0.1
 */