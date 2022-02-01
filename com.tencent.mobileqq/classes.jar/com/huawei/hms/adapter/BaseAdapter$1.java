package com.huawei.hms.adapter;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.ResponseWrap;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;

class BaseAdapter$1
  implements SystemObserver
{
  BaseAdapter$1(BaseAdapter paramBaseAdapter) {}
  
  public boolean onSolutionResult(Intent paramIntent, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      HMSLog.e("BaseAdapter", "onSolutionResult but id is null");
      paramIntent = BaseAdapter.access$000(this.this$0);
      if (paramIntent == null)
      {
        HMSLog.e("BaseAdapter", "onSolutionResult baseCallBack null");
        return true;
      }
      paramIntent.onError(BaseAdapter.access$100(this.this$0, -6));
      return true;
    }
    if (paramString.equals(BaseAdapter.access$700(this.this$0)))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onSolutionResult + id is :");
      ((StringBuilder)localObject1).append(paramString);
      HMSLog.i("BaseAdapter", ((StringBuilder)localObject1).toString());
      paramString = BaseAdapter.access$000(this.this$0);
      if (paramString == null)
      {
        HMSLog.e("BaseAdapter", "onResult baseCallBack null");
        return true;
      }
      long l2 = 0L;
      if (paramIntent == null)
      {
        HMSLog.e("BaseAdapter", "onSolutionResult but data is null");
        paramIntent = BaseAdapter.access$100(this.this$0, -7);
        localObject1 = this.this$0;
        BaseAdapter.access$800((BaseAdapter)localObject1, BaseAdapter.access$300((BaseAdapter)localObject1), BaseAdapter.access$200(this.this$0), 0L);
        paramString.onError(paramIntent);
        return true;
      }
      int i;
      if (paramIntent.hasExtra("kit_update_result"))
      {
        i = paramIntent.getIntExtra("kit_update_result", 0);
        paramIntent = new StringBuilder();
        paramIntent.append("kit_update_result is ");
        paramIntent.append(i);
        HMSLog.i("BaseAdapter", paramIntent.toString());
        if (i == 1)
        {
          HMSLog.e("BaseAdapter", "kit update success,replay request");
          BaseAdapter.access$900(this.this$0);
          return true;
        }
        HMSLog.e("BaseAdapter", "kit update failed");
        paramIntent = this.this$0;
        paramString.onError(BaseAdapter.access$1100(paramIntent, -10, BaseAdapter.access$1000(paramIntent, i)).toJson());
        return true;
      }
      HMSLog.e("BaseAdapter", "onComplete for on activity result");
      localObject1 = paramIntent.getStringExtra("json_header");
      String str = paramIntent.getStringExtra("json_body");
      Object localObject2 = JsonUtil.getInfoFromJsonobject((String)localObject1, "status_code");
      Object localObject3 = JsonUtil.getInfoFromJsonobject((String)localObject1, "error_code");
      long l1 = l2;
      if (paramIntent.hasExtra("HMS_FOREGROUND_RES_UI"))
      {
        paramIntent = JsonUtil.getInfoFromJsonobject(paramIntent.getStringExtra("HMS_FOREGROUND_RES_UI"), "uiDuration");
        l1 = l2;
        if ((paramIntent instanceof Long)) {
          l1 = ((Long)paramIntent).longValue();
        }
      }
      if (((localObject2 instanceof Integer)) && ((localObject3 instanceof Integer)))
      {
        i = ((Integer)localObject2).intValue();
        int j = ((Integer)localObject3).intValue();
        BaseAdapter.access$100(this.this$0, j);
        BaseAdapter.access$200(this.this$0).setStatusCode(i);
        paramIntent = this.this$0;
        BaseAdapter.access$800(paramIntent, BaseAdapter.access$300(paramIntent), BaseAdapter.access$200(this.this$0), l1);
      }
      else
      {
        BaseAdapter.access$100(this.this$0, -8);
        paramIntent = this.this$0;
        BaseAdapter.access$800(paramIntent, BaseAdapter.access$300(paramIntent), BaseAdapter.access$200(this.this$0), l1);
      }
      paramString.onComplete((String)localObject1, str, null);
      return true;
    }
    return false;
  }
  
  public boolean onUpdateResult(int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.adapter.BaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */