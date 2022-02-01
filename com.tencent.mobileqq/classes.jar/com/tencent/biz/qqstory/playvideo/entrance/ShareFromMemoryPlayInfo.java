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
    return "ShareFromMemoryPlayInfo{uid='" + this.uid + '\'' + ", collectionKey='" + this.collectionKey + '\'' + ", shareTimeZone=" + this.shareTimeZone + ", feedId='" + this.feedId + '\'' + ", identify=" + this.identify + ", videoListOrder=" + this.videoListOrder + ", shareFromType=" + this.shareFromType + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.entrance.ShareFromMemoryPlayInfo
 * JD-Core Version:    0.7.0.1
 */