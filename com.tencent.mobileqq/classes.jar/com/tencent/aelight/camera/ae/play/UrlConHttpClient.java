package com.tencent.aelight.camera.ae.play;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.offlineset.utils.IHttpClient;
import com.tencent.ttpic.openapi.offlineset.utils.IResponseListener;
import java.util.concurrent.Executor;

public class UrlConHttpClient
  implements IHttpClient
{
  private static final String TAG = "UrlConHttpClient";
  private IResponseListener mResponseListener;
  
  private void errorResponse(int paramInt, String paramString1, String paramString2)
  {
    IResponseListener localIResponseListener = this.mResponseListener;
    if (localIResponseListener != null) {
      localIResponseListener.response(paramInt, 1, paramString1, paramString2);
    }
  }
  
  public void download(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开始下载文件:");
    localStringBuilder.append(paramString2);
    LogUtils.i(str, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = TAG;
      paramString3 = new StringBuilder();
      paramString3.append("downUrl 无效：");
      paramString3.append(paramString2);
      LogUtils.e(paramString1, paramString3.toString());
      return;
    }
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.2(this, paramString2, paramString3, paramInt, paramString1));
  }
  
  public void get(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      paramString1 = TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url 无效：");
      ((StringBuilder)localObject).append(paramString2);
      LogUtils.e(paramString1, ((StringBuilder)localObject).toString());
      return;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GET 请求：");
    localStringBuilder.append(paramString2);
    LogUtils.i((String)localObject, localStringBuilder.toString());
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new UrlConHttpClient.1(this, paramString2, paramInt, paramString1));
  }
  
  public void post(int paramInt, String paramString1, String paramString2) {}
  
  public void setResponseListener(IResponseListener paramIResponseListener)
  {
    LogUtils.i(TAG, "setResponseListener ");
    this.mResponseListener = paramIResponseListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.UrlConHttpClient
 * JD-Core Version:    0.7.0.1
 */