import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import java.util.HashMap;

public class aswn
  implements ServiceConnection
{
  public aswn(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    MusicPlayerActivity.a(this.a, asvm.a(paramIBinder));
    try
    {
      MusicPlayerActivity.a(this.a).a(MusicPlayerActivity.a(this.a));
      paramComponentName = MusicPlayerActivity.a(this.a).a();
      paramIBinder = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramComponentName, -1L);
      if (paramComponentName != null)
      {
        String str = MusicPlayerActivity.a(this.a, paramComponentName);
        if (MusicPlayerActivity.b().containsKey(str)) {
          MusicPlayerActivity.a(this.a, (aswu)MusicPlayerActivity.b().get(str), paramIBinder);
        }
        for (;;)
        {
          int i = MusicPlayerActivity.a(this.a).a();
          Message.obtain(MusicPlayerActivity.a(this.a), 50, i, 0).sendToTarget();
          MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramComponentName.b, paramComponentName.g, paramComponentName.f, String.valueOf(paramComponentName.a), paramComponentName.c, MusicPlayerActivity.a(this.a).c());
          return;
          MusicPlayerActivity.a(this.a, paramComponentName.b, paramComponentName.g, paramComponentName.d, paramIBinder, false, false);
        }
      }
      return;
    }
    catch (Exception paramComponentName) {}
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    paramComponentName = MusicPlayerActivity.a(this.a);
    if (paramComponentName != null) {}
    try
    {
      paramComponentName.b(MusicPlayerActivity.a(this.a));
      return;
    }
    catch (RemoteException paramComponentName) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswn
 * JD-Core Version:    0.7.0.1
 */