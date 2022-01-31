package com.tencent.mobileqq.activity.richmedia.p2veffect.model;

public class MediaItem
  implements Cloneable
{
  public static final int TYPE_IMAGE = 2;
  public static final int TYPE_VIDEO = 1;
  private long end;
  private int height;
  private String path;
  private int rotation;
  private long start;
  private int type;
  private int width;
  
  public MediaItem(String paramString, int paramInt, long paramLong1, long paramLong2)
  {
    this.path = paramString;
    this.type = paramInt;
    this.start = paramLong1;
    this.end = paramLong2;
  }
  
  public MediaItem(String paramString, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    this.path = paramString;
    this.type = paramInt1;
    this.start = paramLong1;
    this.end = paramLong2;
    this.width = paramInt2;
    this.height = paramInt3;
    this.rotation = paramInt4;
  }
  
  public MediaItem clone()
  {
    try
    {
      MediaItem localMediaItem = (MediaItem)super.clone();
      return localMediaItem;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public long getDuration()
  {
    return this.end - this.start;
  }
  
  public long getEnd()
  {
    return this.end;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public int getRotation()
  {
    return this.rotation;
  }
  
  public long getStart()
  {
    return this.start;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public void setDimen(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setEnd(long paramLong)
  {
    this.end = paramLong;
  }
  
  public void setRotation(int paramInt)
  {
    this.rotation = paramInt;
    if ((paramInt == 90) || (paramInt == 270))
    {
      paramInt = this.width;
      this.width = this.height;
      this.height = paramInt;
    }
  }
  
  public void setStart(long paramLong)
  {
    this.start = paramLong;
  }
  
  public String toString()
  {
    return "[" + this.start + ", " + this.end + ", " + this.path + "], duration = " + (this.end - this.start);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.model.MediaItem
 * JD-Core Version:    0.7.0.1
 */