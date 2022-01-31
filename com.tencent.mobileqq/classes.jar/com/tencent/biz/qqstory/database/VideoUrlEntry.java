package com.tencent.biz.qqstory.database;

import atmo;

public class VideoUrlEntry
  extends atmo
{
  public String vid;
  public String videoUrl;
  public int videoUrlLevel;
  
  public String toString()
  {
    return "VideoUrlEntry{vid='" + this.vid + '\'' + ", videoUrlLevel=" + this.videoUrlLevel + ", videoUrl='" + this.videoUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.VideoUrlEntry
 * JD-Core Version:    0.7.0.1
 */