import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class birc
  implements DownloadListener
{
  birc(bira parambira) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (avjp.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!avjp.b().equals(paramDownloadInfo.l))
      {
        avjp.a(paramDownloadInfo.l);
        paramDownloadInfo.l = avjp.b();
      }
      bivr.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bira.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bird)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     birc
 * JD-Core Version:    0.7.0.1
 */