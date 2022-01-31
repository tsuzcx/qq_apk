import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnErrorListener;
import java.lang.ref.WeakReference;

class apae
  implements TVK_IMediaPlayer.OnErrorListener
{
  apae(apad paramapad) {}
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    QLog.e("FileVideoManager<FileAssistant>", 1, "mediaPlayer onError:errorType[" + paramInt1 + "], errorCode[" + paramInt2 + "],extra[" + paramInt3 + "],detailInfo[" + paramString + "]");
    paramTVK_IMediaPlayer = ajyc.a(2131704586);
    paramString = (apab)this.a.a.get();
    if (paramString != null) {
      paramString.a(paramInt2, paramTVK_IMediaPlayer);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apae
 * JD-Core Version:    0.7.0.1
 */