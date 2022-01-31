import com.tencent.open.downloadnew.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class bcbw
  implements bcgn
{
  bcbw(bcbu parambcbu) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).installSucceed(paramString1, paramString2);
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadCancel(paramDownloadInfo);
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt1, paramString, paramInt2);
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (aqny.a(paramDownloadInfo.l, paramDownloadInfo.c, paramDownloadInfo.e))
    {
      if (!aqny.b().equals(paramDownloadInfo.l))
      {
        aqny.a(paramDownloadInfo.l);
        paramDownloadInfo.l = aqny.b();
      }
      bcgo.a().e(paramDownloadInfo);
    }
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadFinish(paramDownloadInfo);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadPause(paramDownloadInfo);
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadUpdate(paramList);
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).onDownloadWait(paramDownloadInfo);
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).packageReplaced(paramString1, paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    Iterator localIterator = bcbu.a(this.a).iterator();
    while (localIterator.hasNext()) {
      ((bcbx)localIterator.next()).uninstallSucceed(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcbw
 * JD-Core Version:    0.7.0.1
 */