import com.tencent.mobileqq.music.SongInfo;

class axrn
  extends axqq
{
  axrn(axrl paramaxrl) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (axrl.a(this.a) != null) {
      axrl.a(this.a, axrl.a(this.a).a());
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    axrl.a(this.a, paramInt);
    if (paramInt == 2) {
      axrl.a(this.a, axrl.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axrn
 * JD-Core Version:    0.7.0.1
 */