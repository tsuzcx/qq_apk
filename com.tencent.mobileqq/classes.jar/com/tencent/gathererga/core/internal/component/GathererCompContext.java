package com.tencent.gathererga.core.internal.component;

import android.content.Context;
import com.tencent.gathererga.core.internal.BaseContext;
import com.tencent.gathererga.core.internal.GathererConfigInternal;
import com.tencent.gathererga.core.internal.IBase;
import com.tencent.gathererga.core.internal.component.cache.CloudConfigDB;
import com.tencent.gathererga.core.internal.component.cache.CouldConfigDBImpl;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.util.GLog;
import java.lang.ref.WeakReference;

public class GathererCompContext
  extends BaseContext
{
  public static final GathererCompContext a = new GathererCompContext();
  private WeakReference<Context> b;
  private String c;
  private ProviderResultCache d;
  
  public static <T> void a(Class<T> paramClass, Class<?> paramClass1)
  {
    a.b(paramClass, paramClass1);
  }
  
  protected Object a(Class<?> paramClass, Object paramObject)
  {
    paramClass = this.b;
    if ((paramClass != null) && (paramClass.get() != null))
    {
      ((IBase)paramObject).a((Context)this.b.get());
      return paramObject;
    }
    return null;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public void a(GathererConfigInternal paramGathererConfigInternal)
  {
    this.b = new WeakReference(paramGathererConfigInternal.a());
    this.c = paramGathererConfigInternal.e();
    GLog.a(paramGathererConfigInternal.i());
    this.d = paramGathererConfigInternal.f();
    this.d.a(paramGathererConfigInternal.a());
    a(CloudConfigDB.class, CouldConfigDBImpl.class);
  }
  
  public ProviderResultCache c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.component.GathererCompContext
 * JD-Core Version:    0.7.0.1
 */