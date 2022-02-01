package com.tencent.biz.pubaccount.readinjoy.config.beans;

import com.tencent.aladdin.config.parse.AladdinConfigBean;
import java.util.HashMap;
import java.util.Map;

public class SneakyParams
  implements AladdinConfigBean
{
  private String actionName = "";
  private String activityClassName = "";
  private String backupActivityUri = "";
  private int baseDelayMs = 10000;
  private int debounceIntervalMinutes = 60;
  private boolean enable = false;
  private int maximumWakeUpTimes = 3;
  private Map<String, OccasionRule> occasionTypeRulesMap = new HashMap();
  private String packageName = "";
  private Map<String, String> params = new HashMap();
  private int randomDelayUpperBoundMs = 10000;
  private String receiverClassName = "";
  private String serviceClassName = "";
  private String targetProcessName = "";
  private int wakeOccasion = 2;
  private String wakeType = "";
  
  public String getActionName()
  {
    return this.actionName;
  }
  
  public String getActivityClassName()
  {
    return this.activityClassName;
  }
  
  public String getBackupActivityUri()
  {
    return this.backupActivityUri;
  }
  
  public int getBaseDelayMs(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getBaseDelayMs();
    }
    return this.baseDelayMs;
  }
  
  public int getDebounceIntervalMinutes(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getDebounceIntervalMinutes();
    }
    return this.debounceIntervalMinutes;
  }
  
  public int getMaximumWakeUpTimes(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getMaximumWakeUpTimes();
    }
    return this.maximumWakeUpTimes;
  }
  
  public String getPackageName()
  {
    return this.packageName;
  }
  
  public Map<String, String> getParams()
  {
    return this.params;
  }
  
  public int getRandomDelayUpperBoundMs(int paramInt)
  {
    OccasionRule localOccasionRule = (OccasionRule)this.occasionTypeRulesMap.get(String.valueOf(paramInt));
    if (localOccasionRule != null) {
      return localOccasionRule.getRandomDelayUpperBound();
    }
    return this.randomDelayUpperBoundMs;
  }
  
  public String getReceiverClassName()
  {
    return this.receiverClassName;
  }
  
  public String getServiceClassName()
  {
    return this.serviceClassName;
  }
  
  public String getTargetProcessName()
  {
    return this.targetProcessName;
  }
  
  public int getWakeOccasion()
  {
    return this.wakeOccasion;
  }
  
  public String getWakeType()
  {
    return this.wakeType;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public String toString()
  {
    return "SneakyParams{enable=" + this.enable + ", wakeType='" + this.wakeType + '\'' + ", serviceClassName='" + this.serviceClassName + '\'' + ", activityClassName='" + this.activityClassName + '\'' + ", receiverClassName='" + this.receiverClassName + '\'' + ", targetProcessName='" + this.targetProcessName + '\'' + ", actionName='" + this.actionName + '\'' + ", packageName='" + this.packageName + '\'' + ", backupActivityUri='" + this.backupActivityUri + '\'' + ", wakeOccasion=" + this.wakeOccasion + ", baseDelayMs=" + this.baseDelayMs + ", debounceIntervalMinutes=" + this.debounceIntervalMinutes + ", maximumWakeUpTimes=" + this.maximumWakeUpTimes + ", randomDelayUpperBoundMs=" + this.randomDelayUpperBoundMs + ", params=" + this.params + ", occasionTypeRulesMap=" + this.occasionTypeRulesMap + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.beans.SneakyParams
 * JD-Core Version:    0.7.0.1
 */