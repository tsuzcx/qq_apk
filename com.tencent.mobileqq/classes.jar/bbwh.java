import android.app.Activity;
import com.tencent.superplayer.api.SuperPlayerMgr;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class bbwh
{
  private static volatile bbwh jdField_a_of_type_Bbwh;
  private static CopyOnWriteArraySet<bbwe> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet = new CopyOnWriteArraySet();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  
  public static bbwh a()
  {
    if (jdField_a_of_type_Bbwh == null) {}
    try
    {
      if (jdField_a_of_type_Bbwh == null) {
        jdField_a_of_type_Bbwh = new bbwh();
      }
      return jdField_a_of_type_Bbwh;
    }
    finally {}
  }
  
  private void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    SuperPlayerMgr.setLibLoader(new bbwj(this));
    String str = paramActivity.getExternalCacheDir() + "/superplayer";
    SuperPlayerMgr.initSDK(paramActivity.getApplication(), 170303, str);
    SuperPlayerMgr.setOnLogListener(new bbwk(this));
  }
  
  /* Error */
  public void a(Activity paramActivity, bbwe parambbwe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: getstatic 18	bbwh:jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArraySet	Ljava/util/concurrent/CopyOnWriteArraySet;
    //   9: aload_2
    //   10: invokevirtual 91	java/util/concurrent/CopyOnWriteArraySet:add	(Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: getfield 27	bbwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   18: invokevirtual 95	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   21: iconst_1
    //   22: if_icmpne +20 -> 42
    //   25: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +11 -> 39
    //   31: ldc 103
    //   33: iconst_2
    //   34: ldc 105
    //   36: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield 27	bbwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   46: iconst_1
    //   47: invokevirtual 112	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   50: invokestatic 117	axni:a	()Laxni;
    //   53: astore_2
    //   54: new 119	bbwi
    //   57: dup
    //   58: aload_0
    //   59: aload_1
    //   60: invokespecial 121	bbwi:<init>	(Lbbwh;Landroid/app/Activity;)V
    //   63: astore_1
    //   64: aload_2
    //   65: iconst_4
    //   66: anewarray 123	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: ldc 125
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: ldc 127
    //   78: aastore
    //   79: dup
    //   80: iconst_2
    //   81: ldc 129
    //   83: aastore
    //   84: dup
    //   85: iconst_3
    //   86: ldc 131
    //   88: aastore
    //   89: aload_1
    //   90: invokevirtual 134	axni:a	([Ljava/lang/String;Laxng;)V
    //   93: goto -54 -> 39
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	bbwh
    //   0	101	1	paramActivity	Activity
    //   0	101	2	parambbwe	bbwe
    // Exception table:
    //   from	to	target	type
    //   6	14	96	finally
    //   14	39	96	finally
    //   42	93	96	finally
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	bbwh:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 95	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_1
    //   10: iload_1
    //   11: iconst_2
    //   12: if_icmpne +9 -> 21
    //   15: iconst_1
    //   16: istore_2
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_2
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_2
    //   23: goto -6 -> 17
    //   26: astore_3
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_3
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	bbwh
    //   9	4	1	i	int
    //   16	7	2	bool	boolean
    //   26	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	26	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbwh
 * JD-Core Version:    0.7.0.1
 */