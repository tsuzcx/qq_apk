import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class avyf
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private avyf(avya paramavya) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (avya.a(this.a))
    {
      String str = avya.a(paramString1);
      avxz.b("onComplete path:" + str);
      avxz.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      avya.a(this.a, paramString1);
      paramString2 = new File(avya.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      avya.b(this.a, paramString1);
      avya.b(this.a, avya.a(this.a));
      avya.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyf
 * JD-Core Version:    0.7.0.1
 */