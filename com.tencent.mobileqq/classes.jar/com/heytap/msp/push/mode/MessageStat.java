package com.heytap.msp.push.mode;

import android.text.TextUtils;
import com.heytap.mcssdk.f.c;
import org.json.JSONObject;

public class MessageStat
{
  private static final String APP_PACKAGE = "appPackage";
  private static final String EVENT_ID = "eventID";
  private static final String EVENT_TIME = "eventTime";
  private static final String GLOBAL_ID = "globalID";
  private static final String MESSAGE_TYPE = "messageType";
  private static final String PROPERTY = "property";
  private static final String TASK_ID = "taskID";
  private String mAppPackage;
  private String mEventId;
  private long mEventTime = System.currentTimeMillis();
  private String mGlobalId;
  private String mProperty;
  private String mTaskID;
  private int mType = 4096;
  
  public MessageStat() {}
  
  public MessageStat(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this(paramInt, paramString1, null, null, paramString2, paramString3);
  }
  
  public MessageStat(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    setType(paramInt);
    setAppPackage(paramString1);
    setGlobalId(paramString2);
    setTaskID(paramString3);
    setEventId(paramString4);
    setProperty(paramString5);
  }
  
  public MessageStat(String paramString1, String paramString2)
  {
    this(4096, paramString1, null, null, paramString2, "");
  }
  
  public MessageStat(String paramString1, String paramString2, String paramString3)
  {
    this(4096, paramString1, null, null, paramString2, paramString3);
  }
  
  public static MessageStat parse(String paramString)
  {
    MessageStat localMessageStat = new MessageStat();
    try
    {
      paramString = new JSONObject(paramString);
      localMessageStat.setType(paramString.optInt("messageType", 0));
      localMessageStat.setAppPackage(paramString.optString("appPackage"));
      localMessageStat.setEventId(paramString.optString("eventID"));
      localMessageStat.setGlobalId(paramString.optString("globalID", ""));
      localMessageStat.setTaskID(paramString.optString("taskID", ""));
      localMessageStat.setProperty(paramString.optString("property", ""));
      localMessageStat.setEventTime(paramString.optLong("eventTime", System.currentTimeMillis()));
      return localMessageStat;
    }
    catch (Exception paramString)
    {
      c.b(paramString.getLocalizedMessage());
    }
    return null;
  }
  
  public String getAppPackage()
  {
    return this.mAppPackage;
  }
  
  public String getEventId()
  {
    return this.mEventId;
  }
  
  public long getEventTime()
  {
    return this.mEventTime;
  }
  
  public String getGlobalId()
  {
    return this.mGlobalId;
  }
  
  public String getProperty()
  {
    return this.mProperty;
  }
  
  public String getTaskID()
  {
    return this.mTaskID;
  }
  
  public int getType()
  {
    return this.mType;
  }
  
  public void setAppPackage(String paramString)
  {
    this.mAppPackage = paramString;
  }
  
  public void setEventId(String paramString)
  {
    this.mEventId = paramString;
  }
  
  public void setEventTime(long paramLong)
  {
    this.mEventTime = paramLong;
  }
  
  public void setGlobalId(String paramString)
  {
    this.mGlobalId = paramString;
  }
  
  public void setProperty(String paramString)
  {
    this.mProperty = paramString;
  }
  
  public void setTaskID(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    this.mTaskID = localStringBuilder.toString();
  }
  
  public void setTaskID(String paramString)
  {
    this.mTaskID = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.mType = paramInt;
  }
  
  public String toJsonObject()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.putOpt("messageType", Integer.valueOf(this.mType));
      localJSONObject.putOpt("eventID", this.mEventId);
      localJSONObject.putOpt("appPackage", this.mAppPackage);
      localJSONObject.putOpt("eventTime", Long.valueOf(this.mEventTime));
      if (!TextUtils.isEmpty(this.mGlobalId)) {
        localJSONObject.putOpt("globalID", this.mGlobalId);
      }
      if (!TextUtils.isEmpty(this.mTaskID)) {
        localJSONObject.putOpt("taskID", this.mTaskID);
      }
      if (!TextUtils.isEmpty(this.mProperty)) {
        localJSONObject.putOpt("property", this.mProperty);
      }
    }
    catch (Exception localException)
    {
      c.b(localException.getLocalizedMessage());
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.msp.push.mode.MessageStat
 * JD-Core Version:    0.7.0.1
 */