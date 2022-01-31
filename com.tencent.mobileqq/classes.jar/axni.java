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

public class axni
{
  private static volatile axni jdField_a_of_type_Axni;
  private static final Map<axnc, axmz> b = new HashMap();
  private final Map<axnc, List<axng>> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  private static axmz a(axnc paramaxnc)
  {
    if (paramaxnc.jdField_a_of_type_JavaUtilList.size() > 1) {
      return new axne();
    }
    return new axmw();
  }
  
  private static axmz a(String paramString)
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
        localObject2 = (axmz)((Iterator)???).next();
        if ((localObject2 != null) && (((axmz)localObject2).a(paramString))) {
          return localObject2;
        }
      }
    }
    return null;
  }
  
  private axnc a(axnc paramaxnc, axng paramaxng)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        axnc localaxnc = (axnc)localEntry.getKey();
        if ((localaxnc != null) && (localaxnc.a(paramaxnc)))
        {
          ((List)localEntry.getValue()).add(paramaxng);
          return localaxnc;
        }
      }
      localObject = new LinkedList();
      ((LinkedList)localObject).add(paramaxng);
      this.jdField_a_of_type_JavaUtilMap.put(paramaxnc, localObject);
      return null;
    }
  }
  
  private axng a(axnc paramaxnc, long paramLong)
  {
    return new axnj(this, paramaxnc);
  }
  
  public static axni a()
  {
    if (jdField_a_of_type_Axni == null) {}
    try
    {
      if (jdField_a_of_type_Axni == null) {
        jdField_a_of_type_Axni = new axni();
      }
      return jdField_a_of_type_Axni;
    }
    finally {}
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = axmw.a().iterator();
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
  
  private static void a(axnc paramaxnc, axmz paramaxmz)
  {
    if ((paramaxnc == null) || (paramaxmz == null)) {
      return;
    }
    synchronized (b)
    {
      b.put(paramaxnc, paramaxmz);
      return;
    }
  }
  
  private void a(axnc paramaxnc, axng paramaxng)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load loadParam=" + paramaxnc);
    }
    if ((paramaxnc == null) || (paramaxnc.jdField_a_of_type_JavaUtilList == null)) {}
    long l;
    for (int i = 0;; i = paramaxnc.jdField_a_of_type_JavaUtilList.size())
    {
      l = VACDReportUtil.a(null, "SoLoadModule", "SoLoad", "load.start", axnc.a(paramaxnc), i, null);
      paramaxng = new axnk(paramaxng, l, paramaxnc);
      if ((paramaxnc != null) && (paramaxnc.a())) {
        break;
      }
      paramaxng.onLoadResult(1, LoadExtResult.create(1, i, null));
      return;
    }
    paramaxng = a(paramaxnc, paramaxng);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramaxng == null) {
        break label199;
      }
    }
    label199:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("SoLoadWidget.SoLoadManager", 2, bool);
      if (paramaxng == null) {
        break;
      }
      VACDReportUtil.a(l, null, "load.join.same.queue", "first=" + paramaxng.jdField_a_of_type_Long, 0, null);
      return;
    }
    paramaxng = a(paramaxnc, l);
    Object localObject = a(paramaxnc);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoLoadManager", 2, "load getSoLoader=" + localObject);
    }
    a(paramaxnc, (axmz)localObject);
    paramaxnc.jdField_a_of_type_Long = l;
    ((axmz)localObject).a(paramaxnc, paramaxng);
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
          VACDReportUtil.a("ver=" + axmw.a(str), "SoLoadModule", "SoLoadSingle", "Exception", str, 2, paramString1);
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
  
  private static void b(axnc paramaxnc)
  {
    synchronized (b)
    {
      b.remove(paramaxnc);
      return;
    }
  }
  
  public void a(String paramString, axng paramaxng, axna paramaxna)
  {
    axnc localaxnc = new axnc();
    localaxnc.jdField_a_of_type_JavaUtilList.add(new axnd(paramString, paramaxna));
    a(localaxnc, paramaxng);
  }
  
  public void a(String[] paramArrayOfString, axng paramaxng)
  {
    a(paramArrayOfString, paramaxng, null);
  }
  
  public void a(String[] paramArrayOfString, axng paramaxng, axna[] paramArrayOfaxna)
  {
    axnc localaxnc = new axnc();
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
          if ((paramArrayOfaxna != null) && (paramArrayOfaxna.length > i)) {}
          for (axna localaxna = paramArrayOfaxna[i];; localaxna = null)
          {
            localaxnc.jdField_a_of_type_JavaUtilList.add(new axnd(str, localaxna));
            break;
          }
        }
      }
    }
    a(localaxnc, paramaxng);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axni
 * JD-Core Version:    0.7.0.1
 */