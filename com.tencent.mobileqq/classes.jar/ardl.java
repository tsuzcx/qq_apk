import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class ardl
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private ardl(ardg paramardg) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (ardg.a(this.a))
    {
      String str = ardg.a(paramString1);
      ardf.b("onComplete path:" + str);
      ardf.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      ardg.a(this.a, paramString1);
      paramString2 = new File(ardg.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      ardg.b(this.a, paramString1);
      ardg.b(this.a, ardg.a(this.a));
      ardg.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardl
 * JD-Core Version:    0.7.0.1
 */