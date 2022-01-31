import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bdgm
  implements bdld
{
  bdgm(bdgk parambdgk) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (arif.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!arif.b().equals(paramDownloadInfo.l))
      {
        arif.a(paramDownloadInfo.l);
        paramDownloadInfo.l = arif.b();
      }
      bdle.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bdgk.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdgn)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdgm
 * JD-Core Version:    0.7.0.1
 */