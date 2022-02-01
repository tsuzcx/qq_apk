import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class bimn
{
  public static binq a(birg parambirg)
  {
    int j = 0;
    int i = j;
    if (parambirg.a != null)
    {
      i = j;
      if (parambirg.a.getIntent() != null) {
        i = parambirg.a.getIntent().getIntExtra("titleBarStyle", 0);
      }
    }
    bmqw.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new bmct(parambirg);
    }
    if (i == 2) {
      return new bioa(parambirg);
    }
    if (i == 3) {
      return new bmrh(parambirg);
    }
    if (i == 4) {
      return new vnz(parambirg);
    }
    return new binq(parambirg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimn
 * JD-Core Version:    0.7.0.1
 */