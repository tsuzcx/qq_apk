import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;

final class axni
  implements TVK_ICacheMgr.IPreloadCallback
{
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("VideoPlayerView", 2, "onPreLoadFailed() called with: s = [" + paramString1 + "], i = [" + paramInt + "], s1 = [" + paramString2 + "]");
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    QLog.i("VideoPlayerView", 2, "onPreLoadSucess() called with: s = [" + paramString1 + "], s1 = [" + paramString2 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axni
 * JD-Core Version:    0.7.0.1
 */