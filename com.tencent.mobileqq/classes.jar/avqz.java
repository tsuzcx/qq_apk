import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class avqz
  implements TVK_ICacheMgr.IPreloadCallback
{
  private avqz(avqv paramavqv) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (avqv.a(this.a))
    {
      avqu.b("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      avqv.b(this.a, avqv.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (avqv.a(this.a))
    {
      avqu.b("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = avqv.a(paramString1);
          avqu.b("onPreLoadSucess path:" + paramString2);
          avqv.a(this.a, paramString1);
          File localFile = new File(avqv.b(paramString1));
          if (localFile.exists()) {
            localFile.renameTo(new File(paramString2));
          }
          avqv.b(this.a, paramString1);
          avqv.b(this.a, avqv.a(this.a));
          avqv.b(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqz
 * JD-Core Version:    0.7.0.1
 */