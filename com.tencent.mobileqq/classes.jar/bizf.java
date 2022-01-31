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

public class bizf
{
  private String jdField_a_of_type_JavaLangString = "";
  private final Map<String, birp> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WeakReference<biws> jdField_a_of_type_MqqUtilWeakReference;
  private final Map<String, List<bize>> b = new HashMap();
  
  public static bizf a()
  {
    return bizh.a;
  }
  
  private void a(String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      return;
    }
  }
  
  private void a(String paramString, birp parambirp)
  {
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.put(paramString, parambirp);
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
  
  public Map<String, birp> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_MqqUtilWeakReference = null;
    this.b.clear();
  }
  
  public void a(bire parambire, boolean paramBoolean)
  {
    if (parambire == null) {}
    for (;;)
    {
      return;
      String str;
      List localList;
      try
      {
        str = parambire.jdField_a_of_type_JavaLangString;
        localList = (List)this.b.get(str);
        if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramBoolean) && (parambire.equals(biwy.a))) {
          ThreadManager.getUIHandler().post(new PlayDownloadManagerWrap.2(this, parambire));
        }
        if (localList == null)
        {
          this.b.remove(str);
          continue;
        }
      }
      finally {}
      parambire = localList.iterator();
      while (parambire.hasNext()) {
        ((bize)parambire.next()).a(str, paramBoolean);
      }
      this.b.remove(str);
    }
  }
  
  public void a(biws parambiws, @NonNull birb parambirb, @NonNull bire parambire)
  {
    if (a(parambire.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambiws);
    }
    parambiws = new bizg(null);
    a(parambire.jdField_a_of_type_JavaLangString, parambiws);
    this.jdField_a_of_type_JavaLangString = parambire.jdField_a_of_type_JavaLangString;
    ThreadManager.excute(new PlayDownloadManagerWrap.1(this, parambirb, parambire, parambiws), 128, null, true);
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bizf:b	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 58 2 0
    //   12: checkcast 70	java/util/List
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +17 -> 34
    //   20: aload_0
    //   21: getfield 23	bizf:b	Ljava/util/Map;
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
    //   56: checkcast 115	bize
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
    //   0	74	0	this	bizf
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
  
  public void a(String paramString, bize parambize)
  {
    if (parambize != null) {}
    try
    {
      List localList = (List)this.b.get(paramString);
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      if (!((List)localObject).contains(parambize))
      {
        ((List)localObject).add(parambize);
        this.b.put(paramString, localObject);
      }
      return;
    }
    finally {}
  }
  
  public void b(String paramString, bize parambize)
  {
    List localList;
    try
    {
      localList = (List)this.b.get(paramString);
      if ((localList != null) && (localList.size() > 1))
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if ((bize)localIterator.next() == parambize) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bizf
 * JD-Core Version:    0.7.0.1
 */