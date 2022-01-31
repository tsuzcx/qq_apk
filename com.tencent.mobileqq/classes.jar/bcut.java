import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bcut
  extends Handler
{
  private bcut(bcuq parambcuq) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TVKVideoController", 4, new Object[] { "PlayerStatusHandler msg:", Integer.valueOf(paramMessage.what), " ,arg:", Integer.valueOf(paramMessage.arg1) });
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bcuq.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bcuq.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bcuq.a(this.a)), " ,videoH:", Integer.valueOf(bcuq.b(this.a)) });
                }
                if (bcuq.a(this.a) != null)
                {
                  bcuq.a(this.a).onSetVideoCover(bcuq.a(this.a));
                  bcuq.a(this.a).onVideoSize(bcuq.a(this.a), bcuq.b(this.a));
                }
                this.a.a(bcuq.a(this.a), bcuq.b(this.a));
                bcuq.a(this.a, 2);
                return;
                if (bcuq.a(this.a).get())
                {
                  if (bcuq.a(this.a) != null) {
                    bcuq.a(this.a).onVideoStart((int)bcuq.a(this.a).c());
                  }
                  bcuq.c(this.a);
                  bcuq.a(this.a).set(false);
                  return;
                }
                bcuq.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bcuq.a(this.a, true);
              bcuq.a(this.a, 0);
              bcuq.a(this.a).removeCallbacks(this.a.a);
              if (bcuq.a(this.a) != null) {
                bcuq.a(this.a).e = 0L;
              }
              bcuq.d(this.a);
            } while (bcuq.a(this.a) == null);
            bcuq.a(this.a).onVideoComplete(true);
            bcuq.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bcuq.a(this.a) == null) || (bcuq.a(this.a) == null));
        bcuq.a(this.a, bcuq.a(this.a).a((Context)bcuq.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bcuq.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while (bcuq.a(this.a) == null);
      if (paramMessage.arg1 == 929)
      {
        bcuq.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bcuq.a(this.a).onVideoStart((int)bcuq.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcut
 * JD-Core Version:    0.7.0.1
 */