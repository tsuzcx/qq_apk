import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class aqjf
  implements TVK_ICacheMgr.IPreloadCallback
{
  private aqjf(aqjb paramaqjb) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (aqjb.a(this.a))
    {
      aqja.b("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      aqjb.b(this.a, aqjb.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (aqjb.a(this.a))
    {
      aqja.b("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = aqjb.a(paramString1);
          aqja.b("onPreLoadSucess path:" + paramString2);
          aqjb.a(this.a, paramString1);
          File localFile = new File(aqjb.b(paramString1));
          if (localFile.exists()) {
            localFile.renameTo(new File(paramString2));
          }
          aqjb.b(this.a, paramString1);
          aqjb.b(this.a, aqjb.a(this.a));
          aqjb.b(this.a);
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
 * Qualified Name:     aqjf
 * JD-Core Version:    0.7.0.1
 */