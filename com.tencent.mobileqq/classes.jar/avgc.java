import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class avgc
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private avgc(avfx paramavfx) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (avfx.a(this.a))
    {
      String str = avfx.a(paramString1);
      avfw.b("onComplete path:" + str);
      avfw.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      avfx.a(this.a, paramString1);
      paramString2 = new File(avfx.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      avfx.b(this.a, paramString1);
      avfx.b(this.a, avfx.a(this.a));
      avfx.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgc
 * JD-Core Version:    0.7.0.1
 */