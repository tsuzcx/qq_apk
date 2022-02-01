import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicgene.MusicPlayerActivity;
import java.util.HashMap;

public class axle
  extends axjz
{
  public axle(MusicPlayerActivity paramMusicPlayerActivity) {}
  
  public void a(int paramInt)
  {
    Message.obtain(MusicPlayerActivity.a(this.a), 50, paramInt, 0).sendToTarget();
  }
  
  public void a(SongInfo paramSongInfo)
  {
    if (paramSongInfo != null)
    {
      localObject = MusicPlayerActivity.a(this.a, paramSongInfo);
      if (!MusicPlayerActivity.b().containsKey(localObject)) {
        break label64;
      }
      localObject = (axlk)MusicPlayerActivity.b().get(localObject);
      paramSongInfo = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, ((axlk)localObject).a);
      MusicPlayerActivity.a(this.a, (axlk)localObject, paramSongInfo);
    }
    label64:
    while (MusicPlayerActivity.a().containsKey(localObject)) {
      return;
    }
    Object localObject = MusicPlayerActivity.a(this.a);
    if (localObject != null) {}
    for (int i = ((axkb)localObject).c();; i = 0)
    {
      localObject = MusicPlayerActivity.a(this.a, MusicPlayerActivity.a(this.a), paramSongInfo, -1L);
      MusicPlayerActivity.a(this.a, paramSongInfo.c, paramSongInfo.h, paramSongInfo.e, (String)localObject, false, false);
      MusicPlayerActivity.a(this.a).a(this.a.app.getLongAccountUin(), paramSongInfo.c, paramSongInfo.h, paramSongInfo.g, String.valueOf(paramSongInfo.a), paramSongInfo.d, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axle
 * JD-Core Version:    0.7.0.1
 */