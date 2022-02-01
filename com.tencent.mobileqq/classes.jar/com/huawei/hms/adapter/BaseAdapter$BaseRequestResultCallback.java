package com.huawei.hms.adapter;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;

public class BaseAdapter$BaseRequestResultCallback
  implements ResultCallback<ResolveResult<CoreBaseResponse>>
{
  public BaseAdapter$BaseRequestResultCallback(BaseAdapter paramBaseAdapter) {}
  
  private void a(BaseAdapter.BaseCallBack paramBaseCallBack, CoreBaseResponse paramCoreBaseResponse)
  {
    HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
    Object localObject = paramCoreBaseResponse.getPendingIntent();
    if (localObject != null)
    {
      BaseAdapter.b(this.a);
      paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
      return;
    }
    localObject = paramCoreBaseResponse.getIntent();
    if (localObject != null)
    {
      BaseAdapter.b(this.a);
      paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
      return;
    }
    BaseAdapter.b(this.a);
    paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), null);
  }
  
  public void onResult(ResolveResult<CoreBaseResponse> paramResolveResult)
  {
    BaseAdapter.BaseCallBack localBaseCallBack = BaseAdapter.a(this.a);
    if (localBaseCallBack == null)
    {
      HMSLog.e("BaseAdapter", "onResult baseCallBack null");
      BaseAdapter.b(this.a);
      return;
    }
    if (paramResolveResult == null)
    {
      HMSLog.e("BaseAdapter", "result null");
      localBaseCallBack.onError(BaseAdapter.a(this.a, -1));
      BaseAdapter.b(this.a);
      return;
    }
    Object localObject = (CoreBaseResponse)paramResolveResult.getValue();
    if (localObject == null)
    {
      HMSLog.e("BaseAdapter", "response null");
      BaseAdapter.b(this.a);
      localBaseCallBack.onError(BaseAdapter.a(this.a, -1));
      return;
    }
    if (TextUtils.isEmpty(((CoreBaseResponse)localObject).getJsonHeader()))
    {
      HMSLog.e("BaseAdapter", "jsonHeader null");
      BaseAdapter.b(this.a);
      localBaseCallBack.onError(BaseAdapter.a(this.a, -1));
      return;
    }
    JsonUtil.jsonToEntity(((CoreBaseResponse)localObject).getJsonHeader(), BaseAdapter.c(this.a));
    BaseAdapter.a(this.a, BaseAdapter.d(this.a), BaseAdapter.c(this.a));
    if ("intent".equals(BaseAdapter.c(this.a).getResolution()))
    {
      paramResolveResult = BaseAdapter.e(this.a);
      HMSLog.i("BaseAdapter", "activity is " + paramResolveResult);
      if ((paramResolveResult == null) || (paramResolveResult.isFinishing()))
      {
        HMSLog.e("BaseAdapter", "activity null");
        a(localBaseCallBack, (CoreBaseResponse)localObject);
        return;
      }
      PendingIntent localPendingIntent = ((CoreBaseResponse)localObject).getPendingIntent();
      if (localPendingIntent != null)
      {
        if (Util.isAvailableLibExist(BaseAdapter.d(this.a)))
        {
          BaseAdapter.a(this.a, paramResolveResult, localPendingIntent);
          return;
        }
        localBaseCallBack.onError(BaseAdapter.a(this.a, -9));
        return;
      }
      localObject = ((CoreBaseResponse)localObject).getIntent();
      if (localObject != null)
      {
        if (Util.isAvailableLibExist(BaseAdapter.d(this.a)))
        {
          BaseAdapter.a(this.a, paramResolveResult, (Parcelable)localObject);
          return;
        }
        localBaseCallBack.onError(BaseAdapter.a(this.a, -9));
        return;
      }
      HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
      BaseAdapter.b(this.a);
      localBaseCallBack.onError(BaseAdapter.a(this.a, -4));
      return;
    }
    a(localBaseCallBack, (CoreBaseResponse)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback
 * JD-Core Version:    0.7.0.1
 */