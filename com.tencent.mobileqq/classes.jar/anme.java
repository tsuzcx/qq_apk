import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.VideoFrameLoaderListener;
import java.lang.ref.WeakReference;

public class anme
  implements Runnable
{
  public anme(VideoFrameLoader paramVideoFrameLoader) {}
  
  public void run()
  {
    VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = null;
    if (VideoFrameLoader.a(this.a) != null) {
      localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.a).get();
    }
    if (localVideoFrameLoaderListener != null) {
      localVideoFrameLoaderListener.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anme
 * JD-Core Version:    0.7.0.1
 */