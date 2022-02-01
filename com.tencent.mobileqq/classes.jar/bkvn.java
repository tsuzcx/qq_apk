import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.OnLogListener;

class bkvn
  implements TVK_SDKMgr.OnLogListener
{
  bkvn(bkvm parambkvm) {}
  
  public int d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer_TVK_IMediaPlayer", 2, paramString2);
    }
    return 0;
  }
  
  public int e(String paramString1, String paramString2)
  {
    QLog.e("MiniAppVideoPlayer_TVK_IMediaPlayer", 1, paramString2);
    return 0;
  }
  
  public int i(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppVideoPlayer_TVK_IMediaPlayer", 2, paramString2);
    }
    return 0;
  }
  
  public int v(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MiniAppVideoPlayer_TVK_IMediaPlayer", 2, paramString2);
    }
    return 0;
  }
  
  public int w(String paramString1, String paramString2)
  {
    QLog.w("MiniAppVideoPlayer_TVK_IMediaPlayer", 1, paramString2);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkvn
 * JD-Core Version:    0.7.0.1
 */