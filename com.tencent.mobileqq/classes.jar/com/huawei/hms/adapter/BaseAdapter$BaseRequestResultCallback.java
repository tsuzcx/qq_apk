package com.huawei.hms.adapter;

import android.app.Activity;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.Util;
import java.util.concurrent.atomic.AtomicBoolean;

public class BaseAdapter$BaseRequestResultCallback
  implements ResultCallback<ResolveResult<CoreBaseResponse>>
{
  private AtomicBoolean isFirstRsp = new AtomicBoolean(true);
  
  public BaseAdapter$BaseRequestResultCallback(BaseAdapter paramBaseAdapter) {}
  
  private void handleSolutionIntent(BaseAdapter.BaseCallBack paramBaseCallBack, CoreBaseResponse paramCoreBaseResponse)
  {
    HMSLog.i("BaseAdapter", "baseCallBack.onComplete");
    Object localObject = paramCoreBaseResponse.getPendingIntent();
    if (localObject != null)
    {
      paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
      return;
    }
    localObject = paramCoreBaseResponse.getIntent();
    if (localObject != null)
    {
      paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), (Parcelable)localObject);
      return;
    }
    paramBaseCallBack.onComplete(paramCoreBaseResponse.getJsonHeader(), paramCoreBaseResponse.getJsonBody(), null);
  }
  
  public void onResult(ResolveResult<CoreBaseResponse> paramResolveResult)
  {
    BaseAdapter.BaseCallBack localBaseCallBack = BaseAdapter.access$000(this.this$0);
    if (localBaseCallBack == null)
    {
      HMSLog.e("BaseAdapter", "onResult baseCallBack null");
      return;
    }
    if (paramResolveResult == null)
    {
      HMSLog.e("BaseAdapter", "result null");
      localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -1));
      return;
    }
    paramResolveResult = (CoreBaseResponse)paramResolveResult.getValue();
    if (paramResolveResult == null)
    {
      HMSLog.e("BaseAdapter", "response null");
      localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -1));
      return;
    }
    if (TextUtils.isEmpty(paramResolveResult.getJsonHeader()))
    {
      HMSLog.e("BaseAdapter", "jsonHeader null");
      localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -1));
      return;
    }
    JsonUtil.jsonToEntity(paramResolveResult.getJsonHeader(), BaseAdapter.access$200(this.this$0));
    Object localObject1;
    if (this.isFirstRsp.compareAndSet(true, false))
    {
      localObject1 = this.this$0;
      BaseAdapter.access$400((BaseAdapter)localObject1, BaseAdapter.access$300((BaseAdapter)localObject1), BaseAdapter.access$200(this.this$0));
    }
    if ("intent".equals(BaseAdapter.access$200(this.this$0).getResolution()))
    {
      localObject1 = BaseAdapter.access$500(this.this$0);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("activity is ");
      ((StringBuilder)localObject2).append(localObject1);
      HMSLog.i("BaseAdapter", ((StringBuilder)localObject2).toString());
      if ((localObject1 != null) && (!((Activity)localObject1).isFinishing()))
      {
        localObject2 = paramResolveResult.getPendingIntent();
        if (localObject2 != null)
        {
          if (Util.isAvailableLibExist(BaseAdapter.access$300(this.this$0)))
          {
            BaseAdapter.access$600(this.this$0, (Activity)localObject1, (Parcelable)localObject2);
            return;
          }
          localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -9));
          return;
        }
        paramResolveResult = paramResolveResult.getIntent();
        if (paramResolveResult != null)
        {
          if (Util.isAvailableLibExist(BaseAdapter.access$300(this.this$0)))
          {
            BaseAdapter.access$600(this.this$0, (Activity)localObject1, paramResolveResult);
            return;
          }
          localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -9));
          return;
        }
        HMSLog.e("BaseAdapter", "hasResolution is true but NO_SOLUTION");
        localBaseCallBack.onError(BaseAdapter.access$100(this.this$0, -4));
        return;
      }
      HMSLog.e("BaseAdapter", "activity null");
      handleSolutionIntent(localBaseCallBack, paramResolveResult);
      return;
    }
    handleSolutionIntent(localBaseCallBack, paramResolveResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter.BaseRequestResultCallback
 * JD-Core Version:    0.7.0.1
 */