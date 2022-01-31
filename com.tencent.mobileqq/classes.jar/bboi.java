import java.util.Comparator;

class bboi
  implements Comparator<bboj>
{
  public int a(bboj parambboj1, bboj parambboj2)
  {
    int i = 1;
    if (parambboj1.a == parambboj2.a) {
      if (parambboj1.b == parambboj2.b) {
        i = 0;
      }
    }
    while (parambboj1.a > parambboj2.a)
    {
      do
      {
        return i;
      } while (parambboj1.b > parambboj2.b);
      return -1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bboi
 * JD-Core Version:    0.7.0.1
 */