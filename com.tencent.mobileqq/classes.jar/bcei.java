import android.text.Spannable;
import java.util.Comparator;

final class bcei
  implements Comparator<bceh>
{
  bcei(Spannable paramSpannable) {}
  
  public int a(bceh parambceh1, bceh parambceh2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambceh1);
    int k = this.a.getSpanStart(parambceh2);
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
 * Qualified Name:     bcei
 * JD-Core Version:    0.7.0.1
 */