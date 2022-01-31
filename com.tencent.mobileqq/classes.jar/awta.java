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

class awta
  extends awsp
  implements HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 900000L;
  private awtd jdField_a_of_type_Awtd = new awtd(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  private HashMap<WeakReference<WifiManager.WifiLock>, awtc> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 18000000L;
  private awtd jdField_b_of_type_Awtd = new awtd(this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
  private HashMap<String, awtb> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private HashMap<String, awtb> c;
  private HashMap<String, HashSet<Long>> d;
  private HashMap<String, HashSet<Long>> e = new HashMap();
  
  public awta(awso paramawso, String paramString)
  {
    super(paramawso, paramString);
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
  
  private final void a(awtc paramawtc, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramawtc.c);
    localBundle.putString("key_tag", paramawtc.b);
    if (paramInt == 9) {
      localBundle.putLong("key_duration", SystemClock.uptimeMillis() - paramawtc.jdField_a_of_type_Long);
    }
    if (!awso.a())
    {
      awsj.a().a(localBundle);
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
          localObject3 = (awtb)((Iterator)localObject2).next();
          j = ((awtb)localObject3).jdField_a_of_type_JavaUtilHashSet.size();
          localObject3 = ((awtb)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label443;
          }
          l = ((Long)((Pair)((Iterator)localObject3).next()).second).longValue() + l;
          continue;
          localHashMap1 = this.jdField_c_of_type_JavaUtilHashMap;
          continue;
        }
        localObject3 = this.jdField_b_of_type_Awso;
        if (!paramBoolean) {
          break label453;
        }
        localObject2 = "fg30WFLCount";
        awso.b((awso)localObject3, new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l), "|0" });
        Iterator localIterator = localHashMap1.keySet().iterator();
        if (!localIterator.hasNext()) {
          break label434;
        }
        String str = (String)localIterator.next();
        localObject3 = (awtb)localHashMap1.get(str);
        StringBuilder localStringBuilder = awsl.a();
        localObject2 = ((awtb)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject4).first)).append(",").append(String.valueOf(((Pair)localObject4).second));
          i += 1;
          if (i >= ((awtb)localObject3).jdField_a_of_type_JavaUtilHashSet.size()) {
            break label450;
          }
          localStringBuilder.append("#");
          break label450;
        }
        Object localObject4 = this.jdField_b_of_type_Awso;
        if (paramBoolean)
        {
          localObject2 = "fg30WFLDetail";
          if (((awtb)localObject3).jdField_a_of_type_JavaLangString != null) {
            break label417;
          }
          localObject3 = "";
          awso.b((awso)localObject4, new String[] { localObject2, "|", localObject3, "|0|", str, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WFSDetail";
      }
      finally {}
      continue;
      label417:
      Object localObject3 = ((awtb)localObject3).jdField_a_of_type_JavaLangString.replace("|", "_");
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
            localObject1 = (awtb)this.jdField_b_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new awtb(this, null);
              paramBundle.jdField_a_of_type_JavaLangString = ((String)???);
              paramBundle.b = str;
              this.jdField_b_of_type_JavaUtilHashMap.put(str, paramBundle);
            }
            paramBundle.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(l)));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
          {
            localObject1 = (awtb)this.jdField_c_of_type_JavaUtilHashMap.get(str);
            paramBundle = (Bundle)localObject1;
            if (localObject1 == null)
            {
              paramBundle = new awtb(this, null);
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
    awso.b(this.jdField_b_of_type_Awso, new String[] { "wflNotRelease", "|", str, "|", ???, "|0|0" });
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
        awtc localawtc;
        try
        {
          str = awso.a().toString();
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
            localawtc = (awtc)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
            if (localWeakReference.get() != paramMethodHookParam.thisObject) {
              break label235;
            }
            awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_rl|", localawtc.jdField_a_of_type_JavaLangString, "|", str });
            if (!((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld())
            {
              awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_time|", localawtc.jdField_a_of_type_JavaLangString, "|", String.valueOf(SystemClock.uptimeMillis() - localawtc.jdField_a_of_type_Long) });
              ((Iterator)localObject2).remove();
            }
            a(localawtc, 9);
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
          awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_alarm|", localawtc.jdField_a_of_type_JavaLangString });
          ((Iterator)localObject2).remove();
          a(localawtc, 10);
        }
      }
      return;
    } while (!"createWifiLock".equals(paramMethodHookParam.method.getName()));
    label286:
    label289:
    ??? = new WeakReference((WifiManager.WifiLock)paramMethodHookParam.result);
    Object localObject2 = new awtc(this, null);
    ((awtc)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(localObject2.hashCode());
    ((awtc)localObject2).c = str;
    if ((paramMethodHookParam.args != null) && (paramMethodHookParam.args.length == 2)) {}
    for (((awtc)localObject2).b = ((String)paramMethodHookParam.args[1]);; ((awtc)localObject2).b = ((String)paramMethodHookParam.args[0])) {
      do
      {
        this.jdField_a_of_type_JavaUtilHashMap.put(???, localObject2);
        if (paramMethodHookParam.args.length != 1) {
          break;
        }
        awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_new|", ((awtc)localObject2).jdField_a_of_type_JavaLangString, "|0|", String.valueOf(paramMethodHookParam.args[0]) });
        return;
      } while ((paramMethodHookParam.args == null) || (paramMethodHookParam.args.length != 1));
    }
    awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_new|", ((awtc)localObject2).jdField_a_of_type_JavaLangString, "|", String.valueOf(paramMethodHookParam.args[0]), "|", String.valueOf(paramMethodHookParam.args[1]) });
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
          str = awso.a().toString();
          if (QLog.isColorLevel()) {
            awso.a(this.jdField_b_of_type_Awso, paramMethodHookParam.method.getName() + str);
          }
          if (!"startScan".equals(paramMethodHookParam.method.getName())) {
            break label345;
          }
          awso.a(this.jdField_b_of_type_Awso, new String[] { "wfScan", "|", str });
          paramMethodHookParam = this.jdField_a_of_type_Awtd.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            awso.a(this.jdField_b_of_type_Awso, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_a_of_type_Int + " in " + this.jdField_a_of_type_Long / 60L / 1000L + " seconds", awtd.a(paramMethodHookParam));
            this.jdField_a_of_type_Awtd.a();
          }
          paramMethodHookParam = this.jdField_b_of_type_Awtd.a(str);
          if ((paramMethodHookParam != null) && (paramMethodHookParam.size() > 0))
          {
            awso.a(this.jdField_b_of_type_Awso, 5, 0, 0, "Wifi scan is too frequently(" + this.jdField_b_of_type_Int + " in " + this.jdField_b_of_type_Long / 60L / 1000L + " seconds", awtd.a(paramMethodHookParam));
            this.jdField_b_of_type_Awtd.a();
          }
          paramMethodHookParam = new Bundle();
          paramMethodHookParam.putInt("key_action", 8);
          paramMethodHookParam.putString("key_stack", str);
          if (awso.a()) {
            break;
          }
          awsj.a().a(paramMethodHookParam);
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
      awtc localawtc;
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        localawtc = (awtc)this.jdField_a_of_type_JavaUtilHashMap.get(localWeakReference);
        if (localWeakReference.get() == paramMethodHookParam.thisObject)
        {
          awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_ac|", localawtc.jdField_a_of_type_JavaLangString, "|", str });
          if (((WifiManager.WifiLock)paramMethodHookParam.thisObject).isHeld()) {
            continue;
          }
          localawtc.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        }
      }
      if (localWeakReference.get() == null)
      {
        awso.a(this.jdField_b_of_type_Awso, new String[] { "wf_alarm|", localawtc.jdField_a_of_type_JavaLangString });
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
    if ((awso.a()) && (this.jdField_a_of_type_Boolean) && (awso.b(this.jdField_b_of_type_Awso))) {}
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
        awso.b(this.jdField_b_of_type_Awso, new String[] { "fg30WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.jdField_d_of_type_JavaUtilHashMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = awsl.a();
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
          awso.b(this.jdField_b_of_type_Awso, new String[] { "fg30WFSDetail", "|", str, "|", localStringBuilder.toString() });
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
    if ((awso.a()) && (this.jdField_a_of_type_Boolean) && (awso.b(this.jdField_b_of_type_Awso))) {}
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
        awso.b(this.jdField_b_of_type_Awso, new String[] { "bg5WFSCount", "|", String.valueOf(i) });
        localIterator1 = this.e.keySet().iterator();
        if (localIterator1.hasNext())
        {
          String str = (String)localIterator1.next();
          StringBuilder localStringBuilder = awsl.a();
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
          awso.b(this.jdField_b_of_type_Awso, new String[] { "bg5WFSDetail", "|", str, "|", localStringBuilder.toString() });
        }
      }
      this.e.clear();
      a(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awta
 * JD-Core Version:    0.7.0.1
 */