import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bjis
  implements DownloadListener
{
  bjis(bjiq parambjiq) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (avus.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!avus.b().equals(paramDownloadInfo.l))
      {
        avus.a(paramDownloadInfo.l);
        paramDownloadInfo.l = avus.b();
      }
      bjna.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bjiq.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bjit)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjis
 * JD-Core Version:    0.7.0.1
 */