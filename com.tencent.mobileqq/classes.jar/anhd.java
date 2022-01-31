import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

class anhd
  implements bfka
{
  anhd(anhb paramanhb) {}
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (anhb.a(this.a) != null) {
      anhb.a(this.a).a(this.a.a(paramString1, 6, paramString2).toString());
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (anhb.a(this.a) != null)) {
      anhb.a(this.a).a(this.a.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramDownloadInfo != null) && (anhb.a(this.a) != null)) {
      anhb.a(this.a).a(this.a.a(paramDownloadInfo.k, paramDownloadInfo.a(), paramDownloadInfo.f, paramDownloadInfo.e, paramString, paramInt1, paramDownloadInfo.j).toString());
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (anhb.a(this.a) != null)) {
      anhb.a(this.a).a(this.a.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (anhb.a(this.a) != null)) {
      anhb.a(this.a).a(this.a.a(paramDownloadInfo).toString());
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if ((paramList != null) && (anhb.a(this.a) != null))
    {
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        localJSONArray.put(this.a.a(localDownloadInfo));
      }
      anhb.a(this.a).a(localJSONArray.toString());
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (anhb.a(this.a) != null)) {
      anhb.a(this.a).a(this.a.a(paramDownloadInfo).toString());
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (anhb.a(this.a) != null) {
      anhb.a(this.a).a(this.a.a(paramString1, 13, paramString2).toString());
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (anhb.a(this.a) != null) {
      anhb.a(this.a).a(this.a.a(paramString1, 9, paramString2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhd
 * JD-Core Version:    0.7.0.1
 */