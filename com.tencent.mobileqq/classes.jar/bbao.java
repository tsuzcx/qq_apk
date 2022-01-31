import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.List;

public class bbao
{
  public static View a(Context paramContext, Intent paramIntent, List<WebViewTabBarData> paramList, bbom parambbom)
  {
    int i = 0;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("tabBarStyle", 0);
    }
    if (i == 1)
    {
      paramContext = new QQComicTabBarView(paramContext);
      paramContext.a(paramIntent, paramList, parambbom);
      return paramContext;
    }
    if (i == 2)
    {
      bfne.c("WebviewFragmentTabBarBuilder", "style is reader");
      paramContext = new ReaderTabBarView(paramContext);
      paramContext.a(paramIntent, paramList, parambbom);
      return paramContext;
    }
    paramContext = new SwiftFragmentTabBar(paramContext);
    paramContext.a(paramList, parambbom);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbao
 * JD-Core Version:    0.7.0.1
 */