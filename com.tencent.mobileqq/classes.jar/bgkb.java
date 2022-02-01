import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Task;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class bgkb
{
  public int a;
  public LinkedList<TroopFileTransferManager.Task> a;
  public AtomicInteger a;
  
  public bgkb(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger();
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  public void a(TroopFileTransferManager.Task paramTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	bgkb:jdField_a_of_type_JavaUtilLinkedList	Ljava/util/LinkedList;
    //   6: aload_1
    //   7: invokevirtual 32	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   10: pop
    //   11: aload_0
    //   12: getfield 19	bgkb:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   15: invokevirtual 36	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   18: aload_0
    //   19: getfield 26	bgkb:jdField_a_of_type_Int	I
    //   22: if_icmple +14 -> 36
    //   25: aload_0
    //   26: getfield 19	bgkb:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger	Ljava/util/concurrent/atomic/AtomicInteger;
    //   29: invokevirtual 39	java/util/concurrent/atomic/AtomicInteger:decrementAndGet	()I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: return
    //   36: new 41	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool$1
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 44	com/tencent/mobileqq/troop/utils/TroopFileTransferManager$TaskPool$1:<init>	(Lbgkb;)V
    //   44: iconst_5
    //   45: aconst_null
    //   46: iconst_1
    //   47: invokestatic 50	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   50: goto -17 -> 33
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	bgkb
    //   0	58	1	paramTask	TroopFileTransferManager.Task
    // Exception table:
    //   from	to	target	type
    //   2	33	53	finally
    //   36	50	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkb
 * JD-Core Version:    0.7.0.1
 */