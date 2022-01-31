import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqprotect.qsec.QSecLibMgr;
import com.tencent.qqprotect.qsec.QSecLibMgr.LibEventListener;
import java.util.List;

public class amff
  extends Handler
{
  public amff(QSecLibMgr paramQSecLibMgr, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        QSecLibMgr.a(this.a);
        return;
      } while (paramMessage.obj == null);
      QSecLibMgr.a(this.a, (List)paramMessage.obj);
      return;
      QSecLibMgr.b(this.a);
      return;
      QSecLibMgr.c(this.a);
      return;
    } while (paramMessage.obj == null);
    QSecLibMgr.a(this.a, (QSecLibMgr.LibEventListener)paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     amff
 * JD-Core Version:    0.7.0.1
 */