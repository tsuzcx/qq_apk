package com.huawei.hms.opendevice;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;

public class OpenDeviceClientImpl
  extends HuaweiApi<OpenDeviceOptions>
  implements OpenDeviceClient
{
  private static final OpenDeviceHmsClientBuilder a = new OpenDeviceHmsClientBuilder();
  private static final Api<OpenDeviceOptions> b = new Api("HuaweiOpenDevice.API");
  private static OpenDeviceOptions c = new OpenDeviceOptions();
  
  OpenDeviceClientImpl(Activity paramActivity)
  {
    super(paramActivity, b, c, a);
    super.setKitSdkVersion(50002300);
  }
  
  OpenDeviceClientImpl(Context paramContext)
  {
    super(paramContext, b, c, a);
    super.setKitSdkVersion(50002300);
  }
  
  public Task<OdidResult> getOdid()
  {
    String str = HiAnalyticsClient.reportEntry(getContext(), "opendevice.getodid", 50002300);
    return doWrite(new OpenDeviceTaskApiCall("opendevice.getodid", JsonUtil.createJsonString(null), str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDeviceClientImpl
 * JD-Core Version:    0.7.0.1
 */