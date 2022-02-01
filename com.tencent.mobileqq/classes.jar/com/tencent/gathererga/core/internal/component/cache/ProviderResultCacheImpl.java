package com.tencent.gathererga.core.internal.component.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.gathererga.core.internal.component.GathererCompContext;
import com.tencent.gathererga.core.internal.component.db.AbsSecureStorage;
import java.util.WeakHashMap;

public class ProviderResultCacheImpl
  extends AbsSecureStorage
  implements ProviderResultCache
{
  private SharedPreferences b;
  private WeakHashMap<Integer, Object> c = new WeakHashMap();
  
  protected SharedPreferences a()
  {
    return this.b;
  }
  
  public Object a(int paramInt)
  {
    return this.c.get(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    this.c.put(Integer.valueOf(paramInt), paramObject);
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      a(localStringBuilder.toString(), String.valueOf(paramObject));
    }
  }
  
  public void a(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("gatherer_provider", 0);
  }
  
  public Object b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return a(localStringBuilder.toString());
  }
  
  protected String b()
  {
    return GathererCompContext.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.cache.ProviderResultCacheImpl
 * JD-Core Version:    0.7.0.1
 */