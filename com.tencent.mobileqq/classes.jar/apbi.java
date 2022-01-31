import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class apbi
{
  private final SparseArray<BlockingQueue<apbq>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private apbz jdField_a_of_type_Apbz;
  private final BlockingQueue<apbq> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public apbi(apbz paramapbz)
  {
    this.jdField_a_of_type_Apbz = paramapbz;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public apbq a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (apbq)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Apbz.a(paramInt);
      apds.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((apbq)localObject).e();
      ((apbq)localObject).a(paramObject);
      return localObject;
      apds.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(apbq paramapbq)
  {
    int i = paramapbq.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramapbq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbi
 * JD-Core Version:    0.7.0.1
 */