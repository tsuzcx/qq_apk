import java.util.Comparator;
import java.util.Map.Entry;

class bdme
  implements Comparator<Map.Entry<String, Integer>>
{
  bdme(bdmd parambdmd) {}
  
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return -((Integer)paramEntry1.getValue()).compareTo((Integer)paramEntry2.getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdme
 * JD-Core Version:    0.7.0.1
 */