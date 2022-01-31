import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.LoadExtResult;
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

public class azip
{
  private static volatile azip jdField_a_of_type_Azip;
  private static final Map<azij, azig> b = new HashMap();
  private final Map<azij, List<azin>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Set<azij> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private long a(azij paramazij)
  {
    int i = azij.a(paramazij);
    long l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", azij.a(paramazij), i, null);
    paramazij.jdField_a_of_type_Long = l;
    return l;
  }
  
  private static azig a(azij paramazij)
  {
    if (paramazij.jdField_a_of_type_JavaUtilList.size() > 1) {
      return new azil();
    }
    return new azic();
  }
  
  private static azig a(String paramString)
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
        localObject2 = (azig)((Iterator)???).next();
        if ((localObject2 != null) && (((azig)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private azij a(azij paramazij, azin paramazin)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        azij localazij = (azij)localEntry.getKey();
        if ((localazij != null) && (localazij.b(paramazij)))
        {
          ((List)localEntry.getValue()).add(paramazin);
          return localazij;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramazin);
      this.jdField_a_of_type_JavaUtilMap.put(paramazij, localObject);
      return null;
    }
  }
  
  private azij a(String paramString, azih paramazih)
  {
    azij localazij = new azij();
    localazij.jdField_a_of_type_JavaUtilList.add(new azik(paramString, paramazih));
    return localazij;
  }
  
  private azij a(String[] paramArrayOfString, azih[] paramArrayOfazih)
  {
    azij localazij = new azij();
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
          if ((paramArrayOfazih != null) && (paramArrayOfazih.length > i)) {}
          for (azih localazih = paramArrayOfazih[i];; localazih = null)
          {
            localazij.jdField_a_of_type_JavaUtilList.add(new azik(str, localazih));
            break;
          }
        }
      }
    }
    return localazij;
  }
  
  private azin a(azij paramazij, long paramLong)
  {
    return new aziq(this, paramazij);
  }
  
  public static azip a()
  {
    if (jdField_a_of_type_Azip == null) {}
    try
    {
      if (jdField_a_of_type_Azip == null) {
        jdField_a_of_type_Azip = new azip();
      }
      return jdField_a_of_type_Azip;
    }
    finally {}
  }
  
  private LoadExtResult a(azij paramazij)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "loadSync loadParam=" + paramazij);
    }
    long l = a(paramazij);
    if (!azij.a(paramazij)) {}
    for (Object localObject = LoadExtResult.create(1, azij.a(paramazij), null);; localObject = ((azig)localObject).a(paramazij))
    {
      a(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramazij);
      if (!((LoadExtResult)localObject).isSucc()) {
        a((LoadExtResult)localObject, paramazij);
      }
      return localObject;
      localObject = a(paramazij);
      paramazij.d = azij.b;
    }
  }
  
  private LoadExtResult a(String paramString, azih paramazih)
  {
    return a(a(paramString, paramazih));
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = azic.a().iterator();
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
  
  static void a(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, azin paramazin, azij paramazij)
  {
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label88;
      }
    }
    label88:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        VACDReportUtil.endReport(paramLong, "load.end", str, i, null);
      }
      if (paramazin != null) {
        paramazin.a(paramInt, paramLoadExtResult);
      }
      a(paramazij);
      azmj.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(azij paramazij)
  {
    synchronized (b)
    {
      b.remove(paramazij);
      return;
    }
  }
  
  private static void a(azij paramazij, azig paramazig)
  {
    if ((paramazij == null) || (paramazig == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramazij, paramazig);
      return;
    }
  }
  
  private void a(azij paramazij, azin paramazin)
  {
    ThreadManager.excute(new SoLoadManager.2(this, paramazij, paramazin), 16, null, false);
  }
  
  private void a(LoadExtResult arg1, azij paramazij)
  {
    paramazij.d = azij.c;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[handleLoadSyncFail]delayTime:" + l);
    }
    if (l <= 0L)
    {
      a(paramazij, null);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        azij localazij = (azij)localIterator.next();
        if (localazij.b(paramazij))
        {
          ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(localazij);
          localIterator.remove();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postAtTime(new SoLoadManager.1(this, paramazij), paramazij, l + NetConnInfoCenter.getServerTimeMillis());
    this.jdField_a_of_type_JavaUtilSet.add(paramazij);
  }
  
  private void a(String paramString, azin paramazin, azih paramazih)
  {
    a(a(paramString, paramazih), paramazin);
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
          VACDReportUtil.a("ver=" + azic.a(str), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
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
  
  private void a(String[] paramArrayOfString, azin paramazin, azih[] paramArrayOfazih)
  {
    a(a(paramArrayOfString, paramArrayOfazih), paramazin);
  }
  
  private void b(azij paramazij, azin paramazin)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramazij);
    }
    long l = a(paramazij);
    paramazin = new azir(paramazin, l, paramazij);
    if (!azij.a(paramazij))
    {
      paramazin.a(1, LoadExtResult.create(1, azij.a(paramazij), null));
      return;
    }
    if ((paramazij.d != azij.jdField_a_of_type_Int) && (paramazij.d != azij.c)) {
      paramazij.d = azij.jdField_a_of_type_Int;
    }
    paramazin = a(paramazij, paramazin);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramazin == null) {
        break label190;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (paramazin == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + paramazin.jdField_a_of_type_Long, 0, null);
      return;
      label190:
      bool = false;
    }
    paramazin = a(paramazij, l);
    Object localObject = a(paramazij);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramazij, (azig)localObject);
    ((azig)localObject).a(paramazij, paramazin);
  }
  
  public LoadExtResult a(String paramString)
  {
    return a(paramString, null);
  }
  
  public void a(String paramString, azin paramazin)
  {
    a(paramString, paramazin, null);
  }
  
  public void a(String[] paramArrayOfString, azin paramazin)
  {
    a(paramArrayOfString, paramazin, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azip
 * JD-Core Version:    0.7.0.1
 */