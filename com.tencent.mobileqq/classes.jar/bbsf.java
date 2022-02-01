import java.util.Comparator;

final class bbsf
  implements Comparator<bbmu>
{
  public int a(bbmu parambbmu1, bbmu parambbmu2)
  {
    int i;
    if (parambbmu2.a() == null) {
      i = -1;
    }
    int j;
    do
    {
      return i;
      if (parambbmu1.a() == null) {
        return 1;
      }
      j = Integer.signum(parambbmu2.a().c - parambbmu1.a().c);
      i = j;
    } while (j != 0);
    return bbse.a(parambbmu1, parambbmu2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsf
 * JD-Core Version:    0.7.0.1
 */