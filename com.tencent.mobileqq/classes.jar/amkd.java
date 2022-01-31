import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.comic.ui.QQComicTabBarView;
import mqq.os.MqqHandler;

public class amkd
  implements Runnable
{
  public amkd(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2130846384);
    ThreadManager.getUIHandler().post(new amke(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkd
 * JD-Core Version:    0.7.0.1
 */