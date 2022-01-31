import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class ardn
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private ardn(ardi paramardi) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (ardi.a(this.a))
    {
      String str = ardi.a(paramString1);
      ardh.b("onComplete path:" + str);
      ardh.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      ardi.a(this.a, paramString1);
      paramString2 = new File(ardi.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      ardi.b(this.a, paramString1);
      ardi.b(this.a, ardi.a(this.a));
      ardi.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardn
 * JD-Core Version:    0.7.0.1
 */