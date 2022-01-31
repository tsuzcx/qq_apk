import cooperation.qzone.cache.FileCacheService;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;

public final class ankr
  implements Runnable
{
  public ankr(String paramString) {}
  
  public void run()
  {
    QzoneOfflineCacheHelper.access$000().a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ankr
 * JD-Core Version:    0.7.0.1
 */