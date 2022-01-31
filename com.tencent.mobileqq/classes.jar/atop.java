import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class atop
  extends Handler
{
  private final WeakReference<aton> a;
  
  atop(aton paramaton, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramaton);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aton localaton = (aton)this.a.get();
    if (localaton == null) {
      super.handleMessage(paramMessage);
    }
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          super.handleMessage(paramMessage);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, "--->handleMessage[MSG_FROM_SERVICE]");
      return;
      paramMessage = paramMessage.getData();
      paramMessage.setClassLoader(ISong.class.getClassLoader());
      paramMessage = (ISong)paramMessage.getParcelable("key_song");
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_SONG_CHANGE] %s", new Object[] { paramMessage.a() }));
      }
      aton.a(localaton, paramMessage);
      return;
      paramMessage = paramMessage.getData();
      String str = paramMessage.getString("key_id");
      i = paramMessage.getInt("key_play_state", -1);
      if (QLog.isColorLevel()) {
        QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PLAY_STATE_CHANGE] %s %s", new Object[] { str, atoh.a(i) }));
      }
      aton.a(localaton, str, i);
    } while ((i != 4) || (!aton.a(localaton)));
    aton.a(localaton);
    return;
    boolean bool1 = paramMessage.getData().getBoolean("key_net_state", false);
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_NET_STATE_CHANGE] %b", new Object[] { Boolean.valueOf(bool1) }));
    }
    aton.a(localaton, bool1);
    return;
    paramMessage = paramMessage.getData();
    bool1 = paramMessage.getBoolean("key_focus_state", false);
    boolean bool2 = paramMessage.getBoolean("key_focus_transient", false);
    if (QLog.isColorLevel()) {
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_FOCUS_STATE_CHANGE] %b_%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
    }
    aton.a(localaton, bool1, bool2);
    return;
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("key_position", -1);
    int j = paramMessage.getInt("key_duration", -1);
    paramMessage = paramMessage.getString("key_id");
    if (((i <= 0) || (j <= 0)) && (QLog.isColorLevel())) {
      QLog.i("QQMusicPlay.QQMusicPlayClient", 2, String.format("--->handleMessage[MSG_FROM_SERVICE_PROGRESS_CHANGE] [%d/%d] %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramMessage }));
    }
    aton.a(localaton, paramMessage, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atop
 * JD-Core Version:    0.7.0.1
 */