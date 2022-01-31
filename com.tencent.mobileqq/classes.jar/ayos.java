import java.util.Comparator;

public class ayos
  implements Comparator<ayoq>
{
  public int a(ayoq paramayoq1, ayoq paramayoq2)
  {
    if (paramayoq1.b < paramayoq2.b) {
      return 1;
    }
    if (paramayoq1.b == paramayoq2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayos
 * JD-Core Version:    0.7.0.1
 */