package com.tencent.mobileqq.avatar.cache.memory.avatarsetting;

import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.avatar.cache.memory.MemoryCache;
import com.tencent.mobileqq.data.Setting;

public class LruAvatarSettingCache
  implements MemoryCache<Setting>
{
  QQLruCache<String, Setting> a = new QQLruCache(2001, 4000, 60);
  
  public Setting a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.a == null)) {
      return null;
    }
    return (Setting)this.a.get(paramString);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.evictAll();
    }
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.remove(paramString);
    }
  }
  
  public boolean a(String paramString, Setting paramSetting)
  {
    if (this.a != null)
    {
      this.a.put(paramString, paramSetting);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, Setting paramSetting, byte paramByte)
  {
    return a(paramString, paramSetting);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.cache.memory.avatarsetting.LruAvatarSettingCache
 * JD-Core Version:    0.7.0.1
 */