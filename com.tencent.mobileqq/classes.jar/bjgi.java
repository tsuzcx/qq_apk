import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

public class bjgi
  extends Handler
{
  private bjgi(bjgf parambjgf) {}
  
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
                  QLog.d("TVKVideoController", 2, new Object[] { "MEDIA_PREPAREING viewW:", Integer.valueOf(bjgf.a(this.a).getWidth()), " ,viewH:", Integer.valueOf(bjgf.a(this.a).getHeight()), " ,videoW:", Integer.valueOf(bjgf.a(this.a)), " ,videoH:", Integer.valueOf(bjgf.b(this.a)) });
                }
                if (bjgf.a(this.a) != null)
                {
                  bjgf.a(this.a).onSetVideoCover(bjgf.a(this.a));
                  bjgf.a(this.a).onVideoSize(bjgf.a(this.a), bjgf.b(this.a));
                }
                this.a.a(bjgf.a(this.a), bjgf.b(this.a));
                bjgf.a(this.a, 2);
                return;
                if (bjgf.a(this.a).get())
                {
                  if (bjgf.a(this.a) != null) {
                    bjgf.a(this.a).onVideoStart((int)bjgf.a(this.a).c());
                  }
                  bjgf.c(this.a);
                  bjgf.a(this.a).set(false);
                  return;
                }
                bjgf.a(this.a, 3);
                return;
              } while (!QLog.isColorLevel());
              QLog.d("TVKVideoController", 2, "onSeekComplete");
              return;
              if (QLog.isColorLevel()) {
                QLog.d("TVKVideoController", 2, "onPlaybackComplete");
              }
              bjgf.a(this.a, true);
              bjgf.a(this.a, 0);
              bjgf.a(this.a).removeCallbacks(this.a.a);
              if (bjgf.a(this.a) != null) {
                bjgf.a(this.a).e = 0L;
              }
              bjgf.d(this.a);
            } while (bjgf.a(this.a) == null);
            bjgf.a(this.a).onVideoComplete(true);
            bjgf.a(this.a).onVideoProgressUpdate(0);
            return;
          } while (!QLog.isColorLevel());
          QLog.d("TVKVideoController", 2, "onVideoSizeChanged");
          return;
          if (QLog.isColorLevel()) {
            QLog.d("TVKVideoController", 2, "MEDIA_INSTALL_SUCCESS");
          }
        } while ((bjgf.a(this.a) == null) || (bjgf.a(this.a) == null));
        bjgf.a(this.a, bjgf.a(this.a).a((Context)bjgf.a(this.a).get()));
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TVKVideoController", 2, "Error (" + paramMessage.arg1 + "," + paramMessage.arg2 + ")");
        }
        bjgf.a(this.a, paramMessage.arg1, paramMessage.arg2);
        return;
      } while ((bjgf.a(this.a) == null) || (bjgf.c(this.a) == 4));
      if (paramMessage.arg1 == 929)
      {
        bjgf.a(this.a).onVideoBuffering();
        return;
      }
    } while (paramMessage.arg1 != 92);
    bjgf.a(this.a).onVideoStart((int)bjgf.a(this.a).c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgi
 * JD-Core Version:    0.7.0.1
 */