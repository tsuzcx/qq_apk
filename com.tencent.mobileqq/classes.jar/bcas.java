import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class bcas
{
  public static bcbv a(bcfj parambcfj)
  {
    int j = 0;
    int i = j;
    if (parambcfj.a != null)
    {
      i = j;
      if (parambcfj.a.a() != null) {
        i = parambcfj.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    bgvo.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new bgif(parambcfj);
    }
    if (i == 2) {
      return new bccf(parambcfj);
    }
    if (i == 3) {
      return new bgwb(parambcfj);
    }
    return new bcbv(parambcfj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcas
 * JD-Core Version:    0.7.0.1
 */