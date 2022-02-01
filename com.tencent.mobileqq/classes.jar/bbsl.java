import java.util.Comparator;

final class bbsl
  implements Comparator<bbmu>
{
  public int a(bbmu parambbmu1, bbmu parambbmu2)
  {
    int j = Long.signum(parambbmu2.b() - parambbmu1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambbmu2.a() - parambbmu1.a());
    }
    j = i;
    if (i == 0) {
      j = bbsj.a(parambbmu1, parambbmu2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsl
 * JD-Core Version:    0.7.0.1
 */