import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class awqd
{
  public char a;
  public int a;
  public List<awqd> a;
  public int b;
  
  public awqd(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public awqd a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      awqd localawqd = (awqd)localIterator.next();
      if (localawqd.jdField_a_of_type_Char == paramChar) {
        return localawqd;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(awqd paramawqd)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramawqd);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id: ").append(this.jdField_a_of_type_Int).append(" ");
    localStringBuilder.append("char: ").append(this.jdField_a_of_type_Char).append(" ");
    localStringBuilder.append("cnt: ").append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqd
 * JD-Core Version:    0.7.0.1
 */