import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class aqns
{
  private final SparseArray<BlockingQueue<aqoa>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aqoj jdField_a_of_type_Aqoj;
  private final BlockingQueue<aqoa> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public aqns(aqoj paramaqoj)
  {
    this.jdField_a_of_type_Aqoj = paramaqoj;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public aqoa a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (aqoa)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Aqoj.a(paramInt);
      aqqb.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((aqoa)localObject).e();
      ((aqoa)localObject).a(paramObject);
      return localObject;
      aqqb.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(aqoa paramaqoa)
  {
    int i = paramaqoa.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramaqoa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqns
 * JD-Core Version:    0.7.0.1
 */