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
    if ((paramList != null) && (paramList.size() > 0)) {
      return ((Integer)paramList.get(Math.abs(paramInt) % paramList.size())).intValue() * 1000;
    }
    return 0;
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
      while (i < paramJSONArray.length())
      {
        Object localObject = paramJSONArray.opt(i);
        if ((localObject instanceof JSONObject))
        {
          JSONObject localJSONObject = (JSONObject)localObject;
          int j = localJSONObject.optInt("Type");
          localObject = null;
          if (j != 1)
          {
            if (j != 2)
            {
              if (j == 3) {
                localObject = new MiniGameActivityData();
              }
            }
            else {
              localObject = new OnGrabActivityData();
            }
          }
          else {
            localObject = new PreGrabActivityData();
          }
          if (localObject != null)
          {
            ((BaseActivityData)localObject).parseJson(localJSONObject);
            this.activities.add(localObject);
          }
        }
        i += 1;
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
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((BaseActivityData)localIterator.next()).toSimpleString());
      localStringBuilder.append("|");
    }
    return localStringBuilder.toString();
  }
  
  public String getSimpleStringMsgTabBanners()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.msgTabBanners.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((MsgTabBannerData)localIterator.next()).toSimpleString());
      localStringBuilder.append("|");
    }
    return localStringBuilder.toString();
  }
  
  public String getSimpleStringPopBanners()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.popBanners.iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append(((PopBannerData)localIterator.next()).toSimpleString());
      localStringBuilder.append("|");
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
    if (paramJSONObject == null) {
      return;
    }
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
  
  public void preHandleConfigs()
  {
    int i = this.peakVersion;
    int j = 0;
    QLog.d("shua2021_EntryConfig", 1, String.format("preHandleConfigs pVer=%d delayList=%s", new Object[] { Integer.valueOf(i), Arrays.toString(this.delayList.toArray()) }));
    Collections.sort(this.popBanners, Const.a);
    Collections.sort(this.msgTabBanners, Const.a);
    Collections.sort(this.activities, Const.a);
    Iterator localIterator = this.popBanners.iterator();
    i = 0;
    Object localObject;
    int k;
    long l;
    while (localIterator.hasNext())
    {
      localObject = (PopBannerData)localIterator.next();
      if (((PopBannerData)localObject).staggerPeakSwitch)
      {
        k = a(i, this.delayList);
        l = k;
        if (((PopBannerData)localObject).getTaskTime().begin + l < ((PopBannerData)localObject).getTaskTime().end)
        {
          ((PopBannerData)localObject).peakDelayMs = k;
          localObject = ((PopBannerData)localObject).getTaskTime();
          ((TimeInfo)localObject).begin += l;
        }
        i += 1;
      }
    }
    localIterator = this.msgTabBanners.iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject = (MsgTabBannerData)localIterator.next();
      if (((MsgTabBannerData)localObject).staggerPeakSwitch)
      {
        k = a(i, this.delayList);
        l = k;
        if (((MsgTabBannerData)localObject).getTaskTime().begin + l < ((MsgTabBannerData)localObject).getTaskTime().end)
        {
          ((MsgTabBannerData)localObject).peakDelayMs = k;
          localObject = ((MsgTabBannerData)localObject).getTaskTime();
          ((TimeInfo)localObject).begin += l;
        }
        i += 1;
      }
    }
    localIterator = this.activities.iterator();
    i = j;
    while (localIterator.hasNext())
    {
      localObject = (BaseActivityData)localIterator.next();
      if (((BaseActivityData)localObject).staggerPeakSwitch)
      {
        j = a(i, this.delayList);
        l = j;
        if (((BaseActivityData)localObject).getTaskTime().begin + l < ((BaseActivityData)localObject).getTaskTime().end)
        {
          ((BaseActivityData)localObject).peakDelayMs = j;
          if (((BaseActivityData)localObject).scheduleTaskAfterPeak())
          {
            TimeInfo localTimeInfo = ((BaseActivityData)localObject).getTaskTime();
            localTimeInfo.begin += l;
            ((BaseActivityData)localObject).updatePeakDelay(j);
          }
        }
        i += 1;
      }
    }
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntryConfigBean{version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", peakVersion=");
    localStringBuilder.append(this.peakVersion);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(", delayList=");
    localStringBuilder.append(Arrays.toString(this.delayList.toArray()));
    localStringBuilder.append(", \ncommonData=");
    localStringBuilder.append(this.commonData.toSimpleString());
    localStringBuilder.append(", \npopBanners=");
    localStringBuilder.append(getSimpleStringPopBanners());
    localStringBuilder.append(", \nmsgTabBanners=");
    localStringBuilder.append(getSimpleStringMsgTabBanners());
    localStringBuilder.append(", \nactivities=");
    localStringBuilder.append(getSimpleStringActivities());
    localStringBuilder.append(", \nhtmlOfflineCheckConfig=");
    HtmlOfflineCheckConfig localHtmlOfflineCheckConfig = this.htmlOfflineCheckConfig;
    Object localObject = localHtmlOfflineCheckConfig;
    if (localHtmlOfflineCheckConfig == null) {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EntryConfigBean{version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append(", peakVersion=");
    localStringBuilder.append(this.peakVersion);
    localStringBuilder.append(", taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(", delayList=");
    localStringBuilder.append(Arrays.toString(this.delayList.toArray()));
    localStringBuilder.append(", \ncommonData=");
    localStringBuilder.append(this.commonData);
    localStringBuilder.append(", \npopBanners=");
    localStringBuilder.append(Arrays.toString(this.popBanners.toArray()));
    localStringBuilder.append(", \nmsgTabBanners=");
    localStringBuilder.append(Arrays.toString(this.msgTabBanners.toArray()));
    localStringBuilder.append(", \nactivities=");
    localStringBuilder.append(Arrays.toString(this.activities.toArray()));
    localStringBuilder.append(", \nhtmlOfflineCheckConfig=");
    HtmlOfflineCheckConfig localHtmlOfflineCheckConfig = this.htmlOfflineCheckConfig;
    Object localObject = localHtmlOfflineCheckConfig;
    if (localHtmlOfflineCheckConfig == null) {
      localObject = "null";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void validate()
  {
    b();
    c();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean
 * JD-Core Version:    0.7.0.1
 */