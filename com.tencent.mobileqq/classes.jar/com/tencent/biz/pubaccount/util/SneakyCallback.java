package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.IdlePushWakeParam;

public class SneakyCallback
  implements IForeBackGroundCallback
{
  private static SneakyCallback a = new SneakyCallback();
  
  public static void a(int paramInt) {}
  
  public static void a(List<oidb_cmd0x80a.IdlePushWakeParam> paramList) {}
  
  public static void c()
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).addForeBackGroundCallback(a);
  }
  
  public static void d()
  {
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).removeForeBackGroundCallback(a);
  }
  
  public void a() {}
  
  public void cU_() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback
 * JD-Core Version:    0.7.0.1
 */