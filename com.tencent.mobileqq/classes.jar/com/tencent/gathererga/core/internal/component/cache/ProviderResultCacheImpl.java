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
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private WeakHashMap<Integer, Object> jdField_a_of_type_JavaUtilWeakHashMap = new WeakHashMap();
  
  protected SharedPreferences a()
  {
    return this.jdField_a_of_type_AndroidContentSharedPreferences;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilWeakHashMap.get(Integer.valueOf(paramInt));
  }
  
  protected String a()
  {
    return GathererCompContext.a.a();
  }
  
  public void a(int paramInt, Object paramObject, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilWeakHashMap.put(Integer.valueOf(paramInt), paramObject);
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
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramContext.getSharedPreferences("gatherer_provider", 0);
  }
  
  public Object b(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    return a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.cache.ProviderResultCacheImpl
 * JD-Core Version:    0.7.0.1
 */