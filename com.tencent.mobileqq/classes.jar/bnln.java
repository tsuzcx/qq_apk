import java.util.Comparator;

final class bnln
  implements Comparator<bnlp>
{
  public int a(bnlp parambnlp1, bnlp parambnlp2)
  {
    if (parambnlp1.a) {
      return 1;
    }
    if (parambnlp2.a) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnln
 * JD-Core Version:    0.7.0.1
 */