import java.util.Comparator;
import java.util.Map.Entry;

final class audu
  implements Comparator<Map.Entry<String, Integer>>
{
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    return ((Integer)paramEntry2.getValue()).intValue() - ((Integer)paramEntry1.getValue()).intValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     audu
 * JD-Core Version:    0.7.0.1
 */