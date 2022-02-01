import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class bnko
{
  private static final String a = bnko.class.getSimpleName();
  
  public static void a(AppInterface paramAppInterface, bnke parambnke, String paramString, bnkq parambnkq)
  {
    if (parambnke == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, parambnke, paramString, parambnkq);
  }
  
  private static void b(AppInterface paramAppInterface, bnke parambnke, String paramString, bnkq parambnkq)
  {
    if ((parambnke == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      parambnke.a = System.currentTimeMillis();
      parambnke.jdField_f_of_type_Boolean = true;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new bnkp(parambnke, paramString, parambnkq);
      localHttpNetReq.mReqUrl = parambnke.d;
      localHttpNetReq.mHttpMethod = 0;
      if (parambnke.jdField_f_of_type_JavaLangString == null)
      {
        QLog.i(a, 1, "startDownloadMaterial fail, info.name is null, url:" + parambnke.d);
        return;
      }
      localHttpNetReq.mOutPath = new File(paramString, parambnke.jdField_f_of_type_JavaLangString).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).sendReq(localHttpNetReq);
        localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(a, 2, "startDownloadMaterial url: " + parambnke.d);
        return;
      }
      catch (Exception paramAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            paramAppInterface.printStackTrace();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnko
 * JD-Core Version:    0.7.0.1
 */