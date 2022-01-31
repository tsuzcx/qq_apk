import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparedListener;

class arbt
  implements TVK_IMediaPlayer.OnVideoPreparedListener
{
  arbt(arbp paramarbp) {}
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    this.a.jdField_a_of_type_Boolean = false;
    arbp.a(this.a, true);
    if (this.a.c == 3) {}
    do
    {
      return;
      this.a.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_IMediaPlayer.start();
      this.a.c = 2;
    } while (arbp.a(this.a) == null);
    arbp.a(this.a).j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */