import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class beuc
  extends Handler
{
  private beuc(betz parambetz) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(betz.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(betz.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(betz.a(this.a)), " ,videoH:", Integer.valueOf(betz.b(this.a)) });
                }
                if (betz.a(this.a) != null)
                {
                  betz.a(this.a).onSetVideoCover(betz.a(this.a));
                  betz.a(this.a).onVideoSize(betz.a(this.a), betz.b(this.a));
                }
                this.a.a(betz.a(this.a), betz.b(this.a));
                betz.a(this.a, 2);
                return;
                if (betz.a(this.a).get())
                {
                  if (betz.a(this.a) != null) {
                    betz.a(this.a).onVideoStart((int)betz.a(this.a).c());
                  }
                  betz.c(this.a);
                  betz.a(this.a).set(false);
                  return;
                }
                betz.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              betz.a(this.a, true);
              betz.a(this.a, 0);
              betz.a(this.a).removeCallbacks(this.a.a);
              if (betz.a(this.a) != null) {
                betz.a(this.a).e = 0L;
              }
              betz.d(this.a);
            } while (betz.a(this.a) == null);
            betz.a(this.a).onVideoComplete(true);
            betz.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((betz.a(this.a) == null) || (betz.a(this.a) == null));
        betz.a(this.a, betz.a(this.a).a((Context)betz.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        betz.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while (betz.a(this.a) == null);
      if (paramMessage.arg1 == 929)
      {
        betz.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    betz.a(this.a).onVideoStart((int)betz.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuc
 * JD-Core Version:    0.7.0.1
 */