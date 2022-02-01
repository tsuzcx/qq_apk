package com.tencent.biz.qqstory.playvideo.entrance;

import java.io.Serializable;

public class ShareFromMemoryPlayInfo
  implements Serializable
{
  public String collectionKey;
  public String feedId;
  public int identify;
  public int shareFromType = -1;
  public int shareTimeZone;
  public String uid;
  public int videoListOrder;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareFromMemoryPlayInfo{uid='");
    localStringBuilder.append(this.uid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", collectionKey='");
    localStringBuilder.append(this.collectionKey);
    localStringBuilder.append('\'');
    localStringBuilder.append(", shareTimeZone=");
    localStringBuilder.append(this.shareTimeZone);
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", identify=");
    localStringBuilder.append(this.identify);
    localStringBuilder.append(", videoListOrder=");
    localStringBuilder.append(this.videoListOrder);
    localStringBuilder.append(", shareFromType=");
    localStringBuilder.append(this.shareFromType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo
 * JD-Core Version:    0.7.0.1
 */