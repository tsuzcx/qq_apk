package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.stats.bt.a;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicBoolean;

class HMSBIInitializer$1
  implements IQueryUrlCallBack
{
  HMSBIInitializer$1(HMSBIInitializer paramHMSBIInitializer) {}
  
  public void onCallBackFail(int paramInt)
  {
    HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + paramInt);
    HMSBIInitializer.b(this.a).set(false);
  }
  
  public void onCallBackSuccess(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HMSBIInitializer.a(this.a).d(false).b(false).c(false).a(0, paramString).a(1, paramString).a("com.huawei.hwid").a();
      HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
    }
    HMSBIInitializer.b(this.a).set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer.1
 * JD-Core Version:    0.7.0.1
 */