import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bffk
  implements bfka
{
  bffk(bffi parambffi) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (asyt.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!asyt.b().equals(paramDownloadInfo.l))
      {
        asyt.a(paramDownloadInfo.l);
        paramDownloadInfo.l = asyt.b();
      }
      bfkb.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bffi.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bffl)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bffk
 * JD-Core Version:    0.7.0.1
 */