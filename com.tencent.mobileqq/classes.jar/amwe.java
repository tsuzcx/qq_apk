import android.os.Handler;
import com.tencent.mobileqq.richmedia.capture.audio.AudioCapture;
import com.tencent.mobileqq.richmedia.capture.audio.AudioDataCache;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.humrecognition.HummingActivity;
import dov.com.qq.im.capture.music.humrecognition.humming.IRecognizer;
import java.io.File;

public class amwe
  implements Runnable
{
  public amwe(HummingActivity paramHummingActivity) {}
  
  public void run()
  {
    HummingActivity.a(this.a);
    if (HummingActivity.a(this.a)) {
      HummingActivity.a(this.a).sendEmptyMessage(4);
    }
    do
    {
      return;
      if (HummingActivity.b(this.a) >= 5)
      {
        HummingActivity.a(this.a).sendEmptyMessage(5);
        return;
      }
    } while (HummingActivity.a(this.a).a == null);
    File localFile = new File(HummingActivity.a(this.a).a.b());
    if (localFile.exists()) {
      HummingActivity.a(this.a).a(localFile);
    }
    HummingActivity.a(this.a).a();
    HummingActivity.a(this.a).postDelayed(this, 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amwe
 * JD-Core Version:    0.7.0.1
 */