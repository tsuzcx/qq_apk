import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cooperation.comic.ui.QQComicTabBarView;

public class amka
  extends Handler
{
  public amka(QQComicTabBarView paramQQComicTabBarView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.b = 0.0F;
      QQComicTabBarView.a(this.a);
      super.sendMessageDelayed(this.a.a.obtainMessage(1), 16L);
      return;
    case 1: 
      if (this.a.b < 1.0F)
      {
        paramMessage = this.a;
        paramMessage.b += 0.05F;
        QQComicTabBarView.b(this.a);
        super.sendMessageDelayed(this.a.a.obtainMessage(1), 16L);
        return;
      }
      super.sendMessageDelayed(this.a.a.obtainMessage(2), 16L);
      return;
    }
    this.a.b = 1.0F;
    this.a.a(this.a.i, this.a.h);
    this.a.i = this.a.h;
    QQComicTabBarView.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amka
 * JD-Core Version:    0.7.0.1
 */