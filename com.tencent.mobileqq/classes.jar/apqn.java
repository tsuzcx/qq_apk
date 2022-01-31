import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.freshnews.feed.NearbyImgLoader.RequestLoadedImgTask;

public class apqn
  implements URLDrawableHandler
{
  public apqn(NearbyImgLoader.RequestLoadedImgTask paramRequestLoadedImgTask) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt) {}
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong) {}
  
  public void publishProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apqn
 * JD-Core Version:    0.7.0.1
 */