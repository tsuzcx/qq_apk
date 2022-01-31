import android.text.Spannable;
import java.util.Comparator;

final class bcir
  implements Comparator<bciq>
{
  bcir(Spannable paramSpannable) {}
  
  public int a(bciq parambciq1, bciq parambciq2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambciq1);
    int k = this.a.getSpanStart(parambciq2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcir
 * JD-Core Version:    0.7.0.1
 */