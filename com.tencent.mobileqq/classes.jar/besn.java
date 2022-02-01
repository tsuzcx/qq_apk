import java.util.Comparator;

public class besn
  implements Comparator<besl>
{
  public int a(besl parambesl1, besl parambesl2)
  {
    if (parambesl1.b < parambesl2.b) {
      return 1;
    }
    if (parambesl1.b == parambesl2.b) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besn
 * JD-Core Version:    0.7.0.1
 */