import android.text.Spannable;
import java.util.Comparator;

final class bgmf
  implements Comparator<bgme>
{
  bgmf(Spannable paramSpannable) {}
  
  public int a(bgme parambgme1, bgme parambgme2)
  {
    int i = 0;
    int j = this.a.getSpanStart(parambgme1);
    int k = this.a.getSpanStart(parambgme2);
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
 * Qualified Name:     bgmf
 * JD-Core Version:    0.7.0.1
 */