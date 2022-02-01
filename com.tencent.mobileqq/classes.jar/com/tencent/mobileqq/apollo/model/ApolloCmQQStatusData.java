package com.tencent.mobileqq.apollo.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import com.tencent.mobileqq.apollo.utils.api.IApolloABTestApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class ApolloCmQQStatusData
  implements Serializable, Cloneable
{
  @SerializedName("act_id")
  public int apolloQQAct;
  @SerializedName("bubble_id")
  public int apolloQQBubbleId;
  @SerializedName("pic")
  public String apolloQQPicUrl;
  @SerializedName("id")
  public int apolloQQStatus;
  @SerializedName("ts")
  public long apolloQQTs;
  private HashMap<ApolloCmQQStatusData.From, Integer> bubbleTimeMap;
  private HashMap<ApolloCmQQStatusData.From, Integer> freqMap;
  private boolean shouldRefreshSettings = false;
  private HashMap<ApolloCmQQStatusData.From, Integer> timeIntervalMap;
  private String uin;
  
  public static String getDefaultConfigs()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("timeLimit", 24);
      localJSONObject1.put("freq", 3);
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("bubbleTime", 30);
      localJSONObject2.put("timeLimit", 24);
      localJSONObject2.put("freq", 1);
      localJSONObject1.put("aio", localJSONObject2);
      localJSONObject1.put("drawer", localJSONObject2);
      localJSONObject1.put("card", localJSONObject2);
      return localJSONObject1.toString();
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private SharedPreferences getSp()
  {
    return BaseApplication.getContext().getSharedPreferences("cmQQStatus_".concat(this.uin), 0);
  }
  
  private boolean isQQCmshowStatusDataValid()
  {
    return (this.apolloQQTs != 0L) && (this.apolloQQStatus != 0) && (!TextUtils.isEmpty(this.apolloQQPicUrl)) && (this.apolloQQBubbleId != 0) && (this.apolloQQAct != 0);
  }
  
  private boolean isQQCmshowStatusFreqValid(ApolloCmQQStatusData.From paramFrom)
  {
    HashMap localHashMap = this.freqMap;
    if ((localHashMap != null) && (!localHashMap.isEmpty()))
    {
      if (this.freqMap.containsKey(ApolloCmQQStatusData.From.TOTAL))
      {
        if (((Integer)this.freqMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue() <= 0) {
          return false;
        }
        return (this.freqMap.containsKey(paramFrom)) && (((Integer)this.freqMap.get(paramFrom)).intValue() > 0);
      }
      return false;
    }
    QLog.e("ApolloCmQQStatusData", 1, "showUp freq not initialized!");
    return false;
  }
  
  private boolean isQQCmshowStatusTimeIntervalVaild(ApolloCmQQStatusData.From paramFrom)
  {
    long l = (System.currentTimeMillis() / 1000L - this.apolloQQTs) / 3600L;
    HashMap localHashMap = this.timeIntervalMap;
    boolean bool2 = false;
    if ((localHashMap != null) && (!localHashMap.isEmpty()))
    {
      if ((this.timeIntervalMap.containsKey(ApolloCmQQStatusData.From.TOTAL)) && (this.timeIntervalMap.containsKey(paramFrom)))
      {
        boolean bool1 = bool2;
        if (l <= ((Integer)this.timeIntervalMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue())
        {
          bool1 = bool2;
          if (l <= ((Integer)this.timeIntervalMap.get(paramFrom)).intValue()) {
            bool1 = true;
          }
        }
        return bool1;
      }
      QLog.e("ApolloCmQQStatusData", 1, "timeIntervalMap doesn't contain relative keys!");
      return false;
    }
    QLog.e("ApolloCmQQStatusData", 1, "timeIntervalMap uninitialized!");
    return false;
  }
  
  public static void report(ApolloCmQQStatusData.From paramFrom, ApolloCmQQStatusData.ReportParams paramReportParams)
  {
    if (paramFrom == ApolloCmQQStatusData.From.AIO)
    {
      paramFrom = "aio";
    }
    else if (paramFrom == ApolloCmQQStatusData.From.DRAWER)
    {
      paramFrom = "setting_me";
    }
    else
    {
      if (paramFrom != ApolloCmQQStatusData.From.CARD) {
        break label155;
      }
      paramFrom = "friend_card";
    }
    ((IApolloDtReportHelper)QRoute.api(IApolloDtReportHelper.class)).report(paramFrom, "sprite", "animation_playback", new DtReportParamsBuilder().b(paramReportParams.entry).a(paramReportParams.mode).c(paramReportParams.type).f(Integer.toString(paramReportParams.actionId)).d(paramReportParams.guest).d(paramReportParams.timestamp).e(paramReportParams.personNum).f(paramReportParams.ownerStatus).a(Integer.valueOf(paramReportParams.peerStatus)).c(paramReportParams.peerUin).b(paramReportParams.qqUin).e(paramReportParams.duration).a());
    return;
    label155:
    QLog.e("ApolloCmQQStatusData", 1, "invalid report source");
  }
  
  private void setFreqMapSp(ApolloCmQQStatusData.From paramFrom)
  {
    getSp().edit().putInt(String.valueOf(paramFrom).concat("freq"), ((Integer)this.freqMap.get(paramFrom)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.TOTAL).concat("freq"), ((Integer)this.freqMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue()).apply();
  }
  
  private void setMapSp()
  {
    getSp().edit().putInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("timeLimit"), ((Integer)this.timeIntervalMap.get(ApolloCmQQStatusData.From.DRAWER)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("timeLimit"), ((Integer)this.timeIntervalMap.get(ApolloCmQQStatusData.From.CARD)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("timeLimit"), ((Integer)this.timeIntervalMap.get(ApolloCmQQStatusData.From.AIO)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.TOTAL).concat("timeLimit"), ((Integer)this.timeIntervalMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("freq"), ((Integer)this.freqMap.get(ApolloCmQQStatusData.From.DRAWER)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("freq"), ((Integer)this.freqMap.get(ApolloCmQQStatusData.From.CARD)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("freq"), ((Integer)this.freqMap.get(ApolloCmQQStatusData.From.AIO)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.TOTAL).concat("freq"), ((Integer)this.freqMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("bubbleTime"), ((Integer)this.bubbleTimeMap.get(ApolloCmQQStatusData.From.DRAWER)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("bubbleTime"), ((Integer)this.bubbleTimeMap.get(ApolloCmQQStatusData.From.CARD)).intValue()).putInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("bubbleTime"), ((Integer)this.bubbleTimeMap.get(ApolloCmQQStatusData.From.AIO)).intValue()).apply();
  }
  
  private void setShowUpBubbleTimeLimit(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.bubbleTimeMap == null) {
      this.bubbleTimeMap = new HashMap();
    }
    this.bubbleTimeMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(paramInt1));
    this.bubbleTimeMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(paramInt2));
    this.bubbleTimeMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(paramInt3));
  }
  
  private void setShowUpFreqs(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = this.freqMap;
    if (localHashMap == null)
    {
      QLog.e("ApolloCmQQStatusData", 1, "freqMap not initialized!");
      return;
    }
    localHashMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(paramInt1));
    this.freqMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(paramInt2));
    this.freqMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(paramInt3));
  }
  
  private void setShowUpTimeLimit(int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = this.timeIntervalMap;
    if (localHashMap == null)
    {
      QLog.e("ApolloCmQQStatusData", 1, "timeIntervalMap not initialized!");
      return;
    }
    localHashMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(paramInt1));
    this.timeIntervalMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(paramInt2));
    this.timeIntervalMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(paramInt3));
  }
  
  protected Object clone()
  {
    Object localObject;
    try
    {
      ApolloCmQQStatusData localApolloCmQQStatusData = (ApolloCmQQStatusData)super.clone();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
      localObject = null;
    }
    HashMap localHashMap = this.timeIntervalMap;
    if (localHashMap != null) {
      localObject.timeIntervalMap = ((HashMap)localHashMap.clone());
    }
    localHashMap = this.freqMap;
    if (localHashMap != null) {
      localObject.freqMap = ((HashMap)localHashMap.clone());
    }
    localHashMap = this.bubbleTimeMap;
    if (localHashMap != null) {
      localObject.bubbleTimeMap = ((HashMap)localHashMap.clone());
    }
    return localObject;
  }
  
  public int getShowUpBubbleTime(ApolloCmQQStatusData.From paramFrom)
  {
    HashMap localHashMap = this.bubbleTimeMap;
    if ((localHashMap != null) && (!localHashMap.isEmpty()) && (this.bubbleTimeMap.containsKey(paramFrom))) {
      return ((Integer)this.bubbleTimeMap.get(paramFrom)).intValue();
    }
    QLog.e("ApolloCmQQStatusData", 1, "bubble time not found， return default value");
    return 30;
  }
  
  public void printFreqRemaining()
  {
    QLog.d("ApolloCmQQStatusData", 1, this.freqMap.toString());
  }
  
  public void refreshSettings()
  {
    this.shouldRefreshSettings ^= true;
  }
  
  public void setShowUpParams(String paramString)
  {
    try
    {
      JSONObject localJSONObject2 = new JSONObject(paramString);
      if (this.timeIntervalMap == null) {
        this.timeIntervalMap = new HashMap();
      }
      this.timeIntervalMap.put(ApolloCmQQStatusData.From.TOTAL, Integer.valueOf(localJSONObject2.optInt("timeLimit", 24)));
      if (this.freqMap == null) {
        this.freqMap = new HashMap();
      }
      this.freqMap.put(ApolloCmQQStatusData.From.TOTAL, Integer.valueOf(localJSONObject2.optInt("freq", 3)));
      paramString = localJSONObject2.optJSONObject("aio");
      JSONObject localJSONObject1 = localJSONObject2.optJSONObject("drawer");
      localJSONObject2 = localJSONObject2.optJSONObject("card");
      if ((paramString != null) && (localJSONObject1 != null) && (localJSONObject2 != null))
      {
        setShowUpFreqs(paramString.optInt("freq", 1), localJSONObject1.optInt("freq", 1), localJSONObject2.optInt("freq", 1));
        setShowUpTimeLimit(paramString.optInt("timeLimit", 24), localJSONObject1.optInt("timeLimit", 24), localJSONObject2.optInt("timeLimit", 24));
        setShowUpBubbleTimeLimit(paramString.optInt("bubbleTime", 30), localJSONObject1.optInt("bubbleTime", 30), localJSONObject2.optInt("bubbleTime", 30));
        setMapSp();
        return;
      }
      throw new JSONException("JSONObject branch is null");
    }
    catch (JSONException paramString)
    {
      QLog.e("ApolloCmQQStatusData", 1, paramString, new Object[0]);
    }
  }
  
  public boolean shouldOverWriteSp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.uin = paramString;
    if ((getSp().contains("ts")) && (getSp().getLong("ts", 0L) == this.apolloQQTs))
    {
      if ((this.timeIntervalMap == null) || (this.freqMap == null) || (this.bubbleTimeMap == null))
      {
        this.timeIntervalMap = new HashMap();
        this.freqMap = new HashMap();
        this.bubbleTimeMap = new HashMap();
        this.timeIntervalMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("timeLimit"), 24)));
        this.timeIntervalMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("timeLimit"), 24)));
        this.timeIntervalMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("timeLimit"), 24)));
        this.timeIntervalMap.put(ApolloCmQQStatusData.From.TOTAL, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.TOTAL).concat("timeLimit"), 24)));
        this.freqMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("freq"), 1)));
        this.freqMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("freq"), 1)));
        this.freqMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("freq"), 1)));
        this.freqMap.put(ApolloCmQQStatusData.From.TOTAL, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.TOTAL).concat("freq"), 3)));
        this.bubbleTimeMap.put(ApolloCmQQStatusData.From.DRAWER, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.DRAWER).concat("bubbleTime"), 30)));
        this.bubbleTimeMap.put(ApolloCmQQStatusData.From.CARD, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.CARD).concat("bubbleTime"), 30)));
        this.bubbleTimeMap.put(ApolloCmQQStatusData.From.AIO, Integer.valueOf(getSp().getInt(String.valueOf(ApolloCmQQStatusData.From.AIO).concat("bubbleTime"), 30)));
      }
      refreshSettings();
      return false;
    }
    getSp().edit().putLong("ts", this.apolloQQTs).apply();
    return true;
  }
  
  public boolean shouldRefreshSettings()
  {
    return this.shouldRefreshSettings;
  }
  
  public boolean shouldShowQQCmshowStatusAction(ApolloCmQQStatusData.From paramFrom)
  {
    boolean bool = ((IApolloABTestApi)QRoute.api(IApolloABTestApi.class)).canCmStatusExp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("check shouldShowCmStatus: ");
    localStringBuilder.append(bool);
    QLog.i("ApolloCmQQStatusData", 1, localStringBuilder.toString());
    return (bool) && (isQQCmshowStatusDataValid()) && (isQQCmshowStatusTimeIntervalVaild(paramFrom)) && (isQQCmshowStatusFreqValid(paramFrom));
  }
  
  public void showUpFreqDecrement(ApolloCmQQStatusData.From paramFrom)
  {
    Object localObject = this.freqMap;
    if ((localObject != null) && (!((HashMap)localObject).isEmpty()))
    {
      if (paramFrom == ApolloCmQQStatusData.From.TOTAL)
      {
        QLog.e("ApolloCmQQStatusData", 1, "undefined source");
        return;
      }
      if (((Integer)this.freqMap.get(paramFrom)).intValue() == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramFrom);
          ((StringBuilder)localObject).append(": qqStatus action reaches limit");
          QLog.i("ApolloCmQQStatusData", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
      localObject = this.freqMap;
      ((HashMap)localObject).put(paramFrom, Integer.valueOf(((Integer)((HashMap)localObject).get(paramFrom)).intValue() - 1));
      this.freqMap.put(ApolloCmQQStatusData.From.TOTAL, Integer.valueOf(((Integer)this.freqMap.get(ApolloCmQQStatusData.From.TOTAL)).intValue() - 1));
      setFreqMapSp(paramFrom);
      return;
    }
    QLog.e("ApolloCmQQStatusData", 1, "showUp freq not initialized!");
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloCmQQStatusData{apolloQQStatus=");
    localStringBuilder.append(this.apolloQQStatus);
    localStringBuilder.append(", apolloQQTs=");
    localStringBuilder.append(this.apolloQQTs);
    localStringBuilder.append(", apolloQQAct=");
    localStringBuilder.append(this.apolloQQAct);
    localStringBuilder.append(", apolloQQPicUrl='");
    localStringBuilder.append(this.apolloQQPicUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", apolloQQBubbleId=");
    localStringBuilder.append(this.apolloQQBubbleId);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloCmQQStatusData
 * JD-Core Version:    0.7.0.1
 */