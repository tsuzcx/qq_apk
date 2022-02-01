import com.tencent.mobileqq.minigame.manager.FileDownloadManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.WebAudioDownloadListener;
import java.util.Map;

@ProxyService(proxy=DownloaderProxy.class)
public class bjcx
  extends DownloaderProxy
{
  public void abort(String paramString)
  {
    FileDownloadManager.abort(paramString);
  }
  
  public boolean download(String paramString1, Map<String, String> paramMap, String paramString2, int paramInt, DownloaderProxy.DownloadListener paramDownloadListener)
  {
    return FileDownloadManager.download(paramString1, paramMap, paramString2, paramInt, paramDownloadListener);
  }
  
  public void getWebAudioDownloadPath(DownloaderProxy.WebAudioDownloadListener paramWebAudioDownloadListener)
  {
    FileDownloadManager.getWebAudioDownloadPath(paramWebAudioDownloadListener);
  }
  
  public void preConnectDownloadHost() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjcx
 * JD-Core Version:    0.7.0.1
 */