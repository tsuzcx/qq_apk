import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

class bjxr
  extends awxx
{
  bjxr(bjxo parambjxo) {}
  
  public void onPlaySongChanged(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if (bjxo.a(this.a) != null)
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
      bjxo.a(this.a).onPlaySongChanged(localSongInfo);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((bjxo.a(this.a) == null) || ((bjxo.a(this.a).a() != null) && (!bjxo.a(this.a).a().equals(bjxo.a(this.a))))) {}
    while (bjxo.a(this.a) == null) {
      return;
    }
    bjxo.a(this.a).onPlayStateChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxr
 * JD-Core Version:    0.7.0.1
 */