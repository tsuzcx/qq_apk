import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.webview.swift.SwiftFragmentTabBar;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.qqreader.view.ReaderTabBarView;
import java.util.List;

public class bigj
{
  public static View a(Context paramContext, Intent paramIntent, List<WebViewTabBarData> paramList, biuc parambiuc)
  {
    int i = 0;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("tabBarStyle", 0);
    }
    bmgm.d("WebviewFragmentTabBarBuilder", "tab bar style =" + i);
    if (i == 1)
    {
      paramContext = new QQComicTabBarView(paramContext);
      paramContext.a(paramIntent, paramList, parambiuc);
      return paramContext;
    }
    if (i == 2)
    {
      paramContext = new ReaderTabBarView(paramContext);
      paramContext.a(paramIntent, paramList, parambiuc);
      return paramContext;
    }
    paramContext = new SwiftFragmentTabBar(paramContext);
    paramContext.a(paramList, parambiuc);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigj
 * JD-Core Version:    0.7.0.1
 */