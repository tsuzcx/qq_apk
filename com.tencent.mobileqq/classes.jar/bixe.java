import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bixe
  extends Handler
{
  private bixe(bixb parambixb) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bixb.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bixb.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bixb.a(this.a)), " ,videoH:", Integer.valueOf(bixb.b(this.a)) });
                }
                if (bixb.a(this.a) != null)
                {
                  bixb.a(this.a).onSetVideoCover(bixb.a(this.a));
                  bixb.a(this.a).onVideoSize(bixb.a(this.a), bixb.b(this.a));
                }
                this.a.a(bixb.a(this.a), bixb.b(this.a));
                bixb.a(this.a, 2);
                return;
                if (bixb.a(this.a).get())
                {
                  if (bixb.a(this.a) != null) {
                    bixb.a(this.a).onVideoStart((int)bixb.a(this.a).c());
                  }
                  bixb.c(this.a);
                  bixb.a(this.a).set(false);
                  return;
                }
                bixb.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bixb.a(this.a, true);
              bixb.a(this.a, 0);
              bixb.a(this.a).removeCallbacks(this.a.a);
              if (bixb.a(this.a) != null) {
                bixb.a(this.a).e = 0L;
              }
              bixb.d(this.a);
            } while (bixb.a(this.a) == null);
            bixb.a(this.a).onVideoComplete(true);
            bixb.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bixb.a(this.a) == null) || (bixb.a(this.a) == null));
        bixb.a(this.a, bixb.a(this.a).a((Context)bixb.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bixb.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while ((bixb.a(this.a) == null) || (bixb.c(this.a) == 4));
      if (paramMessage.arg1 == 929)
      {
        bixb.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bixb.a(this.a).onVideoStart((int)bixb.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixe
 * JD-Core Version:    0.7.0.1
 */