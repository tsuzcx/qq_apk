package com.tencent.mobileqq.activity.springfestival.entry.model;

import com.tencent.mobileqq.activity.springfestival.Const;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketPopBannerConfBean;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class EntryConfigBean
  implements Serializable
{
  public static final String TAG = "shua2021_EntryConfig";
  @NotNull
  public List<BaseActivityData> activities = new ArrayList();
  @NotNull
  public CommonData commonData = CommonData.newEmpty();
  public List<Integer> delayList = new ArrayList();
  @Nullable
  public HtmlOfflineCheckConfig htmlOfflineCheckConfig;
  @NotNull
  public List<MsgTabBannerData> msgTabBanners = new ArrayList();
  public int peakVersion = 0;
  @NotNull
  public List<PopBannerData> popBanners = new ArrayList();
  public int taskId = 0;
  public int version = 0;
  
  private int a(int paramInt, List<Integer> paramList)
  {
    int j = 0;
    int i = j;
    if (paramList != null)
    {
      i = j;
      if (paramList.size() > 0) {
        i = ((Integer)paramList.get(Math.abs(paramInt) % paramList.size())).intValue() * 1000;
      }
    }
    return i;
  }
  
  private void a()
  {
    Collections.sort(this.activities, Const.a);
    Iterator localIterator = this.activities.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      BaseActivityData localBaseActivityData = (BaseActivityData)localIterator.next();
      if (!Const.a(localBaseActivityData.getConfigTime()))
      {
        localIterator.remove();
        QLog.d("shua2021_EntryConfig", 1, String.format("validateActivityList time invalid remove. %s time=%s", new Object[] { localBaseActivityData, localBaseActivityData.getConfigTime() }));
      }
      else
      {
        if (localObject != null)
        {
          localBaseActivityData.configTimeInfo = Const.a(localObject.configTimeInfo, localBaseActivityData.configTimeInfo);
          if (!Const.a(localBaseActivityData.getConfigTime()))
          {
            localIterator.remove();
            QLog.d("shua2021_EntryConfig", 1, String.format("validateActivityList time invalid after valid cross over remove. %s", new Object[] { localBaseActivityData }));
            continue;
          }
        }
        localBaseActivityData.validate();
        localObject = localBaseActivityData;
      }
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i = 0;
      if (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        JSONObject localJSONObject;
        if ((localObject instanceof JSONObject))
        {
          localJSONObject = (JSONObject)localObject;
          int j = localJSONObject.optInt("Type");
          localObject = null;
          switch (j)
          {
          }
        }
        for (;;)
        {
          if (localObject != null)
          {
            ((BaseActivityData)localObject).parseJson(localJSONObject);
            this.activities.add(localObject);
          }
          i += 1;
          break;
          localObject = new PreGrabActivityData();
          continue;
          localObject = new OnGrabActivityData();
          continue;
          localObject = new MiniGameActivityData();
        }
      }
    }
  }
  
  private void b()
  {
    Collections.sort(this.popBanners, Const.a);
    Iterator localIterator = this.popBanners.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      PopBannerData localPopBannerData = (PopBannerData)localIterator.next();
      if (!Const.a(localPopBannerData.getConfigTime()))
      {
        localIterator.remove();
        QLog.d("shua2021_EntryConfig", 1, String.format("validatePopBannerList time invalid remove. %s", new Object[] { localPopBannerData }));
      }
      else
      {
        if (localObject != null)
        {
          localPopBannerData.configTimeInfo = Const.a(localObject.configTimeInfo, localPopBannerData.configTimeInfo);
          if (!Const.a(localPopBannerData.getConfigTime()))
          {
            localIterator.remove();
            QLog.d("shua2021_EntryConfig", 1, String.format("validatePopBannerList time invalid after valid cross over remove. %s", new Object[] { localPopBannerData }));
            continue;
          }
        }
        localObject = localPopBannerData;
      }
    }
  }
  
  private void b(JSONArray paramJSONArray)
  {
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if ((localObject instanceof JSONObject))
        {
          localObject = (JSONObject)localObject;
          MsgTabBannerData localMsgTabBannerData = new MsgTabBannerData();
          localMsgTabBannerData.parseJson((JSONObject)localObject);
          this.msgTabBanners.add(localMsgTabBannerData);
        }
        i += 1;
      }
    }
  }
  
  private void c()
  {
    Collections.sort(this.msgTabBanners, Const.a);
    Iterator localIterator = this.msgTabBanners.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      MsgTabBannerData localMsgTabBannerData = (MsgTabBannerData)localIterator.next();
      if (!Const.a(localMsgTabBannerData.getConfigTime()))
      {
        localIterator.remove();
        QLog.d("shua2021_EntryConfig", 1, String.format("validatePopBannerList time invalid remove. %s", new Object[] { localMsgTabBannerData }));
      }
      else
      {
        if (localObject != null)
        {
          localMsgTabBannerData.configTimeInfo = Const.a(localObject.configTimeInfo, localMsgTabBannerData.configTimeInfo);
          if (!Const.a(localMsgTabBannerData.getConfigTime()))
          {
            localIterator.remove();
            QLog.d("shua2021_EntryConfig", 1, String.format("validatePopBannerList time invalid after valid cross over remove. %s", new Object[] { localMsgTabBannerData }));
            continue;
          }
        }
        localObject = localMsgTabBannerData;
      }
    }
  }
  
  public String getSimpleStringActivities()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.activities.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((BaseActivityData)localIterator.next()).toSimpleString()).append("|");
    }
    return localStringBuilder.toString();
  }
  
  public String getSimpleStringMsgTabBanners()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.msgTabBanners.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((MsgTabBannerData)localIterator.next()).toSimpleString()).append("|");
    }
    return localStringBuilder.toString();
  }
  
  public String getSimpleStringPopBanners()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.popBanners.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((PopBannerData)localIterator.next()).toSimpleString()).append("|");
    }
    return localStringBuilder.toString();
  }
  
  public void onGetPopBannerConfig(SpringFestivalRedpacketPopBannerConfBean paramSpringFestivalRedpacketPopBannerConfBean)
  {
    this.popBanners.clear();
    if ((paramSpringFestivalRedpacketPopBannerConfBean != null) && (paramSpringFestivalRedpacketPopBannerConfBean.a != null))
    {
      int i = 0;
      while (i < paramSpringFestivalRedpacketPopBannerConfBean.a.length())
      {
        Object localObject = paramSpringFestivalRedpacketPopBannerConfBean.a.opt(i);
        if ((localObject instanceof JSONObject))
        {
          localObject = (JSONObject)localObject;
          PopBannerData localPopBannerData = new PopBannerData();
          localPopBannerData.parseJson((JSONObject)localObject);
          this.popBanners.add(localPopBannerData);
        }
        i += 1;
      }
    }
    b();
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      try
      {
        this.commonData.parseJson(paramJSONObject.optJSONObject("Common"));
        a(paramJSONObject.optJSONArray("ActivityList"));
        b(paramJSONObject.optJSONArray("MsgTabBannerList"));
        paramJSONObject = paramJSONObject.optJSONObject("htmloffline_check_configs");
        if (paramJSONObject != null)
        {
          this.htmlOfflineCheckConfig = new HtmlOfflineCheckConfig();
          this.htmlOfflineCheckConfig.parseJson(paramJSONObject);
          return;
        }
      }
      catch (Throwable paramJSONObject)
      {
        QLog.d("shua2021_EntryConfig", 1, paramJSONObject.getMessage(), paramJSONObject);
      }
    }
  }
  
  public void preHandleConfigs()
  {
    int j = 0;
    QLog.d("shua2021_EntryConfig", 1, String.format("preHandleConfigs pVer=%d delayList=%s", new Object[] { Integer.valueOf(this.peakVersion), Arrays.toString(this.delayList.toArray()) }));
    Collections.sort(this.popBanners, Const.a);
    Collections.sort(this.msgTabBanners, Const.a);
    Collections.sort(this.activities, Const.a);
    Iterator localIterator = this.popBanners.iterator();
    int i = 0;
    Object localObject;
    int k;
    if (localIterator.hasNext())
    {
      localObject = (PopBannerData)localIterator.next();
      if (!((PopBannerData)localObject).staggerPeakSwitch) {
        break label418;
      }
      k = a(i, this.delayList);
      if (k + ((PopBannerData)localObject).getTaskTime().begin < ((PopBannerData)localObject).getTaskTime().end)
      {
        ((PopBannerData)localObject).peakDelayMs = k;
        localObject = ((PopBannerData)localObject).getTaskTime();
        ((TimeInfo)localObject).begin += k;
      }
      i += 1;
    }
    label415:
    label418:
    for (;;)
    {
      break;
      localIterator = this.msgTabBanners.iterator();
      i = 0;
      if (localIterator.hasNext())
      {
        localObject = (MsgTabBannerData)localIterator.next();
        if (!((MsgTabBannerData)localObject).staggerPeakSwitch) {
          break label415;
        }
        k = a(i, this.delayList);
        if (k + ((MsgTabBannerData)localObject).getTaskTime().begin < ((MsgTabBannerData)localObject).getTaskTime().end)
        {
          ((MsgTabBannerData)localObject).peakDelayMs = k;
          localObject = ((MsgTabBannerData)localObject).getTaskTime();
          ((TimeInfo)localObject).begin += k;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        localIterator = this.activities.iterator();
        i = j;
        while (localIterator.hasNext())
        {
          localObject = (BaseActivityData)localIterator.next();
          if (((BaseActivityData)localObject).staggerPeakSwitch)
          {
            j = a(i, this.delayList);
            if (j + ((BaseActivityData)localObject).getTaskTime().begin < ((BaseActivityData)localObject).getTaskTime().end)
            {
              ((BaseActivityData)localObject).peakDelayMs = j;
              if (((BaseActivityData)localObject).scheduleTaskAfterPeak())
              {
                TimeInfo localTimeInfo = ((BaseActivityData)localObject).getTaskTime();
                localTimeInfo.begin += j;
                ((BaseActivityData)localObject).updatePeakDelay(j);
              }
            }
            i += 1;
          }
        }
        return;
      }
    }
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("EntryConfigBean{version=").append(this.version).append(", peakVersion=").append(this.peakVersion).append(", taskId=").append(this.taskId).append(", delayList=").append(Arrays.toString(this.delayList.toArray())).append(", \ncommonData=").append(this.commonData.toSimpleString()).append(", \npopBanners=").append(getSimpleStringPopBanners()).append(", \nmsgTabBanners=").append(getSimpleStringMsgTabBanners()).append(", \nactivities=").append(getSimpleStringActivities()).append(", \nhtmlOfflineCheckConfig=");
    if (this.htmlOfflineCheckConfig == null) {}
    for (Object localObject = "null";; localObject = this.htmlOfflineCheckConfig) {
      return localObject + '}';
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("EntryConfigBean{version=").append(this.version).append(", peakVersion=").append(this.peakVersion).append(", taskId=").append(this.taskId).append(", delayList=").append(Arrays.toString(this.delayList.toArray())).append(", \ncommonData=").append(this.commonData).append(", \npopBanners=").append(Arrays.toString(this.popBanners.toArray())).append(", \nmsgTabBanners=").append(Arrays.toString(this.msgTabBanners.toArray())).append(", \nactivities=").append(Arrays.toString(this.activities.toArray())).append(", \nhtmlOfflineCheckConfig=");
    if (this.htmlOfflineCheckConfig == null) {}
    for (Object localObject = "null";; localObject = this.htmlOfflineCheckConfig) {
      return localObject + '}';
    }
  }
  
  public void validate()
  {
    b();
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean
 * JD-Core Version:    0.7.0.1
 */