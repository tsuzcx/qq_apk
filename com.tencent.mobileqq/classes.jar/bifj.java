import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bifj
  extends Handler
{
  private bifj(bifg parambifg) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bifg.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bifg.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bifg.a(this.a)), " ,videoH:", Integer.valueOf(bifg.b(this.a)) });
                }
                if (bifg.a(this.a) != null)
                {
                  bifg.a(this.a).onSetVideoCover(bifg.a(this.a));
                  bifg.a(this.a).onVideoSize(bifg.a(this.a), bifg.b(this.a));
                }
                this.a.a(bifg.a(this.a), bifg.b(this.a));
                bifg.a(this.a, 2);
                return;
                if (bifg.a(this.a).get())
                {
                  if (bifg.a(this.a) != null) {
                    bifg.a(this.a).onVideoStart((int)bifg.a(this.a).c());
                  }
                  bifg.c(this.a);
                  bifg.a(this.a).set(false);
                  return;
                }
                bifg.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bifg.a(this.a, true);
              bifg.a(this.a, 0);
              bifg.a(this.a).removeCallbacks(this.a.a);
              if (bifg.a(this.a) != null) {
                bifg.a(this.a).e = 0L;
              }
              bifg.d(this.a);
            } while (bifg.a(this.a) == null);
            bifg.a(this.a).onVideoComplete(true);
            bifg.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bifg.a(this.a) == null) || (bifg.a(this.a) == null));
        bifg.a(this.a, bifg.a(this.a).a((Context)bifg.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bifg.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while ((bifg.a(this.a) == null) || (bifg.c(this.a) == 4));
      if (paramMessage.arg1 == 929)
      {
        bifg.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bifg.a(this.a).onVideoStart((int)bifg.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bifj
 * JD-Core Version:    0.7.0.1
 */