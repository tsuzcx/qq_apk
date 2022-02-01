import com.tencent.mobileqq.music.SongInfo;

class awyu
  extends awxx
{
  awyu(awys paramawys) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (awys.a(this.a) != null) {
      awys.a(this.a, awys.a(this.a).a());
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    awys.a(this.a, paramInt);
    if (paramInt == 2) {
      awys.a(this.a, awys.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyu
 * JD-Core Version:    0.7.0.1
 */