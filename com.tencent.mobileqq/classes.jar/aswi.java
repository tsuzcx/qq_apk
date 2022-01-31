import com.tencent.mobileqq.music.SongInfo;

class aswi
  extends asvl
{
  aswi(aswg paramaswg) {}
  
  public void onPlaySongChanged(SongInfo paramSongInfo)
  {
    if (aswg.a(this.a) != null) {
      aswg.a(this.a, aswg.a(this.a).a());
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    aswg.a(this.a, paramInt);
    if (paramInt == 2) {
      aswg.a(this.a, aswg.a(this.a).c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aswi
 * JD-Core Version:    0.7.0.1
 */