import java.util.Comparator;

class amru
  implements Comparator<amrw>
{
  amru(amrt paramamrt) {}
  
  public int a(amrw paramamrw1, amrw paramamrw2)
  {
    if (paramamrw1.a == paramamrw2.a) {
      return 0;
    }
    if (paramamrw1.a > paramamrw2.a) {
      return 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amru
 * JD-Core Version:    0.7.0.1
 */