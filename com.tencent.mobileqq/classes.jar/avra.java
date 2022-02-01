import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class avra
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private avra(avqv paramavqv) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (avqv.a(this.a))
    {
      String str = avqv.a(paramString1);
      avqu.b("onComplete path:" + str);
      avqu.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      avqv.a(this.a, paramString1);
      paramString2 = new File(avqv.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      avqv.b(this.a, paramString1);
      avqv.b(this.a, avqv.a(this.a));
      avqv.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avra
 * JD-Core Version:    0.7.0.1
 */