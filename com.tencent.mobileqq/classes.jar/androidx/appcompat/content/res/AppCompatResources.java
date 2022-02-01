package androidx.appcompat.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ColorStateListInflaterCompat;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class AppCompatResources
{
  private static final String LOG_TAG = "AppCompatResources";
  private static final ThreadLocal<TypedValue> TL_TYPED_VALUE = new ThreadLocal();
  private static final Object sColorStateCacheLock = new Object();
  private static final WeakHashMap<Context, SparseArray<AppCompatResources.ColorStateListCacheEntry>> sColorStateCaches = new WeakHashMap(0);
  
  private static void addColorStateListToCache(@NonNull Context paramContext, @ColorRes int paramInt, @NonNull ColorStateList paramColorStateList)
  {
    synchronized (sColorStateCacheLock)
    {
      SparseArray localSparseArray2 = (SparseArray)sColorStateCaches.get(paramContext);
      SparseArray localSparseArray1 = localSparseArray2;
      if (localSparseArray2 == null)
      {
        localSparseArray1 = new SparseArray();
        sColorStateCaches.put(paramContext, localSparseArray1);
      }
      localSparseArray1.append(paramInt, new AppCompatResources.ColorStateListCacheEntry(paramColorStateList, paramContext.getResources().getConfiguration()));
      return;
    }
  }
  
  @Nullable
  private static ColorStateList getCachedColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    synchronized (sColorStateCacheLock)
    {
      SparseArray localSparseArray = (SparseArray)sColorStateCaches.get(paramContext);
      if ((localSparseArray != null) && (localSparseArray.size() > 0))
      {
        AppCompatResources.ColorStateListCacheEntry localColorStateListCacheEntry = (AppCompatResources.ColorStateListCacheEntry)localSparseArray.get(paramInt);
        if (localColorStateListCacheEntry != null)
        {
          if (localColorStateListCacheEntry.configuration.equals(paramContext.getResources().getConfiguration()))
          {
            paramContext = localColorStateListCacheEntry.value;
            return paramContext;
          }
          localSparseArray.remove(paramInt);
        }
      }
      return null;
    }
  }
  
  public static ColorStateList getColorStateList(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramContext.getColorStateList(paramInt);
    }
    ColorStateList localColorStateList = getCachedColorStateList(paramContext, paramInt);
    if (localColorStateList != null) {
      return localColorStateList;
    }
    localColorStateList = inflateColorStateList(paramContext, paramInt);
    if (localColorStateList != null)
    {
      addColorStateListToCache(paramContext, paramInt, localColorStateList);
      return localColorStateList;
    }
    return ContextCompat.getColorStateList(paramContext, paramInt);
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull Context paramContext, @DrawableRes int paramInt)
  {
    return ResourceManagerInternal.get().getDrawable(paramContext, paramInt);
  }
  
  @NonNull
  private static TypedValue getTypedValue()
  {
    TypedValue localTypedValue2 = (TypedValue)TL_TYPED_VALUE.get();
    TypedValue localTypedValue1 = localTypedValue2;
    if (localTypedValue2 == null)
    {
      localTypedValue1 = new TypedValue();
      TL_TYPED_VALUE.set(localTypedValue1);
    }
    return localTypedValue1;
  }
  
  @Nullable
  private static ColorStateList inflateColorStateList(Context paramContext, int paramInt)
  {
    if (isColorInt(paramContext, paramInt)) {
      return null;
    }
    Resources localResources = paramContext.getResources();
    XmlResourceParser localXmlResourceParser = localResources.getXml(paramInt);
    try
    {
      paramContext = ColorStateListInflaterCompat.createFromXml(localResources, localXmlResourceParser, paramContext.getTheme());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", paramContext);
    }
    return null;
  }
  
  private static boolean isColorInt(@NonNull Context paramContext, @ColorRes int paramInt)
  {
    paramContext = paramContext.getResources();
    TypedValue localTypedValue = getTypedValue();
    paramContext.getValue(paramInt, localTypedValue, true);
    return (localTypedValue.type >= 28) && (localTypedValue.type <= 31);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.content.res.AppCompatResources
 * JD-Core Version:    0.7.0.1
 */