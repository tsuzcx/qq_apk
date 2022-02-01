import com.tencent.mobileqq.music.SongInfo;

public abstract interface axrb
{
  public abstract String getToken();
  
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrb
 * JD-Core Version:    0.7.0.1
 */