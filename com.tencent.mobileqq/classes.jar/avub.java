import java.util.Comparator;

final class avub
  implements Comparator<avoj>
{
  public int a(avoj paramavoj1, avoj paramavoj2)
  {
    int j = Long.signum(paramavoj2.b() - paramavoj1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(paramavoj2.a() - paramavoj1.a());
    }
    j = i;
    if (i == 0) {
      j = avtz.a(paramavoj1, paramavoj2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avub
 * JD-Core Version:    0.7.0.1
 */