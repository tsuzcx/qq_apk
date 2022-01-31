import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class axtb
  extends axsq
  implements HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 900000L;
  private axte jdField_a_of_type_Axte = new axte(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  private HashMap<WeakReference<WifiManager.WifiLock>, axtd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 18000000L;
  private axte jdField_b_of_type_Axte = new axte(this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
  private HashMap<String, axtc> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, axtc> c;
  private HashMap<String, HashSet<Long>> d;
  private HashMap<String, HashSet<Long>> e = new HashMap();
  
  public axtb(axsp paramaxsp, String paramString)
  {
    super(paramaxsp, paramString);
    this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 2))
    {
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue();
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][1]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 2))
    {
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue();
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][1]).intValue() * 60 * 1000L);
    }
  }
  
  private final void a(axtd paramaxtd, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramaxtd.c);
    localBundle.putString("key_tag", paramaxtd.b);
    if (paramInt == 9) {
      localBundle.putLong("key_duration", SystemClock.uptimeMillis() - paramaxtd.jdField_a_of_type_Long);
    }
    if (!axsp.a())
    {
      axsk.a().a(localBundle);
      return;
    }
    a(localBundle);
  }
  
  private final void a(boolean paramBoolean)
  {
    HashMap localHashMap2 = this.jdField_b_of_type_JavaUtilHashMap;
    long l = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int j;
      try
      {
        HashMap localHashMap1 = this.jdField_b_of_type_JavaUtilHashMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axtc)((Iterator)localObject2).next();
          j = ((axtc)localObject3).jdField_a_of_type_JavaUtilHashSet.size();
          localObject3 = ((axtc)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label443;
          }
          l = ((Long)((Pair)((Iterator)localObject3).next()).second).longValue() + l;
          continue;
          localHashMap1 = this.jdField_c_of_type_JavaUtilHashMap;
          continue;
        }
        localObject3 = this.jdField_b_of_type_Axsp;
        if (!paramBoolean) {
          break label453;
        }
        localObject2 = "fg30WFLCount";
        axsp.b((axsp)localObject3, new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l), "|0" });
        Iterator localIterator = localHashMap1.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label434;
        }
        String str = (String)localIterator.next();
        localObject3 = (axtc)localHashMap1.get(str);
        StringBuilder localStringBuilder = axsm.a();
        localObject2 = ((axtc)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject4).first)).append(",").append(String.valueOf(((Pair)localObject4).second));
          i += 1;
          if (i >= ((axtc)localObject3).jdField_a_of_type_JavaUtilHashSet.size()) {
            break label450;
          }
          localStringBuilder.append("#");
          break label450;
        }
        Object localObject4 = this.jdField_b_of_type_Axsp;
        if (paramBoolean)
        {
          localObject2 = "fg30WFLDetail";
          if (((axtc)localObject3).jdField_a_of_type_JavaLangString != null) {
            break label417;
          }
          localObject3 = "";
          axsp.b((axsp)localObject4, new String[] { localObject2, "|", localObject3, "|0|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WFSDetail";
      }
      finally {}
      continue;
      label417:
      Object localObject3 = ((axtc)localObject3).jdField_a_of_type_JavaLangString.replace("|", "_");
      continue;
      label434:
      localObject1.clear();
      return;
      label443:
      int i = j + i;
      continue;
      label450:
      continue;
      label453:
      Object localObject2 = "bg5WFLCount";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (!this.jdField_a_of_type_Boolean) {}
    int i;
    String str;
    do
    {
      return;
      i = paramBundle.getInt("key_action");
      str = paramBundle.getString("key_stack");
      ??? = paramBundle.getString("key_tag");
      long l = paramBundle.getLong("key_duration");
      Object localObject1;
      if (i == 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BatteryStats", 2, new Object[] { "WiFi.onOtherProcReport: scan:", str });
        }
        synchronized (this.jdField_d_of_type_JavaUtilHashMap)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = (HashSet)this.jdField_d_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.jdField_d_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localObject1 = (HashSet)this.e.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new HashSet();
              this.e.put(str, paramBundle);
            }
            paramBundle.add(Long.valueOf(System.currentTimeMillis()));
          }
          return;
        }
      }
      if (i == 9) {
        synchronized (this.jdField_b_of_type_JavaUtilHashMap)
        {
          if (this.jdField_b_of_type_Boolean)
          {
            localObject1 = (axtc)this.jdField_b_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new axtc(this, null);
              paramBundle.jdField_a_of_type_JavaLangString = ((String)???);
              paramBundle.b = str;
              this.jdField_b_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localObject1 = (axtc)this.jdField_c_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new axtc(this, null);
              paramBundle.jdField_a_of_type_JavaLangString = ((String)???);
              paramBundle.b = str;
              this.jdField_c_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          return;
        }
      }
    } while (i != 10);
    axsp.b(this.jdField_b_of_type_Axsp, new String[] { "wflNotRelease", "|", str, "|", ???, "|0|0" });
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str;
    label235:
    do
    {
      return;
      for (;;)
      {
        WeakReference localWeakReference;
        axtd localaxtd;
        try
        {
          str = axsp.a().toString();
          if (!"release".equals(paramMethodHookParam.method.getName())) {
            break label289;
          }
          synchronized (this.jdField_a_of_type_JavaUtilHashMap)
          {
            localObject2 = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
            if (!((Iterator)localObject2).hasNext()) {
              break label286;
            }
            localWeakReference = (WeakReference)((Iterator)localObject2).next();
            localaxtd = (axtd)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
            if (localWeakReference.get() != paramMethodHookParam.thisObject) {
              break label235;
            }
            axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_rl|", localaxtd.jdField_a_of_type_JavaLangString, "|", str });
            if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld())
            {
              axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_time|", localaxtd.jdField_a_of_type_JavaLangString, "|", String.valueOf(SystemClock.uptimeMillis() - localaxtd.jdField_a_of_type_Long) });
              ((Iterator)localObject2).remove();
            }
            a(localaxtd, 9);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
        }
        catch (Throwable paramMethodHookParam) {}
        QLog.d("BatteryStats", 2, "", paramMethodHookParam);
        return;
        if (localWeakReference.get() == null)
        {
          axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_alarm|", localaxtd.jdField_a_of_type_JavaLangString });
          ((Iterator)localObject2).remove();
          a(localaxtd, 10);
        }
      }
      return;
    } while (!"createWifiLock".equals(paramMethodHookParam.method.getName()));
    label286:
    label289:
    ??? = new WeakReference((WifiManager.WifiLock)paramMethodHookParam.result);
    Object localObject2 = new axtd(this, null);
    ((axtd)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(localObject2.hashCode());
    ((axtd)localObject2).c = str;
    if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 2)) {}
    for (((axtd)localObject2).b = ((String)paramMethodHookParam.args[1]);; ((axtd)localObject2).b = ((String)paramMethodHookParam.args[0])) {
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(???, localObject2);
        if (paramMethodHookParam.args.length != 1) {
          break;
        }
        axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_new|", ((axtd)localObject2).jdField_a_of_type_JavaLangString, "|0|", String.valueOf(paramMethodHookParam.args[0]) });
        return;
      } while ((paramMethodHookParam.args == null) || (paramMethodHookParam.args.length != 1));
    }
    axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_new|", ((axtd)localObject2).jdField_a_of_type_JavaLangString, "|", String.valueOf(paramMethodHookParam.args[0]), "|", String.valueOf(paramMethodHookParam.args[1]) });
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_d_of_type_JavaUtilHashMap)
    {
      this.e.clear();
    }
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str;
    label345:
    do
    {
      do
      {
        return;
        try
        {
          str = axsp.a().toString();
          if (QLog.isColorLevel()) {
            axsp.a(this.jdField_b_of_type_Axsp, paramMethodHookParam.method.getName() + str);
          }
          if (!"startScan".equals(paramMethodHookParam.method.getName())) {
            break label345;
          }
          axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wfScan", "|", str });
          paramMethodHookParam = this.jdField_a_of_type_Axte.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            axsp.a(this.jdField_b_of_type_Axsp, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_a_of_type_Int + " in " + this.jdField_a_of_type_Long / 60L / 1000L + " seconds", axte.a(paramMethodHookParam));
            this.jdField_a_of_type_Axte.a();
          }
          paramMethodHookParam = this.jdField_b_of_type_Axte.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            axsp.a(this.jdField_b_of_type_Axsp, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_b_of_type_Int + " in " + this.jdField_b_of_type_Long / 60L / 1000L + " seconds", axte.a(paramMethodHookParam));
            this.jdField_b_of_type_Axte.a();
          }
          paramMethodHookParam = new Bundle();
          paramMethodHookParam.putInt("key_action", 8);
          paramMethodHookParam.putString("key_stack", str);
          if (axsp.a()) {
            break;
          }
          axsk.a().a(paramMethodHookParam);
          return;
        }
        catch (Throwable paramMethodHookParam) {}
      } while (!QLog.isColorLevel());
      QLog.d("BatteryStats", 2, "", paramMethodHookParam);
      return;
      a(paramMethodHookParam);
      return;
    } while (!"acquire".equals(paramMethodHookParam.method.getName()));
    for (;;)
    {
      Iterator localIterator;
      WeakReference localWeakReference;
      axtd localaxtd;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        localaxtd = (axtd)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
        if (localWeakReference.get() == paramMethodHookParam.thisObject)
        {
          axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_ac|", localaxtd.jdField_a_of_type_JavaLangString, "|", str });
          if (((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld()) {
            continue;
          }
          localaxtd.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
      }
      if (localWeakReference.get() == null)
      {
        axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wf_alarm|", localaxtd.jdField_a_of_type_JavaLangString });
        localIterator.remove();
      }
    }
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JavaHookBridge.findAndHookMethod(WifiManager.class, "startScan", new Object[] { this });
        JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { Integer.TYPE, String.class, this });
        JavaHookBridge.findAndHookMethod(WifiManager.class, "createWifiLock", new Object[] { String.class, this });
        JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "acquire", new Object[] { this });
        JavaHookBridge.findAndHookMethod(WifiManager.WifiLock.class, "release", new Object[] { this });
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("BatteryStats", 2, "", localThrowable);
  }
  
  public void e()
  {
    super.e();
    if ((axsp.a()) && (this.jdField_a_of_type_Boolean) && (axsp.b(this.jdField_b_of_type_Axsp))) {}
    label279:
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        Iterator localIterator1 = this.jdField_d_of_type_JavaUtilHashMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        axsp.b(this.jdField_b_of_type_Axsp, new String[] { "fg30WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = axsm.a();
          HashSet localHashSet = (HashSet)this.jdField_d_of_type_JavaUtilHashMap.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label279;
            }
            localStringBuilder.append("#");
            break label279;
          }
          axsp.b(this.jdField_b_of_type_Axsp, new String[] { "fg30WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.jdField_d_of_type_JavaUtilHashMap.clear();
      a(true);
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if ((axsp.a()) && (this.jdField_a_of_type_Boolean) && (axsp.b(this.jdField_b_of_type_Axsp))) {}
    label278:
    for (;;)
    {
      synchronized (this.jdField_d_of_type_JavaUtilHashMap)
      {
        Iterator localIterator1 = this.e.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        axsp.b(this.jdField_b_of_type_Axsp, new String[] { "bg5WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.e.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = axsm.a();
          HashSet localHashSet = (HashSet)this.e.get(str);
          Iterator localIterator2 = localHashSet.iterator();
          i = 0;
          if (localIterator2.hasNext())
          {
            localStringBuilder.append((Long)localIterator2.next());
            i += 1;
            if (i >= localHashSet.size()) {
              break label278;
            }
            localStringBuilder.append("#");
            break label278;
          }
          axsp.b(this.jdField_b_of_type_Axsp, new String[] { "bg5WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.e.clear();
      a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axtb
 * JD-Core Version:    0.7.0.1
 */