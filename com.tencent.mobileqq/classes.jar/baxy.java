import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class baxy
{
  public static bazb a(bbcj parambbcj)
  {
    int j = 0;
    int i = j;
    if (parambbcj.a != null)
    {
      i = j;
      if (parambbcj.a.a() != null) {
        i = parambbcj.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    bfne.c("SwiftWebTitleBuilder", "style is" + i);
    if (i == 1) {
      return new bfao(parambbcj);
    }
    if (i == 2) {
      return new bazl(parambbcj);
    }
    if (i == 3) {
      return new bfnu(parambbcj);
    }
    return new bazb(parambbcj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     baxy
 * JD-Core Version:    0.7.0.1
 */