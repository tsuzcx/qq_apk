package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.takevideo.tag.CompInfoBase;
import com.tencent.biz.qqstory.takevideo.tag.TagItem.TagInfoBase;

public class GetStoryPlayerTagInfoRequest$TagInfoBaseVidList
{
  public final String a;
  public final TagItem.TagInfoBase b;
  public final CompInfoBase c;
  public final String d;
  
  public GetStoryPlayerTagInfoRequest$TagInfoBaseVidList(String paramString1, TagItem.TagInfoBase paramTagInfoBase, CompInfoBase paramCompInfoBase, String paramString2)
  {
    this.a = paramString1;
    this.b = paramTagInfoBase;
    this.c = paramCompInfoBase;
    this.d = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TagInfoBaseVidList{vid='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", tagInfo=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", comInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", extCfgInfo=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetStoryPlayerTagInfoRequest.TagInfoBaseVidList
 * JD-Core Version:    0.7.0.1
 */