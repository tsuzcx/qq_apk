package com.tencent.gathererga.core.internal;

import android.content.Context;
import com.tencent.gathererga.core.IExecutor;
import com.tencent.gathererga.core.ILog;
import com.tencent.gathererga.core.internal.component.GathererHTTP;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCache;
import com.tencent.gathererga.core.internal.component.cache.ProviderResultCacheImpl;
import java.util.Map;

public class GathererConfigInternal
{
  protected Context a;
  protected String b;
  protected Map<Integer, Boolean> c;
  protected int d;
  protected String e;
  protected GathererHTTP f;
  protected boolean g;
  protected IExecutor h;
  protected ProviderResultCache i;
  protected ILog j;
  protected String k;
  
  public Context a()
  {
    return this.a;
  }
  
  public void a(Map<Integer, Boolean> paramMap)
  {
    this.c = paramMap;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public Map<Integer, Boolean> c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String e()
  {
    return this.k;
  }
  
  public ProviderResultCache f()
  {
    ProviderResultCache localProviderResultCache = this.i;
    Object localObject = localProviderResultCache;
    if (localProviderResultCache == null) {
      localObject = new ProviderResultCacheImpl();
    }
    return localObject;
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public IExecutor h()
  {
    return this.h;
  }
  
  public ILog i()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.GathererConfigInternal
 * JD-Core Version:    0.7.0.1
 */