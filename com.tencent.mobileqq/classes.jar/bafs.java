import java.util.Comparator;

class bafs
  implements Comparator<baep>
{
  bafs(bafq parambafq) {}
  
  public int a(baep parambaep1, baep parambaep2)
  {
    if (parambaep2.b() > parambaep1.b()) {}
    do
    {
      return -1;
      if (parambaep2.b() < parambaep1.b()) {
        return 1;
      }
    } while (parambaep2.a() > parambaep1.a());
    if (parambaep2.a() == parambaep1.a()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafs
 * JD-Core Version:    0.7.0.1
 */