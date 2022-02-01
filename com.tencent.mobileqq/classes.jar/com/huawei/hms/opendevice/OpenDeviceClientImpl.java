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
  public static final OpenDeviceHmsClientBuilder a = new OpenDeviceHmsClientBuilder();
  public static final Api<OpenDeviceOptions> b = new Api("HuaweiOpenDevice.API");
  public static OpenDeviceOptions c = new OpenDeviceOptions();
  
  public OpenDeviceClientImpl(Activity paramActivity)
  {
    super(paramActivity, b, c, a);
    super.setKitSdkVersion(50101300);
  }
  
  public OpenDeviceClientImpl(Context paramContext)
  {
    super(paramContext, b, c, a);
    super.setKitSdkVersion(50101300);
  }
  
  public Task<OdidResult> getOdid()
  {
    String str = HiAnalyticsClient.reportEntry(getContext(), "opendevice.getodid", 50101300);
    return doWrite(new OpenDeviceTaskApiCall("opendevice.getodid", JsonUtil.createJsonString(null), str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.opendevice.OpenDeviceClientImpl
 * JD-Core Version:    0.7.0.1
 */