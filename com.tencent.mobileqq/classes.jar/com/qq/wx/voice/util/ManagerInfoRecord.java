package com.qq.wx.voice.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ManagerInfoRecord
{
  private SharedPreferences.Editor a;
  private SharedPreferences b;
  
  public void add(boolean paramBoolean, String paramString)
  {
    if ("wifi" == paramString) {
      if (!paramBoolean) {}
    }
    for (;;)
    {
      try
      {
        i = this.b.getInt("wifi_success", 0);
        this.a.putInt("wifi_success", i + 1);
        this.a.commit();
        i = this.b.getInt("count", 0);
        this.a.putInt("count", i + 1);
        this.a.commit();
        return;
      }
      finally {}
      int i = this.b.getInt("wifi_fail", 0);
      this.a.putInt("wifi_fail", i + 1);
      this.a.commit();
      continue;
      if ("2g" == paramString)
      {
        if (paramBoolean)
        {
          i = this.b.getInt("2g_success", 0);
          this.a.putInt("2g_success", i + 1);
          this.a.commit();
        }
        else
        {
          i = this.b.getInt("2g_fail", 0);
          this.a.putInt("2g_fail", i + 1);
          this.a.commit();
        }
      }
      else if ("ct3g" == paramString)
      {
        if (paramBoolean)
        {
          i = this.b.getInt("ct3g_success", 0);
          this.a.putInt("ct3g_success", i + 1);
          this.a.commit();
        }
        else
        {
          i = this.b.getInt("ct3g_fail", 0);
          this.a.putInt("ct3g_fail", i + 1);
          this.a.commit();
        }
      }
      else if ("cu3g" == paramString)
      {
        if (paramBoolean)
        {
          i = this.b.getInt("cu3g_success", 0);
          this.a.putInt("cu3g_success", i + 1);
          this.a.commit();
        }
        else
        {
          i = this.b.getInt("cu3g_fail", 0);
          this.a.putInt("cu3g_fail", i + 1);
          this.a.commit();
        }
      }
      else if (paramBoolean)
      {
        i = this.b.getInt("other_success", 0);
        this.a.putInt("other_success", i + 1);
        this.a.commit();
      }
      else
      {
        i = this.b.getInt("other_fail", 0);
        this.a.putInt("other_fail", i + 1);
        this.a.commit();
      }
    }
  }
  
  public void clear()
  {
    try
    {
      this.a.clear().commit();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int get(boolean paramBoolean, String paramString)
  {
    if ("wifi" == paramString)
    {
      if (paramBoolean) {}
      try
      {
        i = this.b.getInt("wifi_success", 0);
        return i;
      }
      finally {}
      i = this.b.getInt("wifi_fail", 0);
      return i;
    }
    if ("2g" == paramString)
    {
      if (paramBoolean)
      {
        i = this.b.getInt("2g_success", 0);
        return i;
      }
      i = this.b.getInt("2g_fail", 0);
      return i;
    }
    if ("ct3g" == paramString)
    {
      if (paramBoolean)
      {
        i = this.b.getInt("ct3g_success", 0);
        return i;
      }
      i = this.b.getInt("ct3g_fail", 0);
      return i;
    }
    if ("cu3g" == paramString)
    {
      if (paramBoolean)
      {
        i = this.b.getInt("cu3g_success", 0);
        return i;
      }
      i = this.b.getInt("cu3g_fail", 0);
      return i;
    }
    if (paramBoolean)
    {
      i = this.b.getInt("other_success", 0);
      return i;
    }
    int i = this.b.getInt("other_fail", 0);
    return i;
  }
  
  public String getRecordStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&2g_fail=").append(get(false, "2g")).append("&2g_success=").append(get(true, "2g")).append("&ct3g_fail=").append(get(false, "ct3g")).append("&ct3g_success=").append(get(true, "ct3g")).append("&cu3g_fail=").append(get(false, "cu3g")).append("&cu3g_success=").append(get(true, "cu3g")).append("&other_fail=").append(get(false, "other")).append("&other_success=").append(get(true, "other")).append("&wifi_fail=").append(get(false, "wifi")).append("&wifi_success=").append(get(true, "wifi"));
    return localStringBuilder.toString();
  }
  
  public void init(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("wxvoicesdk", 0);
    this.a = this.b.edit();
  }
  
  public boolean isNeedUpdate()
  {
    try
    {
      return this.b.getInt("count", 0) >= 10;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.qq.wx.voice.util.ManagerInfoRecord
 * JD-Core Version:    0.7.0.1
 */