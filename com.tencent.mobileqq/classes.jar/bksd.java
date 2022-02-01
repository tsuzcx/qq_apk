import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.oskplayer.OskPlayerCore;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoPlayerProviderProxy;
import com.tencent.qqmini.sdk.launcher.core.widget.ReliableVideoPlayer;

@ProxyService(proxy=VideoPlayerProviderProxy.class)
public class bksd
  implements VideoPlayerProviderProxy
{
  public String getUrl(String paramString)
  {
    return OskPlayerCore.getInstance().getUrl(MiniAppFileManager.getInstance().getAbsolutePath(paramString));
  }
  
  public ReliableVideoPlayer getVideoPlayer()
  {
    return new bkqg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bksd
 * JD-Core Version:    0.7.0.1
 */