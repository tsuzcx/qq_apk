import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnNetVideoInfoListener;
import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;

class avoy
  implements TVK_IMediaPlayer.OnNetVideoInfoListener
{
  avoy(avor paramavor) {}
  
  public void onNetVideoInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, TVK_NetVideoInfo paramTVK_NetVideoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoBaseItem", 2, "[MediaPlayer] onNetVideoInfo what=" + paramTVK_NetVideoInfo.getErrInfo() + ",extra=" + paramTVK_NetVideoInfo.getState() + ",mCacheProgress=");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avoy
 * JD-Core Version:    0.7.0.1
 */