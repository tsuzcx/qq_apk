import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class avwb
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  avwb(avvx paramavvx) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.jdField_a_of_type_Boolean = false;
    avvx.a(this.a, true);
    if (this.a.c == 3) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.c = 2;
    } while (avvx.a(this.a) == null);
    avvx.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwb
 * JD-Core Version:    0.7.0.1
 */