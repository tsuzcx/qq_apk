import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

public class annl
{
  public int a;
  public long a;
  public annk a;
  public Map<Integer, Long> a;
  public BlockingQueue<anni> a;
  public boolean a;
  public long b;
  public long c;
  
  public annl(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{").append("spanId:").append(this.jdField_a_of_type_Int).append(",result:").append(this.jdField_a_of_type_Annk);
    Iterator localIterator;
    if (this.jdField_a_of_type_JavaUtilMap != null)
    {
      localStringBuilder.append(",extra:[");
      localIterator = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (QLog.isColorLevel()) {
          localStringBuilder.append("{").append(localEntry.getKey()).append(",").append(localEntry.getValue()).append("}");
        } else {
          localStringBuilder.append("{").append(localEntry.getKey()).append("}");
        }
      }
      localStringBuilder.append("]");
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue != null)
    {
      localStringBuilder.append(",anno:[");
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentBlockingQueue.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((anni)localIterator.next()).toString());
      }
      localStringBuilder.append("]");
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annl
 * JD-Core Version:    0.7.0.1
 */