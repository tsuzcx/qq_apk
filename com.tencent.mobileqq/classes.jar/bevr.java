import android.text.Spannable;
import java.util.Comparator;

final class bevr
  implements Comparator<bevq>
{
  bevr(Spannable paramSpannable) {}
  
  public int a(bevq parambevq1, bevq parambevq2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambevq1);
    int k = this.a.getSpanStart(parambevq2);
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
 * Qualified Name:     bevr
 * JD-Core Version:    0.7.0.1
 */