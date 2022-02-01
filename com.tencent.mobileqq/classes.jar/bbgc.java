import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bbgc
{
  public static bbgc a;
  public long a;
  public Map<Long, WeakReference<Object>> a;
  
  static
  {
    jdField_a_of_type_Bbgc = new bbgc();
  }
  
  private bbgc()
  {
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  }
  
  public static bbgc a()
  {
    return jdField_a_of_type_Bbgc;
  }
  
  public long a(Object paramObject)
  {
    long l;
    if (paramObject == null) {
      l = -9223372036854775808L;
    }
    for (;;)
    {
      return l;
      try
      {
        l = this.jdField_a_of_type_Long;
        this.jdField_a_of_type_Long = (1L + l);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), new WeakReference(paramObject));
      }
      finally {}
    }
  }
  
  /* Error */
  public Object a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	bbgc:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: lload_1
    //   7: invokestatic 35	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokeinterface 51 2 0
    //   15: checkcast 37	java/lang/ref/WeakReference
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +12 -> 32
    //   23: aload_3
    //   24: invokevirtual 54	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: areturn
    //   32: aconst_null
    //   33: astore_3
    //   34: goto -6 -> 28
    //   37: astore_3
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_3
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	bbgc
    //   0	42	1	paramLong	long
    //   18	16	3	localObject1	Object
    //   37	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	37	finally
    //   23	28	37	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbgc
 * JD-Core Version:    0.7.0.1
 */