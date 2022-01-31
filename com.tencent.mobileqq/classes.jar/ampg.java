import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ampg
{
  private ampx jdField_a_of_type_Ampx;
  private final SparseArray<BlockingQueue<ampo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private final BlockingQueue<ampo> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public ampg(ampx paramampx)
  {
    this.jdField_a_of_type_Ampx = paramampx;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public ampo a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (ampo)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Ampx.a(paramInt);
      amrq.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((ampo)localObject).e();
      ((ampo)localObject).a(paramObject);
      return localObject;
      amrq.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(ampo paramampo)
  {
    int i = paramampo.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramampo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ampg
 * JD-Core Version:    0.7.0.1
 */