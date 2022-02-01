package com.tencent.ad.tangram.device;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import org.json.JSONObject;

public final class h$a
{
  public volatile String a_i_h;
  public volatile String d_i_0_h;
  public volatile String d_i_1_h;
  public volatile String d_i_h;
  public volatile String i_0_h;
  public volatile String i_1_h;
  public volatile String i_h;
  public volatile String m_0_h;
  public volatile String m_1_h;
  public volatile String m_h;
  public volatile String s_i_h;
  
  public static a fromString(String paramString)
  {
    try
    {
      paramString = (a)a.class.cast(AdJSON.toObject(new JSONObject(paramString), a.class));
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdDeviceInfoCache", "fromString", paramString);
    }
    return null;
  }
  
  public boolean fill(a parama)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (parama == null) {}
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
        if (!TextUtils.isEmpty(parama.d_i_h))
        {
          bool1 = bool2;
          if (!TextUtils.equals(this.d_i_h, parama.d_i_h))
          {
            this.d_i_h = parama.d_i_h;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty(parama.d_i_0_h))
        {
          bool2 = bool1;
          if (!TextUtils.equals(this.d_i_0_h, parama.d_i_0_h))
          {
            this.d_i_0_h = parama.d_i_0_h;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(parama.d_i_1_h))
        {
          bool1 = bool2;
          if (!TextUtils.equals(this.d_i_1_h, parama.d_i_1_h))
          {
            this.d_i_1_h = parama.d_i_1_h;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty(parama.i_h))
        {
          bool2 = bool1;
          if (!TextUtils.equals(this.i_h, parama.i_h))
          {
            this.i_h = parama.i_h;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(parama.i_0_h))
        {
          bool1 = bool2;
          if (!TextUtils.equals(this.i_0_h, parama.i_0_h))
          {
            this.i_0_h = parama.i_0_h;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty(parama.i_1_h))
        {
          bool2 = bool1;
          if (!TextUtils.equals(this.i_1_h, parama.i_1_h))
          {
            this.i_1_h = parama.i_1_h;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(parama.m_h))
        {
          bool1 = bool2;
          if (!TextUtils.equals(this.m_h, parama.m_h))
          {
            this.m_h = parama.m_h;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty(parama.m_0_h))
        {
          bool2 = bool1;
          if (!TextUtils.equals(this.m_0_h, parama.m_0_h))
          {
            this.m_0_h = parama.m_0_h;
            bool2 = true;
          }
        }
        bool1 = bool2;
        if (!TextUtils.isEmpty(parama.m_1_h))
        {
          bool1 = bool2;
          if (!TextUtils.equals(this.m_1_h, parama.m_1_h))
          {
            this.m_1_h = parama.m_1_h;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (!TextUtils.isEmpty(parama.a_i_h))
        {
          bool2 = bool1;
          if (!TextUtils.equals(this.a_i_h, parama.a_i_h))
          {
            this.a_i_h = parama.a_i_h;
            bool2 = true;
          }
        }
        bool1 = bool2;
      } while (TextUtils.isEmpty(parama.s_i_h));
      bool1 = bool2;
    } while (TextUtils.equals(this.s_i_h, parama.s_i_h));
    this.s_i_h = parama.s_i_h;
    return true;
  }
  
  public String toString()
  {
    try
    {
      Object localObject = AdJSON.fromObject(this);
      if ((localObject != null) && (!JSONObject.NULL.equals(localObject)) && (((JSONObject)JSONObject.class.cast(localObject)).length() > 0))
      {
        localObject = localObject.toString();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable)
    {
      AdLog.e("AdDeviceInfoCache", "toString", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.device.h.a
 * JD-Core Version:    0.7.0.1
 */