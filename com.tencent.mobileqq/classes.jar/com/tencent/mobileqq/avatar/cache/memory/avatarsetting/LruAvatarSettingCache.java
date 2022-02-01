package com.tencent.mobileqq.avatar.cache.memory.avatarsetting;

import android.text.TextUtils;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.avatar.cache.memory.MemoryCache;
import com.tencent.mobileqq.data.Setting;

public class LruAvatarSettingCache
  implements MemoryCache<Setting>
{
  QQLruCache<String, Setting> a = new QQLruCache(2001, 4000, 60);
  
  public void a()
  {
    QQLruCache localQQLruCache = this.a;
    if (localQQLruCache != null) {
      localQQLruCache.evictAll();
    }
  }
  
  public boolean a(String paramString, Setting paramSetting)
  {
    QQLruCache localQQLruCache = this.a;
    if (localQQLruCache != null)
    {
      localQQLruCache.put(paramString, paramSetting);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, Setting paramSetting, byte paramByte)
  {
    return a(paramString, paramSetting);
  }
  
  public void b(String paramString)
  {
    QQLruCache localQQLruCache = this.a;
    if (localQQLruCache != null) {
      localQQLruCache.remove(paramString);
    }
  }
  
  public Setting c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      QQLruCache localQQLruCache = this.a;
      if (localQQLruCache != null) {
        return (Setting)localQQLruCache.get(paramString);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.cache.memory.avatarsetting.LruAvatarSettingCache
 * JD-Core Version:    0.7.0.1
 */