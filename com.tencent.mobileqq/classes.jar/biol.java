import com.tencent.mobileqq.app.ThreadManager;
import cooperation.comic.utils.QQComicRedTouchManager.PluginRedTouchObserver.1;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public abstract class biol
  implements Observer
{
  public abstract void a();
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new QQComicRedTouchManager.PluginRedTouchObserver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biol
 * JD-Core Version:    0.7.0.1
 */