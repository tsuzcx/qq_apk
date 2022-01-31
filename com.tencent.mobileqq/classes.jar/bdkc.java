import com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer;
import java.util.Observable;
import java.util.Observer;

public class bdkc
  implements Observer
{
  public bdkc(MiniAppVideoPlayer paramMiniAppVideoPlayer) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (!(paramObject instanceof String)) {}
    do
    {
      return;
      if (("resetPlayer".equals((String)paramObject)) && (this.a.y))
      {
        this.a.g();
        this.a.c();
        return;
      }
    } while (!"resumePlayer".equals((String)paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdkc
 * JD-Core Version:    0.7.0.1
 */