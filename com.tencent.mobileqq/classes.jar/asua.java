import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_ICacheMgr.IPreloadCallback;
import java.io.File;
import org.json.JSONObject;

class asua
  implements TVK_ICacheMgr.IPreloadCallback
{
  private asua(astw paramastw) {}
  
  public void onPreLoadFailed(String paramString1, int paramInt, String paramString2)
  {
    synchronized (astw.a(this.a))
    {
      astv.b("onPreLoadFailed vid:" + paramString1 + ", i:" + paramInt + ", callbackMsg:" + paramString2);
      astw.b(this.a, astw.a(this.a));
      return;
    }
  }
  
  public void onPreLoadSucess(String paramString1, String paramString2)
  {
    synchronized (astw.a(this.a))
    {
      astv.b("onPreLoadSucess vid:" + paramString1 + ", detail:" + paramString2);
      try
      {
        paramString2 = new JSONObject(paramString2);
        long l1 = paramString2.optLong("fileSize");
        long l2 = paramString2.optLong("offset");
        if ((l1 > 0L) && (l2 > 0L) && (l2 >= l1))
        {
          paramString2 = astw.a(paramString1);
          astv.b("onPreLoadSucess path:" + paramString2);
          astw.a(this.a, paramString1);
          File localFile = new File(astw.b(paramString1));
          if (localFile.exists()) {
            localFile.renameTo(new File(paramString2));
          }
          astw.b(this.a, paramString1);
          astw.b(this.a, astw.a(this.a));
          astw.b(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asua
 * JD-Core Version:    0.7.0.1
 */