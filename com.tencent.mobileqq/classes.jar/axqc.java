import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class axqc
{
  public char a;
  public int a;
  public List<axqc> a;
  public int b;
  
  public axqc(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public axqc a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      axqc localaxqc = (axqc)localIterator.next();
      if (localaxqc.jdField_a_of_type_Char == paramChar) {
        return localaxqc;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(axqc paramaxqc)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramaxqc);
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
 * Qualified Name:     axqc
 * JD-Core Version:    0.7.0.1
 */