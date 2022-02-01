import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotVideoBlurTaskManager.1;
import com.tencent.mobileqq.hotpic.HotVideoData;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class avup
{
  static ArrayList<WeakReference<avup>> a;
  public static boolean a;
  public Context a;
  public ArrayMap<HotVideoData, avub> a;
  boolean b = false;
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  avup(Context paramContext)
  {
    this.jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  /* Error */
  public static avup a(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 37	avup:a	(Z)V
    //   7: aload_0
    //   8: ifnonnull +10 -> 18
    //   11: aconst_null
    //   12: astore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: new 2	avup
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 39	avup:<init>	(Landroid/content/Context;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore_0
    //   29: getstatic 21	avup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   32: invokevirtual 43	java/util/ArrayList:size	()I
    //   35: iconst_3
    //   36: if_icmpge -23 -> 13
    //   39: getstatic 21	avup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   42: new 45	java/lang/ref/WeakReference
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 48	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   50: invokevirtual 52	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   53: pop
    //   54: aload_1
    //   55: astore_0
    //   56: goto -43 -> 13
    //   59: astore_0
    //   60: ldc 2
    //   62: monitorexit
    //   63: aload_0
    //   64: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramContext	Context
    //   26	29	1	localavup	avup
    // Exception table:
    //   from	to	target	type
    //   3	7	59	finally
    //   18	27	59	finally
    //   29	54	59	finally
  }
  
  public static void a(avup paramavup)
  {
    for (;;)
    {
      try
      {
        a(false);
        if (paramavup == null) {
          return;
        }
        if (jdField_a_of_type_JavaUtilArrayList.size() < 3)
        {
          Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
          int i;
          if (localIterator.hasNext())
          {
            Object localObject = (WeakReference)localIterator.next();
            if (localObject != null)
            {
              localObject = (avup)((WeakReference)localObject).get();
              if ((localObject != null) && (paramavup.equals(localObject)))
              {
                i = 1;
                if (i == 0) {
                  jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramavup));
                }
              }
            }
          }
          else
          {
            i = 0;
          }
        }
      }
      finally {}
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    for (;;)
    {
      WeakReference localWeakReference;
      try
      {
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localWeakReference = (WeakReference)localIterator.next();
        if (localWeakReference == null)
        {
          localArrayList.add(localWeakReference);
          continue;
        }
        localavup = (avup)localWeakReference.get();
      }
      finally {}
      avup localavup;
      if (localavup == null) {
        localObject.add(localWeakReference);
      } else if ((paramBoolean) && (!localavup.b)) {
        localavup.a();
      }
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "pauseAllBlurTask HotVideoBlurTaskLock is:" + jdField_a_of_type_Boolean);
    }
  }
  
  /* Error */
  public static void b(avup paramavup)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: invokestatic 37	avup:a	(Z)V
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 21	avup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: invokevirtual 57	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   21: astore_1
    //   22: aload_1
    //   23: invokeinterface 63 1 0
    //   28: ifeq -17 -> 11
    //   31: aload_1
    //   32: invokeinterface 67 1 0
    //   37: checkcast 45	java/lang/ref/WeakReference
    //   40: astore_2
    //   41: aload_2
    //   42: ifnull -20 -> 22
    //   45: aload_2
    //   46: invokevirtual 70	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   49: checkcast 2	avup
    //   52: astore_3
    //   53: aload_3
    //   54: ifnull -32 -> 22
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 73	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   62: ifeq -40 -> 22
    //   65: getstatic 21	avup:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   68: aload_2
    //   69: invokevirtual 107	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: goto -62 -> 11
    //   76: astore_0
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_0
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramavup	avup
    //   21	11	1	localIterator	Iterator
    //   40	29	2	localWeakReference	WeakReference
    //   52	7	3	localavup	avup
    // Exception table:
    //   from	to	target	type
    //   3	7	76	finally
    //   15	22	76	finally
    //   22	41	76	finally
    //   45	53	76	finally
    //   57	73	76	finally
  }
  
  public static void c()
  {
    jdField_a_of_type_Boolean = false;
    a(true);
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "resmueAllBlurTask HotVideoBlurTaskLock is:" + jdField_a_of_type_Boolean + " TaskManagerList size is " + jdField_a_of_type_JavaUtilArrayList.size());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoBlurTaskManager", 2, "tryStartBlurTask HotVideoBlurTaskLock is:" + jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size() == 0) || (jdField_a_of_type_Boolean))
    {
      this.b = false;
      return;
    }
    this.b = true;
    ThreadManager.post(new HotVideoBlurTaskManager.1(this), 5, null, true);
  }
  
  public void a(avub paramavub, HotVideoData paramHotVideoData)
  {
    if ((paramavub == null) || (paramHotVideoData == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramHotVideoData))
        {
          int i = this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.indexOfKey(paramHotVideoData);
          this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.setValueAt(i, paramavub);
          if (QLog.isColorLevel()) {
            QLog.d("HotVideoBlurTaskManager", 2, "AddBlurTask HotVideoData.Name is:" + paramHotVideoData.name + " mBlurTasks size is " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
          }
          if (this.b) {
            break;
          }
          a();
          break;
        }
      }
      finally {}
      this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(paramHotVideoData, paramavub);
    }
  }
  
  public void a(HotVideoData paramHotVideoData)
  {
    if (paramHotVideoData == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramHotVideoData)) {
          this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.remove(paramHotVideoData);
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HotVideoBlurTaskManager", 2, "RemoveTaskByData HotVideoData.Name is:" + paramHotVideoData.name + " mBlurTasks size is " + this.jdField_a_of_type_AndroidSupportV4UtilArrayMap.size());
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avup
 * JD-Core Version:    0.7.0.1
 */