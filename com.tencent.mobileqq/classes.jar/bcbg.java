import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class bcbg
{
  public static bccj a(bcfx parambcfx)
  {
    int j = 0;
    int i = j;
    if (parambcfx.a != null)
    {
      i = j;
      if (parambcfx.a.a() != null) {
        i = parambcfx.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    bgwf.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new bgiw(parambcfx);
    }
    if (i == 2) {
      return new bcct(parambcfx);
    }
    if (i == 3) {
      return new bgws(parambcfx);
    }
    return new bccj(parambcfx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcbg
 * JD-Core Version:    0.7.0.1
 */