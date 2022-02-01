package com.tencent.liteav.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;

public class b
{
  private final SharedPreferences a = TXCCommonUtil.getAppContext().getSharedPreferences("txc_audio_settings", 0);
  
  public static b a()
  {
    return b.a.a();
  }
  
  @SuppressLint({"ApplySharedPref"})
  private void a(String paramString, Object paramObject)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    if ((paramObject instanceof Integer)) {
      localEditor.putInt(paramString, ((Integer)paramObject).intValue());
    } else if ((paramObject instanceof String)) {
      localEditor.putString(paramString, paramObject.toString());
    } else if ((paramObject instanceof Boolean)) {
      localEditor.putBoolean(paramString, ((Boolean)paramObject).booleanValue());
    } else if ((paramObject instanceof Long)) {
      localEditor.putLong(paramString, ((Long)paramObject).longValue());
    } else if ((paramObject instanceof Float)) {
      localEditor.putFloat(paramString, ((Float)paramObject).floatValue());
    } else if ((paramObject instanceof Double)) {
      localEditor.putLong(paramString, Double.doubleToRawLongBits(((Double)paramObject).doubleValue()));
    }
    localEditor.commit();
  }
  
  private Object b(String paramString, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof String)) {
        return this.a.getString(paramString, paramObject.toString());
      }
      if ((paramObject instanceof Integer)) {
        return Integer.valueOf(this.a.getInt(paramString, ((Integer)paramObject).intValue()));
      }
      if ((paramObject instanceof Boolean)) {
        return Boolean.valueOf(this.a.getBoolean(paramString, ((Boolean)paramObject).booleanValue()));
      }
      if ((paramObject instanceof Long)) {
        return Long.valueOf(this.a.getLong(paramString, ((Long)paramObject).longValue()));
      }
      if ((paramObject instanceof Float)) {
        return Float.valueOf(this.a.getFloat(paramString, ((Float)paramObject).floatValue()));
      }
      if ((paramObject instanceof Double))
      {
        double d = Double.longBitsToDouble(this.a.getLong(paramString, Double.doubleToLongBits(((Double)paramObject).doubleValue())));
        return Double.valueOf(d);
      }
      return paramObject;
    }
    catch (Exception localException)
    {
      TXCLog.e("TXCAudioSettings", "get value from sharedpreference failed for key: %s", new Object[] { paramString, localException });
    }
    return paramObject;
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
  }
  
  public long b(String paramString, long paramLong)
  {
    return ((Long)b(paramString, Long.valueOf(paramLong))).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.audio.b
 * JD-Core Version:    0.7.0.1
 */