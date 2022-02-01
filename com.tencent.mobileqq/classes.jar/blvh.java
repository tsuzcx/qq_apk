import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class blvh
{
  private static final String a = blvh.class.getSimpleName();
  
  public static void a(AppInterface paramAppInterface, blvb paramblvb, String paramString, blvj paramblvj)
  {
    if (paramblvb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "startDownloadMaterial is null");
      }
      return;
    }
    b(paramAppInterface, paramblvb, paramString, paramblvj);
  }
  
  private static void b(AppInterface paramAppInterface, blvb paramblvb, String paramString, blvj paramblvj)
  {
    if ((paramblvb == null) || (paramAppInterface == null)) {}
    for (;;)
    {
      return;
      paramblvb.a = System.currentTimeMillis();
      paramblvb.jdField_f_of_type_Boolean = true;
      HttpNetReq localHttpNetReq = new HttpNetReq();
      localHttpNetReq.mCallback = new blvi(paramblvb, paramString, paramblvj);
      localHttpNetReq.mReqUrl = paramblvb.d;
      localHttpNetReq.mHttpMethod = 0;
      if (paramblvb.jdField_f_of_type_JavaLangString == null)
      {
        QLog.i(a, 1, "startDownloadMaterial fail, info.name is null, url:" + paramblvb.d);
        return;
      }
      localHttpNetReq.mOutPath = new File(paramString, paramblvb.jdField_f_of_type_JavaLangString).getPath();
      localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
      localHttpNetReq.mExcuteTimeLimit = 60000L;
      try
      {
        paramAppInterface.getNetEngine(0).sendReq(localHttpNetReq);
        localHttpNetReq.mCallback.onUpdateProgeress(localHttpNetReq, 1L, 100L);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(a, 2, "startDownloadMaterial url: " + paramblvb.d);
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
 * Qualified Name:     blvh
 * JD-Core Version:    0.7.0.1
 */