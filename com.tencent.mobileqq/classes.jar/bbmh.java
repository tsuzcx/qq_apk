import java.util.Comparator;

class bbmh
  implements Comparator<bble>
{
  bbmh(bbmf parambbmf) {}
  
  public int a(bble parambble1, bble parambble2)
  {
    if (parambble2.b() > parambble1.b()) {}
    do
    {
      return -1;
      if (parambble2.b() < parambble1.b()) {
        return 1;
      }
    } while (parambble2.a() > parambble1.a());
    if (parambble2.a() == parambble1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmh
 * JD-Core Version:    0.7.0.1
 */