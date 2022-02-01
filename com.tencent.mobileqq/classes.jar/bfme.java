import android.text.Spannable;
import java.util.Comparator;

final class bfme
  implements Comparator<bfmd>
{
  bfme(Spannable paramSpannable) {}
  
  public int a(bfmd parambfmd1, bfmd parambfmd2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambfmd1);
    int k = this.a.getSpanStart(parambfmd2);
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
 * Qualified Name:     bfme
 * JD-Core Version:    0.7.0.1
 */