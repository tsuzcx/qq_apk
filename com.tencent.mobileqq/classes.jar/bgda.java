import android.text.Spannable;
import java.util.Comparator;

final class bgda
  implements Comparator<bgcz>
{
  bgda(Spannable paramSpannable) {}
  
  public int a(bgcz parambgcz1, bgcz parambgcz2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambgcz1);
    int k = this.a.getSpanStart(parambgcz2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgda
 * JD-Core Version:    0.7.0.1
 */