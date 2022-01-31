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

public class azmy
{
  private static volatile azmy jdField_a_of_type_Azmy;
  private static final Map<azms, azmp> b = new HashMap();
  private final Map<azms, List<azmw>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final Set<azms> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  private long a(azms paramazms)
  {
    int i = azms.a(paramazms);
    long l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", azms.a(paramazms), i, null);
    paramazms.jdField_a_of_type_Long = l;
    return l;
  }
  
  private static azmp a(azms paramazms)
  {
    if (paramazms.jdField_a_of_type_JavaUtilList.size() > 1) {
      return new azmu();
    }
    return new azml();
  }
  
  private static azmp a(String paramString)
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
        localObject2 = (azmp)((Iterator)???).next();
        if ((localObject2 != null) && (((azmp)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private azms a(azms paramazms, azmw paramazmw)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        azms localazms = (azms)localEntry.getKey();
        if ((localazms != null) && (localazms.b(paramazms)))
        {
          ((List)localEntry.getValue()).add(paramazmw);
          return localazms;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramazmw);
      this.jdField_a_of_type_JavaUtilMap.put(paramazms, localObject);
      return null;
    }
  }
  
  private azms a(String paramString, azmq paramazmq)
  {
    azms localazms = new azms();
    localazms.jdField_a_of_type_JavaUtilList.add(new azmt(paramString, paramazmq));
    return localazms;
  }
  
  private azms a(String[] paramArrayOfString, azmq[] paramArrayOfazmq)
  {
    azms localazms = new azms();
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
          if ((paramArrayOfazmq != null) && (paramArrayOfazmq.length > i)) {}
          for (azmq localazmq = paramArrayOfazmq[i];; localazmq = null)
          {
            localazms.jdField_a_of_type_JavaUtilList.add(new azmt(str, localazmq));
            break;
          }
        }
      }
    }
    return localazms;
  }
  
  private azmw a(azms paramazms, long paramLong)
  {
    return new azmz(this, paramazms);
  }
  
  public static azmy a()
  {
    if (jdField_a_of_type_Azmy == null) {}
    try
    {
      if (jdField_a_of_type_Azmy == null) {
        jdField_a_of_type_Azmy = new azmy();
      }
      return jdField_a_of_type_Azmy;
    }
    finally {}
  }
  
  private LoadExtResult a(azms paramazms)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "loadSync loadParam=" + paramazms);
    }
    long l = a(paramazms);
    if (!azms.a(paramazms)) {}
    for (Object localObject = LoadExtResult.create(1, azms.a(paramazms), null);; localObject = ((azmp)localObject).a(paramazms))
    {
      a(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramazms);
      if (!((LoadExtResult)localObject).isSucc()) {
        a((LoadExtResult)localObject, paramazms);
      }
      return localObject;
      localObject = a(paramazms);
      paramazms.d = azms.b;
    }
  }
  
  private LoadExtResult a(String paramString, azmq paramazmq)
  {
    return a(a(paramString, paramazmq));
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = azml.a().iterator();
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
  
  static void a(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, azmw paramazmw, azms paramazms)
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
      if (paramazmw != null) {
        paramazmw.a(paramInt, paramLoadExtResult);
      }
      a(paramazms);
      azqs.b(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      return;
      i = 0;
      break;
    }
  }
  
  private static void a(azms paramazms)
  {
    synchronized (b)
    {
      b.remove(paramazms);
      return;
    }
  }
  
  private static void a(azms paramazms, azmp paramazmp)
  {
    if ((paramazms == null) || (paramazmp == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramazms, paramazmp);
      return;
    }
  }
  
  private void a(azms paramazms, azmw paramazmw)
  {
    ThreadManager.excute(new SoLoadManager.2(this, paramazms, paramazmw), 16, null, false);
  }
  
  private void a(LoadExtResult arg1, azms paramazms)
  {
    paramazms.d = azms.c;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "[handleLoadSyncFail]delayTime:" + l);
    }
    if (l <= 0L)
    {
      a(paramazms, null);
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
      while (localIterator.hasNext())
      {
        azms localazms = (azms)localIterator.next();
        if (localazms.b(paramazms))
        {
          ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(localazms);
          localIterator.remove();
        }
      }
    }
    ThreadManager.getSubThreadHandler().postAtTime(new SoLoadManager.1(this, paramazms), paramazms, l + NetConnInfoCenter.getServerTimeMillis());
    this.jdField_a_of_type_JavaUtilSet.add(paramazms);
  }
  
  private void a(String paramString, azmw paramazmw, azmq paramazmq)
  {
    a(a(paramString, paramazmq), paramazmw);
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
          VACDReportUtil.a("ver=" + azml.a(str), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
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
  
  private void a(String[] paramArrayOfString, azmw paramazmw, azmq[] paramArrayOfazmq)
  {
    a(a(paramArrayOfString, paramArrayOfazmq), paramazmw);
  }
  
  private void b(azms paramazms, azmw paramazmw)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramazms);
    }
    long l = a(paramazms);
    paramazmw = new azna(paramazmw, l, paramazms);
    if (!azms.a(paramazms))
    {
      paramazmw.a(1, LoadExtResult.create(1, azms.a(paramazms), null));
      return;
    }
    if ((paramazms.d != azms.jdField_a_of_type_Int) && (paramazms.d != azms.c)) {
      paramazms.d = azms.jdField_a_of_type_Int;
    }
    paramazmw = a(paramazms, paramazmw);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramazmw == null) {
        break label190;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (paramazmw == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + paramazmw.jdField_a_of_type_Long, 0, null);
      return;
      label190:
      bool = false;
    }
    paramazmw = a(paramazms, l);
    Object localObject = a(paramazms);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramazms, (azmp)localObject);
    ((azmp)localObject).a(paramazms, paramazmw);
  }
  
  public LoadExtResult a(String paramString)
  {
    return a(paramString, null);
  }
  
  public void a(String paramString, azmw paramazmw)
  {
    a(paramString, paramazmw, null);
  }
  
  public void a(String[] paramArrayOfString, azmw paramazmw)
  {
    a(paramArrayOfString, paramazmw, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azmy
 * JD-Core Version:    0.7.0.1
 */