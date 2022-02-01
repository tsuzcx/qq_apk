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
    Object localObject1 = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
    if (localObject1 != null)
    {
      Object localObject2 = (Bitmap)((MQLruCache)localObject1).get(paramString);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
        localObject1 = localObject2;
        if (localConcurrentHashMap != null)
        {
          localObject1 = localObject2;
          if (localConcurrentHashMap.containsKey(paramString))
          {
            long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
            localObject1 = localObject2;
            if (System.currentTimeMillis() - l > jdField_a_of_type_Long)
            {
              this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
              this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache.remove(paramString);
              localObject1 = null;
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getAvatar from cache, key: ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" value: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("Q.qqhead.", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
    if (localObject != null) {
      ((MQLruCache)localObject).remove(paramString);
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null) {
      ((ConcurrentHashMap)localObject).remove(paramString);
    }
  }
  
  public boolean a(String paramString, Bitmap paramBitmap)
  {
    return a(paramString, paramBitmap, (byte)2);
  }
  
  public boolean a(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    MQLruCache localMQLruCache = this.jdField_a_of_type_AndroidSupportV4UtilMQLruCache;
    if (localMQLruCache != null)
    {
      localMQLruCache.put(paramString, paramBitmap, paramByte);
      paramBitmap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (paramBitmap != null) {
        paramBitmap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.cache.memory.avatar.LruLimitTimeAvatarMemoryCache
 * JD-Core Version:    0.7.0.1
 */