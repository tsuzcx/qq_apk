import com.tencent.commonsdk.pool.RecyclablePool.Recyclable;
import java.util.concurrent.ConcurrentHashMap;

public class amdt
  extends RecyclablePool.Recyclable
{
  public int a;
  public long a;
  ConcurrentHashMap<String, Long> a;
  long b;
  
  public amdt()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.b = 0L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    super.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdt
 * JD-Core Version:    0.7.0.1
 */