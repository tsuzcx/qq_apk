package com.tencent.mobileqq.avatar.cache.memory.avatar;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.avatar.cache.memory.MemoryCache;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class LruLimitTimeAvatarMemoryCache
  implements MemoryCache<Bitmap>
{
  private static long jdField_a_of_type_Long = 86400000L;
  private MQLruCache<String, Object> jdField_a_of_type_AndroidSupportV4UtilMQLruCache = GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
  private ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(4);
  
  public Bitmap a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      Bitmap localBitmap2 = (Bitmap)this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
        {
          localBitmap1 = localBitmap2;
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
          {
            long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.", 2, "getAvatar from cache, key: " + paramString + " value: " + localBitmap1);
      }
      return localBitmap1;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null) {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    return a(paramString, paramBitmap, (byte)2);
  }
  
  public boolean a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache != null)
    {
      this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString, paramBitmap, paramByte);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.cache.memory.avatar.LruLimitTimeAvatarMemoryCache
 * JD-Core Version:    0.7.0.1
 */