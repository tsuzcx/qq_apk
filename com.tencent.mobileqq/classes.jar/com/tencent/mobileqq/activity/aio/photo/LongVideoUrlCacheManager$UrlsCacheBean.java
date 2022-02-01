package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.QLog;

public class LongVideoUrlCacheManager$UrlsCacheBean
{
  public String[] a;
  public long b;
  public MessageForShortVideo c;
  public int d;
  String e;
  
  public LongVideoUrlCacheManager$UrlsCacheBean(LongVideoUrlCacheManager paramLongVideoUrlCacheManager, String[] paramArrayOfString, long paramLong, MessageForShortVideo paramMessageForShortVideo, int paramInt, String paramString)
  {
    this.a = paramArrayOfString;
    this.b = paramLong;
    this.c = paramMessageForShortVideo;
    this.d = paramInt;
    this.e = paramString;
  }
  
  public boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.b;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UrlsCacheBean, now=  ");
      localStringBuilder.append(l1);
      localStringBuilder.append(", mGetTime");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" diff=");
      localStringBuilder.append(l2);
      localStringBuilder.append(" urlTimeValidDiff=");
      localStringBuilder.append(LongVideoUrlCacheManager.c());
      QLog.d(" LongVideoUrlCacheManager", 2, localStringBuilder.toString());
    }
    return l2 < LongVideoUrlCacheManager.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.LongVideoUrlCacheManager.UrlsCacheBean
 * JD-Core Version:    0.7.0.1
 */