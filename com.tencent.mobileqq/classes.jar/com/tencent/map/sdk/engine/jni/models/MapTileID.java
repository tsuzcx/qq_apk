package com.tencent.map.sdk.engine.jni.models;

import com.tencent.map.sdk.a.qh;

public class MapTileID
{
  private int dataSource;
  private int priority;
  private int tileTag;
  private String url;
  private int x;
  private int y;
  private int z;
  
  public DataSource getDataSource()
  {
    return DataSource.get(this.dataSource);
  }
  
  public qh getPriority()
  {
    return qh.a(this.priority);
  }
  
  public int getTileTag()
  {
    return this.tileTag;
  }
  
  public String getUrl()
  {
    return this.url;
  }
  
  public int getX()
  {
    return this.x;
  }
  
  public int getY()
  {
    return this.y;
  }
  
  public int getZ()
  {
    return this.z;
  }
  
  public String toString()
  {
    return "MapTileID{x=" + this.x + ", y=" + this.y + ", z=" + this.z + ", url='" + this.url + '\'' + ", priority=" + this.priority + ", dataSource=" + this.dataSource + ", tileTag=" + this.tileTag + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.engine.jni.models.MapTileID
 * JD-Core Version:    0.7.0.1
 */