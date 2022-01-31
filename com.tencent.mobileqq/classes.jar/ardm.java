import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class ardm
  implements TVK_ICacheMgr.IPreloadCallback
{
  private ardm(ardi paramardi) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (ardi.a(this.a))
    {
      ardh.b("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      ardi.b(this.a, ardi.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (ardi.a(this.a))
    {
      ardh.b("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = ardi.a(paramString1);
          ardh.b("onPreLoadSucess path:" + paramString2);
          ardi.a(this.a, paramString1);
          File localFile = new File(ardi.b(paramString1));
          if (localFile.exists()) {
            localFile.renameTo(new File(paramString2));
          }
          ardi.b(this.a, paramString1);
          ardi.b(this.a, ardi.a(this.a));
          ardi.b(this.a);
        }
      }
      catch (Exception paramString1)
      {
        for (;;)
        {
          QLog.d("ImaxAdvertisement", 1, "onPreLoadSucess", paramString1);
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ardm
 * JD-Core Version:    0.7.0.1
 */