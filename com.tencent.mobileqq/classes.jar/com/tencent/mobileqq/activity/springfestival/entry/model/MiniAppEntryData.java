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
    boolean bool = true;
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
    if (paramJSONObject.optInt("ShowFirework", 0) == 1) {}
    for (;;)
    {
      this.isShowFireWork = bool;
      this.fireWorkPlayCount = paramJSONObject.optInt("FireworkPlayCount", this.fireWorkPlayCount);
      this.fireworkImgUrl = paramJSONObject.optString("FireworkImgUrl", this.fireworkImgUrl);
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "MiniAppEntryData{bgUrl='" + this.bgUrl + '\'' + ", contentBgUrl='" + this.contentBgUrl + '\'' + ", headImgUrl='" + this.headImgUrl + '\'' + ", preWording='" + this.preWording + '\'' + ", endWording='" + this.endWording + '\'' + ", jumpUrl='" + this.jumpUrl + '\'' + ", nextLogoUrl='" + this.nextLogoUrl + '\'' + ", leftBubbleUrl='" + this.leftBubbleUrl + '\'' + ", rightBubbleUrl='" + this.rightBubbleUrl + '\'' + ", leftBubbleJumpUrl='" + this.leftBubbleJumpUrl + '\'' + ", rightBubbleJumpUrl='" + this.rightBubbleJumpUrl + '\'' + ", entryStyle=" + this.entryStyle + ", isShowFireWork=" + this.isShowFireWork + ", fireWorkPlayCount=" + this.fireWorkPlayCount + ", fireworkImgUrl=" + this.fireworkImgUrl + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.model.MiniAppEntryData
 * JD-Core Version:    0.7.0.1
 */