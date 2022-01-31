import com.tencent.qphone.base.util.QLog;
import cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver;

public class amko
  implements Runnable
{
  public amko(QQComicRedTouchManager.PluginRedTouchObserver paramPluginRedTouchObserver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PluginRedTouchManager", 2, "onReceiveNewRedTouch()");
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amko
 * JD-Core Version:    0.7.0.1
 */