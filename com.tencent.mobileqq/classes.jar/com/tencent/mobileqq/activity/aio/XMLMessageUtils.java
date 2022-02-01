package com.tencent.mobileqq.activity.aio;

import android.support.v4.util.LruCache;
import com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;

public class XMLMessageUtils
{
  public static LruCache<String, PAMessage> a = new LruCache(50);
  
  public static PAMessage a(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.frienduin, paramMessageRecord.shmsgseq, paramMessageRecord.msgUid, paramMessageRecord.msgData);
  }
  
  public static PAMessage a(String paramString, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    String str = a(paramString, paramLong1, paramLong2);
    PAMessage localPAMessage = (PAMessage)a.get(str);
    paramString = localPAMessage;
    if (localPAMessage == null) {}
    try
    {
      paramArrayOfByte = (PAMessage)((IPublicAccountMessageUtil)QRoute.api(IPublicAccountMessageUtil.class)).fromByteArray(paramArrayOfByte);
      paramString = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        break label73;
      }
      a.put(str, paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Exception paramString)
    {
      label71:
      break label71;
    }
    return null;
    label73:
    return paramString;
  }
  
  private static String a(String paramString, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("&");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("&");
    localStringBuilder.append(paramLong2);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.XMLMessageUtils
 * JD-Core Version:    0.7.0.1
 */