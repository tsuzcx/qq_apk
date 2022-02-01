package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class BaseCommentData$CommentLinkData
  implements Serializable
{
  public static final int TYPE_ACTIVITY = 2;
  public static final int TYPE_CONTENT = 3;
  public static final int TYPE_GOODS = 1;
  public static final int TYPE_MINI_APP = 4;
  private static final long serialVersionUID = -5511624060230403921L;
  @SerializedName("icon")
  public String iconUrl;
  @SerializedName("url")
  public String linkUrl;
  @SerializedName("type")
  public int type;
  @SerializedName("wording")
  public String wording;
  
  public BaseCommentData$CommentLinkData() {}
  
  public BaseCommentData$CommentLinkData(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.linkUrl = paramString1;
    this.wording = paramString2;
    this.iconUrl = paramString3;
  }
  
  public String toString()
  {
    return "CommentLinkData{wording='" + this.wording + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", linkUrl='" + this.linkUrl + '\'' + ", type=" + this.type + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.CommentLinkData
 * JD-Core Version:    0.7.0.1
 */