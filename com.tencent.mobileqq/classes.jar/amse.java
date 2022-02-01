import java.util.Comparator;

class amse
  implements Comparator<amsf>
{
  amse(amsd paramamsd) {}
  
  public int a(amsf paramamsf1, amsf paramamsf2)
  {
    if (paramamsf1.a == paramamsf2.a) {
      return 0;
    }
    if (paramamsf1.a > paramamsf2.a) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amse
 * JD-Core Version:    0.7.0.1
 */