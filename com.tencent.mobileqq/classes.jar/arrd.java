import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class arrd
{
  private final SparseArray<BlockingQueue<arrl>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private arru jdField_a_of_type_Arru;
  private final BlockingQueue<arrl> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public arrd(arru paramarru)
  {
    this.jdField_a_of_type_Arru = paramarru;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public arrl a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (arrl)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Arru.a(paramInt);
      artm.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((arrl)localObject).e();
      ((arrl)localObject).a(paramObject);
      return localObject;
      artm.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(arrl paramarrl)
  {
    int i = paramarrl.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramarrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrd
 * JD-Core Version:    0.7.0.1
 */