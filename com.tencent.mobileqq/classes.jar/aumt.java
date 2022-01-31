import com.tencent.mobileqq.music.SongInfo;

public abstract interface aumt
{
  public abstract String getToken();
  
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aumt
 * JD-Core Version:    0.7.0.1
 */