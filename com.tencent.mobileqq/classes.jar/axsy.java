import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Pair;
import com.tencent.mobileqq.app.ThreadManager;
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

class axsy
  extends axsq
  implements Handler.Callback, HookMethodCallback
{
  private int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = 30000L;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  private HashMap<WeakReference<PowerManager.WakeLock>, axta> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int jdField_b_of_type_Int = 10;
  private long jdField_b_of_type_Long = 600000L;
  private HashMap<String, axsz> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private long jdField_c_of_type_Long = 7200000L;
  private HashMap<String, axsz> jdField_c_of_type_JavaUtilHashMap = new HashMap();
  
  public axsy(axsp paramaxsp, String paramString)
  {
    super(paramaxsp, paramString);
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 1) && (this.jdField_a_of_type_Array2dOfJavaLangString[0].length >= 1))
    {
      this.jdField_a_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[0][0]).intValue() * 1000L);
      this.jdField_a_of_type_Long *= 10L;
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 2) && (this.jdField_a_of_type_Array2dOfJavaLangString[1].length >= 2))
    {
      this.jdField_a_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][0]).intValue();
      this.jdField_b_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[1][1]).intValue() * 60 * 1000L);
    }
    if ((this.jdField_a_of_type_Array2dOfJavaLangString.length >= 3) && (this.jdField_a_of_type_Array2dOfJavaLangString[2].length >= 2))
    {
      this.jdField_b_of_type_Int = Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][0]).intValue();
      this.jdField_c_of_type_Long = (Integer.valueOf(this.jdField_a_of_type_Array2dOfJavaLangString[2][1]).intValue() * 60 * 1000L);
    }
  }
  
  private final void a(axta paramaxta, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", paramInt);
    localBundle.putString("key_stack", paramaxta.b);
    localBundle.putString("key_tag", paramaxta.jdField_a_of_type_JavaLangString);
    localBundle.putInt("key_flag", paramaxta.jdField_a_of_type_Int);
    localBundle.putLong("key_time", paramaxta.a());
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
    long l2 = 0L;
    long l1 = 0L;
    if (paramBoolean) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        HashMap localHashMap1 = this.jdField_b_of_type_JavaUtilHashMap;
        localObject2 = localHashMap1.values().iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (axsz)((Iterator)localObject2).next();
          k = ((axsz)localObject3).jdField_a_of_type_JavaUtilHashSet.size();
          if ((((axsz)localObject3).jdField_a_of_type_Int & 0x1) <= 0) {
            break label506;
          }
          j = 1;
          localObject3 = ((axsz)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label511;
          }
          localObject4 = (Pair)((Iterator)localObject3).next();
          l2 += ((Long)((Pair)localObject4).second).longValue();
          if (j == 0) {
            break label503;
          }
          l1 = ((Long)((Pair)localObject4).second).longValue() + l1;
          break label503;
          localHashMap1 = this.jdField_c_of_type_JavaUtilHashMap;
          continue;
        }
        localObject3 = this.jdField_b_of_type_Axsp;
        if (!paramBoolean) {
          break label522;
        }
        localObject2 = "fg30WlCount";
        axsp.b((axsp)localObject3, new String[] { localObject2, "|", String.valueOf(i), "|", String.valueOf(l2), "|", String.valueOf(l1) });
        Object localObject4 = localHashMap1.keySet().iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break label494;
        }
        String str1 = (String)((Iterator)localObject4).next();
        localObject3 = (axsz)localHashMap1.get(str1);
        StringBuilder localStringBuilder = axsm.a();
        localObject2 = ((axsz)localObject3).jdField_a_of_type_JavaUtilHashSet.iterator();
        i = 0;
        if (((Iterator)localObject2).hasNext())
        {
          localObject5 = (Pair)((Iterator)localObject2).next();
          localStringBuilder.append(String.valueOf(((Pair)localObject5).first)).append(",").append(String.valueOf(((Pair)localObject5).second));
          i += 1;
          if (i >= ((axsz)localObject3).jdField_a_of_type_JavaUtilHashSet.size()) {
            break label519;
          }
          localStringBuilder.append("#");
          break label519;
        }
        Object localObject5 = this.jdField_b_of_type_Axsp;
        if (paramBoolean)
        {
          localObject2 = "fg30WlUse";
          String str2 = ((axsz)localObject3).jdField_a_of_type_JavaLangString.replace("|", "_");
          if ((((axsz)localObject3).jdField_a_of_type_Int & 0x1) <= 0) {
            break label529;
          }
          localObject3 = "1";
          axsp.b((axsp)localObject5, new String[] { localObject2, "|", str2, "|", localObject3, "|", str1, "|", localStringBuilder.toString() });
          continue;
        }
        localObject2 = "bg5WlUse";
      }
      finally {}
      continue;
      label494:
      localObject1.clear();
      return;
      label503:
      continue;
      label506:
      int j = 0;
      continue;
      label511:
      i += k;
      continue;
      label519:
      continue;
      label522:
      Object localObject2 = "bg5WlCount";
      continue;
      label529:
      Object localObject3 = "0";
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    int i = paramBundle.getInt("key_action");
    if ((this.jdField_a_of_type_Boolean) && ((i == 3) || (i == 4) || (i == 5)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BatteryStats", 2, new Object[] { "WakeLock.onOtherProcReport:action=", Integer.valueOf(i), ", tag=", paramBundle.getString("key_tag"), ", stack=", paramBundle.getString("key_stack"), ", time=", Long.valueOf(paramBundle.getLong("key_time")) });
      }
      String str = paramBundle.getString("key_stack");
      if (i == 3) {
        synchronized (this.jdField_b_of_type_JavaUtilHashMap)
        {
          axsz localaxsz2;
          axsz localaxsz1;
          if (this.jdField_b_of_type_Boolean)
          {
            localaxsz2 = (axsz)this.jdField_b_of_type_JavaUtilHashMap.get(str);
            localaxsz1 = localaxsz2;
            if (localaxsz2 == null)
            {
              localaxsz1 = new axsz(this, null);
              localaxsz1.jdField_a_of_type_Int = paramBundle.getInt("key_flag");
              localaxsz1.jdField_a_of_type_JavaLangString = paramBundle.getString("key_tag");
              this.jdField_b_of_type_JavaUtilHashMap.put(str, localaxsz1);
            }
            localaxsz1.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          if ((this.jdField_c_of_type_Boolean) && (this.d))
          {
            localaxsz2 = (axsz)this.jdField_c_of_type_JavaUtilHashMap.get(str);
            localaxsz1 = localaxsz2;
            if (localaxsz2 == null)
            {
              localaxsz1 = new axsz(this, null);
              localaxsz1.jdField_a_of_type_Int = paramBundle.getInt("key_flag");
              localaxsz1.jdField_a_of_type_JavaLangString = paramBundle.getString("key_tag");
              this.jdField_c_of_type_JavaUtilHashMap.put(str, localaxsz1);
            }
            localaxsz1.jdField_a_of_type_JavaUtilHashSet.add(new Pair(Long.valueOf(System.currentTimeMillis()), Long.valueOf(paramBundle.getLong("key_time"))));
          }
          return;
        }
      }
      if (i == 4)
      {
        axsp.b(this.jdField_b_of_type_Axsp, new String[] { "wlNotRelease", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
        return;
      }
      if (i == 5) {
        axsp.b(this.jdField_b_of_type_Axsp, new String[] { "wlTimeout", "|", paramBundle.getString("key_stack"), "|", paramBundle.getString("key_tag"), "|", paramBundle.getInt("key_flag") + "", "|", paramBundle.getLong("key_time") + "" });
      }
    }
  }
  
  public void a(String paramString, Object paramObject1, Object[] paramArrayOfObject, Object paramObject2)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      return;
    }
    Object localObject2;
    Object localObject3;
    label291:
    Object localObject4;
    label330:
    long l;
    label530:
    do
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_JavaUtilHashMap)
        {
          if ("newWakeLock".equals(paramString))
          {
            paramObject1 = new WeakReference((PowerManager.WakeLock)paramObject2);
            paramObject2 = new axta(this);
            paramObject2.jdField_a_of_type_Int = ((Integer)paramArrayOfObject[0]).intValue();
            paramObject2.jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject[1]);
            paramObject2.b = axsp.a().toString();
            paramObject2.c = String.valueOf(paramObject2.hashCode());
            this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, paramObject2);
            axsp.a(this.jdField_b_of_type_Axsp, new String[] { paramString, "|", paramObject2.c, "|", String.valueOf(paramObject2.jdField_a_of_type_Int), "|", paramObject2.jdField_a_of_type_JavaLangString, "|", paramObject2.b });
            return;
          }
        }
        if (!"acquire".equals(paramString)) {
          break;
        }
        paramObject2 = axsp.a().toString();
        localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (WeakReference)localIterator.next();
          localObject3 = (axta)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
          if (((WeakReference)localObject2).get() == paramObject1)
          {
            if (paramArrayOfObject == null) {
              break label1221;
            }
            if (paramArrayOfObject.length == 0)
            {
              break label1221;
              localObject4 = ((axta)localObject3).a(paramObject2);
              axsp localaxsp = this.jdField_b_of_type_Axsp;
              String str = ((axta)localObject3).c;
              if (!((Boolean)((Pair)localObject4).first).booleanValue()) {
                break label1229;
              }
              paramString = paramObject2;
              Object localObject1;
              axsp.a(localaxsp, new String[] { "wl_usg", "|", str, "|0|", paramString, "|", String.valueOf(((Pair)localObject4).second), "|", String.valueOf(localObject1) });
              paramString = ((axta)localObject3).a((PowerManager.WakeLock)paramObject1, paramObject2, localObject1);
              if (!((Boolean)paramString.first).booleanValue()) {
                break label530;
              }
              localObject4 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
              ((Message)localObject4).obj = localObject2;
              this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject4, this.jdField_a_of_type_Long);
            }
            for (;;)
            {
              if (paramString.second == null) {
                break label652;
              }
              axsp.a(this.jdField_b_of_type_Axsp, 4, 0, 0, "Acquire " + ((axta)localObject3).jdField_a_of_type_JavaLangString + " too frequently", axte.a((List)paramString.second));
              break;
              l = ((Long)paramArrayOfObject[0]).longValue();
              break label291;
              if (l >= this.jdField_a_of_type_Long)
              {
                axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wl_alm", "|", ((axta)localObject3).c, "|0|", String.valueOf(((Pair)localObject4).second) });
                axsp.a(this.jdField_b_of_type_Axsp, 4, 1, 0, "Acquire " + ((axta)localObject3).jdField_a_of_type_JavaLangString + " too long time", "CallStack: " + ((axta)localObject3).b);
              }
            }
          }
          else if (((WeakReference)localObject2).get() == null)
          {
            if (((axta)localObject3).a())
            {
              axsp.a(this.jdField_b_of_type_Axsp, 4, 2, 1, "WakeLock " + ((axta)localObject3).jdField_a_of_type_JavaLangString + " not release", "CreateStack: " + ((axta)localObject3).b);
              axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wl_alm", "|", ((axta)localObject3).c, "|1" });
              a((axta)localObject3, 4);
            }
            ((axta)localObject3).a();
            localIterator.remove();
          }
        }
      }
    } while (!"release".equals(paramString));
    label652:
    paramObject2 = axsp.a().toString();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    label824:
    label880:
    int i;
    if (localIterator.hasNext())
    {
      localObject2 = (WeakReference)localIterator.next();
      paramString = (axta)this.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if (((WeakReference)localObject2).get() == paramObject1)
      {
        if (paramArrayOfObject == null) {
          break label1236;
        }
        if (paramArrayOfObject.length == 0)
        {
          break label1236;
          localObject3 = paramString.a((PowerManager.WakeLock)paramObject1, i);
          if (((Boolean)((Pair)localObject3).first).booleanValue())
          {
            this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, localObject2);
            axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wl_tm", "|", paramString.c, "|", String.valueOf(((Pair)localObject3).second) });
            a(paramString, 3);
          }
          localObject2 = paramString.a(paramObject2);
          localObject3 = this.jdField_b_of_type_Axsp;
          localObject4 = paramString.c;
          if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
            break label1242;
          }
        }
      }
    }
    label1221:
    label1229:
    label1236:
    label1242:
    for (paramString = paramObject2;; paramString = "")
    {
      axsp.a((axsp)localObject3, new String[] { "wl_usg", "|", localObject4, "|1|", paramString, "|", String.valueOf(((Pair)localObject2).second), "|", String.valueOf(i) });
      break label824;
      i = ((Integer)paramArrayOfObject[0]).intValue();
      break label880;
      if (((WeakReference)localObject2).get() != null) {
        break label824;
      }
      if (paramString.a())
      {
        axsp.a(this.jdField_b_of_type_Axsp, 4, 2, 1, "WakeLock " + paramString.jdField_a_of_type_JavaLangString + " not release", "CreateStack: " + paramString.b);
        axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wl_alm", "|", paramString.c, "|1" });
        a(paramString, 4);
      }
      paramString.a();
      localIterator.remove();
      break label824;
      break;
      l = -1L;
      break label291;
      paramString = "";
      break label330;
      i = -1;
      break label880;
    }
  }
  
  public void afterHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if (!"acquire".equals(paramMethodHookParam.method.getName())) {
      a(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
    }
  }
  
  public void b()
  {
    super.b();
    synchronized (this.jdField_b_of_type_JavaUtilHashMap)
    {
      this.jdField_c_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
  
  public void beforeHookedMethod(MethodHookParam paramMethodHookParam)
  {
    if ("acquire".equals(paramMethodHookParam.method.getName())) {
      a(paramMethodHookParam.method.getName(), paramMethodHookParam.thisObject, paramMethodHookParam.args, paramMethodHookParam.result);
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
        JavaHookBridge.findAndHookMethod(PowerManager.class, "newWakeLock", new Object[] { Integer.TYPE, String.class, this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { Long.TYPE, this });
        JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "release", new Object[] { Integer.TYPE, this });
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.d("BatteryStats", 2, "", localThrowable);
  }
  
  public void e()
  {
    super.e();
    if ((axsp.a()) && (this.jdField_a_of_type_Boolean) && (axsp.b(this.jdField_b_of_type_Axsp))) {
      a(true);
    }
  }
  
  public void f()
  {
    super.f();
    if ((axsp.a()) && (this.jdField_a_of_type_Boolean) && (axsp.b(this.jdField_b_of_type_Axsp))) {
      a(false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        paramMessage = (WeakReference)paramMessage.obj;
        paramMessage = (axta)this.jdField_a_of_type_JavaUtilHashMap.get(paramMessage);
        if (paramMessage != null)
        {
          a(paramMessage, 5);
          axsp.a(this.jdField_b_of_type_Axsp, new String[] { "wl_alm", "|", paramMessage.c, "|0|0" });
          axsp.a(this.jdField_b_of_type_Axsp, 4, 1, 0, "Acquire " + paramMessage.jdField_a_of_type_JavaLangString + " too long time", "CallStack: " + paramMessage.b);
        }
        while (!QLog.isColorLevel()) {
          return false;
        }
        axsp.a(this.jdField_b_of_type_Axsp, "wake lock is lost ?");
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axsy
 * JD-Core Version:    0.7.0.1
 */