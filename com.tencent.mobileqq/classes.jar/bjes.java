import com.tencent.qqmini.sdk.launcher.core.proxy.MusicPlayerProxy.MusicPlayerListener;

class bjes
  extends awdx
{
  bjes(bjep parambjep) {}
  
  public void onPlaySongChanged(com.tencent.mobileqq.music.SongInfo paramSongInfo)
  {
    if (bjep.a(this.a) != null)
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
      bjep.a(this.a).onPlaySongChanged(localSongInfo);
    }
  }
  
  public void onPlayStateChanged(int paramInt)
  {
    if ((bjep.a(this.a) == null) || ((bjep.a(this.a).a() != null) && (!bjep.a(this.a).a().equals(bjep.a(this.a))))) {}
    while (bjep.a(this.a) == null) {
      return;
    }
    bjep.a(this.a).onPlayStateChanged(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjes
 * JD-Core Version:    0.7.0.1
 */