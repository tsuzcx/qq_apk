import java.util.Comparator;

class bett
  implements Comparator<betu>
{
  bett(bets parambets) {}
  
  public int a(betu parambetu1, betu parambetu2)
  {
    if (parambetu1.b() < parambetu2.b()) {
      return 1;
    }
    if (parambetu1.b() > parambetu2.b()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bett
 * JD-Core Version:    0.7.0.1
 */