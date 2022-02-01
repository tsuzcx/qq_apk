import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.search.rich.RichNodeController.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class bckm
{
  private static String jdField_a_of_type_JavaLangString = "RichNodeController";
  private static final Set<WeakReference<bcke>> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int = 0;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private Map<Integer, bckn> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private int b;
  private int c;
  
  public static void a()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy.(item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (bcke)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy.(node == null");
        }
        localObject1.remove();
      }
      else
      {
        a((bcke)localObject2);
        ((bcke)localObject2).d();
      }
    }
    jdField_a_of_type_JavaUtilSet.clear();
  }
  
  private static void a(bcke parambcke) {}
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "pauseAll, puase:" + paramBoolean + " startPos:" + this.b + " endPos:" + this.c);
    }
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "pauseAll, map is empty");
      }
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bckn)localIterator.next();
        if (localObject != null)
        {
          localObject = ((bckn)localObject).a;
          if (localObject != null)
          {
            localObject = (bcke)((WeakReference)localObject).get();
            if (localObject != null) {
              if (paramBoolean) {
                ((bcke)localObject).b();
              } else {
                ((bcke)localObject).c();
              }
            }
          }
        }
      }
    }
  }
  
  public static void b()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (bcke)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause node == null");
        }
        localObject1.remove();
      }
      else
      {
        ((bcke)localObject2).b();
      }
    }
  }
  
  private void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "restartPlayTimer:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramInt < 0) {
      return;
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new RichNodeController.1(this);
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, paramInt);
  }
  
  public static void c() {}
  
  public static void d() {}
  
  private void e()
  {
    if (this.jdField_a_of_type_JavaUtilMap.size() == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (Map.Entry)localIterator.next();
        Object localObject2 = (bckn)((Map.Entry)localObject1).getValue();
        if (localObject2 == null)
        {
          localIterator.remove();
        }
        else if (((bckn)localObject2).a == null)
        {
          localIterator.remove();
        }
        else
        {
          localObject2 = (bcke)((bckn)localObject2).a.get();
          if (localObject2 == null)
          {
            localIterator.remove();
          }
          else
          {
            localObject1 = (Integer)((Map.Entry)localObject1).getKey();
            if (localObject1 == null)
            {
              ((bcke)localObject2).b();
              localIterator.remove();
            }
            else if ((((Integer)localObject1).intValue() < this.b) || (((Integer)localObject1).intValue() > this.c))
            {
              ((bcke)localObject2).b();
              localIterator.remove();
            }
          }
        }
      }
    }
  }
  
  private static void f()
  {
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (WeakReference)localIterator.next();
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause item == null");
          }
          localIterator.remove();
        }
      }
      Object localObject2 = (bcke)((WeakReference)localObject2).get();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "onPause node == null");
        }
        localObject1.remove();
      }
      else
      {
        ((bcke)localObject2).c();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 0)
    {
      b(100);
      return;
    }
    b(-1);
    b();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == this.b) && (this.c == paramInt1 + paramInt2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setScorllData, mStartPos:" + this.b + " endPos:" + this.c);
    }
    this.b = paramInt1;
    this.c = (paramInt1 + paramInt2);
    e();
  }
  
  public void a(int paramInt, bcke parambcke)
  {
    if (parambcke == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "registerNode, nPos:" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), new bckn(paramInt, parambcke));
    if (this.jdField_a_of_type_Int != 0) {
      parambcke.b();
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaUtilSet)
      {
        Iterator localIterator = jdField_a_of_type_JavaUtilSet.iterator();
        if (!localIterator.hasNext()) {
          break label201;
        }
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference == null) || (localWeakReference.get() != parambcke)) {
          continue;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "find in list:" + bool);
        }
        if (!bool) {
          jdField_a_of_type_JavaUtilSet.add(new WeakReference(parambcke));
        }
        return;
      }
      parambcke.c();
      continue;
      label201:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckm
 * JD-Core Version:    0.7.0.1
 */