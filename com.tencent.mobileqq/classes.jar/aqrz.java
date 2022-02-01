import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.Comparator;

class aqrz
  implements Comparator<ColorNote>
{
  aqrz(aqry paramaqry) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    int j = 0;
    int k = 1;
    boolean bool1 = aqsd.c(paramColorNote1);
    boolean bool2 = aqsd.c(paramColorNote2);
    int i;
    if ((bool1) && (bool2)) {
      i = aqry.a(this.a, paramColorNote1, paramColorNote2);
    }
    do
    {
      do
      {
        do
        {
          return i;
          if (bool1) {
            return -1;
          }
          i = k;
        } while (bool2);
        bool1 = aqsd.b(paramColorNote1);
        bool2 = aqsd.b(paramColorNote2);
        if ((bool1) && (bool2)) {
          return aqry.a(this.a, paramColorNote1, paramColorNote2);
        }
        if (bool1) {
          return -1;
        }
        i = k;
      } while (bool2);
      if (paramColorNote1.getServiceType() == 16973824) {}
      for (i = 1;; i = 0)
      {
        if (paramColorNote2.getServiceType() == 16973824) {
          j = 1;
        }
        if ((i == 0) || (j == 0)) {
          break;
        }
        return aqry.a(this.a, paramColorNote1, paramColorNote2);
      }
      if (i != 0) {
        return -1;
      }
      i = k;
    } while (j != 0);
    return aqry.a(this.a, paramColorNote1, paramColorNote2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrz
 * JD-Core Version:    0.7.0.1
 */