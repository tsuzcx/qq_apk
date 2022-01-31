import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class axng
{
  private static volatile axng jdField_a_of_type_Axng;
  private static final Map<axna, axmx> b = new HashMap();
  private final Map<axna, List<axne>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static axmx a(axna paramaxna)
  {
    if (paramaxna.jdField_a_of_type_JavaUtilList.size() > 1) {
      return new axnc();
    }
    return new axmu();
  }
  
  private static axmx a(String paramString)
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
        localObject2 = (axmx)((Iterator)???).next();
        if ((localObject2 != null) && (((axmx)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private axna a(axna paramaxna, axne paramaxne)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        axna localaxna = (axna)localEntry.getKey();
        if ((localaxna != null) && (localaxna.a(paramaxna)))
        {
          ((List)localEntry.getValue()).add(paramaxne);
          return localaxna;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramaxne);
      this.jdField_a_of_type_JavaUtilMap.put(paramaxna, localObject);
      return null;
    }
  }
  
  private axne a(axna paramaxna, long paramLong)
  {
    return new axnh(this, paramaxna);
  }
  
  public static axng a()
  {
    if (jdField_a_of_type_Axng == null) {}
    try
    {
      if (jdField_a_of_type_Axng == null) {
        jdField_a_of_type_Axng = new axng();
      }
      return jdField_a_of_type_Axng;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = axmu.a().iterator();
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
  
  private static void a(axna paramaxna, axmx paramaxmx)
  {
    if ((paramaxna == null) || (paramaxmx == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramaxna, paramaxmx);
      return;
    }
  }
  
  private void a(axna paramaxna, axne paramaxne)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramaxna);
    }
    if ((paramaxna == null) || (paramaxna.jdField_a_of_type_JavaUtilList == null)) {}
    long l;
    for (int i = 0;; i = paramaxna.jdField_a_of_type_JavaUtilList.size())
    {
      l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", axna.a(paramaxna), i, null);
      paramaxne = new axni(paramaxne, l, paramaxna);
      if ((paramaxna != null) && (paramaxna.a())) {
        break;
      }
      paramaxne.onLoadResult(1, LoadExtResult.create(1, i, null));
      return;
    }
    paramaxne = a(paramaxna, paramaxne);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramaxne == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (paramaxne == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + paramaxne.jdField_a_of_type_Long, 0, null);
      return;
    }
    paramaxne = a(paramaxna, l);
    Object localObject = a(paramaxna);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramaxna, (axmx)localObject);
    paramaxna.jdField_a_of_type_Long = l;
    ((axmx)localObject).a(paramaxna, paramaxne);
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
          VACDReportUtil.a("ver=" + axmu.a(str), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
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
  
  private static void b(axna paramaxna)
  {
    synchronized (b)
    {
      b.remove(paramaxna);
      return;
    }
  }
  
  public void a(String paramString, axne paramaxne, axmy paramaxmy)
  {
    axna localaxna = new axna();
    localaxna.jdField_a_of_type_JavaUtilList.add(new axnb(paramString, paramaxmy));
    a(localaxna, paramaxne);
  }
  
  public void a(String[] paramArrayOfString, axne paramaxne)
  {
    a(paramArrayOfString, paramaxne, null);
  }
  
  public void a(String[] paramArrayOfString, axne paramaxne, axmy[] paramArrayOfaxmy)
  {
    axna localaxna = new axna();
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
          if ((paramArrayOfaxmy != null) && (paramArrayOfaxmy.length > i)) {}
          for (axmy localaxmy = paramArrayOfaxmy[i];; localaxmy = null)
          {
            localaxna.jdField_a_of_type_JavaUtilList.add(new axnb(str, localaxmy));
            break;
          }
        }
      }
    }
    a(localaxna, paramaxne);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axng
 * JD-Core Version:    0.7.0.1
 */