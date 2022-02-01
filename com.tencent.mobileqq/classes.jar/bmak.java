import common.qzone.component.cache.common.FastLruCache.1;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class bmak<K, V>
{
  private final int jdField_a_of_type_Int;
  private ReferenceQueue<V> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private final HashMap<K, V> jdField_a_of_type_JavaUtilHashMap;
  private final HashMap<K, bmal<K, V>> b = new HashMap();
  
  public bmak(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilHashMap = new FastLruCache.1(this, 16, 0.75F, true, paramInt);
  }
  
  private void a()
  {
    for (bmal localbmal = (bmal)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll(); localbmal != null; localbmal = (bmal)this.jdField_a_of_type_JavaLangRefReferenceQueue.poll()) {
      this.b.remove(localbmal.a);
    }
  }
  
  /* Error */
  public final V a(K paramK)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 61	bmak:a	()V
    //   6: aload_0
    //   7: getfield 45	bmak:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnull +9 -> 25
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: areturn
    //   25: aload_0
    //   26: getfield 23	bmak:b	Ljava/util/HashMap;
    //   29: aload_1
    //   30: invokevirtual 64	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   33: checkcast 52	bmal
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +8 -> 46
    //   41: aconst_null
    //   42: astore_1
    //   43: goto -22 -> 21
    //   46: aload_1
    //   47: invokevirtual 67	bmal:get	()Ljava/lang/Object;
    //   50: astore_1
    //   51: goto -30 -> 21
    //   54: astore_1
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_1
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	bmak
    //   0	59	1	paramK	K
    //   14	6	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	15	54	finally
    //   25	37	54	finally
    //   46	51	54	finally
  }
  
  /* Error */
  public final V a(K paramK, V paramV)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 61	bmak:a	()V
    //   6: aload_0
    //   7: getfield 45	bmak:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   10: aload_1
    //   11: aload_2
    //   12: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   15: pop
    //   16: aload_0
    //   17: getfield 23	bmak:b	Ljava/util/HashMap;
    //   20: aload_1
    //   21: new 52	bmal
    //   24: dup
    //   25: aload_1
    //   26: aload_2
    //   27: aload_0
    //   28: getfield 28	bmak:jdField_a_of_type_JavaLangRefReferenceQueue	Ljava/lang/ref/ReferenceQueue;
    //   31: invokespecial 76	bmal:<init>	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/ref/ReferenceQueue;)V
    //   34: invokevirtual 73	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   37: checkcast 52	bmal
    //   40: astore_1
    //   41: aload_1
    //   42: ifnonnull +9 -> 51
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aload_1
    //   52: invokevirtual 67	bmal:get	()Ljava/lang/Object;
    //   55: astore_1
    //   56: goto -9 -> 47
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	bmak
    //   0	64	1	paramK	K
    //   0	64	2	paramV	V
    // Exception table:
    //   from	to	target	type
    //   2	41	59	finally
    //   51	56	59	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmak
 * JD-Core Version:    0.7.0.1
 */