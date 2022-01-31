import android.app.PendingIntent;
import android.location.Criteria;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Member;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class azsp
  extends azsl
  implements HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 900000L;
  private LocationManager jdField_a_of_type_AndroidLocationLocationManager = (LocationManager)BaseApplicationImpl.getApplication().getSystemService("location");
  private azsz jdField_a_of_type_Azsz = new azsz(this.jdField_a_of_type_Int, this.jdField_a_of_type_Long);
  private String jdField_a_of_type_JavaLangString;
  private Map<String, HashSet<Long>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 18000000L;
  private azsz jdField_b_of_type_Azsz = new azsz(this.jdField_b_of_type_Int, this.jdField_b_of_type_Long);
  private Map<String, HashSet<Long>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private Map<String, HashSet<Long>> c;
  private Map<String, HashSet<Long>> d;
  
  public azsp(azsk paramazsk, String paramString)
  {
    super(paramazsk, paramString);
    this.jdField_c_of_type_JavaUtilMap = new HashMap();
    this.jdField_d_of_type_JavaUtilMap = new HashMap();
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
  
  private int a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps");
      if (bool) {
        return 1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryStats", 2, "", localThrowable);
      }
    }
    return -1;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int i = paramBundle.getInt("key_action");
    if ((i == 1) || (i == 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryStats", 2, new Object[] { "GPS.onOtherProcReport:action=", i + ", type=", paramBundle.getString("key_type"), ", stack=", paramBundle.getString("key_stack") });
      }
      if ((azsk.a()) && (this.jdField_a_of_type_Boolean))
      {
        Map localMap2 = this.jdField_a_of_type_JavaUtilMap;
        if (i == 1) {}
        try
        {
          paramBundle = paramBundle.getString("key_type");
          label139:
          HashSet localHashSet2;
          HashSet localHashSet1;
          if (this.jdField_b_of_type_Boolean)
          {
            if (i == 1)
            {
              localMap1 = this.jdField_a_of_type_JavaUtilMap;
              localHashSet2 = (HashSet)localMap1.get(paramBundle);
              localHashSet1 = localHashSet2;
              if (localHashSet2 == null)
              {
                localHashSet1 = new HashSet();
                localMap1.put(paramBundle, localHashSet1);
              }
              localHashSet1.add(Long.valueOf(System.currentTimeMillis()));
            }
          }
          else if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
            if (i != 1) {
              break label289;
            }
          }
          label289:
          for (Map localMap1 = this.jdField_c_of_type_JavaUtilMap;; localMap1 = this.jdField_d_of_type_JavaUtilMap)
          {
            localHashSet2 = (HashSet)localMap1.get(paramBundle);
            localHashSet1 = localHashSet2;
            if (localHashSet2 == null)
            {
              localHashSet1 = new HashSet();
              localMap1.put(paramBundle, localHashSet1);
            }
            localHashSet1.add(Long.valueOf(System.currentTimeMillis()));
            return;
            paramBundle = paramBundle.getString("key_stack");
            break;
            localMap1 = this.jdField_b_of_type_JavaUtilMap;
            break label139;
          }
          return;
        }
        finally {}
      }
    }
  }
  
  public void a(String paramString, Object[] paramArrayOfObject)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    String str3;
    do
    {
      return;
      str3 = azsk.a().toString();
      if (QLog.isColorLevel()) {
        azsk.a(this.jdField_b_of_type_Azsk, "onGPSScan: " + str3);
      }
      if (this.jdField_a_of_type_JavaLangString == null) {
        this.jdField_a_of_type_JavaLangString = SosoInterface.class.getPackage().getName();
      }
    } while ((("requestLocationUpdates".equals(paramString)) || ("requestSingleUpdate".equals(paramString))) && (str3.contains(this.jdField_a_of_type_JavaLangString)));
    String str4 = "location|" + a() + "|";
    if ("requestLocationUpdates".equals(paramString)) {
      if (paramArrayOfObject.length == 5) {
        if ((paramArrayOfObject[2] instanceof Criteria))
        {
          azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str3 });
          label321:
          paramString = new Bundle();
          paramString.putInt("key_action", 2);
          paramString.putString("key_stack", str3);
          if (azsk.a()) {
            break label1088;
          }
          azsf.a().a(paramString);
        }
      }
    }
    for (;;)
    {
      paramString = this.jdField_a_of_type_Azsz.a(str3);
      if ((paramString != null) && (paramString.size() > 0))
      {
        azsk.a(this.jdField_b_of_type_Azsk, 6, 0, 0, "GPS request update is too frequently(" + this.jdField_a_of_type_Int + " in " + this.jdField_a_of_type_Long / 60L / 1000L + " seconds", azsz.a(paramString));
        this.jdField_a_of_type_Azsz.a();
      }
      paramString = this.jdField_b_of_type_Azsz.a(str3);
      if ((paramString == null) || (paramString.size() <= 0)) {
        break;
      }
      azsk.a(this.jdField_b_of_type_Azsk, 6, 0, 0, "Wifi scan is too frequently(" + this.jdField_b_of_type_Int + " in " + this.jdField_b_of_type_Long / 60L / 1000L + " seconds", azsz.a(paramString));
      this.jdField_b_of_type_Azsz.a();
      return;
      if ((paramArrayOfObject[0] instanceof String))
      {
        azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "1", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str3 });
        break label321;
      }
      azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "-1", "|", "{}", "|", str3 });
      break label321;
      if (paramArrayOfObject.length != 6) {
        break label321;
      }
      if ((paramArrayOfObject[2] instanceof Criteria))
      {
        azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "2", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", "[", this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)paramArrayOfObject[2], true), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[2]).getPowerRequirement()), "]", "}", "|", str3 });
        break label321;
      }
      if ((paramArrayOfObject[0] instanceof String))
      {
        azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "3", "|", "{", paramArrayOfObject[0].toString(), "#", paramArrayOfObject[1].toString(), "#", paramArrayOfObject[2].toString(), "}", "|", str3 });
        break label321;
      }
      azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "0", "|", "-1", "|", "{}", "|", str3 });
      break label321;
      label1088:
      a(paramString);
      continue;
      if ("requestSingleUpdate".equals(paramString))
      {
        if ((paramArrayOfObject[0] instanceof String)) {
          azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "1", "|", "0", "|", "{", paramArrayOfObject[0].toString(), "}", "|", str3 });
        }
        for (;;)
        {
          paramString = new Bundle();
          paramString.putInt("key_action", 2);
          paramString.putString("key_stack", str3);
          if (azsk.a()) {
            break label1437;
          }
          azsf.a().a(paramString);
          break;
          if ((paramArrayOfObject[0] instanceof Criteria)) {
            azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "1", "|", "1", "|", "{", "[", this.jdField_a_of_type_AndroidLocationLocationManager.getBestProvider((Criteria)paramArrayOfObject[0], true), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getAccuracy()), ",", String.valueOf(((Criteria)paramArrayOfObject[0]).getPowerRequirement()), "]", "}", "|", str3 });
          } else {
            azsk.a(this.jdField_b_of_type_Azsk, new String[] { str4, "1", "|", "-1", "|", "{}", "|", str3 });
          }
        }
        label1437:
        a(paramString);
      }
      else if ("requestSoso".equals(paramString))
      {
        label1465:
        azsk localazsk;
        String str5;
        String str6;
        String str1;
        if (paramArrayOfObject[2] == null)
        {
          paramString = "none";
          localazsk = this.jdField_b_of_type_Azsk;
          str5 = paramArrayOfObject[0].toString();
          str6 = paramArrayOfObject[1].toString();
          if (paramArrayOfObject[3] != null) {
            break label1684;
          }
          str1 = "-1";
          label1497:
          if (paramArrayOfObject[4] != null) {
            break label1694;
          }
        }
        label1684:
        label1694:
        for (String str2 = "-1";; str2 = paramArrayOfObject[4].toString())
        {
          azsk.a(localazsk, new String[] { str4, "2", "|", "0", "|", "{", str5, "#", str6, "#", paramString, "#", str1, "#", str2, "#", paramArrayOfObject[5].toString(), "}", "|", str3 });
          paramArrayOfObject = new Bundle();
          paramArrayOfObject.putInt("key_action", 1);
          paramArrayOfObject.putString("key_type", paramString);
          if (azsk.a()) {
            break label1705;
          }
          azsf.a().a(paramArrayOfObject);
          break;
          paramString = paramArrayOfObject[2].toString();
          break label1465;
          str1 = paramArrayOfObject[3].toString();
          break label1497;
        }
        label1705:
        a(paramArrayOfObject);
      }
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam) {}
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_c_of_type_JavaUtilMap.clear();
      this.jdField_d_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    a(paramMethodHookParam.method.getName(), paramMethodHookParam.args);
  }
  
  public void d()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      try
      {
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, LocationListener.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, LocationListener.class, Looper.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { String.class, Long.TYPE, Float.TYPE, PendingIntent.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { Long.TYPE, Float.TYPE, Criteria.class, LocationListener.class, Looper.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestLocationUpdates", new Object[] { Long.TYPE, Float.TYPE, Criteria.class, PendingIntent.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { String.class, PendingIntent.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { String.class, LocationListener.class, Looper.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { Criteria.class, LocationListener.class, Looper.class, this });
        JavaHookBridge.findAndHookMethod(LocationManager.class, "requestSingleUpdate", new Object[] { Criteria.class, PendingIntent.class, this });
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("BatteryStats", 2, "", localThrowable);
  }
  
  public void e()
  {
    super.e();
    if ((this.jdField_a_of_type_Boolean) && (azsk.a())) {}
    label518:
    for (;;)
    {
      String str;
      Object localObject2;
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_a_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        localIterator1 = this.jdField_b_of_type_JavaUtilMap.values().iterator();
        int j = 0;
        if (localIterator1.hasNext())
        {
          j = ((HashSet)localIterator1.next()).size() + j;
          continue;
        }
        azsk.b(this.jdField_b_of_type_Azsk, new String[] { "fg30SdkCount", "|", String.valueOf(i) });
        if (azsk.b(this.jdField_b_of_type_Azsk)) {
          azsk.b(this.jdField_b_of_type_Azsk, new String[] { "fg30SysCount", "|", String.valueOf(j) });
        }
        localIterator1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.jdField_a_of_type_JavaUtilMap.get(str);
          localObject3 = azsh.a();
          Iterator localIterator3 = ((HashSet)localObject2).iterator();
          i = 0;
          if (localIterator3.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator3.next());
            i += 1;
            if (i >= ((HashSet)localObject2).size()) {
              break label518;
            }
            ((StringBuilder)localObject3).append("#");
            break label518;
          }
          azsk.b(this.jdField_b_of_type_Azsk, new String[] { "fg30SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
      }
      Iterator localIterator2 = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        str = (String)localIterator2.next();
        localObject3 = (HashSet)this.jdField_b_of_type_JavaUtilMap.get(str);
        localObject2 = azsh.a();
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next()).append("|");
        }
        azsk.b(this.jdField_b_of_type_Azsk, new String[] { "fg30SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
      }
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void f()
  {
    super.f();
    if ((this.jdField_a_of_type_Boolean) && (azsk.a())) {}
    label518:
    for (;;)
    {
      String str;
      Object localObject2;
      Object localObject3;
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        Iterator localIterator1 = this.jdField_c_of_type_JavaUtilMap.values().iterator();
        int i = 0;
        if (localIterator1.hasNext())
        {
          i = ((HashSet)localIterator1.next()).size() + i;
          continue;
        }
        localIterator1 = this.jdField_d_of_type_JavaUtilMap.values().iterator();
        int j = 0;
        if (localIterator1.hasNext())
        {
          j = ((HashSet)localIterator1.next()).size() + j;
          continue;
        }
        azsk.b(this.jdField_b_of_type_Azsk, new String[] { "bg5SdkCount", "|", String.valueOf(i) });
        if (azsk.b(this.jdField_b_of_type_Azsk)) {
          azsk.b(this.jdField_b_of_type_Azsk, new String[] { "bg5SysCount", "|", String.valueOf(j) });
        }
        localIterator1 = this.jdField_c_of_type_JavaUtilMap.keySet().iterator();
        if (localIterator1.hasNext())
        {
          str = (String)localIterator1.next();
          localObject2 = (HashSet)this.jdField_c_of_type_JavaUtilMap.get(str);
          localObject3 = azsh.a();
          Iterator localIterator3 = ((HashSet)localObject2).iterator();
          i = 0;
          if (localIterator3.hasNext())
          {
            ((StringBuilder)localObject3).append((Long)localIterator3.next());
            i += 1;
            if (i >= ((HashSet)localObject2).size()) {
              break label518;
            }
            ((StringBuilder)localObject3).append("#");
            break label518;
          }
          azsk.b(this.jdField_b_of_type_Azsk, new String[] { "bg5SdkDetail", "|", str, "|", ((StringBuilder)localObject3).toString() });
        }
      }
      Iterator localIterator2 = this.jdField_d_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        str = (String)localIterator2.next();
        localObject3 = (HashSet)this.jdField_d_of_type_JavaUtilMap.get(str);
        localObject2 = azsh.a();
        localObject3 = ((HashSet)localObject3).iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next()).append("|");
        }
        azsk.b(this.jdField_b_of_type_Azsk, new String[] { "bg5SysDetail", "|", str, "|", ((StringBuilder)localObject2).toString() });
      }
      this.jdField_c_of_type_JavaUtilMap.clear();
      this.jdField_d_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azsp
 * JD-Core Version:    0.7.0.1
 */