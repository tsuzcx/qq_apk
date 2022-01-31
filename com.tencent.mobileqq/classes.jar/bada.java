import java.util.Comparator;

class bada
  implements Comparator<badc>
{
  bada(bacz parambacz) {}
  
  public int a(badc parambadc1, badc parambadc2)
  {
    if (parambadc1.b < parambadc2.b) {
      return -1;
    }
    if (parambadc1.b > parambadc2.b) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bada
 * JD-Core Version:    0.7.0.1
 */