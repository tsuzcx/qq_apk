import java.util.Comparator;

class axqu
  implements Comparator<axpr>
{
  axqu(axqs paramaxqs) {}
  
  public int a(axpr paramaxpr1, axpr paramaxpr2)
  {
    if (paramaxpr2.b() > paramaxpr1.b()) {}
    do
    {
      return -1;
      if (paramaxpr2.b() < paramaxpr1.b()) {
        return 1;
      }
    } while (paramaxpr2.a() > paramaxpr1.a());
    if (paramaxpr2.a() == paramaxpr1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqu
 * JD-Core Version:    0.7.0.1
 */