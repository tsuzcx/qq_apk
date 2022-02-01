package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class VideoUrlEntry
  extends Entity
{
  public String vid;
  public String videoUrl;
  public int videoUrlLevel;
  
  public String toString()
  {
    return "VideoUrlEntry{vid='" + this.vid + '\'' + ", videoUrlLevel=" + this.videoUrlLevel + ", videoUrl='" + this.videoUrl + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.VideoUrlEntry
 * JD-Core Version:    0.7.0.1
 */