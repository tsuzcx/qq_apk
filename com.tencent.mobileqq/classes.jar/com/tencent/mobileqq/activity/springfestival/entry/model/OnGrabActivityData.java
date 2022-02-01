package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

public class OnGrabActivityData
  extends BaseActivityData
{
  public static final String TAG = "shua2021_OnGrabActivityData";
  public List<OnGrabActivityData.Award> awardList = new ArrayList();
  public String bgUrl = "";
  public String grabWording = "";
  public String leftCloudImgUrl = "";
  public String logoImgUrl = "";
  public MiniAppEntryData miniAppEntryData = new MiniAppEntryData();
  public String nameImgUrl = "";
  public String noRPWording = "";
  public int playDuration = 30;
  public PreviewEntryData previewEntryData = new PreviewEntryData();
  public String rightCloudImgUrl = "";
  public OnGrabActivityData.Share shareData = new OnGrabActivityData.Share(this);
  public String tipBarWording = "";
  
  @NotNull
  public MiniAppEntryData getMiniEntryData()
  {
    return this.miniAppEntryData;
  }
  
  public int getTaskAboutToOverDuration()
  {
    return this.playDuration;
  }
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    super.parseJson(paramJSONObject);
    paramJSONObject = paramJSONObject.optJSONObject("GrabActivity");
    if (paramJSONObject != null)
    {
      this.playDuration = paramJSONObject.optInt("PlayDuration", this.playDuration);
      this.tipBarWording = paramJSONObject.optString("TipBarWording", this.tipBarWording);
      this.grabWording = paramJSONObject.optString("GrabWording", this.grabWording);
      this.noRPWording = paramJSONObject.optString("NoRPWording", this.noRPWording);
      this.logoImgUrl = paramJSONObject.optString("LogoImgUrl", this.logoImgUrl);
      this.nameImgUrl = paramJSONObject.optString("NameImgUrl", this.nameImgUrl);
      this.bgUrl = paramJSONObject.optString("BgUrl", this.bgUrl);
      this.leftCloudImgUrl = paramJSONObject.optString("LeftCloudImgUrl", this.leftCloudImgUrl);
      this.rightCloudImgUrl = paramJSONObject.optString("RightCloudImgUrl", this.rightCloudImgUrl);
      Object localObject = paramJSONObject.optJSONArray("AwardList");
      if (localObject != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
          if (localJSONObject != null)
          {
            OnGrabActivityData.Award localAward = new OnGrabActivityData.Award(this);
            localAward.parseJson(localJSONObject);
            this.awardList.add(localAward);
          }
          i += 1;
        }
      }
      localObject = paramJSONObject.optJSONObject("Share");
      this.shareData.parseJson((JSONObject)localObject);
      localObject = paramJSONObject.optJSONObject("PreviewEntry");
      this.previewEntryData.parseJson((JSONObject)localObject);
      paramJSONObject = paramJSONObject.optJSONObject("MiniAppEntry");
      this.miniAppEntryData.parseJson(paramJSONObject);
    }
  }
  
  public boolean schedulePendantNBreathLight()
  {
    return false;
  }
  
  public boolean scheduleTaskAfterPeak()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnGrabActivityData{superData=");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", playDuration=");
    localStringBuilder.append(this.playDuration);
    localStringBuilder.append(", tipBarWording='");
    localStringBuilder.append(this.tipBarWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", grabWording='");
    localStringBuilder.append(this.grabWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", noRPWording='");
    localStringBuilder.append(this.noRPWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", logoImgUrl='");
    localStringBuilder.append(this.logoImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nameImgUrl='");
    localStringBuilder.append(this.nameImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bgUrl='");
    localStringBuilder.append(this.bgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftCloudImgUrl='");
    localStringBuilder.append(this.leftCloudImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rightCloudImgUrl='");
    localStringBuilder.append(this.rightCloudImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", awardList=");
    localStringBuilder.append(Arrays.toString(this.awardList.toArray()));
    localStringBuilder.append(", shareData=");
    localStringBuilder.append(this.shareData);
    localStringBuilder.append(", previewEntryData=");
    localStringBuilder.append(this.previewEntryData);
    localStringBuilder.append(", miniAppEntryData=");
    localStringBuilder.append(this.miniAppEntryData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.OnGrabActivityData
 * JD-Core Version:    0.7.0.1
 */