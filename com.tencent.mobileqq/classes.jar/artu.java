import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class artu
{
  private final SparseArray<BlockingQueue<aruc>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arul jdField_a_of_type_Arul;
  private final BlockingQueue<aruc> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public artu(arul paramarul)
  {
    this.jdField_a_of_type_Arul = paramarul;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public aruc a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (aruc)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Arul.a(paramInt);
      arwe.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((aruc)localObject).e();
      ((aruc)localObject).a(paramObject);
      return localObject;
      arwe.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(aruc paramaruc)
  {
    int i = paramaruc.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramaruc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artu
 * JD-Core Version:    0.7.0.1
 */