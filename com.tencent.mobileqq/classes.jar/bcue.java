import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bcue
  extends Handler
{
  private bcue(bcub parambcub) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bcub.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bcub.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bcub.a(this.a)), " ,videoH:", Integer.valueOf(bcub.b(this.a)) });
                }
                if (bcub.a(this.a) != null)
                {
                  bcub.a(this.a).onSetVideoCover(bcub.a(this.a));
                  bcub.a(this.a).onVideoSize(bcub.a(this.a), bcub.b(this.a));
                }
                this.a.a(bcub.a(this.a), bcub.b(this.a));
                bcub.a(this.a, 2);
                return;
                if (bcub.a(this.a).get())
                {
                  if (bcub.a(this.a) != null) {
                    bcub.a(this.a).onVideoStart((int)bcub.a(this.a).c());
                  }
                  bcub.c(this.a);
                  bcub.a(this.a).set(false);
                  return;
                }
                bcub.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bcub.a(this.a, true);
              bcub.a(this.a, 0);
              bcub.a(this.a).removeCallbacks(this.a.a);
              if (bcub.a(this.a) != null) {
                bcub.a(this.a).e = 0L;
              }
              bcub.d(this.a);
            } while (bcub.a(this.a) == null);
            bcub.a(this.a).onVideoComplete(true);
            bcub.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bcub.a(this.a) == null) || (bcub.a(this.a) == null));
        bcub.a(this.a, bcub.a(this.a).a((Context)bcub.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bcub.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while (bcub.a(this.a) == null);
      if (paramMessage.arg1 == 929)
      {
        bcub.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bcub.a(this.a).onVideoStart((int)bcub.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcue
 * JD-Core Version:    0.7.0.1
 */