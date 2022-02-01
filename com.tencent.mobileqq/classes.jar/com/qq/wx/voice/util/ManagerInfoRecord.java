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
    if (("wifi" != paramString) || (paramBoolean)) {}
    try
    {
      int i = this.b.getInt("wifi_success", 0);
      this.a.putInt("wifi_success", i + 1);
      this.a.commit();
      break label453;
      i = this.b.getInt("wifi_fail", 0);
      this.a.putInt("wifi_fail", i + 1);
      this.a.commit();
      break label453;
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
      label453:
      i = this.b.getInt("count", 0);
      this.a.putInt("count", i + 1);
      this.a.commit();
      return;
    }
    finally {}
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
    if (("wifi" != paramString) || (paramBoolean)) {}
    try
    {
      i = this.b.getInt("wifi_success", 0);
      return i;
    }
    finally {}
    int i = this.b.getInt("wifi_fail", 0);
    return i;
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
    i = this.b.getInt("other_fail", 0);
    return i;
  }
  
  public String getRecordStr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("&2g_fail=");
    localStringBuilder.append(get(false, "2g"));
    localStringBuilder.append("&2g_success=");
    localStringBuilder.append(get(true, "2g"));
    localStringBuilder.append("&ct3g_fail=");
    localStringBuilder.append(get(false, "ct3g"));
    localStringBuilder.append("&ct3g_success=");
    localStringBuilder.append(get(true, "ct3g"));
    localStringBuilder.append("&cu3g_fail=");
    localStringBuilder.append(get(false, "cu3g"));
    localStringBuilder.append("&cu3g_success=");
    localStringBuilder.append(get(true, "cu3g"));
    localStringBuilder.append("&other_fail=");
    localStringBuilder.append(get(false, "other"));
    localStringBuilder.append("&other_success=");
    localStringBuilder.append(get(true, "other"));
    localStringBuilder.append("&wifi_fail=");
    localStringBuilder.append(get(false, "wifi"));
    localStringBuilder.append("&wifi_success=");
    localStringBuilder.append(get(true, "wifi"));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.wx.voice.util.ManagerInfoRecord
 * JD-Core Version:    0.7.0.1
 */