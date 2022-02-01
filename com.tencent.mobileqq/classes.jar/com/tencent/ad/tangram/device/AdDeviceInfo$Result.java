package com.tencent.ad.tangram.device;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.protocol.qq_ad_get.QQAdGet.DeviceInfo;
import java.util.ArrayList;
import java.util.List;

@Keep
public final class AdDeviceInfo$Result
{
  public qq_ad_get.QQAdGet.DeviceInfo deviceInfo = new qq_ad_get.QQAdGet.DeviceInfo();
  public List<AdAnalysisEvent> eventsForAnalysis = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.AdDeviceInfo.Result
 * JD-Core Version:    0.7.0.1
 */