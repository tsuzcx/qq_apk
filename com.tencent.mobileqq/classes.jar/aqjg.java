import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class aqjg
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private aqjg(aqjb paramaqjb) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (aqjb.a(this.a))
    {
      String str = aqjb.a(paramString1);
      aqja.b("onComplete path:" + str);
      aqja.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      aqjb.a(this.a, paramString1);
      paramString2 = new File(aqjb.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      aqjb.b(this.a, paramString1);
      aqjb.b(this.a, aqjb.a(this.a));
      aqjb.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjg
 * JD-Core Version:    0.7.0.1
 */