import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bdfx
  implements bdko
{
  bdfx(bdfv parambdfv) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (arid.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!arid.b().equals(paramDownloadInfo.l))
      {
        arid.a(paramDownloadInfo.l);
        paramDownloadInfo.l = arid.b();
      }
      bdkp.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bdfv.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bdfy)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdfx
 * JD-Core Version:    0.7.0.1
 */