import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.soload.LoadExtResult;
import com.tencent.widget.soload.SoLoadManager.1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class besi
{
  private static volatile besi jdField_a_of_type_Besi;
  private static final Map<besc, berz> b = new HashMap();
  private final Map<besc, List<besg>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static berz a(besc parambesc)
  {
    if (parambesc.jdField_a_of_type_JavaUtilList.size() > 1) {
      return new bese();
    }
    return new berw();
  }
  
  private static berz a(String paramString)
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
        localObject2 = (berz)((Iterator)???).next();
        if ((localObject2 != null) && (((berz)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private besc a(besc parambesc, besg parambesg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        besc localbesc = (besc)localEntry.getKey();
        if ((localbesc != null) && (localbesc.a(parambesc)))
        {
          ((List)localEntry.getValue()).add(parambesg);
          return localbesc;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(parambesg);
      this.jdField_a_of_type_JavaUtilMap.put(parambesc, localObject);
      return null;
    }
  }
  
  private besg a(besc parambesc, long paramLong)
  {
    return new besj(this, parambesc);
  }
  
  public static besi a()
  {
    if (jdField_a_of_type_Besi == null) {}
    try
    {
      if (jdField_a_of_type_Besi == null) {
        jdField_a_of_type_Besi = new besi();
      }
      return jdField_a_of_type_Besi;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = berw.a().iterator();
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
  
  private static void a(besc parambesc, berz paramberz)
  {
    if ((parambesc == null) || (paramberz == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(parambesc, paramberz);
      return;
    }
  }
  
  private void a(besc parambesc, besg parambesg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + parambesc);
    }
    if ((parambesc == null) || (parambesc.jdField_a_of_type_JavaUtilList == null)) {}
    for (int i = 0;; i = parambesc.jdField_a_of_type_JavaUtilList.size())
    {
      l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", besc.a(parambesc), i, null);
      parambesg = new besk(parambesg, l, parambesc);
      if ((parambesc != null) && (parambesc.a())) {
        break;
      }
      parambesg.a(1, LoadExtResult.create(1, i));
      return;
    }
    parambesg = a(parambesc, parambesg);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (parambesg == null) {
        break label198;
      }
    }
    label198:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (parambesg == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + parambesg.jdField_a_of_type_Long, 0, null);
      return;
    }
    parambesg = a(parambesc, l);
    Object localObject = a(parambesc);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(parambesc, (berz)localObject);
    parambesc.jdField_a_of_type_Long = l;
    MqqHandler localMqqHandler = ThreadManager.getSubThreadHandler();
    SoLoadManager.1 local1 = new SoLoadManager.1(this, parambesc, parambesg, i);
    long l = SystemClock.uptimeMillis();
    localMqqHandler.postAtTime(local1, parambesc, i * 35000L + l);
    ((berz)localObject).a(parambesc, parambesg);
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
            if (!paramString3.contains("com.tencent.widget.soload")) {
              continue;
            }
            paramString2 = (String)localObject;
          }
        }
        Object localObject = BaseApplicationImpl.processName;
        paramString1 = "process:" + (String)localObject + "msg:" + paramString1 + paramString3;
        if (!TextUtils.isEmpty(str))
        {
          VACDReportUtil.a(null, "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
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
  
  private static void b(besc parambesc)
  {
    synchronized (b)
    {
      b.remove(parambesc);
      return;
    }
  }
  
  public void a(String paramString, besg parambesg, besa parambesa)
  {
    besc localbesc = new besc();
    localbesc.jdField_a_of_type_JavaUtilList.add(new besd(paramString, parambesa));
    a(localbesc, parambesg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besi
 * JD-Core Version:    0.7.0.1
 */