package com.tencent.mobileqq.activity.springfestival.entry.model;

import java.io.Serializable;
import org.json.JSONObject;

public class MiniAppEntryData
  implements Serializable
{
  public static final String TAG = "shua2021_MiniAppEntryItemData";
  public String bgUrl = "";
  public String contentBgUrl = "";
  public String endWording = "";
  public int entryStyle = -1;
  public int fireWorkPlayCount = 0;
  public String fireworkImgUrl = "";
  public String headImgUrl = "";
  public boolean isShowFireWork = false;
  public String jumpUrl = "";
  public String leftBubbleJumpUrl = "";
  public String leftBubbleUrl = "";
  public String nextLogoUrl = "";
  public String preWording = "";
  public String rightBubbleJumpUrl = "";
  public String rightBubbleUrl = "";
  
  public void parseJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.bgUrl = paramJSONObject.optString("BgUrl", this.bgUrl);
    this.contentBgUrl = paramJSONObject.optString("ContentBgUrl", this.contentBgUrl);
    this.headImgUrl = paramJSONObject.optString("HeadImgUrl", this.headImgUrl);
    this.preWording = paramJSONObject.optString("PreWording", this.preWording);
    this.endWording = paramJSONObject.optString("EndWording", this.endWording);
    this.jumpUrl = paramJSONObject.optString("JumpUrl", this.jumpUrl);
    this.nextLogoUrl = paramJSONObject.optString("NextLogoUrl", this.nextLogoUrl);
    this.leftBubbleUrl = paramJSONObject.optString("LeftBubbleUrl", this.leftBubbleUrl);
    this.rightBubbleUrl = paramJSONObject.optString("RightBubbleUrl", this.rightBubbleUrl);
    this.leftBubbleJumpUrl = paramJSONObject.optString("LeftBubbleJumpUrl", this.leftBubbleJumpUrl);
    this.rightBubbleJumpUrl = paramJSONObject.optString("RightBubbleJumpUrl", this.rightBubbleJumpUrl);
    this.entryStyle = paramJSONObject.optInt("EntryStyle", this.entryStyle);
    boolean bool = false;
    if (paramJSONObject.optInt("ShowFirework", 0) == 1) {
      bool = true;
    }
    this.isShowFireWork = bool;
    this.fireWorkPlayCount = paramJSONObject.optInt("FireworkPlayCount", this.fireWorkPlayCount);
    this.fireworkImgUrl = paramJSONObject.optString("FireworkImgUrl", this.fireworkImgUrl);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MiniAppEntryData{bgUrl='");
    localStringBuilder.append(this.bgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", contentBgUrl='");
    localStringBuilder.append(this.contentBgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", headImgUrl='");
    localStringBuilder.append(this.headImgUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", preWording='");
    localStringBuilder.append(this.preWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", endWording='");
    localStringBuilder.append(this.endWording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", jumpUrl='");
    localStringBuilder.append(this.jumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", nextLogoUrl='");
    localStringBuilder.append(this.nextLogoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftBubbleUrl='");
    localStringBuilder.append(this.leftBubbleUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rightBubbleUrl='");
    localStringBuilder.append(this.rightBubbleUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", leftBubbleJumpUrl='");
    localStringBuilder.append(this.leftBubbleJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", rightBubbleJumpUrl='");
    localStringBuilder.append(this.rightBubbleJumpUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryStyle=");
    localStringBuilder.append(this.entryStyle);
    localStringBuilder.append(", isShowFireWork=");
    localStringBuilder.append(this.isShowFireWork);
    localStringBuilder.append(", fireWorkPlayCount=");
    localStringBuilder.append(this.fireWorkPlayCount);
    localStringBuilder.append(", fireworkImgUrl=");
    localStringBuilder.append(this.fireworkImgUrl);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.MiniAppEntryData
 * JD-Core Version:    0.7.0.1
 */