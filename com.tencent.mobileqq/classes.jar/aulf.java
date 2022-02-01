import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCompleteCallback;
import java.io.File;

class aulf
  implements TVK_ICacheMgr.IPreloadCompleteCallback
{
  private aulf(aula paramaula) {}
  
  public void onComplete(String paramString1, String paramString2)
  {
    synchronized (aula.a(this.a))
    {
      String str = aula.a(paramString1);
      aukz.b("onComplete path:" + str);
      aukz.b("onComplete vid:" + paramString1 + ", detail:" + paramString2);
      aula.a(this.a, paramString1);
      paramString2 = new File(aula.b(paramString1));
      if (paramString2.exists()) {
        paramString2.renameTo(new File(str));
      }
      aula.b(this.a, paramString1);
      aula.b(this.a, aula.a(this.a));
      aula.b(this.a);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aulf
 * JD-Core Version:    0.7.0.1
 */