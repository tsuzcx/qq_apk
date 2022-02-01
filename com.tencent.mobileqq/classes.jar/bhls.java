import android.content.Intent;
import com.tencent.mobileqq.webview.swift.WebViewFragment;

public class bhls
{
  public static bhmv a(bhql parambhql)
  {
    int j = 0;
    int i = j;
    if (parambhql.a != null)
    {
      i = j;
      if (parambhql.a.getIntent() != null) {
        i = parambhql.a.getIntent().getIntExtra("titleBarStyle", 0);
      }
    }
    blpu.d("SwiftWebTitleBuilder", "title bar style is" + i);
    if (i == 1) {
      return new blbq(parambhql);
    }
    if (i == 2) {
      return new bhnf(parambhql);
    }
    if (i == 3) {
      return new blqf(parambhql);
    }
    if (i == 4) {
      return new vlv(parambhql);
    }
    return new bhmv(parambhql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhls
 * JD-Core Version:    0.7.0.1
 */