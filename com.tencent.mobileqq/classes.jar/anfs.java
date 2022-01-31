import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class anfs
{
  private final SparseArray<BlockingQueue<anga>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private angj jdField_a_of_type_Angj;
  private final BlockingQueue<anga> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public anfs(angj paramangj)
  {
    this.jdField_a_of_type_Angj = paramangj;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public anga a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (anga)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Angj.a(paramInt);
      anic.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((anga)localObject).e();
      ((anga)localObject).a(paramObject);
      return localObject;
      anic.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(anga paramanga)
  {
    int i = paramanga.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramanga);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anfs
 * JD-Core Version:    0.7.0.1
 */