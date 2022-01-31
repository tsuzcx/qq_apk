import android.os.IInterface;
import com.tencent.mobileqq.music.SongInfo;

public abstract interface arze
  extends IInterface
{
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     arze
 * JD-Core Version:    0.7.0.1
 */