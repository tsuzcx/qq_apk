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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoUrlEntry{vid='");
    localStringBuilder.append(this.vid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrlLevel=");
    localStringBuilder.append(this.videoUrlLevel);
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.videoUrl);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.VideoUrlEntry
 * JD-Core Version:    0.7.0.1
 */