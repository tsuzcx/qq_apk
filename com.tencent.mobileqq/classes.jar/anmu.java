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

public class anmu
  implements Handler.Callback
{
  private anmr jdField_a_of_type_Anmr;
  private annm jdField_a_of_type_Annm;
  private blha jdField_a_of_type_Blha = new blha(ThreadManager.getSubThreadLooper(), this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<Integer, annn> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(-1);
  private Set<Integer> jdField_b_of_type_JavaUtilSet = new CopyOnWriteArraySet();
  private ConcurrentHashMap<String, annj> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public static anmu a()
  {
    return anmw.a();
  }
  
  public static boolean a()
  {
    return annu.a;
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    annn localannn = (annn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localannn != null)
    {
      localannn.a();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localannn);
    }
    localannn = new annn(paramInt);
    paramBundle.putBoolean("isSampleFocus", a(paramInt));
    localannn.a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localannn);
  }
  
  private void c(int paramInt, Bundle paramBundle)
  {
    annn localannn = (annn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localannn == null)
    {
      QLog.e("TraceReport" + this.jdField_a_of_type_Anmr.a(paramInt), 1, new Object[] { "already end the trace, featureId:", Integer.valueOf(paramInt) });
      return;
    }
    localannn.c(paramBundle);
    paramBundle = paramBundle.getString("featureKey");
    a().a(paramBundle);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt), localannn);
    this.jdField_b_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
  }
  
  private void d(int paramInt, Bundle paramBundle)
  {
    annn localannn = (annn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localannn == null) {
      return;
    }
    localannn.b(paramBundle);
  }
  
  private void e(int paramInt, Bundle paramBundle)
  {
    annn localannn = (annn)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localannn == null) {
      return;
    }
    localannn.d(paramBundle);
  }
  
  public int a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
      return paramInt;
    }
    return ((annj)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).a;
  }
  
  public int a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return paramInt;
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        return ((annj)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).b;
      }
    } while (!paramBoolean);
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() <= -2147483648) {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(-1);
    }
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    annj localannj = new annj(paramInt, i);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localannj);
    return i;
  }
  
  public anmr a()
  {
    return this.jdField_a_of_type_Anmr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Blha.sendEmptyMessage(4);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    if (this.jdField_a_of_type_Anmr != null) {
      this.jdField_a_of_type_Anmr.a().a();
    }
    this.jdField_a_of_type_Blha.removeMessages(6);
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Anmr == null) {
      return;
    }
    paramBundle.putInt("featureId", a(paramInt, paramBundle.getString("featureKey"), false));
    this.jdField_a_of_type_Blha.obtainMessage(5, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Anmr == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Anmr == null) {}
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
      paramBundle.putInt("initJavaHeap", anna.c());
      paramBundle.putInt("initNativeHeap", anna.d());
    }
    this.jdField_a_of_type_Blha.obtainMessage(1, paramBundle).sendToTarget();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Anmr == null) {
      return;
    }
    if (!paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(paramInt));
      return;
    }
    this.jdField_a_of_type_JavaUtilSet.remove(Integer.valueOf(paramInt));
  }
  
  public void a(anmr paramanmr)
  {
    anmr localanmr = paramanmr;
    if (paramanmr == null)
    {
      localanmr = anna.a();
      QLog.e("TraceReport", 1, "init error, outside not init config");
    }
    if (localanmr == null) {
      return;
    }
    this.jdField_a_of_type_Anmr = localanmr;
    if (this.jdField_a_of_type_Annm == null) {
      this.jdField_a_of_type_Annm = new annm();
    }
    this.jdField_a_of_type_Annm.a(localanmr);
    this.jdField_a_of_type_Blha.sendEmptyMessage(0);
  }
  
  public void a(TraceData paramTraceData)
  {
    if ((!a()) || (paramTraceData.featureId < 0)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_Annm != null) && (this.jdField_a_of_type_Anmr != null))
      {
        if (this.jdField_a_of_type_Annm.a(paramTraceData))
        {
          this.jdField_a_of_type_Blha.removeMessages(6);
          this.jdField_a_of_type_Blha.sendEmptyMessageDelayed(6, annm.a);
          return;
        }
        this.jdField_a_of_type_Blha.removeMessages(6);
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
    if (this.jdField_a_of_type_Anmr == null) {
      return false;
    }
    return this.jdField_a_of_type_Anmr.a(paramInt);
  }
  
  public void b(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Anmr == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Anmr == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt, paramString, false);
    } while (this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)));
    paramBundle.putInt("featureId", i);
    if (a(paramInt))
    {
      paramBundle.putInt("endJavaHeap", anna.c());
      paramBundle.putInt("endNativeHeap", anna.d());
    }
    this.jdField_a_of_type_Blha.obtainMessage(2, paramBundle).sendToTarget();
  }
  
  public void c(int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Anmr == null) {
      a(null);
    }
    if (this.jdField_a_of_type_Anmr == null) {}
    do
    {
      return;
      paramInt = a(paramInt, paramString, false);
    } while ((this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))) || (this.jdField_b_of_type_JavaUtilSet.contains(Integer.valueOf(paramInt))));
    paramBundle.putInt("featureId", paramInt);
    this.jdField_a_of_type_Blha.obtainMessage(3, paramBundle).sendToTarget();
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
      if (this.jdField_a_of_type_Annm != null)
      {
        this.jdField_a_of_type_Annm.a();
        continue;
        b(paramMessage.getInt("featureId"), paramMessage);
        continue;
        c(paramMessage.getInt("featureId"), paramMessage);
        continue;
        d(paramMessage.getInt("featureId"), paramMessage);
        continue;
        if (this.jdField_a_of_type_Annm != null)
        {
          this.jdField_a_of_type_Annm.c();
          continue;
          e(paramMessage.getInt("featureId"), paramMessage);
          continue;
          if (this.jdField_a_of_type_Annm != null) {
            this.jdField_a_of_type_Annm.b();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmu
 * JD-Core Version:    0.7.0.1
 */