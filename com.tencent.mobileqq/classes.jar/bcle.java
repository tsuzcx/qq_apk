import java.util.Comparator;

final class bcle
  implements Comparator<bcfn>
{
  public int a(bcfn parambcfn1, bcfn parambcfn2)
  {
    int j = Long.signum(parambcfn2.b() - parambcfn1.b());
    int i = j;
    if (j == 0) {
      i = Long.signum(parambcfn2.a() - parambcfn1.a());
    }
    j = i;
    if (i == 0) {
      j = bclc.a(parambcfn1, parambcfn2);
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcle
 * JD-Core Version:    0.7.0.1
 */