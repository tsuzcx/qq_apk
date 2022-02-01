import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap.1;
import dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class bozd
{
  private String jdField_a_of_type_JavaLangString = "";
  private final Map<String, borc> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference<bown> jdField_a_of_type_MqqUtilWeakReference;
  private final Map<String, List<bozc>> b = new HashMap();
  
  public static bozd a()
  {
    return bozf.a;
  }
  
  private void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
  }
  
  private void a(String paramString, borc paramborc)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, paramborc);
      return;
    }
  }
  
  private boolean a(String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilMap)
      {
        if (this.jdField_a_of_type_JavaUtilMap.get(paramString) != null)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public Map<String, borc> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.b.clear();
  }
  
  public void a(boqu paramboqu, boolean paramBoolean)
  {
    if (paramboqu == null) {}
    for (;;)
    {
      return;
      String str;
      List localList;
      try
      {
        str = paramboqu.jdField_a_of_type_JavaLangString;
        localList = (List)this.b.get(str);
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramBoolean) && (paramboqu.equals(bowt.a))) {
          ThreadManager.getUIHandler().post(new PlayDownloadManagerWrap.2(this, paramboqu));
        }
        if (localList == null)
        {
          this.b.remove(str);
          continue;
        }
      }
      finally {}
      paramboqu = localList.iterator();
      while (paramboqu.hasNext()) {
        ((bozc)paramboqu.next()).a(str, paramBoolean);
      }
      this.b.remove(str);
    }
  }
  
  public void a(bown parambown, @NonNull boqr paramboqr, @NonNull boqu paramboqu)
  {
    if (a(paramboqu.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambown);
    }
    parambown = new boze(null);
    a(paramboqu.jdField_a_of_type_JavaLangString, parambown);
    this.jdField_a_of_type_JavaLangString = paramboqu.jdField_a_of_type_JavaLangString;
    ThreadManager.excute(new PlayDownloadManagerWrap.1(this, paramboqr, paramboqu, parambown), 128, null, true);
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bozd:b	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 58 2 0
    //   12: checkcast 70	java/util/List
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +17 -> 34
    //   20: aload_0
    //   21: getfield 23	bozd:b	Ljava/util/Map;
    //   24: aload_1
    //   25: invokeinterface 49 2 0
    //   30: pop
    //   31: aload_0
    //   32: monitorexit
    //   33: return
    //   34: aload_3
    //   35: invokeinterface 103 1 0
    //   40: astore_3
    //   41: aload_3
    //   42: invokeinterface 109 1 0
    //   47: ifeq -16 -> 31
    //   50: aload_3
    //   51: invokeinterface 113 1 0
    //   56: checkcast 115	bozc
    //   59: aload_1
    //   60: iload_2
    //   61: invokeinterface 148 3 0
    //   66: goto -25 -> 41
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	bozd
    //   0	74	1	paramString	String
    //   0	74	2	paramInt	int
    //   15	36	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	16	69	finally
    //   20	31	69	finally
    //   34	41	69	finally
    //   41	66	69	finally
  }
  
  public void a(String paramString, bozc parambozc)
  {
    if (parambozc != null) {}
    try
    {
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (!((List)localObject).contains(parambozc))
      {
        ((List)localObject).add(parambozc);
        this.b.put(paramString, localObject);
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString, bozc parambozc)
  {
    List localList;
    try
    {
      localList = (List)this.b.get(paramString);
      if ((localList != null) && (localList.size() > 1))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if ((bozc)localIterator.next() == parambozc) {
            localIterator.remove();
          }
        }
      }
      if (localList == null) {
        break label91;
      }
    }
    finally {}
    if (localList.size() < 1) {
      label91:
      this.b.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bozd
 * JD-Core Version:    0.7.0.1
 */