import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

class bkqa
  extends axjz
{
  bkqa(bkpx parambkpx) {}
  
  public void a(int paramInt)
  {
    if ((bkpx.a(this.a) == null) || ((bkpx.a(this.a).a() != null) && (!bkpx.a(this.a).a().equals(bkpx.a(this.a))))) {}
    while (bkpx.a(this.a) == null) {
      return;
    }
    bkpx.a(this.a).onPlayStateChanged(paramInt);
  }
  
  public void a(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if (bkpx.a(this.a) != null)
    {
      com.tencent.qqmini.sdk.launcher.core.model.SongInfo localSongInfo = new com.tencent.qqmini.sdk.launcher.core.model.SongInfo();
      localSongInfo.album = paramSongInfo.g;
      localSongInfo.coverUrl = paramSongInfo.e;
      localSongInfo.detailUrl = paramSongInfo.f;
      localSongInfo.duration = paramSongInfo.jdField_d_of_type_Long;
      localSongInfo.fromMini = paramSongInfo.jdField_a_of_type_Boolean;
      localSongInfo.id = paramSongInfo.jdField_a_of_type_Long;
      localSongInfo.mid = paramSongInfo.jdField_a_of_type_JavaLangString;
      localSongInfo.singer = paramSongInfo.h;
      localSongInfo.singerId = paramSongInfo.jdField_c_of_type_Long;
      localSongInfo.startTime = paramSongInfo.jdField_a_of_type_Int;
      localSongInfo.summary = paramSongInfo.jdField_d_of_type_JavaLangString;
      localSongInfo.title = paramSongInfo.jdField_c_of_type_JavaLangString;
      localSongInfo.type = paramSongInfo.jdField_b_of_type_Int;
      localSongInfo.uin = paramSongInfo.jdField_b_of_type_Long;
      localSongInfo.url = paramSongInfo.jdField_b_of_type_JavaLangString;
      bkpx.a(this.a).onPlaySongChanged(localSongInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqa
 * JD-Core Version:    0.7.0.1
 */