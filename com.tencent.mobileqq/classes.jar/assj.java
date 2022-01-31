import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnInfoListener;

class assj
  implements TVK_IMediaPlayer.OnInfoListener
{
  assj(assd paramassd) {}
  
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
      if (assd.a(this.a) != null) {
        assd.a(this.a).a(this.a.b, 0);
      }
      this.a.c = 6;
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("VideoBaseItem", 2, "video end buffering !");
      }
    } while (assd.a(this.a) == null);
    assd.a(this.a).a(this.a.b, 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assj
 * JD-Core Version:    0.7.0.1
 */