import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class asub
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private asub(astw paramastw) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (astw.a(this.a))
    {
      String str = astw.a(paramString1);
      astv.b("onComplete path:" + str);
      astv.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      astw.a(this.a, paramString1);
      paramString2 = new File(astw.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      astw.b(this.a, paramString1);
      astw.b(this.a, astw.a(this.a));
      astw.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asub
 * JD-Core Version:    0.7.0.1
 */