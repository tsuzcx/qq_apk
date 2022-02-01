import com.tencent.mobileqq.colornote.data.ColorNote;
import java.util.Comparator;

class aqcw
  implements Comparator<ColorNote>
{
  aqcw(aqcv paramaqcv) {}
  
  public int a(ColorNote paramColorNote1, ColorNote paramColorNote2)
  {
    int j = 0;
    int k = 1;
    boolean bool1 = aqda.c(paramColorNote1);
    boolean bool2 = aqda.c(paramColorNote2);
    int i;
    if ((bool1) && (bool2)) {
      i = aqcv.a(this.a, paramColorNote1, paramColorNote2);
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
        bool1 = aqda.b(paramColorNote1);
        bool2 = aqda.b(paramColorNote2);
        if ((bool1) && (bool2)) {
          return aqcv.a(this.a, paramColorNote1, paramColorNote2);
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
        return aqcv.a(this.a, paramColorNote1, paramColorNote2);
      }
      if (i != 0) {
        return -1;
      }
      i = k;
    } while (j != 0);
    return aqcv.a(this.a, paramColorNote1, paramColorNote2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqcw
 * JD-Core Version:    0.7.0.1
 */