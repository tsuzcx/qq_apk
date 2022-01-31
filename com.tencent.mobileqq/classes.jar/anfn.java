import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class anfn
{
  private final SparseArray<BlockingQueue<anfv>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ange jdField_a_of_type_Ange;
  private final BlockingQueue<anfv> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public anfn(ange paramange)
  {
    this.jdField_a_of_type_Ange = paramange;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public anfv a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (anfv)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Ange.a(paramInt);
      anhx.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((anfv)localObject).e();
      ((anfv)localObject).a(paramObject);
      return localObject;
      anhx.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(anfv paramanfv)
  {
    int i = paramanfv.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramanfv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfn
 * JD-Core Version:    0.7.0.1
 */