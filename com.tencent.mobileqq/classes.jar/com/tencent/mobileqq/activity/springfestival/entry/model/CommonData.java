package com.tencent.mobileqq.activity.springfestival.entry.model;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class CommonData
  implements Serializable
{
  public static final String TAG = "shua2021_CommonData";
  public int activityState = 0;
  public String activityUrlPrefix = "";
  public int cardStyle = 0;
  public Set<Integer> comboNumberSet = new HashSet();
  public String comboResUrl = "";
  public int forbidRefreshAfterTime = 0;
  public int forbidRefreshBeforeTime = 0;
  public int grabReqInterval = 3000;
  public boolean preventSafetyCheck = false;
  public int reportGrabCntInterval = 180000;
  public List<CommonData.ShareWording> shareGreetList = new ArrayList();
  public List<ZipRes> zipResList = new ArrayList();
  
  public static CommonData newEmpty()
  {
    return new CommonData();
  }
  
  public List<String> getShareWordings(int paramInt)
  {
    Iterator localIterator = this.shareGreetList.iterator();
    CommonData.ShareWording localShareWording;
    for (Object localObject = null; localIterator.hasNext(); localObject = localShareWording)
    {
      localShareWording = (CommonData.ShareWording)localIterator.next();
      if (paramInt < localShareWording.minCount) {
        break;
      }
    }
    if (localObject != null) {
      return localObject.wordings;
    }
    return null;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    int i = paramJSONObject.optInt("GrabReqInterval", this.grabReqInterval);
    if (i > 0) {
      this.grabReqInterval = i;
    }
    this.reportGrabCntInterval = paramJSONObject.optInt("ReportGrabCntInterval", this.grabReqInterval);
    this.forbidRefreshBeforeTime = paramJSONObject.optInt("ForbidRefreshBeforeTime", this.forbidRefreshBeforeTime);
    this.forbidRefreshAfterTime = paramJSONObject.optInt("ForbidRefreshAfterTime", this.forbidRefreshAfterTime);
    this.cardStyle = paramJSONObject.optInt("CardStyle", this.cardStyle);
    this.activityState = paramJSONObject.optInt("ActivityState", this.activityState);
    int k = 0;
    i = paramJSONObject.optInt("PreventSafetyCheck", 0);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.preventSafetyCheck = bool;
    this.activityUrlPrefix = paramJSONObject.optString("ActivityUrlPrefix", this.activityUrlPrefix);
    this.comboResUrl = paramJSONObject.optString("ComboNumberImgUrls", this.comboResUrl);
    Object localObject1 = paramJSONObject.optJSONArray("ComboNumberList");
    int j;
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        j = ((JSONArray)localObject1).optInt(i, 0);
        if (j != 0) {
          this.comboNumberSet.add(Integer.valueOf(j));
        }
        i += 1;
      }
    }
    localObject1 = paramJSONObject.optJSONArray("ShareGreetList");
    Object localObject2;
    if (localObject1 != null)
    {
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null)
        {
          j = ((JSONObject)localObject2).optInt("MinCount", -1);
          localObject2 = ((JSONObject)localObject2).optJSONArray("WordingList");
          if ((j >= 0) && (localObject2 != null) && (((JSONArray)localObject2).length() > 0))
          {
            CommonData.ShareWording localShareWording = new CommonData.ShareWording(this);
            localShareWording.minCount = j;
            this.shareGreetList.add(localShareWording);
            j = 0;
            while (j < ((JSONArray)localObject2).length())
            {
              String str = ((JSONArray)localObject2).optString(j, "");
              if (!TextUtils.isEmpty(str)) {
                localShareWording.wordings.add(str);
              }
              j += 1;
            }
          }
        }
        i += 1;
      }
    }
    Collections.sort(this.shareGreetList, new CommonData.1(this));
    paramJSONObject = paramJSONObject.optJSONArray("ResList");
    if (paramJSONObject != null)
    {
      i = k;
      while (i < paramJSONObject.length())
      {
        localObject1 = paramJSONObject.optJSONObject(i);
        if (localObject1 != null)
        {
          localObject2 = new ZipRes();
          ((ZipRes)localObject2).parseJson((JSONObject)localObject1);
          this.zipResList.add(localObject2);
        }
        i += 1;
      }
    }
  }
  
  public String toSimpleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonData{grabReqInterval=");
    localStringBuilder.append(this.grabReqInterval);
    localStringBuilder.append(", reportGrabCntInterval=");
    localStringBuilder.append(this.reportGrabCntInterval);
    localStringBuilder.append(", forbidRefreshBeforeTime=");
    localStringBuilder.append(this.forbidRefreshBeforeTime);
    localStringBuilder.append(", forbidRefreshAfterTime=");
    localStringBuilder.append(this.forbidRefreshAfterTime);
    localStringBuilder.append(", cardStyle=");
    localStringBuilder.append(this.cardStyle);
    localStringBuilder.append(", preventSafetyCheck=");
    localStringBuilder.append(this.preventSafetyCheck);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CommonData{grabReqInterval=");
    localStringBuilder.append(this.grabReqInterval);
    localStringBuilder.append(", reportGrabCntInterval=");
    localStringBuilder.append(this.reportGrabCntInterval);
    localStringBuilder.append(", forbidRefreshBeforeTime=");
    localStringBuilder.append(this.forbidRefreshBeforeTime);
    localStringBuilder.append(", forbidRefreshAfterTime=");
    localStringBuilder.append(this.forbidRefreshAfterTime);
    localStringBuilder.append(", cardStyle=");
    localStringBuilder.append(this.cardStyle);
    localStringBuilder.append(", activityState=");
    localStringBuilder.append(this.activityState);
    localStringBuilder.append(", preventSafetyCheck=");
    localStringBuilder.append(this.preventSafetyCheck);
    localStringBuilder.append(", activityUrlPrefix=");
    localStringBuilder.append(this.activityUrlPrefix);
    localStringBuilder.append(", comboNumberSet=");
    localStringBuilder.append(this.comboNumberSet);
    localStringBuilder.append(", comboResUrl='");
    localStringBuilder.append(this.comboResUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", zipResList=");
    localStringBuilder.append(this.zipResList);
    localStringBuilder.append(", shareGreetList=");
    localStringBuilder.append(this.shareGreetList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.CommonData
 * JD-Core Version:    0.7.0.1
 */