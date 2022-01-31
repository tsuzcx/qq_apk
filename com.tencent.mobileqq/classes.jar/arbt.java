import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class arbt
  implements TVK_IMediaPlayer.OnInfoListener
{
  arbt(arbn paramarbn) {}
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    }
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video start buffering !");
      }
      if (arbn.a(this.a) != null) {
        arbn.a(this.a).a(this.a.b, 0);
      }
      this.a.c = 6;
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video end buffering !");
      }
    } while (arbn.a(this.a) == null);
    arbn.a(this.a).a(this.a.b, 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbt
 * JD-Core Version:    0.7.0.1
 */