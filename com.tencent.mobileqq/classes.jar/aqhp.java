import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class aqhp
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  aqhp(aqhl paramaqhl) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.jdField_a_of_type_Boolean = false;
    aqhl.a(this.a, true);
    if (this.a.c == 3) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.c = 2;
    } while (aqhl.a(this.a) == null);
    aqhl.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqhp
 * JD-Core Version:    0.7.0.1
 */