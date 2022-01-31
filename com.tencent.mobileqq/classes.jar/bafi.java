import android.text.Spannable;
import java.util.Comparator;

final class bafi
  implements Comparator<bafh>
{
  bafi(Spannable paramSpannable) {}
  
  public int a(bafh parambafh1, bafh parambafh2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambafh1);
    int k = this.a.getSpanStart(parambafh2);
    if (j < k) {
      i = -1;
    }
    while (j <= k) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bafi
 * JD-Core Version:    0.7.0.1
 */