import android.util.SparseArray;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class aowz
{
  private final SparseArray<BlockingQueue<aoxh>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private aoxq jdField_a_of_type_Aoxq;
  private final BlockingQueue<aoxh> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  
  public aowz(aoxq paramaoxq)
  {
    this.jdField_a_of_type_Aoxq = paramaoxq;
  }
  
  protected int a()
  {
    return 300;
  }
  
  public aoxh a(int paramInt, Object paramObject)
  {
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null) {
      localObject = new LinkedBlockingQueue();
    }
    localObject = (aoxh)((BlockingQueue)localObject).poll();
    if (localObject == null)
    {
      localObject = this.jdField_a_of_type_Aoxq.a(paramInt);
      aozj.a("DanmakuFactory", new Object[] { localObject, " is created " });
    }
    for (;;)
    {
      ((aoxh)localObject).e();
      ((aoxh)localObject).a(paramObject);
      return localObject;
      aozj.a("DanmakuFactory", new Object[] { localObject, " is reused " });
    }
  }
  
  public void a(aoxh paramaoxh)
  {
    int i = paramaoxh.a();
    BlockingQueue localBlockingQueue = (BlockingQueue)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
    Object localObject = localBlockingQueue;
    if (localBlockingQueue == null)
    {
      localObject = new LinkedBlockingQueue();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localObject);
    }
    if (a() > ((BlockingQueue)localObject).size()) {
      ((BlockingQueue)localObject).add(paramaoxh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aowz
 * JD-Core Version:    0.7.0.1
 */