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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityStart ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityAboutToOver ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
  
  public void a(MsgTabBannerData paramMsgTabBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("————> onMsgTabBannerShow data id = ");
      if (paramMsgTabBannerData == null) {
        localObject = "null";
      } else {
        localObject = paramMsgTabBannerData.id;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" <————");
      QLog.d("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString());
      this.a.a(paramMsgTabBannerData);
      return;
    }
    catch (Exception paramMsgTabBannerData)
    {
      SpringHbMonitorReporter.a(515, paramMsgTabBannerData, new String[0]);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabBannerShow ex. ");
      ((StringBuilder)localObject).append(paramMsgTabBannerData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, ((StringBuilder)localObject).toString(), paramMsgTabBannerData);
    }
  }
  
  public void a(PopBannerData paramPopBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("————> onPopBannerShow popBannerData id = ");
      if (paramPopBannerData == null) {
        localObject = "null";
      } else {
        localObject = paramPopBannerData.id;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" <————");
      QLog.d("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString());
      this.a.a(paramPopBannerData);
      return;
    }
    catch (Exception paramPopBannerData)
    {
      SpringHbMonitorReporter.a(509, paramPopBannerData, new String[0]);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPopBannerShow ex. ");
      ((StringBuilder)localObject).append(paramPopBannerData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, ((StringBuilder)localObject).toString(), paramPopBannerData);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityRealStart ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onActivityOver ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
  
  public void b(MsgTabBannerData paramMsgTabBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("————> onMsgTabBannerHide data id = ");
      if (paramMsgTabBannerData == null) {
        localObject = "null";
      } else {
        localObject = paramMsgTabBannerData.id;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" <————");
      QLog.d("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString());
      this.a.b(paramMsgTabBannerData);
      return;
    }
    catch (Exception paramMsgTabBannerData)
    {
      SpringHbMonitorReporter.a(516, paramMsgTabBannerData, new String[0]);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onMsgTabBannerHide ex. ");
      ((StringBuilder)localObject).append(paramMsgTabBannerData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, ((StringBuilder)localObject).toString(), paramMsgTabBannerData);
    }
  }
  
  public void b(PopBannerData paramPopBannerData)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("————> onPopBannerHide popBannerData id = ");
      if (paramPopBannerData == null) {
        localObject = "null";
      } else {
        localObject = paramPopBannerData.id;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" <————");
      QLog.d("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString());
      this.a.b(paramPopBannerData);
      return;
    }
    catch (Exception paramPopBannerData)
    {
      SpringHbMonitorReporter.a(510, paramPopBannerData, new String[0]);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPopBannerHide ex. ");
      ((StringBuilder)localObject).append(paramPopBannerData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, ((StringBuilder)localObject).toString(), paramPopBannerData);
    }
  }
  
  public void c(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onPendantShow actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2))
      {
        this.a.c(paramBaseActivityData);
        return;
      }
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(505, paramBaseActivityData, new String[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPendantShow ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
  
  public void d(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onPendantHide actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2))
      {
        this.a.d(paramBaseActivityData);
        return;
      }
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(506, paramBaseActivityData, new String[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPendantHide ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
  
  public void e(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onBreathLightShow actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2))
      {
        this.a.e(paramBaseActivityData);
        return;
      }
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(507, paramBaseActivityData, new String[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBreathLightShow ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
  
  public void f(BaseActivityData paramBaseActivityData)
  {
    try
    {
      QLog.d("shua2021_WrapperTaskCallback", 1, String.format("————> onBreathLightHide actData actType = %s id=%s <————", new Object[] { a(paramBaseActivityData), b(paramBaseActivityData) }));
      if ((paramBaseActivityData != null) && (paramBaseActivityData.getType() != 2))
      {
        this.a.f(paramBaseActivityData);
        return;
      }
    }
    catch (Exception paramBaseActivityData)
    {
      SpringHbMonitorReporter.a(508, paramBaseActivityData, new String[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBreathLightHide ex. ");
      localStringBuilder.append(paramBaseActivityData.getMessage());
      QLog.e("shua2021_WrapperTaskCallback", 1, localStringBuilder.toString(), paramBaseActivityData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.WrapperTaskCallback
 * JD-Core Version:    0.7.0.1
 */