import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.1;
import com.tencent.mobileqq.ark.API.ArkAppMusicModule.GlobalMusicCallback.2;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.music.SongInfo;

public final class apsv
  implements axkk
{
  private String a;
  
  public apsv(String paramString)
  {
    this.a = paramString;
  }
  
  public String getToken()
  {
    return apsu.a();
  }
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    ArkAppCenter.a().post(this.a, new ArkAppMusicModule.GlobalMusicCallback.2(this, paramSongInfo));
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    ArkAppCenter.a().post(this.a, new ArkAppMusicModule.GlobalMusicCallback.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apsv
 * JD-Core Version:    0.7.0.1
 */