import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoPreparingListener;

class arbv
  implements TVK_IMediaPlayer.OnVideoPreparingListener
{
  arbv(arbn paramarbn) {}
  
  public void onVideoPreparing(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoBaseItem", 2, "[MediaPlayer] onVideoPreparing mCacheProgress=");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     arbv
 * JD-Core Version:    0.7.0.1
 */