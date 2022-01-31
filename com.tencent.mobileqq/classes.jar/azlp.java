import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azlp
{
  public char a;
  public int a;
  public List<azlp> a;
  public int b;
  
  public azlp(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public azlp a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      azlp localazlp = (azlp)localIterator.next();
      if (localazlp.jdField_a_of_type_Char == paramChar) {
        return localazlp;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(azlp paramazlp)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramazlp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlp
 * JD-Core Version:    0.7.0.1
 */