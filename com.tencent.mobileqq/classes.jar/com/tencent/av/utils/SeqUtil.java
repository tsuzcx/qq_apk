package com.tencent.av.utils;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;

public abstract class SeqUtil
{
  public static long a(Intent paramIntent)
  {
    return paramIntent.getLongExtra("log_seq", 0L);
  }
  
  public static long a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getLong("log_seq");
    }
    return 0L;
  }
  
  public static long a(Object paramObject)
  {
    if ((paramObject instanceof Long)) {
      return ((Long)paramObject).longValue();
    }
    return 0L;
  }
  
  public static long a(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("log_seq"))) {
      return a(paramHashMap.get("log_seq"));
    }
    return 0L;
  }
  
  public static long a(Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfObject.length > paramInt) {
      return a(paramArrayOfObject[paramInt]);
    }
    return 0L;
  }
  
  public static void a(Intent paramIntent, long paramLong)
  {
    paramIntent.putExtra("log_seq", paramLong);
  }
  
  public static void a(Bundle paramBundle, long paramLong)
  {
    paramBundle.putLong("log_seq", paramLong);
  }
  
  public static void a(HashMap<String, Object> paramHashMap, long paramLong)
  {
    paramHashMap.put("log_seq", Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SeqUtil
 * JD-Core Version:    0.7.0.1
 */