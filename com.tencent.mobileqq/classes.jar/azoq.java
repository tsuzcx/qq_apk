import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class azoq
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private LinkedList<azor> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public azoq(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(List<azor> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH点mm分ss");
      int i = paramList.size();
      localStringBuilder.ensureCapacity((((azor)paramList.get(0)).jdField_a_of_type_JavaLangObject.toString().length() + 20) * i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        azor localazor = (azor)paramList.next();
        localStringBuilder.append("[").append(localSimpleDateFormat.format(new Date(localazor.jdField_a_of_type_Long))).append(":").append(localazor.jdField_a_of_type_JavaLangObject.toString()).append("]");
      }
    }
    return localStringBuilder.toString();
  }
  
  public List<azor> a(Object arg1)
  {
    Object localObject1 = new azor();
    ((azor)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
    ((azor)localObject1).jdField_a_of_type_JavaLangObject = ???;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(localObject1);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() < this.jdField_a_of_type_Int) {
        return null;
      }
      azor localazor = (azor)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
      if (((azor)localObject1).jdField_a_of_type_Long - localazor.jdField_a_of_type_Long < this.jdField_a_of_type_Long)
      {
        localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedList);
        return localObject1;
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoq
 * JD-Core Version:    0.7.0.1
 */