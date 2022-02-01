package com.tencent.component.utils.preference;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

class OptimizedSharedPreferencesWrapper
  extends SharedPreferencesWrapper
{
  private static final Object mContent = new Object();
  private SharedPreferences.OnSharedPreferenceChangeListener mInnerListener;
  private final String mKeyPrefix;
  private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap();
  private final boolean mOptimize;
  
  public OptimizedSharedPreferencesWrapper(SharedPreferences paramSharedPreferences, String paramString, boolean paramBoolean)
  {
    super(paramSharedPreferences, new OptimizedSharedPreferencesWrapper.1(paramString));
    this.mKeyPrefix = paramString;
    this.mOptimize = paramBoolean;
  }
  
  private static String generateKey(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (paramString2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(paramString2);
      return localStringBuilder.toString();
    }
    paramString2 = new StringBuilder();
    paramString2.append("null key is not supported when contains key prefix ");
    paramString2.append(paramString1);
    throw new RuntimeException(paramString2.toString());
  }
  
  private static boolean isGeneratedKey(String paramString1, String paramString2)
  {
    return (TextUtils.isEmpty(paramString1)) || ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(paramString1)));
  }
  
  private void notifyListeners(String paramString)
  {
    synchronized (this.mListeners)
    {
      Object localObject1;
      if (!this.mListeners.isEmpty())
      {
        localObject1 = new HashSet(this.mListeners.keySet());
      }
      else
      {
        unregisterInnerListenerIfNeedLocked();
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        localObject1 = ((Collection)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          ??? = (SharedPreferences.OnSharedPreferenceChangeListener)((Iterator)localObject1).next();
          if (??? != null) {
            ((SharedPreferences.OnSharedPreferenceChangeListener)???).onSharedPreferenceChanged(this, paramString);
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private static String rGenerateKey(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith(paramString1))) {
      return paramString2.substring(paramString1.length());
    }
    return null;
  }
  
  private void registerInnerListenerIfNeedLocked()
  {
    if (this.mInnerListener == null)
    {
      this.mInnerListener = new OptimizedSharedPreferencesWrapper.2(this);
      getWrappedSharedPreferences().registerOnSharedPreferenceChangeListener(this.mInnerListener);
    }
  }
  
  private void unregisterInnerListenerIfNeedLocked()
  {
    if (this.mInnerListener != null)
    {
      getWrappedSharedPreferences().unregisterOnSharedPreferenceChangeListener(this.mInnerListener);
      this.mInnerListener = null;
    }
  }
  
  public SharedPreferences.Editor edit()
  {
    SharedPreferences.Editor localEditor = super.edit();
    if (localEditor != null) {
      return new OptimizedSharedPreferencesWrapper.OptimizedEditorWrapper(this, localEditor);
    }
    return null;
  }
  
  public Map<String, ?> getAll()
  {
    Object localObject2 = super.getAll();
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(this.mKeyPrefix))
    {
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!((Map)localObject2).isEmpty())
        {
          localObject1 = new HashMap();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
            String str = rGenerateKey(this.mKeyPrefix, (String)localEntry.getKey());
            if ((str != null) || (TextUtils.isEmpty(this.mKeyPrefix))) {
              ((Map)localObject1).put(str, localEntry.getValue());
            }
          }
        }
      }
    }
    return localObject1;
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    synchronized (this.mListeners)
    {
      if (this.mListeners.isEmpty()) {
        registerInnerListenerIfNeedLocked();
      }
      this.mListeners.put(paramOnSharedPreferenceChangeListener, mContent);
      return;
    }
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    synchronized (this.mListeners)
    {
      this.mListeners.remove(paramOnSharedPreferenceChangeListener);
      if (this.mListeners.isEmpty()) {
        unregisterInnerListenerIfNeedLocked();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.utils.preference.OptimizedSharedPreferencesWrapper
 * JD-Core Version:    0.7.0.1
 */