import android.content.Context;
import android.media.AudioManager;
import com.tencent.common.app.BaseApplicationImpl;

public class bljh
{
  private AudioManager a;
  
  public void a()
  {
    this.a = ((AudioManager)BaseApplicationImpl.getContext().getSystemService("audio"));
    this.a.requestAudioFocus(null, 3, 2);
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljh
 * JD-Core Version:    0.7.0.1
 */