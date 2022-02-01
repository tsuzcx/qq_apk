import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.apollo.trace.sdk.data.TraceData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class amho
  implements Handler.Callback
{
  private amhl jdField_a_of_type_Amhl;
  private amig jdField_a_of_type_Amig;
  private bjmp jdField_a_of_type_Bjmp = new bjmp(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, amih> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, amid> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static amho a()
  {
    return amhq.a();
  }
  
  public static boolean a()
  {
    return amio.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    amih localamih = (amih)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localamih != null)
    {
      localamih.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localamih);
    }
    localamih = new amih(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localamih.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localamih);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    amih localamih = (amih)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localamih == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Amhl.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localamih.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localamih);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    amih localamih = (amih)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localamih == null) {
      return;
    }
    localamih.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    amih localamih = (amih)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localamih == null) {
      return;
    }
    localamih.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((amid)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((amid)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    amid localamid = new amid(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localamid);
    return i;
  }
  
  public amhl a()
  {
    return this.jdField_a_of_type_Amhl;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Bjmp.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Amhl != null) {
      this.jdField_a_of_type_Amhl.a().a();
    }
    this.jdField_a_of_type_Bjmp.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      return;
    }
    paramBundle.putInt("featureId", a(paramInt, paramBundle.getString("featureKey"), false));
    this.jdField_a_of_type_Bjmp.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Amhl == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt, paramString, true);
    } while (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)));
    this.jdField_b_of_type_JavaUtilSet.remove(Integer.valueOf(i));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("initJavaHeap", amhu.c());
      paramBundle.putInt("initNativeHeap", amhu.d());
    }
    this.jdField_a_of_type_Bjmp.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
  }
  
  public void a(amhl paramamhl)
  {
    amhl localamhl = paramamhl;
    if (paramamhl == null)
    {
      localamhl = amhu.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    if (localamhl == null) {
      return;
    }
    this.jdField_a_of_type_Amhl = localamhl;
    if (this.jdField_a_of_type_Amig == null) {
      this.jdField_a_of_type_Amig = new amig();
    }
    this.jdField_a_of_type_Amig.a(localamhl);
    this.jdField_a_of_type_Bjmp.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Amig != null) && (this.jdField_a_of_type_Amhl != null))
      {
        if (this.jdField_a_of_type_Amig.a(paramTraceData))
        {
          this.jdField_a_of_type_Bjmp.removeMessages(6);
          this.jdField_a_of_type_Bjmp.sendEmptyMessageDelayed(6, amig.a);
          return;
        }
        this.jdField_a_of_type_Bjmp.removeMessages(6);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TraceReport", 2, "sendTraceReport mTraceReportControl or config is null");
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      return false;
    }
    return this.jdField_a_of_type_Amhl.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Amhl == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt, paramString, false);
    } while (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", amhu.c());
      paramBundle.putInt("endNativeHeap", amhu.d());
    }
    this.jdField_a_of_type_Bjmp.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Amhl == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Amhl == null) {}
    do
    {
      return;
      paramInt = a(paramInt, paramString, false);
    } while ((this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) || (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))));
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Bjmp.obtainMessage(3, paramBundle).sendToTarget();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (Bundle)paramMessage.obj;
    switch (i)
    {
    }
    for (;;)
    {
      return false;
      if (this.jdField_a_of_type_Amig != null)
      {
        this.jdField_a_of_type_Amig.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Amig != null)
        {
          this.jdField_a_of_type_Amig.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Amig != null) {
            this.jdField_a_of_type_Amig.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amho
 * JD-Core Version:    0.7.0.1
 */