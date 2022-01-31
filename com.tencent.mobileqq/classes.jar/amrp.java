import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.comic.ui.QQComicTabBarView;
import mqq.os.MqqHandler;

public class amrp
  implements Runnable
{
  public amrp(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void run()
  {
    Drawable localDrawable = this.a.getResources().getDrawable(2130846466);
    ThreadManager.getUIHandler().post(new amrq(this, localDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amrp
 * JD-Core Version:    0.7.0.1
 */