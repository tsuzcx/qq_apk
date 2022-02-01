import java.util.Comparator;

final class bhks
  implements Comparator<bhkt>
{
  public int a(bhkt parambhkt1, bhkt parambhkt2)
  {
    return parambhkt2.a() - parambhkt1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhks
 * JD-Core Version:    0.7.0.1
 */