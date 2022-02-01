import android.support.annotation.WorkerThread;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bnrb
{
  public static bnrb a()
  {
    return bnre.a;
  }
  
  @WorkerThread
  private static void b(String paramString1, String paramString2, bnrc parambnrc)
  {
    bnrh.b("AEDownloader", "realDownload---url=" + paramString1 + ", saveName=" + paramString2);
    AppInterface localAppInterface = bofz.a();
    if (localAppInterface == null)
    {
      if (parambnrc != null) {
        parambnrc.a(null);
      }
      bnrh.d("AEDownloader", "realDownload---FAIL appInterface is null");
    }
    do
    {
      return;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new bnrd(paramString1, paramString2, parambnrc);
      localHttpNetReq.mReqUrl = paramString1;
      localHttpNetReq.mHttpMethod = 0;
      localHttpNetReq.mOutPath = new File(paramString2).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        localAppInterface.getNetEngine(0).sendReq(localHttpNetReq);
        return;
      }
      catch (Exception paramString1)
      {
        if (QLog.isColorLevel()) {
          paramString1.printStackTrace();
        }
        bnrh.a("AEDownloader", "realDownload---exception: ", paramString1);
      }
    } while (parambnrc == null);
    parambnrc.a(null);
  }
  
  public void a(String paramString1, String paramString2, bnrc parambnrc)
  {
    b(paramString1, paramString2, parambnrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrb
 * JD-Core Version:    0.7.0.1
 */