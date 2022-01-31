package com.tencent.apkupdate.logic.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class RatingInfo
  extends JceStruct
{
  static Map cache_ratingDistribution;
  public double averageRating = 0.0D;
  public long ratingCount = 0L;
  public Map ratingDistribution = null;
  
  public final void readFrom(JceInputStream paramJceInputStream)
  {
    this.ratingCount = paramJceInputStream.read(this.ratingCount, 0, true);
    this.averageRating = paramJceInputStream.read(this.averageRating, 1, true);
    if (cache_ratingDistribution == null)
    {
      cache_ratingDistribution = new HashMap();
      cache_ratingDistribution.put(Integer.valueOf(0), Long.valueOf(0L));
    }
    this.ratingDistribution = ((Map)paramJceInputStream.read(cache_ratingDistribution, 2, true));
  }
  
  public final void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ratingCount, 0);
    paramJceOutputStream.write(this.averageRating, 1);
    paramJceOutputStream.write(this.ratingDistribution, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.apkupdate.logic.protocol.jce.RatingInfo
 * JD-Core Version:    0.7.0.1
 */