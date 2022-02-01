import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bcrz
{
  public char a;
  public int a;
  public List<bcrz> a;
  public int b;
  
  public bcrz(int paramInt, char paramChar)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Char = paramChar;
    this.b = 1;
  }
  
  public bcrz a(char paramChar)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bcrz localbcrz = (bcrz)localIterator.next();
      if (localbcrz.jdField_a_of_type_Char == paramChar) {
        return localbcrz;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void a(bcrz parambcrz)
  {
    this.jdField_a_of_type_JavaUtilList.add(parambcrz);
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
 * Qualified Name:     bcrz
 * JD-Core Version:    0.7.0.1
 */