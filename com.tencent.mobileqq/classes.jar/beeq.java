import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class beeq
{
  public static beft a(bejh parambejh)
  {
    int j = 0;
    int i = j;
    if (parambejh.a != null)
    {
      i = j;
      if (parambejh.a.a() != null) {
        i = parambejh.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    bjbl.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new biob(parambejh);
    }
    if (i == 2) {
      return new begd(parambejh);
    }
    if (i == 3) {
      return new bjbw(parambejh);
    }
    if (i == 4) {
      return new ufz(parambejh);
    }
    return new beft(parambejh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beeq
 * JD-Core Version:    0.7.0.1
 */