package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT>
{
  private static final String TAG = "TaskApiCall";
  private int apiLevel = 1;
  private final String mRequestJson;
  private final String mUri;
  private Parcelable parcelable;
  private CancellationToken token;
  private String transactionId;
  
  @Deprecated
  public TaskApiCall(String paramString1, String paramString2)
  {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = null;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3)
  {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = paramString3;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.mUri = paramString1;
    this.mRequestJson = paramString2;
    this.parcelable = null;
    this.transactionId = paramString3;
    this.apiLevel = paramInt;
  }
  
  protected abstract void doExecute(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource);
  
  public int getApiLevel()
  {
    return this.apiLevel;
  }
  
  @Deprecated
  public int getMinApkVersion()
  {
    return 30000000;
  }
  
  public Parcelable getParcelable()
  {
    return this.parcelable;
  }
  
  public String getRequestJson()
  {
    return this.mRequestJson;
  }
  
  public CancellationToken getToken()
  {
    return this.token;
  }
  
  public String getTransactionId()
  {
    return this.transactionId;
  }
  
  public String getUri()
  {
    return this.mUri;
  }
  
  public final void onResponse(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource)
  {
    CancellationToken localCancellationToken = this.token;
    if ((localCancellationToken != null) && (localCancellationToken.isCancellationRequested()))
    {
      paramClientT = new StringBuilder();
      paramClientT.append("This Task has been canceled, uri:");
      paramClientT.append(this.mUri);
      paramClientT.append(", transactionId:");
      paramClientT.append(this.transactionId);
      HMSLog.i("TaskApiCall", paramClientT.toString());
      return;
    }
    doExecute(paramClientT, paramResponseErrorCode, paramString, paramTaskCompletionSource);
  }
  
  public void setApiLevel(int paramInt)
  {
    this.apiLevel = paramInt;
  }
  
  public void setParcelable(Parcelable paramParcelable)
  {
    this.parcelable = paramParcelable;
  }
  
  public void setToken(CancellationToken paramCancellationToken)
  {
    this.token = paramCancellationToken;
  }
  
  public void setTransactionId(String paramString)
  {
    this.transactionId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.TaskApiCall
 * JD-Core Version:    0.7.0.1
 */