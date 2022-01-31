import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader;
import dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.VideoFrameLoaderListener;
import java.lang.ref.WeakReference;
import java.util.List;

public class anmg
  implements Runnable
{
  public anmg(VideoFrameLoader paramVideoFrameLoader) {}
  
  public void run()
  {
    if (VideoFrameLoader.a(this.a) != VideoFrameLoader.a(this.a).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onLoadEnd , framecount error!" + VideoFrameLoader.a(this.a) + "-" + VideoFrameLoader.a(this.a).size());
      }
      if ((!VideoFrameLoader.a(this.a)) && (VideoFrameLoader.a(this.a).size() == 0))
      {
        VideoFrameLoader.a(this.a, true);
        this.a.b();
        VideoFrameLoader.a(this.a, new anmb(VideoFrameLoader.a(this.a), VideoFrameLoader.b(this.a), VideoFrameLoader.c(this.a), VideoFrameLoader.a(this.a), VideoFrameLoader.d(this.a), VideoFrameLoader.a(this.a), VideoFrameLoader.b(this.a), this.a));
        ThreadManager.post(VideoFrameLoader.a(this.a), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (VideoFrameLoader.a(this.a) != null) {}
      for (VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.a).get(); localVideoFrameLoaderListener != null; localVideoFrameLoaderListener = null)
      {
        localVideoFrameLoaderListener.c();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anmg
 * JD-Core Version:    0.7.0.1
 */