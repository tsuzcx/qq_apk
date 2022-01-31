import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class beyl
  extends Handler
{
  private beyl(beyi parambeyi) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(beyi.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(beyi.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(beyi.a(this.a)), " ,videoH:", Integer.valueOf(beyi.b(this.a)) });
                }
                if (beyi.a(this.a) != null)
                {
                  beyi.a(this.a).onSetVideoCover(beyi.a(this.a));
                  beyi.a(this.a).onVideoSize(beyi.a(this.a), beyi.b(this.a));
                }
                this.a.a(beyi.a(this.a), beyi.b(this.a));
                beyi.a(this.a, 2);
                return;
                if (beyi.a(this.a).get())
                {
                  if (beyi.a(this.a) != null) {
                    beyi.a(this.a).onVideoStart((int)beyi.a(this.a).c());
                  }
                  beyi.c(this.a);
                  beyi.a(this.a).set(false);
                  return;
                }
                beyi.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              beyi.a(this.a, true);
              beyi.a(this.a, 0);
              beyi.a(this.a).removeCallbacks(this.a.a);
              if (beyi.a(this.a) != null) {
                beyi.a(this.a).e = 0L;
              }
              beyi.d(this.a);
            } while (beyi.a(this.a) == null);
            beyi.a(this.a).onVideoComplete(true);
            beyi.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((beyi.a(this.a) == null) || (beyi.a(this.a) == null));
        beyi.a(this.a, beyi.a(this.a).a((Context)beyi.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        beyi.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while (beyi.a(this.a) == null);
      if (paramMessage.arg1 == 929)
      {
        beyi.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    beyi.a(this.a).onVideoStart((int)beyi.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyl
 * JD-Core Version:    0.7.0.1
 */