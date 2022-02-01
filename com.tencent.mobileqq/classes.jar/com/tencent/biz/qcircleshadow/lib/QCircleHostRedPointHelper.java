package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleHostRedPointHelper
{
  public static void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    getService().asyncGetNumRedPointInfoByAppid(paramString, paramOnGetQQCircleNumRedMsgListener, paramBoolean);
  }
  
  public static QQCircleCounter.RedPointInfo getOuterEntranceRedPointInfoByAppid(String paramString)
  {
    return getService().getOuterEntranceRedPointInfoByAppid(paramString);
  }
  
  private static IQCircleRedPointService getService()
  {
    return (IQCircleRedPointService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQCircleRedPointService.class, "");
  }
  
  public static QQCircleCounter.RedPointInfo getSmallRedPointInfotByAppid(String paramString)
  {
    return getService().getSmallRedPointInfotByAppid(paramString);
  }
  
  public static void setNumRedPointReaded(String paramString)
  {
    getService().setNumRedPointReaded(paramString);
  }
  
  public static void setOuterEntranceRedPointReaded(String paramString, List<Integer> paramList)
  {
    getService().setOuterEntranceRedPointReaded(paramString, paramList);
  }
  
  public static void setSmallRedPointReaded(String paramString)
  {
    getService().setSmallRedPointReaded(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.QCircleHostRedPointHelper
 * JD-Core Version:    0.7.0.1
 */