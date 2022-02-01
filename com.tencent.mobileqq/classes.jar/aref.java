import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class aref
{
  private final SparseArray<BlockingQueue<aren>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arew jdField_a_of_type_Arew;
  private final BlockingQueue<aren> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public aref(arew paramarew)
  {
    this.jdField_a_of_type_Arew = paramarew;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public aren a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (aren)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Arew.a(paramInt);
      argp.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((aren)localObject).e();
      ((aren)localObject).a(paramObject);
      return localObject;
      argp.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(aren paramaren)
  {
    int i = paramaren.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramaren);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aref
 * JD-Core Version:    0.7.0.1
 */