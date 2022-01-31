import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory;
import dov.com.tencent.biz.qqstory.takevideo.rmw.StoryFaceDrawableFactory.FaceDrawableListener;

public class anni
  extends Handler
{
  public anni(StoryFaceDrawableFactory paramStoryFaceDrawableFactory, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      paramMessage = (String)paramMessage.obj;
      this.a.a(paramMessage);
    }
    while ((paramMessage.what != 1002) || (this.a.a == null)) {
      return;
    }
    this.a.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anni
 * JD-Core Version:    0.7.0.1
 */