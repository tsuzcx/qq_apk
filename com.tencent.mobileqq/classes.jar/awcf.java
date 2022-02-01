import android.os.Bundle;
import com.tencent.intervideo.nowproxy.customized_interface.CustomizedDownloader;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;

class awcf
  extends CustomizedDownloader
{
  awcf(awcc paramawcc) {}
  
  public void onDownload(boolean paramBoolean, String paramString1, String paramString2, Bundle paramBundle, DownloadCallback paramDownloadCallback)
  {
    paramBundle = new Bundle();
    paramBundle.putString("url", paramString1);
    paramBundle.putString("path", paramString2);
    awde.a().a(paramBundle, paramDownloadCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awcf
 * JD-Core Version:    0.7.0.1
 */