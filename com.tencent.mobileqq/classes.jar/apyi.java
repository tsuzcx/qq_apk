import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.bubble.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

public class apyi
  extends Handler
{
  private QQAnimationDrawable b;
  
  public apyi(QQAnimationDrawable paramQQAnimationDrawable1, QQAnimationDrawable paramQQAnimationDrawable2)
  {
    this.b = paramQQAnimationDrawable2;
  }
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("InternalHandler handleMessage msg.what:").append(paramMessage.what).append(" main:");
    if (Looper.myLooper() == Looper.getMainLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QQAnimationDrawable", 2, bool);
      if (!(paramMessage.obj instanceof Long)) {
        break label170;
      }
      QLog.d("QQAnimationDrawable", 2, "InternalHandler handleMessage msg.obj:" + paramMessage.obj + " android.os.SystemClock.uptimeMillis():" + SystemClock.uptimeMillis());
      paramMessage = (Long)paramMessage.obj;
      if (paramMessage.longValue() >= SystemClock.uptimeMillis()) {
        break;
      }
      QLog.d("QQAnimationDrawable", 2, "time < android.os.SystemClock.uptimeMillis()");
      this.a.scheduleSelf(this.b, SystemClock.uptimeMillis());
      return;
    }
    QLog.d("QQAnimationDrawable", 2, "time > android.os.SystemClock.uptimeMillis()");
    this.a.scheduleSelf(this.b, paramMessage.longValue());
    return;
    label170:
    QLog.d("QQAnimationDrawable", 2, "InternalHandler handleMessage msg.obj:" + paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyi
 * JD-Core Version:    0.7.0.1
 */