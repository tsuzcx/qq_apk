package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.Const;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.MsgTabBannerData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PopBannerData;
import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public class WrapperTaskCallback
  implements ITaskCallback
{
  ITaskCallback a;
  
  public WrapperTaskCallback(ITaskCallback paramITaskCallback)
  {
    this.a = paramITaskCallback;
  }
  
  private static String a(BaseActivityData paramBaseActivityData)
  {
    if (paramBaseActivityData == null) {
      return "null";
    }
    return Const.a(paramBaseActivityData.type);
  }
  
  private static String b(BaseActivityData paramBaseActivityData)
  {
    if (paramBaseActivityData == null) {
      return "null";
    }
    return paramBaseActivityData.id;
  }
  
  public void a(long paramLong, BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onActivityStart actData actType = %s id=%s taskTime=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData), TimeFormatterUtils.b(paramLong) }));
      this.a.a(paramLong, paramBaseActivityData);
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(501, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onActivityStart ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void a(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onActivityAboutToOver actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      this.a.a(paramBaseActivityData);
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(503, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onActivityAboutToOver ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void a(MsgTabBannerData paramMsgTabBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("————> onMsgTabBannerShow data id = ");
      if (paramMsgTabBannerData == null) {}
      for (String str = "null";; str = paramMsgTabBannerData.id)
      {
        QLog.d("shua2021_WrapperTaskCallback", 1, str + " <————");
        this.a.a(paramMsgTabBannerData);
        return;
      }
      return;
    }
    catch (Exception paramMsgTabBannerData)
    {
      SpringHbMonitorReporter.a(515, paramMsgTabBannerData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onMsgTabBannerShow ex. " + paramMsgTabBannerData.getMessage(), paramMsgTabBannerData);
    }
  }
  
  public void a(PopBannerData paramPopBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("————> onPopBannerShow popBannerData id = ");
      if (paramPopBannerData == null) {}
      for (String str = "null";; str = paramPopBannerData.id)
      {
        QLog.d("shua2021_WrapperTaskCallback", 1, str + " <————");
        this.a.a(paramPopBannerData);
        return;
      }
      return;
    }
    catch (Exception paramPopBannerData)
    {
      SpringHbMonitorReporter.a(509, paramPopBannerData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onPopBannerShow ex. " + paramPopBannerData.getMessage(), paramPopBannerData);
    }
  }
  
  public void b(long paramLong, BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onActivityRealStart actData actType = %s id=%s taskTime=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData), TimeFormatterUtils.b(paramLong) }));
      this.a.b(paramLong, paramBaseActivityData);
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(502, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onActivityRealStart ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void b(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onActivityOver actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      this.a.b(paramBaseActivityData);
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(504, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onActivityOver ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void b(MsgTabBannerData paramMsgTabBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("————> onMsgTabBannerHide data id = ");
      if (paramMsgTabBannerData == null) {}
      for (String str = "null";; str = paramMsgTabBannerData.id)
      {
        QLog.d("shua2021_WrapperTaskCallback", 1, str + " <————");
        this.a.b(paramMsgTabBannerData);
        return;
      }
      return;
    }
    catch (Exception paramMsgTabBannerData)
    {
      SpringHbMonitorReporter.a(516, paramMsgTabBannerData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onMsgTabBannerHide ex. " + paramMsgTabBannerData.getMessage(), paramMsgTabBannerData);
    }
  }
  
  public void b(PopBannerData paramPopBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder().append("————> onPopBannerHide popBannerData id = ");
      if (paramPopBannerData == null) {}
      for (String str = "null";; str = paramPopBannerData.id)
      {
        QLog.d("shua2021_WrapperTaskCallback", 1, str + " <————");
        this.a.b(paramPopBannerData);
        return;
      }
      return;
    }
    catch (Exception paramPopBannerData)
    {
      SpringHbMonitorReporter.a(510, paramPopBannerData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onPopBannerHide ex. " + paramPopBannerData.getMessage(), paramPopBannerData);
    }
  }
  
  public void c(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onPendantShow actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2)) {
        this.a.c(paramBaseActivityData);
      }
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(505, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onPendantShow ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void d(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onPendantHide actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2)) {
        this.a.d(paramBaseActivityData);
      }
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(506, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onPendantHide ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void e(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onBreathLightShow actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2)) {
        this.a.e(paramBaseActivityData);
      }
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(507, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onBreathLightShow ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
  
  public void f(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onBreathLightHide actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2)) {
        this.a.f(paramBaseActivityData);
      }
      return;
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(508, paramBaseActivityData, new String[0]);
      QLog.e("shua2021_WrapperTaskCallback", 1, "onBreathLightHide ex. " + paramBaseActivityData.getMessage(), paramBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.WrapperTaskCallback
 * JD-Core Version:    0.7.0.1
 */