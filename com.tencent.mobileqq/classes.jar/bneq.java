import java.util.Comparator;

final class bneq
  implements Comparator<bnes>
{
  public int a(bnes parambnes1, bnes parambnes2)
  {
    if (parambnes1.a) {
      return 1;
    }
    if (parambnes2.a) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneq
 * JD-Core Version:    0.7.0.1
 */