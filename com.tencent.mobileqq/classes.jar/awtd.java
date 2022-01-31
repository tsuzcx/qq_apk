import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class awtd
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private LinkedList<awte> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  
  public awtd(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public static String a(List<awte> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH点mm分ss");
      int i = paramList.size();
      localStringBuilder.ensureCapacity((((awte)paramList.get(0)).jdField_a_of_type_JavaLangObject.toString().length() + 20) * i);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        awte localawte = (awte)paramList.next();
        localStringBuilder.append("[").append(localSimpleDateFormat.format(new Date(localawte.jdField_a_of_type_Long))).append(":").append(localawte.jdField_a_of_type_JavaLangObject.toString()).append("]");
      }
    }
    return localStringBuilder.toString();
  }
  
  public List<awte> a(Object arg1)
  {
    Object localObject1 = new awte();
    ((awte)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
    ((awte)localObject1).jdField_a_of_type_JavaLangObject = ???;
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.addLast(localObject1);
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() < this.jdField_a_of_type_Int) {
        return null;
      }
      awte localawte = (awte)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
      if (((awte)localObject1).jdField_a_of_type_Long - localawte.jdField_a_of_type_Long < this.jdField_a_of_type_Long)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awtd
 * JD-Core Version:    0.7.0.1
 */