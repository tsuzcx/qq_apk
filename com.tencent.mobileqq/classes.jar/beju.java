import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.QLog;

public class beju
  extends bejt
{
  public beju(int paramInt)
  {
    super(paramInt);
  }
  
  public int a()
  {
    if (WebAccelerateHelper.preloadBrowserView == null)
    {
      WebAccelerateHelper.preInflaterBrowserView();
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "preloadBrowserView on idle.");
      }
    }
    do
    {
      return 2;
      if (SwiftReuseTouchWebView.b != 0) {
        break;
      }
      SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication).a(true);
    } while (!QLog.isColorLevel());
    QLog.d("SwiftBrowserIdleTaskHelper", 2, "preload Webview on idle.");
    return 2;
    long l;
    if (bejq.a() < 5)
    {
      l = System.currentTimeMillis();
      if (System.currentTimeMillis() > bejq.a() + 10000L)
      {
        bejq.a();
        bejq.b();
        bejq.a(l);
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "downloadX5KernelIfNeeded on idle.");
        }
      }
    }
    for (;;)
    {
      return 1;
      if (QLog.isColorLevel())
      {
        QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because time limit:" + l + " - " + bejq.a() + " < 10s.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserIdleTaskHelper", 2, "not need check because count limit:" + bejq.a() + ">=" + 5 + ".");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beju
 * JD-Core Version:    0.7.0.1
 */