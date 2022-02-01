import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awod
{
  private static final awit jdField_a_of_type_Awit = new awit(-1, "-1");
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private final List<awoe> jdField_a_of_type_JavaUtilList = new ArrayList();
  private awit b = jdField_a_of_type_Awit;
  
  public awod(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public awit a()
  {
    return this.b;
  }
  
  public void a()
  {
    this.b = jdField_a_of_type_Awit;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awoe)localIterator.next()).a();
    }
  }
  
  public void a(awit paramawit)
  {
    this.b = paramawit;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((awoe)localIterator.next()).a(paramawit);
    }
  }
  
  public void a(awoe paramawoe)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramawoe)) {
        this.jdField_a_of_type_JavaUtilList.add(paramawoe);
      }
      return;
    }
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	awod:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: astore_1
    //   7: aload_1
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 33	awod:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 70 1 0
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_2
    //   24: aload_1
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	awod
    //   28	4	1	localObject1	Object
    //   23	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   9	20	23	finally
    //   24	26	23	finally
    //   2	9	28	finally
    //   26	28	28	finally
  }
  
  /* Error */
  public void b(awoe paramawoe)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 33	awod:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 33	awod:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: aload_1
    //   14: invokeinterface 73 2 0
    //   19: pop
    //   20: aload_2
    //   21: monitorexit
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_1
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_1
    //   29: athrow
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	awod
    //   0	35	1	paramawoe	awoe
    // Exception table:
    //   from	to	target	type
    //   9	22	25	finally
    //   26	28	25	finally
    //   2	9	30	finally
    //   28	30	30	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awod
 * JD-Core Version:    0.7.0.1
 */