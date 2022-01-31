import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class asyk
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private asyk(asyf paramasyf) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (asyf.a(this.a))
    {
      String str = asyf.a(paramString1);
      asye.b("onComplete path:" + str);
      asye.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      asyf.a(this.a, paramString1);
      paramString2 = new File(asyf.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      asyf.b(this.a, paramString1);
      asyf.b(this.a, asyf.a(this.a));
      asyf.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyk
 * JD-Core Version:    0.7.0.1
 */