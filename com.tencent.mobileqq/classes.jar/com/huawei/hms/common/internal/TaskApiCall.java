package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.support.log.HMSLog;

public abstract class TaskApiCall<ClientT extends AnyClient, ResultT>
{
  private final String a;
  private final String b;
  private Parcelable c;
  private String d;
  private CancellationToken e;
  private int f = 1;
  
  @Deprecated
  public TaskApiCall(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = null;
    this.d = null;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = null;
    this.d = paramString3;
  }
  
  public TaskApiCall(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = null;
    this.d = paramString3;
    this.f = paramInt;
  }
  
  protected abstract void doExecute(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource);
  
  public int getApiLevel()
  {
    return this.f;
  }
  
  @Deprecated
  public int getMinApkVersion()
  {
    return 30000000;
  }
  
  public Parcelable getParcelable()
  {
    return this.c;
  }
  
  public String getRequestJson()
  {
    return this.b;
  }
  
  public CancellationToken getToken()
  {
    return this.e;
  }
  
  public String getTransactionId()
  {
    return this.d;
  }
  
  public String getUri()
  {
    return this.a;
  }
  
  public final void onResponse(ClientT paramClientT, ResponseErrorCode paramResponseErrorCode, String paramString, TaskCompletionSource<ResultT> paramTaskCompletionSource)
  {
    if ((this.e != null) && (this.e.isCancellationRequested()))
    {
      HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.a + ", transactionId:" + this.d);
      return;
    }
    doExecute(paramClientT, paramResponseErrorCode, paramString, paramTaskCompletionSource);
  }
  
  public void setApiLevel(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setParcelable(Parcelable paramParcelable)
  {
    this.c = paramParcelable;
  }
  
  public void setToken(CancellationToken paramCancellationToken)
  {
    this.e = paramCancellationToken;
  }
  
  public void setTransactionId(String paramString)
  {
    this.d = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.common.internal.TaskApiCall
 * JD-Core Version:    0.7.0.1
 */