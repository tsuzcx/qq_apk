package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class ReadInJoySpEventReportUtil$1
  extends LbsManagerServiceOnLocationChangeListener
{
  ReadInJoySpEventReportUtil$1(String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    ReadInJoySpEventReportUtil.a(false);
    QLog.d("ReadInJoySpEventReportUtil", 1, new Object[] { "onLocationFinish errCode = ", Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null)) {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).reportPushEffectEvent(100, new ArrayList());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoySpEventReportUtil.1
 * JD-Core Version:    0.7.0.1
 */