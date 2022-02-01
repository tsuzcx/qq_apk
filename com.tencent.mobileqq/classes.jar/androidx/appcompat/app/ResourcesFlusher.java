package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

class ResourcesFlusher
{
  private static final String TAG = "ResourcesFlusher";
  private static Field sDrawableCacheField;
  private static boolean sDrawableCacheFieldFetched;
  private static Field sResourcesImplField;
  private static boolean sResourcesImplFieldFetched;
  private static Class<?> sThemedResourceCacheClazz;
  private static boolean sThemedResourceCacheClazzFetched;
  private static Field sThemedResourceCache_mUnthemedEntriesField;
  private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;
  
  static void flush(@NonNull Resources paramResources)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      flushNougats(paramResources);
      return;
    }
    if (Build.VERSION.SDK_INT >= 23)
    {
      flushMarshmallows(paramResources);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21) {
      flushLollipops(paramResources);
    }
  }
  
  @RequiresApi(21)
  private static void flushLollipops(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField = sDrawableCacheField;
    if (localField != null)
    {
      try
      {
        paramResources = (Map)localField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        paramResources = null;
      }
      if (paramResources != null) {
        paramResources.clear();
      }
    }
  }
  
  @RequiresApi(23)
  private static void flushMarshmallows(@NonNull Resources paramResources)
  {
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = Resources.class.getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", localNoSuchFieldException);
      }
      sDrawableCacheFieldFetched = true;
    }
    Object localObject2 = null;
    Field localField = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField != null) {
      try
      {
        localObject1 = localField.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    if (localObject1 == null) {
      return;
    }
    flushThemedResourcesCache(localObject1);
  }
  
  @RequiresApi(24)
  private static void flushNougats(@NonNull Resources paramResources)
  {
    if (!sResourcesImplFieldFetched)
    {
      try
      {
        sResourcesImplField = Resources.class.getDeclaredField("mResourcesImpl");
        sResourcesImplField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException1)
      {
        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", localNoSuchFieldException1);
      }
      sResourcesImplFieldFetched = true;
    }
    Field localField1 = sResourcesImplField;
    if (localField1 == null) {
      return;
    }
    Object localObject2 = null;
    try
    {
      paramResources = localField1.get(paramResources);
    }
    catch (IllegalAccessException paramResources)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", paramResources);
      paramResources = null;
    }
    if (paramResources == null) {
      return;
    }
    if (!sDrawableCacheFieldFetched)
    {
      try
      {
        sDrawableCacheField = paramResources.getClass().getDeclaredField("mDrawableCache");
        sDrawableCacheField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException2)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", localNoSuchFieldException2);
      }
      sDrawableCacheFieldFetched = true;
    }
    Field localField2 = sDrawableCacheField;
    Object localObject1 = localObject2;
    if (localField2 != null) {
      try
      {
        localObject1 = localField2.get(paramResources);
      }
      catch (IllegalAccessException paramResources)
      {
        Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", paramResources);
        localObject1 = localObject2;
      }
    }
    if (localObject1 != null) {
      flushThemedResourcesCache(localObject1);
    }
  }
  
  @RequiresApi(16)
  private static void flushThemedResourcesCache(@NonNull Object paramObject)
  {
    if (!sThemedResourceCacheClazzFetched)
    {
      try
      {
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", localClassNotFoundException);
      }
      sThemedResourceCacheClazzFetched = true;
    }
    Class localClass = sThemedResourceCacheClazz;
    if (localClass == null) {
      return;
    }
    if (!sThemedResourceCache_mUnthemedEntriesFieldFetched)
    {
      try
      {
        sThemedResourceCache_mUnthemedEntriesField = localClass.getDeclaredField("mUnthemedEntries");
        sThemedResourceCache_mUnthemedEntriesField.setAccessible(true);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", localNoSuchFieldException);
      }
      sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    }
    Field localField = sThemedResourceCache_mUnthemedEntriesField;
    if (localField == null) {
      return;
    }
    try
    {
      paramObject = (LongSparseArray)localField.get(paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", paramObject);
      paramObject = null;
    }
    if (paramObject != null) {
      paramObject.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.ResourcesFlusher
 * JD-Core Version:    0.7.0.1
 */