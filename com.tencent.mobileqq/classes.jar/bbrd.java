import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bbrd
  extends Handler
{
  private bbrd(bbra parambbra) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bbra.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bbra.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bbra.a(this.a)), " ,videoH:", Integer.valueOf(bbra.b(this.a)) });
                }
                if (bbra.a(this.a) != null)
                {
                  bbra.a(this.a).onSetVideoCover(bbra.a(this.a));
                  bbra.a(this.a).onVideoSize(bbra.a(this.a), bbra.b(this.a));
                }
                this.a.a(bbra.a(this.a), bbra.b(this.a));
                bbra.a(this.a, 2);
                return;
                if (bbra.a(this.a).get())
                {
                  if (bbra.a(this.a) != null) {
                    bbra.a(this.a).onVideoStart((int)bbra.a(this.a).c());
                  }
                  bbra.c(this.a);
                  bbra.a(this.a).set(false);
                  return;
                }
                bbra.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bbra.a(this.a, true);
              bbra.a(this.a, 0);
              bbra.a(this.a).removeCallbacks(this.a.a);
              if (bbra.a(this.a) != null) {
                bbra.a(this.a).e = 0L;
              }
              bbra.d(this.a);
            } while (bbra.a(this.a) == null);
            bbra.a(this.a).onVideoComplete(true);
            bbra.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bbra.a(this.a) == null) || (bbra.a(this.a) == null));
        bbra.a(this.a, bbra.a(this.a).a((Context)bbra.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bbra.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while (bbra.a(this.a) == null);
      if (paramMessage.arg1 == 929)
      {
        bbra.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bbra.a(this.a).onVideoStart((int)bbra.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbrd
 * JD-Core Version:    0.7.0.1
 */