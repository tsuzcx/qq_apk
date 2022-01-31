import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.TbsAccelerator;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.video.QzoneLiveVideoInterface;
import cooperation.qzone.webviewwrapper.IWebviewOnClassLoaded;

public final class amla
  implements Runnable
{
  public amla(IWebviewOnClassLoaded paramIWebviewOnClassLoaded) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (1 != QzoneLiveVideoInterface.getIntConfig("LiveSetting", "qzone_webview_need_preload_dex_classes", 1)) {
          return;
        }
        if (!QzoneLiveVideoInterface.isBestPerformanceDevice()) {
          break;
        }
        if (!SwiftWebAccelerator.TbsAccelerator.a())
        {
          long l = System.currentTimeMillis();
          SwiftWebAccelerator.TbsAccelerator.b();
          QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator init cost " + (System.currentTimeMillis() - l));
          if (this.a == null) {
            break;
          }
          this.a.a();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("QzoneLiveVideoInterface", 1, localException, new Object[0]);
        return;
      }
      QLog.i("QzoneLiveVideoInterface", 2, "saxon@ 预加载 TbsAccelerator is inited");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amla
 * JD-Core Version:    0.7.0.1
 */