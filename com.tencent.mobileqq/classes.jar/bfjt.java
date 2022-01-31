import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bfjt
  implements bfoj
{
  bfjt(bfjr parambfjr) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (atdc.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!atdc.b().equals(paramDownloadInfo.l))
      {
        atdc.a(paramDownloadInfo.l);
        paramDownloadInfo.l = atdc.b();
      }
      bfok.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bfjr.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bfju)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfjt
 * JD-Core Version:    0.7.0.1
 */