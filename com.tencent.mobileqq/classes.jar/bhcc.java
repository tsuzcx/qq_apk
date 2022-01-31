import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import dov.com.qq.im.AECamera.qudong.UrlConHttpClient.1;
import dov.com.qq.im.AECamera.qudong.UrlConHttpClient.2;
import java.util.concurrent.Executor;

public class bhcc
  implements IHttpClient
{
  private static final String jdField_a_of_type_JavaLangString = bhcc.class.getSimpleName();
  private IResponseListener jdField_a_of_type_ComTencentTtpicOpenapiOfflinesetUtilsIResponseListener;
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentTtpicOpenapiOfflinesetUtilsIResponseListener != null) {
      this.jdField_a_of_type_ComTencentTtpicOpenapiOfflinesetUtilsIResponseListener.response(paramInt, 1, paramString1, paramString2);
    }
  }
  
  public void download(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    LogUtils.i(jdField_a_of_type_JavaLangString, "开始下载文件:" + paramString2);
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(jdField_a_of_type_JavaLangString, "downUrl 无效：" + paramString2);
      return;
    }
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.2(this, paramString2, paramString3, paramInt, paramString1));
  }
  
  public void get(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      LogUtils.e(jdField_a_of_type_JavaLangString, "url 无效：" + paramString2);
      return;
    }
    LogUtils.i(jdField_a_of_type_JavaLangString, "GET 请求：" + paramString2);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.1(this, paramString2, paramInt, paramString1));
  }
  
  public void post(int paramInt, String paramString1, String paramString2) {}
  
  public void setResponseListener(IResponseListener paramIResponseListener)
  {
    LogUtils.i(jdField_a_of_type_JavaLangString, "setResponseListener ");
    this.jdField_a_of_type_ComTencentTtpicOpenapiOfflinesetUtilsIResponseListener = paramIResponseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhcc
 * JD-Core Version:    0.7.0.1
 */