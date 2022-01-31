import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class beah
{
  public static bebk a(beey parambeey)
  {
    int j = 0;
    int i = j;
    if (parambeey.a != null)
    {
      i = j;
      if (parambeey.a.a() != null) {
        i = parambeey.a.a().getIntExtra("titleBarStyle", 0);
      }
    }
    bixe.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new biju(parambeey);
    }
    if (i == 2) {
      return new bebu(parambeey);
    }
    if (i == 3) {
      return new bixp(parambeey);
    }
    if (i == 4) {
      return new ucy(parambeey);
    }
    return new bebk(parambeey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beah
 * JD-Core Version:    0.7.0.1
 */