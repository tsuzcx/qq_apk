import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.oskplayer.proxy.VideoManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.IMediaPlayerUtil;

class bknn
  implements IMediaPlayerUtil
{
  bknn(bknl parambknl) {}
  
  public int getContentFlag(String paramString)
  {
    return VideoManager.getInstance().probeContentFlag(paramString);
  }
  
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bknn
 * JD-Core Version:    0.7.0.1
 */