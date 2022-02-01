import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class aujd
  implements TVK_IMediaPlayer.OnInfoListener
{
  aujd(auix paramauix) {}
  
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
      if (auix.a(this.a) != null) {
        auix.a(this.a).a(this.a.b, 0);
      }
      this.a.c = 6;
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video end buffering !");
      }
    } while (auix.a(this.a) == null);
    auix.a(this.a).a(this.a.b, 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aujd
 * JD-Core Version:    0.7.0.1
 */