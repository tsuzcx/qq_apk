import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bhmo
  extends Handler
{
  private bhmo(bhml parambhml) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bhml.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bhml.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bhml.a(this.a)), " ,videoH:", Integer.valueOf(bhml.b(this.a)) });
                }
                if (bhml.a(this.a) != null)
                {
                  bhml.a(this.a).onSetVideoCover(bhml.a(this.a));
                  bhml.a(this.a).onVideoSize(bhml.a(this.a), bhml.b(this.a));
                }
                this.a.a(bhml.a(this.a), bhml.b(this.a));
                bhml.a(this.a, 2);
                return;
                if (bhml.a(this.a).get())
                {
                  if (bhml.a(this.a) != null) {
                    bhml.a(this.a).onVideoStart((int)bhml.a(this.a).c());
                  }
                  bhml.c(this.a);
                  bhml.a(this.a).set(false);
                  return;
                }
                bhml.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bhml.a(this.a, true);
              bhml.a(this.a, 0);
              bhml.a(this.a).removeCallbacks(this.a.a);
              if (bhml.a(this.a) != null) {
                bhml.a(this.a).e = 0L;
              }
              bhml.d(this.a);
            } while (bhml.a(this.a) == null);
            bhml.a(this.a).onVideoComplete(true);
            bhml.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bhml.a(this.a) == null) || (bhml.a(this.a) == null));
        bhml.a(this.a, bhml.a(this.a).a((Context)bhml.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bhml.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while ((bhml.a(this.a) == null) || (bhml.c(this.a) == 4));
      if (paramMessage.arg1 == 929)
      {
        bhml.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bhml.a(this.a).onVideoStart((int)bhml.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhmo
 * JD-Core Version:    0.7.0.1
 */