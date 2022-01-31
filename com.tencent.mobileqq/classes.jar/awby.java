import com.tencent.mobileqq.app.SQLiteDatabase;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class awby
{
  private static final Lock jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  private final alxk jdField_a_of_type_Alxk;
  private SQLiteDatabase jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase;
  
  awby(alxk paramalxk)
  {
    this.jdField_a_of_type_Alxk = paramalxk;
  }
  
  public void a()
  {
    Thread localThread = Thread.currentThread();
    aznl.b(localThread.getId(), localThread.getName());
    jdField_a_of_type_JavaUtilConcurrentLocksLock.lock();
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase = this.jdField_a_of_type_Alxk.a();
    if ((alxk.a) && (bhou.e())) {
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.b();
    }
    for (;;)
    {
      aznl.a(localThread.getId());
      aznl.a(localThread.getId(), localThread.getName());
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.a();
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	awby:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   4: invokevirtual 79	com/tencent/mobileqq/app/SQLiteDatabase:d	()V
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield 54	awby:jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase	Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   12: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   15: checkcast 12	java/util/concurrent/locks/ReentrantLock
    //   18: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   21: ifeq +18 -> 39
    //   24: ldc2_w 83
    //   27: aconst_null
    //   28: invokestatic 72	aznl:a	(JLjava/lang/String;)V
    //   31: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   34: invokeinterface 87 1 0
    //   39: return
    //   40: astore_1
    //   41: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   44: checkcast 12	java/util/concurrent/locks/ReentrantLock
    //   47: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   50: ifeq -11 -> 39
    //   53: ldc2_w 83
    //   56: aconst_null
    //   57: invokestatic 72	aznl:a	(JLjava/lang/String;)V
    //   60: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   63: invokeinterface 87 1 0
    //   68: return
    //   69: astore_1
    //   70: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   73: checkcast 12	java/util/concurrent/locks/ReentrantLock
    //   76: invokevirtual 82	java/util/concurrent/locks/ReentrantLock:isHeldByCurrentThread	()Z
    //   79: ifeq +18 -> 97
    //   82: ldc2_w 83
    //   85: aconst_null
    //   86: invokestatic 72	aznl:a	(JLjava/lang/String;)V
    //   89: getstatic 17	awby:jdField_a_of_type_JavaUtilConcurrentLocksLock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 87 1 0
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	awby
    //   40	1	1	localException	java.lang.Exception
    //   69	29	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	12	40	java/lang/Exception
    //   0	12	69	finally
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppSQLiteDatabase.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awby
 * JD-Core Version:    0.7.0.1
 */