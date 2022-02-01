import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcdl
{
  public char a;
  public int a;
  public List<bcdl> a;
  public int b;
  
  public bcdl(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public bcdl a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bcdl localbcdl = (bcdl)localIterator.next();
      if (localbcdl.jdField_a_of_type_Char == paramChar) {
        return localbcdl;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(bcdl parambcdl)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambcdl);
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
 * Qualified Name:     bcdl
 * JD-Core Version:    0.7.0.1
 */